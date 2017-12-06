package com.medical.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DoctorpurseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DoctorpurseExample() {
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

        public Criteria andDocpurseidIsNull() {
            addCriterion("docPurseId is null");
            return (Criteria) this;
        }

        public Criteria andDocpurseidIsNotNull() {
            addCriterion("docPurseId is not null");
            return (Criteria) this;
        }

        public Criteria andDocpurseidEqualTo(Integer value) {
            addCriterion("docPurseId =", value, "docpurseid");
            return (Criteria) this;
        }

        public Criteria andDocpurseidNotEqualTo(Integer value) {
            addCriterion("docPurseId <>", value, "docpurseid");
            return (Criteria) this;
        }

        public Criteria andDocpurseidGreaterThan(Integer value) {
            addCriterion("docPurseId >", value, "docpurseid");
            return (Criteria) this;
        }

        public Criteria andDocpurseidGreaterThanOrEqualTo(Integer value) {
            addCriterion("docPurseId >=", value, "docpurseid");
            return (Criteria) this;
        }

        public Criteria andDocpurseidLessThan(Integer value) {
            addCriterion("docPurseId <", value, "docpurseid");
            return (Criteria) this;
        }

        public Criteria andDocpurseidLessThanOrEqualTo(Integer value) {
            addCriterion("docPurseId <=", value, "docpurseid");
            return (Criteria) this;
        }

        public Criteria andDocpurseidIn(List<Integer> values) {
            addCriterion("docPurseId in", values, "docpurseid");
            return (Criteria) this;
        }

        public Criteria andDocpurseidNotIn(List<Integer> values) {
            addCriterion("docPurseId not in", values, "docpurseid");
            return (Criteria) this;
        }

        public Criteria andDocpurseidBetween(Integer value1, Integer value2) {
            addCriterion("docPurseId between", value1, value2, "docpurseid");
            return (Criteria) this;
        }

        public Criteria andDocpurseidNotBetween(Integer value1, Integer value2) {
            addCriterion("docPurseId not between", value1, value2, "docpurseid");
            return (Criteria) this;
        }

        public Criteria andDocpursetypeidIsNull() {
            addCriterion("docPurseTypeId is null");
            return (Criteria) this;
        }

        public Criteria andDocpursetypeidIsNotNull() {
            addCriterion("docPurseTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andDocpursetypeidEqualTo(Integer value) {
            addCriterion("docPurseTypeId =", value, "docpursetypeid");
            return (Criteria) this;
        }

        public Criteria andDocpursetypeidNotEqualTo(Integer value) {
            addCriterion("docPurseTypeId <>", value, "docpursetypeid");
            return (Criteria) this;
        }

        public Criteria andDocpursetypeidGreaterThan(Integer value) {
            addCriterion("docPurseTypeId >", value, "docpursetypeid");
            return (Criteria) this;
        }

        public Criteria andDocpursetypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("docPurseTypeId >=", value, "docpursetypeid");
            return (Criteria) this;
        }

        public Criteria andDocpursetypeidLessThan(Integer value) {
            addCriterion("docPurseTypeId <", value, "docpursetypeid");
            return (Criteria) this;
        }

        public Criteria andDocpursetypeidLessThanOrEqualTo(Integer value) {
            addCriterion("docPurseTypeId <=", value, "docpursetypeid");
            return (Criteria) this;
        }

        public Criteria andDocpursetypeidIn(List<Integer> values) {
            addCriterion("docPurseTypeId in", values, "docpursetypeid");
            return (Criteria) this;
        }

        public Criteria andDocpursetypeidNotIn(List<Integer> values) {
            addCriterion("docPurseTypeId not in", values, "docpursetypeid");
            return (Criteria) this;
        }

        public Criteria andDocpursetypeidBetween(Integer value1, Integer value2) {
            addCriterion("docPurseTypeId between", value1, value2, "docpursetypeid");
            return (Criteria) this;
        }

        public Criteria andDocpursetypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("docPurseTypeId not between", value1, value2, "docpursetypeid");
            return (Criteria) this;
        }

        public Criteria andDocpurseamountIsNull() {
            addCriterion("docPurseAmount is null");
            return (Criteria) this;
        }

        public Criteria andDocpurseamountIsNotNull() {
            addCriterion("docPurseAmount is not null");
            return (Criteria) this;
        }

        public Criteria andDocpurseamountEqualTo(BigDecimal value) {
            addCriterion("docPurseAmount =", value, "docpurseamount");
            return (Criteria) this;
        }

        public Criteria andDocpurseamountNotEqualTo(BigDecimal value) {
            addCriterion("docPurseAmount <>", value, "docpurseamount");
            return (Criteria) this;
        }

        public Criteria andDocpurseamountGreaterThan(BigDecimal value) {
            addCriterion("docPurseAmount >", value, "docpurseamount");
            return (Criteria) this;
        }

        public Criteria andDocpurseamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("docPurseAmount >=", value, "docpurseamount");
            return (Criteria) this;
        }

        public Criteria andDocpurseamountLessThan(BigDecimal value) {
            addCriterion("docPurseAmount <", value, "docpurseamount");
            return (Criteria) this;
        }

        public Criteria andDocpurseamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("docPurseAmount <=", value, "docpurseamount");
            return (Criteria) this;
        }

        public Criteria andDocpurseamountIn(List<BigDecimal> values) {
            addCriterion("docPurseAmount in", values, "docpurseamount");
            return (Criteria) this;
        }

        public Criteria andDocpurseamountNotIn(List<BigDecimal> values) {
            addCriterion("docPurseAmount not in", values, "docpurseamount");
            return (Criteria) this;
        }

        public Criteria andDocpurseamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("docPurseAmount between", value1, value2, "docpurseamount");
            return (Criteria) this;
        }

        public Criteria andDocpurseamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("docPurseAmount not between", value1, value2, "docpurseamount");
            return (Criteria) this;
        }

        public Criteria andDocpursetimeIsNull() {
            addCriterion("docPurseTime is null");
            return (Criteria) this;
        }

        public Criteria andDocpursetimeIsNotNull() {
            addCriterion("docPurseTime is not null");
            return (Criteria) this;
        }

        public Criteria andDocpursetimeEqualTo(Date value) {
            addCriterion("docPurseTime =", value, "docpursetime");
            return (Criteria) this;
        }

        public Criteria andDocpursetimeNotEqualTo(Date value) {
            addCriterion("docPurseTime <>", value, "docpursetime");
            return (Criteria) this;
        }

        public Criteria andDocpursetimeGreaterThan(Date value) {
            addCriterion("docPurseTime >", value, "docpursetime");
            return (Criteria) this;
        }

        public Criteria andDocpursetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("docPurseTime >=", value, "docpursetime");
            return (Criteria) this;
        }

        public Criteria andDocpursetimeLessThan(Date value) {
            addCriterion("docPurseTime <", value, "docpursetime");
            return (Criteria) this;
        }

        public Criteria andDocpursetimeLessThanOrEqualTo(Date value) {
            addCriterion("docPurseTime <=", value, "docpursetime");
            return (Criteria) this;
        }

        public Criteria andDocpursetimeIn(List<Date> values) {
            addCriterion("docPurseTime in", values, "docpursetime");
            return (Criteria) this;
        }

        public Criteria andDocpursetimeNotIn(List<Date> values) {
            addCriterion("docPurseTime not in", values, "docpursetime");
            return (Criteria) this;
        }

        public Criteria andDocpursetimeBetween(Date value1, Date value2) {
            addCriterion("docPurseTime between", value1, value2, "docpursetime");
            return (Criteria) this;
        }

        public Criteria andDocpursetimeNotBetween(Date value1, Date value2) {
            addCriterion("docPurseTime not between", value1, value2, "docpursetime");
            return (Criteria) this;
        }

        public Criteria andDocpurseremarkIsNull() {
            addCriterion("docPurseRemark is null");
            return (Criteria) this;
        }

        public Criteria andDocpurseremarkIsNotNull() {
            addCriterion("docPurseRemark is not null");
            return (Criteria) this;
        }

        public Criteria andDocpurseremarkEqualTo(String value) {
            addCriterion("docPurseRemark =", value, "docpurseremark");
            return (Criteria) this;
        }

        public Criteria andDocpurseremarkNotEqualTo(String value) {
            addCriterion("docPurseRemark <>", value, "docpurseremark");
            return (Criteria) this;
        }

        public Criteria andDocpurseremarkGreaterThan(String value) {
            addCriterion("docPurseRemark >", value, "docpurseremark");
            return (Criteria) this;
        }

        public Criteria andDocpurseremarkGreaterThanOrEqualTo(String value) {
            addCriterion("docPurseRemark >=", value, "docpurseremark");
            return (Criteria) this;
        }

        public Criteria andDocpurseremarkLessThan(String value) {
            addCriterion("docPurseRemark <", value, "docpurseremark");
            return (Criteria) this;
        }

        public Criteria andDocpurseremarkLessThanOrEqualTo(String value) {
            addCriterion("docPurseRemark <=", value, "docpurseremark");
            return (Criteria) this;
        }

        public Criteria andDocpurseremarkLike(String value) {
            addCriterion("docPurseRemark like", value, "docpurseremark");
            return (Criteria) this;
        }

        public Criteria andDocpurseremarkNotLike(String value) {
            addCriterion("docPurseRemark not like", value, "docpurseremark");
            return (Criteria) this;
        }

        public Criteria andDocpurseremarkIn(List<String> values) {
            addCriterion("docPurseRemark in", values, "docpurseremark");
            return (Criteria) this;
        }

        public Criteria andDocpurseremarkNotIn(List<String> values) {
            addCriterion("docPurseRemark not in", values, "docpurseremark");
            return (Criteria) this;
        }

        public Criteria andDocpurseremarkBetween(String value1, String value2) {
            addCriterion("docPurseRemark between", value1, value2, "docpurseremark");
            return (Criteria) this;
        }

        public Criteria andDocpurseremarkNotBetween(String value1, String value2) {
            addCriterion("docPurseRemark not between", value1, value2, "docpurseremark");
            return (Criteria) this;
        }

        public Criteria andPayidIsNull() {
            addCriterion("payId is null");
            return (Criteria) this;
        }

        public Criteria andPayidIsNotNull() {
            addCriterion("payId is not null");
            return (Criteria) this;
        }

        public Criteria andPayidEqualTo(Integer value) {
            addCriterion("payId =", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidNotEqualTo(Integer value) {
            addCriterion("payId <>", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidGreaterThan(Integer value) {
            addCriterion("payId >", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidGreaterThanOrEqualTo(Integer value) {
            addCriterion("payId >=", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidLessThan(Integer value) {
            addCriterion("payId <", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidLessThanOrEqualTo(Integer value) {
            addCriterion("payId <=", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidIn(List<Integer> values) {
            addCriterion("payId in", values, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidNotIn(List<Integer> values) {
            addCriterion("payId not in", values, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidBetween(Integer value1, Integer value2) {
            addCriterion("payId between", value1, value2, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidNotBetween(Integer value1, Integer value2) {
            addCriterion("payId not between", value1, value2, "payid");
            return (Criteria) this;
        }

        public Criteria andDocpursebalanceIsNull() {
            addCriterion("docPurseBalance is null");
            return (Criteria) this;
        }

        public Criteria andDocpursebalanceIsNotNull() {
            addCriterion("docPurseBalance is not null");
            return (Criteria) this;
        }

        public Criteria andDocpursebalanceEqualTo(BigDecimal value) {
            addCriterion("docPurseBalance =", value, "docpursebalance");
            return (Criteria) this;
        }

        public Criteria andDocpursebalanceNotEqualTo(BigDecimal value) {
            addCriterion("docPurseBalance <>", value, "docpursebalance");
            return (Criteria) this;
        }

        public Criteria andDocpursebalanceGreaterThan(BigDecimal value) {
            addCriterion("docPurseBalance >", value, "docpursebalance");
            return (Criteria) this;
        }

        public Criteria andDocpursebalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("docPurseBalance >=", value, "docpursebalance");
            return (Criteria) this;
        }

        public Criteria andDocpursebalanceLessThan(BigDecimal value) {
            addCriterion("docPurseBalance <", value, "docpursebalance");
            return (Criteria) this;
        }

        public Criteria andDocpursebalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("docPurseBalance <=", value, "docpursebalance");
            return (Criteria) this;
        }

        public Criteria andDocpursebalanceIn(List<BigDecimal> values) {
            addCriterion("docPurseBalance in", values, "docpursebalance");
            return (Criteria) this;
        }

        public Criteria andDocpursebalanceNotIn(List<BigDecimal> values) {
            addCriterion("docPurseBalance not in", values, "docpursebalance");
            return (Criteria) this;
        }

        public Criteria andDocpursebalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("docPurseBalance between", value1, value2, "docpursebalance");
            return (Criteria) this;
        }

        public Criteria andDocpursebalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("docPurseBalance not between", value1, value2, "docpursebalance");
            return (Criteria) this;
        }

        public Criteria andDocloginidIsNull() {
            addCriterion("docLoginId is null");
            return (Criteria) this;
        }

        public Criteria andDocloginidIsNotNull() {
            addCriterion("docLoginId is not null");
            return (Criteria) this;
        }

        public Criteria andDocloginidEqualTo(Integer value) {
            addCriterion("docLoginId =", value, "docloginid");
            return (Criteria) this;
        }

        public Criteria andDocloginidNotEqualTo(Integer value) {
            addCriterion("docLoginId <>", value, "docloginid");
            return (Criteria) this;
        }

        public Criteria andDocloginidGreaterThan(Integer value) {
            addCriterion("docLoginId >", value, "docloginid");
            return (Criteria) this;
        }

        public Criteria andDocloginidGreaterThanOrEqualTo(Integer value) {
            addCriterion("docLoginId >=", value, "docloginid");
            return (Criteria) this;
        }

        public Criteria andDocloginidLessThan(Integer value) {
            addCriterion("docLoginId <", value, "docloginid");
            return (Criteria) this;
        }

        public Criteria andDocloginidLessThanOrEqualTo(Integer value) {
            addCriterion("docLoginId <=", value, "docloginid");
            return (Criteria) this;
        }

        public Criteria andDocloginidIn(List<Integer> values) {
            addCriterion("docLoginId in", values, "docloginid");
            return (Criteria) this;
        }

        public Criteria andDocloginidNotIn(List<Integer> values) {
            addCriterion("docLoginId not in", values, "docloginid");
            return (Criteria) this;
        }

        public Criteria andDocloginidBetween(Integer value1, Integer value2) {
            addCriterion("docLoginId between", value1, value2, "docloginid");
            return (Criteria) this;
        }

        public Criteria andDocloginidNotBetween(Integer value1, Integer value2) {
            addCriterion("docLoginId not between", value1, value2, "docloginid");
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