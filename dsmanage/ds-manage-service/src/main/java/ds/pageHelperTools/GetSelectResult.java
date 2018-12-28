package ds.pageHelperTools;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ds.common.pojo.DataGridResult;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class GetSelectResult<M,E,D> {
    private int page;
    private int rows;
    private M mapper;
    private E example;
    public GetSelectResult(int page,int rows,M useMapper,E useExample){
        this.page=page;
        this.rows=rows;
        this.mapper=useMapper;
        this.example=useExample;
    }
    public DataGridResult getResult(){
        PageHelper.startPage(page,rows);
        Class mapperClass=mapper.getClass();
        Method selectByExample;
        Object list;
        Class returnType;
        try {
            selectByExample = mapperClass.getMethod("selectByExample", example.getClass());
            list =  selectByExample.invoke(mapper, example);
        }
        catch (Exception v){
            return null;
        }
        PageInfo<D> pageInfo=new PageInfo<D>((List<D>) list);
        long total=pageInfo.getTotal();
        DataGridResult result = new DataGridResult(total,(List<D>)list);
        return result;
    }
    //public DataGridResult getResult();
}
