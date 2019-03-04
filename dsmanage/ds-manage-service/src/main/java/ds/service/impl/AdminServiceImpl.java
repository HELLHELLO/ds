package ds.service.impl;

import ds.common.pojo.Result;
import ds.mapper.AdminMapper;
import ds.pojo.Admin;
import ds.pojo.AdminExample;
import ds.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Result addAdmin(Admin admin) {
        if (admin.getAdminName()==null||admin.getAdminPassword()==null){
            return new Result(Result.Status.emptyParam,"empty name or password");
        }
        admin.setAdminId(null);
        admin.setValued(null);
        Integer num=adminMapper.insertSelective(admin);
        if (num==0){
            return new Result(Result.Status.somethingWrong,"insert fail");
        }
        return new Result(Result.Status.success,"success");
    }

    @Override
    public Result delAdmin(Long id) {
        if (id==null){
            return new Result(Result.Status.emptyParam,"empty id");
        }
        Admin admin=new Admin();
        admin.setValued(false);
        admin.setAdminId(id);
        Integer num=adminMapper.updateByPrimaryKeySelective(admin);
        if (num==0){
            return new Result(Result.Status.somethingWrong,"del fail");
        }
        return new Result(Result.Status.success,"success");
    }

    @Override
    public Result updateAdmin(Admin admin) {
        if (admin.getAdminId()==null){
            return new Result(Result.Status.emptyParam,"empty id");
        }
        admin.setValued(null);
        Integer num=adminMapper.updateByPrimaryKeySelective(admin);
        if (num==0){
            return new Result(Result.Status.somethingWrong,"update fail");
        }
        return new Result(Result.Status.success,"success");
    }

    @Override
    public Result searchAdmin(Admin admin) {
        AdminExample adminExample=new AdminExample();
        AdminExample.Criteria criteria=adminExample.createCriteria();
        if (admin.getAdminId()!=null){
            criteria.andAdminIdEqualTo(admin.getAdminId());
        }
        if (admin.getAdminName()!=null){
            criteria.andAdminNameLike(admin.getAdminName());
        }
        List<Admin> list=adminMapper.selectByExample(adminExample);
        return new Result(Result.Status.success,"success",list);
    }
}
