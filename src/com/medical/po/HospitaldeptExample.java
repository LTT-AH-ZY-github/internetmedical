package com.medical.po;

import java.util.ArrayList;
import java.util.List;

public class HospitaldeptExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HospitaldeptExample() {
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

        public Criteria andHospdeptidIsNull() {
            addCriterion("hospDeptId is null");
            return (Criteria) this;
        }

        public Criteria andHospdeptidIsNotNull() {
            addCriterion("hospDeptId is not null");
            return (Criteria) this;
        }

        public Criteria andHospdeptidEqualTo(Integer value) {
            addCriterion("hospDeptId =", value, "hospdeptid");
            return (Criteria) this;
        }

        public Criteria andHospdeptidNotEqualTo(Integer value) {
            addCriterion("hospDeptId <>", value, "hospdeptid");
            return (Criteria) this;
        }

        public Criteria andHospdeptidGreaterThan(Integer value) {
            addCriterion("hospDeptId >", value, "hospdeptid");
            return (Criteria) this;
        }

        public Criteria andHospdeptidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hospDeptId >=", value, "hospdeptid");
            return (Criteria) this;
        }

        public Criteria andHospdeptidLessThan(Integer value) {
            addCriterion("hospDeptId <", value, "hospdeptid");
            return (Criteria) this;
        }

        public Criteria andHospdeptidLessThanOrEqualTo(Integer value) {
            addCriterion("hospDeptId <=", value, "hospdeptid");
            return (Criteria) this;
        }

        public Criteria andHospdeptidIn(List<Integer> values) {
            addCriterion("hospDeptId in", values, "hospdeptid");
            return (Criteria) this;
        }

        public Criteria andHospdeptidNotIn(List<Integer> values) {
            addCriterion("hospDeptId not in", values, "hospdeptid");
            return (Criteria) this;
        }

        public Criteria andHospdeptidBetween(Integer value1, Integer value2) {
            addCriterion("hospDeptId between", value1, value2, "hospdeptid");
            return (Criteria) this;
        }

        public Criteria andHospdeptidNotBetween(Integer value1, Integer value2) {
            addCriterion("hospDeptId not between", value1, value2, "hospdeptid");
            return (Criteria) this;
        }

        public Criteria andHospdeptnameIsNull() {
            addCriterion("hospDeptName is null");
            return (Criteria) this;
        }

        public Criteria andHospdeptnameIsNotNull() {
            addCriterion("hospDeptName is not null");
            return (Criteria) this;
        }

        public Criteria andHospdeptnameEqualTo(String value) {
            addCriterion("hospDeptName =", value, "hospdeptname");
            return (Criteria) this;
        }

        public Criteria andHospdeptnameNotEqualTo(String value) {
            addCriterion("hospDeptName <>", value, "hospdeptname");
            return (Criteria) this;
        }

        public Criteria andHospdeptnameGreaterThan(String value) {
            addCriterion("hospDeptName >", value, "hospdeptname");
            return (Criteria) this;
        }

        public Criteria andHospdeptnameGreaterThanOrEqualTo(String value) {
            addCriterion("hospDeptName >=", value, "hospdeptname");
            return (Criteria) this;
        }

        public Criteria andHospdeptnameLessThan(String value) {
            addCriterion("hospDeptName <", value, "hospdeptname");
            return (Criteria) this;
        }

        public Criteria andHospdeptnameLessThanOrEqualTo(String value) {
            addCriterion("hospDeptName <=", value, "hospdeptname");
            return (Criteria) this;
        }

        public Criteria andHospdeptnameLike(String value) {
            addCriterion("hospDeptName like", value, "hospdeptname");
            return (Criteria) this;
        }

        public Criteria andHospdeptnameNotLike(String value) {
            addCriterion("hospDeptName not like", value, "hospdeptname");
            return (Criteria) this;
        }

        public Criteria andHospdeptnameIn(List<String> values) {
            addCriterion("hospDeptName in", values, "hospdeptname");
            return (Criteria) this;
        }

        public Criteria andHospdeptnameNotIn(List<String> values) {
            addCriterion("hospDeptName not in", values, "hospdeptname");
            return (Criteria) this;
        }

        public Criteria andHospdeptnameBetween(String value1, String value2) {
            addCriterion("hospDeptName between", value1, value2, "hospdeptname");
            return (Criteria) this;
        }

        public Criteria andHospdeptnameNotBetween(String value1, String value2) {
            addCriterion("hospDeptName not between", value1, value2, "hospdeptname");
            return (Criteria) this;
        }

        public Criteria andHospdeptabsIsNull() {
            addCriterion("hospDeptAbs is null");
            return (Criteria) this;
        }

        public Criteria andHospdeptabsIsNotNull() {
            addCriterion("hospDeptAbs is not null");
            return (Criteria) this;
        }

        public Criteria andHospdeptabsEqualTo(String value) {
            addCriterion("hospDeptAbs =", value, "hospdeptabs");
            return (Criteria) this;
        }

        public Criteria andHospdeptabsNotEqualTo(String value) {
            addCriterion("hospDeptAbs <>", value, "hospdeptabs");
            return (Criteria) this;
        }

        public Criteria andHospdeptabsGreaterThan(String value) {
            addCriterion("hospDeptAbs >", value, "hospdeptabs");
            return (Criteria) this;
        }

        public Criteria andHospdeptabsGreaterThanOrEqualTo(String value) {
            addCriterion("hospDeptAbs >=", value, "hospdeptabs");
            return (Criteria) this;
        }

        public Criteria andHospdeptabsLessThan(String value) {
            addCriterion("hospDeptAbs <", value, "hospdeptabs");
            return (Criteria) this;
        }

        public Criteria andHospdeptabsLessThanOrEqualTo(String value) {
            addCriterion("hospDeptAbs <=", value, "hospdeptabs");
            return (Criteria) this;
        }

        public Criteria andHospdeptabsLike(String value) {
            addCriterion("hospDeptAbs like", value, "hospdeptabs");
            return (Criteria) this;
        }

        public Criteria andHospdeptabsNotLike(String value) {
            addCriterion("hospDeptAbs not like", value, "hospdeptabs");
            return (Criteria) this;
        }

        public Criteria andHospdeptabsIn(List<String> values) {
            addCriterion("hospDeptAbs in", values, "hospdeptabs");
            return (Criteria) this;
        }

        public Criteria andHospdeptabsNotIn(List<String> values) {
            addCriterion("hospDeptAbs not in", values, "hospdeptabs");
            return (Criteria) this;
        }

        public Criteria andHospdeptabsBetween(String value1, String value2) {
            addCriterion("hospDeptAbs between", value1, value2, "hospdeptabs");
            return (Criteria) this;
        }

        public Criteria andHospdeptabsNotBetween(String value1, String value2) {
            addCriterion("hospDeptAbs not between", value1, value2, "hospdeptabs");
            return (Criteria) this;
        }

        public Criteria andHospdeptfatheridIsNull() {
            addCriterion("hospDeptFatherId is null");
            return (Criteria) this;
        }

        public Criteria andHospdeptfatheridIsNotNull() {
            addCriterion("hospDeptFatherId is not null");
            return (Criteria) this;
        }

        public Criteria andHospdeptfatheridEqualTo(Integer value) {
            addCriterion("hospDeptFatherId =", value, "hospdeptfatherid");
            return (Criteria) this;
        }

        public Criteria andHospdeptfatheridNotEqualTo(Integer value) {
            addCriterion("hospDeptFatherId <>", value, "hospdeptfatherid");
            return (Criteria) this;
        }

        public Criteria andHospdeptfatheridGreaterThan(Integer value) {
            addCriterion("hospDeptFatherId >", value, "hospdeptfatherid");
            return (Criteria) this;
        }

        public Criteria andHospdeptfatheridGreaterThanOrEqualTo(Integer value) {
            addCriterion("hospDeptFatherId >=", value, "hospdeptfatherid");
            return (Criteria) this;
        }

        public Criteria andHospdeptfatheridLessThan(Integer value) {
            addCriterion("hospDeptFatherId <", value, "hospdeptfatherid");
            return (Criteria) this;
        }

        public Criteria andHospdeptfatheridLessThanOrEqualTo(Integer value) {
            addCriterion("hospDeptFatherId <=", value, "hospdeptfatherid");
            return (Criteria) this;
        }

        public Criteria andHospdeptfatheridIn(List<Integer> values) {
            addCriterion("hospDeptFatherId in", values, "hospdeptfatherid");
            return (Criteria) this;
        }

        public Criteria andHospdeptfatheridNotIn(List<Integer> values) {
            addCriterion("hospDeptFatherId not in", values, "hospdeptfatherid");
            return (Criteria) this;
        }

        public Criteria andHospdeptfatheridBetween(Integer value1, Integer value2) {
            addCriterion("hospDeptFatherId between", value1, value2, "hospdeptfatherid");
            return (Criteria) this;
        }

        public Criteria andHospdeptfatheridNotBetween(Integer value1, Integer value2) {
            addCriterion("hospDeptFatherId not between", value1, value2, "hospdeptfatherid");
            return (Criteria) this;
        }

        public Criteria andHospdeptischeckIsNull() {
            addCriterion("hospDeptIsCheck is null");
            return (Criteria) this;
        }

        public Criteria andHospdeptischeckIsNotNull() {
            addCriterion("hospDeptIsCheck is not null");
            return (Criteria) this;
        }

        public Criteria andHospdeptischeckEqualTo(Integer value) {
            addCriterion("hospDeptIsCheck =", value, "hospdeptischeck");
            return (Criteria) this;
        }

        public Criteria andHospdeptischeckNotEqualTo(Integer value) {
            addCriterion("hospDeptIsCheck <>", value, "hospdeptischeck");
            return (Criteria) this;
        }

        public Criteria andHospdeptischeckGreaterThan(Integer value) {
            addCriterion("hospDeptIsCheck >", value, "hospdeptischeck");
            return (Criteria) this;
        }

        public Criteria andHospdeptischeckGreaterThanOrEqualTo(Integer value) {
            addCriterion("hospDeptIsCheck >=", value, "hospdeptischeck");
            return (Criteria) this;
        }

        public Criteria andHospdeptischeckLessThan(Integer value) {
            addCriterion("hospDeptIsCheck <", value, "hospdeptischeck");
            return (Criteria) this;
        }

        public Criteria andHospdeptischeckLessThanOrEqualTo(Integer value) {
            addCriterion("hospDeptIsCheck <=", value, "hospdeptischeck");
            return (Criteria) this;
        }

        public Criteria andHospdeptischeckIn(List<Integer> values) {
            addCriterion("hospDeptIsCheck in", values, "hospdeptischeck");
            return (Criteria) this;
        }

        public Criteria andHospdeptischeckNotIn(List<Integer> values) {
            addCriterion("hospDeptIsCheck not in", values, "hospdeptischeck");
            return (Criteria) this;
        }

        public Criteria andHospdeptischeckBetween(Integer value1, Integer value2) {
            addCriterion("hospDeptIsCheck between", value1, value2, "hospdeptischeck");
            return (Criteria) this;
        }

        public Criteria andHospdeptischeckNotBetween(Integer value1, Integer value2) {
            addCriterion("hospDeptIsCheck not between", value1, value2, "hospdeptischeck");
            return (Criteria) this;
        }

        public Criteria andHospdeptsubmitterIsNull() {
            addCriterion("hospDeptSubmitter is null");
            return (Criteria) this;
        }

        public Criteria andHospdeptsubmitterIsNotNull() {
            addCriterion("hospDeptSubmitter is not null");
            return (Criteria) this;
        }

        public Criteria andHospdeptsubmitterEqualTo(Integer value) {
            addCriterion("hospDeptSubmitter =", value, "hospdeptsubmitter");
            return (Criteria) this;
        }

        public Criteria andHospdeptsubmitterNotEqualTo(Integer value) {
            addCriterion("hospDeptSubmitter <>", value, "hospdeptsubmitter");
            return (Criteria) this;
        }

        public Criteria andHospdeptsubmitterGreaterThan(Integer value) {
            addCriterion("hospDeptSubmitter >", value, "hospdeptsubmitter");
            return (Criteria) this;
        }

        public Criteria andHospdeptsubmitterGreaterThanOrEqualTo(Integer value) {
            addCriterion("hospDeptSubmitter >=", value, "hospdeptsubmitter");
            return (Criteria) this;
        }

        public Criteria andHospdeptsubmitterLessThan(Integer value) {
            addCriterion("hospDeptSubmitter <", value, "hospdeptsubmitter");
            return (Criteria) this;
        }

        public Criteria andHospdeptsubmitterLessThanOrEqualTo(Integer value) {
            addCriterion("hospDeptSubmitter <=", value, "hospdeptsubmitter");
            return (Criteria) this;
        }

        public Criteria andHospdeptsubmitterIn(List<Integer> values) {
            addCriterion("hospDeptSubmitter in", values, "hospdeptsubmitter");
            return (Criteria) this;
        }

        public Criteria andHospdeptsubmitterNotIn(List<Integer> values) {
            addCriterion("hospDeptSubmitter not in", values, "hospdeptsubmitter");
            return (Criteria) this;
        }

        public Criteria andHospdeptsubmitterBetween(Integer value1, Integer value2) {
            addCriterion("hospDeptSubmitter between", value1, value2, "hospdeptsubmitter");
            return (Criteria) this;
        }

        public Criteria andHospdeptsubmitterNotBetween(Integer value1, Integer value2) {
            addCriterion("hospDeptSubmitter not between", value1, value2, "hospdeptsubmitter");
            return (Criteria) this;
        }

        public Criteria andHospdeptsubmittertypeIsNull() {
            addCriterion("hospDeptSubmitterType is null");
            return (Criteria) this;
        }

        public Criteria andHospdeptsubmittertypeIsNotNull() {
            addCriterion("hospDeptSubmitterType is not null");
            return (Criteria) this;
        }

        public Criteria andHospdeptsubmittertypeEqualTo(Integer value) {
            addCriterion("hospDeptSubmitterType =", value, "hospdeptsubmittertype");
            return (Criteria) this;
        }

        public Criteria andHospdeptsubmittertypeNotEqualTo(Integer value) {
            addCriterion("hospDeptSubmitterType <>", value, "hospdeptsubmittertype");
            return (Criteria) this;
        }

        public Criteria andHospdeptsubmittertypeGreaterThan(Integer value) {
            addCriterion("hospDeptSubmitterType >", value, "hospdeptsubmittertype");
            return (Criteria) this;
        }

        public Criteria andHospdeptsubmittertypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("hospDeptSubmitterType >=", value, "hospdeptsubmittertype");
            return (Criteria) this;
        }

        public Criteria andHospdeptsubmittertypeLessThan(Integer value) {
            addCriterion("hospDeptSubmitterType <", value, "hospdeptsubmittertype");
            return (Criteria) this;
        }

        public Criteria andHospdeptsubmittertypeLessThanOrEqualTo(Integer value) {
            addCriterion("hospDeptSubmitterType <=", value, "hospdeptsubmittertype");
            return (Criteria) this;
        }

        public Criteria andHospdeptsubmittertypeIn(List<Integer> values) {
            addCriterion("hospDeptSubmitterType in", values, "hospdeptsubmittertype");
            return (Criteria) this;
        }

        public Criteria andHospdeptsubmittertypeNotIn(List<Integer> values) {
            addCriterion("hospDeptSubmitterType not in", values, "hospdeptsubmittertype");
            return (Criteria) this;
        }

        public Criteria andHospdeptsubmittertypeBetween(Integer value1, Integer value2) {
            addCriterion("hospDeptSubmitterType between", value1, value2, "hospdeptsubmittertype");
            return (Criteria) this;
        }

        public Criteria andHospdeptsubmittertypeNotBetween(Integer value1, Integer value2) {
            addCriterion("hospDeptSubmitterType not between", value1, value2, "hospdeptsubmittertype");
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