package com.medical.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HospitalunitpriceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HospitalunitpriceExample() {
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

        public Criteria andUnitpriceidIsNull() {
            addCriterion("UnitPriceId is null");
            return (Criteria) this;
        }

        public Criteria andUnitpriceidIsNotNull() {
            addCriterion("UnitPriceId is not null");
            return (Criteria) this;
        }

        public Criteria andUnitpriceidEqualTo(Integer value) {
            addCriterion("UnitPriceId =", value, "unitpriceid");
            return (Criteria) this;
        }

        public Criteria andUnitpriceidNotEqualTo(Integer value) {
            addCriterion("UnitPriceId <>", value, "unitpriceid");
            return (Criteria) this;
        }

        public Criteria andUnitpriceidGreaterThan(Integer value) {
            addCriterion("UnitPriceId >", value, "unitpriceid");
            return (Criteria) this;
        }

        public Criteria andUnitpriceidGreaterThanOrEqualTo(Integer value) {
            addCriterion("UnitPriceId >=", value, "unitpriceid");
            return (Criteria) this;
        }

        public Criteria andUnitpriceidLessThan(Integer value) {
            addCriterion("UnitPriceId <", value, "unitpriceid");
            return (Criteria) this;
        }

        public Criteria andUnitpriceidLessThanOrEqualTo(Integer value) {
            addCriterion("UnitPriceId <=", value, "unitpriceid");
            return (Criteria) this;
        }

        public Criteria andUnitpriceidIn(List<Integer> values) {
            addCriterion("UnitPriceId in", values, "unitpriceid");
            return (Criteria) this;
        }

        public Criteria andUnitpriceidNotIn(List<Integer> values) {
            addCriterion("UnitPriceId not in", values, "unitpriceid");
            return (Criteria) this;
        }

        public Criteria andUnitpriceidBetween(Integer value1, Integer value2) {
            addCriterion("UnitPriceId between", value1, value2, "unitpriceid");
            return (Criteria) this;
        }

        public Criteria andUnitpriceidNotBetween(Integer value1, Integer value2) {
            addCriterion("UnitPriceId not between", value1, value2, "unitpriceid");
            return (Criteria) this;
        }

        public Criteria andHosploginidIsNull() {
            addCriterion("HospLoginId is null");
            return (Criteria) this;
        }

        public Criteria andHosploginidIsNotNull() {
            addCriterion("HospLoginId is not null");
            return (Criteria) this;
        }

        public Criteria andHosploginidEqualTo(Integer value) {
            addCriterion("HospLoginId =", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidNotEqualTo(Integer value) {
            addCriterion("HospLoginId <>", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidGreaterThan(Integer value) {
            addCriterion("HospLoginId >", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidGreaterThanOrEqualTo(Integer value) {
            addCriterion("HospLoginId >=", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidLessThan(Integer value) {
            addCriterion("HospLoginId <", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidLessThanOrEqualTo(Integer value) {
            addCriterion("HospLoginId <=", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidIn(List<Integer> values) {
            addCriterion("HospLoginId in", values, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidNotIn(List<Integer> values) {
            addCriterion("HospLoginId not in", values, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidBetween(Integer value1, Integer value2) {
            addCriterion("HospLoginId between", value1, value2, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidNotBetween(Integer value1, Integer value2) {
            addCriterion("HospLoginId not between", value1, value2, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andUnitpricenameIsNull() {
            addCriterion("UnitPriceName is null");
            return (Criteria) this;
        }

        public Criteria andUnitpricenameIsNotNull() {
            addCriterion("UnitPriceName is not null");
            return (Criteria) this;
        }

        public Criteria andUnitpricenameEqualTo(String value) {
            addCriterion("UnitPriceName =", value, "unitpricename");
            return (Criteria) this;
        }

        public Criteria andUnitpricenameNotEqualTo(String value) {
            addCriterion("UnitPriceName <>", value, "unitpricename");
            return (Criteria) this;
        }

        public Criteria andUnitpricenameGreaterThan(String value) {
            addCriterion("UnitPriceName >", value, "unitpricename");
            return (Criteria) this;
        }

        public Criteria andUnitpricenameGreaterThanOrEqualTo(String value) {
            addCriterion("UnitPriceName >=", value, "unitpricename");
            return (Criteria) this;
        }

        public Criteria andUnitpricenameLessThan(String value) {
            addCriterion("UnitPriceName <", value, "unitpricename");
            return (Criteria) this;
        }

        public Criteria andUnitpricenameLessThanOrEqualTo(String value) {
            addCriterion("UnitPriceName <=", value, "unitpricename");
            return (Criteria) this;
        }

        public Criteria andUnitpricenameLike(String value) {
            addCriterion("UnitPriceName like", value, "unitpricename");
            return (Criteria) this;
        }

        public Criteria andUnitpricenameNotLike(String value) {
            addCriterion("UnitPriceName not like", value, "unitpricename");
            return (Criteria) this;
        }

        public Criteria andUnitpricenameIn(List<String> values) {
            addCriterion("UnitPriceName in", values, "unitpricename");
            return (Criteria) this;
        }

        public Criteria andUnitpricenameNotIn(List<String> values) {
            addCriterion("UnitPriceName not in", values, "unitpricename");
            return (Criteria) this;
        }

        public Criteria andUnitpricenameBetween(String value1, String value2) {
            addCriterion("UnitPriceName between", value1, value2, "unitpricename");
            return (Criteria) this;
        }

        public Criteria andUnitpricenameNotBetween(String value1, String value2) {
            addCriterion("UnitPriceName not between", value1, value2, "unitpricename");
            return (Criteria) this;
        }

        public Criteria andUnitpricenumberIsNull() {
            addCriterion("UnitPriceNumber is null");
            return (Criteria) this;
        }

        public Criteria andUnitpricenumberIsNotNull() {
            addCriterion("UnitPriceNumber is not null");
            return (Criteria) this;
        }

        public Criteria andUnitpricenumberEqualTo(BigDecimal value) {
            addCriterion("UnitPriceNumber =", value, "unitpricenumber");
            return (Criteria) this;
        }

        public Criteria andUnitpricenumberNotEqualTo(BigDecimal value) {
            addCriterion("UnitPriceNumber <>", value, "unitpricenumber");
            return (Criteria) this;
        }

        public Criteria andUnitpricenumberGreaterThan(BigDecimal value) {
            addCriterion("UnitPriceNumber >", value, "unitpricenumber");
            return (Criteria) this;
        }

        public Criteria andUnitpricenumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("UnitPriceNumber >=", value, "unitpricenumber");
            return (Criteria) this;
        }

        public Criteria andUnitpricenumberLessThan(BigDecimal value) {
            addCriterion("UnitPriceNumber <", value, "unitpricenumber");
            return (Criteria) this;
        }

        public Criteria andUnitpricenumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("UnitPriceNumber <=", value, "unitpricenumber");
            return (Criteria) this;
        }

        public Criteria andUnitpricenumberIn(List<BigDecimal> values) {
            addCriterion("UnitPriceNumber in", values, "unitpricenumber");
            return (Criteria) this;
        }

        public Criteria andUnitpricenumberNotIn(List<BigDecimal> values) {
            addCriterion("UnitPriceNumber not in", values, "unitpricenumber");
            return (Criteria) this;
        }

        public Criteria andUnitpricenumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UnitPriceNumber between", value1, value2, "unitpricenumber");
            return (Criteria) this;
        }

        public Criteria andUnitpricenumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UnitPriceNumber not between", value1, value2, "unitpricenumber");
            return (Criteria) this;
        }

        public Criteria andUnitpriceabsIsNull() {
            addCriterion("UnitPriceAbs is null");
            return (Criteria) this;
        }

        public Criteria andUnitpriceabsIsNotNull() {
            addCriterion("UnitPriceAbs is not null");
            return (Criteria) this;
        }

        public Criteria andUnitpriceabsEqualTo(String value) {
            addCriterion("UnitPriceAbs =", value, "unitpriceabs");
            return (Criteria) this;
        }

        public Criteria andUnitpriceabsNotEqualTo(String value) {
            addCriterion("UnitPriceAbs <>", value, "unitpriceabs");
            return (Criteria) this;
        }

        public Criteria andUnitpriceabsGreaterThan(String value) {
            addCriterion("UnitPriceAbs >", value, "unitpriceabs");
            return (Criteria) this;
        }

        public Criteria andUnitpriceabsGreaterThanOrEqualTo(String value) {
            addCriterion("UnitPriceAbs >=", value, "unitpriceabs");
            return (Criteria) this;
        }

        public Criteria andUnitpriceabsLessThan(String value) {
            addCriterion("UnitPriceAbs <", value, "unitpriceabs");
            return (Criteria) this;
        }

        public Criteria andUnitpriceabsLessThanOrEqualTo(String value) {
            addCriterion("UnitPriceAbs <=", value, "unitpriceabs");
            return (Criteria) this;
        }

        public Criteria andUnitpriceabsLike(String value) {
            addCriterion("UnitPriceAbs like", value, "unitpriceabs");
            return (Criteria) this;
        }

        public Criteria andUnitpriceabsNotLike(String value) {
            addCriterion("UnitPriceAbs not like", value, "unitpriceabs");
            return (Criteria) this;
        }

        public Criteria andUnitpriceabsIn(List<String> values) {
            addCriterion("UnitPriceAbs in", values, "unitpriceabs");
            return (Criteria) this;
        }

        public Criteria andUnitpriceabsNotIn(List<String> values) {
            addCriterion("UnitPriceAbs not in", values, "unitpriceabs");
            return (Criteria) this;
        }

        public Criteria andUnitpriceabsBetween(String value1, String value2) {
            addCriterion("UnitPriceAbs between", value1, value2, "unitpriceabs");
            return (Criteria) this;
        }

        public Criteria andUnitpriceabsNotBetween(String value1, String value2) {
            addCriterion("UnitPriceAbs not between", value1, value2, "unitpriceabs");
            return (Criteria) this;
        }

        public Criteria andUnitpricetimeIsNull() {
            addCriterion("UnitPriceTime is null");
            return (Criteria) this;
        }

        public Criteria andUnitpricetimeIsNotNull() {
            addCriterion("UnitPriceTime is not null");
            return (Criteria) this;
        }

        public Criteria andUnitpricetimeEqualTo(Date value) {
            addCriterion("UnitPriceTime =", value, "unitpricetime");
            return (Criteria) this;
        }

        public Criteria andUnitpricetimeNotEqualTo(Date value) {
            addCriterion("UnitPriceTime <>", value, "unitpricetime");
            return (Criteria) this;
        }

        public Criteria andUnitpricetimeGreaterThan(Date value) {
            addCriterion("UnitPriceTime >", value, "unitpricetime");
            return (Criteria) this;
        }

        public Criteria andUnitpricetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UnitPriceTime >=", value, "unitpricetime");
            return (Criteria) this;
        }

        public Criteria andUnitpricetimeLessThan(Date value) {
            addCriterion("UnitPriceTime <", value, "unitpricetime");
            return (Criteria) this;
        }

        public Criteria andUnitpricetimeLessThanOrEqualTo(Date value) {
            addCriterion("UnitPriceTime <=", value, "unitpricetime");
            return (Criteria) this;
        }

        public Criteria andUnitpricetimeIn(List<Date> values) {
            addCriterion("UnitPriceTime in", values, "unitpricetime");
            return (Criteria) this;
        }

        public Criteria andUnitpricetimeNotIn(List<Date> values) {
            addCriterion("UnitPriceTime not in", values, "unitpricetime");
            return (Criteria) this;
        }

        public Criteria andUnitpricetimeBetween(Date value1, Date value2) {
            addCriterion("UnitPriceTime between", value1, value2, "unitpricetime");
            return (Criteria) this;
        }

        public Criteria andUnitpricetimeNotBetween(Date value1, Date value2) {
            addCriterion("UnitPriceTime not between", value1, value2, "unitpricetime");
            return (Criteria) this;
        }

        public Criteria andUnitpriceoperatetimeIsNull() {
            addCriterion("UnitPriceOperateTime is null");
            return (Criteria) this;
        }

        public Criteria andUnitpriceoperatetimeIsNotNull() {
            addCriterion("UnitPriceOperateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUnitpriceoperatetimeEqualTo(String value) {
            addCriterion("UnitPriceOperateTime =", value, "unitpriceoperatetime");
            return (Criteria) this;
        }

        public Criteria andUnitpriceoperatetimeNotEqualTo(String value) {
            addCriterion("UnitPriceOperateTime <>", value, "unitpriceoperatetime");
            return (Criteria) this;
        }

        public Criteria andUnitpriceoperatetimeGreaterThan(String value) {
            addCriterion("UnitPriceOperateTime >", value, "unitpriceoperatetime");
            return (Criteria) this;
        }

        public Criteria andUnitpriceoperatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("UnitPriceOperateTime >=", value, "unitpriceoperatetime");
            return (Criteria) this;
        }

        public Criteria andUnitpriceoperatetimeLessThan(String value) {
            addCriterion("UnitPriceOperateTime <", value, "unitpriceoperatetime");
            return (Criteria) this;
        }

        public Criteria andUnitpriceoperatetimeLessThanOrEqualTo(String value) {
            addCriterion("UnitPriceOperateTime <=", value, "unitpriceoperatetime");
            return (Criteria) this;
        }

        public Criteria andUnitpriceoperatetimeLike(String value) {
            addCriterion("UnitPriceOperateTime like", value, "unitpriceoperatetime");
            return (Criteria) this;
        }

        public Criteria andUnitpriceoperatetimeNotLike(String value) {
            addCriterion("UnitPriceOperateTime not like", value, "unitpriceoperatetime");
            return (Criteria) this;
        }

        public Criteria andUnitpriceoperatetimeIn(List<String> values) {
            addCriterion("UnitPriceOperateTime in", values, "unitpriceoperatetime");
            return (Criteria) this;
        }

        public Criteria andUnitpriceoperatetimeNotIn(List<String> values) {
            addCriterion("UnitPriceOperateTime not in", values, "unitpriceoperatetime");
            return (Criteria) this;
        }

        public Criteria andUnitpriceoperatetimeBetween(String value1, String value2) {
            addCriterion("UnitPriceOperateTime between", value1, value2, "unitpriceoperatetime");
            return (Criteria) this;
        }

        public Criteria andUnitpriceoperatetimeNotBetween(String value1, String value2) {
            addCriterion("UnitPriceOperateTime not between", value1, value2, "unitpriceoperatetime");
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