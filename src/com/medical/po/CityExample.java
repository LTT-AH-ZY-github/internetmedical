package com.medical.po;

import java.util.ArrayList;
import java.util.List;

public class CityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CityExample() {
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

        public Criteria andCitycodeIsNull() {
            addCriterion("cityCode is null");
            return (Criteria) this;
        }

        public Criteria andCitycodeIsNotNull() {
            addCriterion("cityCode is not null");
            return (Criteria) this;
        }

        public Criteria andCitycodeEqualTo(String value) {
            addCriterion("cityCode =", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeNotEqualTo(String value) {
            addCriterion("cityCode <>", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeGreaterThan(String value) {
            addCriterion("cityCode >", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeGreaterThanOrEqualTo(String value) {
            addCriterion("cityCode >=", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeLessThan(String value) {
            addCriterion("cityCode <", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeLessThanOrEqualTo(String value) {
            addCriterion("cityCode <=", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeLike(String value) {
            addCriterion("cityCode like", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeNotLike(String value) {
            addCriterion("cityCode not like", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeIn(List<String> values) {
            addCriterion("cityCode in", values, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeNotIn(List<String> values) {
            addCriterion("cityCode not in", values, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeBetween(String value1, String value2) {
            addCriterion("cityCode between", value1, value2, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeNotBetween(String value1, String value2) {
            addCriterion("cityCode not between", value1, value2, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitynameIsNull() {
            addCriterion("cityName is null");
            return (Criteria) this;
        }

        public Criteria andCitynameIsNotNull() {
            addCriterion("cityName is not null");
            return (Criteria) this;
        }

        public Criteria andCitynameEqualTo(String value) {
            addCriterion("cityName =", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotEqualTo(String value) {
            addCriterion("cityName <>", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameGreaterThan(String value) {
            addCriterion("cityName >", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameGreaterThanOrEqualTo(String value) {
            addCriterion("cityName >=", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameLessThan(String value) {
            addCriterion("cityName <", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameLessThanOrEqualTo(String value) {
            addCriterion("cityName <=", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameLike(String value) {
            addCriterion("cityName like", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotLike(String value) {
            addCriterion("cityName not like", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameIn(List<String> values) {
            addCriterion("cityName in", values, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotIn(List<String> values) {
            addCriterion("cityName not in", values, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameBetween(String value1, String value2) {
            addCriterion("cityName between", value1, value2, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotBetween(String value1, String value2) {
            addCriterion("cityName not between", value1, value2, "cityname");
            return (Criteria) this;
        }

        public Criteria andCityparentcodeIsNull() {
            addCriterion("cityParentCode is null");
            return (Criteria) this;
        }

        public Criteria andCityparentcodeIsNotNull() {
            addCriterion("cityParentCode is not null");
            return (Criteria) this;
        }

        public Criteria andCityparentcodeEqualTo(String value) {
            addCriterion("cityParentCode =", value, "cityparentcode");
            return (Criteria) this;
        }

        public Criteria andCityparentcodeNotEqualTo(String value) {
            addCriterion("cityParentCode <>", value, "cityparentcode");
            return (Criteria) this;
        }

        public Criteria andCityparentcodeGreaterThan(String value) {
            addCriterion("cityParentCode >", value, "cityparentcode");
            return (Criteria) this;
        }

        public Criteria andCityparentcodeGreaterThanOrEqualTo(String value) {
            addCriterion("cityParentCode >=", value, "cityparentcode");
            return (Criteria) this;
        }

        public Criteria andCityparentcodeLessThan(String value) {
            addCriterion("cityParentCode <", value, "cityparentcode");
            return (Criteria) this;
        }

        public Criteria andCityparentcodeLessThanOrEqualTo(String value) {
            addCriterion("cityParentCode <=", value, "cityparentcode");
            return (Criteria) this;
        }

        public Criteria andCityparentcodeLike(String value) {
            addCriterion("cityParentCode like", value, "cityparentcode");
            return (Criteria) this;
        }

        public Criteria andCityparentcodeNotLike(String value) {
            addCriterion("cityParentCode not like", value, "cityparentcode");
            return (Criteria) this;
        }

        public Criteria andCityparentcodeIn(List<String> values) {
            addCriterion("cityParentCode in", values, "cityparentcode");
            return (Criteria) this;
        }

        public Criteria andCityparentcodeNotIn(List<String> values) {
            addCriterion("cityParentCode not in", values, "cityparentcode");
            return (Criteria) this;
        }

        public Criteria andCityparentcodeBetween(String value1, String value2) {
            addCriterion("cityParentCode between", value1, value2, "cityparentcode");
            return (Criteria) this;
        }

        public Criteria andCityparentcodeNotBetween(String value1, String value2) {
            addCriterion("cityParentCode not between", value1, value2, "cityparentcode");
            return (Criteria) this;
        }

        public Criteria andCitylevelIsNull() {
            addCriterion("cityLevel is null");
            return (Criteria) this;
        }

        public Criteria andCitylevelIsNotNull() {
            addCriterion("cityLevel is not null");
            return (Criteria) this;
        }

        public Criteria andCitylevelEqualTo(Integer value) {
            addCriterion("cityLevel =", value, "citylevel");
            return (Criteria) this;
        }

        public Criteria andCitylevelNotEqualTo(Integer value) {
            addCriterion("cityLevel <>", value, "citylevel");
            return (Criteria) this;
        }

        public Criteria andCitylevelGreaterThan(Integer value) {
            addCriterion("cityLevel >", value, "citylevel");
            return (Criteria) this;
        }

        public Criteria andCitylevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("cityLevel >=", value, "citylevel");
            return (Criteria) this;
        }

        public Criteria andCitylevelLessThan(Integer value) {
            addCriterion("cityLevel <", value, "citylevel");
            return (Criteria) this;
        }

        public Criteria andCitylevelLessThanOrEqualTo(Integer value) {
            addCriterion("cityLevel <=", value, "citylevel");
            return (Criteria) this;
        }

        public Criteria andCitylevelIn(List<Integer> values) {
            addCriterion("cityLevel in", values, "citylevel");
            return (Criteria) this;
        }

        public Criteria andCitylevelNotIn(List<Integer> values) {
            addCriterion("cityLevel not in", values, "citylevel");
            return (Criteria) this;
        }

        public Criteria andCitylevelBetween(Integer value1, Integer value2) {
            addCriterion("cityLevel between", value1, value2, "citylevel");
            return (Criteria) this;
        }

        public Criteria andCitylevelNotBetween(Integer value1, Integer value2) {
            addCriterion("cityLevel not between", value1, value2, "citylevel");
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