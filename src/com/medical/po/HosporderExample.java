package com.medical.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HosporderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HosporderExample() {
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

        public Criteria andHosporderidIsNull() {
            addCriterion("HospOrderId is null");
            return (Criteria) this;
        }

        public Criteria andHosporderidIsNotNull() {
            addCriterion("HospOrderId is not null");
            return (Criteria) this;
        }

        public Criteria andHosporderidEqualTo(Integer value) {
            addCriterion("HospOrderId =", value, "hosporderid");
            return (Criteria) this;
        }

        public Criteria andHosporderidNotEqualTo(Integer value) {
            addCriterion("HospOrderId <>", value, "hosporderid");
            return (Criteria) this;
        }

        public Criteria andHosporderidGreaterThan(Integer value) {
            addCriterion("HospOrderId >", value, "hosporderid");
            return (Criteria) this;
        }

        public Criteria andHosporderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("HospOrderId >=", value, "hosporderid");
            return (Criteria) this;
        }

        public Criteria andHosporderidLessThan(Integer value) {
            addCriterion("HospOrderId <", value, "hosporderid");
            return (Criteria) this;
        }

        public Criteria andHosporderidLessThanOrEqualTo(Integer value) {
            addCriterion("HospOrderId <=", value, "hosporderid");
            return (Criteria) this;
        }

        public Criteria andHosporderidIn(List<Integer> values) {
            addCriterion("HospOrderId in", values, "hosporderid");
            return (Criteria) this;
        }

        public Criteria andHosporderidNotIn(List<Integer> values) {
            addCriterion("HospOrderId not in", values, "hosporderid");
            return (Criteria) this;
        }

        public Criteria andHosporderidBetween(Integer value1, Integer value2) {
            addCriterion("HospOrderId between", value1, value2, "hosporderid");
            return (Criteria) this;
        }

        public Criteria andHosporderidNotBetween(Integer value1, Integer value2) {
            addCriterion("HospOrderId not between", value1, value2, "hosporderid");
            return (Criteria) this;
        }

        public Criteria andHospidIsNull() {
            addCriterion("HospId is null");
            return (Criteria) this;
        }

        public Criteria andHospidIsNotNull() {
            addCriterion("HospId is not null");
            return (Criteria) this;
        }

        public Criteria andHospidEqualTo(Integer value) {
            addCriterion("HospId =", value, "hospid");
            return (Criteria) this;
        }

        public Criteria andHospidNotEqualTo(Integer value) {
            addCriterion("HospId <>", value, "hospid");
            return (Criteria) this;
        }

        public Criteria andHospidGreaterThan(Integer value) {
            addCriterion("HospId >", value, "hospid");
            return (Criteria) this;
        }

        public Criteria andHospidGreaterThanOrEqualTo(Integer value) {
            addCriterion("HospId >=", value, "hospid");
            return (Criteria) this;
        }

        public Criteria andHospidLessThan(Integer value) {
            addCriterion("HospId <", value, "hospid");
            return (Criteria) this;
        }

        public Criteria andHospidLessThanOrEqualTo(Integer value) {
            addCriterion("HospId <=", value, "hospid");
            return (Criteria) this;
        }

        public Criteria andHospidIn(List<Integer> values) {
            addCriterion("HospId in", values, "hospid");
            return (Criteria) this;
        }

        public Criteria andHospidNotIn(List<Integer> values) {
            addCriterion("HospId not in", values, "hospid");
            return (Criteria) this;
        }

        public Criteria andHospidBetween(Integer value1, Integer value2) {
            addCriterion("HospId between", value1, value2, "hospid");
            return (Criteria) this;
        }

        public Criteria andHospidNotBetween(Integer value1, Integer value2) {
            addCriterion("HospId not between", value1, value2, "hospid");
            return (Criteria) this;
        }

        public Criteria andDoctoridIsNull() {
            addCriterion("DoctorId is null");
            return (Criteria) this;
        }

        public Criteria andDoctoridIsNotNull() {
            addCriterion("DoctorId is not null");
            return (Criteria) this;
        }

        public Criteria andDoctoridEqualTo(Integer value) {
            addCriterion("DoctorId =", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridNotEqualTo(Integer value) {
            addCriterion("DoctorId <>", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridGreaterThan(Integer value) {
            addCriterion("DoctorId >", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridGreaterThanOrEqualTo(Integer value) {
            addCriterion("DoctorId >=", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridLessThan(Integer value) {
            addCriterion("DoctorId <", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridLessThanOrEqualTo(Integer value) {
            addCriterion("DoctorId <=", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridIn(List<Integer> values) {
            addCriterion("DoctorId in", values, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridNotIn(List<Integer> values) {
            addCriterion("DoctorId not in", values, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridBetween(Integer value1, Integer value2) {
            addCriterion("DoctorId between", value1, value2, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridNotBetween(Integer value1, Integer value2) {
            addCriterion("DoctorId not between", value1, value2, "doctorid");
            return (Criteria) this;
        }

        public Criteria andOrderpriceIsNull() {
            addCriterion("OrderPrice is null");
            return (Criteria) this;
        }

        public Criteria andOrderpriceIsNotNull() {
            addCriterion("OrderPrice is not null");
            return (Criteria) this;
        }

        public Criteria andOrderpriceEqualTo(BigDecimal value) {
            addCriterion("OrderPrice =", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceNotEqualTo(BigDecimal value) {
            addCriterion("OrderPrice <>", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceGreaterThan(BigDecimal value) {
            addCriterion("OrderPrice >", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OrderPrice >=", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceLessThan(BigDecimal value) {
            addCriterion("OrderPrice <", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OrderPrice <=", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceIn(List<BigDecimal> values) {
            addCriterion("OrderPrice in", values, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceNotIn(List<BigDecimal> values) {
            addCriterion("OrderPrice not in", values, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OrderPrice between", value1, value2, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OrderPrice not between", value1, value2, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderabsIsNull() {
            addCriterion("OrderAbs is null");
            return (Criteria) this;
        }

        public Criteria andOrderabsIsNotNull() {
            addCriterion("OrderAbs is not null");
            return (Criteria) this;
        }

        public Criteria andOrderabsEqualTo(String value) {
            addCriterion("OrderAbs =", value, "orderabs");
            return (Criteria) this;
        }

        public Criteria andOrderabsNotEqualTo(String value) {
            addCriterion("OrderAbs <>", value, "orderabs");
            return (Criteria) this;
        }

        public Criteria andOrderabsGreaterThan(String value) {
            addCriterion("OrderAbs >", value, "orderabs");
            return (Criteria) this;
        }

        public Criteria andOrderabsGreaterThanOrEqualTo(String value) {
            addCriterion("OrderAbs >=", value, "orderabs");
            return (Criteria) this;
        }

        public Criteria andOrderabsLessThan(String value) {
            addCriterion("OrderAbs <", value, "orderabs");
            return (Criteria) this;
        }

        public Criteria andOrderabsLessThanOrEqualTo(String value) {
            addCriterion("OrderAbs <=", value, "orderabs");
            return (Criteria) this;
        }

        public Criteria andOrderabsLike(String value) {
            addCriterion("OrderAbs like", value, "orderabs");
            return (Criteria) this;
        }

        public Criteria andOrderabsNotLike(String value) {
            addCriterion("OrderAbs not like", value, "orderabs");
            return (Criteria) this;
        }

        public Criteria andOrderabsIn(List<String> values) {
            addCriterion("OrderAbs in", values, "orderabs");
            return (Criteria) this;
        }

        public Criteria andOrderabsNotIn(List<String> values) {
            addCriterion("OrderAbs not in", values, "orderabs");
            return (Criteria) this;
        }

        public Criteria andOrderabsBetween(String value1, String value2) {
            addCriterion("OrderAbs between", value1, value2, "orderabs");
            return (Criteria) this;
        }

        public Criteria andOrderabsNotBetween(String value1, String value2) {
            addCriterion("OrderAbs not between", value1, value2, "orderabs");
            return (Criteria) this;
        }

        public Criteria andOrderstateIsNull() {
            addCriterion("OrderState is null");
            return (Criteria) this;
        }

        public Criteria andOrderstateIsNotNull() {
            addCriterion("OrderState is not null");
            return (Criteria) this;
        }

        public Criteria andOrderstateEqualTo(Integer value) {
            addCriterion("OrderState =", value, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateNotEqualTo(Integer value) {
            addCriterion("OrderState <>", value, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateGreaterThan(Integer value) {
            addCriterion("OrderState >", value, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("OrderState >=", value, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateLessThan(Integer value) {
            addCriterion("OrderState <", value, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateLessThanOrEqualTo(Integer value) {
            addCriterion("OrderState <=", value, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateIn(List<Integer> values) {
            addCriterion("OrderState in", values, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateNotIn(List<Integer> values) {
            addCriterion("OrderState not in", values, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateBetween(Integer value1, Integer value2) {
            addCriterion("OrderState between", value1, value2, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderstateNotBetween(Integer value1, Integer value2) {
            addCriterion("OrderState not between", value1, value2, "orderstate");
            return (Criteria) this;
        }

        public Criteria andOrderptimeIsNull() {
            addCriterion("OrderPTime is null");
            return (Criteria) this;
        }

        public Criteria andOrderptimeIsNotNull() {
            addCriterion("OrderPTime is not null");
            return (Criteria) this;
        }

        public Criteria andOrderptimeEqualTo(Date value) {
            addCriterion("OrderPTime =", value, "orderptime");
            return (Criteria) this;
        }

        public Criteria andOrderptimeNotEqualTo(Date value) {
            addCriterion("OrderPTime <>", value, "orderptime");
            return (Criteria) this;
        }

        public Criteria andOrderptimeGreaterThan(Date value) {
            addCriterion("OrderPTime >", value, "orderptime");
            return (Criteria) this;
        }

        public Criteria andOrderptimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OrderPTime >=", value, "orderptime");
            return (Criteria) this;
        }

        public Criteria andOrderptimeLessThan(Date value) {
            addCriterion("OrderPTime <", value, "orderptime");
            return (Criteria) this;
        }

        public Criteria andOrderptimeLessThanOrEqualTo(Date value) {
            addCriterion("OrderPTime <=", value, "orderptime");
            return (Criteria) this;
        }

        public Criteria andOrderptimeIn(List<Date> values) {
            addCriterion("OrderPTime in", values, "orderptime");
            return (Criteria) this;
        }

        public Criteria andOrderptimeNotIn(List<Date> values) {
            addCriterion("OrderPTime not in", values, "orderptime");
            return (Criteria) this;
        }

        public Criteria andOrderptimeBetween(Date value1, Date value2) {
            addCriterion("OrderPTime between", value1, value2, "orderptime");
            return (Criteria) this;
        }

        public Criteria andOrderptimeNotBetween(Date value1, Date value2) {
            addCriterion("OrderPTime not between", value1, value2, "orderptime");
            return (Criteria) this;
        }

        public Criteria andOrderrtimeIsNull() {
            addCriterion("OrderRTime is null");
            return (Criteria) this;
        }

        public Criteria andOrderrtimeIsNotNull() {
            addCriterion("OrderRTime is not null");
            return (Criteria) this;
        }

        public Criteria andOrderrtimeEqualTo(Date value) {
            addCriterion("OrderRTime =", value, "orderrtime");
            return (Criteria) this;
        }

        public Criteria andOrderrtimeNotEqualTo(Date value) {
            addCriterion("OrderRTime <>", value, "orderrtime");
            return (Criteria) this;
        }

        public Criteria andOrderrtimeGreaterThan(Date value) {
            addCriterion("OrderRTime >", value, "orderrtime");
            return (Criteria) this;
        }

        public Criteria andOrderrtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OrderRTime >=", value, "orderrtime");
            return (Criteria) this;
        }

        public Criteria andOrderrtimeLessThan(Date value) {
            addCriterion("OrderRTime <", value, "orderrtime");
            return (Criteria) this;
        }

        public Criteria andOrderrtimeLessThanOrEqualTo(Date value) {
            addCriterion("OrderRTime <=", value, "orderrtime");
            return (Criteria) this;
        }

        public Criteria andOrderrtimeIn(List<Date> values) {
            addCriterion("OrderRTime in", values, "orderrtime");
            return (Criteria) this;
        }

        public Criteria andOrderrtimeNotIn(List<Date> values) {
            addCriterion("OrderRTime not in", values, "orderrtime");
            return (Criteria) this;
        }

        public Criteria andOrderrtimeBetween(Date value1, Date value2) {
            addCriterion("OrderRTime between", value1, value2, "orderrtime");
            return (Criteria) this;
        }

        public Criteria andOrderrtimeNotBetween(Date value1, Date value2) {
            addCriterion("OrderRTime not between", value1, value2, "orderrtime");
            return (Criteria) this;
        }

        public Criteria andOrderetimeIsNull() {
            addCriterion("OrderETime is null");
            return (Criteria) this;
        }

        public Criteria andOrderetimeIsNotNull() {
            addCriterion("OrderETime is not null");
            return (Criteria) this;
        }

        public Criteria andOrderetimeEqualTo(Date value) {
            addCriterion("OrderETime =", value, "orderetime");
            return (Criteria) this;
        }

        public Criteria andOrderetimeNotEqualTo(Date value) {
            addCriterion("OrderETime <>", value, "orderetime");
            return (Criteria) this;
        }

        public Criteria andOrderetimeGreaterThan(Date value) {
            addCriterion("OrderETime >", value, "orderetime");
            return (Criteria) this;
        }

        public Criteria andOrderetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OrderETime >=", value, "orderetime");
            return (Criteria) this;
        }

        public Criteria andOrderetimeLessThan(Date value) {
            addCriterion("OrderETime <", value, "orderetime");
            return (Criteria) this;
        }

        public Criteria andOrderetimeLessThanOrEqualTo(Date value) {
            addCriterion("OrderETime <=", value, "orderetime");
            return (Criteria) this;
        }

        public Criteria andOrderetimeIn(List<Date> values) {
            addCriterion("OrderETime in", values, "orderetime");
            return (Criteria) this;
        }

        public Criteria andOrderetimeNotIn(List<Date> values) {
            addCriterion("OrderETime not in", values, "orderetime");
            return (Criteria) this;
        }

        public Criteria andOrderetimeBetween(Date value1, Date value2) {
            addCriterion("OrderETime between", value1, value2, "orderetime");
            return (Criteria) this;
        }

        public Criteria andOrderetimeNotBetween(Date value1, Date value2) {
            addCriterion("OrderETime not between", value1, value2, "orderetime");
            return (Criteria) this;
        }

        public Criteria andOrderstimeIsNull() {
            addCriterion("OrderSTime is null");
            return (Criteria) this;
        }

        public Criteria andOrderstimeIsNotNull() {
            addCriterion("OrderSTime is not null");
            return (Criteria) this;
        }

        public Criteria andOrderstimeEqualTo(Date value) {
            addCriterion("OrderSTime =", value, "orderstime");
            return (Criteria) this;
        }

        public Criteria andOrderstimeNotEqualTo(Date value) {
            addCriterion("OrderSTime <>", value, "orderstime");
            return (Criteria) this;
        }

        public Criteria andOrderstimeGreaterThan(Date value) {
            addCriterion("OrderSTime >", value, "orderstime");
            return (Criteria) this;
        }

        public Criteria andOrderstimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OrderSTime >=", value, "orderstime");
            return (Criteria) this;
        }

        public Criteria andOrderstimeLessThan(Date value) {
            addCriterion("OrderSTime <", value, "orderstime");
            return (Criteria) this;
        }

        public Criteria andOrderstimeLessThanOrEqualTo(Date value) {
            addCriterion("OrderSTime <=", value, "orderstime");
            return (Criteria) this;
        }

        public Criteria andOrderstimeIn(List<Date> values) {
            addCriterion("OrderSTime in", values, "orderstime");
            return (Criteria) this;
        }

        public Criteria andOrderstimeNotIn(List<Date> values) {
            addCriterion("OrderSTime not in", values, "orderstime");
            return (Criteria) this;
        }

        public Criteria andOrderstimeBetween(Date value1, Date value2) {
            addCriterion("OrderSTime between", value1, value2, "orderstime");
            return (Criteria) this;
        }

        public Criteria andOrderstimeNotBetween(Date value1, Date value2) {
            addCriterion("OrderSTime not between", value1, value2, "orderstime");
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