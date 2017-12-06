package com.medical.po;

import java.util.ArrayList;
import java.util.List;

public class HosplevelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HosplevelExample() {
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

        public Criteria andHosplevelidIsNull() {
            addCriterion("hospLevelId is null");
            return (Criteria) this;
        }

        public Criteria andHosplevelidIsNotNull() {
            addCriterion("hospLevelId is not null");
            return (Criteria) this;
        }

        public Criteria andHosplevelidEqualTo(Integer value) {
            addCriterion("hospLevelId =", value, "hosplevelid");
            return (Criteria) this;
        }

        public Criteria andHosplevelidNotEqualTo(Integer value) {
            addCriterion("hospLevelId <>", value, "hosplevelid");
            return (Criteria) this;
        }

        public Criteria andHosplevelidGreaterThan(Integer value) {
            addCriterion("hospLevelId >", value, "hosplevelid");
            return (Criteria) this;
        }

        public Criteria andHosplevelidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hospLevelId >=", value, "hosplevelid");
            return (Criteria) this;
        }

        public Criteria andHosplevelidLessThan(Integer value) {
            addCriterion("hospLevelId <", value, "hosplevelid");
            return (Criteria) this;
        }

        public Criteria andHosplevelidLessThanOrEqualTo(Integer value) {
            addCriterion("hospLevelId <=", value, "hosplevelid");
            return (Criteria) this;
        }

        public Criteria andHosplevelidIn(List<Integer> values) {
            addCriterion("hospLevelId in", values, "hosplevelid");
            return (Criteria) this;
        }

        public Criteria andHosplevelidNotIn(List<Integer> values) {
            addCriterion("hospLevelId not in", values, "hosplevelid");
            return (Criteria) this;
        }

        public Criteria andHosplevelidBetween(Integer value1, Integer value2) {
            addCriterion("hospLevelId between", value1, value2, "hosplevelid");
            return (Criteria) this;
        }

        public Criteria andHosplevelidNotBetween(Integer value1, Integer value2) {
            addCriterion("hospLevelId not between", value1, value2, "hosplevelid");
            return (Criteria) this;
        }

        public Criteria andHosplevelnameIsNull() {
            addCriterion("hospLevelName is null");
            return (Criteria) this;
        }

        public Criteria andHosplevelnameIsNotNull() {
            addCriterion("hospLevelName is not null");
            return (Criteria) this;
        }

        public Criteria andHosplevelnameEqualTo(String value) {
            addCriterion("hospLevelName =", value, "hosplevelname");
            return (Criteria) this;
        }

        public Criteria andHosplevelnameNotEqualTo(String value) {
            addCriterion("hospLevelName <>", value, "hosplevelname");
            return (Criteria) this;
        }

        public Criteria andHosplevelnameGreaterThan(String value) {
            addCriterion("hospLevelName >", value, "hosplevelname");
            return (Criteria) this;
        }

        public Criteria andHosplevelnameGreaterThanOrEqualTo(String value) {
            addCriterion("hospLevelName >=", value, "hosplevelname");
            return (Criteria) this;
        }

        public Criteria andHosplevelnameLessThan(String value) {
            addCriterion("hospLevelName <", value, "hosplevelname");
            return (Criteria) this;
        }

        public Criteria andHosplevelnameLessThanOrEqualTo(String value) {
            addCriterion("hospLevelName <=", value, "hosplevelname");
            return (Criteria) this;
        }

        public Criteria andHosplevelnameLike(String value) {
            addCriterion("hospLevelName like", value, "hosplevelname");
            return (Criteria) this;
        }

        public Criteria andHosplevelnameNotLike(String value) {
            addCriterion("hospLevelName not like", value, "hosplevelname");
            return (Criteria) this;
        }

        public Criteria andHosplevelnameIn(List<String> values) {
            addCriterion("hospLevelName in", values, "hosplevelname");
            return (Criteria) this;
        }

        public Criteria andHosplevelnameNotIn(List<String> values) {
            addCriterion("hospLevelName not in", values, "hosplevelname");
            return (Criteria) this;
        }

        public Criteria andHosplevelnameBetween(String value1, String value2) {
            addCriterion("hospLevelName between", value1, value2, "hosplevelname");
            return (Criteria) this;
        }

        public Criteria andHosplevelnameNotBetween(String value1, String value2) {
            addCriterion("hospLevelName not between", value1, value2, "hosplevelname");
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