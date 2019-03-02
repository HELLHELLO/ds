package ds.controller;

import ds.common.pojo.Result;
import ds.pojo.TraceAccess;
import ds.pojo.TraceManager;
import ds.service.TraceManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/trace")
public class TraceManageController {
    @Autowired
    private TraceManagerService traceManagerService;

    @RequestMapping(value = "/mng/add",method = RequestMethod.POST)
    @ResponseBody
    public Result addTraceManager(TraceManager traceManager){
        return traceManagerService.addTraceManager(traceManager);
    }

    @RequestMapping(value = "/mng/del",method = RequestMethod.GET)
    @ResponseBody
    public Result delTraceManager(@RequestParam(value = "id",required = false) Long id){
        return traceManagerService.delTraceManager(id);
    }

    @RequestMapping(value = "/mng/update",method = RequestMethod.POST)
    @ResponseBody
    public Result updateTraceManager(TraceManager traceManager){
        return traceManagerService.updateTraceManager(traceManager);
    }

    @RequestMapping(value = "/mng/list",method = RequestMethod.GET)
    @ResponseBody
    public Result getTraceMngList(TraceManager traceManager){
        return traceManagerService.getTraceManagerList(traceManager);
    }

    @RequestMapping(value = "/access/add",method = RequestMethod.POST)
    @ResponseBody
    public Result addTraceAccess(TraceAccess traceAccess){
        return traceManagerService.addTraceAccess(traceAccess);
    }

    @RequestMapping(value = "/access/del",method = RequestMethod.GET)
    @ResponseBody
    public Result delTraceAccess(@RequestParam(value = "id",required = false) Long id){
        return traceManagerService.delTraceAccess(id);
    }

    @RequestMapping(value = "/access/update",method = RequestMethod.POST)
    @ResponseBody
    public Result updateTraceAccess(TraceAccess traceAccess){
        return traceManagerService.updateTraceAccess(traceAccess);
    }

    @RequestMapping(value = "/access/list",method = RequestMethod.POST)
    @ResponseBody
    public Result getTraceAccessList(TraceAccess traceAccess){
        return traceManagerService.getTraceAccessList(traceAccess);
    }

    @RequestMapping(value = "/mng/detail",method = RequestMethod.GET)
    @ResponseBody
    public Result getDetail(@RequestParam(value = "id",required = false) Long id){
        return traceManagerService.getDetail(id);
    }
}
