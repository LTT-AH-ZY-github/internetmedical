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

        public Criteria andDoccalendarischeckIsNull() {
            addCriterion("docCalendarIsCheck is null");
            return (Criteria) this;
        }

        public Criteria andDoccalendarischeckIsNotNull() {
            addCriterion("docCalendarIsCheck is not null");
            return (Criteria) this;
        }

        public Criteria andDoccalendarischeckEqualTo(Boolean value) {
            addCriterion("docCalendarIsCheck =", value, "doccalendarischeck");
            return (Criteria) this;
        }

        public Criteria andDoccalendarischeckNotEqualTo(Boolean value) {
            addCriterion("docCalendarIsCheck <>", value, "doccalendarischeck");
            return (Criteria) this;
        }

        public Criteria andDoccalendarischeckGreaterThan(Boolean value) {
            addCriterion("docCalendarIsCheck >", value, "doccalendarischeck");
            return (Criteria) this;
        }

        public Criteria andDoccalendarischeckGreaterThanOrEqualTo(Boolean value) {
            addCriterion("docCalendarIsCheck >=", value, "doccalendarischeck");
            return (Criteria) this;
        }

        public Criteria andDoccalendarischeckLessThan(Boolean value) {
            addCriterion("docCalendarIsCheck <", value, "doccalendarischeck");
            return (Criteria) this;
        }

        public Criteria andDoccalendarischeckLessThanOrEqualTo(Boolean value) {
            addCriterion("docCalendarIsCheck <=", value, "doccalendarischeck");
            return (Criteria) this;
        }

        public Criteria andDoccalendarischeckIn(List<Boolean> values) {
            addCriterion("docCalendarIsCheck in", values, "doccalendarischeck");
            return (Criteria) this;
        }

        public Criteria andDoccalendarischeckNotIn(List<Boolean> values) {
            addCriterion("docCalendarIsCheck not in", values, "doccalendarischeck");
            return (Criteria) this;
        }

        public Criteria andDoccalendarischeckBetween(Boolean value1, Boolean value2) {
            addCriterion("docCalendarIsCheck between", value1, value2, "doccalendarischeck");
            return (Criteria) this;
        }

        public Criteria andDoccalendarischeckNotBetween(Boolean value1, Boolean value2) {
            addCriterion("docCalendarIsCheck not between", value1, value2, "doccalendarischeck");
            return (Criteria) this;
        }

        public Criteria andDocaddresslocationIsNull() {
            addCriterion("docAddressLocation is null");
            return (Criteria) this;
        }

        public Criteria andDocaddresslocationIsNotNull() {
            addCriterion("docAddressLocation is not null");
            return (Criteria) this;
        }

        public Criteria andDocaddresslocationEqualTo(String value) {
            addCriterion("docAddressLocation =", value, "docaddresslocation");
            return (Criteria) this;
        }

        public Criteria andDocaddresslocationNotEqualTo(String value) {
            addCriterion("docAddressLocation <>", value, "docaddresslocation");
            return (Criteria) this;
        }

        public Criteria andDocaddresslocationGreaterThan(String value) {
            addCriterion("docAddressLocation >", value, "docaddresslocation");
            return (Criteria) this;
        }

        public Criteria andDocaddresslocationGreaterThanOrEqualTo(String value) {
            addCriterion("docAddressLocation >=", value, "docaddresslocation");
            return (Criteria) this;
        }

        public Criteria andDocaddresslocationLessThan(String value) {
            addCriterion("docAddressLocation <", value, "docaddresslocation");
            return (Criteria) this;
        }

        public Criteria andDocaddresslocationLessThanOrEqualTo(String value) {
            addCriterion("docAddressLocation <=", value, "docaddresslocation");
            return (Criteria) this;
        }

        public Criteria andDocaddresslocationLike(String value) {
            addCriterion("docAddressLocation like", value, "docaddresslocation");
            return (Criteria) this;
        }

        public Criteria andDocaddresslocationNotLike(String value) {
            addCriterion("docAddressLocation not like", value, "docaddresslocation");
            return (Criteria) this;
        }

        public Criteria andDocaddresslocationIn(List<String> values) {
            addCriterion("docAddressLocation in", values, "docaddresslocation");
            return (Criteria) this;
        }

        public Criteria andDocaddresslocationNotIn(List<String> values) {
            addCriterion("docAddressLocation not in", values, "docaddresslocation");
            return (Criteria) this;
        }

        public Criteria andDocaddresslocationBetween(String value1, String value2) {
            addCriterion("docAddressLocation between", value1, value2, "docaddresslocation");
            return (Criteria) this;
        }

        public Criteria andDocaddresslocationNotBetween(String value1, String value2) {
            addCriterion("docAddressLocation not between", value1, value2, "docaddresslocation");
            return (Criteria) this;
        }

        public Criteria andDocaddressprovinceIsNull() {
            addCriterion("docAddressProvince is null");
            return (Criteria) this;
        }

        public Criteria andDocaddressprovinceIsNotNull() {
            addCriterion("docAddressProvince is not null");
            return (Criteria) this;
        }

        public Criteria andDocaddressprovinceEqualTo(String value) {
            addCriterion("docAddressProvince =", value, "docaddressprovince");
            return (Criteria) this;
        }

        public Criteria andDocaddressprovinceNotEqualTo(String value) {
            addCriterion("docAddressProvince <>", value, "docaddressprovince");
            return (Criteria) this;
        }

        public Criteria andDocaddressprovinceGreaterThan(String value) {
            addCriterion("docAddressProvince >", value, "docaddressprovince");
            return (Criteria) this;
        }

        public Criteria andDocaddressprovinceGreaterThanOrEqualTo(String value) {
            addCriterion("docAddressProvince >=", value, "docaddressprovince");
            return (Criteria) this;
        }

        public Criteria andDocaddressprovinceLessThan(String value) {
            addCriterion("docAddressProvince <", value, "docaddressprovince");
            return (Criteria) this;
        }

        public Criteria andDocaddressprovinceLessThanOrEqualTo(String value) {
            addCriterion("docAddressProvince <=", value, "docaddressprovince");
            return (Criteria) this;
        }

        public Criteria andDocaddressprovinceLike(String value) {
            addCriterion("docAddressProvince like", value, "docaddressprovince");
            return (Criteria) this;
        }

        public Criteria andDocaddressprovinceNotLike(String value) {
            addCriterion("docAddressProvince not like", value, "docaddressprovince");
            return (Criteria) this;
        }

        public Criteria andDocaddressprovinceIn(List<String> values) {
            addCriterion("docAddressProvince in", values, "docaddressprovince");
            return (Criteria) this;
        }

        public Criteria andDocaddressprovinceNotIn(List<String> values) {
            addCriterion("docAddressProvince not in", values, "docaddressprovince");
            return (Criteria) this;
        }

        public Criteria andDocaddressprovinceBetween(String value1, String value2) {
            addCriterion("docAddressProvince between", value1, value2, "docaddressprovince");
            return (Criteria) this;
        }

        public Criteria andDocaddressprovinceNotBetween(String value1, String value2) {
            addCriterion("docAddressProvince not between", value1, value2, "docaddressprovince");
            return (Criteria) this;
        }

        public Criteria andDocaddresscityIsNull() {
            addCriterion("docAddressCity is null");
            return (Criteria) this;
        }

        public Criteria andDocaddresscityIsNotNull() {
            addCriterion("docAddressCity is not null");
            return (Criteria) this;
        }

        public Criteria andDocaddresscityEqualTo(String value) {
            addCriterion("docAddressCity =", value, "docaddresscity");
            return (Criteria) this;
        }

        public Criteria andDocaddresscityNotEqualTo(String value) {
            addCriterion("docAddressCity <>", value, "docaddresscity");
            return (Criteria) this;
        }

        public Criteria andDocaddresscityGreaterThan(String value) {
            addCriterion("docAddressCity >", value, "docaddresscity");
            return (Criteria) this;
        }

        public Criteria andDocaddresscityGreaterThanOrEqualTo(String value) {
            addCriterion("docAddressCity >=", value, "docaddresscity");
            return (Criteria) this;
        }

        public Criteria andDocaddresscityLessThan(String value) {
            addCriterion("docAddressCity <", value, "docaddresscity");
            return (Criteria) this;
        }

        public Criteria andDocaddresscityLessThanOrEqualTo(String value) {
            addCriterion("docAddressCity <=", value, "docaddresscity");
            return (Criteria) this;
        }

        public Criteria andDocaddresscityLike(String value) {
            addCriterion("docAddressCity like", value, "docaddresscity");
            return (Criteria) this;
        }

        public Criteria andDocaddresscityNotLike(String value) {
            addCriterion("docAddressCity not like", value, "docaddresscity");
            return (Criteria) this;
        }

        public Criteria andDocaddresscityIn(List<String> values) {
            addCriterion("docAddressCity in", values, "docaddresscity");
            return (Criteria) this;
        }

        public Criteria andDocaddresscityNotIn(List<String> values) {
            addCriterion("docAddressCity not in", values, "docaddresscity");
            return (Criteria) this;
        }

        public Criteria andDocaddresscityBetween(String value1, String value2) {
            addCriterion("docAddressCity between", value1, value2, "docaddresscity");
            return (Criteria) this;
        }

        public Criteria andDocaddresscityNotBetween(String value1, String value2) {
            addCriterion("docAddressCity not between", value1, value2, "docaddresscity");
            return (Criteria) this;
        }

        public Criteria andDocaddressareaIsNull() {
            addCriterion("docAddressArea is null");
            return (Criteria) this;
        }

        public Criteria andDocaddressareaIsNotNull() {
            addCriterion("docAddressArea is not null");
            return (Criteria) this;
        }

        public Criteria andDocaddressareaEqualTo(String value) {
            addCriterion("docAddressArea =", value, "docaddressarea");
            return (Criteria) this;
        }

        public Criteria andDocaddressareaNotEqualTo(String value) {
            addCriterion("docAddressArea <>", value, "docaddressarea");
            return (Criteria) this;
        }

        public Criteria andDocaddressareaGreaterThan(String value) {
            addCriterion("docAddressArea >", value, "docaddressarea");
            return (Criteria) this;
        }

        public Criteria andDocaddressareaGreaterThanOrEqualTo(String value) {
            addCriterion("docAddressArea >=", value, "docaddressarea");
            return (Criteria) this;
        }

        public Criteria andDocaddressareaLessThan(String value) {
            addCriterion("docAddressArea <", value, "docaddressarea");
            return (Criteria) this;
        }

        public Criteria andDocaddressareaLessThanOrEqualTo(String value) {
            addCriterion("docAddressArea <=", value, "docaddressarea");
            return (Criteria) this;
        }

        public Criteria andDocaddressareaLike(String value) {
            addCriterion("docAddressArea like", value, "docaddressarea");
            return (Criteria) this;
        }

        public Criteria andDocaddressareaNotLike(String value) {
            addCriterion("docAddressArea not like", value, "docaddressarea");
            return (Criteria) this;
        }

        public Criteria andDocaddressareaIn(List<String> values) {
            addCriterion("docAddressArea in", values, "docaddressarea");
            return (Criteria) this;
        }

        public Criteria andDocaddressareaNotIn(List<String> values) {
            addCriterion("docAddressArea not in", values, "docaddressarea");
            return (Criteria) this;
        }

        public Criteria andDocaddressareaBetween(String value1, String value2) {
            addCriterion("docAddressArea between", value1, value2, "docaddressarea");
            return (Criteria) this;
        }

        public Criteria andDocaddressareaNotBetween(String value1, String value2) {
            addCriterion("docAddressArea not between", value1, value2, "docaddressarea");
            return (Criteria) this;
        }

        public Criteria andDocaddressotherIsNull() {
            addCriterion("docAddressOther is null");
            return (Criteria) this;
        }

        public Criteria andDocaddressotherIsNotNull() {
            addCriterion("docAddressOther is not null");
            return (Criteria) this;
        }

        public Criteria andDocaddressotherEqualTo(String value) {
            addCriterion("docAddressOther =", value, "docaddressother");
            return (Criteria) this;
        }

        public Criteria andDocaddressotherNotEqualTo(String value) {
            addCriterion("docAddressOther <>", value, "docaddressother");
            return (Criteria) this;
        }

        public Criteria andDocaddressotherGreaterThan(String value) {
            addCriterion("docAddressOther >", value, "docaddressother");
            return (Criteria) this;
        }

        public Criteria andDocaddressotherGreaterThanOrEqualTo(String value) {
            addCriterion("docAddressOther >=", value, "docaddressother");
            return (Criteria) this;
        }

        public Criteria andDocaddressotherLessThan(String value) {
            addCriterion("docAddressOther <", value, "docaddressother");
            return (Criteria) this;
        }

        public Criteria andDocaddressotherLessThanOrEqualTo(String value) {
            addCriterion("docAddressOther <=", value, "docaddressother");
            return (Criteria) this;
        }

        public Criteria andDocaddressotherLike(String value) {
            addCriterion("docAddressOther like", value, "docaddressother");
            return (Criteria) this;
        }

        public Criteria andDocaddressotherNotLike(String value) {
            addCriterion("docAddressOther not like", value, "docaddressother");
            return (Criteria) this;
        }

        public Criteria andDocaddressotherIn(List<String> values) {
            addCriterion("docAddressOther in", values, "docaddressother");
            return (Criteria) this;
        }

        public Criteria andDocaddressotherNotIn(List<String> values) {
            addCriterion("docAddressOther not in", values, "docaddressother");
            return (Criteria) this;
        }

        public Criteria andDocaddressotherBetween(String value1, String value2) {
            addCriterion("docAddressOther between", value1, value2, "docaddressother");
            return (Criteria) this;
        }

        public Criteria andDocaddressotherNotBetween(String value1, String value2) {
            addCriterion("docAddressOther not between", value1, value2, "docaddressother");
            return (Criteria) this;
        }

        public Criteria andDocaddresslonIsNull() {
            addCriterion("docAddressLon is null");
            return (Criteria) this;
        }

        public Criteria andDocaddresslonIsNotNull() {
            addCriterion("docAddressLon is not null");
            return (Criteria) this;
        }

        public Criteria andDocaddresslonEqualTo(String value) {
            addCriterion("docAddressLon =", value, "docaddresslon");
            return (Criteria) this;
        }

        public Criteria andDocaddresslonNotEqualTo(String value) {
            addCriterion("docAddressLon <>", value, "docaddresslon");
            return (Criteria) this;
        }

        public Criteria andDocaddresslonGreaterThan(String value) {
            addCriterion("docAddressLon >", value, "docaddresslon");
            return (Criteria) this;
        }

        public Criteria andDocaddresslonGreaterThanOrEqualTo(String value) {
            addCriterion("docAddressLon >=", value, "docaddresslon");
            return (Criteria) this;
        }

        public Criteria andDocaddresslonLessThan(String value) {
            addCriterion("docAddressLon <", value, "docaddresslon");
            return (Criteria) this;
        }

        public Criteria andDocaddresslonLessThanOrEqualTo(String value) {
            addCriterion("docAddressLon <=", value, "docaddresslon");
            return (Criteria) this;
        }

        public Criteria andDocaddresslonLike(String value) {
            addCriterion("docAddressLon like", value, "docaddresslon");
            return (Criteria) this;
        }

        public Criteria andDocaddresslonNotLike(String value) {
            addCriterion("docAddressLon not like", value, "docaddresslon");
            return (Criteria) this;
        }

        public Criteria andDocaddresslonIn(List<String> values) {
            addCriterion("docAddressLon in", values, "docaddresslon");
            return (Criteria) this;
        }

        public Criteria andDocaddresslonNotIn(List<String> values) {
            addCriterion("docAddressLon not in", values, "docaddresslon");
            return (Criteria) this;
        }

        public Criteria andDocaddresslonBetween(String value1, String value2) {
            addCriterion("docAddressLon between", value1, value2, "docaddresslon");
            return (Criteria) this;
        }

        public Criteria andDocaddresslonNotBetween(String value1, String value2) {
            addCriterion("docAddressLon not between", value1, value2, "docaddresslon");
            return (Criteria) this;
        }

        public Criteria andDocaddresslatIsNull() {
            addCriterion("docAddressLat is null");
            return (Criteria) this;
        }

        public Criteria andDocaddresslatIsNotNull() {
            addCriterion("docAddressLat is not null");
            return (Criteria) this;
        }

        public Criteria andDocaddresslatEqualTo(String value) {
            addCriterion("docAddressLat =", value, "docaddresslat");
            return (Criteria) this;
        }

        public Criteria andDocaddresslatNotEqualTo(String value) {
            addCriterion("docAddressLat <>", value, "docaddresslat");
            return (Criteria) this;
        }

        public Criteria andDocaddresslatGreaterThan(String value) {
            addCriterion("docAddressLat >", value, "docaddresslat");
            return (Criteria) this;
        }

        public Criteria andDocaddresslatGreaterThanOrEqualTo(String value) {
            addCriterion("docAddressLat >=", value, "docaddresslat");
            return (Criteria) this;
        }

        public Criteria andDocaddresslatLessThan(String value) {
            addCriterion("docAddressLat <", value, "docaddresslat");
            return (Criteria) this;
        }

        public Criteria andDocaddresslatLessThanOrEqualTo(String value) {
            addCriterion("docAddressLat <=", value, "docaddresslat");
            return (Criteria) this;
        }

        public Criteria andDocaddresslatLike(String value) {
            addCriterion("docAddressLat like", value, "docaddresslat");
            return (Criteria) this;
        }

        public Criteria andDocaddresslatNotLike(String value) {
            addCriterion("docAddressLat not like", value, "docaddresslat");
            return (Criteria) this;
        }

        public Criteria andDocaddresslatIn(List<String> values) {
            addCriterion("docAddressLat in", values, "docaddresslat");
            return (Criteria) this;
        }

        public Criteria andDocaddresslatNotIn(List<String> values) {
            addCriterion("docAddressLat not in", values, "docaddresslat");
            return (Criteria) this;
        }

        public Criteria andDocaddresslatBetween(String value1, String value2) {
            addCriterion("docAddressLat between", value1, value2, "docaddresslat");
            return (Criteria) this;
        }

        public Criteria andDocaddresslatNotBetween(String value1, String value2) {
            addCriterion("docAddressLat not between", value1, value2, "docaddresslat");
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