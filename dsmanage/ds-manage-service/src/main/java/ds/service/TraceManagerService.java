package ds.service;

import ds.common.pojo.Result;
import ds.pojo.TraceAccess;
import ds.pojo.TraceManager;


public interface TraceManagerService {
    Result addTraceManager(TraceManager traceMng);
    Result delTraceManager(Long id);
    Result updateTraceManager(TraceManager traceMng);//更改溯源管理员基本信息，不涉及其权限信息
    Result getTraceManagerList(TraceManager traceMng);//根据指定信息查询对应溯源管理员列表

    Result addTraceAccess(TraceAccess traceAccess);//添加一条溯源管理权限信息
    Result delTraceAccess(Long id);
    Result updateTraceAccess(TraceAccess traceAccess);//更改该一条权限信息，不涉及溯源管理员基本信息
    Result getTraceAccessList(TraceAccess traceAccess);//根据指定信息查询对应的溯源管理权限信息

    Result getDetail(Long id);  //根据溯源管理员id查询其基本信息和权限信息
}
