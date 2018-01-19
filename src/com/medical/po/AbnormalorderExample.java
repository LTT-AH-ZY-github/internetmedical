package com.medical.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AbnormalorderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AbnormalorderExample() {
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

        public Criteria andAbnormalorderidIsNull() {
            addCriterion("abnormalOrderId is null");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderidIsNotNull() {
            addCriterion("abnormalOrderId is not null");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderidEqualTo(Integer value) {
            addCriterion("abnormalOrderId =", value, "abnormalorderid");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderidNotEqualTo(Integer value) {
            addCriterion("abnormalOrderId <>", value, "abnormalorderid");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderidGreaterThan(Integer value) {
            addCriterion("abnormalOrderId >", value, "abnormalorderid");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("abnormalOrderId >=", value, "abnormalorderid");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderidLessThan(Integer value) {
            addCriterion("abnormalOrderId <", value, "abnormalorderid");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderidLessThanOrEqualTo(Integer value) {
            addCriterion("abnormalOrderId <=", value, "abnormalorderid");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderidIn(List<Integer> values) {
            addCriterion("abnormalOrderId in", values, "abnormalorderid");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderidNotIn(List<Integer> values) {
            addCriterion("abnormalOrderId not in", values, "abnormalorderid");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderidBetween(Integer value1, Integer value2) {
            addCriterion("abnormalOrderId between", value1, value2, "abnormalorderid");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderidNotBetween(Integer value1, Integer value2) {
            addCriterion("abnormalOrderId not between", value1, value2, "abnormalorderid");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderpayidIsNull() {
            addCriterion("abnormalOrderPayId is null");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderpayidIsNotNull() {
            addCriterion("abnormalOrderPayId is not null");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderpayidEqualTo(Integer value) {
            addCriterion("abnormalOrderPayId =", value, "abnormalorderpayid");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderpayidNotEqualTo(Integer value) {
            addCriterion("abnormalOrderPayId <>", value, "abnormalorderpayid");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderpayidGreaterThan(Integer value) {
            addCriterion("abnormalOrderPayId >", value, "abnormalorderpayid");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderpayidGreaterThanOrEqualTo(Integer value) {
            addCriterion("abnormalOrderPayId >=", value, "abnormalorderpayid");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderpayidLessThan(Integer value) {
            addCriterion("abnormalOrderPayId <", value, "abnormalorderpayid");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderpayidLessThanOrEqualTo(Integer value) {
            addCriterion("abnormalOrderPayId <=", value, "abnormalorderpayid");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderpayidIn(List<Integer> values) {
            addCriterion("abnormalOrderPayId in", values, "abnormalorderpayid");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderpayidNotIn(List<Integer> values) {
            addCriterion("abnormalOrderPayId not in", values, "abnormalorderpayid");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderpayidBetween(Integer value1, Integer value2) {
            addCriterion("abnormalOrderPayId between", value1, value2, "abnormalorderpayid");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderpayidNotBetween(Integer value1, Integer value2) {
            addCriterion("abnormalOrderPayId not between", value1, value2, "abnormalorderpayid");
            return (Criteria) this;
        }

        public Criteria andAbnormalordertypeIsNull() {
            addCriterion("abnormalOrderType is null");
            return (Criteria) this;
        }

        public Criteria andAbnormalordertypeIsNotNull() {
            addCriterion("abnormalOrderType is not null");
            return (Criteria) this;
        }

        public Criteria andAbnormalordertypeEqualTo(Integer value) {
            addCriterion("abnormalOrderType =", value, "abnormalordertype");
            return (Criteria) this;
        }

        public Criteria andAbnormalordertypeNotEqualTo(Integer value) {
            addCriterion("abnormalOrderType <>", value, "abnormalordertype");
            return (Criteria) this;
        }

        public Criteria andAbnormalordertypeGreaterThan(Integer value) {
            addCriterion("abnormalOrderType >", value, "abnormalordertype");
            return (Criteria) this;
        }

        public Criteria andAbnormalordertypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("abnormalOrderType >=", value, "abnormalordertype");
            return (Criteria) this;
        }

        public Criteria andAbnormalordertypeLessThan(Integer value) {
            addCriterion("abnormalOrderType <", value, "abnormalordertype");
            return (Criteria) this;
        }

        public Criteria andAbnormalordertypeLessThanOrEqualTo(Integer value) {
            addCriterion("abnormalOrderType <=", value, "abnormalordertype");
            return (Criteria) this;
        }

        public Criteria andAbnormalordertypeIn(List<Integer> values) {
            addCriterion("abnormalOrderType in", values, "abnormalordertype");
            return (Criteria) this;
        }

        public Criteria andAbnormalordertypeNotIn(List<Integer> values) {
            addCriterion("abnormalOrderType not in", values, "abnormalordertype");
            return (Criteria) this;
        }

        public Criteria andAbnormalordertypeBetween(Integer value1, Integer value2) {
            addCriterion("abnormalOrderType between", value1, value2, "abnormalordertype");
            return (Criteria) this;
        }

        public Criteria andAbnormalordertypeNotBetween(Integer value1, Integer value2) {
            addCriterion("abnormalOrderType not between", value1, value2, "abnormalordertype");
            return (Criteria) this;
        }

        public Criteria andAbnormalordercreattimeIsNull() {
            addCriterion("abnormalOrderCreatTime is null");
            return (Criteria) this;
        }

        public Criteria andAbnormalordercreattimeIsNotNull() {
            addCriterion("abnormalOrderCreatTime is not null");
            return (Criteria) this;
        }

        public Criteria andAbnormalordercreattimeEqualTo(Date value) {
            addCriterion("abnormalOrderCreatTime =", value, "abnormalordercreattime");
            return (Criteria) this;
        }

        public Criteria andAbnormalordercreattimeNotEqualTo(Date value) {
            addCriterion("abnormalOrderCreatTime <>", value, "abnormalordercreattime");
            return (Criteria) this;
        }

        public Criteria andAbnormalordercreattimeGreaterThan(Date value) {
            addCriterion("abnormalOrderCreatTime >", value, "abnormalordercreattime");
            return (Criteria) this;
        }

        public Criteria andAbnormalordercreattimeGreaterThanOrEqualTo(Date value) {
            addCriterion("abnormalOrderCreatTime >=", value, "abnormalordercreattime");
            return (Criteria) this;
        }

        public Criteria andAbnormalordercreattimeLessThan(Date value) {
            addCriterion("abnormalOrderCreatTime <", value, "abnormalordercreattime");
            return (Criteria) this;
        }

        public Criteria andAbnormalordercreattimeLessThanOrEqualTo(Date value) {
            addCriterion("abnormalOrderCreatTime <=", value, "abnormalordercreattime");
            return (Criteria) this;
        }

        public Criteria andAbnormalordercreattimeIn(List<Date> values) {
            addCriterion("abnormalOrderCreatTime in", values, "abnormalordercreattime");
            return (Criteria) this;
        }

        public Criteria andAbnormalordercreattimeNotIn(List<Date> values) {
            addCriterion("abnormalOrderCreatTime not in", values, "abnormalordercreattime");
            return (Criteria) this;
        }

        public Criteria andAbnormalordercreattimeBetween(Date value1, Date value2) {
            addCriterion("abnormalOrderCreatTime between", value1, value2, "abnormalordercreattime");
            return (Criteria) this;
        }

        public Criteria andAbnormalordercreattimeNotBetween(Date value1, Date value2) {
            addCriterion("abnormalOrderCreatTime not between", value1, value2, "abnormalordercreattime");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderendtimeIsNull() {
            addCriterion("abnormalOrderEndTime is null");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderendtimeIsNotNull() {
            addCriterion("abnormalOrderEndTime is not null");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderendtimeEqualTo(Date value) {
            addCriterion("abnormalOrderEndTime =", value, "abnormalorderendtime");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderendtimeNotEqualTo(Date value) {
            addCriterion("abnormalOrderEndTime <>", value, "abnormalorderendtime");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderendtimeGreaterThan(Date value) {
            addCriterion("abnormalOrderEndTime >", value, "abnormalorderendtime");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("abnormalOrderEndTime >=", value, "abnormalorderendtime");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderendtimeLessThan(Date value) {
            addCriterion("abnormalOrderEndTime <", value, "abnormalorderendtime");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderendtimeLessThanOrEqualTo(Date value) {
            addCriterion("abnormalOrderEndTime <=", value, "abnormalorderendtime");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderendtimeIn(List<Date> values) {
            addCriterion("abnormalOrderEndTime in", values, "abnormalorderendtime");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderendtimeNotIn(List<Date> values) {
            addCriterion("abnormalOrderEndTime not in", values, "abnormalorderendtime");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderendtimeBetween(Date value1, Date value2) {
            addCriterion("abnormalOrderEndTime between", value1, value2, "abnormalorderendtime");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderendtimeNotBetween(Date value1, Date value2) {
            addCriterion("abnormalOrderEndTime not between", value1, value2, "abnormalorderendtime");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderreasonIsNull() {
            addCriterion("abnormalOrderReason is null");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderreasonIsNotNull() {
            addCriterion("abnormalOrderReason is not null");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderreasonEqualTo(String value) {
            addCriterion("abnormalOrderReason =", value, "abnormalorderreason");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderreasonNotEqualTo(String value) {
            addCriterion("abnormalOrderReason <>", value, "abnormalorderreason");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderreasonGreaterThan(String value) {
            addCriterion("abnormalOrderReason >", value, "abnormalorderreason");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderreasonGreaterThanOrEqualTo(String value) {
            addCriterion("abnormalOrderReason >=", value, "abnormalorderreason");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderreasonLessThan(String value) {
            addCriterion("abnormalOrderReason <", value, "abnormalorderreason");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderreasonLessThanOrEqualTo(String value) {
            addCriterion("abnormalOrderReason <=", value, "abnormalorderreason");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderreasonLike(String value) {
            addCriterion("abnormalOrderReason like", value, "abnormalorderreason");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderreasonNotLike(String value) {
            addCriterion("abnormalOrderReason not like", value, "abnormalorderreason");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderreasonIn(List<String> values) {
            addCriterion("abnormalOrderReason in", values, "abnormalorderreason");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderreasonNotIn(List<String> values) {
            addCriterion("abnormalOrderReason not in", values, "abnormalorderreason");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderreasonBetween(String value1, String value2) {
            addCriterion("abnormalOrderReason between", value1, value2, "abnormalorderreason");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderreasonNotBetween(String value1, String value2) {
            addCriterion("abnormalOrderReason not between", value1, value2, "abnormalorderreason");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderissolveIsNull() {
            addCriterion("abnormalOrderIsSolve is null");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderissolveIsNotNull() {
            addCriterion("abnormalOrderIsSolve is not null");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderissolveEqualTo(Boolean value) {
            addCriterion("abnormalOrderIsSolve =", value, "abnormalorderissolve");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderissolveNotEqualTo(Boolean value) {
            addCriterion("abnormalOrderIsSolve <>", value, "abnormalorderissolve");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderissolveGreaterThan(Boolean value) {
            addCriterion("abnormalOrderIsSolve >", value, "abnormalorderissolve");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderissolveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("abnormalOrderIsSolve >=", value, "abnormalorderissolve");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderissolveLessThan(Boolean value) {
            addCriterion("abnormalOrderIsSolve <", value, "abnormalorderissolve");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderissolveLessThanOrEqualTo(Boolean value) {
            addCriterion("abnormalOrderIsSolve <=", value, "abnormalorderissolve");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderissolveIn(List<Boolean> values) {
            addCriterion("abnormalOrderIsSolve in", values, "abnormalorderissolve");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderissolveNotIn(List<Boolean> values) {
            addCriterion("abnormalOrderIsSolve not in", values, "abnormalorderissolve");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderissolveBetween(Boolean value1, Boolean value2) {
            addCriterion("abnormalOrderIsSolve between", value1, value2, "abnormalorderissolve");
            return (Criteria) this;
        }

        public Criteria andAbnormalorderissolveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("abnormalOrderIsSolve not between", value1, value2, "abnormalorderissolve");
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