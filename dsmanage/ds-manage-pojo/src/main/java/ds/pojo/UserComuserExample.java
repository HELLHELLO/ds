package ds.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserComuserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserComuserExample() {
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

        public Criteria andComuserIdIsNull() {
            addCriterion("comuser_id is null");
            return (Criteria) this;
        }

        public Criteria andComuserIdIsNotNull() {
            addCriterion("comuser_id is not null");
            return (Criteria) this;
        }

        public Criteria andComuserIdEqualTo(Long value) {
            addCriterion("comuser_id =", value, "comuserId");
            return (Criteria) this;
        }

        public Criteria andComuserIdNotEqualTo(Long value) {
            addCriterion("comuser_id <>", value, "comuserId");
            return (Criteria) this;
        }

        public Criteria andComuserIdGreaterThan(Long value) {
            addCriterion("comuser_id >", value, "comuserId");
            return (Criteria) this;
        }

        public Criteria andComuserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("comuser_id >=", value, "comuserId");
            return (Criteria) this;
        }

        public Criteria andComuserIdLessThan(Long value) {
            addCriterion("comuser_id <", value, "comuserId");
            return (Criteria) this;
        }

        public Criteria andComuserIdLessThanOrEqualTo(Long value) {
            addCriterion("comuser_id <=", value, "comuserId");
            return (Criteria) this;
        }

        public Criteria andComuserIdIn(List<Long> values) {
            addCriterion("comuser_id in", values, "comuserId");
            return (Criteria) this;
        }

        public Criteria andComuserIdNotIn(List<Long> values) {
            addCriterion("comuser_id not in", values, "comuserId");
            return (Criteria) this;
        }

        public Criteria andComuserIdBetween(Long value1, Long value2) {
            addCriterion("comuser_id between", value1, value2, "comuserId");
            return (Criteria) this;
        }

        public Criteria andComuserIdNotBetween(Long value1, Long value2) {
            addCriterion("comuser_id not between", value1, value2, "comuserId");
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
<<<<<<< HEAD

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
=======
>>>>>>> aaa
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