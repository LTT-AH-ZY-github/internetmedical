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

        public Criteria andUserorderactualhospitalizationidIsNull() {
            addCriterion("userOrderActualHospitalizationId is null");
            return (Criteria) this;
        }

        public Criteria andUserorderactualhospitalizationidIsNotNull() {
            addCriterion("userOrderActualHospitalizationId is not null");
            return (Criteria) this;
        }

        public Criteria andUserorderactualhospitalizationidEqualTo(Integer value) {
            addCriterion("userOrderActualHospitalizationId =", value, "userorderactualhospitalizationid");
            return (Criteria) this;
        }

        public Criteria andUserorderactualhospitalizationidNotEqualTo(Integer value) {
            addCriterion("userOrderActualHospitalizationId <>", value, "userorderactualhospitalizationid");
            return (Criteria) this;
        }

        public Criteria andUserorderactualhospitalizationidGreaterThan(Integer value) {
            addCriterion("userOrderActualHospitalizationId >", value, "userorderactualhospitalizationid");
            return (Criteria) this;
        }

        public Criteria andUserorderactualhospitalizationidGreaterThanOrEqualTo(Integer value) {
            addCriterion("userOrderActualHospitalizationId >=", value, "userorderactualhospitalizationid");
            return (Criteria) this;
        }

        public Criteria andUserorderactualhospitalizationidLessThan(Integer value) {
            addCriterion("userOrderActualHospitalizationId <", value, "userorderactualhospitalizationid");
            return (Criteria) this;
        }

        public Criteria andUserorderactualhospitalizationidLessThanOrEqualTo(Integer value) {
            addCriterion("userOrderActualHospitalizationId <=", value, "userorderactualhospitalizationid");
            return (Criteria) this;
        }

        public Criteria andUserorderactualhospitalizationidIn(List<Integer> values) {
            addCriterion("userOrderActualHospitalizationId in", values, "userorderactualhospitalizationid");
            return (Criteria) this;
        }

        public Criteria andUserorderactualhospitalizationidNotIn(List<Integer> values) {
            addCriterion("userOrderActualHospitalizationId not in", values, "userorderactualhospitalizationid");
            return (Criteria) this;
        }

        public Criteria andUserorderactualhospitalizationidBetween(Integer value1, Integer value2) {
            addCriterion("userOrderActualHospitalizationId between", value1, value2, "userorderactualhospitalizationid");
            return (Criteria) this;
        }

        public Criteria andUserorderactualhospitalizationidNotBetween(Integer value1, Integer value2) {
            addCriterion("userOrderActualHospitalizationId not between", value1, value2, "userorderactualhospitalizationid");
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

        public Criteria andUserorderhstateEqualTo(Boolean value) {
            addCriterion("userOrderHState =", value, "userorderhstate");
            return (Criteria) this;
        }

        public Criteria andUserorderhstateNotEqualTo(Boolean value) {
            addCriterion("userOrderHState <>", value, "userorderhstate");
            return (Criteria) this;
        }

        public Criteria andUserorderhstateGreaterThan(Boolean value) {
            addCriterion("userOrderHState >", value, "userorderhstate");
            return (Criteria) this;
        }

        public Criteria andUserorderhstateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("userOrderHState >=", value, "userorderhstate");
            return (Criteria) this;
        }

        public Criteria andUserorderhstateLessThan(Boolean value) {
            addCriterion("userOrderHState <", value, "userorderhstate");
            return (Criteria) this;
        }

        public Criteria andUserorderhstateLessThanOrEqualTo(Boolean value) {
            addCriterion("userOrderHState <=", value, "userorderhstate");
            return (Criteria) this;
        }

        public Criteria andUserorderhstateIn(List<Boolean> values) {
            addCriterion("userOrderHState in", values, "userorderhstate");
            return (Criteria) this;
        }

        public Criteria andUserorderhstateNotIn(List<Boolean> values) {
            addCriterion("userOrderHState not in", values, "userorderhstate");
            return (Criteria) this;
        }

        public Criteria andUserorderhstateBetween(Boolean value1, Boolean value2) {
            addCriterion("userOrderHState between", value1, value2, "userorderhstate");
            return (Criteria) this;
        }

        public Criteria andUserorderhstateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("userOrderHState not between", value1, value2, "userorderhstate");
            return (Criteria) this;
        }

        public Criteria andUserorderchosehosptimeIsNull() {
            addCriterion("userOrderChoseHospTime is null");
            return (Criteria) this;
        }

        public Criteria andUserorderchosehosptimeIsNotNull() {
            addCriterion("userOrderChoseHospTime is not null");
            return (Criteria) this;
        }

        public Criteria andUserorderchosehosptimeEqualTo(Date value) {
            addCriterion("userOrderChoseHospTime =", value, "userorderchosehosptime");
            return (Criteria) this;
        }

        public Criteria andUserorderchosehosptimeNotEqualTo(Date value) {
            addCriterion("userOrderChoseHospTime <>", value, "userorderchosehosptime");
            return (Criteria) this;
        }

        public Criteria andUserorderchosehosptimeGreaterThan(Date value) {
            addCriterion("userOrderChoseHospTime >", value, "userorderchosehosptime");
            return (Criteria) this;
        }

        public Criteria andUserorderchosehosptimeGreaterThanOrEqualTo(Date value) {
            addCriterion("userOrderChoseHospTime >=", value, "userorderchosehosptime");
            return (Criteria) this;
        }

        public Criteria andUserorderchosehosptimeLessThan(Date value) {
            addCriterion("userOrderChoseHospTime <", value, "userorderchosehosptime");
            return (Criteria) this;
        }

        public Criteria andUserorderchosehosptimeLessThanOrEqualTo(Date value) {
            addCriterion("userOrderChoseHospTime <=", value, "userorderchosehosptime");
            return (Criteria) this;
        }

        public Criteria andUserorderchosehosptimeIn(List<Date> values) {
            addCriterion("userOrderChoseHospTime in", values, "userorderchosehosptime");
            return (Criteria) this;
        }

        public Criteria andUserorderchosehosptimeNotIn(List<Date> values) {
            addCriterion("userOrderChoseHospTime not in", values, "userorderchosehosptime");
            return (Criteria) this;
        }

        public Criteria andUserorderchosehosptimeBetween(Date value1, Date value2) {
            addCriterion("userOrderChoseHospTime between", value1, value2, "userorderchosehosptime");
            return (Criteria) this;
        }

        public Criteria andUserorderchosehosptimeNotBetween(Date value1, Date value2) {
            addCriterion("userOrderChoseHospTime not between", value1, value2, "userorderchosehosptime");
            return (Criteria) this;
        }

        public Criteria andUserorderhospconfirmtimeIsNull() {
            addCriterion("userOrderHospConfirmTime is null");
            return (Criteria) this;
        }

        public Criteria andUserorderhospconfirmtimeIsNotNull() {
            addCriterion("userOrderHospConfirmTime is not null");
            return (Criteria) this;
        }

        public Criteria andUserorderhospconfirmtimeEqualTo(Date value) {
            addCriterion("userOrderHospConfirmTime =", value, "userorderhospconfirmtime");
            return (Criteria) this;
        }

        public Criteria andUserorderhospconfirmtimeNotEqualTo(Date value) {
            addCriterion("userOrderHospConfirmTime <>", value, "userorderhospconfirmtime");
            return (Criteria) this;
        }

        public Criteria andUserorderhospconfirmtimeGreaterThan(Date value) {
            addCriterion("userOrderHospConfirmTime >", value, "userorderhospconfirmtime");
            return (Criteria) this;
        }

        public Criteria andUserorderhospconfirmtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("userOrderHospConfirmTime >=", value, "userorderhospconfirmtime");
            return (Criteria) this;
        }

        public Criteria andUserorderhospconfirmtimeLessThan(Date value) {
            addCriterion("userOrderHospConfirmTime <", value, "userorderhospconfirmtime");
            return (Criteria) this;
        }

        public Criteria andUserorderhospconfirmtimeLessThanOrEqualTo(Date value) {
            addCriterion("userOrderHospConfirmTime <=", value, "userorderhospconfirmtime");
            return (Criteria) this;
        }

        public Criteria andUserorderhospconfirmtimeIn(List<Date> values) {
            addCriterion("userOrderHospConfirmTime in", values, "userorderhospconfirmtime");
            return (Criteria) this;
        }

        public Criteria andUserorderhospconfirmtimeNotIn(List<Date> values) {
            addCriterion("userOrderHospConfirmTime not in", values, "userorderhospconfirmtime");
            return (Criteria) this;
        }

        public Criteria andUserorderhospconfirmtimeBetween(Date value1, Date value2) {
            addCriterion("userOrderHospConfirmTime between", value1, value2, "userorderhospconfirmtime");
            return (Criteria) this;
        }

        public Criteria andUserorderhospconfirmtimeNotBetween(Date value1, Date value2) {
            addCriterion("userOrderHospConfirmTime not between", value1, value2, "userorderhospconfirmtime");
            return (Criteria) this;
        }

        public Criteria andUserorderleavehosptimeIsNull() {
            addCriterion("userOrderLeaveHospTime is null");
            return (Criteria) this;
        }

        public Criteria andUserorderleavehosptimeIsNotNull() {
            addCriterion("userOrderLeaveHospTime is not null");
            return (Criteria) this;
        }

        public Criteria andUserorderleavehosptimeEqualTo(Date value) {
            addCriterion("userOrderLeaveHospTime =", value, "userorderleavehosptime");
            return (Criteria) this;
        }

        public Criteria andUserorderleavehosptimeNotEqualTo(Date value) {
            addCriterion("userOrderLeaveHospTime <>", value, "userorderleavehosptime");
            return (Criteria) this;
        }

        public Criteria andUserorderleavehosptimeGreaterThan(Date value) {
            addCriterion("userOrderLeaveHospTime >", value, "userorderleavehosptime");
            return (Criteria) this;
        }

        public Criteria andUserorderleavehosptimeGreaterThanOrEqualTo(Date value) {
            addCriterion("userOrderLeaveHospTime >=", value, "userorderleavehosptime");
            return (Criteria) this;
        }

        public Criteria andUserorderleavehosptimeLessThan(Date value) {
            addCriterion("userOrderLeaveHospTime <", value, "userorderleavehosptime");
            return (Criteria) this;
        }

        public Criteria andUserorderleavehosptimeLessThanOrEqualTo(Date value) {
            addCriterion("userOrderLeaveHospTime <=", value, "userorderleavehosptime");
            return (Criteria) this;
        }

        public Criteria andUserorderleavehosptimeIn(List<Date> values) {
            addCriterion("userOrderLeaveHospTime in", values, "userorderleavehosptime");
            return (Criteria) this;
        }

        public Criteria andUserorderleavehosptimeNotIn(List<Date> values) {
            addCriterion("userOrderLeaveHospTime not in", values, "userorderleavehosptime");
            return (Criteria) this;
        }

        public Criteria andUserorderleavehosptimeBetween(Date value1, Date value2) {
            addCriterion("userOrderLeaveHospTime between", value1, value2, "userorderleavehosptime");
            return (Criteria) this;
        }

        public Criteria andUserorderleavehosptimeNotBetween(Date value1, Date value2) {
            addCriterion("userOrderLeaveHospTime not between", value1, value2, "userorderleavehosptime");
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

        public Criteria andUserordertotaldepositIsNull() {
            addCriterion("userOrderTotalDeposit is null");
            return (Criteria) this;
        }

        public Criteria andUserordertotaldepositIsNotNull() {
            addCriterion("userOrderTotalDeposit is not null");
            return (Criteria) this;
        }

        public Criteria andUserordertotaldepositEqualTo(BigDecimal value) {
            addCriterion("userOrderTotalDeposit =", value, "userordertotaldeposit");
            return (Criteria) this;
        }

        public Criteria andUserordertotaldepositNotEqualTo(BigDecimal value) {
            addCriterion("userOrderTotalDeposit <>", value, "userordertotaldeposit");
            return (Criteria) this;
        }

        public Criteria andUserordertotaldepositGreaterThan(BigDecimal value) {
            addCriterion("userOrderTotalDeposit >", value, "userordertotaldeposit");
            return (Criteria) this;
        }

        public Criteria andUserordertotaldepositGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("userOrderTotalDeposit >=", value, "userordertotaldeposit");
            return (Criteria) this;
        }

        public Criteria andUserordertotaldepositLessThan(BigDecimal value) {
            addCriterion("userOrderTotalDeposit <", value, "userordertotaldeposit");
            return (Criteria) this;
        }

        public Criteria andUserordertotaldepositLessThanOrEqualTo(BigDecimal value) {
            addCriterion("userOrderTotalDeposit <=", value, "userordertotaldeposit");
            return (Criteria) this;
        }

        public Criteria andUserordertotaldepositIn(List<BigDecimal> values) {
            addCriterion("userOrderTotalDeposit in", values, "userordertotaldeposit");
            return (Criteria) this;
        }

        public Criteria andUserordertotaldepositNotIn(List<BigDecimal> values) {
            addCriterion("userOrderTotalDeposit not in", values, "userordertotaldeposit");
            return (Criteria) this;
        }

        public Criteria andUserordertotaldepositBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("userOrderTotalDeposit between", value1, value2, "userordertotaldeposit");
            return (Criteria) this;
        }

        public Criteria andUserordertotaldepositNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("userOrderTotalDeposit not between", value1, value2, "userordertotaldeposit");
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

        public Criteria andUserorderhospprimarydeptIsNull() {
            addCriterion("userOrderHospPrimaryDept is null");
            return (Criteria) this;
        }

        public Criteria andUserorderhospprimarydeptIsNotNull() {
            addCriterion("userOrderHospPrimaryDept is not null");
            return (Criteria) this;
        }

        public Criteria andUserorderhospprimarydeptEqualTo(String value) {
            addCriterion("userOrderHospPrimaryDept =", value, "userorderhospprimarydept");
            return (Criteria) this;
        }

        public Criteria andUserorderhospprimarydeptNotEqualTo(String value) {
            addCriterion("userOrderHospPrimaryDept <>", value, "userorderhospprimarydept");
            return (Criteria) this;
        }

        public Criteria andUserorderhospprimarydeptGreaterThan(String value) {
            addCriterion("userOrderHospPrimaryDept >", value, "userorderhospprimarydept");
            return (Criteria) this;
        }

        public Criteria andUserorderhospprimarydeptGreaterThanOrEqualTo(String value) {
            addCriterion("userOrderHospPrimaryDept >=", value, "userorderhospprimarydept");
            return (Criteria) this;
        }

        public Criteria andUserorderhospprimarydeptLessThan(String value) {
            addCriterion("userOrderHospPrimaryDept <", value, "userorderhospprimarydept");
            return (Criteria) this;
        }

        public Criteria andUserorderhospprimarydeptLessThanOrEqualTo(String value) {
            addCriterion("userOrderHospPrimaryDept <=", value, "userorderhospprimarydept");
            return (Criteria) this;
        }

        public Criteria andUserorderhospprimarydeptLike(String value) {
            addCriterion("userOrderHospPrimaryDept like", value, "userorderhospprimarydept");
            return (Criteria) this;
        }

        public Criteria andUserorderhospprimarydeptNotLike(String value) {
            addCriterion("userOrderHospPrimaryDept not like", value, "userorderhospprimarydept");
            return (Criteria) this;
        }

        public Criteria andUserorderhospprimarydeptIn(List<String> values) {
            addCriterion("userOrderHospPrimaryDept in", values, "userorderhospprimarydept");
            return (Criteria) this;
        }

        public Criteria andUserorderhospprimarydeptNotIn(List<String> values) {
            addCriterion("userOrderHospPrimaryDept not in", values, "userorderhospprimarydept");
            return (Criteria) this;
        }

        public Criteria andUserorderhospprimarydeptBetween(String value1, String value2) {
            addCriterion("userOrderHospPrimaryDept between", value1, value2, "userorderhospprimarydept");
            return (Criteria) this;
        }

        public Criteria andUserorderhospprimarydeptNotBetween(String value1, String value2) {
            addCriterion("userOrderHospPrimaryDept not between", value1, value2, "userorderhospprimarydept");
            return (Criteria) this;
        }

        public Criteria andUserorderhospseconddeptIsNull() {
            addCriterion("userOrderHospSecondDept is null");
            return (Criteria) this;
        }

        public Criteria andUserorderhospseconddeptIsNotNull() {
            addCriterion("userOrderHospSecondDept is not null");
            return (Criteria) this;
        }

        public Criteria andUserorderhospseconddeptEqualTo(String value) {
            addCriterion("userOrderHospSecondDept =", value, "userorderhospseconddept");
            return (Criteria) this;
        }

        public Criteria andUserorderhospseconddeptNotEqualTo(String value) {
            addCriterion("userOrderHospSecondDept <>", value, "userorderhospseconddept");
            return (Criteria) this;
        }

        public Criteria andUserorderhospseconddeptGreaterThan(String value) {
            addCriterion("userOrderHospSecondDept >", value, "userorderhospseconddept");
            return (Criteria) this;
        }

        public Criteria andUserorderhospseconddeptGreaterThanOrEqualTo(String value) {
            addCriterion("userOrderHospSecondDept >=", value, "userorderhospseconddept");
            return (Criteria) this;
        }

        public Criteria andUserorderhospseconddeptLessThan(String value) {
            addCriterion("userOrderHospSecondDept <", value, "userorderhospseconddept");
            return (Criteria) this;
        }

        public Criteria andUserorderhospseconddeptLessThanOrEqualTo(String value) {
            addCriterion("userOrderHospSecondDept <=", value, "userorderhospseconddept");
            return (Criteria) this;
        }

        public Criteria andUserorderhospseconddeptLike(String value) {
            addCriterion("userOrderHospSecondDept like", value, "userorderhospseconddept");
            return (Criteria) this;
        }

        public Criteria andUserorderhospseconddeptNotLike(String value) {
            addCriterion("userOrderHospSecondDept not like", value, "userorderhospseconddept");
            return (Criteria) this;
        }

        public Criteria andUserorderhospseconddeptIn(List<String> values) {
            addCriterion("userOrderHospSecondDept in", values, "userorderhospseconddept");
            return (Criteria) this;
        }

        public Criteria andUserorderhospseconddeptNotIn(List<String> values) {
            addCriterion("userOrderHospSecondDept not in", values, "userorderhospseconddept");
            return (Criteria) this;
        }

        public Criteria andUserorderhospseconddeptBetween(String value1, String value2) {
            addCriterion("userOrderHospSecondDept between", value1, value2, "userorderhospseconddept");
            return (Criteria) this;
        }

        public Criteria andUserorderhospseconddeptNotBetween(String value1, String value2) {
            addCriterion("userOrderHospSecondDept not between", value1, value2, "userorderhospseconddept");
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

        public Criteria andUserorderfinishtimeIsNull() {
            addCriterion("userOrderFinishTime is null");
            return (Criteria) this;
        }

        public Criteria andUserorderfinishtimeIsNotNull() {
            addCriterion("userOrderFinishTime is not null");
            return (Criteria) this;
        }

        public Criteria andUserorderfinishtimeEqualTo(Date value) {
            addCriterion("userOrderFinishTime =", value, "userorderfinishtime");
            return (Criteria) this;
        }

        public Criteria andUserorderfinishtimeNotEqualTo(Date value) {
            addCriterion("userOrderFinishTime <>", value, "userorderfinishtime");
            return (Criteria) this;
        }

        public Criteria andUserorderfinishtimeGreaterThan(Date value) {
            addCriterion("userOrderFinishTime >", value, "userorderfinishtime");
            return (Criteria) this;
        }

        public Criteria andUserorderfinishtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("userOrderFinishTime >=", value, "userorderfinishtime");
            return (Criteria) this;
        }

        public Criteria andUserorderfinishtimeLessThan(Date value) {
            addCriterion("userOrderFinishTime <", value, "userorderfinishtime");
            return (Criteria) this;
        }

        public Criteria andUserorderfinishtimeLessThanOrEqualTo(Date value) {
            addCriterion("userOrderFinishTime <=", value, "userorderfinishtime");
            return (Criteria) this;
        }

        public Criteria andUserorderfinishtimeIn(List<Date> values) {
            addCriterion("userOrderFinishTime in", values, "userorderfinishtime");
            return (Criteria) this;
        }

        public Criteria andUserorderfinishtimeNotIn(List<Date> values) {
            addCriterion("userOrderFinishTime not in", values, "userorderfinishtime");
            return (Criteria) this;
        }

        public Criteria andUserorderfinishtimeBetween(Date value1, Date value2) {
            addCriterion("userOrderFinishTime between", value1, value2, "userorderfinishtime");
            return (Criteria) this;
        }

        public Criteria andUserorderfinishtimeNotBetween(Date value1, Date value2) {
            addCriterion("userOrderFinishTime not between", value1, value2, "userorderfinishtime");
            return (Criteria) this;
        }

        public Criteria andUsersickdescIsNull() {
            addCriterion("userSickDesc is null");
            return (Criteria) this;
        }

        public Criteria andUsersickdescIsNotNull() {
            addCriterion("userSickDesc is not null");
            return (Criteria) this;
        }

        public Criteria andUsersickdescEqualTo(String value) {
            addCriterion("userSickDesc =", value, "usersickdesc");
            return (Criteria) this;
        }

        public Criteria andUsersickdescNotEqualTo(String value) {
            addCriterion("userSickDesc <>", value, "usersickdesc");
            return (Criteria) this;
        }

        public Criteria andUsersickdescGreaterThan(String value) {
            addCriterion("userSickDesc >", value, "usersickdesc");
            return (Criteria) this;
        }

        public Criteria andUsersickdescGreaterThanOrEqualTo(String value) {
            addCriterion("userSickDesc >=", value, "usersickdesc");
            return (Criteria) this;
        }

        public Criteria andUsersickdescLessThan(String value) {
            addCriterion("userSickDesc <", value, "usersickdesc");
            return (Criteria) this;
        }

        public Criteria andUsersickdescLessThanOrEqualTo(String value) {
            addCriterion("userSickDesc <=", value, "usersickdesc");
            return (Criteria) this;
        }

        public Criteria andUsersickdescLike(String value) {
            addCriterion("userSickDesc like", value, "usersickdesc");
            return (Criteria) this;
        }

        public Criteria andUsersickdescNotLike(String value) {
            addCriterion("userSickDesc not like", value, "usersickdesc");
            return (Criteria) this;
        }

        public Criteria andUsersickdescIn(List<String> values) {
            addCriterion("userSickDesc in", values, "usersickdesc");
            return (Criteria) this;
        }

        public Criteria andUsersickdescNotIn(List<String> values) {
            addCriterion("userSickDesc not in", values, "usersickdesc");
            return (Criteria) this;
        }

        public Criteria andUsersickdescBetween(String value1, String value2) {
            addCriterion("userSickDesc between", value1, value2, "usersickdesc");
            return (Criteria) this;
        }

        public Criteria andUsersickdescNotBetween(String value1, String value2) {
            addCriterion("userSickDesc not between", value1, value2, "usersickdesc");
            return (Criteria) this;
        }

        public Criteria andUsersickpicIsNull() {
            addCriterion("userSickPic is null");
            return (Criteria) this;
        }

        public Criteria andUsersickpicIsNotNull() {
            addCriterion("userSickPic is not null");
            return (Criteria) this;
        }

        public Criteria andUsersickpicEqualTo(String value) {
            addCriterion("userSickPic =", value, "usersickpic");
            return (Criteria) this;
        }

        public Criteria andUsersickpicNotEqualTo(String value) {
            addCriterion("userSickPic <>", value, "usersickpic");
            return (Criteria) this;
        }

        public Criteria andUsersickpicGreaterThan(String value) {
            addCriterion("userSickPic >", value, "usersickpic");
            return (Criteria) this;
        }

        public Criteria andUsersickpicGreaterThanOrEqualTo(String value) {
            addCriterion("userSickPic >=", value, "usersickpic");
            return (Criteria) this;
        }

        public Criteria andUsersickpicLessThan(String value) {
            addCriterion("userSickPic <", value, "usersickpic");
            return (Criteria) this;
        }

        public Criteria andUsersickpicLessThanOrEqualTo(String value) {
            addCriterion("userSickPic <=", value, "usersickpic");
            return (Criteria) this;
        }

        public Criteria andUsersickpicLike(String value) {
            addCriterion("userSickPic like", value, "usersickpic");
            return (Criteria) this;
        }

        public Criteria andUsersickpicNotLike(String value) {
            addCriterion("userSickPic not like", value, "usersickpic");
            return (Criteria) this;
        }

        public Criteria andUsersickpicIn(List<String> values) {
            addCriterion("userSickPic in", values, "usersickpic");
            return (Criteria) this;
        }

        public Criteria andUsersickpicNotIn(List<String> values) {
            addCriterion("userSickPic not in", values, "usersickpic");
            return (Criteria) this;
        }

        public Criteria andUsersickpicBetween(String value1, String value2) {
            addCriterion("userSickPic between", value1, value2, "usersickpic");
            return (Criteria) this;
        }

        public Criteria andUsersickpicNotBetween(String value1, String value2) {
            addCriterion("userSickPic not between", value1, value2, "usersickpic");
            return (Criteria) this;
        }

        public Criteria andUsersickprimarydeptIsNull() {
            addCriterion("userSickPrimaryDept is null");
            return (Criteria) this;
        }

        public Criteria andUsersickprimarydeptIsNotNull() {
            addCriterion("userSickPrimaryDept is not null");
            return (Criteria) this;
        }

        public Criteria andUsersickprimarydeptEqualTo(String value) {
            addCriterion("userSickPrimaryDept =", value, "usersickprimarydept");
            return (Criteria) this;
        }

        public Criteria andUsersickprimarydeptNotEqualTo(String value) {
            addCriterion("userSickPrimaryDept <>", value, "usersickprimarydept");
            return (Criteria) this;
        }

        public Criteria andUsersickprimarydeptGreaterThan(String value) {
            addCriterion("userSickPrimaryDept >", value, "usersickprimarydept");
            return (Criteria) this;
        }

        public Criteria andUsersickprimarydeptGreaterThanOrEqualTo(String value) {
            addCriterion("userSickPrimaryDept >=", value, "usersickprimarydept");
            return (Criteria) this;
        }

        public Criteria andUsersickprimarydeptLessThan(String value) {
            addCriterion("userSickPrimaryDept <", value, "usersickprimarydept");
            return (Criteria) this;
        }

        public Criteria andUsersickprimarydeptLessThanOrEqualTo(String value) {
            addCriterion("userSickPrimaryDept <=", value, "usersickprimarydept");
            return (Criteria) this;
        }

        public Criteria andUsersickprimarydeptLike(String value) {
            addCriterion("userSickPrimaryDept like", value, "usersickprimarydept");
            return (Criteria) this;
        }

        public Criteria andUsersickprimarydeptNotLike(String value) {
            addCriterion("userSickPrimaryDept not like", value, "usersickprimarydept");
            return (Criteria) this;
        }

        public Criteria andUsersickprimarydeptIn(List<String> values) {
            addCriterion("userSickPrimaryDept in", values, "usersickprimarydept");
            return (Criteria) this;
        }

        public Criteria andUsersickprimarydeptNotIn(List<String> values) {
            addCriterion("userSickPrimaryDept not in", values, "usersickprimarydept");
            return (Criteria) this;
        }

        public Criteria andUsersickprimarydeptBetween(String value1, String value2) {
            addCriterion("userSickPrimaryDept between", value1, value2, "usersickprimarydept");
            return (Criteria) this;
        }

        public Criteria andUsersickprimarydeptNotBetween(String value1, String value2) {
            addCriterion("userSickPrimaryDept not between", value1, value2, "usersickprimarydept");
            return (Criteria) this;
        }

        public Criteria andUsersickseconddeptIsNull() {
            addCriterion("userSickSecondDept is null");
            return (Criteria) this;
        }

        public Criteria andUsersickseconddeptIsNotNull() {
            addCriterion("userSickSecondDept is not null");
            return (Criteria) this;
        }

        public Criteria andUsersickseconddeptEqualTo(String value) {
            addCriterion("userSickSecondDept =", value, "usersickseconddept");
            return (Criteria) this;
        }

        public Criteria andUsersickseconddeptNotEqualTo(String value) {
            addCriterion("userSickSecondDept <>", value, "usersickseconddept");
            return (Criteria) this;
        }

        public Criteria andUsersickseconddeptGreaterThan(String value) {
            addCriterion("userSickSecondDept >", value, "usersickseconddept");
            return (Criteria) this;
        }

        public Criteria andUsersickseconddeptGreaterThanOrEqualTo(String value) {
            addCriterion("userSickSecondDept >=", value, "usersickseconddept");
            return (Criteria) this;
        }

        public Criteria andUsersickseconddeptLessThan(String value) {
            addCriterion("userSickSecondDept <", value, "usersickseconddept");
            return (Criteria) this;
        }

        public Criteria andUsersickseconddeptLessThanOrEqualTo(String value) {
            addCriterion("userSickSecondDept <=", value, "usersickseconddept");
            return (Criteria) this;
        }

        public Criteria andUsersickseconddeptLike(String value) {
            addCriterion("userSickSecondDept like", value, "usersickseconddept");
            return (Criteria) this;
        }

        public Criteria andUsersickseconddeptNotLike(String value) {
            addCriterion("userSickSecondDept not like", value, "usersickseconddept");
            return (Criteria) this;
        }

        public Criteria andUsersickseconddeptIn(List<String> values) {
            addCriterion("userSickSecondDept in", values, "usersickseconddept");
            return (Criteria) this;
        }

        public Criteria andUsersickseconddeptNotIn(List<String> values) {
            addCriterion("userSickSecondDept not in", values, "usersickseconddept");
            return (Criteria) this;
        }

        public Criteria andUsersickseconddeptBetween(String value1, String value2) {
            addCriterion("userSickSecondDept between", value1, value2, "usersickseconddept");
            return (Criteria) this;
        }

        public Criteria andUsersickseconddeptNotBetween(String value1, String value2) {
            addCriterion("userSickSecondDept not between", value1, value2, "usersickseconddept");
            return (Criteria) this;
        }

        public Criteria andFamilynameIsNull() {
            addCriterion("familyName is null");
            return (Criteria) this;
        }

        public Criteria andFamilynameIsNotNull() {
            addCriterion("familyName is not null");
            return (Criteria) this;
        }

        public Criteria andFamilynameEqualTo(String value) {
            addCriterion("familyName =", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameNotEqualTo(String value) {
            addCriterion("familyName <>", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameGreaterThan(String value) {
            addCriterion("familyName >", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameGreaterThanOrEqualTo(String value) {
            addCriterion("familyName >=", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameLessThan(String value) {
            addCriterion("familyName <", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameLessThanOrEqualTo(String value) {
            addCriterion("familyName <=", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameLike(String value) {
            addCriterion("familyName like", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameNotLike(String value) {
            addCriterion("familyName not like", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameIn(List<String> values) {
            addCriterion("familyName in", values, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameNotIn(List<String> values) {
            addCriterion("familyName not in", values, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameBetween(String value1, String value2) {
            addCriterion("familyName between", value1, value2, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameNotBetween(String value1, String value2) {
            addCriterion("familyName not between", value1, value2, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilymaleIsNull() {
            addCriterion("familyMale is null");
            return (Criteria) this;
        }

        public Criteria andFamilymaleIsNotNull() {
            addCriterion("familyMale is not null");
            return (Criteria) this;
        }

        public Criteria andFamilymaleEqualTo(String value) {
            addCriterion("familyMale =", value, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleNotEqualTo(String value) {
            addCriterion("familyMale <>", value, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleGreaterThan(String value) {
            addCriterion("familyMale >", value, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleGreaterThanOrEqualTo(String value) {
            addCriterion("familyMale >=", value, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleLessThan(String value) {
            addCriterion("familyMale <", value, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleLessThanOrEqualTo(String value) {
            addCriterion("familyMale <=", value, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleLike(String value) {
            addCriterion("familyMale like", value, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleNotLike(String value) {
            addCriterion("familyMale not like", value, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleIn(List<String> values) {
            addCriterion("familyMale in", values, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleNotIn(List<String> values) {
            addCriterion("familyMale not in", values, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleBetween(String value1, String value2) {
            addCriterion("familyMale between", value1, value2, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleNotBetween(String value1, String value2) {
            addCriterion("familyMale not between", value1, value2, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilyageIsNull() {
            addCriterion("familyAge is null");
            return (Criteria) this;
        }

        public Criteria andFamilyageIsNotNull() {
            addCriterion("familyAge is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyageEqualTo(Integer value) {
            addCriterion("familyAge =", value, "familyage");
            return (Criteria) this;
        }

        public Criteria andFamilyageNotEqualTo(Integer value) {
            addCriterion("familyAge <>", value, "familyage");
            return (Criteria) this;
        }

        public Criteria andFamilyageGreaterThan(Integer value) {
            addCriterion("familyAge >", value, "familyage");
            return (Criteria) this;
        }

        public Criteria andFamilyageGreaterThanOrEqualTo(Integer value) {
            addCriterion("familyAge >=", value, "familyage");
            return (Criteria) this;
        }

        public Criteria andFamilyageLessThan(Integer value) {
            addCriterion("familyAge <", value, "familyage");
            return (Criteria) this;
        }

        public Criteria andFamilyageLessThanOrEqualTo(Integer value) {
            addCriterion("familyAge <=", value, "familyage");
            return (Criteria) this;
        }

        public Criteria andFamilyageIn(List<Integer> values) {
            addCriterion("familyAge in", values, "familyage");
            return (Criteria) this;
        }

        public Criteria andFamilyageNotIn(List<Integer> values) {
            addCriterion("familyAge not in", values, "familyage");
            return (Criteria) this;
        }

        public Criteria andFamilyageBetween(Integer value1, Integer value2) {
            addCriterion("familyAge between", value1, value2, "familyage");
            return (Criteria) this;
        }

        public Criteria andFamilyageNotBetween(Integer value1, Integer value2) {
            addCriterion("familyAge not between", value1, value2, "familyage");
            return (Criteria) this;
        }

        public Criteria andDocaddresslocationIsNull() {
            addCriterion("docAddressLocation is null");
            return (Criteria) this;
        }

        public Criteria andDocaddresslocationIsNotNull() {
            addCriterion("docAddressLocation is not null");
            return (Criteria) this;
        }

        public Criteria andDocaddresslocationEqualTo(String value) {
            addCriterion("docAddressLocation =", value, "docaddresslocation");
            return (Criteria) this;
        }

        public Criteria andDocaddresslocationNotEqualTo(String value) {
            addCriterion("docAddressLocation <>", value, "docaddresslocation");
            return (Criteria) this;
        }

        public Criteria andDocaddresslocationGreaterThan(String value) {
            addCriterion("docAddressLocation >", value, "docaddresslocation");
            return (Criteria) this;
        }

        public Criteria andDocaddresslocationGreaterThanOrEqualTo(String value) {
            addCriterion("docAddressLocation >=", value, "docaddresslocation");
            return (Criteria) this;
        }

        public Criteria andDocaddresslocationLessThan(String value) {
            addCriterion("docAddressLocation <", value, "docaddresslocation");
            return (Criteria) this;
        }

        public Criteria andDocaddresslocationLessThanOrEqualTo(String value) {
            addCriterion("docAddressLocation <=", value, "docaddresslocation");
            return (Criteria) this;
        }

        public Criteria andDocaddresslocationLike(String value) {
            addCriterion("docAddressLocation like", value, "docaddresslocation");
            return (Criteria) this;
        }

        public Criteria andDocaddresslocationNotLike(String value) {
            addCriterion("docAddressLocation not like", value, "docaddresslocation");
            return (Criteria) this;
        }

        public Criteria andDocaddresslocationIn(List<String> values) {
            addCriterion("docAddressLocation in", values, "docaddresslocation");
            return (Criteria) this;
        }

        public Criteria andDocaddresslocationNotIn(List<String> values) {
            addCriterion("docAddressLocation not in", values, "docaddresslocation");
            return (Criteria) this;
        }

        public Criteria andDocaddresslocationBetween(String value1, String value2) {
            addCriterion("docAddressLocation between", value1, value2, "docaddresslocation");
            return (Criteria) this;
        }

        public Criteria andDocaddresslocationNotBetween(String value1, String value2) {
            addCriterion("docAddressLocation not between", value1, value2, "docaddresslocation");
            return (Criteria) this;
        }

        public Criteria andDocaddressprovinceIsNull() {
            addCriterion("docAddressProvince is null");
            return (Criteria) this;
        }

        public Criteria andDocaddressprovinceIsNotNull() {
            addCriterion("docAddressProvince is not null");
            return (Criteria) this;
        }

        public Criteria andDocaddressprovinceEqualTo(String value) {
            addCriterion("docAddressProvince =", value, "docaddressprovince");
            return (Criteria) this;
        }

        public Criteria andDocaddressprovinceNotEqualTo(String value) {
            addCriterion("docAddressProvince <>", value, "docaddressprovince");
            return (Criteria) this;
        }

        public Criteria andDocaddressprovinceGreaterThan(String value) {
            addCriterion("docAddressProvince >", value, "docaddressprovince");
            return (Criteria) this;
        }

        public Criteria andDocaddressprovinceGreaterThanOrEqualTo(String value) {
            addCriterion("docAddressProvince >=", value, "docaddressprovince");
            return (Criteria) this;
        }

        public Criteria andDocaddressprovinceLessThan(String value) {
            addCriterion("docAddressProvince <", value, "docaddressprovince");
            return (Criteria) this;
        }

        public Criteria andDocaddressprovinceLessThanOrEqualTo(String value) {
            addCriterion("docAddressProvince <=", value, "docaddressprovince");
            return (Criteria) this;
        }

        public Criteria andDocaddressprovinceLike(String value) {
            addCriterion("docAddressProvince like", value, "docaddressprovince");
            return (Criteria) this;
        }

        public Criteria andDocaddressprovinceNotLike(String value) {
            addCriterion("docAddressProvince not like", value, "docaddressprovince");
            return (Criteria) this;
        }

        public Criteria andDocaddressprovinceIn(List<String> values) {
            addCriterion("docAddressProvince in", values, "docaddressprovince");
            return (Criteria) this;
        }

        public Criteria andDocaddressprovinceNotIn(List<String> values) {
            addCriterion("docAddressProvince not in", values, "docaddressprovince");
            return (Criteria) this;
        }

        public Criteria andDocaddressprovinceBetween(String value1, String value2) {
            addCriterion("docAddressProvince between", value1, value2, "docaddressprovince");
            return (Criteria) this;
        }

        public Criteria andDocaddressprovinceNotBetween(String value1, String value2) {
            addCriterion("docAddressProvince not between", value1, value2, "docaddressprovince");
            return (Criteria) this;
        }

        public Criteria andDocaddresscityIsNull() {
            addCriterion("docAddressCity is null");
            return (Criteria) this;
        }

        public Criteria andDocaddresscityIsNotNull() {
            addCriterion("docAddressCity is not null");
            return (Criteria) this;
        }

        public Criteria andDocaddresscityEqualTo(String value) {
            addCriterion("docAddressCity =", value, "docaddresscity");
            return (Criteria) this;
        }

        public Criteria andDocaddresscityNotEqualTo(String value) {
            addCriterion("docAddressCity <>", value, "docaddresscity");
            return (Criteria) this;
        }

        public Criteria andDocaddresscityGreaterThan(String value) {
            addCriterion("docAddressCity >", value, "docaddresscity");
            return (Criteria) this;
        }

        public Criteria andDocaddresscityGreaterThanOrEqualTo(String value) {
            addCriterion("docAddressCity >=", value, "docaddresscity");
            return (Criteria) this;
        }

        public Criteria andDocaddresscityLessThan(String value) {
            addCriterion("docAddressCity <", value, "docaddresscity");
            return (Criteria) this;
        }

        public Criteria andDocaddresscityLessThanOrEqualTo(String value) {
            addCriterion("docAddressCity <=", value, "docaddresscity");
            return (Criteria) this;
        }

        public Criteria andDocaddresscityLike(String value) {
            addCriterion("docAddressCity like", value, "docaddresscity");
            return (Criteria) this;
        }

        public Criteria andDocaddresscityNotLike(String value) {
            addCriterion("docAddressCity not like", value, "docaddresscity");
            return (Criteria) this;
        }

        public Criteria andDocaddresscityIn(List<String> values) {
            addCriterion("docAddressCity in", values, "docaddresscity");
            return (Criteria) this;
        }

        public Criteria andDocaddresscityNotIn(List<String> values) {
            addCriterion("docAddressCity not in", values, "docaddresscity");
            return (Criteria) this;
        }

        public Criteria andDocaddresscityBetween(String value1, String value2) {
            addCriterion("docAddressCity between", value1, value2, "docaddresscity");
            return (Criteria) this;
        }

        public Criteria andDocaddresscityNotBetween(String value1, String value2) {
            addCriterion("docAddressCity not between", value1, value2, "docaddresscity");
            return (Criteria) this;
        }

        public Criteria andDocaddressareaIsNull() {
            addCriterion("docAddressArea is null");
            return (Criteria) this;
        }

        public Criteria andDocaddressareaIsNotNull() {
            addCriterion("docAddressArea is not null");
            return (Criteria) this;
        }

        public Criteria andDocaddressareaEqualTo(String value) {
            addCriterion("docAddressArea =", value, "docaddressarea");
            return (Criteria) this;
        }

        public Criteria andDocaddressareaNotEqualTo(String value) {
            addCriterion("docAddressArea <>", value, "docaddressarea");
            return (Criteria) this;
        }

        public Criteria andDocaddressareaGreaterThan(String value) {
            addCriterion("docAddressArea >", value, "docaddressarea");
            return (Criteria) this;
        }

        public Criteria andDocaddressareaGreaterThanOrEqualTo(String value) {
            addCriterion("docAddressArea >=", value, "docaddressarea");
            return (Criteria) this;
        }

        public Criteria andDocaddressareaLessThan(String value) {
            addCriterion("docAddressArea <", value, "docaddressarea");
            return (Criteria) this;
        }

        public Criteria andDocaddressareaLessThanOrEqualTo(String value) {
            addCriterion("docAddressArea <=", value, "docaddressarea");
            return (Criteria) this;
        }

        public Criteria andDocaddressareaLike(String value) {
            addCriterion("docAddressArea like", value, "docaddressarea");
            return (Criteria) this;
        }

        public Criteria andDocaddressareaNotLike(String value) {
            addCriterion("docAddressArea not like", value, "docaddressarea");
            return (Criteria) this;
        }

        public Criteria andDocaddressareaIn(List<String> values) {
            addCriterion("docAddressArea in", values, "docaddressarea");
            return (Criteria) this;
        }

        public Criteria andDocaddressareaNotIn(List<String> values) {
            addCriterion("docAddressArea not in", values, "docaddressarea");
            return (Criteria) this;
        }

        public Criteria andDocaddressareaBetween(String value1, String value2) {
            addCriterion("docAddressArea between", value1, value2, "docaddressarea");
            return (Criteria) this;
        }

        public Criteria andDocaddressareaNotBetween(String value1, String value2) {
            addCriterion("docAddressArea not between", value1, value2, "docaddressarea");
            return (Criteria) this;
        }

        public Criteria andDocaddressotherIsNull() {
            addCriterion("docAddressOther is null");
            return (Criteria) this;
        }

        public Criteria andDocaddressotherIsNotNull() {
            addCriterion("docAddressOther is not null");
            return (Criteria) this;
        }

        public Criteria andDocaddressotherEqualTo(String value) {
            addCriterion("docAddressOther =", value, "docaddressother");
            return (Criteria) this;
        }

        public Criteria andDocaddressotherNotEqualTo(String value) {
            addCriterion("docAddressOther <>", value, "docaddressother");
            return (Criteria) this;
        }

        public Criteria andDocaddressotherGreaterThan(String value) {
            addCriterion("docAddressOther >", value, "docaddressother");
            return (Criteria) this;
        }

        public Criteria andDocaddressotherGreaterThanOrEqualTo(String value) {
            addCriterion("docAddressOther >=", value, "docaddressother");
            return (Criteria) this;
        }

        public Criteria andDocaddressotherLessThan(String value) {
            addCriterion("docAddressOther <", value, "docaddressother");
            return (Criteria) this;
        }

        public Criteria andDocaddressotherLessThanOrEqualTo(String value) {
            addCriterion("docAddressOther <=", value, "docaddressother");
            return (Criteria) this;
        }

        public Criteria andDocaddressotherLike(String value) {
            addCriterion("docAddressOther like", value, "docaddressother");
            return (Criteria) this;
        }

        public Criteria andDocaddressotherNotLike(String value) {
            addCriterion("docAddressOther not like", value, "docaddressother");
            return (Criteria) this;
        }

        public Criteria andDocaddressotherIn(List<String> values) {
            addCriterion("docAddressOther in", values, "docaddressother");
            return (Criteria) this;
        }

        public Criteria andDocaddressotherNotIn(List<String> values) {
            addCriterion("docAddressOther not in", values, "docaddressother");
            return (Criteria) this;
        }

        public Criteria andDocaddressotherBetween(String value1, String value2) {
            addCriterion("docAddressOther between", value1, value2, "docaddressother");
            return (Criteria) this;
        }

        public Criteria andDocaddressotherNotBetween(String value1, String value2) {
            addCriterion("docAddressOther not between", value1, value2, "docaddressother");
            return (Criteria) this;
        }

        public Criteria andDocaddresslonIsNull() {
            addCriterion("docAddressLon is null");
            return (Criteria) this;
        }

        public Criteria andDocaddresslonIsNotNull() {
            addCriterion("docAddressLon is not null");
            return (Criteria) this;
        }

        public Criteria andDocaddresslonEqualTo(String value) {
            addCriterion("docAddressLon =", value, "docaddresslon");
            return (Criteria) this;
        }

        public Criteria andDocaddresslonNotEqualTo(String value) {
            addCriterion("docAddressLon <>", value, "docaddresslon");
            return (Criteria) this;
        }

        public Criteria andDocaddresslonGreaterThan(String value) {
            addCriterion("docAddressLon >", value, "docaddresslon");
            return (Criteria) this;
        }

        public Criteria andDocaddresslonGreaterThanOrEqualTo(String value) {
            addCriterion("docAddressLon >=", value, "docaddresslon");
            return (Criteria) this;
        }

        public Criteria andDocaddresslonLessThan(String value) {
            addCriterion("docAddressLon <", value, "docaddresslon");
            return (Criteria) this;
        }

        public Criteria andDocaddresslonLessThanOrEqualTo(String value) {
            addCriterion("docAddressLon <=", value, "docaddresslon");
            return (Criteria) this;
        }

        public Criteria andDocaddresslonLike(String value) {
            addCriterion("docAddressLon like", value, "docaddresslon");
            return (Criteria) this;
        }

        public Criteria andDocaddresslonNotLike(String value) {
            addCriterion("docAddressLon not like", value, "docaddresslon");
            return (Criteria) this;
        }

        public Criteria andDocaddresslonIn(List<String> values) {
            addCriterion("docAddressLon in", values, "docaddresslon");
            return (Criteria) this;
        }

        public Criteria andDocaddresslonNotIn(List<String> values) {
            addCriterion("docAddressLon not in", values, "docaddresslon");
            return (Criteria) this;
        }

        public Criteria andDocaddresslonBetween(String value1, String value2) {
            addCriterion("docAddressLon between", value1, value2, "docaddresslon");
            return (Criteria) this;
        }

        public Criteria andDocaddresslonNotBetween(String value1, String value2) {
            addCriterion("docAddressLon not between", value1, value2, "docaddresslon");
            return (Criteria) this;
        }

        public Criteria andDocaddresslatIsNull() {
            addCriterion("docAddressLat is null");
            return (Criteria) this;
        }

        public Criteria andDocaddresslatIsNotNull() {
            addCriterion("docAddressLat is not null");
            return (Criteria) this;
        }

        public Criteria andDocaddresslatEqualTo(String value) {
            addCriterion("docAddressLat =", value, "docaddresslat");
            return (Criteria) this;
        }

        public Criteria andDocaddresslatNotEqualTo(String value) {
            addCriterion("docAddressLat <>", value, "docaddresslat");
            return (Criteria) this;
        }

        public Criteria andDocaddresslatGreaterThan(String value) {
            addCriterion("docAddressLat >", value, "docaddresslat");
            return (Criteria) this;
        }

        public Criteria andDocaddresslatGreaterThanOrEqualTo(String value) {
            addCriterion("docAddressLat >=", value, "docaddresslat");
            return (Criteria) this;
        }

        public Criteria andDocaddresslatLessThan(String value) {
            addCriterion("docAddressLat <", value, "docaddresslat");
            return (Criteria) this;
        }

        public Criteria andDocaddresslatLessThanOrEqualTo(String value) {
            addCriterion("docAddressLat <=", value, "docaddresslat");
            return (Criteria) this;
        }

        public Criteria andDocaddresslatLike(String value) {
            addCriterion("docAddressLat like", value, "docaddresslat");
            return (Criteria) this;
        }

        public Criteria andDocaddresslatNotLike(String value) {
            addCriterion("docAddressLat not like", value, "docaddresslat");
            return (Criteria) this;
        }

        public Criteria andDocaddresslatIn(List<String> values) {
            addCriterion("docAddressLat in", values, "docaddresslat");
            return (Criteria) this;
        }

        public Criteria andDocaddresslatNotIn(List<String> values) {
            addCriterion("docAddressLat not in", values, "docaddresslat");
            return (Criteria) this;
        }

        public Criteria andDocaddresslatBetween(String value1, String value2) {
            addCriterion("docAddressLat between", value1, value2, "docaddresslat");
            return (Criteria) this;
        }

        public Criteria andDocaddresslatNotBetween(String value1, String value2) {
            addCriterion("docAddressLat not between", value1, value2, "docaddresslat");
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