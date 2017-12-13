package com.medical.po;

import java.util.ArrayList;
import java.util.List;

public class HospitalberthExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HospitalberthExample() {
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

        public Criteria andHospberthidIsNull() {
            addCriterion("hospBerthId is null");
            return (Criteria) this;
        }

        public Criteria andHospberthidIsNotNull() {
            addCriterion("hospBerthId is not null");
            return (Criteria) this;
        }

        public Criteria andHospberthidEqualTo(Integer value) {
            addCriterion("hospBerthId =", value, "hospberthid");
            return (Criteria) this;
        }

        public Criteria andHospberthidNotEqualTo(Integer value) {
            addCriterion("hospBerthId <>", value, "hospberthid");
            return (Criteria) this;
        }

        public Criteria andHospberthidGreaterThan(Integer value) {
            addCriterion("hospBerthId >", value, "hospberthid");
            return (Criteria) this;
        }

        public Criteria andHospberthidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hospBerthId >=", value, "hospberthid");
            return (Criteria) this;
        }

        public Criteria andHospberthidLessThan(Integer value) {
            addCriterion("hospBerthId <", value, "hospberthid");
            return (Criteria) this;
        }

        public Criteria andHospberthidLessThanOrEqualTo(Integer value) {
            addCriterion("hospBerthId <=", value, "hospberthid");
            return (Criteria) this;
        }

        public Criteria andHospberthidIn(List<Integer> values) {
            addCriterion("hospBerthId in", values, "hospberthid");
            return (Criteria) this;
        }

        public Criteria andHospberthidNotIn(List<Integer> values) {
            addCriterion("hospBerthId not in", values, "hospberthid");
            return (Criteria) this;
        }

        public Criteria andHospberthidBetween(Integer value1, Integer value2) {
            addCriterion("hospBerthId between", value1, value2, "hospberthid");
            return (Criteria) this;
        }

        public Criteria andHospberthidNotBetween(Integer value1, Integer value2) {
            addCriterion("hospBerthId not between", value1, value2, "hospberthid");
            return (Criteria) this;
        }

        public Criteria andHospberthdeptidIsNull() {
            addCriterion("hospBerthDeptId is null");
            return (Criteria) this;
        }

        public Criteria andHospberthdeptidIsNotNull() {
            addCriterion("hospBerthDeptId is not null");
            return (Criteria) this;
        }

        public Criteria andHospberthdeptidEqualTo(Integer value) {
            addCriterion("hospBerthDeptId =", value, "hospberthdeptid");
            return (Criteria) this;
        }

        public Criteria andHospberthdeptidNotEqualTo(Integer value) {
            addCriterion("hospBerthDeptId <>", value, "hospberthdeptid");
            return (Criteria) this;
        }

        public Criteria andHospberthdeptidGreaterThan(Integer value) {
            addCriterion("hospBerthDeptId >", value, "hospberthdeptid");
            return (Criteria) this;
        }

        public Criteria andHospberthdeptidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hospBerthDeptId >=", value, "hospberthdeptid");
            return (Criteria) this;
        }

        public Criteria andHospberthdeptidLessThan(Integer value) {
            addCriterion("hospBerthDeptId <", value, "hospberthdeptid");
            return (Criteria) this;
        }

        public Criteria andHospberthdeptidLessThanOrEqualTo(Integer value) {
            addCriterion("hospBerthDeptId <=", value, "hospberthdeptid");
            return (Criteria) this;
        }

        public Criteria andHospberthdeptidIn(List<Integer> values) {
            addCriterion("hospBerthDeptId in", values, "hospberthdeptid");
            return (Criteria) this;
        }

        public Criteria andHospberthdeptidNotIn(List<Integer> values) {
            addCriterion("hospBerthDeptId not in", values, "hospberthdeptid");
            return (Criteria) this;
        }

        public Criteria andHospberthdeptidBetween(Integer value1, Integer value2) {
            addCriterion("hospBerthDeptId between", value1, value2, "hospberthdeptid");
            return (Criteria) this;
        }

        public Criteria andHospberthdeptidNotBetween(Integer value1, Integer value2) {
            addCriterion("hospBerthDeptId not between", value1, value2, "hospberthdeptid");
            return (Criteria) this;
        }

        public Criteria andHospberthnameIsNull() {
            addCriterion("hospBerthName is null");
            return (Criteria) this;
        }

        public Criteria andHospberthnameIsNotNull() {
            addCriterion("hospBerthName is not null");
            return (Criteria) this;
        }

        public Criteria andHospberthnameEqualTo(String value) {
            addCriterion("hospBerthName =", value, "hospberthname");
            return (Criteria) this;
        }

        public Criteria andHospberthnameNotEqualTo(String value) {
            addCriterion("hospBerthName <>", value, "hospberthname");
            return (Criteria) this;
        }

        public Criteria andHospberthnameGreaterThan(String value) {
            addCriterion("hospBerthName >", value, "hospberthname");
            return (Criteria) this;
        }

        public Criteria andHospberthnameGreaterThanOrEqualTo(String value) {
            addCriterion("hospBerthName >=", value, "hospberthname");
            return (Criteria) this;
        }

        public Criteria andHospberthnameLessThan(String value) {
            addCriterion("hospBerthName <", value, "hospberthname");
            return (Criteria) this;
        }

        public Criteria andHospberthnameLessThanOrEqualTo(String value) {
            addCriterion("hospBerthName <=", value, "hospberthname");
            return (Criteria) this;
        }

        public Criteria andHospberthnameLike(String value) {
            addCriterion("hospBerthName like", value, "hospberthname");
            return (Criteria) this;
        }

        public Criteria andHospberthnameNotLike(String value) {
            addCriterion("hospBerthName not like", value, "hospberthname");
            return (Criteria) this;
        }

        public Criteria andHospberthnameIn(List<String> values) {
            addCriterion("hospBerthName in", values, "hospberthname");
            return (Criteria) this;
        }

        public Criteria andHospberthnameNotIn(List<String> values) {
            addCriterion("hospBerthName not in", values, "hospberthname");
            return (Criteria) this;
        }

        public Criteria andHospberthnameBetween(String value1, String value2) {
            addCriterion("hospBerthName between", value1, value2, "hospberthname");
            return (Criteria) this;
        }

        public Criteria andHospberthnameNotBetween(String value1, String value2) {
            addCriterion("hospBerthName not between", value1, value2, "hospberthname");
            return (Criteria) this;
        }

        public Criteria andHospberthabsIsNull() {
            addCriterion("hospBerthAbs is null");
            return (Criteria) this;
        }

        public Criteria andHospberthabsIsNotNull() {
            addCriterion("hospBerthAbs is not null");
            return (Criteria) this;
        }

        public Criteria andHospberthabsEqualTo(String value) {
            addCriterion("hospBerthAbs =", value, "hospberthabs");
            return (Criteria) this;
        }

        public Criteria andHospberthabsNotEqualTo(String value) {
            addCriterion("hospBerthAbs <>", value, "hospberthabs");
            return (Criteria) this;
        }

        public Criteria andHospberthabsGreaterThan(String value) {
            addCriterion("hospBerthAbs >", value, "hospberthabs");
            return (Criteria) this;
        }

        public Criteria andHospberthabsGreaterThanOrEqualTo(String value) {
            addCriterion("hospBerthAbs >=", value, "hospberthabs");
            return (Criteria) this;
        }

        public Criteria andHospberthabsLessThan(String value) {
            addCriterion("hospBerthAbs <", value, "hospberthabs");
            return (Criteria) this;
        }

        public Criteria andHospberthabsLessThanOrEqualTo(String value) {
            addCriterion("hospBerthAbs <=", value, "hospberthabs");
            return (Criteria) this;
        }

        public Criteria andHospberthabsLike(String value) {
            addCriterion("hospBerthAbs like", value, "hospberthabs");
            return (Criteria) this;
        }

        public Criteria andHospberthabsNotLike(String value) {
            addCriterion("hospBerthAbs not like", value, "hospberthabs");
            return (Criteria) this;
        }

        public Criteria andHospberthabsIn(List<String> values) {
            addCriterion("hospBerthAbs in", values, "hospberthabs");
            return (Criteria) this;
        }

        public Criteria andHospberthabsNotIn(List<String> values) {
            addCriterion("hospBerthAbs not in", values, "hospberthabs");
            return (Criteria) this;
        }

        public Criteria andHospberthabsBetween(String value1, String value2) {
            addCriterion("hospBerthAbs between", value1, value2, "hospberthabs");
            return (Criteria) this;
        }

        public Criteria andHospberthabsNotBetween(String value1, String value2) {
            addCriterion("hospBerthAbs not between", value1, value2, "hospberthabs");
            return (Criteria) this;
        }

        public Criteria andHosploginidIsNull() {
            addCriterion("hosploginid is null");
            return (Criteria) this;
        }

        public Criteria andHosploginidIsNotNull() {
            addCriterion("hosploginid is not null");
            return (Criteria) this;
        }

        public Criteria andHosploginidEqualTo(Integer value) {
            addCriterion("hosploginid =", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidNotEqualTo(Integer value) {
            addCriterion("hosploginid <>", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidGreaterThan(Integer value) {
            addCriterion("hosploginid >", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hosploginid >=", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidLessThan(Integer value) {
            addCriterion("hosploginid <", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidLessThanOrEqualTo(Integer value) {
            addCriterion("hosploginid <=", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidIn(List<Integer> values) {
            addCriterion("hosploginid in", values, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidNotIn(List<Integer> values) {
            addCriterion("hosploginid not in", values, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidBetween(Integer value1, Integer value2) {
            addCriterion("hosploginid between", value1, value2, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidNotBetween(Integer value1, Integer value2) {
            addCriterion("hosploginid not between", value1, value2, "hosploginid");
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