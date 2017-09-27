package com.medical.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserlogExample() {
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

        public Criteria andUserlogidIsNull() {
            addCriterion("userLogId is null");
            return (Criteria) this;
        }

        public Criteria andUserlogidIsNotNull() {
            addCriterion("userLogId is not null");
            return (Criteria) this;
        }

        public Criteria andUserlogidEqualTo(Integer value) {
            addCriterion("userLogId =", value, "userlogid");
            return (Criteria) this;
        }

        public Criteria andUserlogidNotEqualTo(Integer value) {
            addCriterion("userLogId <>", value, "userlogid");
            return (Criteria) this;
        }

        public Criteria andUserlogidGreaterThan(Integer value) {
            addCriterion("userLogId >", value, "userlogid");
            return (Criteria) this;
        }

        public Criteria andUserlogidGreaterThanOrEqualTo(Integer value) {
            addCriterion("userLogId >=", value, "userlogid");
            return (Criteria) this;
        }

        public Criteria andUserlogidLessThan(Integer value) {
            addCriterion("userLogId <", value, "userlogid");
            return (Criteria) this;
        }

        public Criteria andUserlogidLessThanOrEqualTo(Integer value) {
            addCriterion("userLogId <=", value, "userlogid");
            return (Criteria) this;
        }

        public Criteria andUserlogidIn(List<Integer> values) {
            addCriterion("userLogId in", values, "userlogid");
            return (Criteria) this;
        }

        public Criteria andUserlogidNotIn(List<Integer> values) {
            addCriterion("userLogId not in", values, "userlogid");
            return (Criteria) this;
        }

        public Criteria andUserlogidBetween(Integer value1, Integer value2) {
            addCriterion("userLogId between", value1, value2, "userlogid");
            return (Criteria) this;
        }

        public Criteria andUserlogidNotBetween(Integer value1, Integer value2) {
            addCriterion("userLogId not between", value1, value2, "userlogid");
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

        public Criteria andUserlogtimeIsNull() {
            addCriterion("userLogTime is null");
            return (Criteria) this;
        }

        public Criteria andUserlogtimeIsNotNull() {
            addCriterion("userLogTime is not null");
            return (Criteria) this;
        }

        public Criteria andUserlogtimeEqualTo(Date value) {
            addCriterion("userLogTime =", value, "userlogtime");
            return (Criteria) this;
        }

        public Criteria andUserlogtimeNotEqualTo(Date value) {
            addCriterion("userLogTime <>", value, "userlogtime");
            return (Criteria) this;
        }

        public Criteria andUserlogtimeGreaterThan(Date value) {
            addCriterion("userLogTime >", value, "userlogtime");
            return (Criteria) this;
        }

        public Criteria andUserlogtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("userLogTime >=", value, "userlogtime");
            return (Criteria) this;
        }

        public Criteria andUserlogtimeLessThan(Date value) {
            addCriterion("userLogTime <", value, "userlogtime");
            return (Criteria) this;
        }

        public Criteria andUserlogtimeLessThanOrEqualTo(Date value) {
            addCriterion("userLogTime <=", value, "userlogtime");
            return (Criteria) this;
        }

        public Criteria andUserlogtimeIn(List<Date> values) {
            addCriterion("userLogTime in", values, "userlogtime");
            return (Criteria) this;
        }

        public Criteria andUserlogtimeNotIn(List<Date> values) {
            addCriterion("userLogTime not in", values, "userlogtime");
            return (Criteria) this;
        }

        public Criteria andUserlogtimeBetween(Date value1, Date value2) {
            addCriterion("userLogTime between", value1, value2, "userlogtime");
            return (Criteria) this;
        }

        public Criteria andUserlogtimeNotBetween(Date value1, Date value2) {
            addCriterion("userLogTime not between", value1, value2, "userlogtime");
            return (Criteria) this;
        }

        public Criteria andUserloglonIsNull() {
            addCriterion("userLogLon is null");
            return (Criteria) this;
        }

        public Criteria andUserloglonIsNotNull() {
            addCriterion("userLogLon is not null");
            return (Criteria) this;
        }

        public Criteria andUserloglonEqualTo(String value) {
            addCriterion("userLogLon =", value, "userloglon");
            return (Criteria) this;
        }

        public Criteria andUserloglonNotEqualTo(String value) {
            addCriterion("userLogLon <>", value, "userloglon");
            return (Criteria) this;
        }

        public Criteria andUserloglonGreaterThan(String value) {
            addCriterion("userLogLon >", value, "userloglon");
            return (Criteria) this;
        }

        public Criteria andUserloglonGreaterThanOrEqualTo(String value) {
            addCriterion("userLogLon >=", value, "userloglon");
            return (Criteria) this;
        }

        public Criteria andUserloglonLessThan(String value) {
            addCriterion("userLogLon <", value, "userloglon");
            return (Criteria) this;
        }

        public Criteria andUserloglonLessThanOrEqualTo(String value) {
            addCriterion("userLogLon <=", value, "userloglon");
            return (Criteria) this;
        }

        public Criteria andUserloglonLike(String value) {
            addCriterion("userLogLon like", value, "userloglon");
            return (Criteria) this;
        }

        public Criteria andUserloglonNotLike(String value) {
            addCriterion("userLogLon not like", value, "userloglon");
            return (Criteria) this;
        }

        public Criteria andUserloglonIn(List<String> values) {
            addCriterion("userLogLon in", values, "userloglon");
            return (Criteria) this;
        }

        public Criteria andUserloglonNotIn(List<String> values) {
            addCriterion("userLogLon not in", values, "userloglon");
            return (Criteria) this;
        }

        public Criteria andUserloglonBetween(String value1, String value2) {
            addCriterion("userLogLon between", value1, value2, "userloglon");
            return (Criteria) this;
        }

        public Criteria andUserloglonNotBetween(String value1, String value2) {
            addCriterion("userLogLon not between", value1, value2, "userloglon");
            return (Criteria) this;
        }

        public Criteria andUserloglatIsNull() {
            addCriterion("userLogLat is null");
            return (Criteria) this;
        }

        public Criteria andUserloglatIsNotNull() {
            addCriterion("userLogLat is not null");
            return (Criteria) this;
        }

        public Criteria andUserloglatEqualTo(String value) {
            addCriterion("userLogLat =", value, "userloglat");
            return (Criteria) this;
        }

        public Criteria andUserloglatNotEqualTo(String value) {
            addCriterion("userLogLat <>", value, "userloglat");
            return (Criteria) this;
        }

        public Criteria andUserloglatGreaterThan(String value) {
            addCriterion("userLogLat >", value, "userloglat");
            return (Criteria) this;
        }

        public Criteria andUserloglatGreaterThanOrEqualTo(String value) {
            addCriterion("userLogLat >=", value, "userloglat");
            return (Criteria) this;
        }

        public Criteria andUserloglatLessThan(String value) {
            addCriterion("userLogLat <", value, "userloglat");
            return (Criteria) this;
        }

        public Criteria andUserloglatLessThanOrEqualTo(String value) {
            addCriterion("userLogLat <=", value, "userloglat");
            return (Criteria) this;
        }

        public Criteria andUserloglatLike(String value) {
            addCriterion("userLogLat like", value, "userloglat");
            return (Criteria) this;
        }

        public Criteria andUserloglatNotLike(String value) {
            addCriterion("userLogLat not like", value, "userloglat");
            return (Criteria) this;
        }

        public Criteria andUserloglatIn(List<String> values) {
            addCriterion("userLogLat in", values, "userloglat");
            return (Criteria) this;
        }

        public Criteria andUserloglatNotIn(List<String> values) {
            addCriterion("userLogLat not in", values, "userloglat");
            return (Criteria) this;
        }

        public Criteria andUserloglatBetween(String value1, String value2) {
            addCriterion("userLogLat between", value1, value2, "userloglat");
            return (Criteria) this;
        }

        public Criteria andUserloglatNotBetween(String value1, String value2) {
            addCriterion("userLogLat not between", value1, value2, "userloglat");
            return (Criteria) this;
        }

        public Criteria andUserloglocIsNull() {
            addCriterion("userLogLoc is null");
            return (Criteria) this;
        }

        public Criteria andUserloglocIsNotNull() {
            addCriterion("userLogLoc is not null");
            return (Criteria) this;
        }

        public Criteria andUserloglocEqualTo(String value) {
            addCriterion("userLogLoc =", value, "userlogloc");
            return (Criteria) this;
        }

        public Criteria andUserloglocNotEqualTo(String value) {
            addCriterion("userLogLoc <>", value, "userlogloc");
            return (Criteria) this;
        }

        public Criteria andUserloglocGreaterThan(String value) {
            addCriterion("userLogLoc >", value, "userlogloc");
            return (Criteria) this;
        }

        public Criteria andUserloglocGreaterThanOrEqualTo(String value) {
            addCriterion("userLogLoc >=", value, "userlogloc");
            return (Criteria) this;
        }

        public Criteria andUserloglocLessThan(String value) {
            addCriterion("userLogLoc <", value, "userlogloc");
            return (Criteria) this;
        }

        public Criteria andUserloglocLessThanOrEqualTo(String value) {
            addCriterion("userLogLoc <=", value, "userlogloc");
            return (Criteria) this;
        }

        public Criteria andUserloglocLike(String value) {
            addCriterion("userLogLoc like", value, "userlogloc");
            return (Criteria) this;
        }

        public Criteria andUserloglocNotLike(String value) {
            addCriterion("userLogLoc not like", value, "userlogloc");
            return (Criteria) this;
        }

        public Criteria andUserloglocIn(List<String> values) {
            addCriterion("userLogLoc in", values, "userlogloc");
            return (Criteria) this;
        }

        public Criteria andUserloglocNotIn(List<String> values) {
            addCriterion("userLogLoc not in", values, "userlogloc");
            return (Criteria) this;
        }

        public Criteria andUserloglocBetween(String value1, String value2) {
            addCriterion("userLogLoc between", value1, value2, "userlogloc");
            return (Criteria) this;
        }

        public Criteria andUserloglocNotBetween(String value1, String value2) {
            addCriterion("userLogLoc not between", value1, value2, "userlogloc");
            return (Criteria) this;
        }

        public Criteria andUserlogdevIsNull() {
            addCriterion("userLogDev is null");
            return (Criteria) this;
        }

        public Criteria andUserlogdevIsNotNull() {
            addCriterion("userLogDev is not null");
            return (Criteria) this;
        }

        public Criteria andUserlogdevEqualTo(Boolean value) {
            addCriterion("userLogDev =", value, "userlogdev");
            return (Criteria) this;
        }

        public Criteria andUserlogdevNotEqualTo(Boolean value) {
            addCriterion("userLogDev <>", value, "userlogdev");
            return (Criteria) this;
        }

        public Criteria andUserlogdevGreaterThan(Boolean value) {
            addCriterion("userLogDev >", value, "userlogdev");
            return (Criteria) this;
        }

        public Criteria andUserlogdevGreaterThanOrEqualTo(Boolean value) {
            addCriterion("userLogDev >=", value, "userlogdev");
            return (Criteria) this;
        }

        public Criteria andUserlogdevLessThan(Boolean value) {
            addCriterion("userLogDev <", value, "userlogdev");
            return (Criteria) this;
        }

        public Criteria andUserlogdevLessThanOrEqualTo(Boolean value) {
            addCriterion("userLogDev <=", value, "userlogdev");
            return (Criteria) this;
        }

        public Criteria andUserlogdevIn(List<Boolean> values) {
            addCriterion("userLogDev in", values, "userlogdev");
            return (Criteria) this;
        }

        public Criteria andUserlogdevNotIn(List<Boolean> values) {
            addCriterion("userLogDev not in", values, "userlogdev");
            return (Criteria) this;
        }

        public Criteria andUserlogdevBetween(Boolean value1, Boolean value2) {
            addCriterion("userLogDev between", value1, value2, "userlogdev");
            return (Criteria) this;
        }

        public Criteria andUserlogdevNotBetween(Boolean value1, Boolean value2) {
            addCriterion("userLogDev not between", value1, value2, "userlogdev");
            return (Criteria) this;
        }

        public Criteria andUserlogbverIsNull() {
            addCriterion("userLogBVer is null");
            return (Criteria) this;
        }

        public Criteria andUserlogbverIsNotNull() {
            addCriterion("userLogBVer is not null");
            return (Criteria) this;
        }

        public Criteria andUserlogbverEqualTo(String value) {
            addCriterion("userLogBVer =", value, "userlogbver");
            return (Criteria) this;
        }

        public Criteria andUserlogbverNotEqualTo(String value) {
            addCriterion("userLogBVer <>", value, "userlogbver");
            return (Criteria) this;
        }

        public Criteria andUserlogbverGreaterThan(String value) {
            addCriterion("userLogBVer >", value, "userlogbver");
            return (Criteria) this;
        }

        public Criteria andUserlogbverGreaterThanOrEqualTo(String value) {
            addCriterion("userLogBVer >=", value, "userlogbver");
            return (Criteria) this;
        }

        public Criteria andUserlogbverLessThan(String value) {
            addCriterion("userLogBVer <", value, "userlogbver");
            return (Criteria) this;
        }

        public Criteria andUserlogbverLessThanOrEqualTo(String value) {
            addCriterion("userLogBVer <=", value, "userlogbver");
            return (Criteria) this;
        }

        public Criteria andUserlogbverLike(String value) {
            addCriterion("userLogBVer like", value, "userlogbver");
            return (Criteria) this;
        }

        public Criteria andUserlogbverNotLike(String value) {
            addCriterion("userLogBVer not like", value, "userlogbver");
            return (Criteria) this;
        }

        public Criteria andUserlogbverIn(List<String> values) {
            addCriterion("userLogBVer in", values, "userlogbver");
            return (Criteria) this;
        }

        public Criteria andUserlogbverNotIn(List<String> values) {
            addCriterion("userLogBVer not in", values, "userlogbver");
            return (Criteria) this;
        }

        public Criteria andUserlogbverBetween(String value1, String value2) {
            addCriterion("userLogBVer between", value1, value2, "userlogbver");
            return (Criteria) this;
        }

        public Criteria andUserlogbverNotBetween(String value1, String value2) {
            addCriterion("userLogBVer not between", value1, value2, "userlogbver");
            return (Criteria) this;
        }

        public Criteria andUserlogmodelIsNull() {
            addCriterion("userLogModel is null");
            return (Criteria) this;
        }

        public Criteria andUserlogmodelIsNotNull() {
            addCriterion("userLogModel is not null");
            return (Criteria) this;
        }

        public Criteria andUserlogmodelEqualTo(String value) {
            addCriterion("userLogModel =", value, "userlogmodel");
            return (Criteria) this;
        }

        public Criteria andUserlogmodelNotEqualTo(String value) {
            addCriterion("userLogModel <>", value, "userlogmodel");
            return (Criteria) this;
        }

        public Criteria andUserlogmodelGreaterThan(String value) {
            addCriterion("userLogModel >", value, "userlogmodel");
            return (Criteria) this;
        }

        public Criteria andUserlogmodelGreaterThanOrEqualTo(String value) {
            addCriterion("userLogModel >=", value, "userlogmodel");
            return (Criteria) this;
        }

        public Criteria andUserlogmodelLessThan(String value) {
            addCriterion("userLogModel <", value, "userlogmodel");
            return (Criteria) this;
        }

        public Criteria andUserlogmodelLessThanOrEqualTo(String value) {
            addCriterion("userLogModel <=", value, "userlogmodel");
            return (Criteria) this;
        }

        public Criteria andUserlogmodelLike(String value) {
            addCriterion("userLogModel like", value, "userlogmodel");
            return (Criteria) this;
        }

        public Criteria andUserlogmodelNotLike(String value) {
            addCriterion("userLogModel not like", value, "userlogmodel");
            return (Criteria) this;
        }

        public Criteria andUserlogmodelIn(List<String> values) {
            addCriterion("userLogModel in", values, "userlogmodel");
            return (Criteria) this;
        }

        public Criteria andUserlogmodelNotIn(List<String> values) {
            addCriterion("userLogModel not in", values, "userlogmodel");
            return (Criteria) this;
        }

        public Criteria andUserlogmodelBetween(String value1, String value2) {
            addCriterion("userLogModel between", value1, value2, "userlogmodel");
            return (Criteria) this;
        }

        public Criteria andUserlogmodelNotBetween(String value1, String value2) {
            addCriterion("userLogModel not between", value1, value2, "userlogmodel");
            return (Criteria) this;
        }

        public Criteria andUserlogpverIsNull() {
            addCriterion("userLogPVer is null");
            return (Criteria) this;
        }

        public Criteria andUserlogpverIsNotNull() {
            addCriterion("userLogPVer is not null");
            return (Criteria) this;
        }

        public Criteria andUserlogpverEqualTo(String value) {
            addCriterion("userLogPVer =", value, "userlogpver");
            return (Criteria) this;
        }

        public Criteria andUserlogpverNotEqualTo(String value) {
            addCriterion("userLogPVer <>", value, "userlogpver");
            return (Criteria) this;
        }

        public Criteria andUserlogpverGreaterThan(String value) {
            addCriterion("userLogPVer >", value, "userlogpver");
            return (Criteria) this;
        }

        public Criteria andUserlogpverGreaterThanOrEqualTo(String value) {
            addCriterion("userLogPVer >=", value, "userlogpver");
            return (Criteria) this;
        }

        public Criteria andUserlogpverLessThan(String value) {
            addCriterion("userLogPVer <", value, "userlogpver");
            return (Criteria) this;
        }

        public Criteria andUserlogpverLessThanOrEqualTo(String value) {
            addCriterion("userLogPVer <=", value, "userlogpver");
            return (Criteria) this;
        }

        public Criteria andUserlogpverLike(String value) {
            addCriterion("userLogPVer like", value, "userlogpver");
            return (Criteria) this;
        }

        public Criteria andUserlogpverNotLike(String value) {
            addCriterion("userLogPVer not like", value, "userlogpver");
            return (Criteria) this;
        }

        public Criteria andUserlogpverIn(List<String> values) {
            addCriterion("userLogPVer in", values, "userlogpver");
            return (Criteria) this;
        }

        public Criteria andUserlogpverNotIn(List<String> values) {
            addCriterion("userLogPVer not in", values, "userlogpver");
            return (Criteria) this;
        }

        public Criteria andUserlogpverBetween(String value1, String value2) {
            addCriterion("userLogPVer between", value1, value2, "userlogpver");
            return (Criteria) this;
        }

        public Criteria andUserlogpverNotBetween(String value1, String value2) {
            addCriterion("userLogPVer not between", value1, value2, "userlogpver");
            return (Criteria) this;
        }

        public Criteria andUserlogmacIsNull() {
            addCriterion("userLogMac is null");
            return (Criteria) this;
        }

        public Criteria andUserlogmacIsNotNull() {
            addCriterion("userLogMac is not null");
            return (Criteria) this;
        }

        public Criteria andUserlogmacEqualTo(String value) {
            addCriterion("userLogMac =", value, "userlogmac");
            return (Criteria) this;
        }

        public Criteria andUserlogmacNotEqualTo(String value) {
            addCriterion("userLogMac <>", value, "userlogmac");
            return (Criteria) this;
        }

        public Criteria andUserlogmacGreaterThan(String value) {
            addCriterion("userLogMac >", value, "userlogmac");
            return (Criteria) this;
        }

        public Criteria andUserlogmacGreaterThanOrEqualTo(String value) {
            addCriterion("userLogMac >=", value, "userlogmac");
            return (Criteria) this;
        }

        public Criteria andUserlogmacLessThan(String value) {
            addCriterion("userLogMac <", value, "userlogmac");
            return (Criteria) this;
        }

        public Criteria andUserlogmacLessThanOrEqualTo(String value) {
            addCriterion("userLogMac <=", value, "userlogmac");
            return (Criteria) this;
        }

        public Criteria andUserlogmacLike(String value) {
            addCriterion("userLogMac like", value, "userlogmac");
            return (Criteria) this;
        }

        public Criteria andUserlogmacNotLike(String value) {
            addCriterion("userLogMac not like", value, "userlogmac");
            return (Criteria) this;
        }

        public Criteria andUserlogmacIn(List<String> values) {
            addCriterion("userLogMac in", values, "userlogmac");
            return (Criteria) this;
        }

        public Criteria andUserlogmacNotIn(List<String> values) {
            addCriterion("userLogMac not in", values, "userlogmac");
            return (Criteria) this;
        }

        public Criteria andUserlogmacBetween(String value1, String value2) {
            addCriterion("userLogMac between", value1, value2, "userlogmac");
            return (Criteria) this;
        }

        public Criteria andUserlogmacNotBetween(String value1, String value2) {
            addCriterion("userLogMac not between", value1, value2, "userlogmac");
            return (Criteria) this;
        }

        public Criteria andUserlogipIsNull() {
            addCriterion("userLogIp is null");
            return (Criteria) this;
        }

        public Criteria andUserlogipIsNotNull() {
            addCriterion("userLogIp is not null");
            return (Criteria) this;
        }

        public Criteria andUserlogipEqualTo(String value) {
            addCriterion("userLogIp =", value, "userlogip");
            return (Criteria) this;
        }

        public Criteria andUserlogipNotEqualTo(String value) {
            addCriterion("userLogIp <>", value, "userlogip");
            return (Criteria) this;
        }

        public Criteria andUserlogipGreaterThan(String value) {
            addCriterion("userLogIp >", value, "userlogip");
            return (Criteria) this;
        }

        public Criteria andUserlogipGreaterThanOrEqualTo(String value) {
            addCriterion("userLogIp >=", value, "userlogip");
            return (Criteria) this;
        }

        public Criteria andUserlogipLessThan(String value) {
            addCriterion("userLogIp <", value, "userlogip");
            return (Criteria) this;
        }

        public Criteria andUserlogipLessThanOrEqualTo(String value) {
            addCriterion("userLogIp <=", value, "userlogip");
            return (Criteria) this;
        }

        public Criteria andUserlogipLike(String value) {
            addCriterion("userLogIp like", value, "userlogip");
            return (Criteria) this;
        }

        public Criteria andUserlogipNotLike(String value) {
            addCriterion("userLogIp not like", value, "userlogip");
            return (Criteria) this;
        }

        public Criteria andUserlogipIn(List<String> values) {
            addCriterion("userLogIp in", values, "userlogip");
            return (Criteria) this;
        }

        public Criteria andUserlogipNotIn(List<String> values) {
            addCriterion("userLogIp not in", values, "userlogip");
            return (Criteria) this;
        }

        public Criteria andUserlogipBetween(String value1, String value2) {
            addCriterion("userLogIp between", value1, value2, "userlogip");
            return (Criteria) this;
        }

        public Criteria andUserlogipNotBetween(String value1, String value2) {
            addCriterion("userLogIp not between", value1, value2, "userlogip");
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