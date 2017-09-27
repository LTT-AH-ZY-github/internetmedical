package com.medical.po;

import java.util.ArrayList;
import java.util.List;

public class FamilyinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FamilyinfoExample() {
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

        public Criteria andFamilyidIsNull() {
            addCriterion("familyId is null");
            return (Criteria) this;
        }

        public Criteria andFamilyidIsNotNull() {
            addCriterion("familyId is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyidEqualTo(Integer value) {
            addCriterion("familyId =", value, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidNotEqualTo(Integer value) {
            addCriterion("familyId <>", value, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidGreaterThan(Integer value) {
            addCriterion("familyId >", value, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("familyId >=", value, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidLessThan(Integer value) {
            addCriterion("familyId <", value, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidLessThanOrEqualTo(Integer value) {
            addCriterion("familyId <=", value, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidIn(List<Integer> values) {
            addCriterion("familyId in", values, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidNotIn(List<Integer> values) {
            addCriterion("familyId not in", values, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidBetween(Integer value1, Integer value2) {
            addCriterion("familyId between", value1, value2, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidNotBetween(Integer value1, Integer value2) {
            addCriterion("familyId not between", value1, value2, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilynameIsNull() {
            addCriterion("familyName is null");
            return (Criteria) this;
        }

        public Criteria andFamilynameIsNotNull() {
            addCriterion("familyName is not null");
            return (Criteria) this;
        }

        public Criteria andFamilynameEqualTo(String value) {
            addCriterion("familyName =", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameNotEqualTo(String value) {
            addCriterion("familyName <>", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameGreaterThan(String value) {
            addCriterion("familyName >", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameGreaterThanOrEqualTo(String value) {
            addCriterion("familyName >=", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameLessThan(String value) {
            addCriterion("familyName <", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameLessThanOrEqualTo(String value) {
            addCriterion("familyName <=", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameLike(String value) {
            addCriterion("familyName like", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameNotLike(String value) {
            addCriterion("familyName not like", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameIn(List<String> values) {
            addCriterion("familyName in", values, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameNotIn(List<String> values) {
            addCriterion("familyName not in", values, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameBetween(String value1, String value2) {
            addCriterion("familyName between", value1, value2, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameNotBetween(String value1, String value2) {
            addCriterion("familyName not between", value1, value2, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilymaleIsNull() {
            addCriterion("familyMale is null");
            return (Criteria) this;
        }

        public Criteria andFamilymaleIsNotNull() {
            addCriterion("familyMale is not null");
            return (Criteria) this;
        }

        public Criteria andFamilymaleEqualTo(String value) {
            addCriterion("familyMale =", value, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleNotEqualTo(String value) {
            addCriterion("familyMale <>", value, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleGreaterThan(String value) {
            addCriterion("familyMale >", value, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleGreaterThanOrEqualTo(String value) {
            addCriterion("familyMale >=", value, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleLessThan(String value) {
            addCriterion("familyMale <", value, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleLessThanOrEqualTo(String value) {
            addCriterion("familyMale <=", value, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleLike(String value) {
            addCriterion("familyMale like", value, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleNotLike(String value) {
            addCriterion("familyMale not like", value, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleIn(List<String> values) {
            addCriterion("familyMale in", values, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleNotIn(List<String> values) {
            addCriterion("familyMale not in", values, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleBetween(String value1, String value2) {
            addCriterion("familyMale between", value1, value2, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleNotBetween(String value1, String value2) {
            addCriterion("familyMale not between", value1, value2, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilyageIsNull() {
            addCriterion("familyAge is null");
            return (Criteria) this;
        }

        public Criteria andFamilyageIsNotNull() {
            addCriterion("familyAge is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyageEqualTo(Integer value) {
            addCriterion("familyAge =", value, "familyage");
            return (Criteria) this;
        }

        public Criteria andFamilyageNotEqualTo(Integer value) {
            addCriterion("familyAge <>", value, "familyage");
            return (Criteria) this;
        }

        public Criteria andFamilyageGreaterThan(Integer value) {
            addCriterion("familyAge >", value, "familyage");
            return (Criteria) this;
        }

        public Criteria andFamilyageGreaterThanOrEqualTo(Integer value) {
            addCriterion("familyAge >=", value, "familyage");
            return (Criteria) this;
        }

        public Criteria andFamilyageLessThan(Integer value) {
            addCriterion("familyAge <", value, "familyage");
            return (Criteria) this;
        }

        public Criteria andFamilyageLessThanOrEqualTo(Integer value) {
            addCriterion("familyAge <=", value, "familyage");
            return (Criteria) this;
        }

        public Criteria andFamilyageIn(List<Integer> values) {
            addCriterion("familyAge in", values, "familyage");
            return (Criteria) this;
        }

        public Criteria andFamilyageNotIn(List<Integer> values) {
            addCriterion("familyAge not in", values, "familyage");
            return (Criteria) this;
        }

        public Criteria andFamilyageBetween(Integer value1, Integer value2) {
            addCriterion("familyAge between", value1, value2, "familyage");
            return (Criteria) this;
        }

        public Criteria andFamilyageNotBetween(Integer value1, Integer value2) {
            addCriterion("familyAge not between", value1, value2, "familyage");
            return (Criteria) this;
        }

        public Criteria andUserloginidIsNull() {
            addCriterion("userLoginId is null");
            return (Criteria) this;
        }

        public Criteria andUserloginidIsNotNull() {
            addCriterion("userLoginId is not null");
            return (Criteria) this;
        }

        public Criteria andUserloginidEqualTo(Integer value) {
            addCriterion("userLoginId =", value, "userloginid");
            return (Criteria) this;
        }

        public Criteria andUserloginidNotEqualTo(Integer value) {
            addCriterion("userLoginId <>", value, "userloginid");
            return (Criteria) this;
        }

        public Criteria andUserloginidGreaterThan(Integer value) {
            addCriterion("userLoginId >", value, "userloginid");
            return (Criteria) this;
        }

        public Criteria andUserloginidGreaterThanOrEqualTo(Integer value) {
            addCriterion("userLoginId >=", value, "userloginid");
            return (Criteria) this;
        }

        public Criteria andUserloginidLessThan(Integer value) {
            addCriterion("userLoginId <", value, "userloginid");
            return (Criteria) this;
        }

        public Criteria andUserloginidLessThanOrEqualTo(Integer value) {
            addCriterion("userLoginId <=", value, "userloginid");
            return (Criteria) this;
        }

        public Criteria andUserloginidIn(List<Integer> values) {
            addCriterion("userLoginId in", values, "userloginid");
            return (Criteria) this;
        }

        public Criteria andUserloginidNotIn(List<Integer> values) {
            addCriterion("userLoginId not in", values, "userloginid");
            return (Criteria) this;
        }

        public Criteria andUserloginidBetween(Integer value1, Integer value2) {
            addCriterion("userLoginId between", value1, value2, "userloginid");
            return (Criteria) this;
        }

        public Criteria andUserloginidNotBetween(Integer value1, Integer value2) {
            addCriterion("userLoginId not between", value1, value2, "userloginid");
            return (Criteria) this;
        }

        public Criteria andFamilytypeIsNull() {
            addCriterion("familyType is null");
            return (Criteria) this;
        }

        public Criteria andFamilytypeIsNotNull() {
            addCriterion("familyType is not null");
            return (Criteria) this;
        }

        public Criteria andFamilytypeEqualTo(Boolean value) {
            addCriterion("familyType =", value, "familytype");
            return (Criteria) this;
        }

        public Criteria andFamilytypeNotEqualTo(Boolean value) {
            addCriterion("familyType <>", value, "familytype");
            return (Criteria) this;
        }

        public Criteria andFamilytypeGreaterThan(Boolean value) {
            addCriterion("familyType >", value, "familytype");
            return (Criteria) this;
        }

        public Criteria andFamilytypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("familyType >=", value, "familytype");
            return (Criteria) this;
        }

        public Criteria andFamilytypeLessThan(Boolean value) {
            addCriterion("familyType <", value, "familytype");
            return (Criteria) this;
        }

        public Criteria andFamilytypeLessThanOrEqualTo(Boolean value) {
            addCriterion("familyType <=", value, "familytype");
            return (Criteria) this;
        }

        public Criteria andFamilytypeIn(List<Boolean> values) {
            addCriterion("familyType in", values, "familytype");
            return (Criteria) this;
        }

        public Criteria andFamilytypeNotIn(List<Boolean> values) {
            addCriterion("familyType not in", values, "familytype");
            return (Criteria) this;
        }

        public Criteria andFamilytypeBetween(Boolean value1, Boolean value2) {
            addCriterion("familyType between", value1, value2, "familytype");
            return (Criteria) this;
        }

        public Criteria andFamilytypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("familyType not between", value1, value2, "familytype");
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