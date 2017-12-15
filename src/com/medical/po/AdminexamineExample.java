package com.medical.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminexamineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminexamineExample() {
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

        public Criteria andExaminetypeIsNull() {
            addCriterion("examineType is null");
            return (Criteria) this;
        }

        public Criteria andExaminetypeIsNotNull() {
            addCriterion("examineType is not null");
            return (Criteria) this;
        }

        public Criteria andExaminetypeEqualTo(Integer value) {
            addCriterion("examineType =", value, "examinetype");
            return (Criteria) this;
        }

        public Criteria andExaminetypeNotEqualTo(Integer value) {
            addCriterion("examineType <>", value, "examinetype");
            return (Criteria) this;
        }

        public Criteria andExaminetypeGreaterThan(Integer value) {
            addCriterion("examineType >", value, "examinetype");
            return (Criteria) this;
        }

        public Criteria andExaminetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("examineType >=", value, "examinetype");
            return (Criteria) this;
        }

        public Criteria andExaminetypeLessThan(Integer value) {
            addCriterion("examineType <", value, "examinetype");
            return (Criteria) this;
        }

        public Criteria andExaminetypeLessThanOrEqualTo(Integer value) {
            addCriterion("examineType <=", value, "examinetype");
            return (Criteria) this;
        }

        public Criteria andExaminetypeIn(List<Integer> values) {
            addCriterion("examineType in", values, "examinetype");
            return (Criteria) this;
        }

        public Criteria andExaminetypeNotIn(List<Integer> values) {
            addCriterion("examineType not in", values, "examinetype");
            return (Criteria) this;
        }

        public Criteria andExaminetypeBetween(Integer value1, Integer value2) {
            addCriterion("examineType between", value1, value2, "examinetype");
            return (Criteria) this;
        }

        public Criteria andExaminetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("examineType not between", value1, value2, "examinetype");
            return (Criteria) this;
        }

        public Criteria andExaminetargetidIsNull() {
            addCriterion("examineTargetId is null");
            return (Criteria) this;
        }

        public Criteria andExaminetargetidIsNotNull() {
            addCriterion("examineTargetId is not null");
            return (Criteria) this;
        }

        public Criteria andExaminetargetidEqualTo(Integer value) {
            addCriterion("examineTargetId =", value, "examinetargetid");
            return (Criteria) this;
        }

        public Criteria andExaminetargetidNotEqualTo(Integer value) {
            addCriterion("examineTargetId <>", value, "examinetargetid");
            return (Criteria) this;
        }

        public Criteria andExaminetargetidGreaterThan(Integer value) {
            addCriterion("examineTargetId >", value, "examinetargetid");
            return (Criteria) this;
        }

        public Criteria andExaminetargetidGreaterThanOrEqualTo(Integer value) {
            addCriterion("examineTargetId >=", value, "examinetargetid");
            return (Criteria) this;
        }

        public Criteria andExaminetargetidLessThan(Integer value) {
            addCriterion("examineTargetId <", value, "examinetargetid");
            return (Criteria) this;
        }

        public Criteria andExaminetargetidLessThanOrEqualTo(Integer value) {
            addCriterion("examineTargetId <=", value, "examinetargetid");
            return (Criteria) this;
        }

        public Criteria andExaminetargetidIn(List<Integer> values) {
            addCriterion("examineTargetId in", values, "examinetargetid");
            return (Criteria) this;
        }

        public Criteria andExaminetargetidNotIn(List<Integer> values) {
            addCriterion("examineTargetId not in", values, "examinetargetid");
            return (Criteria) this;
        }

        public Criteria andExaminetargetidBetween(Integer value1, Integer value2) {
            addCriterion("examineTargetId between", value1, value2, "examinetargetid");
            return (Criteria) this;
        }

        public Criteria andExaminetargetidNotBetween(Integer value1, Integer value2) {
            addCriterion("examineTargetId not between", value1, value2, "examinetargetid");
            return (Criteria) this;
        }

        public Criteria andExamineresultIsNull() {
            addCriterion("examineResult is null");
            return (Criteria) this;
        }

        public Criteria andExamineresultIsNotNull() {
            addCriterion("examineResult is not null");
            return (Criteria) this;
        }

        public Criteria andExamineresultEqualTo(Boolean value) {
            addCriterion("examineResult =", value, "examineresult");
            return (Criteria) this;
        }

        public Criteria andExamineresultNotEqualTo(Boolean value) {
            addCriterion("examineResult <>", value, "examineresult");
            return (Criteria) this;
        }

        public Criteria andExamineresultGreaterThan(Boolean value) {
            addCriterion("examineResult >", value, "examineresult");
            return (Criteria) this;
        }

        public Criteria andExamineresultGreaterThanOrEqualTo(Boolean value) {
            addCriterion("examineResult >=", value, "examineresult");
            return (Criteria) this;
        }

        public Criteria andExamineresultLessThan(Boolean value) {
            addCriterion("examineResult <", value, "examineresult");
            return (Criteria) this;
        }

        public Criteria andExamineresultLessThanOrEqualTo(Boolean value) {
            addCriterion("examineResult <=", value, "examineresult");
            return (Criteria) this;
        }

        public Criteria andExamineresultIn(List<Boolean> values) {
            addCriterion("examineResult in", values, "examineresult");
            return (Criteria) this;
        }

        public Criteria andExamineresultNotIn(List<Boolean> values) {
            addCriterion("examineResult not in", values, "examineresult");
            return (Criteria) this;
        }

        public Criteria andExamineresultBetween(Boolean value1, Boolean value2) {
            addCriterion("examineResult between", value1, value2, "examineresult");
            return (Criteria) this;
        }

        public Criteria andExamineresultNotBetween(Boolean value1, Boolean value2) {
            addCriterion("examineResult not between", value1, value2, "examineresult");
            return (Criteria) this;
        }

        public Criteria andExamineideasIsNull() {
            addCriterion("examineIdeas is null");
            return (Criteria) this;
        }

        public Criteria andExamineideasIsNotNull() {
            addCriterion("examineIdeas is not null");
            return (Criteria) this;
        }

        public Criteria andExamineideasEqualTo(String value) {
            addCriterion("examineIdeas =", value, "examineideas");
            return (Criteria) this;
        }

        public Criteria andExamineideasNotEqualTo(String value) {
            addCriterion("examineIdeas <>", value, "examineideas");
            return (Criteria) this;
        }

        public Criteria andExamineideasGreaterThan(String value) {
            addCriterion("examineIdeas >", value, "examineideas");
            return (Criteria) this;
        }

        public Criteria andExamineideasGreaterThanOrEqualTo(String value) {
            addCriterion("examineIdeas >=", value, "examineideas");
            return (Criteria) this;
        }

        public Criteria andExamineideasLessThan(String value) {
            addCriterion("examineIdeas <", value, "examineideas");
            return (Criteria) this;
        }

        public Criteria andExamineideasLessThanOrEqualTo(String value) {
            addCriterion("examineIdeas <=", value, "examineideas");
            return (Criteria) this;
        }

        public Criteria andExamineideasLike(String value) {
            addCriterion("examineIdeas like", value, "examineideas");
            return (Criteria) this;
        }

        public Criteria andExamineideasNotLike(String value) {
            addCriterion("examineIdeas not like", value, "examineideas");
            return (Criteria) this;
        }

        public Criteria andExamineideasIn(List<String> values) {
            addCriterion("examineIdeas in", values, "examineideas");
            return (Criteria) this;
        }

        public Criteria andExamineideasNotIn(List<String> values) {
            addCriterion("examineIdeas not in", values, "examineideas");
            return (Criteria) this;
        }

        public Criteria andExamineideasBetween(String value1, String value2) {
            addCriterion("examineIdeas between", value1, value2, "examineideas");
            return (Criteria) this;
        }

        public Criteria andExamineideasNotBetween(String value1, String value2) {
            addCriterion("examineIdeas not between", value1, value2, "examineideas");
            return (Criteria) this;
        }

        public Criteria andExaminetimeIsNull() {
            addCriterion("examineTime is null");
            return (Criteria) this;
        }

        public Criteria andExaminetimeIsNotNull() {
            addCriterion("examineTime is not null");
            return (Criteria) this;
        }

        public Criteria andExaminetimeEqualTo(Date value) {
            addCriterion("examineTime =", value, "examinetime");
            return (Criteria) this;
        }

        public Criteria andExaminetimeNotEqualTo(Date value) {
            addCriterion("examineTime <>", value, "examinetime");
            return (Criteria) this;
        }

        public Criteria andExaminetimeGreaterThan(Date value) {
            addCriterion("examineTime >", value, "examinetime");
            return (Criteria) this;
        }

        public Criteria andExaminetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("examineTime >=", value, "examinetime");
            return (Criteria) this;
        }

        public Criteria andExaminetimeLessThan(Date value) {
            addCriterion("examineTime <", value, "examinetime");
            return (Criteria) this;
        }

        public Criteria andExaminetimeLessThanOrEqualTo(Date value) {
            addCriterion("examineTime <=", value, "examinetime");
            return (Criteria) this;
        }

        public Criteria andExaminetimeIn(List<Date> values) {
            addCriterion("examineTime in", values, "examinetime");
            return (Criteria) this;
        }

        public Criteria andExaminetimeNotIn(List<Date> values) {
            addCriterion("examineTime not in", values, "examinetime");
            return (Criteria) this;
        }

        public Criteria andExaminetimeBetween(Date value1, Date value2) {
            addCriterion("examineTime between", value1, value2, "examinetime");
            return (Criteria) this;
        }

        public Criteria andExaminetimeNotBetween(Date value1, Date value2) {
            addCriterion("examineTime not between", value1, value2, "examinetime");
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