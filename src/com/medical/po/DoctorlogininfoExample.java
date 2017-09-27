package com.medical.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DoctorlogininfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DoctorlogininfoExample() {
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

        public Criteria andDocloginnameIsNull() {
            addCriterion("docLoginName is null");
            return (Criteria) this;
        }

        public Criteria andDocloginnameIsNotNull() {
            addCriterion("docLoginName is not null");
            return (Criteria) this;
        }

        public Criteria andDocloginnameEqualTo(String value) {
            addCriterion("docLoginName =", value, "docloginname");
            return (Criteria) this;
        }

        public Criteria andDocloginnameNotEqualTo(String value) {
            addCriterion("docLoginName <>", value, "docloginname");
            return (Criteria) this;
        }

        public Criteria andDocloginnameGreaterThan(String value) {
            addCriterion("docLoginName >", value, "docloginname");
            return (Criteria) this;
        }

        public Criteria andDocloginnameGreaterThanOrEqualTo(String value) {
            addCriterion("docLoginName >=", value, "docloginname");
            return (Criteria) this;
        }

        public Criteria andDocloginnameLessThan(String value) {
            addCriterion("docLoginName <", value, "docloginname");
            return (Criteria) this;
        }

        public Criteria andDocloginnameLessThanOrEqualTo(String value) {
            addCriterion("docLoginName <=", value, "docloginname");
            return (Criteria) this;
        }

        public Criteria andDocloginnameLike(String value) {
            addCriterion("docLoginName like", value, "docloginname");
            return (Criteria) this;
        }

        public Criteria andDocloginnameNotLike(String value) {
            addCriterion("docLoginName not like", value, "docloginname");
            return (Criteria) this;
        }

        public Criteria andDocloginnameIn(List<String> values) {
            addCriterion("docLoginName in", values, "docloginname");
            return (Criteria) this;
        }

        public Criteria andDocloginnameNotIn(List<String> values) {
            addCriterion("docLoginName not in", values, "docloginname");
            return (Criteria) this;
        }

        public Criteria andDocloginnameBetween(String value1, String value2) {
            addCriterion("docLoginName between", value1, value2, "docloginname");
            return (Criteria) this;
        }

        public Criteria andDocloginnameNotBetween(String value1, String value2) {
            addCriterion("docLoginName not between", value1, value2, "docloginname");
            return (Criteria) this;
        }

        public Criteria andDocloginphoneIsNull() {
            addCriterion("docLoginPhone is null");
            return (Criteria) this;
        }

        public Criteria andDocloginphoneIsNotNull() {
            addCriterion("docLoginPhone is not null");
            return (Criteria) this;
        }

        public Criteria andDocloginphoneEqualTo(String value) {
            addCriterion("docLoginPhone =", value, "docloginphone");
            return (Criteria) this;
        }

        public Criteria andDocloginphoneNotEqualTo(String value) {
            addCriterion("docLoginPhone <>", value, "docloginphone");
            return (Criteria) this;
        }

        public Criteria andDocloginphoneGreaterThan(String value) {
            addCriterion("docLoginPhone >", value, "docloginphone");
            return (Criteria) this;
        }

        public Criteria andDocloginphoneGreaterThanOrEqualTo(String value) {
            addCriterion("docLoginPhone >=", value, "docloginphone");
            return (Criteria) this;
        }

        public Criteria andDocloginphoneLessThan(String value) {
            addCriterion("docLoginPhone <", value, "docloginphone");
            return (Criteria) this;
        }

        public Criteria andDocloginphoneLessThanOrEqualTo(String value) {
            addCriterion("docLoginPhone <=", value, "docloginphone");
            return (Criteria) this;
        }

        public Criteria andDocloginphoneLike(String value) {
            addCriterion("docLoginPhone like", value, "docloginphone");
            return (Criteria) this;
        }

        public Criteria andDocloginphoneNotLike(String value) {
            addCriterion("docLoginPhone not like", value, "docloginphone");
            return (Criteria) this;
        }

        public Criteria andDocloginphoneIn(List<String> values) {
            addCriterion("docLoginPhone in", values, "docloginphone");
            return (Criteria) this;
        }

        public Criteria andDocloginphoneNotIn(List<String> values) {
            addCriterion("docLoginPhone not in", values, "docloginphone");
            return (Criteria) this;
        }

        public Criteria andDocloginphoneBetween(String value1, String value2) {
            addCriterion("docLoginPhone between", value1, value2, "docloginphone");
            return (Criteria) this;
        }

        public Criteria andDocloginphoneNotBetween(String value1, String value2) {
            addCriterion("docLoginPhone not between", value1, value2, "docloginphone");
            return (Criteria) this;
        }

        public Criteria andDocloginpwdIsNull() {
            addCriterion("docLoginPwd is null");
            return (Criteria) this;
        }

        public Criteria andDocloginpwdIsNotNull() {
            addCriterion("docLoginPwd is not null");
            return (Criteria) this;
        }

        public Criteria andDocloginpwdEqualTo(String value) {
            addCriterion("docLoginPwd =", value, "docloginpwd");
            return (Criteria) this;
        }

        public Criteria andDocloginpwdNotEqualTo(String value) {
            addCriterion("docLoginPwd <>", value, "docloginpwd");
            return (Criteria) this;
        }

        public Criteria andDocloginpwdGreaterThan(String value) {
            addCriterion("docLoginPwd >", value, "docloginpwd");
            return (Criteria) this;
        }

        public Criteria andDocloginpwdGreaterThanOrEqualTo(String value) {
            addCriterion("docLoginPwd >=", value, "docloginpwd");
            return (Criteria) this;
        }

        public Criteria andDocloginpwdLessThan(String value) {
            addCriterion("docLoginPwd <", value, "docloginpwd");
            return (Criteria) this;
        }

        public Criteria andDocloginpwdLessThanOrEqualTo(String value) {
            addCriterion("docLoginPwd <=", value, "docloginpwd");
            return (Criteria) this;
        }

        public Criteria andDocloginpwdLike(String value) {
            addCriterion("docLoginPwd like", value, "docloginpwd");
            return (Criteria) this;
        }

        public Criteria andDocloginpwdNotLike(String value) {
            addCriterion("docLoginPwd not like", value, "docloginpwd");
            return (Criteria) this;
        }

        public Criteria andDocloginpwdIn(List<String> values) {
            addCriterion("docLoginPwd in", values, "docloginpwd");
            return (Criteria) this;
        }

        public Criteria andDocloginpwdNotIn(List<String> values) {
            addCriterion("docLoginPwd not in", values, "docloginpwd");
            return (Criteria) this;
        }

        public Criteria andDocloginpwdBetween(String value1, String value2) {
            addCriterion("docLoginPwd between", value1, value2, "docloginpwd");
            return (Criteria) this;
        }

        public Criteria andDocloginpwdNotBetween(String value1, String value2) {
            addCriterion("docLoginPwd not between", value1, value2, "docloginpwd");
            return (Criteria) this;
        }

        public Criteria andDocloginsaltIsNull() {
            addCriterion("docLoginSalt is null");
            return (Criteria) this;
        }

        public Criteria andDocloginsaltIsNotNull() {
            addCriterion("docLoginSalt is not null");
            return (Criteria) this;
        }

        public Criteria andDocloginsaltEqualTo(String value) {
            addCriterion("docLoginSalt =", value, "docloginsalt");
            return (Criteria) this;
        }

        public Criteria andDocloginsaltNotEqualTo(String value) {
            addCriterion("docLoginSalt <>", value, "docloginsalt");
            return (Criteria) this;
        }

        public Criteria andDocloginsaltGreaterThan(String value) {
            addCriterion("docLoginSalt >", value, "docloginsalt");
            return (Criteria) this;
        }

        public Criteria andDocloginsaltGreaterThanOrEqualTo(String value) {
            addCriterion("docLoginSalt >=", value, "docloginsalt");
            return (Criteria) this;
        }

        public Criteria andDocloginsaltLessThan(String value) {
            addCriterion("docLoginSalt <", value, "docloginsalt");
            return (Criteria) this;
        }

        public Criteria andDocloginsaltLessThanOrEqualTo(String value) {
            addCriterion("docLoginSalt <=", value, "docloginsalt");
            return (Criteria) this;
        }

        public Criteria andDocloginsaltLike(String value) {
            addCriterion("docLoginSalt like", value, "docloginsalt");
            return (Criteria) this;
        }

        public Criteria andDocloginsaltNotLike(String value) {
            addCriterion("docLoginSalt not like", value, "docloginsalt");
            return (Criteria) this;
        }

        public Criteria andDocloginsaltIn(List<String> values) {
            addCriterion("docLoginSalt in", values, "docloginsalt");
            return (Criteria) this;
        }

        public Criteria andDocloginsaltNotIn(List<String> values) {
            addCriterion("docLoginSalt not in", values, "docloginsalt");
            return (Criteria) this;
        }

        public Criteria andDocloginsaltBetween(String value1, String value2) {
            addCriterion("docLoginSalt between", value1, value2, "docloginsalt");
            return (Criteria) this;
        }

        public Criteria andDocloginsaltNotBetween(String value1, String value2) {
            addCriterion("docLoginSalt not between", value1, value2, "docloginsalt");
            return (Criteria) this;
        }

        public Criteria andDoclogintokenIsNull() {
            addCriterion("docLoginToken is null");
            return (Criteria) this;
        }

        public Criteria andDoclogintokenIsNotNull() {
            addCriterion("docLoginToken is not null");
            return (Criteria) this;
        }

        public Criteria andDoclogintokenEqualTo(String value) {
            addCriterion("docLoginToken =", value, "doclogintoken");
            return (Criteria) this;
        }

        public Criteria andDoclogintokenNotEqualTo(String value) {
            addCriterion("docLoginToken <>", value, "doclogintoken");
            return (Criteria) this;
        }

        public Criteria andDoclogintokenGreaterThan(String value) {
            addCriterion("docLoginToken >", value, "doclogintoken");
            return (Criteria) this;
        }

        public Criteria andDoclogintokenGreaterThanOrEqualTo(String value) {
            addCriterion("docLoginToken >=", value, "doclogintoken");
            return (Criteria) this;
        }

        public Criteria andDoclogintokenLessThan(String value) {
            addCriterion("docLoginToken <", value, "doclogintoken");
            return (Criteria) this;
        }

        public Criteria andDoclogintokenLessThanOrEqualTo(String value) {
            addCriterion("docLoginToken <=", value, "doclogintoken");
            return (Criteria) this;
        }

        public Criteria andDoclogintokenLike(String value) {
            addCriterion("docLoginToken like", value, "doclogintoken");
            return (Criteria) this;
        }

        public Criteria andDoclogintokenNotLike(String value) {
            addCriterion("docLoginToken not like", value, "doclogintoken");
            return (Criteria) this;
        }

        public Criteria andDoclogintokenIn(List<String> values) {
            addCriterion("docLoginToken in", values, "doclogintoken");
            return (Criteria) this;
        }

        public Criteria andDoclogintokenNotIn(List<String> values) {
            addCriterion("docLoginToken not in", values, "doclogintoken");
            return (Criteria) this;
        }

        public Criteria andDoclogintokenBetween(String value1, String value2) {
            addCriterion("docLoginToken between", value1, value2, "doclogintoken");
            return (Criteria) this;
        }

        public Criteria andDoclogintokenNotBetween(String value1, String value2) {
            addCriterion("docLoginToken not between", value1, value2, "doclogintoken");
            return (Criteria) this;
        }

        public Criteria andDoclogindldIsNull() {
            addCriterion("docLoginDld is null");
            return (Criteria) this;
        }

        public Criteria andDoclogindldIsNotNull() {
            addCriterion("docLoginDld is not null");
            return (Criteria) this;
        }

        public Criteria andDoclogindldEqualTo(Long value) {
            addCriterion("docLoginDld =", value, "doclogindld");
            return (Criteria) this;
        }

        public Criteria andDoclogindldNotEqualTo(Long value) {
            addCriterion("docLoginDld <>", value, "doclogindld");
            return (Criteria) this;
        }

        public Criteria andDoclogindldGreaterThan(Long value) {
            addCriterion("docLoginDld >", value, "doclogindld");
            return (Criteria) this;
        }

        public Criteria andDoclogindldGreaterThanOrEqualTo(Long value) {
            addCriterion("docLoginDld >=", value, "doclogindld");
            return (Criteria) this;
        }

        public Criteria andDoclogindldLessThan(Long value) {
            addCriterion("docLoginDld <", value, "doclogindld");
            return (Criteria) this;
        }

        public Criteria andDoclogindldLessThanOrEqualTo(Long value) {
            addCriterion("docLoginDld <=", value, "doclogindld");
            return (Criteria) this;
        }

        public Criteria andDoclogindldIn(List<Long> values) {
            addCriterion("docLoginDld in", values, "doclogindld");
            return (Criteria) this;
        }

        public Criteria andDoclogindldNotIn(List<Long> values) {
            addCriterion("docLoginDld not in", values, "doclogindld");
            return (Criteria) this;
        }

        public Criteria andDoclogindldBetween(Long value1, Long value2) {
            addCriterion("docLoginDld between", value1, value2, "doclogindld");
            return (Criteria) this;
        }

        public Criteria andDoclogindldNotBetween(Long value1, Long value2) {
            addCriterion("docLoginDld not between", value1, value2, "doclogindld");
            return (Criteria) this;
        }

        public Criteria andDoclogintimeIsNull() {
            addCriterion("docLoginTime is null");
            return (Criteria) this;
        }

        public Criteria andDoclogintimeIsNotNull() {
            addCriterion("docLoginTime is not null");
            return (Criteria) this;
        }

        public Criteria andDoclogintimeEqualTo(Date value) {
            addCriterion("docLoginTime =", value, "doclogintime");
            return (Criteria) this;
        }

        public Criteria andDoclogintimeNotEqualTo(Date value) {
            addCriterion("docLoginTime <>", value, "doclogintime");
            return (Criteria) this;
        }

        public Criteria andDoclogintimeGreaterThan(Date value) {
            addCriterion("docLoginTime >", value, "doclogintime");
            return (Criteria) this;
        }

        public Criteria andDoclogintimeGreaterThanOrEqualTo(Date value) {
            addCriterion("docLoginTime >=", value, "doclogintime");
            return (Criteria) this;
        }

        public Criteria andDoclogintimeLessThan(Date value) {
            addCriterion("docLoginTime <", value, "doclogintime");
            return (Criteria) this;
        }

        public Criteria andDoclogintimeLessThanOrEqualTo(Date value) {
            addCriterion("docLoginTime <=", value, "doclogintime");
            return (Criteria) this;
        }

        public Criteria andDoclogintimeIn(List<Date> values) {
            addCriterion("docLoginTime in", values, "doclogintime");
            return (Criteria) this;
        }

        public Criteria andDoclogintimeNotIn(List<Date> values) {
            addCriterion("docLoginTime not in", values, "doclogintime");
            return (Criteria) this;
        }

        public Criteria andDoclogintimeBetween(Date value1, Date value2) {
            addCriterion("docLoginTime between", value1, value2, "doclogintime");
            return (Criteria) this;
        }

        public Criteria andDoclogintimeNotBetween(Date value1, Date value2) {
            addCriterion("docLoginTime not between", value1, value2, "doclogintime");
            return (Criteria) this;
        }

        public Criteria andDocloginlonIsNull() {
            addCriterion("docLoginLon is null");
            return (Criteria) this;
        }

        public Criteria andDocloginlonIsNotNull() {
            addCriterion("docLoginLon is not null");
            return (Criteria) this;
        }

        public Criteria andDocloginlonEqualTo(String value) {
            addCriterion("docLoginLon =", value, "docloginlon");
            return (Criteria) this;
        }

        public Criteria andDocloginlonNotEqualTo(String value) {
            addCriterion("docLoginLon <>", value, "docloginlon");
            return (Criteria) this;
        }

        public Criteria andDocloginlonGreaterThan(String value) {
            addCriterion("docLoginLon >", value, "docloginlon");
            return (Criteria) this;
        }

        public Criteria andDocloginlonGreaterThanOrEqualTo(String value) {
            addCriterion("docLoginLon >=", value, "docloginlon");
            return (Criteria) this;
        }

        public Criteria andDocloginlonLessThan(String value) {
            addCriterion("docLoginLon <", value, "docloginlon");
            return (Criteria) this;
        }

        public Criteria andDocloginlonLessThanOrEqualTo(String value) {
            addCriterion("docLoginLon <=", value, "docloginlon");
            return (Criteria) this;
        }

        public Criteria andDocloginlonLike(String value) {
            addCriterion("docLoginLon like", value, "docloginlon");
            return (Criteria) this;
        }

        public Criteria andDocloginlonNotLike(String value) {
            addCriterion("docLoginLon not like", value, "docloginlon");
            return (Criteria) this;
        }

        public Criteria andDocloginlonIn(List<String> values) {
            addCriterion("docLoginLon in", values, "docloginlon");
            return (Criteria) this;
        }

        public Criteria andDocloginlonNotIn(List<String> values) {
            addCriterion("docLoginLon not in", values, "docloginlon");
            return (Criteria) this;
        }

        public Criteria andDocloginlonBetween(String value1, String value2) {
            addCriterion("docLoginLon between", value1, value2, "docloginlon");
            return (Criteria) this;
        }

        public Criteria andDocloginlonNotBetween(String value1, String value2) {
            addCriterion("docLoginLon not between", value1, value2, "docloginlon");
            return (Criteria) this;
        }

        public Criteria andDocloginlatIsNull() {
            addCriterion("docLoginLat is null");
            return (Criteria) this;
        }

        public Criteria andDocloginlatIsNotNull() {
            addCriterion("docLoginLat is not null");
            return (Criteria) this;
        }

        public Criteria andDocloginlatEqualTo(String value) {
            addCriterion("docLoginLat =", value, "docloginlat");
            return (Criteria) this;
        }

        public Criteria andDocloginlatNotEqualTo(String value) {
            addCriterion("docLoginLat <>", value, "docloginlat");
            return (Criteria) this;
        }

        public Criteria andDocloginlatGreaterThan(String value) {
            addCriterion("docLoginLat >", value, "docloginlat");
            return (Criteria) this;
        }

        public Criteria andDocloginlatGreaterThanOrEqualTo(String value) {
            addCriterion("docLoginLat >=", value, "docloginlat");
            return (Criteria) this;
        }

        public Criteria andDocloginlatLessThan(String value) {
            addCriterion("docLoginLat <", value, "docloginlat");
            return (Criteria) this;
        }

        public Criteria andDocloginlatLessThanOrEqualTo(String value) {
            addCriterion("docLoginLat <=", value, "docloginlat");
            return (Criteria) this;
        }

        public Criteria andDocloginlatLike(String value) {
            addCriterion("docLoginLat like", value, "docloginlat");
            return (Criteria) this;
        }

        public Criteria andDocloginlatNotLike(String value) {
            addCriterion("docLoginLat not like", value, "docloginlat");
            return (Criteria) this;
        }

        public Criteria andDocloginlatIn(List<String> values) {
            addCriterion("docLoginLat in", values, "docloginlat");
            return (Criteria) this;
        }

        public Criteria andDocloginlatNotIn(List<String> values) {
            addCriterion("docLoginLat not in", values, "docloginlat");
            return (Criteria) this;
        }

        public Criteria andDocloginlatBetween(String value1, String value2) {
            addCriterion("docLoginLat between", value1, value2, "docloginlat");
            return (Criteria) this;
        }

        public Criteria andDocloginlatNotBetween(String value1, String value2) {
            addCriterion("docLoginLat not between", value1, value2, "docloginlat");
            return (Criteria) this;
        }

        public Criteria andDocloginlocIsNull() {
            addCriterion("docLoginLoc is null");
            return (Criteria) this;
        }

        public Criteria andDocloginlocIsNotNull() {
            addCriterion("docLoginLoc is not null");
            return (Criteria) this;
        }

        public Criteria andDocloginlocEqualTo(String value) {
            addCriterion("docLoginLoc =", value, "docloginloc");
            return (Criteria) this;
        }

        public Criteria andDocloginlocNotEqualTo(String value) {
            addCriterion("docLoginLoc <>", value, "docloginloc");
            return (Criteria) this;
        }

        public Criteria andDocloginlocGreaterThan(String value) {
            addCriterion("docLoginLoc >", value, "docloginloc");
            return (Criteria) this;
        }

        public Criteria andDocloginlocGreaterThanOrEqualTo(String value) {
            addCriterion("docLoginLoc >=", value, "docloginloc");
            return (Criteria) this;
        }

        public Criteria andDocloginlocLessThan(String value) {
            addCriterion("docLoginLoc <", value, "docloginloc");
            return (Criteria) this;
        }

        public Criteria andDocloginlocLessThanOrEqualTo(String value) {
            addCriterion("docLoginLoc <=", value, "docloginloc");
            return (Criteria) this;
        }

        public Criteria andDocloginlocLike(String value) {
            addCriterion("docLoginLoc like", value, "docloginloc");
            return (Criteria) this;
        }

        public Criteria andDocloginlocNotLike(String value) {
            addCriterion("docLoginLoc not like", value, "docloginloc");
            return (Criteria) this;
        }

        public Criteria andDocloginlocIn(List<String> values) {
            addCriterion("docLoginLoc in", values, "docloginloc");
            return (Criteria) this;
        }

        public Criteria andDocloginlocNotIn(List<String> values) {
            addCriterion("docLoginLoc not in", values, "docloginloc");
            return (Criteria) this;
        }

        public Criteria andDocloginlocBetween(String value1, String value2) {
            addCriterion("docLoginLoc between", value1, value2, "docloginloc");
            return (Criteria) this;
        }

        public Criteria andDocloginlocNotBetween(String value1, String value2) {
            addCriterion("docLoginLoc not between", value1, value2, "docloginloc");
            return (Criteria) this;
        }

        public Criteria andDocloginprovinceIsNull() {
            addCriterion("docLoginProvince is null");
            return (Criteria) this;
        }

        public Criteria andDocloginprovinceIsNotNull() {
            addCriterion("docLoginProvince is not null");
            return (Criteria) this;
        }

        public Criteria andDocloginprovinceEqualTo(String value) {
            addCriterion("docLoginProvince =", value, "docloginprovince");
            return (Criteria) this;
        }

        public Criteria andDocloginprovinceNotEqualTo(String value) {
            addCriterion("docLoginProvince <>", value, "docloginprovince");
            return (Criteria) this;
        }

        public Criteria andDocloginprovinceGreaterThan(String value) {
            addCriterion("docLoginProvince >", value, "docloginprovince");
            return (Criteria) this;
        }

        public Criteria andDocloginprovinceGreaterThanOrEqualTo(String value) {
            addCriterion("docLoginProvince >=", value, "docloginprovince");
            return (Criteria) this;
        }

        public Criteria andDocloginprovinceLessThan(String value) {
            addCriterion("docLoginProvince <", value, "docloginprovince");
            return (Criteria) this;
        }

        public Criteria andDocloginprovinceLessThanOrEqualTo(String value) {
            addCriterion("docLoginProvince <=", value, "docloginprovince");
            return (Criteria) this;
        }

        public Criteria andDocloginprovinceLike(String value) {
            addCriterion("docLoginProvince like", value, "docloginprovince");
            return (Criteria) this;
        }

        public Criteria andDocloginprovinceNotLike(String value) {
            addCriterion("docLoginProvince not like", value, "docloginprovince");
            return (Criteria) this;
        }

        public Criteria andDocloginprovinceIn(List<String> values) {
            addCriterion("docLoginProvince in", values, "docloginprovince");
            return (Criteria) this;
        }

        public Criteria andDocloginprovinceNotIn(List<String> values) {
            addCriterion("docLoginProvince not in", values, "docloginprovince");
            return (Criteria) this;
        }

        public Criteria andDocloginprovinceBetween(String value1, String value2) {
            addCriterion("docLoginProvince between", value1, value2, "docloginprovince");
            return (Criteria) this;
        }

        public Criteria andDocloginprovinceNotBetween(String value1, String value2) {
            addCriterion("docLoginProvince not between", value1, value2, "docloginprovince");
            return (Criteria) this;
        }

        public Criteria andDoclogincityIsNull() {
            addCriterion("docLoginCity is null");
            return (Criteria) this;
        }

        public Criteria andDoclogincityIsNotNull() {
            addCriterion("docLoginCity is not null");
            return (Criteria) this;
        }

        public Criteria andDoclogincityEqualTo(String value) {
            addCriterion("docLoginCity =", value, "doclogincity");
            return (Criteria) this;
        }

        public Criteria andDoclogincityNotEqualTo(String value) {
            addCriterion("docLoginCity <>", value, "doclogincity");
            return (Criteria) this;
        }

        public Criteria andDoclogincityGreaterThan(String value) {
            addCriterion("docLoginCity >", value, "doclogincity");
            return (Criteria) this;
        }

        public Criteria andDoclogincityGreaterThanOrEqualTo(String value) {
            addCriterion("docLoginCity >=", value, "doclogincity");
            return (Criteria) this;
        }

        public Criteria andDoclogincityLessThan(String value) {
            addCriterion("docLoginCity <", value, "doclogincity");
            return (Criteria) this;
        }

        public Criteria andDoclogincityLessThanOrEqualTo(String value) {
            addCriterion("docLoginCity <=", value, "doclogincity");
            return (Criteria) this;
        }

        public Criteria andDoclogincityLike(String value) {
            addCriterion("docLoginCity like", value, "doclogincity");
            return (Criteria) this;
        }

        public Criteria andDoclogincityNotLike(String value) {
            addCriterion("docLoginCity not like", value, "doclogincity");
            return (Criteria) this;
        }

        public Criteria andDoclogincityIn(List<String> values) {
            addCriterion("docLoginCity in", values, "doclogincity");
            return (Criteria) this;
        }

        public Criteria andDoclogincityNotIn(List<String> values) {
            addCriterion("docLoginCity not in", values, "doclogincity");
            return (Criteria) this;
        }

        public Criteria andDoclogincityBetween(String value1, String value2) {
            addCriterion("docLoginCity between", value1, value2, "doclogincity");
            return (Criteria) this;
        }

        public Criteria andDoclogincityNotBetween(String value1, String value2) {
            addCriterion("docLoginCity not between", value1, value2, "doclogincity");
            return (Criteria) this;
        }

        public Criteria andDocloginareaIsNull() {
            addCriterion("docLoginArea is null");
            return (Criteria) this;
        }

        public Criteria andDocloginareaIsNotNull() {
            addCriterion("docLoginArea is not null");
            return (Criteria) this;
        }

        public Criteria andDocloginareaEqualTo(String value) {
            addCriterion("docLoginArea =", value, "docloginarea");
            return (Criteria) this;
        }

        public Criteria andDocloginareaNotEqualTo(String value) {
            addCriterion("docLoginArea <>", value, "docloginarea");
            return (Criteria) this;
        }

        public Criteria andDocloginareaGreaterThan(String value) {
            addCriterion("docLoginArea >", value, "docloginarea");
            return (Criteria) this;
        }

        public Criteria andDocloginareaGreaterThanOrEqualTo(String value) {
            addCriterion("docLoginArea >=", value, "docloginarea");
            return (Criteria) this;
        }

        public Criteria andDocloginareaLessThan(String value) {
            addCriterion("docLoginArea <", value, "docloginarea");
            return (Criteria) this;
        }

        public Criteria andDocloginareaLessThanOrEqualTo(String value) {
            addCriterion("docLoginArea <=", value, "docloginarea");
            return (Criteria) this;
        }

        public Criteria andDocloginareaLike(String value) {
            addCriterion("docLoginArea like", value, "docloginarea");
            return (Criteria) this;
        }

        public Criteria andDocloginareaNotLike(String value) {
            addCriterion("docLoginArea not like", value, "docloginarea");
            return (Criteria) this;
        }

        public Criteria andDocloginareaIn(List<String> values) {
            addCriterion("docLoginArea in", values, "docloginarea");
            return (Criteria) this;
        }

        public Criteria andDocloginareaNotIn(List<String> values) {
            addCriterion("docLoginArea not in", values, "docloginarea");
            return (Criteria) this;
        }

        public Criteria andDocloginareaBetween(String value1, String value2) {
            addCriterion("docLoginArea between", value1, value2, "docloginarea");
            return (Criteria) this;
        }

        public Criteria andDocloginareaNotBetween(String value1, String value2) {
            addCriterion("docLoginArea not between", value1, value2, "docloginarea");
            return (Criteria) this;
        }

        public Criteria andDocloginotherIsNull() {
            addCriterion("docLoginOther is null");
            return (Criteria) this;
        }

        public Criteria andDocloginotherIsNotNull() {
            addCriterion("docLoginOther is not null");
            return (Criteria) this;
        }

        public Criteria andDocloginotherEqualTo(String value) {
            addCriterion("docLoginOther =", value, "docloginother");
            return (Criteria) this;
        }

        public Criteria andDocloginotherNotEqualTo(String value) {
            addCriterion("docLoginOther <>", value, "docloginother");
            return (Criteria) this;
        }

        public Criteria andDocloginotherGreaterThan(String value) {
            addCriterion("docLoginOther >", value, "docloginother");
            return (Criteria) this;
        }

        public Criteria andDocloginotherGreaterThanOrEqualTo(String value) {
            addCriterion("docLoginOther >=", value, "docloginother");
            return (Criteria) this;
        }

        public Criteria andDocloginotherLessThan(String value) {
            addCriterion("docLoginOther <", value, "docloginother");
            return (Criteria) this;
        }

        public Criteria andDocloginotherLessThanOrEqualTo(String value) {
            addCriterion("docLoginOther <=", value, "docloginother");
            return (Criteria) this;
        }

        public Criteria andDocloginotherLike(String value) {
            addCriterion("docLoginOther like", value, "docloginother");
            return (Criteria) this;
        }

        public Criteria andDocloginotherNotLike(String value) {
            addCriterion("docLoginOther not like", value, "docloginother");
            return (Criteria) this;
        }

        public Criteria andDocloginotherIn(List<String> values) {
            addCriterion("docLoginOther in", values, "docloginother");
            return (Criteria) this;
        }

        public Criteria andDocloginotherNotIn(List<String> values) {
            addCriterion("docLoginOther not in", values, "docloginother");
            return (Criteria) this;
        }

        public Criteria andDocloginotherBetween(String value1, String value2) {
            addCriterion("docLoginOther between", value1, value2, "docloginother");
            return (Criteria) this;
        }

        public Criteria andDocloginotherNotBetween(String value1, String value2) {
            addCriterion("docLoginOther not between", value1, value2, "docloginother");
            return (Criteria) this;
        }

        public Criteria andDoclogindevIsNull() {
            addCriterion("docLoginDev is null");
            return (Criteria) this;
        }

        public Criteria andDoclogindevIsNotNull() {
            addCriterion("docLoginDev is not null");
            return (Criteria) this;
        }

        public Criteria andDoclogindevEqualTo(String value) {
            addCriterion("docLoginDev =", value, "doclogindev");
            return (Criteria) this;
        }

        public Criteria andDoclogindevNotEqualTo(String value) {
            addCriterion("docLoginDev <>", value, "doclogindev");
            return (Criteria) this;
        }

        public Criteria andDoclogindevGreaterThan(String value) {
            addCriterion("docLoginDev >", value, "doclogindev");
            return (Criteria) this;
        }

        public Criteria andDoclogindevGreaterThanOrEqualTo(String value) {
            addCriterion("docLoginDev >=", value, "doclogindev");
            return (Criteria) this;
        }

        public Criteria andDoclogindevLessThan(String value) {
            addCriterion("docLoginDev <", value, "doclogindev");
            return (Criteria) this;
        }

        public Criteria andDoclogindevLessThanOrEqualTo(String value) {
            addCriterion("docLoginDev <=", value, "doclogindev");
            return (Criteria) this;
        }

        public Criteria andDoclogindevLike(String value) {
            addCriterion("docLoginDev like", value, "doclogindev");
            return (Criteria) this;
        }

        public Criteria andDoclogindevNotLike(String value) {
            addCriterion("docLoginDev not like", value, "doclogindev");
            return (Criteria) this;
        }

        public Criteria andDoclogindevIn(List<String> values) {
            addCriterion("docLoginDev in", values, "doclogindev");
            return (Criteria) this;
        }

        public Criteria andDoclogindevNotIn(List<String> values) {
            addCriterion("docLoginDev not in", values, "doclogindev");
            return (Criteria) this;
        }

        public Criteria andDoclogindevBetween(String value1, String value2) {
            addCriterion("docLoginDev between", value1, value2, "doclogindev");
            return (Criteria) this;
        }

        public Criteria andDoclogindevNotBetween(String value1, String value2) {
            addCriterion("docLoginDev not between", value1, value2, "doclogindev");
            return (Criteria) this;
        }

        public Criteria andDocloginbverIsNull() {
            addCriterion("docLoginBVer is null");
            return (Criteria) this;
        }

        public Criteria andDocloginbverIsNotNull() {
            addCriterion("docLoginBVer is not null");
            return (Criteria) this;
        }

        public Criteria andDocloginbverEqualTo(String value) {
            addCriterion("docLoginBVer =", value, "docloginbver");
            return (Criteria) this;
        }

        public Criteria andDocloginbverNotEqualTo(String value) {
            addCriterion("docLoginBVer <>", value, "docloginbver");
            return (Criteria) this;
        }

        public Criteria andDocloginbverGreaterThan(String value) {
            addCriterion("docLoginBVer >", value, "docloginbver");
            return (Criteria) this;
        }

        public Criteria andDocloginbverGreaterThanOrEqualTo(String value) {
            addCriterion("docLoginBVer >=", value, "docloginbver");
            return (Criteria) this;
        }

        public Criteria andDocloginbverLessThan(String value) {
            addCriterion("docLoginBVer <", value, "docloginbver");
            return (Criteria) this;
        }

        public Criteria andDocloginbverLessThanOrEqualTo(String value) {
            addCriterion("docLoginBVer <=", value, "docloginbver");
            return (Criteria) this;
        }

        public Criteria andDocloginbverLike(String value) {
            addCriterion("docLoginBVer like", value, "docloginbver");
            return (Criteria) this;
        }

        public Criteria andDocloginbverNotLike(String value) {
            addCriterion("docLoginBVer not like", value, "docloginbver");
            return (Criteria) this;
        }

        public Criteria andDocloginbverIn(List<String> values) {
            addCriterion("docLoginBVer in", values, "docloginbver");
            return (Criteria) this;
        }

        public Criteria andDocloginbverNotIn(List<String> values) {
            addCriterion("docLoginBVer not in", values, "docloginbver");
            return (Criteria) this;
        }

        public Criteria andDocloginbverBetween(String value1, String value2) {
            addCriterion("docLoginBVer between", value1, value2, "docloginbver");
            return (Criteria) this;
        }

        public Criteria andDocloginbverNotBetween(String value1, String value2) {
            addCriterion("docLoginBVer not between", value1, value2, "docloginbver");
            return (Criteria) this;
        }

        public Criteria andDocloginmodelIsNull() {
            addCriterion("docLoginModel is null");
            return (Criteria) this;
        }

        public Criteria andDocloginmodelIsNotNull() {
            addCriterion("docLoginModel is not null");
            return (Criteria) this;
        }

        public Criteria andDocloginmodelEqualTo(String value) {
            addCriterion("docLoginModel =", value, "docloginmodel");
            return (Criteria) this;
        }

        public Criteria andDocloginmodelNotEqualTo(String value) {
            addCriterion("docLoginModel <>", value, "docloginmodel");
            return (Criteria) this;
        }

        public Criteria andDocloginmodelGreaterThan(String value) {
            addCriterion("docLoginModel >", value, "docloginmodel");
            return (Criteria) this;
        }

        public Criteria andDocloginmodelGreaterThanOrEqualTo(String value) {
            addCriterion("docLoginModel >=", value, "docloginmodel");
            return (Criteria) this;
        }

        public Criteria andDocloginmodelLessThan(String value) {
            addCriterion("docLoginModel <", value, "docloginmodel");
            return (Criteria) this;
        }

        public Criteria andDocloginmodelLessThanOrEqualTo(String value) {
            addCriterion("docLoginModel <=", value, "docloginmodel");
            return (Criteria) this;
        }

        public Criteria andDocloginmodelLike(String value) {
            addCriterion("docLoginModel like", value, "docloginmodel");
            return (Criteria) this;
        }

        public Criteria andDocloginmodelNotLike(String value) {
            addCriterion("docLoginModel not like", value, "docloginmodel");
            return (Criteria) this;
        }

        public Criteria andDocloginmodelIn(List<String> values) {
            addCriterion("docLoginModel in", values, "docloginmodel");
            return (Criteria) this;
        }

        public Criteria andDocloginmodelNotIn(List<String> values) {
            addCriterion("docLoginModel not in", values, "docloginmodel");
            return (Criteria) this;
        }

        public Criteria andDocloginmodelBetween(String value1, String value2) {
            addCriterion("docLoginModel between", value1, value2, "docloginmodel");
            return (Criteria) this;
        }

        public Criteria andDocloginmodelNotBetween(String value1, String value2) {
            addCriterion("docLoginModel not between", value1, value2, "docloginmodel");
            return (Criteria) this;
        }

        public Criteria andDocloginpverIsNull() {
            addCriterion("docLoginPVer is null");
            return (Criteria) this;
        }

        public Criteria andDocloginpverIsNotNull() {
            addCriterion("docLoginPVer is not null");
            return (Criteria) this;
        }

        public Criteria andDocloginpverEqualTo(String value) {
            addCriterion("docLoginPVer =", value, "docloginpver");
            return (Criteria) this;
        }

        public Criteria andDocloginpverNotEqualTo(String value) {
            addCriterion("docLoginPVer <>", value, "docloginpver");
            return (Criteria) this;
        }

        public Criteria andDocloginpverGreaterThan(String value) {
            addCriterion("docLoginPVer >", value, "docloginpver");
            return (Criteria) this;
        }

        public Criteria andDocloginpverGreaterThanOrEqualTo(String value) {
            addCriterion("docLoginPVer >=", value, "docloginpver");
            return (Criteria) this;
        }

        public Criteria andDocloginpverLessThan(String value) {
            addCriterion("docLoginPVer <", value, "docloginpver");
            return (Criteria) this;
        }

        public Criteria andDocloginpverLessThanOrEqualTo(String value) {
            addCriterion("docLoginPVer <=", value, "docloginpver");
            return (Criteria) this;
        }

        public Criteria andDocloginpverLike(String value) {
            addCriterion("docLoginPVer like", value, "docloginpver");
            return (Criteria) this;
        }

        public Criteria andDocloginpverNotLike(String value) {
            addCriterion("docLoginPVer not like", value, "docloginpver");
            return (Criteria) this;
        }

        public Criteria andDocloginpverIn(List<String> values) {
            addCriterion("docLoginPVer in", values, "docloginpver");
            return (Criteria) this;
        }

        public Criteria andDocloginpverNotIn(List<String> values) {
            addCriterion("docLoginPVer not in", values, "docloginpver");
            return (Criteria) this;
        }

        public Criteria andDocloginpverBetween(String value1, String value2) {
            addCriterion("docLoginPVer between", value1, value2, "docloginpver");
            return (Criteria) this;
        }

        public Criteria andDocloginpverNotBetween(String value1, String value2) {
            addCriterion("docLoginPVer not between", value1, value2, "docloginpver");
            return (Criteria) this;
        }

        public Criteria andDocloginmacIsNull() {
            addCriterion("docLoginMac is null");
            return (Criteria) this;
        }

        public Criteria andDocloginmacIsNotNull() {
            addCriterion("docLoginMac is not null");
            return (Criteria) this;
        }

        public Criteria andDocloginmacEqualTo(String value) {
            addCriterion("docLoginMac =", value, "docloginmac");
            return (Criteria) this;
        }

        public Criteria andDocloginmacNotEqualTo(String value) {
            addCriterion("docLoginMac <>", value, "docloginmac");
            return (Criteria) this;
        }

        public Criteria andDocloginmacGreaterThan(String value) {
            addCriterion("docLoginMac >", value, "docloginmac");
            return (Criteria) this;
        }

        public Criteria andDocloginmacGreaterThanOrEqualTo(String value) {
            addCriterion("docLoginMac >=", value, "docloginmac");
            return (Criteria) this;
        }

        public Criteria andDocloginmacLessThan(String value) {
            addCriterion("docLoginMac <", value, "docloginmac");
            return (Criteria) this;
        }

        public Criteria andDocloginmacLessThanOrEqualTo(String value) {
            addCriterion("docLoginMac <=", value, "docloginmac");
            return (Criteria) this;
        }

        public Criteria andDocloginmacLike(String value) {
            addCriterion("docLoginMac like", value, "docloginmac");
            return (Criteria) this;
        }

        public Criteria andDocloginmacNotLike(String value) {
            addCriterion("docLoginMac not like", value, "docloginmac");
            return (Criteria) this;
        }

        public Criteria andDocloginmacIn(List<String> values) {
            addCriterion("docLoginMac in", values, "docloginmac");
            return (Criteria) this;
        }

        public Criteria andDocloginmacNotIn(List<String> values) {
            addCriterion("docLoginMac not in", values, "docloginmac");
            return (Criteria) this;
        }

        public Criteria andDocloginmacBetween(String value1, String value2) {
            addCriterion("docLoginMac between", value1, value2, "docloginmac");
            return (Criteria) this;
        }

        public Criteria andDocloginmacNotBetween(String value1, String value2) {
            addCriterion("docLoginMac not between", value1, value2, "docloginmac");
            return (Criteria) this;
        }

        public Criteria andDocloginipIsNull() {
            addCriterion("docLoginIp is null");
            return (Criteria) this;
        }

        public Criteria andDocloginipIsNotNull() {
            addCriterion("docLoginIp is not null");
            return (Criteria) this;
        }

        public Criteria andDocloginipEqualTo(String value) {
            addCriterion("docLoginIp =", value, "docloginip");
            return (Criteria) this;
        }

        public Criteria andDocloginipNotEqualTo(String value) {
            addCriterion("docLoginIp <>", value, "docloginip");
            return (Criteria) this;
        }

        public Criteria andDocloginipGreaterThan(String value) {
            addCriterion("docLoginIp >", value, "docloginip");
            return (Criteria) this;
        }

        public Criteria andDocloginipGreaterThanOrEqualTo(String value) {
            addCriterion("docLoginIp >=", value, "docloginip");
            return (Criteria) this;
        }

        public Criteria andDocloginipLessThan(String value) {
            addCriterion("docLoginIp <", value, "docloginip");
            return (Criteria) this;
        }

        public Criteria andDocloginipLessThanOrEqualTo(String value) {
            addCriterion("docLoginIp <=", value, "docloginip");
            return (Criteria) this;
        }

        public Criteria andDocloginipLike(String value) {
            addCriterion("docLoginIp like", value, "docloginip");
            return (Criteria) this;
        }

        public Criteria andDocloginipNotLike(String value) {
            addCriterion("docLoginIp not like", value, "docloginip");
            return (Criteria) this;
        }

        public Criteria andDocloginipIn(List<String> values) {
            addCriterion("docLoginIp in", values, "docloginip");
            return (Criteria) this;
        }

        public Criteria andDocloginipNotIn(List<String> values) {
            addCriterion("docLoginIp not in", values, "docloginip");
            return (Criteria) this;
        }

        public Criteria andDocloginipBetween(String value1, String value2) {
            addCriterion("docLoginIp between", value1, value2, "docloginip");
            return (Criteria) this;
        }

        public Criteria andDocloginipNotBetween(String value1, String value2) {
            addCriterion("docLoginIp not between", value1, value2, "docloginip");
            return (Criteria) this;
        }

        public Criteria andDoclogintypeIsNull() {
            addCriterion("docLoginType is null");
            return (Criteria) this;
        }

        public Criteria andDoclogintypeIsNotNull() {
            addCriterion("docLoginType is not null");
            return (Criteria) this;
        }

        public Criteria andDoclogintypeEqualTo(Boolean value) {
            addCriterion("docLoginType =", value, "doclogintype");
            return (Criteria) this;
        }

        public Criteria andDoclogintypeNotEqualTo(Boolean value) {
            addCriterion("docLoginType <>", value, "doclogintype");
            return (Criteria) this;
        }

        public Criteria andDoclogintypeGreaterThan(Boolean value) {
            addCriterion("docLoginType >", value, "doclogintype");
            return (Criteria) this;
        }

        public Criteria andDoclogintypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("docLoginType >=", value, "doclogintype");
            return (Criteria) this;
        }

        public Criteria andDoclogintypeLessThan(Boolean value) {
            addCriterion("docLoginType <", value, "doclogintype");
            return (Criteria) this;
        }

        public Criteria andDoclogintypeLessThanOrEqualTo(Boolean value) {
            addCriterion("docLoginType <=", value, "doclogintype");
            return (Criteria) this;
        }

        public Criteria andDoclogintypeIn(List<Boolean> values) {
            addCriterion("docLoginType in", values, "doclogintype");
            return (Criteria) this;
        }

        public Criteria andDoclogintypeNotIn(List<Boolean> values) {
            addCriterion("docLoginType not in", values, "doclogintype");
            return (Criteria) this;
        }

        public Criteria andDoclogintypeBetween(Boolean value1, Boolean value2) {
            addCriterion("docLoginType between", value1, value2, "doclogintype");
            return (Criteria) this;
        }

        public Criteria andDoclogintypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("docLoginType not between", value1, value2, "doclogintype");
            return (Criteria) this;
        }

        public Criteria andDocloginpixIsNull() {
            addCriterion("docLoginPix is null");
            return (Criteria) this;
        }

        public Criteria andDocloginpixIsNotNull() {
            addCriterion("docLoginPix is not null");
            return (Criteria) this;
        }

        public Criteria andDocloginpixEqualTo(String value) {
            addCriterion("docLoginPix =", value, "docloginpix");
            return (Criteria) this;
        }

        public Criteria andDocloginpixNotEqualTo(String value) {
            addCriterion("docLoginPix <>", value, "docloginpix");
            return (Criteria) this;
        }

        public Criteria andDocloginpixGreaterThan(String value) {
            addCriterion("docLoginPix >", value, "docloginpix");
            return (Criteria) this;
        }

        public Criteria andDocloginpixGreaterThanOrEqualTo(String value) {
            addCriterion("docLoginPix >=", value, "docloginpix");
            return (Criteria) this;
        }

        public Criteria andDocloginpixLessThan(String value) {
            addCriterion("docLoginPix <", value, "docloginpix");
            return (Criteria) this;
        }

        public Criteria andDocloginpixLessThanOrEqualTo(String value) {
            addCriterion("docLoginPix <=", value, "docloginpix");
            return (Criteria) this;
        }

        public Criteria andDocloginpixLike(String value) {
            addCriterion("docLoginPix like", value, "docloginpix");
            return (Criteria) this;
        }

        public Criteria andDocloginpixNotLike(String value) {
            addCriterion("docLoginPix not like", value, "docloginpix");
            return (Criteria) this;
        }

        public Criteria andDocloginpixIn(List<String> values) {
            addCriterion("docLoginPix in", values, "docloginpix");
            return (Criteria) this;
        }

        public Criteria andDocloginpixNotIn(List<String> values) {
            addCriterion("docLoginPix not in", values, "docloginpix");
            return (Criteria) this;
        }

        public Criteria andDocloginpixBetween(String value1, String value2) {
            addCriterion("docLoginPix between", value1, value2, "docloginpix");
            return (Criteria) this;
        }

        public Criteria andDocloginpixNotBetween(String value1, String value2) {
            addCriterion("docLoginPix not between", value1, value2, "docloginpix");
            return (Criteria) this;
        }

        public Criteria andDoclogincidIsNull() {
            addCriterion("docLoginCId is null");
            return (Criteria) this;
        }

        public Criteria andDoclogincidIsNotNull() {
            addCriterion("docLoginCId is not null");
            return (Criteria) this;
        }

        public Criteria andDoclogincidEqualTo(String value) {
            addCriterion("docLoginCId =", value, "doclogincid");
            return (Criteria) this;
        }

        public Criteria andDoclogincidNotEqualTo(String value) {
            addCriterion("docLoginCId <>", value, "doclogincid");
            return (Criteria) this;
        }

        public Criteria andDoclogincidGreaterThan(String value) {
            addCriterion("docLoginCId >", value, "doclogincid");
            return (Criteria) this;
        }

        public Criteria andDoclogincidGreaterThanOrEqualTo(String value) {
            addCriterion("docLoginCId >=", value, "doclogincid");
            return (Criteria) this;
        }

        public Criteria andDoclogincidLessThan(String value) {
            addCriterion("docLoginCId <", value, "doclogincid");
            return (Criteria) this;
        }

        public Criteria andDoclogincidLessThanOrEqualTo(String value) {
            addCriterion("docLoginCId <=", value, "doclogincid");
            return (Criteria) this;
        }

        public Criteria andDoclogincidLike(String value) {
            addCriterion("docLoginCId like", value, "doclogincid");
            return (Criteria) this;
        }

        public Criteria andDoclogincidNotLike(String value) {
            addCriterion("docLoginCId not like", value, "doclogincid");
            return (Criteria) this;
        }

        public Criteria andDoclogincidIn(List<String> values) {
            addCriterion("docLoginCId in", values, "doclogincid");
            return (Criteria) this;
        }

        public Criteria andDoclogincidNotIn(List<String> values) {
            addCriterion("docLoginCId not in", values, "doclogincid");
            return (Criteria) this;
        }

        public Criteria andDoclogincidBetween(String value1, String value2) {
            addCriterion("docLoginCId between", value1, value2, "doclogincid");
            return (Criteria) this;
        }

        public Criteria andDoclogincidNotBetween(String value1, String value2) {
            addCriterion("docLoginCId not between", value1, value2, "doclogincid");
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