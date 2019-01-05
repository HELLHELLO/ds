package ds.service;

import ds.common.pojo.DataGridResult;

import ds.pojo.User;


import java.util.Map;

/**
 * 获取用户信息
 * 获取全部信息或根据id进行查询
 */
public interface UserListService {
    DataGridResult getUserById(long page,long rows,long id);
    Map getUserByUserName(String name);
    DataGridResult getUserList(long page,long rows);

    Map updateUserById(User user);
    Map deleteComuserUserById(Long id);

}
