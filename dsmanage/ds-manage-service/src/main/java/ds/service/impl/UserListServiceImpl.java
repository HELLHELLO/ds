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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserListServiceImpl implements UserListService {
    @Autowired
    private UserMapper userMapper;

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
}
