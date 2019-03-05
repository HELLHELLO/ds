package ds.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;
import ds.common.pojo.DataGridResult;
import ds.common.pojo.Result;
import ds.mapper.*;
import ds.pageHelperTools.GetSelectResult;
import ds.pojo.*;
import ds.service.UserListService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.SQLWarningException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.sql.SQLException;
import java.util.*;



@Service
public class UserListServiceImpl implements UserListService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserComuserMapper userComuserMapper;

    @Autowired
    private ConsultItemMapper consultItemMapper;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private UserAddressMapper userAddressMapper;

    //private enum userRoles{"cosumer", "marchant", "tracemng", "expert"};
    private static final HashSet<String> userRoles = new HashSet<String>() {{
        add("cosumer");
        add("marchant");
        add("tracemng");
        add("expert");
    }};


    @Override
    public DataGridResult getUserById(long page, long rows, long id) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUserIdEqualTo(id);
        criteria.andValuedEqualTo(true);
        DataGridResult result=new GetSelectResult<UserMapper,UserExample,User>((int)page,(int)rows,userMapper,userExample).getResult();//获取查询结果，因为pageHelper的大部分设置具有重复性所以我放到单独的类里做了

        List<User> users=(List<User>) result.getRows();
        for(User user:users){
            user.setPassword(null);
        }
        result.setRows(users);

        return result;
        /* PageHelper.startPage((int)page,(int)rows);
        List<User> list=userMapper.selectByExample(userExample);
        PageInfo<User> pageInfo=new PageInfo<User>(list);
        long total = pageInfo.getTotal();
        DataGridResult result = new DataGridResult(total,list);
        return result;*/
    }

    @Override
    public DataGridResult getUserList(long page, long rows) {
        UserExample userExample=new UserExample();
        userExample.createCriteria().andValuedEqualTo(true);
        DataGridResult result=new GetSelectResult<UserMapper,UserExample,User>((int)page,(int)rows,userMapper,userExample).getResult();

        List<User> users=(List<User>) result.getRows();
        for(User user:users){
            user.setPassword(null);
        }
        result.setRows(users);

        return result;
    }


    //可能有SQL注入，到时候检查一下
    @Override
    public Result getUserByUserName(String name) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUsernameLike(name);
        criteria.andValuedEqualTo(true);
        try {
            List<User> resultList = userMapper.selectByExample(userExample);

            for(User user:resultList){
                user.setPassword(null);
            }

            return new Result(Result.Status.success,"success",resultList);
        }
        catch (Exception e){
            return new Result(Result.Status.somethingWrong,"something wrong");
        }
    }



    //该方法未测试
    @Override
    public Result updateUserById(User user) {
        Map result=new HashMap();
        if (user.getUserId()==null){    //如果未指定用户id，直接报错
            return new Result(Result.Status.emptyParam,"empty userId");
        }

        try {
            //检查该用户是否存在
            UserExample userExample = new UserExample();
            userExample.createCriteria().andValuedEqualTo(true).andUserIdEqualTo(user.getUserId());
            long exist = userMapper.countByExample(userExample);//若不存在则报错
            if (exist == 0) {
                return new Result(Result.Status.somethingWrong,"user does not exist");
            }
            user.setPassword(null);     //禁止修改用户的用户名与密码
            user.setUsername(null);
            user.setValued(null);       //该接口不实现删除功能
            user.setRole(null);         //该接口不能修改用户角色，由其他接口实现。

            int resultNum = userMapper.updateByExampleSelective(user, userExample);
            if (resultNum > 0) {
                return new Result(Result.Status.success,"success");
            } else {
                return new Result(Result.Status.somethingWrong,"failed to update");
            }

        }
        catch (Exception e){
            return new Result(Result.Status.somethingWrong,e.getMessage());
        }


    }

    @Override
    public Result deleteComuserUserById(Long id){
        if (id==null){
            return new Result(Result.Status.emptyParam,"empty userId");
        }

            User user = userMapper.selectByPrimaryKey(id);
            if (user == null) {
                return new Result(Result.Status.somethingWrong,"target dose not exist");
            }
            if (!user.getRole().equals("cosumer")) {
                return new Result(Result.Status.somethingWrong,"the user is not a cosumer");
            }


            //检查该用户是否还有没完成的订单
            OrderExample orderExample = new OrderExample();
            OrderExample.Criteria criteria = orderExample.createCriteria();
            criteria.andUserIdEqualTo(id);
            criteria.andValuedEqualTo(true);
            List<Integer> closed = new ArrayList<Integer>();  //设置已完成订单的statu的可能取值
            closed.add(5);
            closed.add(6);
            criteria.andStatusNotIn(closed);        //设置查询未完成的订单
            long numOfNotFinishedOrder = orderMapper.countByExample(orderExample);
            if (numOfNotFinishedOrder != 0) {      //有未完成的订单，报错
                return new Result(Result.Status.somethingWrong,"the comuser has order unfinshed");
            }

            user.setValued(false);

            //设值user_comuser表的相应字段
            UserComuserExample userComuserExample = new UserComuserExample();
            userComuserExample.createCriteria().andUserIdEqualTo(id).andValuedEqualTo(true);
            //List<UserComuser> userComusers = userComuserMapper.selectByExample(userComuserExample);
            //for (UserComuser userComuser : userComusers) {
            //    userComuser.setValued(false);
            //}

            //设置相应的咨询单信息
            ConsultItemExample consultItemExample=new ConsultItemExample();
            consultItemExample.createCriteria().andUserIdEqualTo(id).andValuedEqualTo(true);
            //List<ConsultItem> consultItems=consultItemMapper.selectByExample(consultItemExample);

            //设置相应购物车信息
            CartExample cartExample=new CartExample();
            cartExample.createCriteria().andUserIdEqualTo(id).andValuedEqualTo(true);

            //设置相应的地址信息
            UserAddressExample userAddressExample=new UserAddressExample();
            userAddressExample.createCriteria().andUserIdEqualTo(id).andValuedEqualTo(true);

            //删除这些信息
            User userDel=new User();
            userDel.setValued(false);
            userDel.setUserId(id);

            UserComuser userComuserDel=new UserComuser();
            userComuserDel.setValued(false);

            ConsultItemWithBLOBs consultItemDel=new ConsultItemWithBLOBs();
            consultItemDel.setValued(false);

            Cart cartDel=new Cart();
            cartDel.setValued(false);

            UserAddress userAddressDel=new UserAddress();
            userAddressDel.setValued(false);

            userMapper.updateByPrimaryKeySelective(userDel);
            userComuserMapper.updateByExampleSelective(userComuserDel,userComuserExample);
            consultItemMapper.updateByExampleSelective(consultItemDel,consultItemExample);
            cartMapper.updateByExampleSelective(cartDel,cartExample);
            userAddressMapper.updateByExampleSelective(userAddressDel,userAddressExample);


            return new Result(Result.Status.success,"success");

    }

}
