package com.medical.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RefundrateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RefundrateExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDocfefundrateIsNull() {
            addCriterion("docFefundRate is null");
            return (Criteria) this;
        }

        public Criteria andDocfefundrateIsNotNull() {
            addCriterion("docFefundRate is not null");
            return (Criteria) this;
        }

        public Criteria andDocfefundrateEqualTo(BigDecimal value) {
            addCriterion("docFefundRate =", value, "docfefundrate");
            return (Criteria) this;
        }

        public Criteria andDocfefundrateNotEqualTo(BigDecimal value) {
            addCriterion("docFefundRate <>", value, "docfefundrate");
            return (Criteria) this;
        }

        public Criteria andDocfefundrateGreaterThan(BigDecimal value) {
            addCriterion("docFefundRate >", value, "docfefundrate");
            return (Criteria) this;
        }

        public Criteria andDocfefundrateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("docFefundRate >=", value, "docfefundrate");
            return (Criteria) this;
        }

        public Criteria andDocfefundrateLessThan(BigDecimal value) {
            addCriterion("docFefundRate <", value, "docfefundrate");
            return (Criteria) this;
        }

        public Criteria andDocfefundrateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("docFefundRate <=", value, "docfefundrate");
            return (Criteria) this;
        }

        public Criteria andDocfefundrateIn(List<BigDecimal> values) {
            addCriterion("docFefundRate in", values, "docfefundrate");
            return (Criteria) this;
        }

        public Criteria andDocfefundrateNotIn(List<BigDecimal> values) {
            addCriterion("docFefundRate not in", values, "docfefundrate");
            return (Criteria) this;
        }

        public Criteria andDocfefundrateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("docFefundRate between", value1, value2, "docfefundrate");
            return (Criteria) this;
        }

        public Criteria andDocfefundrateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("docFefundRate not between", value1, value2, "docfefundrate");
            return (Criteria) this;
        }

        public Criteria andHospfefundrateIsNull() {
            addCriterion("hospFefundRate is null");
            return (Criteria) this;
        }

        public Criteria andHospfefundrateIsNotNull() {
            addCriterion("hospFefundRate is not null");
            return (Criteria) this;
        }

        public Criteria andHospfefundrateEqualTo(BigDecimal value) {
            addCriterion("hospFefundRate =", value, "hospfefundrate");
            return (Criteria) this;
        }

        public Criteria andHospfefundrateNotEqualTo(BigDecimal value) {
            addCriterion("hospFefundRate <>", value, "hospfefundrate");
            return (Criteria) this;
        }

        public Criteria andHospfefundrateGreaterThan(BigDecimal value) {
            addCriterion("hospFefundRate >", value, "hospfefundrate");
            return (Criteria) this;
        }

        public Criteria andHospfefundrateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hospFefundRate >=", value, "hospfefundrate");
            return (Criteria) this;
        }

        public Criteria andHospfefundrateLessThan(BigDecimal value) {
            addCriterion("hospFefundRate <", value, "hospfefundrate");
            return (Criteria) this;
        }

        public Criteria andHospfefundrateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hospFefundRate <=", value, "hospfefundrate");
            return (Criteria) this;
        }

        public Criteria andHospfefundrateIn(List<BigDecimal> values) {
            addCriterion("hospFefundRate in", values, "hospfefundrate");
            return (Criteria) this;
        }

        public Criteria andHospfefundrateNotIn(List<BigDecimal> values) {
            addCriterion("hospFefundRate not in", values, "hospfefundrate");
            return (Criteria) this;
        }

        public Criteria andHospfefundrateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hospFefundRate between", value1, value2, "hospfefundrate");
            return (Criteria) this;
        }

        public Criteria andHospfefundrateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hospFefundRate not between", value1, value2, "hospfefundrate");
            return (Criteria) this;
        }

        public Criteria andAdminloginidIsNull() {
            addCriterion("adminLoginId is null");
            return (Criteria) this;
        }

        public Criteria andAdminloginidIsNotNull() {
            addCriterion("adminLoginId is not null");
            return (Criteria) this;
        }

        public Criteria andAdminloginidEqualTo(Integer value) {
            addCriterion("adminLoginId =", value, "adminloginid");
            return (Criteria) this;
        }

        public Criteria andAdminloginidNotEqualTo(Integer value) {
            addCriterion("adminLoginId <>", value, "adminloginid");
            return (Criteria) this;
        }

        public Criteria andAdminloginidGreaterThan(Integer value) {
            addCriterion("adminLoginId >", value, "adminloginid");
            return (Criteria) this;
        }

        public Criteria andAdminloginidGreaterThanOrEqualTo(Integer value) {
            addCriterion("adminLoginId >=", value, "adminloginid");
            return (Criteria) this;
        }

        public Criteria andAdminloginidLessThan(Integer value) {
            addCriterion("adminLoginId <", value, "adminloginid");
            return (Criteria) this;
        }

        public Criteria andAdminloginidLessThanOrEqualTo(Integer value) {
            addCriterion("adminLoginId <=", value, "adminloginid");
            return (Criteria) this;
        }

        public Criteria andAdminloginidIn(List<Integer> values) {
            addCriterion("adminLoginId in", values, "adminloginid");
            return (Criteria) this;
        }

        public Criteria andAdminloginidNotIn(List<Integer> values) {
            addCriterion("adminLoginId not in", values, "adminloginid");
            return (Criteria) this;
        }

        public Criteria andAdminloginidBetween(Integer value1, Integer value2) {
            addCriterion("adminLoginId between", value1, value2, "adminloginid");
            return (Criteria) this;
        }

        public Criteria andAdminloginidNotBetween(Integer value1, Integer value2) {
            addCriterion("adminLoginId not between", value1, value2, "adminloginid");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
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