package com.medical.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HospitalpackageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HospitalpackageExample() {
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

        public Criteria andPackageidIsNull() {
            addCriterion("PackageId is null");
            return (Criteria) this;
        }

        public Criteria andPackageidIsNotNull() {
            addCriterion("PackageId is not null");
            return (Criteria) this;
        }

        public Criteria andPackageidEqualTo(Integer value) {
            addCriterion("PackageId =", value, "packageid");
            return (Criteria) this;
        }

        public Criteria andPackageidNotEqualTo(Integer value) {
            addCriterion("PackageId <>", value, "packageid");
            return (Criteria) this;
        }

        public Criteria andPackageidGreaterThan(Integer value) {
            addCriterion("PackageId >", value, "packageid");
            return (Criteria) this;
        }

        public Criteria andPackageidGreaterThanOrEqualTo(Integer value) {
            addCriterion("PackageId >=", value, "packageid");
            return (Criteria) this;
        }

        public Criteria andPackageidLessThan(Integer value) {
            addCriterion("PackageId <", value, "packageid");
            return (Criteria) this;
        }

        public Criteria andPackageidLessThanOrEqualTo(Integer value) {
            addCriterion("PackageId <=", value, "packageid");
            return (Criteria) this;
        }

        public Criteria andPackageidIn(List<Integer> values) {
            addCriterion("PackageId in", values, "packageid");
            return (Criteria) this;
        }

        public Criteria andPackageidNotIn(List<Integer> values) {
            addCriterion("PackageId not in", values, "packageid");
            return (Criteria) this;
        }

        public Criteria andPackageidBetween(Integer value1, Integer value2) {
            addCriterion("PackageId between", value1, value2, "packageid");
            return (Criteria) this;
        }

        public Criteria andPackageidNotBetween(Integer value1, Integer value2) {
            addCriterion("PackageId not between", value1, value2, "packageid");
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

        public Criteria andPackagenameIsNull() {
            addCriterion("PackageName is null");
            return (Criteria) this;
        }

        public Criteria andPackagenameIsNotNull() {
            addCriterion("PackageName is not null");
            return (Criteria) this;
        }

        public Criteria andPackagenameEqualTo(String value) {
            addCriterion("PackageName =", value, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameNotEqualTo(String value) {
            addCriterion("PackageName <>", value, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameGreaterThan(String value) {
            addCriterion("PackageName >", value, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameGreaterThanOrEqualTo(String value) {
            addCriterion("PackageName >=", value, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameLessThan(String value) {
            addCriterion("PackageName <", value, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameLessThanOrEqualTo(String value) {
            addCriterion("PackageName <=", value, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameLike(String value) {
            addCriterion("PackageName like", value, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameNotLike(String value) {
            addCriterion("PackageName not like", value, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameIn(List<String> values) {
            addCriterion("PackageName in", values, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameNotIn(List<String> values) {
            addCriterion("PackageName not in", values, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameBetween(String value1, String value2) {
            addCriterion("PackageName between", value1, value2, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenameNotBetween(String value1, String value2) {
            addCriterion("PackageName not between", value1, value2, "packagename");
            return (Criteria) this;
        }

        public Criteria andPackagenumberIsNull() {
            addCriterion("PackageNumber is null");
            return (Criteria) this;
        }

        public Criteria andPackagenumberIsNotNull() {
            addCriterion("PackageNumber is not null");
            return (Criteria) this;
        }

        public Criteria andPackagenumberEqualTo(BigDecimal value) {
            addCriterion("PackageNumber =", value, "packagenumber");
            return (Criteria) this;
        }

        public Criteria andPackagenumberNotEqualTo(BigDecimal value) {
            addCriterion("PackageNumber <>", value, "packagenumber");
            return (Criteria) this;
        }

        public Criteria andPackagenumberGreaterThan(BigDecimal value) {
            addCriterion("PackageNumber >", value, "packagenumber");
            return (Criteria) this;
        }

        public Criteria andPackagenumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PackageNumber >=", value, "packagenumber");
            return (Criteria) this;
        }

        public Criteria andPackagenumberLessThan(BigDecimal value) {
            addCriterion("PackageNumber <", value, "packagenumber");
            return (Criteria) this;
        }

        public Criteria andPackagenumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PackageNumber <=", value, "packagenumber");
            return (Criteria) this;
        }

        public Criteria andPackagenumberIn(List<BigDecimal> values) {
            addCriterion("PackageNumber in", values, "packagenumber");
            return (Criteria) this;
        }

        public Criteria andPackagenumberNotIn(List<BigDecimal> values) {
            addCriterion("PackageNumber not in", values, "packagenumber");
            return (Criteria) this;
        }

        public Criteria andPackagenumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PackageNumber between", value1, value2, "packagenumber");
            return (Criteria) this;
        }

        public Criteria andPackagenumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PackageNumber not between", value1, value2, "packagenumber");
            return (Criteria) this;
        }

        public Criteria andPackageabsIsNull() {
            addCriterion("PackageAbs is null");
            return (Criteria) this;
        }

        public Criteria andPackageabsIsNotNull() {
            addCriterion("PackageAbs is not null");
            return (Criteria) this;
        }

        public Criteria andPackageabsEqualTo(String value) {
            addCriterion("PackageAbs =", value, "packageabs");
            return (Criteria) this;
        }

        public Criteria andPackageabsNotEqualTo(String value) {
            addCriterion("PackageAbs <>", value, "packageabs");
            return (Criteria) this;
        }

        public Criteria andPackageabsGreaterThan(String value) {
            addCriterion("PackageAbs >", value, "packageabs");
            return (Criteria) this;
        }

        public Criteria andPackageabsGreaterThanOrEqualTo(String value) {
            addCriterion("PackageAbs >=", value, "packageabs");
            return (Criteria) this;
        }

        public Criteria andPackageabsLessThan(String value) {
            addCriterion("PackageAbs <", value, "packageabs");
            return (Criteria) this;
        }

        public Criteria andPackageabsLessThanOrEqualTo(String value) {
            addCriterion("PackageAbs <=", value, "packageabs");
            return (Criteria) this;
        }

        public Criteria andPackageabsLike(String value) {
            addCriterion("PackageAbs like", value, "packageabs");
            return (Criteria) this;
        }

        public Criteria andPackageabsNotLike(String value) {
            addCriterion("PackageAbs not like", value, "packageabs");
            return (Criteria) this;
        }

        public Criteria andPackageabsIn(List<String> values) {
            addCriterion("PackageAbs in", values, "packageabs");
            return (Criteria) this;
        }

        public Criteria andPackageabsNotIn(List<String> values) {
            addCriterion("PackageAbs not in", values, "packageabs");
            return (Criteria) this;
        }

        public Criteria andPackageabsBetween(String value1, String value2) {
            addCriterion("PackageAbs between", value1, value2, "packageabs");
            return (Criteria) this;
        }

        public Criteria andPackageabsNotBetween(String value1, String value2) {
            addCriterion("PackageAbs not between", value1, value2, "packageabs");
            return (Criteria) this;
        }

        public Criteria andPackagestimeIsNull() {
            addCriterion("PackageSTime is null");
            return (Criteria) this;
        }

        public Criteria andPackagestimeIsNotNull() {
            addCriterion("PackageSTime is not null");
            return (Criteria) this;
        }

        public Criteria andPackagestimeEqualTo(Date value) {
            addCriterion("PackageSTime =", value, "packagestime");
            return (Criteria) this;
        }

        public Criteria andPackagestimeNotEqualTo(Date value) {
            addCriterion("PackageSTime <>", value, "packagestime");
            return (Criteria) this;
        }

        public Criteria andPackagestimeGreaterThan(Date value) {
            addCriterion("PackageSTime >", value, "packagestime");
            return (Criteria) this;
        }

        public Criteria andPackagestimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PackageSTime >=", value, "packagestime");
            return (Criteria) this;
        }

        public Criteria andPackagestimeLessThan(Date value) {
            addCriterion("PackageSTime <", value, "packagestime");
            return (Criteria) this;
        }

        public Criteria andPackagestimeLessThanOrEqualTo(Date value) {
            addCriterion("PackageSTime <=", value, "packagestime");
            return (Criteria) this;
        }

        public Criteria andPackagestimeIn(List<Date> values) {
            addCriterion("PackageSTime in", values, "packagestime");
            return (Criteria) this;
        }

        public Criteria andPackagestimeNotIn(List<Date> values) {
            addCriterion("PackageSTime not in", values, "packagestime");
            return (Criteria) this;
        }

        public Criteria andPackagestimeBetween(Date value1, Date value2) {
            addCriterion("PackageSTime between", value1, value2, "packagestime");
            return (Criteria) this;
        }

        public Criteria andPackagestimeNotBetween(Date value1, Date value2) {
            addCriterion("PackageSTime not between", value1, value2, "packagestime");
            return (Criteria) this;
        }

        public Criteria andPackageetimeIsNull() {
            addCriterion("PackageETime is null");
            return (Criteria) this;
        }

        public Criteria andPackageetimeIsNotNull() {
            addCriterion("PackageETime is not null");
            return (Criteria) this;
        }

        public Criteria andPackageetimeEqualTo(Date value) {
            addCriterion("PackageETime =", value, "packageetime");
            return (Criteria) this;
        }

        public Criteria andPackageetimeNotEqualTo(Date value) {
            addCriterion("PackageETime <>", value, "packageetime");
            return (Criteria) this;
        }

        public Criteria andPackageetimeGreaterThan(Date value) {
            addCriterion("PackageETime >", value, "packageetime");
            return (Criteria) this;
        }

        public Criteria andPackageetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PackageETime >=", value, "packageetime");
            return (Criteria) this;
        }

        public Criteria andPackageetimeLessThan(Date value) {
            addCriterion("PackageETime <", value, "packageetime");
            return (Criteria) this;
        }

        public Criteria andPackageetimeLessThanOrEqualTo(Date value) {
            addCriterion("PackageETime <=", value, "packageetime");
            return (Criteria) this;
        }

        public Criteria andPackageetimeIn(List<Date> values) {
            addCriterion("PackageETime in", values, "packageetime");
            return (Criteria) this;
        }

        public Criteria andPackageetimeNotIn(List<Date> values) {
            addCriterion("PackageETime not in", values, "packageetime");
            return (Criteria) this;
        }

        public Criteria andPackageetimeBetween(Date value1, Date value2) {
            addCriterion("PackageETime between", value1, value2, "packageetime");
            return (Criteria) this;
        }

        public Criteria andPackageetimeNotBetween(Date value1, Date value2) {
            addCriterion("PackageETime not between", value1, value2, "packageetime");
            return (Criteria) this;
        }

        public Criteria andPackagesustimeIsNull() {
            addCriterion("PackageSusTime is null");
            return (Criteria) this;
        }

        public Criteria andPackagesustimeIsNotNull() {
            addCriterion("PackageSusTime is not null");
            return (Criteria) this;
        }

        public Criteria andPackagesustimeEqualTo(Integer value) {
            addCriterion("PackageSusTime =", value, "packagesustime");
            return (Criteria) this;
        }

        public Criteria andPackagesustimeNotEqualTo(Integer value) {
            addCriterion("PackageSusTime <>", value, "packagesustime");
            return (Criteria) this;
        }

        public Criteria andPackagesustimeGreaterThan(Integer value) {
            addCriterion("PackageSusTime >", value, "packagesustime");
            return (Criteria) this;
        }

        public Criteria andPackagesustimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("PackageSusTime >=", value, "packagesustime");
            return (Criteria) this;
        }

        public Criteria andPackagesustimeLessThan(Integer value) {
            addCriterion("PackageSusTime <", value, "packagesustime");
            return (Criteria) this;
        }

        public Criteria andPackagesustimeLessThanOrEqualTo(Integer value) {
            addCriterion("PackageSusTime <=", value, "packagesustime");
            return (Criteria) this;
        }

        public Criteria andPackagesustimeIn(List<Integer> values) {
            addCriterion("PackageSusTime in", values, "packagesustime");
            return (Criteria) this;
        }

        public Criteria andPackagesustimeNotIn(List<Integer> values) {
            addCriterion("PackageSusTime not in", values, "packagesustime");
            return (Criteria) this;
        }

        public Criteria andPackagesustimeBetween(Integer value1, Integer value2) {
            addCriterion("PackageSusTime between", value1, value2, "packagesustime");
            return (Criteria) this;
        }

        public Criteria andPackagesustimeNotBetween(Integer value1, Integer value2) {
            addCriterion("PackageSusTime not between", value1, value2, "packagesustime");
            return (Criteria) this;
        }

        public Criteria andPackagetimeIsNull() {
            addCriterion("PackageTime is null");
            return (Criteria) this;
        }

        public Criteria andPackagetimeIsNotNull() {
            addCriterion("PackageTime is not null");
            return (Criteria) this;
        }

        public Criteria andPackagetimeEqualTo(Date value) {
            addCriterion("PackageTime =", value, "packagetime");
            return (Criteria) this;
        }

        public Criteria andPackagetimeNotEqualTo(Date value) {
            addCriterion("PackageTime <>", value, "packagetime");
            return (Criteria) this;
        }

        public Criteria andPackagetimeGreaterThan(Date value) {
            addCriterion("PackageTime >", value, "packagetime");
            return (Criteria) this;
        }

        public Criteria andPackagetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PackageTime >=", value, "packagetime");
            return (Criteria) this;
        }

        public Criteria andPackagetimeLessThan(Date value) {
            addCriterion("PackageTime <", value, "packagetime");
            return (Criteria) this;
        }

        public Criteria andPackagetimeLessThanOrEqualTo(Date value) {
            addCriterion("PackageTime <=", value, "packagetime");
            return (Criteria) this;
        }

        public Criteria andPackagetimeIn(List<Date> values) {
            addCriterion("PackageTime in", values, "packagetime");
            return (Criteria) this;
        }

        public Criteria andPackagetimeNotIn(List<Date> values) {
            addCriterion("PackageTime not in", values, "packagetime");
            return (Criteria) this;
        }

        public Criteria andPackagetimeBetween(Date value1, Date value2) {
            addCriterion("PackageTime between", value1, value2, "packagetime");
            return (Criteria) this;
        }

        public Criteria andPackagetimeNotBetween(Date value1, Date value2) {
            addCriterion("PackageTime not between", value1, value2, "packagetime");
            return (Criteria) this;
        }

        public Criteria andPackageoperatetimeIsNull() {
            addCriterion("PackageOperateTime is null");
            return (Criteria) this;
        }

        public Criteria andPackageoperatetimeIsNotNull() {
            addCriterion("PackageOperateTime is not null");
            return (Criteria) this;
        }

        public Criteria andPackageoperatetimeEqualTo(String value) {
            addCriterion("PackageOperateTime =", value, "packageoperatetime");
            return (Criteria) this;
        }

        public Criteria andPackageoperatetimeNotEqualTo(String value) {
            addCriterion("PackageOperateTime <>", value, "packageoperatetime");
            return (Criteria) this;
        }

        public Criteria andPackageoperatetimeGreaterThan(String value) {
            addCriterion("PackageOperateTime >", value, "packageoperatetime");
            return (Criteria) this;
        }

        public Criteria andPackageoperatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("PackageOperateTime >=", value, "packageoperatetime");
            return (Criteria) this;
        }

        public Criteria andPackageoperatetimeLessThan(String value) {
            addCriterion("PackageOperateTime <", value, "packageoperatetime");
            return (Criteria) this;
        }

        public Criteria andPackageoperatetimeLessThanOrEqualTo(String value) {
            addCriterion("PackageOperateTime <=", value, "packageoperatetime");
            return (Criteria) this;
        }

        public Criteria andPackageoperatetimeLike(String value) {
            addCriterion("PackageOperateTime like", value, "packageoperatetime");
            return (Criteria) this;
        }

        public Criteria andPackageoperatetimeNotLike(String value) {
            addCriterion("PackageOperateTime not like", value, "packageoperatetime");
            return (Criteria) this;
        }

        public Criteria andPackageoperatetimeIn(List<String> values) {
            addCriterion("PackageOperateTime in", values, "packageoperatetime");
            return (Criteria) this;
        }

        public Criteria andPackageoperatetimeNotIn(List<String> values) {
            addCriterion("PackageOperateTime not in", values, "packageoperatetime");
            return (Criteria) this;
        }

        public Criteria andPackageoperatetimeBetween(String value1, String value2) {
            addCriterion("PackageOperateTime between", value1, value2, "packageoperatetime");
            return (Criteria) this;
        }

        public Criteria andPackageoperatetimeNotBetween(String value1, String value2) {
            addCriterion("PackageOperateTime not between", value1, value2, "packageoperatetime");
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