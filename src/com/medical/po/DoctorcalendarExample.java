package com.medical.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DoctorcalendarExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DoctorcalendarExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andDoccalendaridIsNull() {
            addCriterion("docCalendarId is null");
            return (Criteria) this;
        }

        public Criteria andDoccalendaridIsNotNull() {
            addCriterion("docCalendarId is not null");
            return (Criteria) this;
        }

        public Criteria andDoccalendaridEqualTo(Integer value) {
            addCriterion("docCalendarId =", value, "doccalendarid");
            return (Criteria) this;
        }

        public Criteria andDoccalendaridNotEqualTo(Integer value) {
            addCriterion("docCalendarId <>", value, "doccalendarid");
            return (Criteria) this;
        }

        public Criteria andDoccalendaridGreaterThan(Integer value) {
            addCriterion("docCalendarId >", value, "doccalendarid");
            return (Criteria) this;
        }

        public Criteria andDoccalendaridGreaterThanOrEqualTo(Integer value) {
            addCriterion("docCalendarId >=", value, "doccalendarid");
            return (Criteria) this;
        }

        public Criteria andDoccalendaridLessThan(Integer value) {
            addCriterion("docCalendarId <", value, "doccalendarid");
            return (Criteria) this;
        }

        public Criteria andDoccalendaridLessThanOrEqualTo(Integer value) {
            addCriterion("docCalendarId <=", value, "doccalendarid");
            return (Criteria) this;
        }

        public Criteria andDoccalendaridIn(List<Integer> values) {
            addCriterion("docCalendarId in", values, "doccalendarid");
            return (Criteria) this;
        }

        public Criteria andDoccalendaridNotIn(List<Integer> values) {
            addCriterion("docCalendarId not in", values, "doccalendarid");
            return (Criteria) this;
        }

        public Criteria andDoccalendaridBetween(Integer value1, Integer value2) {
            addCriterion("docCalendarId between", value1, value2, "doccalendarid");
            return (Criteria) this;
        }

        public Criteria andDoccalendaridNotBetween(Integer value1, Integer value2) {
            addCriterion("docCalendarId not between", value1, value2, "doccalendarid");
            return (Criteria) this;
        }

        public Criteria andDoccalendardayIsNull() {
            addCriterion("docCalendarDay is null");
            return (Criteria) this;
        }

        public Criteria andDoccalendardayIsNotNull() {
            addCriterion("docCalendarDay is not null");
            return (Criteria) this;
        }

        public Criteria andDoccalendardayEqualTo(Date value) {
            addCriterionForJDBCDate("docCalendarDay =", value, "doccalendarday");
            return (Criteria) this;
        }

        public Criteria andDoccalendardayNotEqualTo(Date value) {
            addCriterionForJDBCDate("docCalendarDay <>", value, "doccalendarday");
            return (Criteria) this;
        }

        public Criteria andDoccalendardayGreaterThan(Date value) {
            addCriterionForJDBCDate("docCalendarDay >", value, "doccalendarday");
            return (Criteria) this;
        }

        public Criteria andDoccalendardayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("docCalendarDay >=", value, "doccalendarday");
            return (Criteria) this;
        }

        public Criteria andDoccalendardayLessThan(Date value) {
            addCriterionForJDBCDate("docCalendarDay <", value, "doccalendarday");
            return (Criteria) this;
        }

        public Criteria andDoccalendardayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("docCalendarDay <=", value, "doccalendarday");
            return (Criteria) this;
        }

        public Criteria andDoccalendardayIn(List<Date> values) {
            addCriterionForJDBCDate("docCalendarDay in", values, "doccalendarday");
            return (Criteria) this;
        }

        public Criteria andDoccalendardayNotIn(List<Date> values) {
            addCriterionForJDBCDate("docCalendarDay not in", values, "doccalendarday");
            return (Criteria) this;
        }

        public Criteria andDoccalendardayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("docCalendarDay between", value1, value2, "doccalendarday");
            return (Criteria) this;
        }

        public Criteria andDoccalendardayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("docCalendarDay not between", value1, value2, "doccalendarday");
            return (Criteria) this;
        }

        public Criteria andDoccalendartimeIsNull() {
            addCriterion("docCalendarTime is null");
            return (Criteria) this;
        }

        public Criteria andDoccalendartimeIsNotNull() {
            addCriterion("docCalendarTime is not null");
            return (Criteria) this;
        }

        public Criteria andDoccalendartimeEqualTo(String value) {
            addCriterion("docCalendarTime =", value, "doccalendartime");
            return (Criteria) this;
        }

        public Criteria andDoccalendartimeNotEqualTo(String value) {
            addCriterion("docCalendarTime <>", value, "doccalendartime");
            return (Criteria) this;
        }

        public Criteria andDoccalendartimeGreaterThan(String value) {
            addCriterion("docCalendarTime >", value, "doccalendartime");
            return (Criteria) this;
        }

        public Criteria andDoccalendartimeGreaterThanOrEqualTo(String value) {
            addCriterion("docCalendarTime >=", value, "doccalendartime");
            return (Criteria) this;
        }

        public Criteria andDoccalendartimeLessThan(String value) {
            addCriterion("docCalendarTime <", value, "doccalendartime");
            return (Criteria) this;
        }

        public Criteria andDoccalendartimeLessThanOrEqualTo(String value) {
            addCriterion("docCalendarTime <=", value, "doccalendartime");
            return (Criteria) this;
        }

        public Criteria andDoccalendartimeLike(String value) {
            addCriterion("docCalendarTime like", value, "doccalendartime");
            return (Criteria) this;
        }

        public Criteria andDoccalendartimeNotLike(String value) {
            addCriterion("docCalendarTime not like", value, "doccalendartime");
            return (Criteria) this;
        }

        public Criteria andDoccalendartimeIn(List<String> values) {
            addCriterion("docCalendarTime in", values, "doccalendartime");
            return (Criteria) this;
        }

        public Criteria andDoccalendartimeNotIn(List<String> values) {
            addCriterion("docCalendarTime not in", values, "doccalendartime");
            return (Criteria) this;
        }

        public Criteria andDoccalendartimeBetween(String value1, String value2) {
            addCriterion("docCalendarTime between", value1, value2, "doccalendartime");
            return (Criteria) this;
        }

        public Criteria andDoccalendartimeNotBetween(String value1, String value2) {
            addCriterion("docCalendarTime not between", value1, value2, "doccalendartime");
            return (Criteria) this;
        }

        public Criteria andDoccalendaraffairIsNull() {
            addCriterion("docCalendarAffair is null");
            return (Criteria) this;
        }

        public Criteria andDoccalendaraffairIsNotNull() {
            addCriterion("docCalendarAffair is not null");
            return (Criteria) this;
        }

        public Criteria andDoccalendaraffairEqualTo(String value) {
            addCriterion("docCalendarAffair =", value, "doccalendaraffair");
            return (Criteria) this;
        }

        public Criteria andDoccalendaraffairNotEqualTo(String value) {
            addCriterion("docCalendarAffair <>", value, "doccalendaraffair");
            return (Criteria) this;
        }

        public Criteria andDoccalendaraffairGreaterThan(String value) {
            addCriterion("docCalendarAffair >", value, "doccalendaraffair");
            return (Criteria) this;
        }

        public Criteria andDoccalendaraffairGreaterThanOrEqualTo(String value) {
            addCriterion("docCalendarAffair >=", value, "doccalendaraffair");
            return (Criteria) this;
        }

        public Criteria andDoccalendaraffairLessThan(String value) {
            addCriterion("docCalendarAffair <", value, "doccalendaraffair");
            return (Criteria) this;
        }

        public Criteria andDoccalendaraffairLessThanOrEqualTo(String value) {
            addCriterion("docCalendarAffair <=", value, "doccalendaraffair");
            return (Criteria) this;
        }

        public Criteria andDoccalendaraffairLike(String value) {
            addCriterion("docCalendarAffair like", value, "doccalendaraffair");
            return (Criteria) this;
        }

        public Criteria andDoccalendaraffairNotLike(String value) {
            addCriterion("docCalendarAffair not like", value, "doccalendaraffair");
            return (Criteria) this;
        }

        public Criteria andDoccalendaraffairIn(List<String> values) {
            addCriterion("docCalendarAffair in", values, "doccalendaraffair");
            return (Criteria) this;
        }

        public Criteria andDoccalendaraffairNotIn(List<String> values) {
            addCriterion("docCalendarAffair not in", values, "doccalendaraffair");
            return (Criteria) this;
        }

        public Criteria andDoccalendaraffairBetween(String value1, String value2) {
            addCriterion("docCalendarAffair between", value1, value2, "doccalendaraffair");
            return (Criteria) this;
        }

        public Criteria andDoccalendaraffairNotBetween(String value1, String value2) {
            addCriterion("docCalendarAffair not between", value1, value2, "doccalendaraffair");
            return (Criteria) this;
        }

        public Criteria andDoccalendaradressidIsNull() {
            addCriterion("docCalendarAdressId is null");
            return (Criteria) this;
        }

        public Criteria andDoccalendaradressidIsNotNull() {
            addCriterion("docCalendarAdressId is not null");
            return (Criteria) this;
        }

        public Criteria andDoccalendaradressidEqualTo(Integer value) {
            addCriterion("docCalendarAdressId =", value, "doccalendaradressid");
            return (Criteria) this;
        }

        public Criteria andDoccalendaradressidNotEqualTo(Integer value) {
            addCriterion("docCalendarAdressId <>", value, "doccalendaradressid");
            return (Criteria) this;
        }

        public Criteria andDoccalendaradressidGreaterThan(Integer value) {
            addCriterion("docCalendarAdressId >", value, "doccalendaradressid");
            return (Criteria) this;
        }

        public Criteria andDoccalendaradressidGreaterThanOrEqualTo(Integer value) {
            addCriterion("docCalendarAdressId >=", value, "doccalendaradressid");
            return (Criteria) this;
        }

        public Criteria andDoccalendaradressidLessThan(Integer value) {
            addCriterion("docCalendarAdressId <", value, "doccalendaradressid");
            return (Criteria) this;
        }

        public Criteria andDoccalendaradressidLessThanOrEqualTo(Integer value) {
            addCriterion("docCalendarAdressId <=", value, "doccalendaradressid");
            return (Criteria) this;
        }

        public Criteria andDoccalendaradressidIn(List<Integer> values) {
            addCriterion("docCalendarAdressId in", values, "doccalendaradressid");
            return (Criteria) this;
        }

        public Criteria andDoccalendaradressidNotIn(List<Integer> values) {
            addCriterion("docCalendarAdressId not in", values, "doccalendaradressid");
            return (Criteria) this;
        }

        public Criteria andDoccalendaradressidBetween(Integer value1, Integer value2) {
            addCriterion("docCalendarAdressId between", value1, value2, "doccalendaradressid");
            return (Criteria) this;
        }

        public Criteria andDoccalendaradressidNotBetween(Integer value1, Integer value2) {
            addCriterion("docCalendarAdressId not between", value1, value2, "doccalendaradressid");
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