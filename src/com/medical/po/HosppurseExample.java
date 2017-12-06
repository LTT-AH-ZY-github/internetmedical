package com.medical.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HosppurseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HosppurseExample() {
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

        public Criteria andHosppurseidIsNull() {
            addCriterion("hospPurseId is null");
            return (Criteria) this;
        }

        public Criteria andHosppurseidIsNotNull() {
            addCriterion("hospPurseId is not null");
            return (Criteria) this;
        }

        public Criteria andHosppurseidEqualTo(Integer value) {
            addCriterion("hospPurseId =", value, "hosppurseid");
            return (Criteria) this;
        }

        public Criteria andHosppurseidNotEqualTo(Integer value) {
            addCriterion("hospPurseId <>", value, "hosppurseid");
            return (Criteria) this;
        }

        public Criteria andHosppurseidGreaterThan(Integer value) {
            addCriterion("hospPurseId >", value, "hosppurseid");
            return (Criteria) this;
        }

        public Criteria andHosppurseidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hospPurseId >=", value, "hosppurseid");
            return (Criteria) this;
        }

        public Criteria andHosppurseidLessThan(Integer value) {
            addCriterion("hospPurseId <", value, "hosppurseid");
            return (Criteria) this;
        }

        public Criteria andHosppurseidLessThanOrEqualTo(Integer value) {
            addCriterion("hospPurseId <=", value, "hosppurseid");
            return (Criteria) this;
        }

        public Criteria andHosppurseidIn(List<Integer> values) {
            addCriterion("hospPurseId in", values, "hosppurseid");
            return (Criteria) this;
        }

        public Criteria andHosppurseidNotIn(List<Integer> values) {
            addCriterion("hospPurseId not in", values, "hosppurseid");
            return (Criteria) this;
        }

        public Criteria andHosppurseidBetween(Integer value1, Integer value2) {
            addCriterion("hospPurseId between", value1, value2, "hosppurseid");
            return (Criteria) this;
        }

        public Criteria andHosppurseidNotBetween(Integer value1, Integer value2) {
            addCriterion("hospPurseId not between", value1, value2, "hosppurseid");
            return (Criteria) this;
        }

        public Criteria andHosppursetypeidIsNull() {
            addCriterion("hospPurseTypeId is null");
            return (Criteria) this;
        }

        public Criteria andHosppursetypeidIsNotNull() {
            addCriterion("hospPurseTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andHosppursetypeidEqualTo(Integer value) {
            addCriterion("hospPurseTypeId =", value, "hosppursetypeid");
            return (Criteria) this;
        }

        public Criteria andHosppursetypeidNotEqualTo(Integer value) {
            addCriterion("hospPurseTypeId <>", value, "hosppursetypeid");
            return (Criteria) this;
        }

        public Criteria andHosppursetypeidGreaterThan(Integer value) {
            addCriterion("hospPurseTypeId >", value, "hosppursetypeid");
            return (Criteria) this;
        }

        public Criteria andHosppursetypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hospPurseTypeId >=", value, "hosppursetypeid");
            return (Criteria) this;
        }

        public Criteria andHosppursetypeidLessThan(Integer value) {
            addCriterion("hospPurseTypeId <", value, "hosppursetypeid");
            return (Criteria) this;
        }

        public Criteria andHosppursetypeidLessThanOrEqualTo(Integer value) {
            addCriterion("hospPurseTypeId <=", value, "hosppursetypeid");
            return (Criteria) this;
        }

        public Criteria andHosppursetypeidIn(List<Integer> values) {
            addCriterion("hospPurseTypeId in", values, "hosppursetypeid");
            return (Criteria) this;
        }

        public Criteria andHosppursetypeidNotIn(List<Integer> values) {
            addCriterion("hospPurseTypeId not in", values, "hosppursetypeid");
            return (Criteria) this;
        }

        public Criteria andHosppursetypeidBetween(Integer value1, Integer value2) {
            addCriterion("hospPurseTypeId between", value1, value2, "hosppursetypeid");
            return (Criteria) this;
        }

        public Criteria andHosppursetypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("hospPurseTypeId not between", value1, value2, "hosppursetypeid");
            return (Criteria) this;
        }

        public Criteria andHosppurseamountIsNull() {
            addCriterion("hospPurseAmount is null");
            return (Criteria) this;
        }

        public Criteria andHosppurseamountIsNotNull() {
            addCriterion("hospPurseAmount is not null");
            return (Criteria) this;
        }

        public Criteria andHosppurseamountEqualTo(BigDecimal value) {
            addCriterion("hospPurseAmount =", value, "hosppurseamount");
            return (Criteria) this;
        }

        public Criteria andHosppurseamountNotEqualTo(BigDecimal value) {
            addCriterion("hospPurseAmount <>", value, "hosppurseamount");
            return (Criteria) this;
        }

        public Criteria andHosppurseamountGreaterThan(BigDecimal value) {
            addCriterion("hospPurseAmount >", value, "hosppurseamount");
            return (Criteria) this;
        }

        public Criteria andHosppurseamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hospPurseAmount >=", value, "hosppurseamount");
            return (Criteria) this;
        }

        public Criteria andHosppurseamountLessThan(BigDecimal value) {
            addCriterion("hospPurseAmount <", value, "hosppurseamount");
            return (Criteria) this;
        }

        public Criteria andHosppurseamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hospPurseAmount <=", value, "hosppurseamount");
            return (Criteria) this;
        }

        public Criteria andHosppurseamountIn(List<BigDecimal> values) {
            addCriterion("hospPurseAmount in", values, "hosppurseamount");
            return (Criteria) this;
        }

        public Criteria andHosppurseamountNotIn(List<BigDecimal> values) {
            addCriterion("hospPurseAmount not in", values, "hosppurseamount");
            return (Criteria) this;
        }

        public Criteria andHosppurseamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hospPurseAmount between", value1, value2, "hosppurseamount");
            return (Criteria) this;
        }

        public Criteria andHosppurseamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hospPurseAmount not between", value1, value2, "hosppurseamount");
            return (Criteria) this;
        }

        public Criteria andHosppursetimeIsNull() {
            addCriterion("hospPurseTime is null");
            return (Criteria) this;
        }

        public Criteria andHosppursetimeIsNotNull() {
            addCriterion("hospPurseTime is not null");
            return (Criteria) this;
        }

        public Criteria andHosppursetimeEqualTo(Date value) {
            addCriterion("hospPurseTime =", value, "hosppursetime");
            return (Criteria) this;
        }

        public Criteria andHosppursetimeNotEqualTo(Date value) {
            addCriterion("hospPurseTime <>", value, "hosppursetime");
            return (Criteria) this;
        }

        public Criteria andHosppursetimeGreaterThan(Date value) {
            addCriterion("hospPurseTime >", value, "hosppursetime");
            return (Criteria) this;
        }

        public Criteria andHosppursetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("hospPurseTime >=", value, "hosppursetime");
            return (Criteria) this;
        }

        public Criteria andHosppursetimeLessThan(Date value) {
            addCriterion("hospPurseTime <", value, "hosppursetime");
            return (Criteria) this;
        }

        public Criteria andHosppursetimeLessThanOrEqualTo(Date value) {
            addCriterion("hospPurseTime <=", value, "hosppursetime");
            return (Criteria) this;
        }

        public Criteria andHosppursetimeIn(List<Date> values) {
            addCriterion("hospPurseTime in", values, "hosppursetime");
            return (Criteria) this;
        }

        public Criteria andHosppursetimeNotIn(List<Date> values) {
            addCriterion("hospPurseTime not in", values, "hosppursetime");
            return (Criteria) this;
        }

        public Criteria andHosppursetimeBetween(Date value1, Date value2) {
            addCriterion("hospPurseTime between", value1, value2, "hosppursetime");
            return (Criteria) this;
        }

        public Criteria andHosppursetimeNotBetween(Date value1, Date value2) {
            addCriterion("hospPurseTime not between", value1, value2, "hosppursetime");
            return (Criteria) this;
        }

        public Criteria andHosppurseremarkIsNull() {
            addCriterion("hospPurseRemark is null");
            return (Criteria) this;
        }

        public Criteria andHosppurseremarkIsNotNull() {
            addCriterion("hospPurseRemark is not null");
            return (Criteria) this;
        }

        public Criteria andHosppurseremarkEqualTo(String value) {
            addCriterion("hospPurseRemark =", value, "hosppurseremark");
            return (Criteria) this;
        }

        public Criteria andHosppurseremarkNotEqualTo(String value) {
            addCriterion("hospPurseRemark <>", value, "hosppurseremark");
            return (Criteria) this;
        }

        public Criteria andHosppurseremarkGreaterThan(String value) {
            addCriterion("hospPurseRemark >", value, "hosppurseremark");
            return (Criteria) this;
        }

        public Criteria andHosppurseremarkGreaterThanOrEqualTo(String value) {
            addCriterion("hospPurseRemark >=", value, "hosppurseremark");
            return (Criteria) this;
        }

        public Criteria andHosppurseremarkLessThan(String value) {
            addCriterion("hospPurseRemark <", value, "hosppurseremark");
            return (Criteria) this;
        }

        public Criteria andHosppurseremarkLessThanOrEqualTo(String value) {
            addCriterion("hospPurseRemark <=", value, "hosppurseremark");
            return (Criteria) this;
        }

        public Criteria andHosppurseremarkLike(String value) {
            addCriterion("hospPurseRemark like", value, "hosppurseremark");
            return (Criteria) this;
        }

        public Criteria andHosppurseremarkNotLike(String value) {
            addCriterion("hospPurseRemark not like", value, "hosppurseremark");
            return (Criteria) this;
        }

        public Criteria andHosppurseremarkIn(List<String> values) {
            addCriterion("hospPurseRemark in", values, "hosppurseremark");
            return (Criteria) this;
        }

        public Criteria andHosppurseremarkNotIn(List<String> values) {
            addCriterion("hospPurseRemark not in", values, "hosppurseremark");
            return (Criteria) this;
        }

        public Criteria andHosppurseremarkBetween(String value1, String value2) {
            addCriterion("hospPurseRemark between", value1, value2, "hosppurseremark");
            return (Criteria) this;
        }

        public Criteria andHosppurseremarkNotBetween(String value1, String value2) {
            addCriterion("hospPurseRemark not between", value1, value2, "hosppurseremark");
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

        public Criteria andHosppursebalanceIsNull() {
            addCriterion("hospPurseBalance is null");
            return (Criteria) this;
        }

        public Criteria andHosppursebalanceIsNotNull() {
            addCriterion("hospPurseBalance is not null");
            return (Criteria) this;
        }

        public Criteria andHosppursebalanceEqualTo(BigDecimal value) {
            addCriterion("hospPurseBalance =", value, "hosppursebalance");
            return (Criteria) this;
        }

        public Criteria andHosppursebalanceNotEqualTo(BigDecimal value) {
            addCriterion("hospPurseBalance <>", value, "hosppursebalance");
            return (Criteria) this;
        }

        public Criteria andHosppursebalanceGreaterThan(BigDecimal value) {
            addCriterion("hospPurseBalance >", value, "hosppursebalance");
            return (Criteria) this;
        }

        public Criteria andHosppursebalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hospPurseBalance >=", value, "hosppursebalance");
            return (Criteria) this;
        }

        public Criteria andHosppursebalanceLessThan(BigDecimal value) {
            addCriterion("hospPurseBalance <", value, "hosppursebalance");
            return (Criteria) this;
        }

        public Criteria andHosppursebalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hospPurseBalance <=", value, "hosppursebalance");
            return (Criteria) this;
        }

        public Criteria andHosppursebalanceIn(List<BigDecimal> values) {
            addCriterion("hospPurseBalance in", values, "hosppursebalance");
            return (Criteria) this;
        }

        public Criteria andHosppursebalanceNotIn(List<BigDecimal> values) {
            addCriterion("hospPurseBalance not in", values, "hosppursebalance");
            return (Criteria) this;
        }

        public Criteria andHosppursebalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hospPurseBalance between", value1, value2, "hosppursebalance");
            return (Criteria) this;
        }

        public Criteria andHosppursebalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hospPurseBalance not between", value1, value2, "hosppursebalance");
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