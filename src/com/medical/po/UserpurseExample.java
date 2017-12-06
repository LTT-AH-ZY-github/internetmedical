package com.medical.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserpurseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserpurseExample() {
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

        public Criteria andUserpurseidIsNull() {
            addCriterion("userPurseId is null");
            return (Criteria) this;
        }

        public Criteria andUserpurseidIsNotNull() {
            addCriterion("userPurseId is not null");
            return (Criteria) this;
        }

        public Criteria andUserpurseidEqualTo(Integer value) {
            addCriterion("userPurseId =", value, "userpurseid");
            return (Criteria) this;
        }

        public Criteria andUserpurseidNotEqualTo(Integer value) {
            addCriterion("userPurseId <>", value, "userpurseid");
            return (Criteria) this;
        }

        public Criteria andUserpurseidGreaterThan(Integer value) {
            addCriterion("userPurseId >", value, "userpurseid");
            return (Criteria) this;
        }

        public Criteria andUserpurseidGreaterThanOrEqualTo(Integer value) {
            addCriterion("userPurseId >=", value, "userpurseid");
            return (Criteria) this;
        }

        public Criteria andUserpurseidLessThan(Integer value) {
            addCriterion("userPurseId <", value, "userpurseid");
            return (Criteria) this;
        }

        public Criteria andUserpurseidLessThanOrEqualTo(Integer value) {
            addCriterion("userPurseId <=", value, "userpurseid");
            return (Criteria) this;
        }

        public Criteria andUserpurseidIn(List<Integer> values) {
            addCriterion("userPurseId in", values, "userpurseid");
            return (Criteria) this;
        }

        public Criteria andUserpurseidNotIn(List<Integer> values) {
            addCriterion("userPurseId not in", values, "userpurseid");
            return (Criteria) this;
        }

        public Criteria andUserpurseidBetween(Integer value1, Integer value2) {
            addCriterion("userPurseId between", value1, value2, "userpurseid");
            return (Criteria) this;
        }

        public Criteria andUserpurseidNotBetween(Integer value1, Integer value2) {
            addCriterion("userPurseId not between", value1, value2, "userpurseid");
            return (Criteria) this;
        }

        public Criteria andUserpursetypeidIsNull() {
            addCriterion("userPurseTypeId is null");
            return (Criteria) this;
        }

        public Criteria andUserpursetypeidIsNotNull() {
            addCriterion("userPurseTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andUserpursetypeidEqualTo(Integer value) {
            addCriterion("userPurseTypeId =", value, "userpursetypeid");
            return (Criteria) this;
        }

        public Criteria andUserpursetypeidNotEqualTo(Integer value) {
            addCriterion("userPurseTypeId <>", value, "userpursetypeid");
            return (Criteria) this;
        }

        public Criteria andUserpursetypeidGreaterThan(Integer value) {
            addCriterion("userPurseTypeId >", value, "userpursetypeid");
            return (Criteria) this;
        }

        public Criteria andUserpursetypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("userPurseTypeId >=", value, "userpursetypeid");
            return (Criteria) this;
        }

        public Criteria andUserpursetypeidLessThan(Integer value) {
            addCriterion("userPurseTypeId <", value, "userpursetypeid");
            return (Criteria) this;
        }

        public Criteria andUserpursetypeidLessThanOrEqualTo(Integer value) {
            addCriterion("userPurseTypeId <=", value, "userpursetypeid");
            return (Criteria) this;
        }

        public Criteria andUserpursetypeidIn(List<Integer> values) {
            addCriterion("userPurseTypeId in", values, "userpursetypeid");
            return (Criteria) this;
        }

        public Criteria andUserpursetypeidNotIn(List<Integer> values) {
            addCriterion("userPurseTypeId not in", values, "userpursetypeid");
            return (Criteria) this;
        }

        public Criteria andUserpursetypeidBetween(Integer value1, Integer value2) {
            addCriterion("userPurseTypeId between", value1, value2, "userpursetypeid");
            return (Criteria) this;
        }

        public Criteria andUserpursetypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("userPurseTypeId not between", value1, value2, "userpursetypeid");
            return (Criteria) this;
        }

        public Criteria andUserpurseamountIsNull() {
            addCriterion("userPurseAmount is null");
            return (Criteria) this;
        }

        public Criteria andUserpurseamountIsNotNull() {
            addCriterion("userPurseAmount is not null");
            return (Criteria) this;
        }

        public Criteria andUserpurseamountEqualTo(BigDecimal value) {
            addCriterion("userPurseAmount =", value, "userpurseamount");
            return (Criteria) this;
        }

        public Criteria andUserpurseamountNotEqualTo(BigDecimal value) {
            addCriterion("userPurseAmount <>", value, "userpurseamount");
            return (Criteria) this;
        }

        public Criteria andUserpurseamountGreaterThan(BigDecimal value) {
            addCriterion("userPurseAmount >", value, "userpurseamount");
            return (Criteria) this;
        }

        public Criteria andUserpurseamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("userPurseAmount >=", value, "userpurseamount");
            return (Criteria) this;
        }

        public Criteria andUserpurseamountLessThan(BigDecimal value) {
            addCriterion("userPurseAmount <", value, "userpurseamount");
            return (Criteria) this;
        }

        public Criteria andUserpurseamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("userPurseAmount <=", value, "userpurseamount");
            return (Criteria) this;
        }

        public Criteria andUserpurseamountIn(List<BigDecimal> values) {
            addCriterion("userPurseAmount in", values, "userpurseamount");
            return (Criteria) this;
        }

        public Criteria andUserpurseamountNotIn(List<BigDecimal> values) {
            addCriterion("userPurseAmount not in", values, "userpurseamount");
            return (Criteria) this;
        }

        public Criteria andUserpurseamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("userPurseAmount between", value1, value2, "userpurseamount");
            return (Criteria) this;
        }

        public Criteria andUserpurseamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("userPurseAmount not between", value1, value2, "userpurseamount");
            return (Criteria) this;
        }

        public Criteria andUserpursetimeIsNull() {
            addCriterion("userPurseTime is null");
            return (Criteria) this;
        }

        public Criteria andUserpursetimeIsNotNull() {
            addCriterion("userPurseTime is not null");
            return (Criteria) this;
        }

        public Criteria andUserpursetimeEqualTo(Date value) {
            addCriterion("userPurseTime =", value, "userpursetime");
            return (Criteria) this;
        }

        public Criteria andUserpursetimeNotEqualTo(Date value) {
            addCriterion("userPurseTime <>", value, "userpursetime");
            return (Criteria) this;
        }

        public Criteria andUserpursetimeGreaterThan(Date value) {
            addCriterion("userPurseTime >", value, "userpursetime");
            return (Criteria) this;
        }

        public Criteria andUserpursetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("userPurseTime >=", value, "userpursetime");
            return (Criteria) this;
        }

        public Criteria andUserpursetimeLessThan(Date value) {
            addCriterion("userPurseTime <", value, "userpursetime");
            return (Criteria) this;
        }

        public Criteria andUserpursetimeLessThanOrEqualTo(Date value) {
            addCriterion("userPurseTime <=", value, "userpursetime");
            return (Criteria) this;
        }

        public Criteria andUserpursetimeIn(List<Date> values) {
            addCriterion("userPurseTime in", values, "userpursetime");
            return (Criteria) this;
        }

        public Criteria andUserpursetimeNotIn(List<Date> values) {
            addCriterion("userPurseTime not in", values, "userpursetime");
            return (Criteria) this;
        }

        public Criteria andUserpursetimeBetween(Date value1, Date value2) {
            addCriterion("userPurseTime between", value1, value2, "userpursetime");
            return (Criteria) this;
        }

        public Criteria andUserpursetimeNotBetween(Date value1, Date value2) {
            addCriterion("userPurseTime not between", value1, value2, "userpursetime");
            return (Criteria) this;
        }

        public Criteria andUserpurseremarkIsNull() {
            addCriterion("userPurseRemark is null");
            return (Criteria) this;
        }

        public Criteria andUserpurseremarkIsNotNull() {
            addCriterion("userPurseRemark is not null");
            return (Criteria) this;
        }

        public Criteria andUserpurseremarkEqualTo(String value) {
            addCriterion("userPurseRemark =", value, "userpurseremark");
            return (Criteria) this;
        }

        public Criteria andUserpurseremarkNotEqualTo(String value) {
            addCriterion("userPurseRemark <>", value, "userpurseremark");
            return (Criteria) this;
        }

        public Criteria andUserpurseremarkGreaterThan(String value) {
            addCriterion("userPurseRemark >", value, "userpurseremark");
            return (Criteria) this;
        }

        public Criteria andUserpurseremarkGreaterThanOrEqualTo(String value) {
            addCriterion("userPurseRemark >=", value, "userpurseremark");
            return (Criteria) this;
        }

        public Criteria andUserpurseremarkLessThan(String value) {
            addCriterion("userPurseRemark <", value, "userpurseremark");
            return (Criteria) this;
        }

        public Criteria andUserpurseremarkLessThanOrEqualTo(String value) {
            addCriterion("userPurseRemark <=", value, "userpurseremark");
            return (Criteria) this;
        }

        public Criteria andUserpurseremarkLike(String value) {
            addCriterion("userPurseRemark like", value, "userpurseremark");
            return (Criteria) this;
        }

        public Criteria andUserpurseremarkNotLike(String value) {
            addCriterion("userPurseRemark not like", value, "userpurseremark");
            return (Criteria) this;
        }

        public Criteria andUserpurseremarkIn(List<String> values) {
            addCriterion("userPurseRemark in", values, "userpurseremark");
            return (Criteria) this;
        }

        public Criteria andUserpurseremarkNotIn(List<String> values) {
            addCriterion("userPurseRemark not in", values, "userpurseremark");
            return (Criteria) this;
        }

        public Criteria andUserpurseremarkBetween(String value1, String value2) {
            addCriterion("userPurseRemark between", value1, value2, "userpurseremark");
            return (Criteria) this;
        }

        public Criteria andUserpurseremarkNotBetween(String value1, String value2) {
            addCriterion("userPurseRemark not between", value1, value2, "userpurseremark");
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

        public Criteria andUserpursebalanceIsNull() {
            addCriterion("userPurseBalance is null");
            return (Criteria) this;
        }

        public Criteria andUserpursebalanceIsNotNull() {
            addCriterion("userPurseBalance is not null");
            return (Criteria) this;
        }

        public Criteria andUserpursebalanceEqualTo(BigDecimal value) {
            addCriterion("userPurseBalance =", value, "userpursebalance");
            return (Criteria) this;
        }

        public Criteria andUserpursebalanceNotEqualTo(BigDecimal value) {
            addCriterion("userPurseBalance <>", value, "userpursebalance");
            return (Criteria) this;
        }

        public Criteria andUserpursebalanceGreaterThan(BigDecimal value) {
            addCriterion("userPurseBalance >", value, "userpursebalance");
            return (Criteria) this;
        }

        public Criteria andUserpursebalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("userPurseBalance >=", value, "userpursebalance");
            return (Criteria) this;
        }

        public Criteria andUserpursebalanceLessThan(BigDecimal value) {
            addCriterion("userPurseBalance <", value, "userpursebalance");
            return (Criteria) this;
        }

        public Criteria andUserpursebalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("userPurseBalance <=", value, "userpursebalance");
            return (Criteria) this;
        }

        public Criteria andUserpursebalanceIn(List<BigDecimal> values) {
            addCriterion("userPurseBalance in", values, "userpursebalance");
            return (Criteria) this;
        }

        public Criteria andUserpursebalanceNotIn(List<BigDecimal> values) {
            addCriterion("userPurseBalance not in", values, "userpursebalance");
            return (Criteria) this;
        }

        public Criteria andUserpursebalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("userPurseBalance between", value1, value2, "userpursebalance");
            return (Criteria) this;
        }

        public Criteria andUserpursebalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("userPurseBalance not between", value1, value2, "userpursebalance");
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