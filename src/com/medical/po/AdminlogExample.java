package com.medical.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminlogExample() {
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

        public Criteria andAdminlogidIsNull() {
            addCriterion("adminLogId is null");
            return (Criteria) this;
        }

        public Criteria andAdminlogidIsNotNull() {
            addCriterion("adminLogId is not null");
            return (Criteria) this;
        }

        public Criteria andAdminlogidEqualTo(Integer value) {
            addCriterion("adminLogId =", value, "adminlogid");
            return (Criteria) this;
        }

        public Criteria andAdminlogidNotEqualTo(Integer value) {
            addCriterion("adminLogId <>", value, "adminlogid");
            return (Criteria) this;
        }

        public Criteria andAdminlogidGreaterThan(Integer value) {
            addCriterion("adminLogId >", value, "adminlogid");
            return (Criteria) this;
        }

        public Criteria andAdminlogidGreaterThanOrEqualTo(Integer value) {
            addCriterion("adminLogId >=", value, "adminlogid");
            return (Criteria) this;
        }

        public Criteria andAdminlogidLessThan(Integer value) {
            addCriterion("adminLogId <", value, "adminlogid");
            return (Criteria) this;
        }

        public Criteria andAdminlogidLessThanOrEqualTo(Integer value) {
            addCriterion("adminLogId <=", value, "adminlogid");
            return (Criteria) this;
        }

        public Criteria andAdminlogidIn(List<Integer> values) {
            addCriterion("adminLogId in", values, "adminlogid");
            return (Criteria) this;
        }

        public Criteria andAdminlogidNotIn(List<Integer> values) {
            addCriterion("adminLogId not in", values, "adminlogid");
            return (Criteria) this;
        }

        public Criteria andAdminlogidBetween(Integer value1, Integer value2) {
            addCriterion("adminLogId between", value1, value2, "adminlogid");
            return (Criteria) this;
        }

        public Criteria andAdminlogidNotBetween(Integer value1, Integer value2) {
            addCriterion("adminLogId not between", value1, value2, "adminlogid");
            return (Criteria) this;
        }

        public Criteria andAdminlogtimeIsNull() {
            addCriterion("adminLogTime is null");
            return (Criteria) this;
        }

        public Criteria andAdminlogtimeIsNotNull() {
            addCriterion("adminLogTime is not null");
            return (Criteria) this;
        }

        public Criteria andAdminlogtimeEqualTo(Date value) {
            addCriterion("adminLogTime =", value, "adminlogtime");
            return (Criteria) this;
        }

        public Criteria andAdminlogtimeNotEqualTo(Date value) {
            addCriterion("adminLogTime <>", value, "adminlogtime");
            return (Criteria) this;
        }

        public Criteria andAdminlogtimeGreaterThan(Date value) {
            addCriterion("adminLogTime >", value, "adminlogtime");
            return (Criteria) this;
        }

        public Criteria andAdminlogtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("adminLogTime >=", value, "adminlogtime");
            return (Criteria) this;
        }

        public Criteria andAdminlogtimeLessThan(Date value) {
            addCriterion("adminLogTime <", value, "adminlogtime");
            return (Criteria) this;
        }

        public Criteria andAdminlogtimeLessThanOrEqualTo(Date value) {
            addCriterion("adminLogTime <=", value, "adminlogtime");
            return (Criteria) this;
        }

        public Criteria andAdminlogtimeIn(List<Date> values) {
            addCriterion("adminLogTime in", values, "adminlogtime");
            return (Criteria) this;
        }

        public Criteria andAdminlogtimeNotIn(List<Date> values) {
            addCriterion("adminLogTime not in", values, "adminlogtime");
            return (Criteria) this;
        }

        public Criteria andAdminlogtimeBetween(Date value1, Date value2) {
            addCriterion("adminLogTime between", value1, value2, "adminlogtime");
            return (Criteria) this;
        }

        public Criteria andAdminlogtimeNotBetween(Date value1, Date value2) {
            addCriterion("adminLogTime not between", value1, value2, "adminlogtime");
            return (Criteria) this;
        }

        public Criteria andAdminloglocIsNull() {
            addCriterion("adminLogLoc is null");
            return (Criteria) this;
        }

        public Criteria andAdminloglocIsNotNull() {
            addCriterion("adminLogLoc is not null");
            return (Criteria) this;
        }

        public Criteria andAdminloglocEqualTo(String value) {
            addCriterion("adminLogLoc =", value, "adminlogloc");
            return (Criteria) this;
        }

        public Criteria andAdminloglocNotEqualTo(String value) {
            addCriterion("adminLogLoc <>", value, "adminlogloc");
            return (Criteria) this;
        }

        public Criteria andAdminloglocGreaterThan(String value) {
            addCriterion("adminLogLoc >", value, "adminlogloc");
            return (Criteria) this;
        }

        public Criteria andAdminloglocGreaterThanOrEqualTo(String value) {
            addCriterion("adminLogLoc >=", value, "adminlogloc");
            return (Criteria) this;
        }

        public Criteria andAdminloglocLessThan(String value) {
            addCriterion("adminLogLoc <", value, "adminlogloc");
            return (Criteria) this;
        }

        public Criteria andAdminloglocLessThanOrEqualTo(String value) {
            addCriterion("adminLogLoc <=", value, "adminlogloc");
            return (Criteria) this;
        }

        public Criteria andAdminloglocLike(String value) {
            addCriterion("adminLogLoc like", value, "adminlogloc");
            return (Criteria) this;
        }

        public Criteria andAdminloglocNotLike(String value) {
            addCriterion("adminLogLoc not like", value, "adminlogloc");
            return (Criteria) this;
        }

        public Criteria andAdminloglocIn(List<String> values) {
            addCriterion("adminLogLoc in", values, "adminlogloc");
            return (Criteria) this;
        }

        public Criteria andAdminloglocNotIn(List<String> values) {
            addCriterion("adminLogLoc not in", values, "adminlogloc");
            return (Criteria) this;
        }

        public Criteria andAdminloglocBetween(String value1, String value2) {
            addCriterion("adminLogLoc between", value1, value2, "adminlogloc");
            return (Criteria) this;
        }

        public Criteria andAdminloglocNotBetween(String value1, String value2) {
            addCriterion("adminLogLoc not between", value1, value2, "adminlogloc");
            return (Criteria) this;
        }

        public Criteria andAdminlogbverIsNull() {
            addCriterion("adminLogBVer is null");
            return (Criteria) this;
        }

        public Criteria andAdminlogbverIsNotNull() {
            addCriterion("adminLogBVer is not null");
            return (Criteria) this;
        }

        public Criteria andAdminlogbverEqualTo(String value) {
            addCriterion("adminLogBVer =", value, "adminlogbver");
            return (Criteria) this;
        }

        public Criteria andAdminlogbverNotEqualTo(String value) {
            addCriterion("adminLogBVer <>", value, "adminlogbver");
            return (Criteria) this;
        }

        public Criteria andAdminlogbverGreaterThan(String value) {
            addCriterion("adminLogBVer >", value, "adminlogbver");
            return (Criteria) this;
        }

        public Criteria andAdminlogbverGreaterThanOrEqualTo(String value) {
            addCriterion("adminLogBVer >=", value, "adminlogbver");
            return (Criteria) this;
        }

        public Criteria andAdminlogbverLessThan(String value) {
            addCriterion("adminLogBVer <", value, "adminlogbver");
            return (Criteria) this;
        }

        public Criteria andAdminlogbverLessThanOrEqualTo(String value) {
            addCriterion("adminLogBVer <=", value, "adminlogbver");
            return (Criteria) this;
        }

        public Criteria andAdminlogbverLike(String value) {
            addCriterion("adminLogBVer like", value, "adminlogbver");
            return (Criteria) this;
        }

        public Criteria andAdminlogbverNotLike(String value) {
            addCriterion("adminLogBVer not like", value, "adminlogbver");
            return (Criteria) this;
        }

        public Criteria andAdminlogbverIn(List<String> values) {
            addCriterion("adminLogBVer in", values, "adminlogbver");
            return (Criteria) this;
        }

        public Criteria andAdminlogbverNotIn(List<String> values) {
            addCriterion("adminLogBVer not in", values, "adminlogbver");
            return (Criteria) this;
        }

        public Criteria andAdminlogbverBetween(String value1, String value2) {
            addCriterion("adminLogBVer between", value1, value2, "adminlogbver");
            return (Criteria) this;
        }

        public Criteria andAdminlogbverNotBetween(String value1, String value2) {
            addCriterion("adminLogBVer not between", value1, value2, "adminlogbver");
            return (Criteria) this;
        }

        public Criteria andAdminlogmacIsNull() {
            addCriterion("adminLogMac is null");
            return (Criteria) this;
        }

        public Criteria andAdminlogmacIsNotNull() {
            addCriterion("adminLogMac is not null");
            return (Criteria) this;
        }

        public Criteria andAdminlogmacEqualTo(String value) {
            addCriterion("adminLogMac =", value, "adminlogmac");
            return (Criteria) this;
        }

        public Criteria andAdminlogmacNotEqualTo(String value) {
            addCriterion("adminLogMac <>", value, "adminlogmac");
            return (Criteria) this;
        }

        public Criteria andAdminlogmacGreaterThan(String value) {
            addCriterion("adminLogMac >", value, "adminlogmac");
            return (Criteria) this;
        }

        public Criteria andAdminlogmacGreaterThanOrEqualTo(String value) {
            addCriterion("adminLogMac >=", value, "adminlogmac");
            return (Criteria) this;
        }

        public Criteria andAdminlogmacLessThan(String value) {
            addCriterion("adminLogMac <", value, "adminlogmac");
            return (Criteria) this;
        }

        public Criteria andAdminlogmacLessThanOrEqualTo(String value) {
            addCriterion("adminLogMac <=", value, "adminlogmac");
            return (Criteria) this;
        }

        public Criteria andAdminlogmacLike(String value) {
            addCriterion("adminLogMac like", value, "adminlogmac");
            return (Criteria) this;
        }

        public Criteria andAdminlogmacNotLike(String value) {
            addCriterion("adminLogMac not like", value, "adminlogmac");
            return (Criteria) this;
        }

        public Criteria andAdminlogmacIn(List<String> values) {
            addCriterion("adminLogMac in", values, "adminlogmac");
            return (Criteria) this;
        }

        public Criteria andAdminlogmacNotIn(List<String> values) {
            addCriterion("adminLogMac not in", values, "adminlogmac");
            return (Criteria) this;
        }

        public Criteria andAdminlogmacBetween(String value1, String value2) {
            addCriterion("adminLogMac between", value1, value2, "adminlogmac");
            return (Criteria) this;
        }

        public Criteria andAdminlogmacNotBetween(String value1, String value2) {
            addCriterion("adminLogMac not between", value1, value2, "adminlogmac");
            return (Criteria) this;
        }

        public Criteria andAdminlogipIsNull() {
            addCriterion("adminLogIp is null");
            return (Criteria) this;
        }

        public Criteria andAdminlogipIsNotNull() {
            addCriterion("adminLogIp is not null");
            return (Criteria) this;
        }

        public Criteria andAdminlogipEqualTo(String value) {
            addCriterion("adminLogIp =", value, "adminlogip");
            return (Criteria) this;
        }

        public Criteria andAdminlogipNotEqualTo(String value) {
            addCriterion("adminLogIp <>", value, "adminlogip");
            return (Criteria) this;
        }

        public Criteria andAdminlogipGreaterThan(String value) {
            addCriterion("adminLogIp >", value, "adminlogip");
            return (Criteria) this;
        }

        public Criteria andAdminlogipGreaterThanOrEqualTo(String value) {
            addCriterion("adminLogIp >=", value, "adminlogip");
            return (Criteria) this;
        }

        public Criteria andAdminlogipLessThan(String value) {
            addCriterion("adminLogIp <", value, "adminlogip");
            return (Criteria) this;
        }

        public Criteria andAdminlogipLessThanOrEqualTo(String value) {
            addCriterion("adminLogIp <=", value, "adminlogip");
            return (Criteria) this;
        }

        public Criteria andAdminlogipLike(String value) {
            addCriterion("adminLogIp like", value, "adminlogip");
            return (Criteria) this;
        }

        public Criteria andAdminlogipNotLike(String value) {
            addCriterion("adminLogIp not like", value, "adminlogip");
            return (Criteria) this;
        }

        public Criteria andAdminlogipIn(List<String> values) {
            addCriterion("adminLogIp in", values, "adminlogip");
            return (Criteria) this;
        }

        public Criteria andAdminlogipNotIn(List<String> values) {
            addCriterion("adminLogIp not in", values, "adminlogip");
            return (Criteria) this;
        }

        public Criteria andAdminlogipBetween(String value1, String value2) {
            addCriterion("adminLogIp between", value1, value2, "adminlogip");
            return (Criteria) this;
        }

        public Criteria andAdminlogipNotBetween(String value1, String value2) {
            addCriterion("adminLogIp not between", value1, value2, "adminlogip");
            return (Criteria) this;
        }

        public Criteria andAdminloglonIsNull() {
            addCriterion("adminLogLon is null");
            return (Criteria) this;
        }

        public Criteria andAdminloglonIsNotNull() {
            addCriterion("adminLogLon is not null");
            return (Criteria) this;
        }

        public Criteria andAdminloglonEqualTo(String value) {
            addCriterion("adminLogLon =", value, "adminloglon");
            return (Criteria) this;
        }

        public Criteria andAdminloglonNotEqualTo(String value) {
            addCriterion("adminLogLon <>", value, "adminloglon");
            return (Criteria) this;
        }

        public Criteria andAdminloglonGreaterThan(String value) {
            addCriterion("adminLogLon >", value, "adminloglon");
            return (Criteria) this;
        }

        public Criteria andAdminloglonGreaterThanOrEqualTo(String value) {
            addCriterion("adminLogLon >=", value, "adminloglon");
            return (Criteria) this;
        }

        public Criteria andAdminloglonLessThan(String value) {
            addCriterion("adminLogLon <", value, "adminloglon");
            return (Criteria) this;
        }

        public Criteria andAdminloglonLessThanOrEqualTo(String value) {
            addCriterion("adminLogLon <=", value, "adminloglon");
            return (Criteria) this;
        }

        public Criteria andAdminloglonLike(String value) {
            addCriterion("adminLogLon like", value, "adminloglon");
            return (Criteria) this;
        }

        public Criteria andAdminloglonNotLike(String value) {
            addCriterion("adminLogLon not like", value, "adminloglon");
            return (Criteria) this;
        }

        public Criteria andAdminloglonIn(List<String> values) {
            addCriterion("adminLogLon in", values, "adminloglon");
            return (Criteria) this;
        }

        public Criteria andAdminloglonNotIn(List<String> values) {
            addCriterion("adminLogLon not in", values, "adminloglon");
            return (Criteria) this;
        }

        public Criteria andAdminloglonBetween(String value1, String value2) {
            addCriterion("adminLogLon between", value1, value2, "adminloglon");
            return (Criteria) this;
        }

        public Criteria andAdminloglonNotBetween(String value1, String value2) {
            addCriterion("adminLogLon not between", value1, value2, "adminloglon");
            return (Criteria) this;
        }

        public Criteria andAdminloglatIsNull() {
            addCriterion("adminLogLat is null");
            return (Criteria) this;
        }

        public Criteria andAdminloglatIsNotNull() {
            addCriterion("adminLogLat is not null");
            return (Criteria) this;
        }

        public Criteria andAdminloglatEqualTo(String value) {
            addCriterion("adminLogLat =", value, "adminloglat");
            return (Criteria) this;
        }

        public Criteria andAdminloglatNotEqualTo(String value) {
            addCriterion("adminLogLat <>", value, "adminloglat");
            return (Criteria) this;
        }

        public Criteria andAdminloglatGreaterThan(String value) {
            addCriterion("adminLogLat >", value, "adminloglat");
            return (Criteria) this;
        }

        public Criteria andAdminloglatGreaterThanOrEqualTo(String value) {
            addCriterion("adminLogLat >=", value, "adminloglat");
            return (Criteria) this;
        }

        public Criteria andAdminloglatLessThan(String value) {
            addCriterion("adminLogLat <", value, "adminloglat");
            return (Criteria) this;
        }

        public Criteria andAdminloglatLessThanOrEqualTo(String value) {
            addCriterion("adminLogLat <=", value, "adminloglat");
            return (Criteria) this;
        }

        public Criteria andAdminloglatLike(String value) {
            addCriterion("adminLogLat like", value, "adminloglat");
            return (Criteria) this;
        }

        public Criteria andAdminloglatNotLike(String value) {
            addCriterion("adminLogLat not like", value, "adminloglat");
            return (Criteria) this;
        }

        public Criteria andAdminloglatIn(List<String> values) {
            addCriterion("adminLogLat in", values, "adminloglat");
            return (Criteria) this;
        }

        public Criteria andAdminloglatNotIn(List<String> values) {
            addCriterion("adminLogLat not in", values, "adminloglat");
            return (Criteria) this;
        }

        public Criteria andAdminloglatBetween(String value1, String value2) {
            addCriterion("adminLogLat between", value1, value2, "adminloglat");
            return (Criteria) this;
        }

        public Criteria andAdminloglatNotBetween(String value1, String value2) {
            addCriterion("adminLogLat not between", value1, value2, "adminloglat");
            return (Criteria) this;
        }

        public Criteria andAdminloginidIsNull() {
            addCriterion("adminLoginId is null");
            return (Criteria) this;
        }

        public Criteria andAdminloginidIsNotNull() {
            addCriterion("adminLoginId is not null");
            return (Criteria) this;
        }

        public Criteria andAdminloginidEqualTo(Integer value) {
            addCriterion("adminLoginId =", value, "adminloginid");
            return (Criteria) this;
        }

        public Criteria andAdminloginidNotEqualTo(Integer value) {
            addCriterion("adminLoginId <>", value, "adminloginid");
            return (Criteria) this;
        }

        public Criteria andAdminloginidGreaterThan(Integer value) {
            addCriterion("adminLoginId >", value, "adminloginid");
            return (Criteria) this;
        }

        public Criteria andAdminloginidGreaterThanOrEqualTo(Integer value) {
            addCriterion("adminLoginId >=", value, "adminloginid");
            return (Criteria) this;
        }

        public Criteria andAdminloginidLessThan(Integer value) {
            addCriterion("adminLoginId <", value, "adminloginid");
            return (Criteria) this;
        }

        public Criteria andAdminloginidLessThanOrEqualTo(Integer value) {
            addCriterion("adminLoginId <=", value, "adminloginid");
            return (Criteria) this;
        }

        public Criteria andAdminloginidIn(List<Integer> values) {
            addCriterion("adminLoginId in", values, "adminloginid");
            return (Criteria) this;
        }

        public Criteria andAdminloginidNotIn(List<Integer> values) {
            addCriterion("adminLoginId not in", values, "adminloginid");
            return (Criteria) this;
        }

        public Criteria andAdminloginidBetween(Integer value1, Integer value2) {
            addCriterion("adminLoginId between", value1, value2, "adminloginid");
            return (Criteria) this;
        }

        public Criteria andAdminloginidNotBetween(Integer value1, Integer value2) {
            addCriterion("adminLoginId not between", value1, value2, "adminloginid");
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