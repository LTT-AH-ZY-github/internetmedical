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

        public Criteria andOrderstimeEqualTo(String value) {
            addCriterion("OrderSTime =", value, "orderstime");
            return (Criteria) this;
        }

        public Criteria andOrderstimeNotEqualTo(String value) {
            addCriterion("OrderSTime <>", value, "orderstime");
            return (Criteria) this;
        }

        public Criteria andOrderstimeGreaterThan(String value) {
            addCriterion("OrderSTime >", value, "orderstime");
            return (Criteria) this;
        }

        public Criteria andOrderstimeGreaterThanOrEqualTo(String value) {
            addCriterion("OrderSTime >=", value, "orderstime");
            return (Criteria) this;
        }

        public Criteria andOrderstimeLessThan(String value) {
            addCriterion("OrderSTime <", value, "orderstime");
            return (Criteria) this;
        }

        public Criteria andOrderstimeLessThanOrEqualTo(String value) {
            addCriterion("OrderSTime <=", value, "orderstime");
            return (Criteria) this;
        }

        public Criteria andOrderstimeLike(String value) {
            addCriterion("OrderSTime like", value, "orderstime");
            return (Criteria) this;
        }

        public Criteria andOrderstimeNotLike(String value) {
            addCriterion("OrderSTime not like", value, "orderstime");
            return (Criteria) this;
        }

        public Criteria andOrderstimeIn(List<String> values) {
            addCriterion("OrderSTime in", values, "orderstime");
            return (Criteria) this;
        }

        public Criteria andOrderstimeNotIn(List<String> values) {
            addCriterion("OrderSTime not in", values, "orderstime");
            return (Criteria) this;
        }

        public Criteria andOrderstimeBetween(String value1, String value2) {
            addCriterion("OrderSTime between", value1, value2, "orderstime");
            return (Criteria) this;
        }

        public Criteria andOrderstimeNotBetween(String value1, String value2) {
            addCriterion("OrderSTime not between", value1, value2, "orderstime");
            return (Criteria) this;
        }

        public Criteria andOrderhosppriceIsNull() {
            addCriterion("OrderHospPrice is null");
            return (Criteria) this;
        }

        public Criteria andOrderhosppriceIsNotNull() {
            addCriterion("OrderHospPrice is not null");
            return (Criteria) this;
        }

        public Criteria andOrderhosppriceEqualTo(BigDecimal value) {
            addCriterion("OrderHospPrice =", value, "orderhospprice");
            return (Criteria) this;
        }

        public Criteria andOrderhosppriceNotEqualTo(BigDecimal value) {
            addCriterion("OrderHospPrice <>", value, "orderhospprice");
            return (Criteria) this;
        }

        public Criteria andOrderhosppriceGreaterThan(BigDecimal value) {
            addCriterion("OrderHospPrice >", value, "orderhospprice");
            return (Criteria) this;
        }

        public Criteria andOrderhosppriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OrderHospPrice >=", value, "orderhospprice");
            return (Criteria) this;
        }

        public Criteria andOrderhosppriceLessThan(BigDecimal value) {
            addCriterion("OrderHospPrice <", value, "orderhospprice");
            return (Criteria) this;
        }

        public Criteria andOrderhosppriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OrderHospPrice <=", value, "orderhospprice");
            return (Criteria) this;
        }

        public Criteria andOrderhosppriceIn(List<BigDecimal> values) {
            addCriterion("OrderHospPrice in", values, "orderhospprice");
            return (Criteria) this;
        }

        public Criteria andOrderhosppriceNotIn(List<BigDecimal> values) {
            addCriterion("OrderHospPrice not in", values, "orderhospprice");
            return (Criteria) this;
        }

        public Criteria andOrderhosppriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OrderHospPrice between", value1, value2, "orderhospprice");
            return (Criteria) this;
        }

        public Criteria andOrderhosppriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OrderHospPrice not between", value1, value2, "orderhospprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorpriceIsNull() {
            addCriterion("OrderDoctorPrice is null");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorpriceIsNotNull() {
            addCriterion("OrderDoctorPrice is not null");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorpriceEqualTo(BigDecimal value) {
            addCriterion("OrderDoctorPrice =", value, "orderdoctorprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorpriceNotEqualTo(BigDecimal value) {
            addCriterion("OrderDoctorPrice <>", value, "orderdoctorprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorpriceGreaterThan(BigDecimal value) {
            addCriterion("OrderDoctorPrice >", value, "orderdoctorprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OrderDoctorPrice >=", value, "orderdoctorprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorpriceLessThan(BigDecimal value) {
            addCriterion("OrderDoctorPrice <", value, "orderdoctorprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OrderDoctorPrice <=", value, "orderdoctorprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorpriceIn(List<BigDecimal> values) {
            addCriterion("OrderDoctorPrice in", values, "orderdoctorprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorpriceNotIn(List<BigDecimal> values) {
            addCriterion("OrderDoctorPrice not in", values, "orderdoctorprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OrderDoctorPrice between", value1, value2, "orderdoctorprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OrderDoctorPrice not between", value1, value2, "orderdoctorprice");
            return (Criteria) this;
        }

        public Criteria andOrderhosptpricetypeIsNull() {
            addCriterion("OrderHospTPriceType is null");
            return (Criteria) this;
        }

        public Criteria andOrderhosptpricetypeIsNotNull() {
            addCriterion("OrderHospTPriceType is not null");
            return (Criteria) this;
        }

        public Criteria andOrderhosptpricetypeEqualTo(Integer value) {
            addCriterion("OrderHospTPriceType =", value, "orderhosptpricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhosptpricetypeNotEqualTo(Integer value) {
            addCriterion("OrderHospTPriceType <>", value, "orderhosptpricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhosptpricetypeGreaterThan(Integer value) {
            addCriterion("OrderHospTPriceType >", value, "orderhosptpricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhosptpricetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("OrderHospTPriceType >=", value, "orderhosptpricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhosptpricetypeLessThan(Integer value) {
            addCriterion("OrderHospTPriceType <", value, "orderhosptpricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhosptpricetypeLessThanOrEqualTo(Integer value) {
            addCriterion("OrderHospTPriceType <=", value, "orderhosptpricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhosptpricetypeIn(List<Integer> values) {
            addCriterion("OrderHospTPriceType in", values, "orderhosptpricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhosptpricetypeNotIn(List<Integer> values) {
            addCriterion("OrderHospTPriceType not in", values, "orderhosptpricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhosptpricetypeBetween(Integer value1, Integer value2) {
            addCriterion("OrderHospTPriceType between", value1, value2, "orderhosptpricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhosptpricetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("OrderHospTPriceType not between", value1, value2, "orderhosptpricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhosptpriceIsNull() {
            addCriterion("OrderHospTPrice is null");
            return (Criteria) this;
        }

        public Criteria andOrderhosptpriceIsNotNull() {
            addCriterion("OrderHospTPrice is not null");
            return (Criteria) this;
        }

        public Criteria andOrderhosptpriceEqualTo(BigDecimal value) {
            addCriterion("OrderHospTPrice =", value, "orderhosptprice");
            return (Criteria) this;
        }

        public Criteria andOrderhosptpriceNotEqualTo(BigDecimal value) {
            addCriterion("OrderHospTPrice <>", value, "orderhosptprice");
            return (Criteria) this;
        }

        public Criteria andOrderhosptpriceGreaterThan(BigDecimal value) {
            addCriterion("OrderHospTPrice >", value, "orderhosptprice");
            return (Criteria) this;
        }

        public Criteria andOrderhosptpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OrderHospTPrice >=", value, "orderhosptprice");
            return (Criteria) this;
        }

        public Criteria andOrderhosptpriceLessThan(BigDecimal value) {
            addCriterion("OrderHospTPrice <", value, "orderhosptprice");
            return (Criteria) this;
        }

        public Criteria andOrderhosptpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OrderHospTPrice <=", value, "orderhosptprice");
            return (Criteria) this;
        }

        public Criteria andOrderhosptpriceIn(List<BigDecimal> values) {
            addCriterion("OrderHospTPrice in", values, "orderhosptprice");
            return (Criteria) this;
        }

        public Criteria andOrderhosptpriceNotIn(List<BigDecimal> values) {
            addCriterion("OrderHospTPrice not in", values, "orderhosptprice");
            return (Criteria) this;
        }

        public Criteria andOrderhosptpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OrderHospTPrice between", value1, value2, "orderhosptprice");
            return (Criteria) this;
        }

        public Criteria andOrderhosptpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OrderHospTPrice not between", value1, value2, "orderhosptprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctortpricetypeIsNull() {
            addCriterion("OrderDoctorTPriceType is null");
            return (Criteria) this;
        }

        public Criteria andOrderdoctortpricetypeIsNotNull() {
            addCriterion("OrderDoctorTPriceType is not null");
            return (Criteria) this;
        }

        public Criteria andOrderdoctortpricetypeEqualTo(Integer value) {
            addCriterion("OrderDoctorTPriceType =", value, "orderdoctortpricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctortpricetypeNotEqualTo(Integer value) {
            addCriterion("OrderDoctorTPriceType <>", value, "orderdoctortpricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctortpricetypeGreaterThan(Integer value) {
            addCriterion("OrderDoctorTPriceType >", value, "orderdoctortpricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctortpricetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("OrderDoctorTPriceType >=", value, "orderdoctortpricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctortpricetypeLessThan(Integer value) {
            addCriterion("OrderDoctorTPriceType <", value, "orderdoctortpricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctortpricetypeLessThanOrEqualTo(Integer value) {
            addCriterion("OrderDoctorTPriceType <=", value, "orderdoctortpricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctortpricetypeIn(List<Integer> values) {
            addCriterion("OrderDoctorTPriceType in", values, "orderdoctortpricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctortpricetypeNotIn(List<Integer> values) {
            addCriterion("OrderDoctorTPriceType not in", values, "orderdoctortpricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctortpricetypeBetween(Integer value1, Integer value2) {
            addCriterion("OrderDoctorTPriceType between", value1, value2, "orderdoctortpricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctortpricetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("OrderDoctorTPriceType not between", value1, value2, "orderdoctortpricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctortpriceIsNull() {
            addCriterion("OrderDoctorTPrice is null");
            return (Criteria) this;
        }

        public Criteria andOrderdoctortpriceIsNotNull() {
            addCriterion("OrderDoctorTPrice is not null");
            return (Criteria) this;
        }

        public Criteria andOrderdoctortpriceEqualTo(BigDecimal value) {
            addCriterion("OrderDoctorTPrice =", value, "orderdoctortprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctortpriceNotEqualTo(BigDecimal value) {
            addCriterion("OrderDoctorTPrice <>", value, "orderdoctortprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctortpriceGreaterThan(BigDecimal value) {
            addCriterion("OrderDoctorTPrice >", value, "orderdoctortprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctortpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OrderDoctorTPrice >=", value, "orderdoctortprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctortpriceLessThan(BigDecimal value) {
            addCriterion("OrderDoctorTPrice <", value, "orderdoctortprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctortpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OrderDoctorTPrice <=", value, "orderdoctortprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctortpriceIn(List<BigDecimal> values) {
            addCriterion("OrderDoctorTPrice in", values, "orderdoctortprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctortpriceNotIn(List<BigDecimal> values) {
            addCriterion("OrderDoctorTPrice not in", values, "orderdoctortprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctortpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OrderDoctorTPrice between", value1, value2, "orderdoctortprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctortpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OrderDoctorTPrice not between", value1, value2, "orderdoctortprice");
            return (Criteria) this;
        }

        public Criteria andOrderhospapricetypeIsNull() {
            addCriterion("OrderHospAPriceType is null");
            return (Criteria) this;
        }

        public Criteria andOrderhospapricetypeIsNotNull() {
            addCriterion("OrderHospAPriceType is not null");
            return (Criteria) this;
        }

        public Criteria andOrderhospapricetypeEqualTo(Integer value) {
            addCriterion("OrderHospAPriceType =", value, "orderhospapricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhospapricetypeNotEqualTo(Integer value) {
            addCriterion("OrderHospAPriceType <>", value, "orderhospapricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhospapricetypeGreaterThan(Integer value) {
            addCriterion("OrderHospAPriceType >", value, "orderhospapricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhospapricetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("OrderHospAPriceType >=", value, "orderhospapricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhospapricetypeLessThan(Integer value) {
            addCriterion("OrderHospAPriceType <", value, "orderhospapricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhospapricetypeLessThanOrEqualTo(Integer value) {
            addCriterion("OrderHospAPriceType <=", value, "orderhospapricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhospapricetypeIn(List<Integer> values) {
            addCriterion("OrderHospAPriceType in", values, "orderhospapricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhospapricetypeNotIn(List<Integer> values) {
            addCriterion("OrderHospAPriceType not in", values, "orderhospapricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhospapricetypeBetween(Integer value1, Integer value2) {
            addCriterion("OrderHospAPriceType between", value1, value2, "orderhospapricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhospapricetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("OrderHospAPriceType not between", value1, value2, "orderhospapricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhospapriceIsNull() {
            addCriterion("OrderHospAPrice is null");
            return (Criteria) this;
        }

        public Criteria andOrderhospapriceIsNotNull() {
            addCriterion("OrderHospAPrice is not null");
            return (Criteria) this;
        }

        public Criteria andOrderhospapriceEqualTo(BigDecimal value) {
            addCriterion("OrderHospAPrice =", value, "orderhospaprice");
            return (Criteria) this;
        }

        public Criteria andOrderhospapriceNotEqualTo(BigDecimal value) {
            addCriterion("OrderHospAPrice <>", value, "orderhospaprice");
            return (Criteria) this;
        }

        public Criteria andOrderhospapriceGreaterThan(BigDecimal value) {
            addCriterion("OrderHospAPrice >", value, "orderhospaprice");
            return (Criteria) this;
        }

        public Criteria andOrderhospapriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OrderHospAPrice >=", value, "orderhospaprice");
            return (Criteria) this;
        }

        public Criteria andOrderhospapriceLessThan(BigDecimal value) {
            addCriterion("OrderHospAPrice <", value, "orderhospaprice");
            return (Criteria) this;
        }

        public Criteria andOrderhospapriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OrderHospAPrice <=", value, "orderhospaprice");
            return (Criteria) this;
        }

        public Criteria andOrderhospapriceIn(List<BigDecimal> values) {
            addCriterion("OrderHospAPrice in", values, "orderhospaprice");
            return (Criteria) this;
        }

        public Criteria andOrderhospapriceNotIn(List<BigDecimal> values) {
            addCriterion("OrderHospAPrice not in", values, "orderhospaprice");
            return (Criteria) this;
        }

        public Criteria andOrderhospapriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OrderHospAPrice between", value1, value2, "orderhospaprice");
            return (Criteria) this;
        }

        public Criteria andOrderhospapriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OrderHospAPrice not between", value1, value2, "orderhospaprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorapricetypeIsNull() {
            addCriterion("OrderDoctorAPriceType is null");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorapricetypeIsNotNull() {
            addCriterion("OrderDoctorAPriceType is not null");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorapricetypeEqualTo(Integer value) {
            addCriterion("OrderDoctorAPriceType =", value, "orderdoctorapricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorapricetypeNotEqualTo(Integer value) {
            addCriterion("OrderDoctorAPriceType <>", value, "orderdoctorapricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorapricetypeGreaterThan(Integer value) {
            addCriterion("OrderDoctorAPriceType >", value, "orderdoctorapricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorapricetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("OrderDoctorAPriceType >=", value, "orderdoctorapricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorapricetypeLessThan(Integer value) {
            addCriterion("OrderDoctorAPriceType <", value, "orderdoctorapricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorapricetypeLessThanOrEqualTo(Integer value) {
            addCriterion("OrderDoctorAPriceType <=", value, "orderdoctorapricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorapricetypeIn(List<Integer> values) {
            addCriterion("OrderDoctorAPriceType in", values, "orderdoctorapricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorapricetypeNotIn(List<Integer> values) {
            addCriterion("OrderDoctorAPriceType not in", values, "orderdoctorapricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorapricetypeBetween(Integer value1, Integer value2) {
            addCriterion("OrderDoctorAPriceType between", value1, value2, "orderdoctorapricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorapricetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("OrderDoctorAPriceType not between", value1, value2, "orderdoctorapricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorapriceIsNull() {
            addCriterion("OrderDoctorAPrice is null");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorapriceIsNotNull() {
            addCriterion("OrderDoctorAPrice is not null");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorapriceEqualTo(BigDecimal value) {
            addCriterion("OrderDoctorAPrice =", value, "orderdoctoraprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorapriceNotEqualTo(BigDecimal value) {
            addCriterion("OrderDoctorAPrice <>", value, "orderdoctoraprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorapriceGreaterThan(BigDecimal value) {
            addCriterion("OrderDoctorAPrice >", value, "orderdoctoraprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorapriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OrderDoctorAPrice >=", value, "orderdoctoraprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorapriceLessThan(BigDecimal value) {
            addCriterion("OrderDoctorAPrice <", value, "orderdoctoraprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorapriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OrderDoctorAPrice <=", value, "orderdoctoraprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorapriceIn(List<BigDecimal> values) {
            addCriterion("OrderDoctorAPrice in", values, "orderdoctoraprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorapriceNotIn(List<BigDecimal> values) {
            addCriterion("OrderDoctorAPrice not in", values, "orderdoctoraprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorapriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OrderDoctorAPrice between", value1, value2, "orderdoctoraprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorapriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OrderDoctorAPrice not between", value1, value2, "orderdoctoraprice");
            return (Criteria) this;
        }

        public Criteria andOrderhospepricetypeIsNull() {
            addCriterion("OrderHospEPriceType is null");
            return (Criteria) this;
        }

        public Criteria andOrderhospepricetypeIsNotNull() {
            addCriterion("OrderHospEPriceType is not null");
            return (Criteria) this;
        }

        public Criteria andOrderhospepricetypeEqualTo(Integer value) {
            addCriterion("OrderHospEPriceType =", value, "orderhospepricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhospepricetypeNotEqualTo(Integer value) {
            addCriterion("OrderHospEPriceType <>", value, "orderhospepricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhospepricetypeGreaterThan(Integer value) {
            addCriterion("OrderHospEPriceType >", value, "orderhospepricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhospepricetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("OrderHospEPriceType >=", value, "orderhospepricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhospepricetypeLessThan(Integer value) {
            addCriterion("OrderHospEPriceType <", value, "orderhospepricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhospepricetypeLessThanOrEqualTo(Integer value) {
            addCriterion("OrderHospEPriceType <=", value, "orderhospepricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhospepricetypeIn(List<Integer> values) {
            addCriterion("OrderHospEPriceType in", values, "orderhospepricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhospepricetypeNotIn(List<Integer> values) {
            addCriterion("OrderHospEPriceType not in", values, "orderhospepricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhospepricetypeBetween(Integer value1, Integer value2) {
            addCriterion("OrderHospEPriceType between", value1, value2, "orderhospepricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhospepricetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("OrderHospEPriceType not between", value1, value2, "orderhospepricetype");
            return (Criteria) this;
        }

        public Criteria andOrderhospepriceIsNull() {
            addCriterion("OrderHospEPrice is null");
            return (Criteria) this;
        }

        public Criteria andOrderhospepriceIsNotNull() {
            addCriterion("OrderHospEPrice is not null");
            return (Criteria) this;
        }

        public Criteria andOrderhospepriceEqualTo(BigDecimal value) {
            addCriterion("OrderHospEPrice =", value, "orderhospeprice");
            return (Criteria) this;
        }

        public Criteria andOrderhospepriceNotEqualTo(BigDecimal value) {
            addCriterion("OrderHospEPrice <>", value, "orderhospeprice");
            return (Criteria) this;
        }

        public Criteria andOrderhospepriceGreaterThan(BigDecimal value) {
            addCriterion("OrderHospEPrice >", value, "orderhospeprice");
            return (Criteria) this;
        }

        public Criteria andOrderhospepriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OrderHospEPrice >=", value, "orderhospeprice");
            return (Criteria) this;
        }

        public Criteria andOrderhospepriceLessThan(BigDecimal value) {
            addCriterion("OrderHospEPrice <", value, "orderhospeprice");
            return (Criteria) this;
        }

        public Criteria andOrderhospepriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OrderHospEPrice <=", value, "orderhospeprice");
            return (Criteria) this;
        }

        public Criteria andOrderhospepriceIn(List<BigDecimal> values) {
            addCriterion("OrderHospEPrice in", values, "orderhospeprice");
            return (Criteria) this;
        }

        public Criteria andOrderhospepriceNotIn(List<BigDecimal> values) {
            addCriterion("OrderHospEPrice not in", values, "orderhospeprice");
            return (Criteria) this;
        }

        public Criteria andOrderhospepriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OrderHospEPrice between", value1, value2, "orderhospeprice");
            return (Criteria) this;
        }

        public Criteria andOrderhospepriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OrderHospEPrice not between", value1, value2, "orderhospeprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorepricetypeIsNull() {
            addCriterion("OrderDoctorEPriceType is null");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorepricetypeIsNotNull() {
            addCriterion("OrderDoctorEPriceType is not null");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorepricetypeEqualTo(Integer value) {
            addCriterion("OrderDoctorEPriceType =", value, "orderdoctorepricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorepricetypeNotEqualTo(Integer value) {
            addCriterion("OrderDoctorEPriceType <>", value, "orderdoctorepricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorepricetypeGreaterThan(Integer value) {
            addCriterion("OrderDoctorEPriceType >", value, "orderdoctorepricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorepricetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("OrderDoctorEPriceType >=", value, "orderdoctorepricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorepricetypeLessThan(Integer value) {
            addCriterion("OrderDoctorEPriceType <", value, "orderdoctorepricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorepricetypeLessThanOrEqualTo(Integer value) {
            addCriterion("OrderDoctorEPriceType <=", value, "orderdoctorepricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorepricetypeIn(List<Integer> values) {
            addCriterion("OrderDoctorEPriceType in", values, "orderdoctorepricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorepricetypeNotIn(List<Integer> values) {
            addCriterion("OrderDoctorEPriceType not in", values, "orderdoctorepricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorepricetypeBetween(Integer value1, Integer value2) {
            addCriterion("OrderDoctorEPriceType between", value1, value2, "orderdoctorepricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorepricetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("OrderDoctorEPriceType not between", value1, value2, "orderdoctorepricetype");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorepriceIsNull() {
            addCriterion("OrderDoctorEPrice is null");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorepriceIsNotNull() {
            addCriterion("OrderDoctorEPrice is not null");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorepriceEqualTo(BigDecimal value) {
            addCriterion("OrderDoctorEPrice =", value, "orderdoctoreprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorepriceNotEqualTo(BigDecimal value) {
            addCriterion("OrderDoctorEPrice <>", value, "orderdoctoreprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorepriceGreaterThan(BigDecimal value) {
            addCriterion("OrderDoctorEPrice >", value, "orderdoctoreprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorepriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OrderDoctorEPrice >=", value, "orderdoctoreprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorepriceLessThan(BigDecimal value) {
            addCriterion("OrderDoctorEPrice <", value, "orderdoctoreprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorepriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OrderDoctorEPrice <=", value, "orderdoctoreprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorepriceIn(List<BigDecimal> values) {
            addCriterion("OrderDoctorEPrice in", values, "orderdoctoreprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorepriceNotIn(List<BigDecimal> values) {
            addCriterion("OrderDoctorEPrice not in", values, "orderdoctoreprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorepriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OrderDoctorEPrice between", value1, value2, "orderdoctoreprice");
            return (Criteria) this;
        }

        public Criteria andOrderdoctorepriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OrderDoctorEPrice not between", value1, value2, "orderdoctoreprice");
            return (Criteria) this;
        }

        public Criteria andOrdertotalhosppriceIsNull() {
            addCriterion("OrderTotalHospPrice is null");
            return (Criteria) this;
        }

        public Criteria andOrdertotalhosppriceIsNotNull() {
            addCriterion("OrderTotalHospPrice is not null");
            return (Criteria) this;
        }

        public Criteria andOrdertotalhosppriceEqualTo(BigDecimal value) {
            addCriterion("OrderTotalHospPrice =", value, "ordertotalhospprice");
            return (Criteria) this;
        }

        public Criteria andOrdertotalhosppriceNotEqualTo(BigDecimal value) {
            addCriterion("OrderTotalHospPrice <>", value, "ordertotalhospprice");
            return (Criteria) this;
        }

        public Criteria andOrdertotalhosppriceGreaterThan(BigDecimal value) {
            addCriterion("OrderTotalHospPrice >", value, "ordertotalhospprice");
            return (Criteria) this;
        }

        public Criteria andOrdertotalhosppriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OrderTotalHospPrice >=", value, "ordertotalhospprice");
            return (Criteria) this;
        }

        public Criteria andOrdertotalhosppriceLessThan(BigDecimal value) {
            addCriterion("OrderTotalHospPrice <", value, "ordertotalhospprice");
            return (Criteria) this;
        }

        public Criteria andOrdertotalhosppriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OrderTotalHospPrice <=", value, "ordertotalhospprice");
            return (Criteria) this;
        }

        public Criteria andOrdertotalhosppriceIn(List<BigDecimal> values) {
            addCriterion("OrderTotalHospPrice in", values, "ordertotalhospprice");
            return (Criteria) this;
        }

        public Criteria andOrdertotalhosppriceNotIn(List<BigDecimal> values) {
            addCriterion("OrderTotalHospPrice not in", values, "ordertotalhospprice");
            return (Criteria) this;
        }

        public Criteria andOrdertotalhosppriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OrderTotalHospPrice between", value1, value2, "ordertotalhospprice");
            return (Criteria) this;
        }

        public Criteria andOrdertotalhosppriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OrderTotalHospPrice not between", value1, value2, "ordertotalhospprice");
            return (Criteria) this;
        }

        public Criteria andOrdertotaldoctorpriceIsNull() {
            addCriterion("OrderTotalDoctorPrice is null");
            return (Criteria) this;
        }

        public Criteria andOrdertotaldoctorpriceIsNotNull() {
            addCriterion("OrderTotalDoctorPrice is not null");
            return (Criteria) this;
        }

        public Criteria andOrdertotaldoctorpriceEqualTo(BigDecimal value) {
            addCriterion("OrderTotalDoctorPrice =", value, "ordertotaldoctorprice");
            return (Criteria) this;
        }

        public Criteria andOrdertotaldoctorpriceNotEqualTo(BigDecimal value) {
            addCriterion("OrderTotalDoctorPrice <>", value, "ordertotaldoctorprice");
            return (Criteria) this;
        }

        public Criteria andOrdertotaldoctorpriceGreaterThan(BigDecimal value) {
            addCriterion("OrderTotalDoctorPrice >", value, "ordertotaldoctorprice");
            return (Criteria) this;
        }

        public Criteria andOrdertotaldoctorpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OrderTotalDoctorPrice >=", value, "ordertotaldoctorprice");
            return (Criteria) this;
        }

        public Criteria andOrdertotaldoctorpriceLessThan(BigDecimal value) {
            addCriterion("OrderTotalDoctorPrice <", value, "ordertotaldoctorprice");
            return (Criteria) this;
        }

        public Criteria andOrdertotaldoctorpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OrderTotalDoctorPrice <=", value, "ordertotaldoctorprice");
            return (Criteria) this;
        }

        public Criteria andOrdertotaldoctorpriceIn(List<BigDecimal> values) {
            addCriterion("OrderTotalDoctorPrice in", values, "ordertotaldoctorprice");
            return (Criteria) this;
        }

        public Criteria andOrdertotaldoctorpriceNotIn(List<BigDecimal> values) {
            addCriterion("OrderTotalDoctorPrice not in", values, "ordertotaldoctorprice");
            return (Criteria) this;
        }

        public Criteria andOrdertotaldoctorpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OrderTotalDoctorPrice between", value1, value2, "ordertotaldoctorprice");
            return (Criteria) this;
        }

        public Criteria andOrdertotaldoctorpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OrderTotalDoctorPrice not between", value1, value2, "ordertotaldoctorprice");
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