package ds.service.impl;

import ds.common.pojo.Result;

import ds.mapper.TraceAccessMapper;
import ds.mapper.TraceManagerMapper;
import ds.pojo.TraceAccess;
import ds.pojo.TraceAccessExample;
import ds.pojo.TraceManager;
import ds.pojo.TraceManagerExample;
import ds.service.TraceManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public Result delTraceManager(Long id) {
        if (id==null){
            return new Result(Result.Status.emptyParam,"empty id");
        }
        //根据id删除相应溯源管理员
        TraceManager traceManager=new TraceManager();
        traceManager.setMngId(id);
        traceManager.setValued(false);
        Integer num=traceManagerMapper.updateByPrimaryKeySelective(traceManager);
        //如果没有任何行被修改，则该管理员不存在
        if (num==0){
            return new Result(Result.Status.somethingWrong,"no such a tracemng");
        }

        //同时删除相应的溯源管理权限
        TraceAccessExample traceAccessExample=new TraceAccessExample();
        TraceAccessExample.Criteria criteria=traceAccessExample.createCriteria();
        criteria.andTraceManagerIdEqualTo(id);
        TraceAccess traceAccess=new TraceAccess();
        traceAccess.setValued(false);
        traceAccessMapper.updateByExampleSelective(traceAccess,traceAccessExample);

        return new Result(Result.Status.success,"delete success");
    }

    @Override
    public Result updateTraceManager(TraceManager traceMng) {
        if (traceMng==null){
            return new Result(Result.Status.emptyParam,"empty mng");
        }else if (traceMng.getMngId()==null){
            return new Result(Result.Status.emptyParam,"MngId must be order");
        }
        if(traceMng.getLoginName()==null||traceMng.getLoginPassword()==null||traceMng.getMngName()==null){
            return new Result(Result.Status.emptyParam,"empty LoginName or LoginPassword or MngName");
        }
        traceMng.setCreated(null);
        traceMng.setUpdated(null);
        traceMng.setValued(null);

        Integer num=traceManagerMapper.updateByPrimaryKeySelective(traceMng);
        //检查是否有行被修改
        if (num==0){
            return new Result(Result.Status.somethingWrong,"no such a tracemng");
        }
        return new Result(Result.Status.success,"update mng success");
    }

    @Override
    public Result getTraceManagerList(TraceManager traceMng) {
        TraceManagerExample traceManagerExample=new TraceManagerExample();
        TraceManagerExample.Criteria criteria=traceManagerExample.createCriteria();
        criteria.andValuedEqualTo(true);
        //设置查询条件
        if (traceMng!=null){
            if (traceMng.getMngName()!=null){
                criteria.andMngNameLike(traceMng.getMngName());
            }
            if (traceMng.getLoginName()!=null){
                criteria.andLoginNameLike(traceMng.getLoginName());
            }
            if (traceMng.getPhone()!=null){
                criteria.andPhoneEqualTo(traceMng.getPhone());
            }
            if (traceMng.getEmail()!=null){
                criteria.andEmailEqualTo(traceMng.getEmail());
            }
            if(traceMng.getMngId()!=null){
                criteria.andMngIdEqualTo(traceMng.getMngId());
            }
        }


        List<TraceManager> list=traceManagerMapper.selectByExample(traceManagerExample);
        return new Result(Result.Status.success,"success",list);
    }

    @Override
    public Result addTraceAccess(TraceAccess traceAccess) {
        if(traceAccess==null){
            return new Result(Result.Status.emptyParam,"empty");
        }
        if (traceAccess.getTraceManagerId()==null){
            return new Result(Result.Status.emptyParam,"empty traceMng");
        }
        if (traceAccess.getShopId()==null&&traceAccess.getCid()==null){
            return new Result(Result.Status.emptyParam,"shopid or cid must be set");
        }
        traceAccess.setValued(true);
        traceAccess.setCreated(null);
        traceAccess.setUpdated(null);
        traceAccess.setTraceAccessId(null);

        //检查指定的溯源管理员是否存在
        TraceManager traceManager=traceManagerMapper.selectByPrimaryKey(traceAccess.getTraceManagerId());
        if (traceManager==null){
            return new Result(Result.Status.somethingWrong,"the mng do not exist");
        }

        traceAccessMapper.insertSelective(traceAccess);
        return new Result(Result.Status.success,"success");
    }

    @Override
    public Result delTraceAccess(Long id) {
        if (id==null){
            return new Result(Result.Status.emptyParam,"empty id");
        }

        TraceAccess traceAccess=new TraceAccess();
        traceAccess.setTraceAccessId(id);
        traceAccess.setValued(false);
        Integer num=traceAccessMapper.updateByPrimaryKeySelective(traceAccess);
        if(num==0){
            return new Result(Result.Status.somethingWrong,"no such a access");
        }
        return new Result(Result.Status.success,"delete success");
    }

    @Override
    public Result updateTraceAccess(TraceAccess traceAccess) {
        if(traceAccess==null){
            return new Result(Result.Status.emptyParam,"empty");
        }
        if (traceAccess.getTraceAccessId()==null){
            return new Result(Result.Status.emptyParam,"the accessId must be order");
        }
        if (traceAccess.getShopId()==null&&traceAccess.getCid()==null){
            return new Result(Result.Status.emptyParam,"shopid or cid must be set");
        }
        if (traceAccess.getTraceManagerId()==null){
            return new Result(Result.Status.emptyParam,"mngId is empty");
        }
        traceAccess.setValued(null);
        traceAccess.setCreated(null);
        traceAccess.setUpdated(null);

        //检查指定的溯源管理员是否存在
        TraceManager traceManager=traceManagerMapper.selectByPrimaryKey(traceAccess.getTraceManagerId());
        if (traceManager==null){
            return new Result(Result.Status.somethingWrong,"the mng do not exist");
        }

        Integer num=traceAccessMapper.updateByPrimaryKeySelective(traceAccess);
        if (num==0){
            return new Result(Result.Status.somethingWrong,"no such a access");
        }
        return new Result(Result.Status.success,"success");
    }

    @Override
    public Result getTraceAccessList(TraceAccess traceAccess) {
        if(traceAccess==null){
            return new Result(Result.Status.emptyParam,"empty");
        }

        TraceAccessExample traceAccessExample=new TraceAccessExample();
        TraceAccessExample.Criteria criteria=traceAccessExample.createCriteria();
        criteria.andValuedEqualTo(true);
        if (traceAccess.getShopId()!=null){
            criteria.andShopIdEqualTo(traceAccess.getShopId());
        }
        if (traceAccess.getCid()!=null){
            criteria.andCidEqualTo(traceAccess.getCid());
        }
        if (traceAccess.getTraceManagerId()!=null){
            criteria.andTraceManagerIdEqualTo(traceAccess.getTraceManagerId());
        }

        List<TraceAccess> list=traceAccessMapper.selectByExample(traceAccessExample);
        return new Result(Result.Status.success,"success",list);
    }

    @Override
    public Result getDetail(Long id) {
        if (id==null){
            return new Result(Result.Status.emptyParam,"empty id");
        }

        //查询权限信息
        TraceAccess traceAccess=new TraceAccess();
        traceAccess.setTraceManagerId(id);
        Result accessResult=getTraceAccessList(traceAccess);

        //查询基本信息
        TraceManager traceManager=traceManagerMapper.selectByPrimaryKey(id);
        if (traceManager==null){
            return new Result(Result.Status.somethingWrong,"the mng do not exist");
        }
        List list=new ArrayList<>();
        list.add(traceManager);
        list.add(accessResult.getList());
        return new Result(Result.Status.success,"success",list);
    }
}
