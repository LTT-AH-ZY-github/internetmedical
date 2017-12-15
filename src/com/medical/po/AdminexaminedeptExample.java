package com.medical.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminexaminedeptExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminexaminedeptExample() {
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

        public Criteria andExamineidIsNull() {
            addCriterion("examineId is null");
            return (Criteria) this;
        }

        public Criteria andExamineidIsNotNull() {
            addCriterion("examineId is not null");
            return (Criteria) this;
        }

        public Criteria andExamineidEqualTo(Integer value) {
            addCriterion("examineId =", value, "examineid");
            return (Criteria) this;
        }

        public Criteria andExamineidNotEqualTo(Integer value) {
            addCriterion("examineId <>", value, "examineid");
            return (Criteria) this;
        }

        public Criteria andExamineidGreaterThan(Integer value) {
            addCriterion("examineId >", value, "examineid");
            return (Criteria) this;
        }

        public Criteria andExamineidGreaterThanOrEqualTo(Integer value) {
            addCriterion("examineId >=", value, "examineid");
            return (Criteria) this;
        }

        public Criteria andExamineidLessThan(Integer value) {
            addCriterion("examineId <", value, "examineid");
            return (Criteria) this;
        }

        public Criteria andExamineidLessThanOrEqualTo(Integer value) {
            addCriterion("examineId <=", value, "examineid");
            return (Criteria) this;
        }

        public Criteria andExamineidIn(List<Integer> values) {
            addCriterion("examineId in", values, "examineid");
            return (Criteria) this;
        }

        public Criteria andExamineidNotIn(List<Integer> values) {
            addCriterion("examineId not in", values, "examineid");
            return (Criteria) this;
        }

        public Criteria andExamineidBetween(Integer value1, Integer value2) {
            addCriterion("examineId between", value1, value2, "examineid");
            return (Criteria) this;
        }

        public Criteria andExamineidNotBetween(Integer value1, Integer value2) {
            addCriterion("examineId not between", value1, value2, "examineid");
            return (Criteria) this;
        }

        public Criteria andExaminedeptidIsNull() {
            addCriterion("examineDeptId is null");
            return (Criteria) this;
        }

        public Criteria andExaminedeptidIsNotNull() {
            addCriterion("examineDeptId is not null");
            return (Criteria) this;
        }

        public Criteria andExaminedeptidEqualTo(Integer value) {
            addCriterion("examineDeptId =", value, "examinedeptid");
            return (Criteria) this;
        }

        public Criteria andExaminedeptidNotEqualTo(Integer value) {
            addCriterion("examineDeptId <>", value, "examinedeptid");
            return (Criteria) this;
        }

        public Criteria andExaminedeptidGreaterThan(Integer value) {
            addCriterion("examineDeptId >", value, "examinedeptid");
            return (Criteria) this;
        }

        public Criteria andExaminedeptidGreaterThanOrEqualTo(Integer value) {
            addCriterion("examineDeptId >=", value, "examinedeptid");
            return (Criteria) this;
        }

        public Criteria andExaminedeptidLessThan(Integer value) {
            addCriterion("examineDeptId <", value, "examinedeptid");
            return (Criteria) this;
        }

        public Criteria andExaminedeptidLessThanOrEqualTo(Integer value) {
            addCriterion("examineDeptId <=", value, "examinedeptid");
            return (Criteria) this;
        }

        public Criteria andExaminedeptidIn(List<Integer> values) {
            addCriterion("examineDeptId in", values, "examinedeptid");
            return (Criteria) this;
        }

        public Criteria andExaminedeptidNotIn(List<Integer> values) {
            addCriterion("examineDeptId not in", values, "examinedeptid");
            return (Criteria) this;
        }

        public Criteria andExaminedeptidBetween(Integer value1, Integer value2) {
            addCriterion("examineDeptId between", value1, value2, "examinedeptid");
            return (Criteria) this;
        }

        public Criteria andExaminedeptidNotBetween(Integer value1, Integer value2) {
            addCriterion("examineDeptId not between", value1, value2, "examinedeptid");
            return (Criteria) this;
        }

        public Criteria andExaminedeptnameIsNull() {
            addCriterion("examineDeptName is null");
            return (Criteria) this;
        }

        public Criteria andExaminedeptnameIsNotNull() {
            addCriterion("examineDeptName is not null");
            return (Criteria) this;
        }

        public Criteria andExaminedeptnameEqualTo(String value) {
            addCriterion("examineDeptName =", value, "examinedeptname");
            return (Criteria) this;
        }

        public Criteria andExaminedeptnameNotEqualTo(String value) {
            addCriterion("examineDeptName <>", value, "examinedeptname");
            return (Criteria) this;
        }

        public Criteria andExaminedeptnameGreaterThan(String value) {
            addCriterion("examineDeptName >", value, "examinedeptname");
            return (Criteria) this;
        }

        public Criteria andExaminedeptnameGreaterThanOrEqualTo(String value) {
            addCriterion("examineDeptName >=", value, "examinedeptname");
            return (Criteria) this;
        }

        public Criteria andExaminedeptnameLessThan(String value) {
            addCriterion("examineDeptName <", value, "examinedeptname");
            return (Criteria) this;
        }

        public Criteria andExaminedeptnameLessThanOrEqualTo(String value) {
            addCriterion("examineDeptName <=", value, "examinedeptname");
            return (Criteria) this;
        }

        public Criteria andExaminedeptnameLike(String value) {
            addCriterion("examineDeptName like", value, "examinedeptname");
            return (Criteria) this;
        }

        public Criteria andExaminedeptnameNotLike(String value) {
            addCriterion("examineDeptName not like", value, "examinedeptname");
            return (Criteria) this;
        }

        public Criteria andExaminedeptnameIn(List<String> values) {
            addCriterion("examineDeptName in", values, "examinedeptname");
            return (Criteria) this;
        }

        public Criteria andExaminedeptnameNotIn(List<String> values) {
            addCriterion("examineDeptName not in", values, "examinedeptname");
            return (Criteria) this;
        }

        public Criteria andExaminedeptnameBetween(String value1, String value2) {
            addCriterion("examineDeptName between", value1, value2, "examinedeptname");
            return (Criteria) this;
        }

        public Criteria andExaminedeptnameNotBetween(String value1, String value2) {
            addCriterion("examineDeptName not between", value1, value2, "examinedeptname");
            return (Criteria) this;
        }

        public Criteria andExaminedeptresultIsNull() {
            addCriterion("examineDeptResult is null");
            return (Criteria) this;
        }

        public Criteria andExaminedeptresultIsNotNull() {
            addCriterion("examineDeptResult is not null");
            return (Criteria) this;
        }

        public Criteria andExaminedeptresultEqualTo(Byte value) {
            addCriterion("examineDeptResult =", value, "examinedeptresult");
            return (Criteria) this;
        }

        public Criteria andExaminedeptresultNotEqualTo(Byte value) {
            addCriterion("examineDeptResult <>", value, "examinedeptresult");
            return (Criteria) this;
        }

        public Criteria andExaminedeptresultGreaterThan(Byte value) {
            addCriterion("examineDeptResult >", value, "examinedeptresult");
            return (Criteria) this;
        }

        public Criteria andExaminedeptresultGreaterThanOrEqualTo(Byte value) {
            addCriterion("examineDeptResult >=", value, "examinedeptresult");
            return (Criteria) this;
        }

        public Criteria andExaminedeptresultLessThan(Byte value) {
            addCriterion("examineDeptResult <", value, "examinedeptresult");
            return (Criteria) this;
        }

        public Criteria andExaminedeptresultLessThanOrEqualTo(Byte value) {
            addCriterion("examineDeptResult <=", value, "examinedeptresult");
            return (Criteria) this;
        }

        public Criteria andExaminedeptresultIn(List<Byte> values) {
            addCriterion("examineDeptResult in", values, "examinedeptresult");
            return (Criteria) this;
        }

        public Criteria andExaminedeptresultNotIn(List<Byte> values) {
            addCriterion("examineDeptResult not in", values, "examinedeptresult");
            return (Criteria) this;
        }

        public Criteria andExaminedeptresultBetween(Byte value1, Byte value2) {
            addCriterion("examineDeptResult between", value1, value2, "examinedeptresult");
            return (Criteria) this;
        }

        public Criteria andExaminedeptresultNotBetween(Byte value1, Byte value2) {
            addCriterion("examineDeptResult not between", value1, value2, "examinedeptresult");
            return (Criteria) this;
        }

        public Criteria andExaminedeptideasIsNull() {
            addCriterion("examineDeptideas is null");
            return (Criteria) this;
        }

        public Criteria andExaminedeptideasIsNotNull() {
            addCriterion("examineDeptideas is not null");
            return (Criteria) this;
        }

        public Criteria andExaminedeptideasEqualTo(String value) {
            addCriterion("examineDeptideas =", value, "examinedeptideas");
            return (Criteria) this;
        }

        public Criteria andExaminedeptideasNotEqualTo(String value) {
            addCriterion("examineDeptideas <>", value, "examinedeptideas");
            return (Criteria) this;
        }

        public Criteria andExaminedeptideasGreaterThan(String value) {
            addCriterion("examineDeptideas >", value, "examinedeptideas");
            return (Criteria) this;
        }

        public Criteria andExaminedeptideasGreaterThanOrEqualTo(String value) {
            addCriterion("examineDeptideas >=", value, "examinedeptideas");
            return (Criteria) this;
        }

        public Criteria andExaminedeptideasLessThan(String value) {
            addCriterion("examineDeptideas <", value, "examinedeptideas");
            return (Criteria) this;
        }

        public Criteria andExaminedeptideasLessThanOrEqualTo(String value) {
            addCriterion("examineDeptideas <=", value, "examinedeptideas");
            return (Criteria) this;
        }

        public Criteria andExaminedeptideasLike(String value) {
            addCriterion("examineDeptideas like", value, "examinedeptideas");
            return (Criteria) this;
        }

        public Criteria andExaminedeptideasNotLike(String value) {
            addCriterion("examineDeptideas not like", value, "examinedeptideas");
            return (Criteria) this;
        }

        public Criteria andExaminedeptideasIn(List<String> values) {
            addCriterion("examineDeptideas in", values, "examinedeptideas");
            return (Criteria) this;
        }

        public Criteria andExaminedeptideasNotIn(List<String> values) {
            addCriterion("examineDeptideas not in", values, "examinedeptideas");
            return (Criteria) this;
        }

        public Criteria andExaminedeptideasBetween(String value1, String value2) {
            addCriterion("examineDeptideas between", value1, value2, "examinedeptideas");
            return (Criteria) this;
        }

        public Criteria andExaminedeptideasNotBetween(String value1, String value2) {
            addCriterion("examineDeptideas not between", value1, value2, "examinedeptideas");
            return (Criteria) this;
        }

        public Criteria andExaminedepttimeIsNull() {
            addCriterion("examineDeptTime is null");
            return (Criteria) this;
        }

        public Criteria andExaminedepttimeIsNotNull() {
            addCriterion("examineDeptTime is not null");
            return (Criteria) this;
        }

        public Criteria andExaminedepttimeEqualTo(Date value) {
            addCriterion("examineDeptTime =", value, "examinedepttime");
            return (Criteria) this;
        }

        public Criteria andExaminedepttimeNotEqualTo(Date value) {
            addCriterion("examineDeptTime <>", value, "examinedepttime");
            return (Criteria) this;
        }

        public Criteria andExaminedepttimeGreaterThan(Date value) {
            addCriterion("examineDeptTime >", value, "examinedepttime");
            return (Criteria) this;
        }

        public Criteria andExaminedepttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("examineDeptTime >=", value, "examinedepttime");
            return (Criteria) this;
        }

        public Criteria andExaminedepttimeLessThan(Date value) {
            addCriterion("examineDeptTime <", value, "examinedepttime");
            return (Criteria) this;
        }

        public Criteria andExaminedepttimeLessThanOrEqualTo(Date value) {
            addCriterion("examineDeptTime <=", value, "examinedepttime");
            return (Criteria) this;
        }

        public Criteria andExaminedepttimeIn(List<Date> values) {
            addCriterion("examineDeptTime in", values, "examinedepttime");
            return (Criteria) this;
        }

        public Criteria andExaminedepttimeNotIn(List<Date> values) {
            addCriterion("examineDeptTime not in", values, "examinedepttime");
            return (Criteria) this;
        }

        public Criteria andExaminedepttimeBetween(Date value1, Date value2) {
            addCriterion("examineDeptTime between", value1, value2, "examinedepttime");
            return (Criteria) this;
        }

        public Criteria andExaminedepttimeNotBetween(Date value1, Date value2) {
            addCriterion("examineDeptTime not between", value1, value2, "examinedepttime");
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