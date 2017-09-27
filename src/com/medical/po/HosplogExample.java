package com.medical.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HosplogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HosplogExample() {
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

        public Criteria andHosplogidIsNull() {
            addCriterion("hospLogId is null");
            return (Criteria) this;
        }

        public Criteria andHosplogidIsNotNull() {
            addCriterion("hospLogId is not null");
            return (Criteria) this;
        }

        public Criteria andHosplogidEqualTo(Integer value) {
            addCriterion("hospLogId =", value, "hosplogid");
            return (Criteria) this;
        }

        public Criteria andHosplogidNotEqualTo(Integer value) {
            addCriterion("hospLogId <>", value, "hosplogid");
            return (Criteria) this;
        }

        public Criteria andHosplogidGreaterThan(Integer value) {
            addCriterion("hospLogId >", value, "hosplogid");
            return (Criteria) this;
        }

        public Criteria andHosplogidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hospLogId >=", value, "hosplogid");
            return (Criteria) this;
        }

        public Criteria andHosplogidLessThan(Integer value) {
            addCriterion("hospLogId <", value, "hosplogid");
            return (Criteria) this;
        }

        public Criteria andHosplogidLessThanOrEqualTo(Integer value) {
            addCriterion("hospLogId <=", value, "hosplogid");
            return (Criteria) this;
        }

        public Criteria andHosplogidIn(List<Integer> values) {
            addCriterion("hospLogId in", values, "hosplogid");
            return (Criteria) this;
        }

        public Criteria andHosplogidNotIn(List<Integer> values) {
            addCriterion("hospLogId not in", values, "hosplogid");
            return (Criteria) this;
        }

        public Criteria andHosplogidBetween(Integer value1, Integer value2) {
            addCriterion("hospLogId between", value1, value2, "hosplogid");
            return (Criteria) this;
        }

        public Criteria andHosplogidNotBetween(Integer value1, Integer value2) {
            addCriterion("hospLogId not between", value1, value2, "hosplogid");
            return (Criteria) this;
        }

        public Criteria andHosplogtimeIsNull() {
            addCriterion("hospLogTime is null");
            return (Criteria) this;
        }

        public Criteria andHosplogtimeIsNotNull() {
            addCriterion("hospLogTime is not null");
            return (Criteria) this;
        }

        public Criteria andHosplogtimeEqualTo(Date value) {
            addCriterion("hospLogTime =", value, "hosplogtime");
            return (Criteria) this;
        }

        public Criteria andHosplogtimeNotEqualTo(Date value) {
            addCriterion("hospLogTime <>", value, "hosplogtime");
            return (Criteria) this;
        }

        public Criteria andHosplogtimeGreaterThan(Date value) {
            addCriterion("hospLogTime >", value, "hosplogtime");
            return (Criteria) this;
        }

        public Criteria andHosplogtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("hospLogTime >=", value, "hosplogtime");
            return (Criteria) this;
        }

        public Criteria andHosplogtimeLessThan(Date value) {
            addCriterion("hospLogTime <", value, "hosplogtime");
            return (Criteria) this;
        }

        public Criteria andHosplogtimeLessThanOrEqualTo(Date value) {
            addCriterion("hospLogTime <=", value, "hosplogtime");
            return (Criteria) this;
        }

        public Criteria andHosplogtimeIn(List<Date> values) {
            addCriterion("hospLogTime in", values, "hosplogtime");
            return (Criteria) this;
        }

        public Criteria andHosplogtimeNotIn(List<Date> values) {
            addCriterion("hospLogTime not in", values, "hosplogtime");
            return (Criteria) this;
        }

        public Criteria andHosplogtimeBetween(Date value1, Date value2) {
            addCriterion("hospLogTime between", value1, value2, "hosplogtime");
            return (Criteria) this;
        }

        public Criteria andHosplogtimeNotBetween(Date value1, Date value2) {
            addCriterion("hospLogTime not between", value1, value2, "hosplogtime");
            return (Criteria) this;
        }

        public Criteria andHosploglocIsNull() {
            addCriterion("hospLogLoc is null");
            return (Criteria) this;
        }

        public Criteria andHosploglocIsNotNull() {
            addCriterion("hospLogLoc is not null");
            return (Criteria) this;
        }

        public Criteria andHosploglocEqualTo(String value) {
            addCriterion("hospLogLoc =", value, "hosplogloc");
            return (Criteria) this;
        }

        public Criteria andHosploglocNotEqualTo(String value) {
            addCriterion("hospLogLoc <>", value, "hosplogloc");
            return (Criteria) this;
        }

        public Criteria andHosploglocGreaterThan(String value) {
            addCriterion("hospLogLoc >", value, "hosplogloc");
            return (Criteria) this;
        }

        public Criteria andHosploglocGreaterThanOrEqualTo(String value) {
            addCriterion("hospLogLoc >=", value, "hosplogloc");
            return (Criteria) this;
        }

        public Criteria andHosploglocLessThan(String value) {
            addCriterion("hospLogLoc <", value, "hosplogloc");
            return (Criteria) this;
        }

        public Criteria andHosploglocLessThanOrEqualTo(String value) {
            addCriterion("hospLogLoc <=", value, "hosplogloc");
            return (Criteria) this;
        }

        public Criteria andHosploglocLike(String value) {
            addCriterion("hospLogLoc like", value, "hosplogloc");
            return (Criteria) this;
        }

        public Criteria andHosploglocNotLike(String value) {
            addCriterion("hospLogLoc not like", value, "hosplogloc");
            return (Criteria) this;
        }

        public Criteria andHosploglocIn(List<String> values) {
            addCriterion("hospLogLoc in", values, "hosplogloc");
            return (Criteria) this;
        }

        public Criteria andHosploglocNotIn(List<String> values) {
            addCriterion("hospLogLoc not in", values, "hosplogloc");
            return (Criteria) this;
        }

        public Criteria andHosploglocBetween(String value1, String value2) {
            addCriterion("hospLogLoc between", value1, value2, "hosplogloc");
            return (Criteria) this;
        }

        public Criteria andHosploglocNotBetween(String value1, String value2) {
            addCriterion("hospLogLoc not between", value1, value2, "hosplogloc");
            return (Criteria) this;
        }

        public Criteria andHosplogbverIsNull() {
            addCriterion("hospLogBVer is null");
            return (Criteria) this;
        }

        public Criteria andHosplogbverIsNotNull() {
            addCriterion("hospLogBVer is not null");
            return (Criteria) this;
        }

        public Criteria andHosplogbverEqualTo(String value) {
            addCriterion("hospLogBVer =", value, "hosplogbver");
            return (Criteria) this;
        }

        public Criteria andHosplogbverNotEqualTo(String value) {
            addCriterion("hospLogBVer <>", value, "hosplogbver");
            return (Criteria) this;
        }

        public Criteria andHosplogbverGreaterThan(String value) {
            addCriterion("hospLogBVer >", value, "hosplogbver");
            return (Criteria) this;
        }

        public Criteria andHosplogbverGreaterThanOrEqualTo(String value) {
            addCriterion("hospLogBVer >=", value, "hosplogbver");
            return (Criteria) this;
        }

        public Criteria andHosplogbverLessThan(String value) {
            addCriterion("hospLogBVer <", value, "hosplogbver");
            return (Criteria) this;
        }

        public Criteria andHosplogbverLessThanOrEqualTo(String value) {
            addCriterion("hospLogBVer <=", value, "hosplogbver");
            return (Criteria) this;
        }

        public Criteria andHosplogbverLike(String value) {
            addCriterion("hospLogBVer like", value, "hosplogbver");
            return (Criteria) this;
        }

        public Criteria andHosplogbverNotLike(String value) {
            addCriterion("hospLogBVer not like", value, "hosplogbver");
            return (Criteria) this;
        }

        public Criteria andHosplogbverIn(List<String> values) {
            addCriterion("hospLogBVer in", values, "hosplogbver");
            return (Criteria) this;
        }

        public Criteria andHosplogbverNotIn(List<String> values) {
            addCriterion("hospLogBVer not in", values, "hosplogbver");
            return (Criteria) this;
        }

        public Criteria andHosplogbverBetween(String value1, String value2) {
            addCriterion("hospLogBVer between", value1, value2, "hosplogbver");
            return (Criteria) this;
        }

        public Criteria andHosplogbverNotBetween(String value1, String value2) {
            addCriterion("hospLogBVer not between", value1, value2, "hosplogbver");
            return (Criteria) this;
        }

        public Criteria andHosplogmacIsNull() {
            addCriterion("hospLogMac is null");
            return (Criteria) this;
        }

        public Criteria andHosplogmacIsNotNull() {
            addCriterion("hospLogMac is not null");
            return (Criteria) this;
        }

        public Criteria andHosplogmacEqualTo(String value) {
            addCriterion("hospLogMac =", value, "hosplogmac");
            return (Criteria) this;
        }

        public Criteria andHosplogmacNotEqualTo(String value) {
            addCriterion("hospLogMac <>", value, "hosplogmac");
            return (Criteria) this;
        }

        public Criteria andHosplogmacGreaterThan(String value) {
            addCriterion("hospLogMac >", value, "hosplogmac");
            return (Criteria) this;
        }

        public Criteria andHosplogmacGreaterThanOrEqualTo(String value) {
            addCriterion("hospLogMac >=", value, "hosplogmac");
            return (Criteria) this;
        }

        public Criteria andHosplogmacLessThan(String value) {
            addCriterion("hospLogMac <", value, "hosplogmac");
            return (Criteria) this;
        }

        public Criteria andHosplogmacLessThanOrEqualTo(String value) {
            addCriterion("hospLogMac <=", value, "hosplogmac");
            return (Criteria) this;
        }

        public Criteria andHosplogmacLike(String value) {
            addCriterion("hospLogMac like", value, "hosplogmac");
            return (Criteria) this;
        }

        public Criteria andHosplogmacNotLike(String value) {
            addCriterion("hospLogMac not like", value, "hosplogmac");
            return (Criteria) this;
        }

        public Criteria andHosplogmacIn(List<String> values) {
            addCriterion("hospLogMac in", values, "hosplogmac");
            return (Criteria) this;
        }

        public Criteria andHosplogmacNotIn(List<String> values) {
            addCriterion("hospLogMac not in", values, "hosplogmac");
            return (Criteria) this;
        }

        public Criteria andHosplogmacBetween(String value1, String value2) {
            addCriterion("hospLogMac between", value1, value2, "hosplogmac");
            return (Criteria) this;
        }

        public Criteria andHosplogmacNotBetween(String value1, String value2) {
            addCriterion("hospLogMac not between", value1, value2, "hosplogmac");
            return (Criteria) this;
        }

        public Criteria andHosplogipIsNull() {
            addCriterion("hospLogIp is null");
            return (Criteria) this;
        }

        public Criteria andHosplogipIsNotNull() {
            addCriterion("hospLogIp is not null");
            return (Criteria) this;
        }

        public Criteria andHosplogipEqualTo(String value) {
            addCriterion("hospLogIp =", value, "hosplogip");
            return (Criteria) this;
        }

        public Criteria andHosplogipNotEqualTo(String value) {
            addCriterion("hospLogIp <>", value, "hosplogip");
            return (Criteria) this;
        }

        public Criteria andHosplogipGreaterThan(String value) {
            addCriterion("hospLogIp >", value, "hosplogip");
            return (Criteria) this;
        }

        public Criteria andHosplogipGreaterThanOrEqualTo(String value) {
            addCriterion("hospLogIp >=", value, "hosplogip");
            return (Criteria) this;
        }

        public Criteria andHosplogipLessThan(String value) {
            addCriterion("hospLogIp <", value, "hosplogip");
            return (Criteria) this;
        }

        public Criteria andHosplogipLessThanOrEqualTo(String value) {
            addCriterion("hospLogIp <=", value, "hosplogip");
            return (Criteria) this;
        }

        public Criteria andHosplogipLike(String value) {
            addCriterion("hospLogIp like", value, "hosplogip");
            return (Criteria) this;
        }

        public Criteria andHosplogipNotLike(String value) {
            addCriterion("hospLogIp not like", value, "hosplogip");
            return (Criteria) this;
        }

        public Criteria andHosplogipIn(List<String> values) {
            addCriterion("hospLogIp in", values, "hosplogip");
            return (Criteria) this;
        }

        public Criteria andHosplogipNotIn(List<String> values) {
            addCriterion("hospLogIp not in", values, "hosplogip");
            return (Criteria) this;
        }

        public Criteria andHosplogipBetween(String value1, String value2) {
            addCriterion("hospLogIp between", value1, value2, "hosplogip");
            return (Criteria) this;
        }

        public Criteria andHosplogipNotBetween(String value1, String value2) {
            addCriterion("hospLogIp not between", value1, value2, "hosplogip");
            return (Criteria) this;
        }

        public Criteria andHosploginidIsNull() {
            addCriterion("hospLoginId is null");
            return (Criteria) this;
        }

        public Criteria andHosploginidIsNotNull() {
            addCriterion("hospLoginId is not null");
            return (Criteria) this;
        }

        public Criteria andHosploginidEqualTo(Integer value) {
            addCriterion("hospLoginId =", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidNotEqualTo(Integer value) {
            addCriterion("hospLoginId <>", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidGreaterThan(Integer value) {
            addCriterion("hospLoginId >", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hospLoginId >=", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidLessThan(Integer value) {
            addCriterion("hospLoginId <", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidLessThanOrEqualTo(Integer value) {
            addCriterion("hospLoginId <=", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidIn(List<Integer> values) {
            addCriterion("hospLoginId in", values, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidNotIn(List<Integer> values) {
            addCriterion("hospLoginId not in", values, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidBetween(Integer value1, Integer value2) {
            addCriterion("hospLoginId between", value1, value2, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidNotBetween(Integer value1, Integer value2) {
            addCriterion("hospLoginId not between", value1, value2, "hosploginid");
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