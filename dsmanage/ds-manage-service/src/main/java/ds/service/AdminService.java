package ds.service;

import ds.common.pojo.Result;
import ds.pojo.Admin;

public interface AdminService {
    public Result addAdmin(Admin admin);
    public Result delAdmin(Long id);//根据管理员id删除管理员
    public Result updateAdmin(Admin admin);//更新管理员信息
    public Result searchAdmin(Admin admin);//查找管理员
}
