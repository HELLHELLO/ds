package ds.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemPicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ItemPicExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andPicIdIsNull() {
            addCriterion("pic_id is null");
            return (Criteria) this;
        }

        public Criteria andPicIdIsNotNull() {
            addCriterion("pic_id is not null");
            return (Criteria) this;
        }

        public Criteria andPicIdEqualTo(Long value) {
            addCriterion("pic_id =", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdNotEqualTo(Long value) {
            addCriterion("pic_id <>", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdGreaterThan(Long value) {
            addCriterion("pic_id >", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pic_id >=", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdLessThan(Long value) {
            addCriterion("pic_id <", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdLessThanOrEqualTo(Long value) {
            addCriterion("pic_id <=", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdIn(List<Long> values) {
            addCriterion("pic_id in", values, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdNotIn(List<Long> values) {
            addCriterion("pic_id not in", values, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdBetween(Long value1, Long value2) {
            addCriterion("pic_id between", value1, value2, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdNotBetween(Long value1, Long value2) {
            addCriterion("pic_id not between", value1, value2, "picId");
            return (Criteria) this;
        }

        public Criteria andItemsIdIsNull() {
            addCriterion("items_id is null");
            return (Criteria) this;
        }

        public Criteria andItemsIdIsNotNull() {
            addCriterion("items_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemsIdEqualTo(Long value) {
            addCriterion("items_id =", value, "itemsId");
            return (Criteria) this;
        }

        public Criteria andItemsIdNotEqualTo(Long value) {
            addCriterion("items_id <>", value, "itemsId");
            return (Criteria) this;
        }

        public Criteria andItemsIdGreaterThan(Long value) {
            addCriterion("items_id >", value, "itemsId");
            return (Criteria) this;
        }

        public Criteria andItemsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("items_id >=", value, "itemsId");
            return (Criteria) this;
        }

        public Criteria andItemsIdLessThan(Long value) {
            addCriterion("items_id <", value, "itemsId");
            return (Criteria) this;
        }

        public Criteria andItemsIdLessThanOrEqualTo(Long value) {
            addCriterion("items_id <=", value, "itemsId");
            return (Criteria) this;
        }

        public Criteria andItemsIdIn(List<Long> values) {
            addCriterion("items_id in", values, "itemsId");
            return (Criteria) this;
        }

        public Criteria andItemsIdNotIn(List<Long> values) {
            addCriterion("items_id not in", values, "itemsId");
            return (Criteria) this;
        }

        public Criteria andItemsIdBetween(Long value1, Long value2) {
            addCriterion("items_id between", value1, value2, "itemsId");
            return (Criteria) this;
        }

        public Criteria andItemsIdNotBetween(Long value1, Long value2) {
            addCriterion("items_id not between", value1, value2, "itemsId");
            return (Criteria) this;
        }

        public Criteria andPicDecIsNull() {
            addCriterion("pic_dec is null");
            return (Criteria) this;
        }

        public Criteria andPicDecIsNotNull() {
            addCriterion("pic_dec is not null");
            return (Criteria) this;
        }

        public Criteria andPicDecEqualTo(String value) {
            addCriterion("pic_dec =", value, "picDec");
            return (Criteria) this;
        }

        public Criteria andPicDecNotEqualTo(String value) {
            addCriterion("pic_dec <>", value, "picDec");
            return (Criteria) this;
        }

        public Criteria andPicDecGreaterThan(String value) {
            addCriterion("pic_dec >", value, "picDec");
            return (Criteria) this;
        }

        public Criteria andPicDecGreaterThanOrEqualTo(String value) {
            addCriterion("pic_dec >=", value, "picDec");
            return (Criteria) this;
        }

        public Criteria andPicDecLessThan(String value) {
            addCriterion("pic_dec <", value, "picDec");
            return (Criteria) this;
        }

        public Criteria andPicDecLessThanOrEqualTo(String value) {
            addCriterion("pic_dec <=", value, "picDec");
            return (Criteria) this;
        }

        public Criteria andPicDecLike(String value) {
            addCriterion("pic_dec like", value, "picDec");
            return (Criteria) this;
        }

        public Criteria andPicDecNotLike(String value) {
            addCriterion("pic_dec not like", value, "picDec");
            return (Criteria) this;
        }

        public Criteria andPicDecIn(List<String> values) {
            addCriterion("pic_dec in", values, "picDec");
            return (Criteria) this;
        }

        public Criteria andPicDecNotIn(List<String> values) {
            addCriterion("pic_dec not in", values, "picDec");
            return (Criteria) this;
        }

        public Criteria andPicDecBetween(String value1, String value2) {
            addCriterion("pic_dec between", value1, value2, "picDec");
            return (Criteria) this;
        }

        public Criteria andPicDecNotBetween(String value1, String value2) {
            addCriterion("pic_dec not between", value1, value2, "picDec");
            return (Criteria) this;
        }

        public Criteria andPicUrlIsNull() {
            addCriterion("pic_url is null");
            return (Criteria) this;
        }

        public Criteria andPicUrlIsNotNull() {
            addCriterion("pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andPicUrlEqualTo(String value) {
            addCriterion("pic_url =", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotEqualTo(String value) {
            addCriterion("pic_url <>", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlGreaterThan(String value) {
            addCriterion("pic_url >", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("pic_url >=", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLessThan(String value) {
            addCriterion("pic_url <", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLessThanOrEqualTo(String value) {
            addCriterion("pic_url <=", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLike(String value) {
            addCriterion("pic_url like", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotLike(String value) {
            addCriterion("pic_url not like", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlIn(List<String> values) {
            addCriterion("pic_url in", values, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotIn(List<String> values) {
            addCriterion("pic_url not in", values, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlBetween(String value1, String value2) {
            addCriterion("pic_url between", value1, value2, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotBetween(String value1, String value2) {
            addCriterion("pic_url not between", value1, value2, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicStatuIsNull() {
            addCriterion("pic_statu is null");
            return (Criteria) this;
        }

        public Criteria andPicStatuIsNotNull() {
            addCriterion("pic_statu is not null");
            return (Criteria) this;
        }

        public Criteria andPicStatuEqualTo(Boolean value) {
            addCriterion("pic_statu =", value, "picStatu");
            return (Criteria) this;
        }

        public Criteria andPicStatuNotEqualTo(Boolean value) {
            addCriterion("pic_statu <>", value, "picStatu");
            return (Criteria) this;
        }

        public Criteria andPicStatuGreaterThan(Boolean value) {
            addCriterion("pic_statu >", value, "picStatu");
            return (Criteria) this;
        }

        public Criteria andPicStatuGreaterThanOrEqualTo(Boolean value) {
            addCriterion("pic_statu >=", value, "picStatu");
            return (Criteria) this;
        }

        public Criteria andPicStatuLessThan(Boolean value) {
            addCriterion("pic_statu <", value, "picStatu");
            return (Criteria) this;
        }

        public Criteria andPicStatuLessThanOrEqualTo(Boolean value) {
            addCriterion("pic_statu <=", value, "picStatu");
            return (Criteria) this;
        }

        public Criteria andPicStatuIn(List<Boolean> values) {
            addCriterion("pic_statu in", values, "picStatu");
            return (Criteria) this;
        }

        public Criteria andPicStatuNotIn(List<Boolean> values) {
            addCriterion("pic_statu not in", values, "picStatu");
            return (Criteria) this;
        }

        public Criteria andPicStatuBetween(Boolean value1, Boolean value2) {
            addCriterion("pic_statu between", value1, value2, "picStatu");
            return (Criteria) this;
        }

        public Criteria andPicStatuNotBetween(Boolean value1, Boolean value2) {
            addCriterion("pic_statu not between", value1, value2, "picStatu");
            return (Criteria) this;
        }

        public Criteria andPicMasterIsNull() {
            addCriterion("pic_master is null");
            return (Criteria) this;
        }

        public Criteria andPicMasterIsNotNull() {
            addCriterion("pic_master is not null");
            return (Criteria) this;
        }

        public Criteria andPicMasterEqualTo(Boolean value) {
            addCriterion("pic_master =", value, "picMaster");
            return (Criteria) this;
        }

        public Criteria andPicMasterNotEqualTo(Boolean value) {
            addCriterion("pic_master <>", value, "picMaster");
            return (Criteria) this;
        }

        public Criteria andPicMasterGreaterThan(Boolean value) {
            addCriterion("pic_master >", value, "picMaster");
            return (Criteria) this;
        }

        public Criteria andPicMasterGreaterThanOrEqualTo(Boolean value) {
            addCriterion("pic_master >=", value, "picMaster");
            return (Criteria) this;
        }

        public Criteria andPicMasterLessThan(Boolean value) {
            addCriterion("pic_master <", value, "picMaster");
            return (Criteria) this;
        }

        public Criteria andPicMasterLessThanOrEqualTo(Boolean value) {
            addCriterion("pic_master <=", value, "picMaster");
            return (Criteria) this;
        }

        public Criteria andPicMasterIn(List<Boolean> values) {
            addCriterion("pic_master in", values, "picMaster");
            return (Criteria) this;
        }

        public Criteria andPicMasterNotIn(List<Boolean> values) {
            addCriterion("pic_master not in", values, "picMaster");
            return (Criteria) this;
        }

        public Criteria andPicMasterBetween(Boolean value1, Boolean value2) {
            addCriterion("pic_master between", value1, value2, "picMaster");
            return (Criteria) this;
        }

        public Criteria andPicMasterNotBetween(Boolean value1, Boolean value2) {
            addCriterion("pic_master not between", value1, value2, "picMaster");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNull() {
            addCriterion("modified_time is null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNotNull() {
            addCriterion("modified_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeEqualTo(Date value) {
            addCriterion("modified_time =", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotEqualTo(Date value) {
            addCriterion("modified_time <>", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThan(Date value) {
            addCriterion("modified_time >", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modified_time >=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThan(Date value) {
            addCriterion("modified_time <", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThanOrEqualTo(Date value) {
            addCriterion("modified_time <=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIn(List<Date> values) {
            addCriterion("modified_time in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotIn(List<Date> values) {
            addCriterion("modified_time not in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeBetween(Date value1, Date value2) {
            addCriterion("modified_time between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotBetween(Date value1, Date value2) {
            addCriterion("modified_time not between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andValuedIsNull() {
            addCriterion("valued is null");
            return (Criteria) this;
        }

        public Criteria andValuedIsNotNull() {
            addCriterion("valued is not null");
            return (Criteria) this;
        }

        public Criteria andValuedEqualTo(Boolean value) {
            addCriterion("valued =", value, "valued");
            return (Criteria) this;
        }

        public Criteria andValuedNotEqualTo(Boolean value) {
            addCriterion("valued <>", value, "valued");
            return (Criteria) this;
        }

        public Criteria andValuedGreaterThan(Boolean value) {
            addCriterion("valued >", value, "valued");
            return (Criteria) this;
        }

        public Criteria andValuedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("valued >=", value, "valued");
            return (Criteria) this;
        }

        public Criteria andValuedLessThan(Boolean value) {
            addCriterion("valued <", value, "valued");
            return (Criteria) this;
        }

        public Criteria andValuedLessThanOrEqualTo(Boolean value) {
            addCriterion("valued <=", value, "valued");
            return (Criteria) this;
        }

        public Criteria andValuedIn(List<Boolean> values) {
            addCriterion("valued in", values, "valued");
            return (Criteria) this;
        }

        public Criteria andValuedNotIn(List<Boolean> values) {
            addCriterion("valued not in", values, "valued");
            return (Criteria) this;
        }

        public Criteria andValuedBetween(Boolean value1, Boolean value2) {
            addCriterion("valued between", value1, value2, "valued");
            return (Criteria) this;
        }

        public Criteria andValuedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("valued not between", value1, value2, "valued");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}