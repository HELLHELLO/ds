package ds.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ds.common.pojo.DataGridResult;
import ds.mapper.UserMapper;
import ds.pageHelperTools.GetSelectResult;
import ds.pojo.User;
import ds.pojo.UserExample;
import ds.service.UserListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserListServiceImpl implements UserListService {
    @Autowired
    private UserMapper userMapper;

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
        return result;
    }


    //可能有SQL注入，到时候检查一下
    @Override
    public Map getUserByUserName(String name) {
        Map result=new HashMap();
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUsernameLike(name);
        criteria.andValuedEqualTo(true);
        try {
            List<User> resultList = userMapper.selectByExample(userExample);
            result.put("statu","success");
            result.put("code","0");
            result.put("message","search success");
            result.put("result",resultList);
            return result;
        }
        catch (Exception e){
            result.put("statu","failed");
            result.put("code","1");
            result.put("message","something wrong");
            return result;
        }
    }


    //该方法未测试
    @Override
    public Map updateUserById(User user) {
        Map result=new HashMap();
        if (user.getUserId()==null){    //如果未指定用户id，直接报错
            result.put("statu","failed");
            result.put("code","6");
            result.put("message","missing userId");
            return result;
        }

        try {
            //检查该用户是否存在
            UserExample userExample = new UserExample();
            userExample.createCriteria().andValuedEqualTo(true).andUserIdEqualTo(user.getUserId());
            long exist = userMapper.countByExample(userExample);//若不存在则报错
            if (exist == 0) {
                result.put("statu", "failed");
                result.put("code", "5");
                result.put("message", "user does not exist");
                return result;
            }
            user.setPassword(null);     //禁止修改用户的用户名与密码
            user.setUsername(null);
            user.setValued(null);       //该接口不实现删除功能
            user.setRole(null);         //该接口不能修改用户角色，由其他接口实现。

            int resultNum = userMapper.updateByExampleSelective(user, userExample);
            if (resultNum > 0) {
                result.put("statu", "success");
                result.put("code", "0");
                result.put("message", "update success");
                return result;
            } else {
                result.put("statu", "failed");
                result.put("code", "2");
                result.put("message", "failed to update");
                return result;
            }

        }
        catch (Exception e){
            result.put("statu","failed");
            result.put("code","6");
            result.put("message","something wrong");
            result.put("detail",e.getMessage());
            return result;
        }


    }

    @Override
    public Map deleteComuserUserById(Long id) {
        Map result=new HashMap();
        if (id==null){
            result.put("statu","failed");
            result.put("code","6");
            result.put("message","missing userId");
            return result;
        }
        User user=userMapper.selectByPrimaryKey(id);
        if(user==null){
            result.put("statu","failed");
            result.put("code","5");
            result.put("message","target does not exist");
            return result;
        }
        if (!user.getRole().equals("cosumer")){
            result.put("statu","failed");
            result.put("code","7");
            result.put("message","the user is not a cosumer");
            return result;
        }

        return null;
    }
}
