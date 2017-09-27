package com.medical.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DoctorlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DoctorlogExample() {
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

        public Criteria andDoclogidIsNull() {
            addCriterion("docLogId is null");
            return (Criteria) this;
        }

        public Criteria andDoclogidIsNotNull() {
            addCriterion("docLogId is not null");
            return (Criteria) this;
        }

        public Criteria andDoclogidEqualTo(Integer value) {
            addCriterion("docLogId =", value, "doclogid");
            return (Criteria) this;
        }

        public Criteria andDoclogidNotEqualTo(Integer value) {
            addCriterion("docLogId <>", value, "doclogid");
            return (Criteria) this;
        }

        public Criteria andDoclogidGreaterThan(Integer value) {
            addCriterion("docLogId >", value, "doclogid");
            return (Criteria) this;
        }

        public Criteria andDoclogidGreaterThanOrEqualTo(Integer value) {
            addCriterion("docLogId >=", value, "doclogid");
            return (Criteria) this;
        }

        public Criteria andDoclogidLessThan(Integer value) {
            addCriterion("docLogId <", value, "doclogid");
            return (Criteria) this;
        }

        public Criteria andDoclogidLessThanOrEqualTo(Integer value) {
            addCriterion("docLogId <=", value, "doclogid");
            return (Criteria) this;
        }

        public Criteria andDoclogidIn(List<Integer> values) {
            addCriterion("docLogId in", values, "doclogid");
            return (Criteria) this;
        }

        public Criteria andDoclogidNotIn(List<Integer> values) {
            addCriterion("docLogId not in", values, "doclogid");
            return (Criteria) this;
        }

        public Criteria andDoclogidBetween(Integer value1, Integer value2) {
            addCriterion("docLogId between", value1, value2, "doclogid");
            return (Criteria) this;
        }

        public Criteria andDoclogidNotBetween(Integer value1, Integer value2) {
            addCriterion("docLogId not between", value1, value2, "doclogid");
            return (Criteria) this;
        }

        public Criteria andDoclogtimeIsNull() {
            addCriterion("docLogTime is null");
            return (Criteria) this;
        }

        public Criteria andDoclogtimeIsNotNull() {
            addCriterion("docLogTime is not null");
            return (Criteria) this;
        }

        public Criteria andDoclogtimeEqualTo(Date value) {
            addCriterion("docLogTime =", value, "doclogtime");
            return (Criteria) this;
        }

        public Criteria andDoclogtimeNotEqualTo(Date value) {
            addCriterion("docLogTime <>", value, "doclogtime");
            return (Criteria) this;
        }

        public Criteria andDoclogtimeGreaterThan(Date value) {
            addCriterion("docLogTime >", value, "doclogtime");
            return (Criteria) this;
        }

        public Criteria andDoclogtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("docLogTime >=", value, "doclogtime");
            return (Criteria) this;
        }

        public Criteria andDoclogtimeLessThan(Date value) {
            addCriterion("docLogTime <", value, "doclogtime");
            return (Criteria) this;
        }

        public Criteria andDoclogtimeLessThanOrEqualTo(Date value) {
            addCriterion("docLogTime <=", value, "doclogtime");
            return (Criteria) this;
        }

        public Criteria andDoclogtimeIn(List<Date> values) {
            addCriterion("docLogTime in", values, "doclogtime");
            return (Criteria) this;
        }

        public Criteria andDoclogtimeNotIn(List<Date> values) {
            addCriterion("docLogTime not in", values, "doclogtime");
            return (Criteria) this;
        }

        public Criteria andDoclogtimeBetween(Date value1, Date value2) {
            addCriterion("docLogTime between", value1, value2, "doclogtime");
            return (Criteria) this;
        }

        public Criteria andDoclogtimeNotBetween(Date value1, Date value2) {
            addCriterion("docLogTime not between", value1, value2, "doclogtime");
            return (Criteria) this;
        }

        public Criteria andDocloglonIsNull() {
            addCriterion("docLogLon is null");
            return (Criteria) this;
        }

        public Criteria andDocloglonIsNotNull() {
            addCriterion("docLogLon is not null");
            return (Criteria) this;
        }

        public Criteria andDocloglonEqualTo(String value) {
            addCriterion("docLogLon =", value, "docloglon");
            return (Criteria) this;
        }

        public Criteria andDocloglonNotEqualTo(String value) {
            addCriterion("docLogLon <>", value, "docloglon");
            return (Criteria) this;
        }

        public Criteria andDocloglonGreaterThan(String value) {
            addCriterion("docLogLon >", value, "docloglon");
            return (Criteria) this;
        }

        public Criteria andDocloglonGreaterThanOrEqualTo(String value) {
            addCriterion("docLogLon >=", value, "docloglon");
            return (Criteria) this;
        }

        public Criteria andDocloglonLessThan(String value) {
            addCriterion("docLogLon <", value, "docloglon");
            return (Criteria) this;
        }

        public Criteria andDocloglonLessThanOrEqualTo(String value) {
            addCriterion("docLogLon <=", value, "docloglon");
            return (Criteria) this;
        }

        public Criteria andDocloglonLike(String value) {
            addCriterion("docLogLon like", value, "docloglon");
            return (Criteria) this;
        }

        public Criteria andDocloglonNotLike(String value) {
            addCriterion("docLogLon not like", value, "docloglon");
            return (Criteria) this;
        }

        public Criteria andDocloglonIn(List<String> values) {
            addCriterion("docLogLon in", values, "docloglon");
            return (Criteria) this;
        }

        public Criteria andDocloglonNotIn(List<String> values) {
            addCriterion("docLogLon not in", values, "docloglon");
            return (Criteria) this;
        }

        public Criteria andDocloglonBetween(String value1, String value2) {
            addCriterion("docLogLon between", value1, value2, "docloglon");
            return (Criteria) this;
        }

        public Criteria andDocloglonNotBetween(String value1, String value2) {
            addCriterion("docLogLon not between", value1, value2, "docloglon");
            return (Criteria) this;
        }

        public Criteria andDocloglatIsNull() {
            addCriterion("docLogLat is null");
            return (Criteria) this;
        }

        public Criteria andDocloglatIsNotNull() {
            addCriterion("docLogLat is not null");
            return (Criteria) this;
        }

        public Criteria andDocloglatEqualTo(String value) {
            addCriterion("docLogLat =", value, "docloglat");
            return (Criteria) this;
        }

        public Criteria andDocloglatNotEqualTo(String value) {
            addCriterion("docLogLat <>", value, "docloglat");
            return (Criteria) this;
        }

        public Criteria andDocloglatGreaterThan(String value) {
            addCriterion("docLogLat >", value, "docloglat");
            return (Criteria) this;
        }

        public Criteria andDocloglatGreaterThanOrEqualTo(String value) {
            addCriterion("docLogLat >=", value, "docloglat");
            return (Criteria) this;
        }

        public Criteria andDocloglatLessThan(String value) {
            addCriterion("docLogLat <", value, "docloglat");
            return (Criteria) this;
        }

        public Criteria andDocloglatLessThanOrEqualTo(String value) {
            addCriterion("docLogLat <=", value, "docloglat");
            return (Criteria) this;
        }

        public Criteria andDocloglatLike(String value) {
            addCriterion("docLogLat like", value, "docloglat");
            return (Criteria) this;
        }

        public Criteria andDocloglatNotLike(String value) {
            addCriterion("docLogLat not like", value, "docloglat");
            return (Criteria) this;
        }

        public Criteria andDocloglatIn(List<String> values) {
            addCriterion("docLogLat in", values, "docloglat");
            return (Criteria) this;
        }

        public Criteria andDocloglatNotIn(List<String> values) {
            addCriterion("docLogLat not in", values, "docloglat");
            return (Criteria) this;
        }

        public Criteria andDocloglatBetween(String value1, String value2) {
            addCriterion("docLogLat between", value1, value2, "docloglat");
            return (Criteria) this;
        }

        public Criteria andDocloglatNotBetween(String value1, String value2) {
            addCriterion("docLogLat not between", value1, value2, "docloglat");
            return (Criteria) this;
        }

        public Criteria andDocloglocIsNull() {
            addCriterion("docLogLoc is null");
            return (Criteria) this;
        }

        public Criteria andDocloglocIsNotNull() {
            addCriterion("docLogLoc is not null");
            return (Criteria) this;
        }

        public Criteria andDocloglocEqualTo(String value) {
            addCriterion("docLogLoc =", value, "doclogloc");
            return (Criteria) this;
        }

        public Criteria andDocloglocNotEqualTo(String value) {
            addCriterion("docLogLoc <>", value, "doclogloc");
            return (Criteria) this;
        }

        public Criteria andDocloglocGreaterThan(String value) {
            addCriterion("docLogLoc >", value, "doclogloc");
            return (Criteria) this;
        }

        public Criteria andDocloglocGreaterThanOrEqualTo(String value) {
            addCriterion("docLogLoc >=", value, "doclogloc");
            return (Criteria) this;
        }

        public Criteria andDocloglocLessThan(String value) {
            addCriterion("docLogLoc <", value, "doclogloc");
            return (Criteria) this;
        }

        public Criteria andDocloglocLessThanOrEqualTo(String value) {
            addCriterion("docLogLoc <=", value, "doclogloc");
            return (Criteria) this;
        }

        public Criteria andDocloglocLike(String value) {
            addCriterion("docLogLoc like", value, "doclogloc");
            return (Criteria) this;
        }

        public Criteria andDocloglocNotLike(String value) {
            addCriterion("docLogLoc not like", value, "doclogloc");
            return (Criteria) this;
        }

        public Criteria andDocloglocIn(List<String> values) {
            addCriterion("docLogLoc in", values, "doclogloc");
            return (Criteria) this;
        }

        public Criteria andDocloglocNotIn(List<String> values) {
            addCriterion("docLogLoc not in", values, "doclogloc");
            return (Criteria) this;
        }

        public Criteria andDocloglocBetween(String value1, String value2) {
            addCriterion("docLogLoc between", value1, value2, "doclogloc");
            return (Criteria) this;
        }

        public Criteria andDocloglocNotBetween(String value1, String value2) {
            addCriterion("docLogLoc not between", value1, value2, "doclogloc");
            return (Criteria) this;
        }

        public Criteria andDoclogdevIsNull() {
            addCriterion("docLogDev is null");
            return (Criteria) this;
        }

        public Criteria andDoclogdevIsNotNull() {
            addCriterion("docLogDev is not null");
            return (Criteria) this;
        }

        public Criteria andDoclogdevEqualTo(Boolean value) {
            addCriterion("docLogDev =", value, "doclogdev");
            return (Criteria) this;
        }

        public Criteria andDoclogdevNotEqualTo(Boolean value) {
            addCriterion("docLogDev <>", value, "doclogdev");
            return (Criteria) this;
        }

        public Criteria andDoclogdevGreaterThan(Boolean value) {
            addCriterion("docLogDev >", value, "doclogdev");
            return (Criteria) this;
        }

        public Criteria andDoclogdevGreaterThanOrEqualTo(Boolean value) {
            addCriterion("docLogDev >=", value, "doclogdev");
            return (Criteria) this;
        }

        public Criteria andDoclogdevLessThan(Boolean value) {
            addCriterion("docLogDev <", value, "doclogdev");
            return (Criteria) this;
        }

        public Criteria andDoclogdevLessThanOrEqualTo(Boolean value) {
            addCriterion("docLogDev <=", value, "doclogdev");
            return (Criteria) this;
        }

        public Criteria andDoclogdevIn(List<Boolean> values) {
            addCriterion("docLogDev in", values, "doclogdev");
            return (Criteria) this;
        }

        public Criteria andDoclogdevNotIn(List<Boolean> values) {
            addCriterion("docLogDev not in", values, "doclogdev");
            return (Criteria) this;
        }

        public Criteria andDoclogdevBetween(Boolean value1, Boolean value2) {
            addCriterion("docLogDev between", value1, value2, "doclogdev");
            return (Criteria) this;
        }

        public Criteria andDoclogdevNotBetween(Boolean value1, Boolean value2) {
            addCriterion("docLogDev not between", value1, value2, "doclogdev");
            return (Criteria) this;
        }

        public Criteria andDoclogbverIsNull() {
            addCriterion("docLogBVer is null");
            return (Criteria) this;
        }

        public Criteria andDoclogbverIsNotNull() {
            addCriterion("docLogBVer is not null");
            return (Criteria) this;
        }

        public Criteria andDoclogbverEqualTo(String value) {
            addCriterion("docLogBVer =", value, "doclogbver");
            return (Criteria) this;
        }

        public Criteria andDoclogbverNotEqualTo(String value) {
            addCriterion("docLogBVer <>", value, "doclogbver");
            return (Criteria) this;
        }

        public Criteria andDoclogbverGreaterThan(String value) {
            addCriterion("docLogBVer >", value, "doclogbver");
            return (Criteria) this;
        }

        public Criteria andDoclogbverGreaterThanOrEqualTo(String value) {
            addCriterion("docLogBVer >=", value, "doclogbver");
            return (Criteria) this;
        }

        public Criteria andDoclogbverLessThan(String value) {
            addCriterion("docLogBVer <", value, "doclogbver");
            return (Criteria) this;
        }

        public Criteria andDoclogbverLessThanOrEqualTo(String value) {
            addCriterion("docLogBVer <=", value, "doclogbver");
            return (Criteria) this;
        }

        public Criteria andDoclogbverLike(String value) {
            addCriterion("docLogBVer like", value, "doclogbver");
            return (Criteria) this;
        }

        public Criteria andDoclogbverNotLike(String value) {
            addCriterion("docLogBVer not like", value, "doclogbver");
            return (Criteria) this;
        }

        public Criteria andDoclogbverIn(List<String> values) {
            addCriterion("docLogBVer in", values, "doclogbver");
            return (Criteria) this;
        }

        public Criteria andDoclogbverNotIn(List<String> values) {
            addCriterion("docLogBVer not in", values, "doclogbver");
            return (Criteria) this;
        }

        public Criteria andDoclogbverBetween(String value1, String value2) {
            addCriterion("docLogBVer between", value1, value2, "doclogbver");
            return (Criteria) this;
        }

        public Criteria andDoclogbverNotBetween(String value1, String value2) {
            addCriterion("docLogBVer not between", value1, value2, "doclogbver");
            return (Criteria) this;
        }

        public Criteria andDoclogmodelIsNull() {
            addCriterion("docLogModel is null");
            return (Criteria) this;
        }

        public Criteria andDoclogmodelIsNotNull() {
            addCriterion("docLogModel is not null");
            return (Criteria) this;
        }

        public Criteria andDoclogmodelEqualTo(String value) {
            addCriterion("docLogModel =", value, "doclogmodel");
            return (Criteria) this;
        }

        public Criteria andDoclogmodelNotEqualTo(String value) {
            addCriterion("docLogModel <>", value, "doclogmodel");
            return (Criteria) this;
        }

        public Criteria andDoclogmodelGreaterThan(String value) {
            addCriterion("docLogModel >", value, "doclogmodel");
            return (Criteria) this;
        }

        public Criteria andDoclogmodelGreaterThanOrEqualTo(String value) {
            addCriterion("docLogModel >=", value, "doclogmodel");
            return (Criteria) this;
        }

        public Criteria andDoclogmodelLessThan(String value) {
            addCriterion("docLogModel <", value, "doclogmodel");
            return (Criteria) this;
        }

        public Criteria andDoclogmodelLessThanOrEqualTo(String value) {
            addCriterion("docLogModel <=", value, "doclogmodel");
            return (Criteria) this;
        }

        public Criteria andDoclogmodelLike(String value) {
            addCriterion("docLogModel like", value, "doclogmodel");
            return (Criteria) this;
        }

        public Criteria andDoclogmodelNotLike(String value) {
            addCriterion("docLogModel not like", value, "doclogmodel");
            return (Criteria) this;
        }

        public Criteria andDoclogmodelIn(List<String> values) {
            addCriterion("docLogModel in", values, "doclogmodel");
            return (Criteria) this;
        }

        public Criteria andDoclogmodelNotIn(List<String> values) {
            addCriterion("docLogModel not in", values, "doclogmodel");
            return (Criteria) this;
        }

        public Criteria andDoclogmodelBetween(String value1, String value2) {
            addCriterion("docLogModel between", value1, value2, "doclogmodel");
            return (Criteria) this;
        }

        public Criteria andDoclogmodelNotBetween(String value1, String value2) {
            addCriterion("docLogModel not between", value1, value2, "doclogmodel");
            return (Criteria) this;
        }

        public Criteria andDoclogpverIsNull() {
            addCriterion("docLogPVer is null");
            return (Criteria) this;
        }

        public Criteria andDoclogpverIsNotNull() {
            addCriterion("docLogPVer is not null");
            return (Criteria) this;
        }

        public Criteria andDoclogpverEqualTo(String value) {
            addCriterion("docLogPVer =", value, "doclogpver");
            return (Criteria) this;
        }

        public Criteria andDoclogpverNotEqualTo(String value) {
            addCriterion("docLogPVer <>", value, "doclogpver");
            return (Criteria) this;
        }

        public Criteria andDoclogpverGreaterThan(String value) {
            addCriterion("docLogPVer >", value, "doclogpver");
            return (Criteria) this;
        }

        public Criteria andDoclogpverGreaterThanOrEqualTo(String value) {
            addCriterion("docLogPVer >=", value, "doclogpver");
            return (Criteria) this;
        }

        public Criteria andDoclogpverLessThan(String value) {
            addCriterion("docLogPVer <", value, "doclogpver");
            return (Criteria) this;
        }

        public Criteria andDoclogpverLessThanOrEqualTo(String value) {
            addCriterion("docLogPVer <=", value, "doclogpver");
            return (Criteria) this;
        }

        public Criteria andDoclogpverLike(String value) {
            addCriterion("docLogPVer like", value, "doclogpver");
            return (Criteria) this;
        }

        public Criteria andDoclogpverNotLike(String value) {
            addCriterion("docLogPVer not like", value, "doclogpver");
            return (Criteria) this;
        }

        public Criteria andDoclogpverIn(List<String> values) {
            addCriterion("docLogPVer in", values, "doclogpver");
            return (Criteria) this;
        }

        public Criteria andDoclogpverNotIn(List<String> values) {
            addCriterion("docLogPVer not in", values, "doclogpver");
            return (Criteria) this;
        }

        public Criteria andDoclogpverBetween(String value1, String value2) {
            addCriterion("docLogPVer between", value1, value2, "doclogpver");
            return (Criteria) this;
        }

        public Criteria andDoclogpverNotBetween(String value1, String value2) {
            addCriterion("docLogPVer not between", value1, value2, "doclogpver");
            return (Criteria) this;
        }

        public Criteria andDoclogmacIsNull() {
            addCriterion("docLogMac is null");
            return (Criteria) this;
        }

        public Criteria andDoclogmacIsNotNull() {
            addCriterion("docLogMac is not null");
            return (Criteria) this;
        }

        public Criteria andDoclogmacEqualTo(String value) {
            addCriterion("docLogMac =", value, "doclogmac");
            return (Criteria) this;
        }

        public Criteria andDoclogmacNotEqualTo(String value) {
            addCriterion("docLogMac <>", value, "doclogmac");
            return (Criteria) this;
        }

        public Criteria andDoclogmacGreaterThan(String value) {
            addCriterion("docLogMac >", value, "doclogmac");
            return (Criteria) this;
        }

        public Criteria andDoclogmacGreaterThanOrEqualTo(String value) {
            addCriterion("docLogMac >=", value, "doclogmac");
            return (Criteria) this;
        }

        public Criteria andDoclogmacLessThan(String value) {
            addCriterion("docLogMac <", value, "doclogmac");
            return (Criteria) this;
        }

        public Criteria andDoclogmacLessThanOrEqualTo(String value) {
            addCriterion("docLogMac <=", value, "doclogmac");
            return (Criteria) this;
        }

        public Criteria andDoclogmacLike(String value) {
            addCriterion("docLogMac like", value, "doclogmac");
            return (Criteria) this;
        }

        public Criteria andDoclogmacNotLike(String value) {
            addCriterion("docLogMac not like", value, "doclogmac");
            return (Criteria) this;
        }

        public Criteria andDoclogmacIn(List<String> values) {
            addCriterion("docLogMac in", values, "doclogmac");
            return (Criteria) this;
        }

        public Criteria andDoclogmacNotIn(List<String> values) {
            addCriterion("docLogMac not in", values, "doclogmac");
            return (Criteria) this;
        }

        public Criteria andDoclogmacBetween(String value1, String value2) {
            addCriterion("docLogMac between", value1, value2, "doclogmac");
            return (Criteria) this;
        }

        public Criteria andDoclogmacNotBetween(String value1, String value2) {
            addCriterion("docLogMac not between", value1, value2, "doclogmac");
            return (Criteria) this;
        }

        public Criteria andDoclogipIsNull() {
            addCriterion("docLogIp is null");
            return (Criteria) this;
        }

        public Criteria andDoclogipIsNotNull() {
            addCriterion("docLogIp is not null");
            return (Criteria) this;
        }

        public Criteria andDoclogipEqualTo(String value) {
            addCriterion("docLogIp =", value, "doclogip");
            return (Criteria) this;
        }

        public Criteria andDoclogipNotEqualTo(String value) {
            addCriterion("docLogIp <>", value, "doclogip");
            return (Criteria) this;
        }

        public Criteria andDoclogipGreaterThan(String value) {
            addCriterion("docLogIp >", value, "doclogip");
            return (Criteria) this;
        }

        public Criteria andDoclogipGreaterThanOrEqualTo(String value) {
            addCriterion("docLogIp >=", value, "doclogip");
            return (Criteria) this;
        }

        public Criteria andDoclogipLessThan(String value) {
            addCriterion("docLogIp <", value, "doclogip");
            return (Criteria) this;
        }

        public Criteria andDoclogipLessThanOrEqualTo(String value) {
            addCriterion("docLogIp <=", value, "doclogip");
            return (Criteria) this;
        }

        public Criteria andDoclogipLike(String value) {
            addCriterion("docLogIp like", value, "doclogip");
            return (Criteria) this;
        }

        public Criteria andDoclogipNotLike(String value) {
            addCriterion("docLogIp not like", value, "doclogip");
            return (Criteria) this;
        }

        public Criteria andDoclogipIn(List<String> values) {
            addCriterion("docLogIp in", values, "doclogip");
            return (Criteria) this;
        }

        public Criteria andDoclogipNotIn(List<String> values) {
            addCriterion("docLogIp not in", values, "doclogip");
            return (Criteria) this;
        }

        public Criteria andDoclogipBetween(String value1, String value2) {
            addCriterion("docLogIp between", value1, value2, "doclogip");
            return (Criteria) this;
        }

        public Criteria andDoclogipNotBetween(String value1, String value2) {
            addCriterion("docLogIp not between", value1, value2, "doclogip");
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