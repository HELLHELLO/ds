package ds.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CartExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CartExample() {
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

        public Criteria andCartIdIsNull() {
            addCriterion("cart_id is null");
            return (Criteria) this;
        }

        public Criteria andCartIdIsNotNull() {
            addCriterion("cart_id is not null");
            return (Criteria) this;
        }

        public Criteria andCartIdEqualTo(Long value) {
            addCriterion("cart_id =", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdNotEqualTo(Long value) {
            addCriterion("cart_id <>", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdGreaterThan(Long value) {
            addCriterion("cart_id >", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cart_id >=", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdLessThan(Long value) {
            addCriterion("cart_id <", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdLessThanOrEqualTo(Long value) {
            addCriterion("cart_id <=", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdIn(List<Long> values) {
            addCriterion("cart_id in", values, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdNotIn(List<Long> values) {
            addCriterion("cart_id not in", values, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdBetween(Long value1, Long value2) {
            addCriterion("cart_id between", value1, value2, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdNotBetween(Long value1, Long value2) {
            addCriterion("cart_id not between", value1, value2, "cartId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(Long value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(Long value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(Long value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(Long value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(Long value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(Long value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<Long> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<Long> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(Long value1, Long value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(Long value1, Long value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemNumIsNull() {
            addCriterion("item_num is null");
            return (Criteria) this;
        }

        public Criteria andItemNumIsNotNull() {
            addCriterion("item_num is not null");
            return (Criteria) this;
        }

        public Criteria andItemNumEqualTo(Integer value) {
            addCriterion("item_num =", value, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumNotEqualTo(Integer value) {
            addCriterion("item_num <>", value, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumGreaterThan(Integer value) {
            addCriterion("item_num >", value, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_num >=", value, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumLessThan(Integer value) {
            addCriterion("item_num <", value, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumLessThanOrEqualTo(Integer value) {
            addCriterion("item_num <=", value, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumIn(List<Integer> values) {
            addCriterion("item_num in", values, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumNotIn(List<Integer> values) {
            addCriterion("item_num not in", values, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumBetween(Integer value1, Integer value2) {
            addCriterion("item_num between", value1, value2, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumNotBetween(Integer value1, Integer value2) {
            addCriterion("item_num not between", value1, value2, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemUpdateTimeIsNull() {
            addCriterion("item_update_time is null");
            return (Criteria) this;
        }

        public Criteria andItemUpdateTimeIsNotNull() {
            addCriterion("item_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andItemUpdateTimeEqualTo(Date value) {
            addCriterion("item_update_time =", value, "itemUpdateTime");
            return (Criteria) this;
        }

        public Criteria andItemUpdateTimeNotEqualTo(Date value) {
            addCriterion("item_update_time <>", value, "itemUpdateTime");
            return (Criteria) this;
        }

        public Criteria andItemUpdateTimeGreaterThan(Date value) {
            addCriterion("item_update_time >", value, "itemUpdateTime");
            return (Criteria) this;
        }

        public Criteria andItemUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("item_update_time >=", value, "itemUpdateTime");
            return (Criteria) this;
        }

        public Criteria andItemUpdateTimeLessThan(Date value) {
            addCriterion("item_update_time <", value, "itemUpdateTime");
            return (Criteria) this;
        }

        public Criteria andItemUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("item_update_time <=", value, "itemUpdateTime");
            return (Criteria) this;
        }

        public Criteria andItemUpdateTimeIn(List<Date> values) {
            addCriterion("item_update_time in", values, "itemUpdateTime");
            return (Criteria) this;
        }

        public Criteria andItemUpdateTimeNotIn(List<Date> values) {
            addCriterion("item_update_time not in", values, "itemUpdateTime");
            return (Criteria) this;
        }

        public Criteria andItemUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("item_update_time between", value1, value2, "itemUpdateTime");
            return (Criteria) this;
        }

        public Criteria andItemUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("item_update_time not between", value1, value2, "itemUpdateTime");
            return (Criteria) this;
        }

        public Criteria andItemStatuIsNull() {
            addCriterion("item_statu is null");
            return (Criteria) this;
        }

        public Criteria andItemStatuIsNotNull() {
            addCriterion("item_statu is not null");
            return (Criteria) this;
        }

        public Criteria andItemStatuEqualTo(Byte value) {
            addCriterion("item_statu =", value, "itemStatu");
            return (Criteria) this;
        }

        public Criteria andItemStatuNotEqualTo(Byte value) {
            addCriterion("item_statu <>", value, "itemStatu");
            return (Criteria) this;
        }

        public Criteria andItemStatuGreaterThan(Byte value) {
            addCriterion("item_statu >", value, "itemStatu");
            return (Criteria) this;
        }

        public Criteria andItemStatuGreaterThanOrEqualTo(Byte value) {
            addCriterion("item_statu >=", value, "itemStatu");
            return (Criteria) this;
        }

        public Criteria andItemStatuLessThan(Byte value) {
            addCriterion("item_statu <", value, "itemStatu");
            return (Criteria) this;
        }

        public Criteria andItemStatuLessThanOrEqualTo(Byte value) {
            addCriterion("item_statu <=", value, "itemStatu");
            return (Criteria) this;
        }

        public Criteria andItemStatuIn(List<Byte> values) {
            addCriterion("item_statu in", values, "itemStatu");
            return (Criteria) this;
        }

        public Criteria andItemStatuNotIn(List<Byte> values) {
            addCriterion("item_statu not in", values, "itemStatu");
            return (Criteria) this;
        }

        public Criteria andItemStatuBetween(Byte value1, Byte value2) {
            addCriterion("item_statu between", value1, value2, "itemStatu");
            return (Criteria) this;
        }

        public Criteria andItemStatuNotBetween(Byte value1, Byte value2) {
            addCriterion("item_statu not between", value1, value2, "itemStatu");
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