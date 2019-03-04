package ds.service;

import ds.common.pojo.Result;
import ds.pojo.Expert;

import java.util.Map;

public interface ExpertService {
    public Result getExpertsList();
    public Result updateExpertById(Expert expert);
    public Result searchExpert(Expert expert,Boolean priceUpper);
    public Result deleteExpertById(Long id);
}
