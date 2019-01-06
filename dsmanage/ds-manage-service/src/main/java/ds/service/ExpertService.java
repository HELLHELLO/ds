package ds.service;

import ds.pojo.Expert;

import java.util.Map;

public interface ExpertService {
    public Map getExpertsList();
    public Map updateExpertById(Expert expert);
    public Map searchExpert(Expert expert,Boolean priceUpper);
    public Map deleteExpertById(Long id);
}
