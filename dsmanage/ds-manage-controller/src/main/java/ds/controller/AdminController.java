package ds.controller;

import ds.common.pojo.Result;
import ds.pojo.Admin;
import ds.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/add")
    @ResponseBody
    public Result addAdmin(Admin admin) throws Exception{
        return adminService.addAdmin(admin);
    }

    @RequestMapping("/del")
    @ResponseBody
    public Result delAdmin(@RequestParam(value = "id",required = false) Long id){
        return adminService.delAdmin(id);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result updateAdmin(Admin admin) throws Exception{
        return adminService.updateAdmin(admin);
    }

    @RequestMapping("/search")
    @ResponseBody
    public Result searchAdmin(Admin admin){
        return adminService.searchAdmin(admin);
    }
}
