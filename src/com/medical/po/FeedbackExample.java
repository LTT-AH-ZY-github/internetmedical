package com.medical.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FeedbackExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FeedbackExample() {
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

        public Criteria andFeedbackidIsNull() {
            addCriterion("feedBackId is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackidIsNotNull() {
            addCriterion("feedBackId is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackidEqualTo(Integer value) {
            addCriterion("feedBackId =", value, "feedbackid");
            return (Criteria) this;
        }

        public Criteria andFeedbackidNotEqualTo(Integer value) {
            addCriterion("feedBackId <>", value, "feedbackid");
            return (Criteria) this;
        }

        public Criteria andFeedbackidGreaterThan(Integer value) {
            addCriterion("feedBackId >", value, "feedbackid");
            return (Criteria) this;
        }

        public Criteria andFeedbackidGreaterThanOrEqualTo(Integer value) {
            addCriterion("feedBackId >=", value, "feedbackid");
            return (Criteria) this;
        }

        public Criteria andFeedbackidLessThan(Integer value) {
            addCriterion("feedBackId <", value, "feedbackid");
            return (Criteria) this;
        }

        public Criteria andFeedbackidLessThanOrEqualTo(Integer value) {
            addCriterion("feedBackId <=", value, "feedbackid");
            return (Criteria) this;
        }

        public Criteria andFeedbackidIn(List<Integer> values) {
            addCriterion("feedBackId in", values, "feedbackid");
            return (Criteria) this;
        }

        public Criteria andFeedbackidNotIn(List<Integer> values) {
            addCriterion("feedBackId not in", values, "feedbackid");
            return (Criteria) this;
        }

        public Criteria andFeedbackidBetween(Integer value1, Integer value2) {
            addCriterion("feedBackId between", value1, value2, "feedbackid");
            return (Criteria) this;
        }

        public Criteria andFeedbackidNotBetween(Integer value1, Integer value2) {
            addCriterion("feedBackId not between", value1, value2, "feedbackid");
            return (Criteria) this;
        }

        public Criteria andFeedbackideaIsNull() {
            addCriterion("feedBackIdea is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackideaIsNotNull() {
            addCriterion("feedBackIdea is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackideaEqualTo(String value) {
            addCriterion("feedBackIdea =", value, "feedbackidea");
            return (Criteria) this;
        }

        public Criteria andFeedbackideaNotEqualTo(String value) {
            addCriterion("feedBackIdea <>", value, "feedbackidea");
            return (Criteria) this;
        }

        public Criteria andFeedbackideaGreaterThan(String value) {
            addCriterion("feedBackIdea >", value, "feedbackidea");
            return (Criteria) this;
        }

        public Criteria andFeedbackideaGreaterThanOrEqualTo(String value) {
            addCriterion("feedBackIdea >=", value, "feedbackidea");
            return (Criteria) this;
        }

        public Criteria andFeedbackideaLessThan(String value) {
            addCriterion("feedBackIdea <", value, "feedbackidea");
            return (Criteria) this;
        }

        public Criteria andFeedbackideaLessThanOrEqualTo(String value) {
            addCriterion("feedBackIdea <=", value, "feedbackidea");
            return (Criteria) this;
        }

        public Criteria andFeedbackideaLike(String value) {
            addCriterion("feedBackIdea like", value, "feedbackidea");
            return (Criteria) this;
        }

        public Criteria andFeedbackideaNotLike(String value) {
            addCriterion("feedBackIdea not like", value, "feedbackidea");
            return (Criteria) this;
        }

        public Criteria andFeedbackideaIn(List<String> values) {
            addCriterion("feedBackIdea in", values, "feedbackidea");
            return (Criteria) this;
        }

        public Criteria andFeedbackideaNotIn(List<String> values) {
            addCriterion("feedBackIdea not in", values, "feedbackidea");
            return (Criteria) this;
        }

        public Criteria andFeedbackideaBetween(String value1, String value2) {
            addCriterion("feedBackIdea between", value1, value2, "feedbackidea");
            return (Criteria) this;
        }

        public Criteria andFeedbackideaNotBetween(String value1, String value2) {
            addCriterion("feedBackIdea not between", value1, value2, "feedbackidea");
            return (Criteria) this;
        }

        public Criteria andFeedbacktimeIsNull() {
            addCriterion("feedBackTime is null");
            return (Criteria) this;
        }

        public Criteria andFeedbacktimeIsNotNull() {
            addCriterion("feedBackTime is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbacktimeEqualTo(Date value) {
            addCriterion("feedBackTime =", value, "feedbacktime");
            return (Criteria) this;
        }

        public Criteria andFeedbacktimeNotEqualTo(Date value) {
            addCriterion("feedBackTime <>", value, "feedbacktime");
            return (Criteria) this;
        }

        public Criteria andFeedbacktimeGreaterThan(Date value) {
            addCriterion("feedBackTime >", value, "feedbacktime");
            return (Criteria) this;
        }

        public Criteria andFeedbacktimeGreaterThanOrEqualTo(Date value) {
            addCriterion("feedBackTime >=", value, "feedbacktime");
            return (Criteria) this;
        }

        public Criteria andFeedbacktimeLessThan(Date value) {
            addCriterion("feedBackTime <", value, "feedbacktime");
            return (Criteria) this;
        }

        public Criteria andFeedbacktimeLessThanOrEqualTo(Date value) {
            addCriterion("feedBackTime <=", value, "feedbacktime");
            return (Criteria) this;
        }

        public Criteria andFeedbacktimeIn(List<Date> values) {
            addCriterion("feedBackTime in", values, "feedbacktime");
            return (Criteria) this;
        }

        public Criteria andFeedbacktimeNotIn(List<Date> values) {
            addCriterion("feedBackTime not in", values, "feedbacktime");
            return (Criteria) this;
        }

        public Criteria andFeedbacktimeBetween(Date value1, Date value2) {
            addCriterion("feedBackTime between", value1, value2, "feedbacktime");
            return (Criteria) this;
        }

        public Criteria andFeedbacktimeNotBetween(Date value1, Date value2) {
            addCriterion("feedBackTime not between", value1, value2, "feedbacktime");
            return (Criteria) this;
        }

        public Criteria andFeedbackischeckIsNull() {
            addCriterion("feedBackIsCheck is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackischeckIsNotNull() {
            addCriterion("feedBackIsCheck is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackischeckEqualTo(Boolean value) {
            addCriterion("feedBackIsCheck =", value, "feedbackischeck");
            return (Criteria) this;
        }

        public Criteria andFeedbackischeckNotEqualTo(Boolean value) {
            addCriterion("feedBackIsCheck <>", value, "feedbackischeck");
            return (Criteria) this;
        }

        public Criteria andFeedbackischeckGreaterThan(Boolean value) {
            addCriterion("feedBackIsCheck >", value, "feedbackischeck");
            return (Criteria) this;
        }

        public Criteria andFeedbackischeckGreaterThanOrEqualTo(Boolean value) {
            addCriterion("feedBackIsCheck >=", value, "feedbackischeck");
            return (Criteria) this;
        }

        public Criteria andFeedbackischeckLessThan(Boolean value) {
            addCriterion("feedBackIsCheck <", value, "feedbackischeck");
            return (Criteria) this;
        }

        public Criteria andFeedbackischeckLessThanOrEqualTo(Boolean value) {
            addCriterion("feedBackIsCheck <=", value, "feedbackischeck");
            return (Criteria) this;
        }

        public Criteria andFeedbackischeckIn(List<Boolean> values) {
            addCriterion("feedBackIsCheck in", values, "feedbackischeck");
            return (Criteria) this;
        }

        public Criteria andFeedbackischeckNotIn(List<Boolean> values) {
            addCriterion("feedBackIsCheck not in", values, "feedbackischeck");
            return (Criteria) this;
        }

        public Criteria andFeedbackischeckBetween(Boolean value1, Boolean value2) {
            addCriterion("feedBackIsCheck between", value1, value2, "feedbackischeck");
            return (Criteria) this;
        }

        public Criteria andFeedbackischeckNotBetween(Boolean value1, Boolean value2) {
            addCriterion("feedBackIsCheck not between", value1, value2, "feedbackischeck");
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