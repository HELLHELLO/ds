package ds.controller;

import ds.common.pojo.DataGridResult;
import ds.service.UserListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserListService userListService;

    @RequestMapping("/{id}")
    @ResponseBody
    public DataGridResult getUserById(@RequestParam(defaultValue = "1") Long page, @RequestParam(defaultValue = "30") Long rows, @PathVariable Long id){
        DataGridResult result=userListService.getUserById(page,rows,id);
        return result;
    }

    @RequestMapping("/list")
    @ResponseBody
    public DataGridResult getUserList(@RequestParam(defaultValue = "1") Long page, @RequestParam(defaultValue = "30") Long rows){
        DataGridResult result=userListService.getUserList(page,rows);
        return result;
    }
}
