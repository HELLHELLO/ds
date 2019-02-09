package ds.service.impl;

import ds.common.pojo.Result;

import ds.mapper.TraceAccessMapper;
import ds.mapper.TraceManagerMapper;
import ds.pojo.TraceManager;
import ds.service.TraceManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraceManagerServiceImpl implements TraceManagerService {
    @Autowired
    private TraceManagerMapper traceManagerMapper;

    @Autowired
    private TraceAccessMapper traceAccessMapper;

    @Override
    public Result addTraceManager(TraceManager traceMng) {
        traceMng.setMngId(null);
        if(traceMng.getLoginName()==null||traceMng.getLoginPassword()==null||traceMng.getMngName()==null){
            return new Result(Result.Status.emptyParam,"empty param");
        }
        traceMng.setCreated(null);
        traceMng.setUpdated(null);
        traceMng.setValued(true);
        traceManagerMapper.insertSelective(traceMng);
        return new Result(Result.Status.success,"created mng success");
    }
}
