package ds.service;

import ds.common.pojo.DataGridResult;

/**
 * 获取用户信息
 * 获取全部信息或根据id进行查询
 */
public interface UserListService {
    DataGridResult getUserById(long page,long rows,long id);
    DataGridResult getUserList(long page,long rows);
}
