package ds.controller;

import ds.common.pojo.Result;
import ds.pojo.TraceManager;
import ds.service.TraceManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/trace")
public class TraceManageController {
    @Autowired
    private TraceManagerService traceManagerService;

    @RequestMapping(value = "/mng/add",method = RequestMethod.POST)
    public Result addTraceManager(TraceManager traceManager){
        return traceManagerService.addTraceManager(traceManager);
    }
}
