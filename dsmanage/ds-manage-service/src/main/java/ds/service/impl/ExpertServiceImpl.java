package ds.service.impl;

import ds.mapper.ConsultItemMapper;
import ds.mapper.ExpertMapper;
import ds.pojo.ConsultItem;
import ds.pojo.ConsultItemExample;
import ds.pojo.Expert;
import ds.pojo.ExpertExample;
import ds.service.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExpertServiceImpl implements ExpertService {
    @Autowired
    private ExpertMapper expertMapper;

    @Autowired
    private ConsultItemMapper consultItemMapper;

    @Override
    public Map getExpertsList() {
        Map result=new HashMap();
        ExpertExample expertExample=new ExpertExample();
        List<Expert> list=expertMapper.selectByExample(expertExample);
        result.put("statu","success");
        result.put("code","0");
        result.put("message","get list success");
        result.put("list",list);
        return result;
    }

    @Override
    public Map updateExpertById(Expert expert) {
        Map result=new HashMap();
        if (expert.getExpert()==null){
            result.put("statu","failed");
            result.put("code","6");
            result.put("message","missing ExpertId");
            return result;
        }

        //清空不能设置的字段
        expert.setValued(null);
        expert.setUserId(null);

        //更新数据库
        expertMapper.updateByPrimaryKeySelective(expert);
        result.put("statu","success");
        result.put("code","0");
        result.put("message","update success");
        return result;
    }

    @Override
    public Map searchExpert(Expert expert,Boolean priceUpper) {
        Map result=new HashMap();
        ExpertExample expertExample=new ExpertExample();
        ExpertExample.Criteria criteria=expertExample.createCriteria();
        criteria.andValuedEqualTo(true);

        //根据传入字段设置查询条件
        if (expert.getExpert()!=null){
            criteria.andExpertEqualTo(expert.getExpert());
        }
        if (expert.getCategory()!=null){
            criteria.andCategoryLike(expert.getCategory());
        }
        if (expert.getFee()!=null){
            //根据标志位设置大于或小于
            if (priceUpper){
                criteria.andFeeGreaterThanOrEqualTo(expert.getFee());
            }else {
                criteria.andFeeLessThanOrEqualTo(expert.getFee());
            }
        }
        if (expert.getName()!=null){
            criteria.andNameLike(expert.getName());
        }
        if (expert.getUserId()!=null){
            criteria.andUserIdEqualTo(expert.getUserId());
        }
        if (expert.getStatus()!=null){
            criteria.andStatusEqualTo(expert.getStatus());
        }

        List<Expert> list=expertMapper.selectByExample(expertExample);

        result.put("statu","success");
        result.put("code","0");
        result.put("message","search success");
        result.put("list",list);


        return result;
    }

    @Override
    public Map deleteExpertById(Long id) {
        Map result=new HashMap();
        if (id==null){
            result.put("statu","failed");
            result.put("code","6");
            result.put("message","missing ExpertId");
            return result;
        }

        //查询该专家是否仍有未完成的咨询单
        ConsultItemExample consultItemExample=new ConsultItemExample();
        consultItemExample.createCriteria().andValuedEqualTo(true).andStatusEqualTo(true);
        Long num=consultItemMapper.countByExample(consultItemExample);
        //若有没完成的咨询单则不能删除
        if (num>0){
            result.put("statu","failed");
            result.put("code","8");
            result.put("message","it has consult has not finished");
            return result;
        }else{
            //若没有未完成的咨询单，则删除
            Expert expert=new Expert();
            expert.setExpert(id);
            expert.setValued(false);
            expertMapper.updateByPrimaryKeySelective(expert);
            result.put("statu","success");
            result.put("code","0");
            result.put("message","delete success");
            return result;
        }
    }
}
