package com.medical.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppversionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppversionExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAppversionIsNull() {
            addCriterion("appVersion is null");
            return (Criteria) this;
        }

        public Criteria andAppversionIsNotNull() {
            addCriterion("appVersion is not null");
            return (Criteria) this;
        }

        public Criteria andAppversionEqualTo(String value) {
            addCriterion("appVersion =", value, "appversion");
            return (Criteria) this;
        }

        public Criteria andAppversionNotEqualTo(String value) {
            addCriterion("appVersion <>", value, "appversion");
            return (Criteria) this;
        }

        public Criteria andAppversionGreaterThan(String value) {
            addCriterion("appVersion >", value, "appversion");
            return (Criteria) this;
        }

        public Criteria andAppversionGreaterThanOrEqualTo(String value) {
            addCriterion("appVersion >=", value, "appversion");
            return (Criteria) this;
        }

        public Criteria andAppversionLessThan(String value) {
            addCriterion("appVersion <", value, "appversion");
            return (Criteria) this;
        }

        public Criteria andAppversionLessThanOrEqualTo(String value) {
            addCriterion("appVersion <=", value, "appversion");
            return (Criteria) this;
        }

        public Criteria andAppversionLike(String value) {
            addCriterion("appVersion like", value, "appversion");
            return (Criteria) this;
        }

        public Criteria andAppversionNotLike(String value) {
            addCriterion("appVersion not like", value, "appversion");
            return (Criteria) this;
        }

        public Criteria andAppversionIn(List<String> values) {
            addCriterion("appVersion in", values, "appversion");
            return (Criteria) this;
        }

        public Criteria andAppversionNotIn(List<String> values) {
            addCriterion("appVersion not in", values, "appversion");
            return (Criteria) this;
        }

        public Criteria andAppversionBetween(String value1, String value2) {
            addCriterion("appVersion between", value1, value2, "appversion");
            return (Criteria) this;
        }

        public Criteria andAppversionNotBetween(String value1, String value2) {
            addCriterion("appVersion not between", value1, value2, "appversion");
            return (Criteria) this;
        }

        public Criteria andApppublishtimeIsNull() {
            addCriterion("appPublishTime is null");
            return (Criteria) this;
        }

        public Criteria andApppublishtimeIsNotNull() {
            addCriterion("appPublishTime is not null");
            return (Criteria) this;
        }

        public Criteria andApppublishtimeEqualTo(Date value) {
            addCriterion("appPublishTime =", value, "apppublishtime");
            return (Criteria) this;
        }

        public Criteria andApppublishtimeNotEqualTo(Date value) {
            addCriterion("appPublishTime <>", value, "apppublishtime");
            return (Criteria) this;
        }

        public Criteria andApppublishtimeGreaterThan(Date value) {
            addCriterion("appPublishTime >", value, "apppublishtime");
            return (Criteria) this;
        }

        public Criteria andApppublishtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("appPublishTime >=", value, "apppublishtime");
            return (Criteria) this;
        }

        public Criteria andApppublishtimeLessThan(Date value) {
            addCriterion("appPublishTime <", value, "apppublishtime");
            return (Criteria) this;
        }

        public Criteria andApppublishtimeLessThanOrEqualTo(Date value) {
            addCriterion("appPublishTime <=", value, "apppublishtime");
            return (Criteria) this;
        }

        public Criteria andApppublishtimeIn(List<Date> values) {
            addCriterion("appPublishTime in", values, "apppublishtime");
            return (Criteria) this;
        }

        public Criteria andApppublishtimeNotIn(List<Date> values) {
            addCriterion("appPublishTime not in", values, "apppublishtime");
            return (Criteria) this;
        }

        public Criteria andApppublishtimeBetween(Date value1, Date value2) {
            addCriterion("appPublishTime between", value1, value2, "apppublishtime");
            return (Criteria) this;
        }

        public Criteria andApppublishtimeNotBetween(Date value1, Date value2) {
            addCriterion("appPublishTime not between", value1, value2, "apppublishtime");
            return (Criteria) this;
        }

        public Criteria andApptypeIsNull() {
            addCriterion("appType is null");
            return (Criteria) this;
        }

        public Criteria andApptypeIsNotNull() {
            addCriterion("appType is not null");
            return (Criteria) this;
        }

        public Criteria andApptypeEqualTo(Integer value) {
            addCriterion("appType =", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeNotEqualTo(Integer value) {
            addCriterion("appType <>", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeGreaterThan(Integer value) {
            addCriterion("appType >", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("appType >=", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeLessThan(Integer value) {
            addCriterion("appType <", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeLessThanOrEqualTo(Integer value) {
            addCriterion("appType <=", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeIn(List<Integer> values) {
            addCriterion("appType in", values, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeNotIn(List<Integer> values) {
            addCriterion("appType not in", values, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeBetween(Integer value1, Integer value2) {
            addCriterion("appType between", value1, value2, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeNotBetween(Integer value1, Integer value2) {
            addCriterion("appType not between", value1, value2, "apptype");
            return (Criteria) this;
        }

        public Criteria andAppurlIsNull() {
            addCriterion("appUrl is null");
            return (Criteria) this;
        }

        public Criteria andAppurlIsNotNull() {
            addCriterion("appUrl is not null");
            return (Criteria) this;
        }

        public Criteria andAppurlEqualTo(String value) {
            addCriterion("appUrl =", value, "appurl");
            return (Criteria) this;
        }

        public Criteria andAppurlNotEqualTo(String value) {
            addCriterion("appUrl <>", value, "appurl");
            return (Criteria) this;
        }

        public Criteria andAppurlGreaterThan(String value) {
            addCriterion("appUrl >", value, "appurl");
            return (Criteria) this;
        }

        public Criteria andAppurlGreaterThanOrEqualTo(String value) {
            addCriterion("appUrl >=", value, "appurl");
            return (Criteria) this;
        }

        public Criteria andAppurlLessThan(String value) {
            addCriterion("appUrl <", value, "appurl");
            return (Criteria) this;
        }

        public Criteria andAppurlLessThanOrEqualTo(String value) {
            addCriterion("appUrl <=", value, "appurl");
            return (Criteria) this;
        }

        public Criteria andAppurlLike(String value) {
            addCriterion("appUrl like", value, "appurl");
            return (Criteria) this;
        }

        public Criteria andAppurlNotLike(String value) {
            addCriterion("appUrl not like", value, "appurl");
            return (Criteria) this;
        }

        public Criteria andAppurlIn(List<String> values) {
            addCriterion("appUrl in", values, "appurl");
            return (Criteria) this;
        }

        public Criteria andAppurlNotIn(List<String> values) {
            addCriterion("appUrl not in", values, "appurl");
            return (Criteria) this;
        }

        public Criteria andAppurlBetween(String value1, String value2) {
            addCriterion("appUrl between", value1, value2, "appurl");
            return (Criteria) this;
        }

        public Criteria andAppurlNotBetween(String value1, String value2) {
            addCriterion("appUrl not between", value1, value2, "appurl");
            return (Criteria) this;
        }

        public Criteria andSystemtypeIsNull() {
            addCriterion("systemType is null");
            return (Criteria) this;
        }

        public Criteria andSystemtypeIsNotNull() {
            addCriterion("systemType is not null");
            return (Criteria) this;
        }

        public Criteria andSystemtypeEqualTo(Integer value) {
            addCriterion("systemType =", value, "systemtype");
            return (Criteria) this;
        }

        public Criteria andSystemtypeNotEqualTo(Integer value) {
            addCriterion("systemType <>", value, "systemtype");
            return (Criteria) this;
        }

        public Criteria andSystemtypeGreaterThan(Integer value) {
            addCriterion("systemType >", value, "systemtype");
            return (Criteria) this;
        }

        public Criteria andSystemtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("systemType >=", value, "systemtype");
            return (Criteria) this;
        }

        public Criteria andSystemtypeLessThan(Integer value) {
            addCriterion("systemType <", value, "systemtype");
            return (Criteria) this;
        }

        public Criteria andSystemtypeLessThanOrEqualTo(Integer value) {
            addCriterion("systemType <=", value, "systemtype");
            return (Criteria) this;
        }

        public Criteria andSystemtypeIn(List<Integer> values) {
            addCriterion("systemType in", values, "systemtype");
            return (Criteria) this;
        }

        public Criteria andSystemtypeNotIn(List<Integer> values) {
            addCriterion("systemType not in", values, "systemtype");
            return (Criteria) this;
        }

        public Criteria andSystemtypeBetween(Integer value1, Integer value2) {
            addCriterion("systemType between", value1, value2, "systemtype");
            return (Criteria) this;
        }

        public Criteria andSystemtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("systemType not between", value1, value2, "systemtype");
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