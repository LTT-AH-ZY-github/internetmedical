package com.medical.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HosptitaldepositExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HosptitaldepositExample() {
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

        public Criteria andHospdepositidIsNull() {
            addCriterion("hospDepositId is null");
            return (Criteria) this;
        }

        public Criteria andHospdepositidIsNotNull() {
            addCriterion("hospDepositId is not null");
            return (Criteria) this;
        }

        public Criteria andHospdepositidEqualTo(Integer value) {
            addCriterion("hospDepositId =", value, "hospdepositid");
            return (Criteria) this;
        }

        public Criteria andHospdepositidNotEqualTo(Integer value) {
            addCriterion("hospDepositId <>", value, "hospdepositid");
            return (Criteria) this;
        }

        public Criteria andHospdepositidGreaterThan(Integer value) {
            addCriterion("hospDepositId >", value, "hospdepositid");
            return (Criteria) this;
        }

        public Criteria andHospdepositidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hospDepositId >=", value, "hospdepositid");
            return (Criteria) this;
        }

        public Criteria andHospdepositidLessThan(Integer value) {
            addCriterion("hospDepositId <", value, "hospdepositid");
            return (Criteria) this;
        }

        public Criteria andHospdepositidLessThanOrEqualTo(Integer value) {
            addCriterion("hospDepositId <=", value, "hospdepositid");
            return (Criteria) this;
        }

        public Criteria andHospdepositidIn(List<Integer> values) {
            addCriterion("hospDepositId in", values, "hospdepositid");
            return (Criteria) this;
        }

        public Criteria andHospdepositidNotIn(List<Integer> values) {
            addCriterion("hospDepositId not in", values, "hospdepositid");
            return (Criteria) this;
        }

        public Criteria andHospdepositidBetween(Integer value1, Integer value2) {
            addCriterion("hospDepositId between", value1, value2, "hospdepositid");
            return (Criteria) this;
        }

        public Criteria andHospdepositidNotBetween(Integer value1, Integer value2) {
            addCriterion("hospDepositId not between", value1, value2, "hospdepositid");
            return (Criteria) this;
        }

        public Criteria andHospdepositnumIsNull() {
            addCriterion("hospDepositNum is null");
            return (Criteria) this;
        }

        public Criteria andHospdepositnumIsNotNull() {
            addCriterion("hospDepositNum is not null");
            return (Criteria) this;
        }

        public Criteria andHospdepositnumEqualTo(BigDecimal value) {
            addCriterion("hospDepositNum =", value, "hospdepositnum");
            return (Criteria) this;
        }

        public Criteria andHospdepositnumNotEqualTo(BigDecimal value) {
            addCriterion("hospDepositNum <>", value, "hospdepositnum");
            return (Criteria) this;
        }

        public Criteria andHospdepositnumGreaterThan(BigDecimal value) {
            addCriterion("hospDepositNum >", value, "hospdepositnum");
            return (Criteria) this;
        }

        public Criteria andHospdepositnumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hospDepositNum >=", value, "hospdepositnum");
            return (Criteria) this;
        }

        public Criteria andHospdepositnumLessThan(BigDecimal value) {
            addCriterion("hospDepositNum <", value, "hospdepositnum");
            return (Criteria) this;
        }

        public Criteria andHospdepositnumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hospDepositNum <=", value, "hospdepositnum");
            return (Criteria) this;
        }

        public Criteria andHospdepositnumIn(List<BigDecimal> values) {
            addCriterion("hospDepositNum in", values, "hospdepositnum");
            return (Criteria) this;
        }

        public Criteria andHospdepositnumNotIn(List<BigDecimal> values) {
            addCriterion("hospDepositNum not in", values, "hospdepositnum");
            return (Criteria) this;
        }

        public Criteria andHospdepositnumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hospDepositNum between", value1, value2, "hospdepositnum");
            return (Criteria) this;
        }

        public Criteria andHospdepositnumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hospDepositNum not between", value1, value2, "hospdepositnum");
            return (Criteria) this;
        }

        public Criteria andHospdepositremarkIsNull() {
            addCriterion("hospDepositRemark is null");
            return (Criteria) this;
        }

        public Criteria andHospdepositremarkIsNotNull() {
            addCriterion("hospDepositRemark is not null");
            return (Criteria) this;
        }

        public Criteria andHospdepositremarkEqualTo(String value) {
            addCriterion("hospDepositRemark =", value, "hospdepositremark");
            return (Criteria) this;
        }

        public Criteria andHospdepositremarkNotEqualTo(String value) {
            addCriterion("hospDepositRemark <>", value, "hospdepositremark");
            return (Criteria) this;
        }

        public Criteria andHospdepositremarkGreaterThan(String value) {
            addCriterion("hospDepositRemark >", value, "hospdepositremark");
            return (Criteria) this;
        }

        public Criteria andHospdepositremarkGreaterThanOrEqualTo(String value) {
            addCriterion("hospDepositRemark >=", value, "hospdepositremark");
            return (Criteria) this;
        }

        public Criteria andHospdepositremarkLessThan(String value) {
            addCriterion("hospDepositRemark <", value, "hospdepositremark");
            return (Criteria) this;
        }

        public Criteria andHospdepositremarkLessThanOrEqualTo(String value) {
            addCriterion("hospDepositRemark <=", value, "hospdepositremark");
            return (Criteria) this;
        }

        public Criteria andHospdepositremarkLike(String value) {
            addCriterion("hospDepositRemark like", value, "hospdepositremark");
            return (Criteria) this;
        }

        public Criteria andHospdepositremarkNotLike(String value) {
            addCriterion("hospDepositRemark not like", value, "hospdepositremark");
            return (Criteria) this;
        }

        public Criteria andHospdepositremarkIn(List<String> values) {
            addCriterion("hospDepositRemark in", values, "hospdepositremark");
            return (Criteria) this;
        }

        public Criteria andHospdepositremarkNotIn(List<String> values) {
            addCriterion("hospDepositRemark not in", values, "hospdepositremark");
            return (Criteria) this;
        }

        public Criteria andHospdepositremarkBetween(String value1, String value2) {
            addCriterion("hospDepositRemark between", value1, value2, "hospdepositremark");
            return (Criteria) this;
        }

        public Criteria andHospdepositremarkNotBetween(String value1, String value2) {
            addCriterion("hospDepositRemark not between", value1, value2, "hospdepositremark");
            return (Criteria) this;
        }

        public Criteria andHospdeposittimeIsNull() {
            addCriterion("hospDepositTime is null");
            return (Criteria) this;
        }

        public Criteria andHospdeposittimeIsNotNull() {
            addCriterion("hospDepositTime is not null");
            return (Criteria) this;
        }

        public Criteria andHospdeposittimeEqualTo(Date value) {
            addCriterion("hospDepositTime =", value, "hospdeposittime");
            return (Criteria) this;
        }

        public Criteria andHospdeposittimeNotEqualTo(Date value) {
            addCriterion("hospDepositTime <>", value, "hospdeposittime");
            return (Criteria) this;
        }

        public Criteria andHospdeposittimeGreaterThan(Date value) {
            addCriterion("hospDepositTime >", value, "hospdeposittime");
            return (Criteria) this;
        }

        public Criteria andHospdeposittimeGreaterThanOrEqualTo(Date value) {
            addCriterion("hospDepositTime >=", value, "hospdeposittime");
            return (Criteria) this;
        }

        public Criteria andHospdeposittimeLessThan(Date value) {
            addCriterion("hospDepositTime <", value, "hospdeposittime");
            return (Criteria) this;
        }

        public Criteria andHospdeposittimeLessThanOrEqualTo(Date value) {
            addCriterion("hospDepositTime <=", value, "hospdeposittime");
            return (Criteria) this;
        }

        public Criteria andHospdeposittimeIn(List<Date> values) {
            addCriterion("hospDepositTime in", values, "hospdeposittime");
            return (Criteria) this;
        }

        public Criteria andHospdeposittimeNotIn(List<Date> values) {
            addCriterion("hospDepositTime not in", values, "hospdeposittime");
            return (Criteria) this;
        }

        public Criteria andHospdeposittimeBetween(Date value1, Date value2) {
            addCriterion("hospDepositTime between", value1, value2, "hospdeposittime");
            return (Criteria) this;
        }

        public Criteria andHospdeposittimeNotBetween(Date value1, Date value2) {
            addCriterion("hospDepositTime not between", value1, value2, "hospdeposittime");
            return (Criteria) this;
        }

        public Criteria andHosploginidIsNull() {
            addCriterion("hospLoginId is null");
            return (Criteria) this;
        }

        public Criteria andHosploginidIsNotNull() {
            addCriterion("hospLoginId is not null");
            return (Criteria) this;
        }

        public Criteria andHosploginidEqualTo(Integer value) {
            addCriterion("hospLoginId =", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidNotEqualTo(Integer value) {
            addCriterion("hospLoginId <>", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidGreaterThan(Integer value) {
            addCriterion("hospLoginId >", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hospLoginId >=", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidLessThan(Integer value) {
            addCriterion("hospLoginId <", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidLessThanOrEqualTo(Integer value) {
            addCriterion("hospLoginId <=", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidIn(List<Integer> values) {
            addCriterion("hospLoginId in", values, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidNotIn(List<Integer> values) {
            addCriterion("hospLoginId not in", values, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidBetween(Integer value1, Integer value2) {
            addCriterion("hospLoginId between", value1, value2, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidNotBetween(Integer value1, Integer value2) {
            addCriterion("hospLoginId not between", value1, value2, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andUserloginidIsNull() {
            addCriterion("userLoginId is null");
            return (Criteria) this;
        }

        public Criteria andUserloginidIsNotNull() {
            addCriterion("userLoginId is not null");
            return (Criteria) this;
        }

        public Criteria andUserloginidEqualTo(Integer value) {
            addCriterion("userLoginId =", value, "userloginid");
            return (Criteria) this;
        }

        public Criteria andUserloginidNotEqualTo(Integer value) {
            addCriterion("userLoginId <>", value, "userloginid");
            return (Criteria) this;
        }

        public Criteria andUserloginidGreaterThan(Integer value) {
            addCriterion("userLoginId >", value, "userloginid");
            return (Criteria) this;
        }

        public Criteria andUserloginidGreaterThanOrEqualTo(Integer value) {
            addCriterion("userLoginId >=", value, "userloginid");
            return (Criteria) this;
        }

        public Criteria andUserloginidLessThan(Integer value) {
            addCriterion("userLoginId <", value, "userloginid");
            return (Criteria) this;
        }

        public Criteria andUserloginidLessThanOrEqualTo(Integer value) {
            addCriterion("userLoginId <=", value, "userloginid");
            return (Criteria) this;
        }

        public Criteria andUserloginidIn(List<Integer> values) {
            addCriterion("userLoginId in", values, "userloginid");
            return (Criteria) this;
        }

        public Criteria andUserloginidNotIn(List<Integer> values) {
            addCriterion("userLoginId not in", values, "userloginid");
            return (Criteria) this;
        }

        public Criteria andUserloginidBetween(Integer value1, Integer value2) {
            addCriterion("userLoginId between", value1, value2, "userloginid");
            return (Criteria) this;
        }

        public Criteria andUserloginidNotBetween(Integer value1, Integer value2) {
            addCriterion("userLoginId not between", value1, value2, "userloginid");
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