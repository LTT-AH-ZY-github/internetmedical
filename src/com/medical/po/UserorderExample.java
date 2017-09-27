package com.medical.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserorderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserorderExample() {
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

        public Criteria andUserorderidIsNull() {
            addCriterion("userOrderId is null");
            return (Criteria) this;
        }

        public Criteria andUserorderidIsNotNull() {
            addCriterion("userOrderId is not null");
            return (Criteria) this;
        }

        public Criteria andUserorderidEqualTo(Integer value) {
            addCriterion("userOrderId =", value, "userorderid");
            return (Criteria) this;
        }

        public Criteria andUserorderidNotEqualTo(Integer value) {
            addCriterion("userOrderId <>", value, "userorderid");
            return (Criteria) this;
        }

        public Criteria andUserorderidGreaterThan(Integer value) {
            addCriterion("userOrderId >", value, "userorderid");
            return (Criteria) this;
        }

        public Criteria andUserorderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("userOrderId >=", value, "userorderid");
            return (Criteria) this;
        }

        public Criteria andUserorderidLessThan(Integer value) {
            addCriterion("userOrderId <", value, "userorderid");
            return (Criteria) this;
        }

        public Criteria andUserorderidLessThanOrEqualTo(Integer value) {
            addCriterion("userOrderId <=", value, "userorderid");
            return (Criteria) this;
        }

        public Criteria andUserorderidIn(List<Integer> values) {
            addCriterion("userOrderId in", values, "userorderid");
            return (Criteria) this;
        }

        public Criteria andUserorderidNotIn(List<Integer> values) {
            addCriterion("userOrderId not in", values, "userorderid");
            return (Criteria) this;
        }

        public Criteria andUserorderidBetween(Integer value1, Integer value2) {
            addCriterion("userOrderId between", value1, value2, "userorderid");
            return (Criteria) this;
        }

        public Criteria andUserorderidNotBetween(Integer value1, Integer value2) {
            addCriterion("userOrderId not between", value1, value2, "userorderid");
            return (Criteria) this;
        }

        public Criteria andUserorderptimeIsNull() {
            addCriterion("userOrderPTime is null");
            return (Criteria) this;
        }

        public Criteria andUserorderptimeIsNotNull() {
            addCriterion("userOrderPTime is not null");
            return (Criteria) this;
        }

        public Criteria andUserorderptimeEqualTo(Date value) {
            addCriterion("userOrderPTime =", value, "userorderptime");
            return (Criteria) this;
        }

        public Criteria andUserorderptimeNotEqualTo(Date value) {
            addCriterion("userOrderPTime <>", value, "userorderptime");
            return (Criteria) this;
        }

        public Criteria andUserorderptimeGreaterThan(Date value) {
            addCriterion("userOrderPTime >", value, "userorderptime");
            return (Criteria) this;
        }

        public Criteria andUserorderptimeGreaterThanOrEqualTo(Date value) {
            addCriterion("userOrderPTime >=", value, "userorderptime");
            return (Criteria) this;
        }

        public Criteria andUserorderptimeLessThan(Date value) {
            addCriterion("userOrderPTime <", value, "userorderptime");
            return (Criteria) this;
        }

        public Criteria andUserorderptimeLessThanOrEqualTo(Date value) {
            addCriterion("userOrderPTime <=", value, "userorderptime");
            return (Criteria) this;
        }

        public Criteria andUserorderptimeIn(List<Date> values) {
            addCriterion("userOrderPTime in", values, "userorderptime");
            return (Criteria) this;
        }

        public Criteria andUserorderptimeNotIn(List<Date> values) {
            addCriterion("userOrderPTime not in", values, "userorderptime");
            return (Criteria) this;
        }

        public Criteria andUserorderptimeBetween(Date value1, Date value2) {
            addCriterion("userOrderPTime between", value1, value2, "userorderptime");
            return (Criteria) this;
        }

        public Criteria andUserorderptimeNotBetween(Date value1, Date value2) {
            addCriterion("userOrderPTime not between", value1, value2, "userorderptime");
            return (Criteria) this;
        }

        public Criteria andUserorderrtimeIsNull() {
            addCriterion("userOrderRTime is null");
            return (Criteria) this;
        }

        public Criteria andUserorderrtimeIsNotNull() {
            addCriterion("userOrderRTime is not null");
            return (Criteria) this;
        }

        public Criteria andUserorderrtimeEqualTo(Date value) {
            addCriterion("userOrderRTime =", value, "userorderrtime");
            return (Criteria) this;
        }

        public Criteria andUserorderrtimeNotEqualTo(Date value) {
            addCriterion("userOrderRTime <>", value, "userorderrtime");
            return (Criteria) this;
        }

        public Criteria andUserorderrtimeGreaterThan(Date value) {
            addCriterion("userOrderRTime >", value, "userorderrtime");
            return (Criteria) this;
        }

        public Criteria andUserorderrtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("userOrderRTime >=", value, "userorderrtime");
            return (Criteria) this;
        }

        public Criteria andUserorderrtimeLessThan(Date value) {
            addCriterion("userOrderRTime <", value, "userorderrtime");
            return (Criteria) this;
        }

        public Criteria andUserorderrtimeLessThanOrEqualTo(Date value) {
            addCriterion("userOrderRTime <=", value, "userorderrtime");
            return (Criteria) this;
        }

        public Criteria andUserorderrtimeIn(List<Date> values) {
            addCriterion("userOrderRTime in", values, "userorderrtime");
            return (Criteria) this;
        }

        public Criteria andUserorderrtimeNotIn(List<Date> values) {
            addCriterion("userOrderRTime not in", values, "userorderrtime");
            return (Criteria) this;
        }

        public Criteria andUserorderrtimeBetween(Date value1, Date value2) {
            addCriterion("userOrderRTime between", value1, value2, "userorderrtime");
            return (Criteria) this;
        }

        public Criteria andUserorderrtimeNotBetween(Date value1, Date value2) {
            addCriterion("userOrderRTime not between", value1, value2, "userorderrtime");
            return (Criteria) this;
        }

        public Criteria andUserorderetimeIsNull() {
            addCriterion("userOrderETime is null");
            return (Criteria) this;
        }

        public Criteria andUserorderetimeIsNotNull() {
            addCriterion("userOrderETime is not null");
            return (Criteria) this;
        }

        public Criteria andUserorderetimeEqualTo(Date value) {
            addCriterion("userOrderETime =", value, "userorderetime");
            return (Criteria) this;
        }

        public Criteria andUserorderetimeNotEqualTo(Date value) {
            addCriterion("userOrderETime <>", value, "userorderetime");
            return (Criteria) this;
        }

        public Criteria andUserorderetimeGreaterThan(Date value) {
            addCriterion("userOrderETime >", value, "userorderetime");
            return (Criteria) this;
        }

        public Criteria andUserorderetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("userOrderETime >=", value, "userorderetime");
            return (Criteria) this;
        }

        public Criteria andUserorderetimeLessThan(Date value) {
            addCriterion("userOrderETime <", value, "userorderetime");
            return (Criteria) this;
        }

        public Criteria andUserorderetimeLessThanOrEqualTo(Date value) {
            addCriterion("userOrderETime <=", value, "userorderetime");
            return (Criteria) this;
        }

        public Criteria andUserorderetimeIn(List<Date> values) {
            addCriterion("userOrderETime in", values, "userorderetime");
            return (Criteria) this;
        }

        public Criteria andUserorderetimeNotIn(List<Date> values) {
            addCriterion("userOrderETime not in", values, "userorderetime");
            return (Criteria) this;
        }

        public Criteria andUserorderetimeBetween(Date value1, Date value2) {
            addCriterion("userOrderETime between", value1, value2, "userorderetime");
            return (Criteria) this;
        }

        public Criteria andUserorderetimeNotBetween(Date value1, Date value2) {
            addCriterion("userOrderETime not between", value1, value2, "userorderetime");
            return (Criteria) this;
        }

        public Criteria andUserorderappointmentIsNull() {
            addCriterion("userOrderAppointment is null");
            return (Criteria) this;
        }

        public Criteria andUserorderappointmentIsNotNull() {
            addCriterion("userOrderAppointment is not null");
            return (Criteria) this;
        }

        public Criteria andUserorderappointmentEqualTo(String value) {
            addCriterion("userOrderAppointment =", value, "userorderappointment");
            return (Criteria) this;
        }

        public Criteria andUserorderappointmentNotEqualTo(String value) {
            addCriterion("userOrderAppointment <>", value, "userorderappointment");
            return (Criteria) this;
        }

        public Criteria andUserorderappointmentGreaterThan(String value) {
            addCriterion("userOrderAppointment >", value, "userorderappointment");
            return (Criteria) this;
        }

        public Criteria andUserorderappointmentGreaterThanOrEqualTo(String value) {
            addCriterion("userOrderAppointment >=", value, "userorderappointment");
            return (Criteria) this;
        }

        public Criteria andUserorderappointmentLessThan(String value) {
            addCriterion("userOrderAppointment <", value, "userorderappointment");
            return (Criteria) this;
        }

        public Criteria andUserorderappointmentLessThanOrEqualTo(String value) {
            addCriterion("userOrderAppointment <=", value, "userorderappointment");
            return (Criteria) this;
        }

        public Criteria andUserorderappointmentLike(String value) {
            addCriterion("userOrderAppointment like", value, "userorderappointment");
            return (Criteria) this;
        }

        public Criteria andUserorderappointmentNotLike(String value) {
            addCriterion("userOrderAppointment not like", value, "userorderappointment");
            return (Criteria) this;
        }

        public Criteria andUserorderappointmentIn(List<String> values) {
            addCriterion("userOrderAppointment in", values, "userorderappointment");
            return (Criteria) this;
        }

        public Criteria andUserorderappointmentNotIn(List<String> values) {
            addCriterion("userOrderAppointment not in", values, "userorderappointment");
            return (Criteria) this;
        }

        public Criteria andUserorderappointmentBetween(String value1, String value2) {
            addCriterion("userOrderAppointment between", value1, value2, "userorderappointment");
            return (Criteria) this;
        }

        public Criteria andUserorderappointmentNotBetween(String value1, String value2) {
            addCriterion("userOrderAppointment not between", value1, value2, "userorderappointment");
            return (Criteria) this;
        }

        public Criteria andUserorderdocloginidIsNull() {
            addCriterion("userOrderDocLoginId is null");
            return (Criteria) this;
        }

        public Criteria andUserorderdocloginidIsNotNull() {
            addCriterion("userOrderDocLoginId is not null");
            return (Criteria) this;
        }

        public Criteria andUserorderdocloginidEqualTo(Integer value) {
            addCriterion("userOrderDocLoginId =", value, "userorderdocloginid");
            return (Criteria) this;
        }

        public Criteria andUserorderdocloginidNotEqualTo(Integer value) {
            addCriterion("userOrderDocLoginId <>", value, "userorderdocloginid");
            return (Criteria) this;
        }

        public Criteria andUserorderdocloginidGreaterThan(Integer value) {
            addCriterion("userOrderDocLoginId >", value, "userorderdocloginid");
            return (Criteria) this;
        }

        public Criteria andUserorderdocloginidGreaterThanOrEqualTo(Integer value) {
            addCriterion("userOrderDocLoginId >=", value, "userorderdocloginid");
            return (Criteria) this;
        }

        public Criteria andUserorderdocloginidLessThan(Integer value) {
            addCriterion("userOrderDocLoginId <", value, "userorderdocloginid");
            return (Criteria) this;
        }

        public Criteria andUserorderdocloginidLessThanOrEqualTo(Integer value) {
            addCriterion("userOrderDocLoginId <=", value, "userorderdocloginid");
            return (Criteria) this;
        }

        public Criteria andUserorderdocloginidIn(List<Integer> values) {
            addCriterion("userOrderDocLoginId in", values, "userorderdocloginid");
            return (Criteria) this;
        }

        public Criteria andUserorderdocloginidNotIn(List<Integer> values) {
            addCriterion("userOrderDocLoginId not in", values, "userorderdocloginid");
            return (Criteria) this;
        }

        public Criteria andUserorderdocloginidBetween(Integer value1, Integer value2) {
            addCriterion("userOrderDocLoginId between", value1, value2, "userorderdocloginid");
            return (Criteria) this;
        }

        public Criteria andUserorderdocloginidNotBetween(Integer value1, Integer value2) {
            addCriterion("userOrderDocLoginId not between", value1, value2, "userorderdocloginid");
            return (Criteria) this;
        }

        public Criteria andUserorderrecdocloginidIsNull() {
            addCriterion("userOrderRecDocLoginId is null");
            return (Criteria) this;
        }

        public Criteria andUserorderrecdocloginidIsNotNull() {
            addCriterion("userOrderRecDocLoginId is not null");
            return (Criteria) this;
        }

        public Criteria andUserorderrecdocloginidEqualTo(Integer value) {
            addCriterion("userOrderRecDocLoginId =", value, "userorderrecdocloginid");
            return (Criteria) this;
        }

        public Criteria andUserorderrecdocloginidNotEqualTo(Integer value) {
            addCriterion("userOrderRecDocLoginId <>", value, "userorderrecdocloginid");
            return (Criteria) this;
        }

        public Criteria andUserorderrecdocloginidGreaterThan(Integer value) {
            addCriterion("userOrderRecDocLoginId >", value, "userorderrecdocloginid");
            return (Criteria) this;
        }

        public Criteria andUserorderrecdocloginidGreaterThanOrEqualTo(Integer value) {
            addCriterion("userOrderRecDocLoginId >=", value, "userorderrecdocloginid");
            return (Criteria) this;
        }

        public Criteria andUserorderrecdocloginidLessThan(Integer value) {
            addCriterion("userOrderRecDocLoginId <", value, "userorderrecdocloginid");
            return (Criteria) this;
        }

        public Criteria andUserorderrecdocloginidLessThanOrEqualTo(Integer value) {
            addCriterion("userOrderRecDocLoginId <=", value, "userorderrecdocloginid");
            return (Criteria) this;
        }

        public Criteria andUserorderrecdocloginidIn(List<Integer> values) {
            addCriterion("userOrderRecDocLoginId in", values, "userorderrecdocloginid");
            return (Criteria) this;
        }

        public Criteria andUserorderrecdocloginidNotIn(List<Integer> values) {
            addCriterion("userOrderRecDocLoginId not in", values, "userorderrecdocloginid");
            return (Criteria) this;
        }

        public Criteria andUserorderrecdocloginidBetween(Integer value1, Integer value2) {
            addCriterion("userOrderRecDocLoginId between", value1, value2, "userorderrecdocloginid");
            return (Criteria) this;
        }

        public Criteria andUserorderrecdocloginidNotBetween(Integer value1, Integer value2) {
            addCriterion("userOrderRecDocLoginId not between", value1, value2, "userorderrecdocloginid");
            return (Criteria) this;
        }

        public Criteria andUserorderstateidIsNull() {
            addCriterion("userOrderStateId is null");
            return (Criteria) this;
        }

        public Criteria andUserorderstateidIsNotNull() {
            addCriterion("userOrderStateId is not null");
            return (Criteria) this;
        }

        public Criteria andUserorderstateidEqualTo(Integer value) {
            addCriterion("userOrderStateId =", value, "userorderstateid");
            return (Criteria) this;
        }

        public Criteria andUserorderstateidNotEqualTo(Integer value) {
            addCriterion("userOrderStateId <>", value, "userorderstateid");
            return (Criteria) this;
        }

        public Criteria andUserorderstateidGreaterThan(Integer value) {
            addCriterion("userOrderStateId >", value, "userorderstateid");
            return (Criteria) this;
        }

        public Criteria andUserorderstateidGreaterThanOrEqualTo(Integer value) {
            addCriterion("userOrderStateId >=", value, "userorderstateid");
            return (Criteria) this;
        }

        public Criteria andUserorderstateidLessThan(Integer value) {
            addCriterion("userOrderStateId <", value, "userorderstateid");
            return (Criteria) this;
        }

        public Criteria andUserorderstateidLessThanOrEqualTo(Integer value) {
            addCriterion("userOrderStateId <=", value, "userorderstateid");
            return (Criteria) this;
        }

        public Criteria andUserorderstateidIn(List<Integer> values) {
            addCriterion("userOrderStateId in", values, "userorderstateid");
            return (Criteria) this;
        }

        public Criteria andUserorderstateidNotIn(List<Integer> values) {
            addCriterion("userOrderStateId not in", values, "userorderstateid");
            return (Criteria) this;
        }

        public Criteria andUserorderstateidBetween(Integer value1, Integer value2) {
            addCriterion("userOrderStateId between", value1, value2, "userorderstateid");
            return (Criteria) this;
        }

        public Criteria andUserorderstateidNotBetween(Integer value1, Integer value2) {
            addCriterion("userOrderStateId not between", value1, value2, "userorderstateid");
            return (Criteria) this;
        }

        public Criteria andUserorderhospidIsNull() {
            addCriterion("userOrderHospId is null");
            return (Criteria) this;
        }

        public Criteria andUserorderhospidIsNotNull() {
            addCriterion("userOrderHospId is not null");
            return (Criteria) this;
        }

        public Criteria andUserorderhospidEqualTo(Integer value) {
            addCriterion("userOrderHospId =", value, "userorderhospid");
            return (Criteria) this;
        }

        public Criteria andUserorderhospidNotEqualTo(Integer value) {
            addCriterion("userOrderHospId <>", value, "userorderhospid");
            return (Criteria) this;
        }

        public Criteria andUserorderhospidGreaterThan(Integer value) {
            addCriterion("userOrderHospId >", value, "userorderhospid");
            return (Criteria) this;
        }

        public Criteria andUserorderhospidGreaterThanOrEqualTo(Integer value) {
            addCriterion("userOrderHospId >=", value, "userorderhospid");
            return (Criteria) this;
        }

        public Criteria andUserorderhospidLessThan(Integer value) {
            addCriterion("userOrderHospId <", value, "userorderhospid");
            return (Criteria) this;
        }

        public Criteria andUserorderhospidLessThanOrEqualTo(Integer value) {
            addCriterion("userOrderHospId <=", value, "userorderhospid");
            return (Criteria) this;
        }

        public Criteria andUserorderhospidIn(List<Integer> values) {
            addCriterion("userOrderHospId in", values, "userorderhospid");
            return (Criteria) this;
        }

        public Criteria andUserorderhospidNotIn(List<Integer> values) {
            addCriterion("userOrderHospId not in", values, "userorderhospid");
            return (Criteria) this;
        }

        public Criteria andUserorderhospidBetween(Integer value1, Integer value2) {
            addCriterion("userOrderHospId between", value1, value2, "userorderhospid");
            return (Criteria) this;
        }

        public Criteria andUserorderhospidNotBetween(Integer value1, Integer value2) {
            addCriterion("userOrderHospId not between", value1, value2, "userorderhospid");
            return (Criteria) this;
        }

        public Criteria andUserorderdpriceIsNull() {
            addCriterion("userOrderDPrice is null");
            return (Criteria) this;
        }

        public Criteria andUserorderdpriceIsNotNull() {
            addCriterion("userOrderDPrice is not null");
            return (Criteria) this;
        }

        public Criteria andUserorderdpriceEqualTo(BigDecimal value) {
            addCriterion("userOrderDPrice =", value, "userorderdprice");
            return (Criteria) this;
        }

        public Criteria andUserorderdpriceNotEqualTo(BigDecimal value) {
            addCriterion("userOrderDPrice <>", value, "userorderdprice");
            return (Criteria) this;
        }

        public Criteria andUserorderdpriceGreaterThan(BigDecimal value) {
            addCriterion("userOrderDPrice >", value, "userorderdprice");
            return (Criteria) this;
        }

        public Criteria andUserorderdpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("userOrderDPrice >=", value, "userorderdprice");
            return (Criteria) this;
        }

        public Criteria andUserorderdpriceLessThan(BigDecimal value) {
            addCriterion("userOrderDPrice <", value, "userorderdprice");
            return (Criteria) this;
        }

        public Criteria andUserorderdpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("userOrderDPrice <=", value, "userorderdprice");
            return (Criteria) this;
        }

        public Criteria andUserorderdpriceIn(List<BigDecimal> values) {
            addCriterion("userOrderDPrice in", values, "userorderdprice");
            return (Criteria) this;
        }

        public Criteria andUserorderdpriceNotIn(List<BigDecimal> values) {
            addCriterion("userOrderDPrice not in", values, "userorderdprice");
            return (Criteria) this;
        }

        public Criteria andUserorderdpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("userOrderDPrice between", value1, value2, "userorderdprice");
            return (Criteria) this;
        }

        public Criteria andUserorderdpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("userOrderDPrice not between", value1, value2, "userorderdprice");
            return (Criteria) this;
        }

        public Criteria andUserorderhstateIsNull() {
            addCriterion("userOrderHState is null");
            return (Criteria) this;
        }

        public Criteria andUserorderhstateIsNotNull() {
            addCriterion("userOrderHState is not null");
            return (Criteria) this;
        }

        public Criteria andUserorderhstateEqualTo(Byte value) {
            addCriterion("userOrderHState =", value, "userorderhstate");
            return (Criteria) this;
        }

        public Criteria andUserorderhstateNotEqualTo(Byte value) {
            addCriterion("userOrderHState <>", value, "userorderhstate");
            return (Criteria) this;
        }

        public Criteria andUserorderhstateGreaterThan(Byte value) {
            addCriterion("userOrderHState >", value, "userorderhstate");
            return (Criteria) this;
        }

        public Criteria andUserorderhstateGreaterThanOrEqualTo(Byte value) {
            addCriterion("userOrderHState >=", value, "userorderhstate");
            return (Criteria) this;
        }

        public Criteria andUserorderhstateLessThan(Byte value) {
            addCriterion("userOrderHState <", value, "userorderhstate");
            return (Criteria) this;
        }

        public Criteria andUserorderhstateLessThanOrEqualTo(Byte value) {
            addCriterion("userOrderHState <=", value, "userorderhstate");
            return (Criteria) this;
        }

        public Criteria andUserorderhstateIn(List<Byte> values) {
            addCriterion("userOrderHState in", values, "userorderhstate");
            return (Criteria) this;
        }

        public Criteria andUserorderhstateNotIn(List<Byte> values) {
            addCriterion("userOrderHState not in", values, "userorderhstate");
            return (Criteria) this;
        }

        public Criteria andUserorderhstateBetween(Byte value1, Byte value2) {
            addCriterion("userOrderHState between", value1, value2, "userorderhstate");
            return (Criteria) this;
        }

        public Criteria andUserorderhstateNotBetween(Byte value1, Byte value2) {
            addCriterion("userOrderHState not between", value1, value2, "userorderhstate");
            return (Criteria) this;
        }

        public Criteria andUserorderhpriceIsNull() {
            addCriterion("userOrderHPrice is null");
            return (Criteria) this;
        }

        public Criteria andUserorderhpriceIsNotNull() {
            addCriterion("userOrderHPrice is not null");
            return (Criteria) this;
        }

        public Criteria andUserorderhpriceEqualTo(BigDecimal value) {
            addCriterion("userOrderHPrice =", value, "userorderhprice");
            return (Criteria) this;
        }

        public Criteria andUserorderhpriceNotEqualTo(BigDecimal value) {
            addCriterion("userOrderHPrice <>", value, "userorderhprice");
            return (Criteria) this;
        }

        public Criteria andUserorderhpriceGreaterThan(BigDecimal value) {
            addCriterion("userOrderHPrice >", value, "userorderhprice");
            return (Criteria) this;
        }

        public Criteria andUserorderhpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("userOrderHPrice >=", value, "userorderhprice");
            return (Criteria) this;
        }

        public Criteria andUserorderhpriceLessThan(BigDecimal value) {
            addCriterion("userOrderHPrice <", value, "userorderhprice");
            return (Criteria) this;
        }

        public Criteria andUserorderhpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("userOrderHPrice <=", value, "userorderhprice");
            return (Criteria) this;
        }

        public Criteria andUserorderhpriceIn(List<BigDecimal> values) {
            addCriterion("userOrderHPrice in", values, "userorderhprice");
            return (Criteria) this;
        }

        public Criteria andUserorderhpriceNotIn(List<BigDecimal> values) {
            addCriterion("userOrderHPrice not in", values, "userorderhprice");
            return (Criteria) this;
        }

        public Criteria andUserorderhpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("userOrderHPrice between", value1, value2, "userorderhprice");
            return (Criteria) this;
        }

        public Criteria andUserorderhpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("userOrderHPrice not between", value1, value2, "userorderhprice");
            return (Criteria) this;
        }

        public Criteria andUserordertpricetypeIsNull() {
            addCriterion("userOrderTPriceType is null");
            return (Criteria) this;
        }

        public Criteria andUserordertpricetypeIsNotNull() {
            addCriterion("userOrderTPriceType is not null");
            return (Criteria) this;
        }

        public Criteria andUserordertpricetypeEqualTo(Integer value) {
            addCriterion("userOrderTPriceType =", value, "userordertpricetype");
            return (Criteria) this;
        }

        public Criteria andUserordertpricetypeNotEqualTo(Integer value) {
            addCriterion("userOrderTPriceType <>", value, "userordertpricetype");
            return (Criteria) this;
        }

        public Criteria andUserordertpricetypeGreaterThan(Integer value) {
            addCriterion("userOrderTPriceType >", value, "userordertpricetype");
            return (Criteria) this;
        }

        public Criteria andUserordertpricetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("userOrderTPriceType >=", value, "userordertpricetype");
            return (Criteria) this;
        }

        public Criteria andUserordertpricetypeLessThan(Integer value) {
            addCriterion("userOrderTPriceType <", value, "userordertpricetype");
            return (Criteria) this;
        }

        public Criteria andUserordertpricetypeLessThanOrEqualTo(Integer value) {
            addCriterion("userOrderTPriceType <=", value, "userordertpricetype");
            return (Criteria) this;
        }

        public Criteria andUserordertpricetypeIn(List<Integer> values) {
            addCriterion("userOrderTPriceType in", values, "userordertpricetype");
            return (Criteria) this;
        }

        public Criteria andUserordertpricetypeNotIn(List<Integer> values) {
            addCriterion("userOrderTPriceType not in", values, "userordertpricetype");
            return (Criteria) this;
        }

        public Criteria andUserordertpricetypeBetween(Integer value1, Integer value2) {
            addCriterion("userOrderTPriceType between", value1, value2, "userordertpricetype");
            return (Criteria) this;
        }

        public Criteria andUserordertpricetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("userOrderTPriceType not between", value1, value2, "userordertpricetype");
            return (Criteria) this;
        }

        public Criteria andUserordertpriceIsNull() {
            addCriterion("userOrderTPrice is null");
            return (Criteria) this;
        }

        public Criteria andUserordertpriceIsNotNull() {
            addCriterion("userOrderTPrice is not null");
            return (Criteria) this;
        }

        public Criteria andUserordertpriceEqualTo(BigDecimal value) {
            addCriterion("userOrderTPrice =", value, "userordertprice");
            return (Criteria) this;
        }

        public Criteria andUserordertpriceNotEqualTo(BigDecimal value) {
            addCriterion("userOrderTPrice <>", value, "userordertprice");
            return (Criteria) this;
        }

        public Criteria andUserordertpriceGreaterThan(BigDecimal value) {
            addCriterion("userOrderTPrice >", value, "userordertprice");
            return (Criteria) this;
        }

        public Criteria andUserordertpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("userOrderTPrice >=", value, "userordertprice");
            return (Criteria) this;
        }

        public Criteria andUserordertpriceLessThan(BigDecimal value) {
            addCriterion("userOrderTPrice <", value, "userordertprice");
            return (Criteria) this;
        }

        public Criteria andUserordertpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("userOrderTPrice <=", value, "userordertprice");
            return (Criteria) this;
        }

        public Criteria andUserordertpriceIn(List<BigDecimal> values) {
            addCriterion("userOrderTPrice in", values, "userordertprice");
            return (Criteria) this;
        }

        public Criteria andUserordertpriceNotIn(List<BigDecimal> values) {
            addCriterion("userOrderTPrice not in", values, "userordertprice");
            return (Criteria) this;
        }

        public Criteria andUserordertpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("userOrderTPrice between", value1, value2, "userordertprice");
            return (Criteria) this;
        }

        public Criteria andUserordertpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("userOrderTPrice not between", value1, value2, "userordertprice");
            return (Criteria) this;
        }

        public Criteria andUserorderapricetypeIsNull() {
            addCriterion("userOrderAPriceType is null");
            return (Criteria) this;
        }

        public Criteria andUserorderapricetypeIsNotNull() {
            addCriterion("userOrderAPriceType is not null");
            return (Criteria) this;
        }

        public Criteria andUserorderapricetypeEqualTo(Integer value) {
            addCriterion("userOrderAPriceType =", value, "userorderapricetype");
            return (Criteria) this;
        }

        public Criteria andUserorderapricetypeNotEqualTo(Integer value) {
            addCriterion("userOrderAPriceType <>", value, "userorderapricetype");
            return (Criteria) this;
        }

        public Criteria andUserorderapricetypeGreaterThan(Integer value) {
            addCriterion("userOrderAPriceType >", value, "userorderapricetype");
            return (Criteria) this;
        }

        public Criteria andUserorderapricetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("userOrderAPriceType >=", value, "userorderapricetype");
            return (Criteria) this;
        }

        public Criteria andUserorderapricetypeLessThan(Integer value) {
            addCriterion("userOrderAPriceType <", value, "userorderapricetype");
            return (Criteria) this;
        }

        public Criteria andUserorderapricetypeLessThanOrEqualTo(Integer value) {
            addCriterion("userOrderAPriceType <=", value, "userorderapricetype");
            return (Criteria) this;
        }

        public Criteria andUserorderapricetypeIn(List<Integer> values) {
            addCriterion("userOrderAPriceType in", values, "userorderapricetype");
            return (Criteria) this;
        }

        public Criteria andUserorderapricetypeNotIn(List<Integer> values) {
            addCriterion("userOrderAPriceType not in", values, "userorderapricetype");
            return (Criteria) this;
        }

        public Criteria andUserorderapricetypeBetween(Integer value1, Integer value2) {
            addCriterion("userOrderAPriceType between", value1, value2, "userorderapricetype");
            return (Criteria) this;
        }

        public Criteria andUserorderapricetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("userOrderAPriceType not between", value1, value2, "userorderapricetype");
            return (Criteria) this;
        }

        public Criteria andUserorderapriceIsNull() {
            addCriterion("userOrderAPrice is null");
            return (Criteria) this;
        }

        public Criteria andUserorderapriceIsNotNull() {
            addCriterion("userOrderAPrice is not null");
            return (Criteria) this;
        }

        public Criteria andUserorderapriceEqualTo(BigDecimal value) {
            addCriterion("userOrderAPrice =", value, "userorderaprice");
            return (Criteria) this;
        }

        public Criteria andUserorderapriceNotEqualTo(BigDecimal value) {
            addCriterion("userOrderAPrice <>", value, "userorderaprice");
            return (Criteria) this;
        }

        public Criteria andUserorderapriceGreaterThan(BigDecimal value) {
            addCriterion("userOrderAPrice >", value, "userorderaprice");
            return (Criteria) this;
        }

        public Criteria andUserorderapriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("userOrderAPrice >=", value, "userorderaprice");
            return (Criteria) this;
        }

        public Criteria andUserorderapriceLessThan(BigDecimal value) {
            addCriterion("userOrderAPrice <", value, "userorderaprice");
            return (Criteria) this;
        }

        public Criteria andUserorderapriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("userOrderAPrice <=", value, "userorderaprice");
            return (Criteria) this;
        }

        public Criteria andUserorderapriceIn(List<BigDecimal> values) {
            addCriterion("userOrderAPrice in", values, "userorderaprice");
            return (Criteria) this;
        }

        public Criteria andUserorderapriceNotIn(List<BigDecimal> values) {
            addCriterion("userOrderAPrice not in", values, "userorderaprice");
            return (Criteria) this;
        }

        public Criteria andUserorderapriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("userOrderAPrice between", value1, value2, "userorderaprice");
            return (Criteria) this;
        }

        public Criteria andUserorderapriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("userOrderAPrice not between", value1, value2, "userorderaprice");
            return (Criteria) this;
        }

        public Criteria andUserorderepricetypeIsNull() {
            addCriterion("userOrderEPriceType is null");
            return (Criteria) this;
        }

        public Criteria andUserorderepricetypeIsNotNull() {
            addCriterion("userOrderEPriceType is not null");
            return (Criteria) this;
        }

        public Criteria andUserorderepricetypeEqualTo(Integer value) {
            addCriterion("userOrderEPriceType =", value, "userorderepricetype");
            return (Criteria) this;
        }

        public Criteria andUserorderepricetypeNotEqualTo(Integer value) {
            addCriterion("userOrderEPriceType <>", value, "userorderepricetype");
            return (Criteria) this;
        }

        public Criteria andUserorderepricetypeGreaterThan(Integer value) {
            addCriterion("userOrderEPriceType >", value, "userorderepricetype");
            return (Criteria) this;
        }

        public Criteria andUserorderepricetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("userOrderEPriceType >=", value, "userorderepricetype");
            return (Criteria) this;
        }

        public Criteria andUserorderepricetypeLessThan(Integer value) {
            addCriterion("userOrderEPriceType <", value, "userorderepricetype");
            return (Criteria) this;
        }

        public Criteria andUserorderepricetypeLessThanOrEqualTo(Integer value) {
            addCriterion("userOrderEPriceType <=", value, "userorderepricetype");
            return (Criteria) this;
        }

        public Criteria andUserorderepricetypeIn(List<Integer> values) {
            addCriterion("userOrderEPriceType in", values, "userorderepricetype");
            return (Criteria) this;
        }

        public Criteria andUserorderepricetypeNotIn(List<Integer> values) {
            addCriterion("userOrderEPriceType not in", values, "userorderepricetype");
            return (Criteria) this;
        }

        public Criteria andUserorderepricetypeBetween(Integer value1, Integer value2) {
            addCriterion("userOrderEPriceType between", value1, value2, "userorderepricetype");
            return (Criteria) this;
        }

        public Criteria andUserorderepricetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("userOrderEPriceType not between", value1, value2, "userorderepricetype");
            return (Criteria) this;
        }

        public Criteria andUserorderepriceIsNull() {
            addCriterion("userOrderEPrice is null");
            return (Criteria) this;
        }

        public Criteria andUserorderepriceIsNotNull() {
            addCriterion("userOrderEPrice is not null");
            return (Criteria) this;
        }

        public Criteria andUserorderepriceEqualTo(BigDecimal value) {
            addCriterion("userOrderEPrice =", value, "userordereprice");
            return (Criteria) this;
        }

        public Criteria andUserorderepriceNotEqualTo(BigDecimal value) {
            addCriterion("userOrderEPrice <>", value, "userordereprice");
            return (Criteria) this;
        }

        public Criteria andUserorderepriceGreaterThan(BigDecimal value) {
            addCriterion("userOrderEPrice >", value, "userordereprice");
            return (Criteria) this;
        }

        public Criteria andUserorderepriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("userOrderEPrice >=", value, "userordereprice");
            return (Criteria) this;
        }

        public Criteria andUserorderepriceLessThan(BigDecimal value) {
            addCriterion("userOrderEPrice <", value, "userordereprice");
            return (Criteria) this;
        }

        public Criteria andUserorderepriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("userOrderEPrice <=", value, "userordereprice");
            return (Criteria) this;
        }

        public Criteria andUserorderepriceIn(List<BigDecimal> values) {
            addCriterion("userOrderEPrice in", values, "userordereprice");
            return (Criteria) this;
        }

        public Criteria andUserorderepriceNotIn(List<BigDecimal> values) {
            addCriterion("userOrderEPrice not in", values, "userordereprice");
            return (Criteria) this;
        }

        public Criteria andUserorderepriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("userOrderEPrice between", value1, value2, "userordereprice");
            return (Criteria) this;
        }

        public Criteria andUserorderepriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("userOrderEPrice not between", value1, value2, "userordereprice");
            return (Criteria) this;
        }

        public Criteria andUserorderpriceIsNull() {
            addCriterion("userOrderPrice is null");
            return (Criteria) this;
        }

        public Criteria andUserorderpriceIsNotNull() {
            addCriterion("userOrderPrice is not null");
            return (Criteria) this;
        }

        public Criteria andUserorderpriceEqualTo(BigDecimal value) {
            addCriterion("userOrderPrice =", value, "userorderprice");
            return (Criteria) this;
        }

        public Criteria andUserorderpriceNotEqualTo(BigDecimal value) {
            addCriterion("userOrderPrice <>", value, "userorderprice");
            return (Criteria) this;
        }

        public Criteria andUserorderpriceGreaterThan(BigDecimal value) {
            addCriterion("userOrderPrice >", value, "userorderprice");
            return (Criteria) this;
        }

        public Criteria andUserorderpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("userOrderPrice >=", value, "userorderprice");
            return (Criteria) this;
        }

        public Criteria andUserorderpriceLessThan(BigDecimal value) {
            addCriterion("userOrderPrice <", value, "userorderprice");
            return (Criteria) this;
        }

        public Criteria andUserorderpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("userOrderPrice <=", value, "userorderprice");
            return (Criteria) this;
        }

        public Criteria andUserorderpriceIn(List<BigDecimal> values) {
            addCriterion("userOrderPrice in", values, "userorderprice");
            return (Criteria) this;
        }

        public Criteria andUserorderpriceNotIn(List<BigDecimal> values) {
            addCriterion("userOrderPrice not in", values, "userorderprice");
            return (Criteria) this;
        }

        public Criteria andUserorderpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("userOrderPrice between", value1, value2, "userorderprice");
            return (Criteria) this;
        }

        public Criteria andUserorderpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("userOrderPrice not between", value1, value2, "userorderprice");
            return (Criteria) this;
        }

        public Criteria andUserorderdepositIsNull() {
            addCriterion("userOrderDeposit is null");
            return (Criteria) this;
        }

        public Criteria andUserorderdepositIsNotNull() {
            addCriterion("userOrderDeposit is not null");
            return (Criteria) this;
        }

        public Criteria andUserorderdepositEqualTo(BigDecimal value) {
            addCriterion("userOrderDeposit =", value, "userorderdeposit");
            return (Criteria) this;
        }

        public Criteria andUserorderdepositNotEqualTo(BigDecimal value) {
            addCriterion("userOrderDeposit <>", value, "userorderdeposit");
            return (Criteria) this;
        }

        public Criteria andUserorderdepositGreaterThan(BigDecimal value) {
            addCriterion("userOrderDeposit >", value, "userorderdeposit");
            return (Criteria) this;
        }

        public Criteria andUserorderdepositGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("userOrderDeposit >=", value, "userorderdeposit");
            return (Criteria) this;
        }

        public Criteria andUserorderdepositLessThan(BigDecimal value) {
            addCriterion("userOrderDeposit <", value, "userorderdeposit");
            return (Criteria) this;
        }

        public Criteria andUserorderdepositLessThanOrEqualTo(BigDecimal value) {
            addCriterion("userOrderDeposit <=", value, "userorderdeposit");
            return (Criteria) this;
        }

        public Criteria andUserorderdepositIn(List<BigDecimal> values) {
            addCriterion("userOrderDeposit in", values, "userorderdeposit");
            return (Criteria) this;
        }

        public Criteria andUserorderdepositNotIn(List<BigDecimal> values) {
            addCriterion("userOrderDeposit not in", values, "userorderdeposit");
            return (Criteria) this;
        }

        public Criteria andUserorderdepositBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("userOrderDeposit between", value1, value2, "userorderdeposit");
            return (Criteria) this;
        }

        public Criteria andUserorderdepositNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("userOrderDeposit not between", value1, value2, "userorderdeposit");
            return (Criteria) this;
        }

        public Criteria andUsersickidIsNull() {
            addCriterion("userSickId is null");
            return (Criteria) this;
        }

        public Criteria andUsersickidIsNotNull() {
            addCriterion("userSickId is not null");
            return (Criteria) this;
        }

        public Criteria andUsersickidEqualTo(Integer value) {
            addCriterion("userSickId =", value, "usersickid");
            return (Criteria) this;
        }

        public Criteria andUsersickidNotEqualTo(Integer value) {
            addCriterion("userSickId <>", value, "usersickid");
            return (Criteria) this;
        }

        public Criteria andUsersickidGreaterThan(Integer value) {
            addCriterion("userSickId >", value, "usersickid");
            return (Criteria) this;
        }

        public Criteria andUsersickidGreaterThanOrEqualTo(Integer value) {
            addCriterion("userSickId >=", value, "usersickid");
            return (Criteria) this;
        }

        public Criteria andUsersickidLessThan(Integer value) {
            addCriterion("userSickId <", value, "usersickid");
            return (Criteria) this;
        }

        public Criteria andUsersickidLessThanOrEqualTo(Integer value) {
            addCriterion("userSickId <=", value, "usersickid");
            return (Criteria) this;
        }

        public Criteria andUsersickidIn(List<Integer> values) {
            addCriterion("userSickId in", values, "usersickid");
            return (Criteria) this;
        }

        public Criteria andUsersickidNotIn(List<Integer> values) {
            addCriterion("userSickId not in", values, "usersickid");
            return (Criteria) this;
        }

        public Criteria andUsersickidBetween(Integer value1, Integer value2) {
            addCriterion("userSickId between", value1, value2, "usersickid");
            return (Criteria) this;
        }

        public Criteria andUsersickidNotBetween(Integer value1, Integer value2) {
            addCriterion("userSickId not between", value1, value2, "usersickid");
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