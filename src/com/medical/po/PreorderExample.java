package com.medical.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PreorderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PreorderExample() {
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

        public Criteria andPreorderidIsNull() {
            addCriterion("preOrderId is null");
            return (Criteria) this;
        }

        public Criteria andPreorderidIsNotNull() {
            addCriterion("preOrderId is not null");
            return (Criteria) this;
        }

        public Criteria andPreorderidEqualTo(Integer value) {
            addCriterion("preOrderId =", value, "preorderid");
            return (Criteria) this;
        }

        public Criteria andPreorderidNotEqualTo(Integer value) {
            addCriterion("preOrderId <>", value, "preorderid");
            return (Criteria) this;
        }

        public Criteria andPreorderidGreaterThan(Integer value) {
            addCriterion("preOrderId >", value, "preorderid");
            return (Criteria) this;
        }

        public Criteria andPreorderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("preOrderId >=", value, "preorderid");
            return (Criteria) this;
        }

        public Criteria andPreorderidLessThan(Integer value) {
            addCriterion("preOrderId <", value, "preorderid");
            return (Criteria) this;
        }

        public Criteria andPreorderidLessThanOrEqualTo(Integer value) {
            addCriterion("preOrderId <=", value, "preorderid");
            return (Criteria) this;
        }

        public Criteria andPreorderidIn(List<Integer> values) {
            addCriterion("preOrderId in", values, "preorderid");
            return (Criteria) this;
        }

        public Criteria andPreorderidNotIn(List<Integer> values) {
            addCriterion("preOrderId not in", values, "preorderid");
            return (Criteria) this;
        }

        public Criteria andPreorderidBetween(Integer value1, Integer value2) {
            addCriterion("preOrderId between", value1, value2, "preorderid");
            return (Criteria) this;
        }

        public Criteria andPreorderidNotBetween(Integer value1, Integer value2) {
            addCriterion("preOrderId not between", value1, value2, "preorderid");
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

        public Criteria andPreordertypeIsNull() {
            addCriterion("preOrderType is null");
            return (Criteria) this;
        }

        public Criteria andPreordertypeIsNotNull() {
            addCriterion("preOrderType is not null");
            return (Criteria) this;
        }

        public Criteria andPreordertypeEqualTo(Integer value) {
            addCriterion("preOrderType =", value, "preordertype");
            return (Criteria) this;
        }

        public Criteria andPreordertypeNotEqualTo(Integer value) {
            addCriterion("preOrderType <>", value, "preordertype");
            return (Criteria) this;
        }

        public Criteria andPreordertypeGreaterThan(Integer value) {
            addCriterion("preOrderType >", value, "preordertype");
            return (Criteria) this;
        }

        public Criteria andPreordertypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("preOrderType >=", value, "preordertype");
            return (Criteria) this;
        }

        public Criteria andPreordertypeLessThan(Integer value) {
            addCriterion("preOrderType <", value, "preordertype");
            return (Criteria) this;
        }

        public Criteria andPreordertypeLessThanOrEqualTo(Integer value) {
            addCriterion("preOrderType <=", value, "preordertype");
            return (Criteria) this;
        }

        public Criteria andPreordertypeIn(List<Integer> values) {
            addCriterion("preOrderType in", values, "preordertype");
            return (Criteria) this;
        }

        public Criteria andPreordertypeNotIn(List<Integer> values) {
            addCriterion("preOrderType not in", values, "preordertype");
            return (Criteria) this;
        }

        public Criteria andPreordertypeBetween(Integer value1, Integer value2) {
            addCriterion("preOrderType between", value1, value2, "preordertype");
            return (Criteria) this;
        }

        public Criteria andPreordertypeNotBetween(Integer value1, Integer value2) {
            addCriterion("preOrderType not between", value1, value2, "preordertype");
            return (Criteria) this;
        }

        public Criteria andPreorderstateIsNull() {
            addCriterion("preOrderState is null");
            return (Criteria) this;
        }

        public Criteria andPreorderstateIsNotNull() {
            addCriterion("preOrderState is not null");
            return (Criteria) this;
        }

        public Criteria andPreorderstateEqualTo(Integer value) {
            addCriterion("preOrderState =", value, "preorderstate");
            return (Criteria) this;
        }

        public Criteria andPreorderstateNotEqualTo(Integer value) {
            addCriterion("preOrderState <>", value, "preorderstate");
            return (Criteria) this;
        }

        public Criteria andPreorderstateGreaterThan(Integer value) {
            addCriterion("preOrderState >", value, "preorderstate");
            return (Criteria) this;
        }

        public Criteria andPreorderstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("preOrderState >=", value, "preorderstate");
            return (Criteria) this;
        }

        public Criteria andPreorderstateLessThan(Integer value) {
            addCriterion("preOrderState <", value, "preorderstate");
            return (Criteria) this;
        }

        public Criteria andPreorderstateLessThanOrEqualTo(Integer value) {
            addCriterion("preOrderState <=", value, "preorderstate");
            return (Criteria) this;
        }

        public Criteria andPreorderstateIn(List<Integer> values) {
            addCriterion("preOrderState in", values, "preorderstate");
            return (Criteria) this;
        }

        public Criteria andPreorderstateNotIn(List<Integer> values) {
            addCriterion("preOrderState not in", values, "preorderstate");
            return (Criteria) this;
        }

        public Criteria andPreorderstateBetween(Integer value1, Integer value2) {
            addCriterion("preOrderState between", value1, value2, "preorderstate");
            return (Criteria) this;
        }

        public Criteria andPreorderstateNotBetween(Integer value1, Integer value2) {
            addCriterion("preOrderState not between", value1, value2, "preorderstate");
            return (Criteria) this;
        }

        public Criteria andPreorderuserloginidIsNull() {
            addCriterion("preOrderUserLoginId is null");
            return (Criteria) this;
        }

        public Criteria andPreorderuserloginidIsNotNull() {
            addCriterion("preOrderUserLoginId is not null");
            return (Criteria) this;
        }

        public Criteria andPreorderuserloginidEqualTo(Integer value) {
            addCriterion("preOrderUserLoginId =", value, "preorderuserloginid");
            return (Criteria) this;
        }

        public Criteria andPreorderuserloginidNotEqualTo(Integer value) {
            addCriterion("preOrderUserLoginId <>", value, "preorderuserloginid");
            return (Criteria) this;
        }

        public Criteria andPreorderuserloginidGreaterThan(Integer value) {
            addCriterion("preOrderUserLoginId >", value, "preorderuserloginid");
            return (Criteria) this;
        }

        public Criteria andPreorderuserloginidGreaterThanOrEqualTo(Integer value) {
            addCriterion("preOrderUserLoginId >=", value, "preorderuserloginid");
            return (Criteria) this;
        }

        public Criteria andPreorderuserloginidLessThan(Integer value) {
            addCriterion("preOrderUserLoginId <", value, "preorderuserloginid");
            return (Criteria) this;
        }

        public Criteria andPreorderuserloginidLessThanOrEqualTo(Integer value) {
            addCriterion("preOrderUserLoginId <=", value, "preorderuserloginid");
            return (Criteria) this;
        }

        public Criteria andPreorderuserloginidIn(List<Integer> values) {
            addCriterion("preOrderUserLoginId in", values, "preorderuserloginid");
            return (Criteria) this;
        }

        public Criteria andPreorderuserloginidNotIn(List<Integer> values) {
            addCriterion("preOrderUserLoginId not in", values, "preorderuserloginid");
            return (Criteria) this;
        }

        public Criteria andPreorderuserloginidBetween(Integer value1, Integer value2) {
            addCriterion("preOrderUserLoginId between", value1, value2, "preorderuserloginid");
            return (Criteria) this;
        }

        public Criteria andPreorderuserloginidNotBetween(Integer value1, Integer value2) {
            addCriterion("preOrderUserLoginId not between", value1, value2, "preorderuserloginid");
            return (Criteria) this;
        }

        public Criteria andPreorderdocloginidIsNull() {
            addCriterion("preOrderDocLoginId is null");
            return (Criteria) this;
        }

        public Criteria andPreorderdocloginidIsNotNull() {
            addCriterion("preOrderDocLoginId is not null");
            return (Criteria) this;
        }

        public Criteria andPreorderdocloginidEqualTo(Integer value) {
            addCriterion("preOrderDocLoginId =", value, "preorderdocloginid");
            return (Criteria) this;
        }

        public Criteria andPreorderdocloginidNotEqualTo(Integer value) {
            addCriterion("preOrderDocLoginId <>", value, "preorderdocloginid");
            return (Criteria) this;
        }

        public Criteria andPreorderdocloginidGreaterThan(Integer value) {
            addCriterion("preOrderDocLoginId >", value, "preorderdocloginid");
            return (Criteria) this;
        }

        public Criteria andPreorderdocloginidGreaterThanOrEqualTo(Integer value) {
            addCriterion("preOrderDocLoginId >=", value, "preorderdocloginid");
            return (Criteria) this;
        }

        public Criteria andPreorderdocloginidLessThan(Integer value) {
            addCriterion("preOrderDocLoginId <", value, "preorderdocloginid");
            return (Criteria) this;
        }

        public Criteria andPreorderdocloginidLessThanOrEqualTo(Integer value) {
            addCriterion("preOrderDocLoginId <=", value, "preorderdocloginid");
            return (Criteria) this;
        }

        public Criteria andPreorderdocloginidIn(List<Integer> values) {
            addCriterion("preOrderDocLoginId in", values, "preorderdocloginid");
            return (Criteria) this;
        }

        public Criteria andPreorderdocloginidNotIn(List<Integer> values) {
            addCriterion("preOrderDocLoginId not in", values, "preorderdocloginid");
            return (Criteria) this;
        }

        public Criteria andPreorderdocloginidBetween(Integer value1, Integer value2) {
            addCriterion("preOrderDocLoginId between", value1, value2, "preorderdocloginid");
            return (Criteria) this;
        }

        public Criteria andPreorderdocloginidNotBetween(Integer value1, Integer value2) {
            addCriterion("preOrderDocLoginId not between", value1, value2, "preorderdocloginid");
            return (Criteria) this;
        }

        public Criteria andPreorderredocloginidIsNull() {
            addCriterion("preOrderReDocLoginId is null");
            return (Criteria) this;
        }

        public Criteria andPreorderredocloginidIsNotNull() {
            addCriterion("preOrderReDocLoginId is not null");
            return (Criteria) this;
        }

        public Criteria andPreorderredocloginidEqualTo(Integer value) {
            addCriterion("preOrderReDocLoginId =", value, "preorderredocloginid");
            return (Criteria) this;
        }

        public Criteria andPreorderredocloginidNotEqualTo(Integer value) {
            addCriterion("preOrderReDocLoginId <>", value, "preorderredocloginid");
            return (Criteria) this;
        }

        public Criteria andPreorderredocloginidGreaterThan(Integer value) {
            addCriterion("preOrderReDocLoginId >", value, "preorderredocloginid");
            return (Criteria) this;
        }

        public Criteria andPreorderredocloginidGreaterThanOrEqualTo(Integer value) {
            addCriterion("preOrderReDocLoginId >=", value, "preorderredocloginid");
            return (Criteria) this;
        }

        public Criteria andPreorderredocloginidLessThan(Integer value) {
            addCriterion("preOrderReDocLoginId <", value, "preorderredocloginid");
            return (Criteria) this;
        }

        public Criteria andPreorderredocloginidLessThanOrEqualTo(Integer value) {
            addCriterion("preOrderReDocLoginId <=", value, "preorderredocloginid");
            return (Criteria) this;
        }

        public Criteria andPreorderredocloginidIn(List<Integer> values) {
            addCriterion("preOrderReDocLoginId in", values, "preorderredocloginid");
            return (Criteria) this;
        }

        public Criteria andPreorderredocloginidNotIn(List<Integer> values) {
            addCriterion("preOrderReDocLoginId not in", values, "preorderredocloginid");
            return (Criteria) this;
        }

        public Criteria andPreorderredocloginidBetween(Integer value1, Integer value2) {
            addCriterion("preOrderReDocLoginId between", value1, value2, "preorderredocloginid");
            return (Criteria) this;
        }

        public Criteria andPreorderredocloginidNotBetween(Integer value1, Integer value2) {
            addCriterion("preOrderReDocLoginId not between", value1, value2, "preorderredocloginid");
            return (Criteria) this;
        }

        public Criteria andPreordertimeIsNull() {
            addCriterion("preOrderTime is null");
            return (Criteria) this;
        }

        public Criteria andPreordertimeIsNotNull() {
            addCriterion("preOrderTime is not null");
            return (Criteria) this;
        }

        public Criteria andPreordertimeEqualTo(Date value) {
            addCriterion("preOrderTime =", value, "preordertime");
            return (Criteria) this;
        }

        public Criteria andPreordertimeNotEqualTo(Date value) {
            addCriterion("preOrderTime <>", value, "preordertime");
            return (Criteria) this;
        }

        public Criteria andPreordertimeGreaterThan(Date value) {
            addCriterion("preOrderTime >", value, "preordertime");
            return (Criteria) this;
        }

        public Criteria andPreordertimeGreaterThanOrEqualTo(Date value) {
            addCriterion("preOrderTime >=", value, "preordertime");
            return (Criteria) this;
        }

        public Criteria andPreordertimeLessThan(Date value) {
            addCriterion("preOrderTime <", value, "preordertime");
            return (Criteria) this;
        }

        public Criteria andPreordertimeLessThanOrEqualTo(Date value) {
            addCriterion("preOrderTime <=", value, "preordertime");
            return (Criteria) this;
        }

        public Criteria andPreordertimeIn(List<Date> values) {
            addCriterion("preOrderTime in", values, "preordertime");
            return (Criteria) this;
        }

        public Criteria andPreordertimeNotIn(List<Date> values) {
            addCriterion("preOrderTime not in", values, "preordertime");
            return (Criteria) this;
        }

        public Criteria andPreordertimeBetween(Date value1, Date value2) {
            addCriterion("preOrderTime between", value1, value2, "preordertime");
            return (Criteria) this;
        }

        public Criteria andPreordertimeNotBetween(Date value1, Date value2) {
            addCriterion("preOrderTime not between", value1, value2, "preordertime");
            return (Criteria) this;
        }

        public Criteria andPreorderdpriceIsNull() {
            addCriterion("preOrderDPrice is null");
            return (Criteria) this;
        }

        public Criteria andPreorderdpriceIsNotNull() {
            addCriterion("preOrderDPrice is not null");
            return (Criteria) this;
        }

        public Criteria andPreorderdpriceEqualTo(BigDecimal value) {
            addCriterion("preOrderDPrice =", value, "preorderdprice");
            return (Criteria) this;
        }

        public Criteria andPreorderdpriceNotEqualTo(BigDecimal value) {
            addCriterion("preOrderDPrice <>", value, "preorderdprice");
            return (Criteria) this;
        }

        public Criteria andPreorderdpriceGreaterThan(BigDecimal value) {
            addCriterion("preOrderDPrice >", value, "preorderdprice");
            return (Criteria) this;
        }

        public Criteria andPreorderdpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("preOrderDPrice >=", value, "preorderdprice");
            return (Criteria) this;
        }

        public Criteria andPreorderdpriceLessThan(BigDecimal value) {
            addCriterion("preOrderDPrice <", value, "preorderdprice");
            return (Criteria) this;
        }

        public Criteria andPreorderdpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("preOrderDPrice <=", value, "preorderdprice");
            return (Criteria) this;
        }

        public Criteria andPreorderdpriceIn(List<BigDecimal> values) {
            addCriterion("preOrderDPrice in", values, "preorderdprice");
            return (Criteria) this;
        }

        public Criteria andPreorderdpriceNotIn(List<BigDecimal> values) {
            addCriterion("preOrderDPrice not in", values, "preorderdprice");
            return (Criteria) this;
        }

        public Criteria andPreorderdpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("preOrderDPrice between", value1, value2, "preorderdprice");
            return (Criteria) this;
        }

        public Criteria andPreorderdpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("preOrderDPrice not between", value1, value2, "preorderdprice");
            return (Criteria) this;
        }

        public Criteria andPreorderhstateIsNull() {
            addCriterion("preOrderHState is null");
            return (Criteria) this;
        }

        public Criteria andPreorderhstateIsNotNull() {
            addCriterion("preOrderHState is not null");
            return (Criteria) this;
        }

        public Criteria andPreorderhstateEqualTo(Byte value) {
            addCriterion("preOrderHState =", value, "preorderhstate");
            return (Criteria) this;
        }

        public Criteria andPreorderhstateNotEqualTo(Byte value) {
            addCriterion("preOrderHState <>", value, "preorderhstate");
            return (Criteria) this;
        }

        public Criteria andPreorderhstateGreaterThan(Byte value) {
            addCriterion("preOrderHState >", value, "preorderhstate");
            return (Criteria) this;
        }

        public Criteria andPreorderhstateGreaterThanOrEqualTo(Byte value) {
            addCriterion("preOrderHState >=", value, "preorderhstate");
            return (Criteria) this;
        }

        public Criteria andPreorderhstateLessThan(Byte value) {
            addCriterion("preOrderHState <", value, "preorderhstate");
            return (Criteria) this;
        }

        public Criteria andPreorderhstateLessThanOrEqualTo(Byte value) {
            addCriterion("preOrderHState <=", value, "preorderhstate");
            return (Criteria) this;
        }

        public Criteria andPreorderhstateIn(List<Byte> values) {
            addCriterion("preOrderHState in", values, "preorderhstate");
            return (Criteria) this;
        }

        public Criteria andPreorderhstateNotIn(List<Byte> values) {
            addCriterion("preOrderHState not in", values, "preorderhstate");
            return (Criteria) this;
        }

        public Criteria andPreorderhstateBetween(Byte value1, Byte value2) {
            addCriterion("preOrderHState between", value1, value2, "preorderhstate");
            return (Criteria) this;
        }

        public Criteria andPreorderhstateNotBetween(Byte value1, Byte value2) {
            addCriterion("preOrderHState not between", value1, value2, "preorderhstate");
            return (Criteria) this;
        }

        public Criteria andPreorderhpriceIsNull() {
            addCriterion("preOrderHPrice is null");
            return (Criteria) this;
        }

        public Criteria andPreorderhpriceIsNotNull() {
            addCriterion("preOrderHPrice is not null");
            return (Criteria) this;
        }

        public Criteria andPreorderhpriceEqualTo(BigDecimal value) {
            addCriterion("preOrderHPrice =", value, "preorderhprice");
            return (Criteria) this;
        }

        public Criteria andPreorderhpriceNotEqualTo(BigDecimal value) {
            addCriterion("preOrderHPrice <>", value, "preorderhprice");
            return (Criteria) this;
        }

        public Criteria andPreorderhpriceGreaterThan(BigDecimal value) {
            addCriterion("preOrderHPrice >", value, "preorderhprice");
            return (Criteria) this;
        }

        public Criteria andPreorderhpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("preOrderHPrice >=", value, "preorderhprice");
            return (Criteria) this;
        }

        public Criteria andPreorderhpriceLessThan(BigDecimal value) {
            addCriterion("preOrderHPrice <", value, "preorderhprice");
            return (Criteria) this;
        }

        public Criteria andPreorderhpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("preOrderHPrice <=", value, "preorderhprice");
            return (Criteria) this;
        }

        public Criteria andPreorderhpriceIn(List<BigDecimal> values) {
            addCriterion("preOrderHPrice in", values, "preorderhprice");
            return (Criteria) this;
        }

        public Criteria andPreorderhpriceNotIn(List<BigDecimal> values) {
            addCriterion("preOrderHPrice not in", values, "preorderhprice");
            return (Criteria) this;
        }

        public Criteria andPreorderhpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("preOrderHPrice between", value1, value2, "preorderhprice");
            return (Criteria) this;
        }

        public Criteria andPreorderhpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("preOrderHPrice not between", value1, value2, "preorderhprice");
            return (Criteria) this;
        }

        public Criteria andPreordertpricetypeIsNull() {
            addCriterion("preOrderTPriceType is null");
            return (Criteria) this;
        }

        public Criteria andPreordertpricetypeIsNotNull() {
            addCriterion("preOrderTPriceType is not null");
            return (Criteria) this;
        }

        public Criteria andPreordertpricetypeEqualTo(Integer value) {
            addCriterion("preOrderTPriceType =", value, "preordertpricetype");
            return (Criteria) this;
        }

        public Criteria andPreordertpricetypeNotEqualTo(Integer value) {
            addCriterion("preOrderTPriceType <>", value, "preordertpricetype");
            return (Criteria) this;
        }

        public Criteria andPreordertpricetypeGreaterThan(Integer value) {
            addCriterion("preOrderTPriceType >", value, "preordertpricetype");
            return (Criteria) this;
        }

        public Criteria andPreordertpricetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("preOrderTPriceType >=", value, "preordertpricetype");
            return (Criteria) this;
        }

        public Criteria andPreordertpricetypeLessThan(Integer value) {
            addCriterion("preOrderTPriceType <", value, "preordertpricetype");
            return (Criteria) this;
        }

        public Criteria andPreordertpricetypeLessThanOrEqualTo(Integer value) {
            addCriterion("preOrderTPriceType <=", value, "preordertpricetype");
            return (Criteria) this;
        }

        public Criteria andPreordertpricetypeIn(List<Integer> values) {
            addCriterion("preOrderTPriceType in", values, "preordertpricetype");
            return (Criteria) this;
        }

        public Criteria andPreordertpricetypeNotIn(List<Integer> values) {
            addCriterion("preOrderTPriceType not in", values, "preordertpricetype");
            return (Criteria) this;
        }

        public Criteria andPreordertpricetypeBetween(Integer value1, Integer value2) {
            addCriterion("preOrderTPriceType between", value1, value2, "preordertpricetype");
            return (Criteria) this;
        }

        public Criteria andPreordertpricetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("preOrderTPriceType not between", value1, value2, "preordertpricetype");
            return (Criteria) this;
        }

        public Criteria andPreordertpriceIsNull() {
            addCriterion("preOrderTPrice is null");
            return (Criteria) this;
        }

        public Criteria andPreordertpriceIsNotNull() {
            addCriterion("preOrderTPrice is not null");
            return (Criteria) this;
        }

        public Criteria andPreordertpriceEqualTo(BigDecimal value) {
            addCriterion("preOrderTPrice =", value, "preordertprice");
            return (Criteria) this;
        }

        public Criteria andPreordertpriceNotEqualTo(BigDecimal value) {
            addCriterion("preOrderTPrice <>", value, "preordertprice");
            return (Criteria) this;
        }

        public Criteria andPreordertpriceGreaterThan(BigDecimal value) {
            addCriterion("preOrderTPrice >", value, "preordertprice");
            return (Criteria) this;
        }

        public Criteria andPreordertpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("preOrderTPrice >=", value, "preordertprice");
            return (Criteria) this;
        }

        public Criteria andPreordertpriceLessThan(BigDecimal value) {
            addCriterion("preOrderTPrice <", value, "preordertprice");
            return (Criteria) this;
        }

        public Criteria andPreordertpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("preOrderTPrice <=", value, "preordertprice");
            return (Criteria) this;
        }

        public Criteria andPreordertpriceIn(List<BigDecimal> values) {
            addCriterion("preOrderTPrice in", values, "preordertprice");
            return (Criteria) this;
        }

        public Criteria andPreordertpriceNotIn(List<BigDecimal> values) {
            addCriterion("preOrderTPrice not in", values, "preordertprice");
            return (Criteria) this;
        }

        public Criteria andPreordertpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("preOrderTPrice between", value1, value2, "preordertprice");
            return (Criteria) this;
        }

        public Criteria andPreordertpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("preOrderTPrice not between", value1, value2, "preordertprice");
            return (Criteria) this;
        }

        public Criteria andPreorderapricetypeIsNull() {
            addCriterion("preOrderAPriceType is null");
            return (Criteria) this;
        }

        public Criteria andPreorderapricetypeIsNotNull() {
            addCriterion("preOrderAPriceType is not null");
            return (Criteria) this;
        }

        public Criteria andPreorderapricetypeEqualTo(Integer value) {
            addCriterion("preOrderAPriceType =", value, "preorderapricetype");
            return (Criteria) this;
        }

        public Criteria andPreorderapricetypeNotEqualTo(Integer value) {
            addCriterion("preOrderAPriceType <>", value, "preorderapricetype");
            return (Criteria) this;
        }

        public Criteria andPreorderapricetypeGreaterThan(Integer value) {
            addCriterion("preOrderAPriceType >", value, "preorderapricetype");
            return (Criteria) this;
        }

        public Criteria andPreorderapricetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("preOrderAPriceType >=", value, "preorderapricetype");
            return (Criteria) this;
        }

        public Criteria andPreorderapricetypeLessThan(Integer value) {
            addCriterion("preOrderAPriceType <", value, "preorderapricetype");
            return (Criteria) this;
        }

        public Criteria andPreorderapricetypeLessThanOrEqualTo(Integer value) {
            addCriterion("preOrderAPriceType <=", value, "preorderapricetype");
            return (Criteria) this;
        }

        public Criteria andPreorderapricetypeIn(List<Integer> values) {
            addCriterion("preOrderAPriceType in", values, "preorderapricetype");
            return (Criteria) this;
        }

        public Criteria andPreorderapricetypeNotIn(List<Integer> values) {
            addCriterion("preOrderAPriceType not in", values, "preorderapricetype");
            return (Criteria) this;
        }

        public Criteria andPreorderapricetypeBetween(Integer value1, Integer value2) {
            addCriterion("preOrderAPriceType between", value1, value2, "preorderapricetype");
            return (Criteria) this;
        }

        public Criteria andPreorderapricetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("preOrderAPriceType not between", value1, value2, "preorderapricetype");
            return (Criteria) this;
        }

        public Criteria andPreorderapriceIsNull() {
            addCriterion("preOrderAPrice is null");
            return (Criteria) this;
        }

        public Criteria andPreorderapriceIsNotNull() {
            addCriterion("preOrderAPrice is not null");
            return (Criteria) this;
        }

        public Criteria andPreorderapriceEqualTo(BigDecimal value) {
            addCriterion("preOrderAPrice =", value, "preorderaprice");
            return (Criteria) this;
        }

        public Criteria andPreorderapriceNotEqualTo(BigDecimal value) {
            addCriterion("preOrderAPrice <>", value, "preorderaprice");
            return (Criteria) this;
        }

        public Criteria andPreorderapriceGreaterThan(BigDecimal value) {
            addCriterion("preOrderAPrice >", value, "preorderaprice");
            return (Criteria) this;
        }

        public Criteria andPreorderapriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("preOrderAPrice >=", value, "preorderaprice");
            return (Criteria) this;
        }

        public Criteria andPreorderapriceLessThan(BigDecimal value) {
            addCriterion("preOrderAPrice <", value, "preorderaprice");
            return (Criteria) this;
        }

        public Criteria andPreorderapriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("preOrderAPrice <=", value, "preorderaprice");
            return (Criteria) this;
        }

        public Criteria andPreorderapriceIn(List<BigDecimal> values) {
            addCriterion("preOrderAPrice in", values, "preorderaprice");
            return (Criteria) this;
        }

        public Criteria andPreorderapriceNotIn(List<BigDecimal> values) {
            addCriterion("preOrderAPrice not in", values, "preorderaprice");
            return (Criteria) this;
        }

        public Criteria andPreorderapriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("preOrderAPrice between", value1, value2, "preorderaprice");
            return (Criteria) this;
        }

        public Criteria andPreorderapriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("preOrderAPrice not between", value1, value2, "preorderaprice");
            return (Criteria) this;
        }

        public Criteria andPreorderepricetypeIsNull() {
            addCriterion("preOrderEPriceType is null");
            return (Criteria) this;
        }

        public Criteria andPreorderepricetypeIsNotNull() {
            addCriterion("preOrderEPriceType is not null");
            return (Criteria) this;
        }

        public Criteria andPreorderepricetypeEqualTo(Integer value) {
            addCriterion("preOrderEPriceType =", value, "preorderepricetype");
            return (Criteria) this;
        }

        public Criteria andPreorderepricetypeNotEqualTo(Integer value) {
            addCriterion("preOrderEPriceType <>", value, "preorderepricetype");
            return (Criteria) this;
        }

        public Criteria andPreorderepricetypeGreaterThan(Integer value) {
            addCriterion("preOrderEPriceType >", value, "preorderepricetype");
            return (Criteria) this;
        }

        public Criteria andPreorderepricetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("preOrderEPriceType >=", value, "preorderepricetype");
            return (Criteria) this;
        }

        public Criteria andPreorderepricetypeLessThan(Integer value) {
            addCriterion("preOrderEPriceType <", value, "preorderepricetype");
            return (Criteria) this;
        }

        public Criteria andPreorderepricetypeLessThanOrEqualTo(Integer value) {
            addCriterion("preOrderEPriceType <=", value, "preorderepricetype");
            return (Criteria) this;
        }

        public Criteria andPreorderepricetypeIn(List<Integer> values) {
            addCriterion("preOrderEPriceType in", values, "preorderepricetype");
            return (Criteria) this;
        }

        public Criteria andPreorderepricetypeNotIn(List<Integer> values) {
            addCriterion("preOrderEPriceType not in", values, "preorderepricetype");
            return (Criteria) this;
        }

        public Criteria andPreorderepricetypeBetween(Integer value1, Integer value2) {
            addCriterion("preOrderEPriceType between", value1, value2, "preorderepricetype");
            return (Criteria) this;
        }

        public Criteria andPreorderepricetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("preOrderEPriceType not between", value1, value2, "preorderepricetype");
            return (Criteria) this;
        }

        public Criteria andPreorderepriceIsNull() {
            addCriterion("preOrderEPrice is null");
            return (Criteria) this;
        }

        public Criteria andPreorderepriceIsNotNull() {
            addCriterion("preOrderEPrice is not null");
            return (Criteria) this;
        }

        public Criteria andPreorderepriceEqualTo(BigDecimal value) {
            addCriterion("preOrderEPrice =", value, "preordereprice");
            return (Criteria) this;
        }

        public Criteria andPreorderepriceNotEqualTo(BigDecimal value) {
            addCriterion("preOrderEPrice <>", value, "preordereprice");
            return (Criteria) this;
        }

        public Criteria andPreorderepriceGreaterThan(BigDecimal value) {
            addCriterion("preOrderEPrice >", value, "preordereprice");
            return (Criteria) this;
        }

        public Criteria andPreorderepriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("preOrderEPrice >=", value, "preordereprice");
            return (Criteria) this;
        }

        public Criteria andPreorderepriceLessThan(BigDecimal value) {
            addCriterion("preOrderEPrice <", value, "preordereprice");
            return (Criteria) this;
        }

        public Criteria andPreorderepriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("preOrderEPrice <=", value, "preordereprice");
            return (Criteria) this;
        }

        public Criteria andPreorderepriceIn(List<BigDecimal> values) {
            addCriterion("preOrderEPrice in", values, "preordereprice");
            return (Criteria) this;
        }

        public Criteria andPreorderepriceNotIn(List<BigDecimal> values) {
            addCriterion("preOrderEPrice not in", values, "preordereprice");
            return (Criteria) this;
        }

        public Criteria andPreorderepriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("preOrderEPrice between", value1, value2, "preordereprice");
            return (Criteria) this;
        }

        public Criteria andPreorderepriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("preOrderEPrice not between", value1, value2, "preordereprice");
            return (Criteria) this;
        }

        public Criteria andPreorderpriceIsNull() {
            addCriterion("preOrderPrice is null");
            return (Criteria) this;
        }

        public Criteria andPreorderpriceIsNotNull() {
            addCriterion("preOrderPrice is not null");
            return (Criteria) this;
        }

        public Criteria andPreorderpriceEqualTo(BigDecimal value) {
            addCriterion("preOrderPrice =", value, "preorderprice");
            return (Criteria) this;
        }

        public Criteria andPreorderpriceNotEqualTo(BigDecimal value) {
            addCriterion("preOrderPrice <>", value, "preorderprice");
            return (Criteria) this;
        }

        public Criteria andPreorderpriceGreaterThan(BigDecimal value) {
            addCriterion("preOrderPrice >", value, "preorderprice");
            return (Criteria) this;
        }

        public Criteria andPreorderpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("preOrderPrice >=", value, "preorderprice");
            return (Criteria) this;
        }

        public Criteria andPreorderpriceLessThan(BigDecimal value) {
            addCriterion("preOrderPrice <", value, "preorderprice");
            return (Criteria) this;
        }

        public Criteria andPreorderpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("preOrderPrice <=", value, "preorderprice");
            return (Criteria) this;
        }

        public Criteria andPreorderpriceIn(List<BigDecimal> values) {
            addCriterion("preOrderPrice in", values, "preorderprice");
            return (Criteria) this;
        }

        public Criteria andPreorderpriceNotIn(List<BigDecimal> values) {
            addCriterion("preOrderPrice not in", values, "preorderprice");
            return (Criteria) this;
        }

        public Criteria andPreorderpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("preOrderPrice between", value1, value2, "preorderprice");
            return (Criteria) this;
        }

        public Criteria andPreorderpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("preOrderPrice not between", value1, value2, "preorderprice");
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