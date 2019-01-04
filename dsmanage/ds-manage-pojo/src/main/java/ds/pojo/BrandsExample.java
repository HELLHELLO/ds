package ds.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BrandsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BrandsExample() {
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

        public Criteria andBrandIdIsNull() {
            addCriterion("brand_id is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNotNull() {
            addCriterion("brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdEqualTo(Long value) {
            addCriterion("brand_id =", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotEqualTo(Long value) {
            addCriterion("brand_id <>", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThan(Long value) {
            addCriterion("brand_id >", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThanOrEqualTo(Long value) {
            addCriterion("brand_id >=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThan(Long value) {
            addCriterion("brand_id <", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThanOrEqualTo(Long value) {
            addCriterion("brand_id <=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIn(List<Long> values) {
            addCriterion("brand_id in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotIn(List<Long> values) {
            addCriterion("brand_id not in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdBetween(Long value1, Long value2) {
            addCriterion("brand_id between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotBetween(Long value1, Long value2) {
            addCriterion("brand_id not between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNull() {
            addCriterion("brand_name is null");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNotNull() {
            addCriterion("brand_name is not null");
            return (Criteria) this;
        }

        public Criteria andBrandNameEqualTo(String value) {
            addCriterion("brand_name =", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotEqualTo(String value) {
            addCriterion("brand_name <>", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThan(String value) {
            addCriterion("brand_name >", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThanOrEqualTo(String value) {
            addCriterion("brand_name >=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThan(String value) {
            addCriterion("brand_name <", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThanOrEqualTo(String value) {
            addCriterion("brand_name <=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLike(String value) {
            addCriterion("brand_name like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotLike(String value) {
            addCriterion("brand_name not like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameIn(List<String> values) {
            addCriterion("brand_name in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotIn(List<String> values) {
            addCriterion("brand_name not in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameBetween(String value1, String value2) {
            addCriterion("brand_name between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotBetween(String value1, String value2) {
            addCriterion("brand_name not between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandImageIsNull() {
            addCriterion("brand_image is null");
            return (Criteria) this;
        }

        public Criteria andBrandImageIsNotNull() {
            addCriterion("brand_image is not null");
            return (Criteria) this;
        }

        public Criteria andBrandImageEqualTo(String value) {
            addCriterion("brand_image =", value, "brandImage");
            return (Criteria) this;
        }

        public Criteria andBrandImageNotEqualTo(String value) {
            addCriterion("brand_image <>", value, "brandImage");
            return (Criteria) this;
        }

        public Criteria andBrandImageGreaterThan(String value) {
            addCriterion("brand_image >", value, "brandImage");
            return (Criteria) this;
        }

        public Criteria andBrandImageGreaterThanOrEqualTo(String value) {
            addCriterion("brand_image >=", value, "brandImage");
            return (Criteria) this;
        }

        public Criteria andBrandImageLessThan(String value) {
            addCriterion("brand_image <", value, "brandImage");
            return (Criteria) this;
        }

        public Criteria andBrandImageLessThanOrEqualTo(String value) {
            addCriterion("brand_image <=", value, "brandImage");
            return (Criteria) this;
        }

        public Criteria andBrandImageLike(String value) {
            addCriterion("brand_image like", value, "brandImage");
            return (Criteria) this;
        }

        public Criteria andBrandImageNotLike(String value) {
            addCriterion("brand_image not like", value, "brandImage");
            return (Criteria) this;
        }

        public Criteria andBrandImageIn(List<String> values) {
            addCriterion("brand_image in", values, "brandImage");
            return (Criteria) this;
        }

        public Criteria andBrandImageNotIn(List<String> values) {
            addCriterion("brand_image not in", values, "brandImage");
            return (Criteria) this;
        }

        public Criteria andBrandImageBetween(String value1, String value2) {
            addCriterion("brand_image between", value1, value2, "brandImage");
            return (Criteria) this;
        }

        public Criteria andBrandImageNotBetween(String value1, String value2) {
            addCriterion("brand_image not between", value1, value2, "brandImage");
            return (Criteria) this;
        }

        public Criteria andBrandDecIsNull() {
            addCriterion("brand_dec is null");
            return (Criteria) this;
        }

        public Criteria andBrandDecIsNotNull() {
            addCriterion("brand_dec is not null");
            return (Criteria) this;
        }

        public Criteria andBrandDecEqualTo(String value) {
            addCriterion("brand_dec =", value, "brandDec");
            return (Criteria) this;
        }

        public Criteria andBrandDecNotEqualTo(String value) {
            addCriterion("brand_dec <>", value, "brandDec");
            return (Criteria) this;
        }

        public Criteria andBrandDecGreaterThan(String value) {
            addCriterion("brand_dec >", value, "brandDec");
            return (Criteria) this;
        }

        public Criteria andBrandDecGreaterThanOrEqualTo(String value) {
            addCriterion("brand_dec >=", value, "brandDec");
            return (Criteria) this;
        }

        public Criteria andBrandDecLessThan(String value) {
            addCriterion("brand_dec <", value, "brandDec");
            return (Criteria) this;
        }

        public Criteria andBrandDecLessThanOrEqualTo(String value) {
            addCriterion("brand_dec <=", value, "brandDec");
            return (Criteria) this;
        }

        public Criteria andBrandDecLike(String value) {
            addCriterion("brand_dec like", value, "brandDec");
            return (Criteria) this;
        }

        public Criteria andBrandDecNotLike(String value) {
            addCriterion("brand_dec not like", value, "brandDec");
            return (Criteria) this;
        }

        public Criteria andBrandDecIn(List<String> values) {
            addCriterion("brand_dec in", values, "brandDec");
            return (Criteria) this;
        }

        public Criteria andBrandDecNotIn(List<String> values) {
            addCriterion("brand_dec not in", values, "brandDec");
            return (Criteria) this;
        }

        public Criteria andBrandDecBetween(String value1, String value2) {
            addCriterion("brand_dec between", value1, value2, "brandDec");
            return (Criteria) this;
        }

        public Criteria andBrandDecNotBetween(String value1, String value2) {
            addCriterion("brand_dec not between", value1, value2, "brandDec");
            return (Criteria) this;
        }

        public Criteria andBrandUrlIsNull() {
            addCriterion("brand_url is null");
            return (Criteria) this;
        }

        public Criteria andBrandUrlIsNotNull() {
            addCriterion("brand_url is not null");
            return (Criteria) this;
        }

        public Criteria andBrandUrlEqualTo(String value) {
            addCriterion("brand_url =", value, "brandUrl");
            return (Criteria) this;
        }

        public Criteria andBrandUrlNotEqualTo(String value) {
            addCriterion("brand_url <>", value, "brandUrl");
            return (Criteria) this;
        }

        public Criteria andBrandUrlGreaterThan(String value) {
            addCriterion("brand_url >", value, "brandUrl");
            return (Criteria) this;
        }

        public Criteria andBrandUrlGreaterThanOrEqualTo(String value) {
            addCriterion("brand_url >=", value, "brandUrl");
            return (Criteria) this;
        }

        public Criteria andBrandUrlLessThan(String value) {
            addCriterion("brand_url <", value, "brandUrl");
            return (Criteria) this;
        }

        public Criteria andBrandUrlLessThanOrEqualTo(String value) {
            addCriterion("brand_url <=", value, "brandUrl");
            return (Criteria) this;
        }

        public Criteria andBrandUrlLike(String value) {
            addCriterion("brand_url like", value, "brandUrl");
            return (Criteria) this;
        }

        public Criteria andBrandUrlNotLike(String value) {
            addCriterion("brand_url not like", value, "brandUrl");
            return (Criteria) this;
        }

        public Criteria andBrandUrlIn(List<String> values) {
            addCriterion("brand_url in", values, "brandUrl");
            return (Criteria) this;
        }

        public Criteria andBrandUrlNotIn(List<String> values) {
            addCriterion("brand_url not in", values, "brandUrl");
            return (Criteria) this;
        }

        public Criteria andBrandUrlBetween(String value1, String value2) {
            addCriterion("brand_url between", value1, value2, "brandUrl");
            return (Criteria) this;
        }

        public Criteria andBrandUrlNotBetween(String value1, String value2) {
            addCriterion("brand_url not between", value1, value2, "brandUrl");
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

        public Criteria andUpdatedIsNull() {
            addCriterion("updated is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNotNull() {
            addCriterion("updated is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedEqualTo(Date value) {
            addCriterion("updated =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(Date value) {
            addCriterion("updated <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(Date value) {
            addCriterion("updated >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("updated >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(Date value) {
            addCriterion("updated <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("updated <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<Date> values) {
            addCriterion("updated in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<Date> values) {
            addCriterion("updated not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(Date value1, Date value2) {
            addCriterion("updated between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("updated not between", value1, value2, "updated");
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