package com.medical.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserlogininfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserlogininfoExample() {
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

        public Criteria andUserhuanxinaccountIsNull() {
            addCriterion("userHuanXinAccount is null");
            return (Criteria) this;
        }

        public Criteria andUserhuanxinaccountIsNotNull() {
            addCriterion("userHuanXinAccount is not null");
            return (Criteria) this;
        }

        public Criteria andUserhuanxinaccountEqualTo(String value) {
            addCriterion("userHuanXinAccount =", value, "userhuanxinaccount");
            return (Criteria) this;
        }

        public Criteria andUserhuanxinaccountNotEqualTo(String value) {
            addCriterion("userHuanXinAccount <>", value, "userhuanxinaccount");
            return (Criteria) this;
        }

        public Criteria andUserhuanxinaccountGreaterThan(String value) {
            addCriterion("userHuanXinAccount >", value, "userhuanxinaccount");
            return (Criteria) this;
        }

        public Criteria andUserhuanxinaccountGreaterThanOrEqualTo(String value) {
            addCriterion("userHuanXinAccount >=", value, "userhuanxinaccount");
            return (Criteria) this;
        }

        public Criteria andUserhuanxinaccountLessThan(String value) {
            addCriterion("userHuanXinAccount <", value, "userhuanxinaccount");
            return (Criteria) this;
        }

        public Criteria andUserhuanxinaccountLessThanOrEqualTo(String value) {
            addCriterion("userHuanXinAccount <=", value, "userhuanxinaccount");
            return (Criteria) this;
        }

        public Criteria andUserhuanxinaccountLike(String value) {
            addCriterion("userHuanXinAccount like", value, "userhuanxinaccount");
            return (Criteria) this;
        }

        public Criteria andUserhuanxinaccountNotLike(String value) {
            addCriterion("userHuanXinAccount not like", value, "userhuanxinaccount");
            return (Criteria) this;
        }

        public Criteria andUserhuanxinaccountIn(List<String> values) {
            addCriterion("userHuanXinAccount in", values, "userhuanxinaccount");
            return (Criteria) this;
        }

        public Criteria andUserhuanxinaccountNotIn(List<String> values) {
            addCriterion("userHuanXinAccount not in", values, "userhuanxinaccount");
            return (Criteria) this;
        }

        public Criteria andUserhuanxinaccountBetween(String value1, String value2) {
            addCriterion("userHuanXinAccount between", value1, value2, "userhuanxinaccount");
            return (Criteria) this;
        }

        public Criteria andUserhuanxinaccountNotBetween(String value1, String value2) {
            addCriterion("userHuanXinAccount not between", value1, value2, "userhuanxinaccount");
            return (Criteria) this;
        }

        public Criteria andUserloginnameIsNull() {
            addCriterion("userLoginName is null");
            return (Criteria) this;
        }

        public Criteria andUserloginnameIsNotNull() {
            addCriterion("userLoginName is not null");
            return (Criteria) this;
        }

        public Criteria andUserloginnameEqualTo(String value) {
            addCriterion("userLoginName =", value, "userloginname");
            return (Criteria) this;
        }

        public Criteria andUserloginnameNotEqualTo(String value) {
            addCriterion("userLoginName <>", value, "userloginname");
            return (Criteria) this;
        }

        public Criteria andUserloginnameGreaterThan(String value) {
            addCriterion("userLoginName >", value, "userloginname");
            return (Criteria) this;
        }

        public Criteria andUserloginnameGreaterThanOrEqualTo(String value) {
            addCriterion("userLoginName >=", value, "userloginname");
            return (Criteria) this;
        }

        public Criteria andUserloginnameLessThan(String value) {
            addCriterion("userLoginName <", value, "userloginname");
            return (Criteria) this;
        }

        public Criteria andUserloginnameLessThanOrEqualTo(String value) {
            addCriterion("userLoginName <=", value, "userloginname");
            return (Criteria) this;
        }

        public Criteria andUserloginnameLike(String value) {
            addCriterion("userLoginName like", value, "userloginname");
            return (Criteria) this;
        }

        public Criteria andUserloginnameNotLike(String value) {
            addCriterion("userLoginName not like", value, "userloginname");
            return (Criteria) this;
        }

        public Criteria andUserloginnameIn(List<String> values) {
            addCriterion("userLoginName in", values, "userloginname");
            return (Criteria) this;
        }

        public Criteria andUserloginnameNotIn(List<String> values) {
            addCriterion("userLoginName not in", values, "userloginname");
            return (Criteria) this;
        }

        public Criteria andUserloginnameBetween(String value1, String value2) {
            addCriterion("userLoginName between", value1, value2, "userloginname");
            return (Criteria) this;
        }

        public Criteria andUserloginnameNotBetween(String value1, String value2) {
            addCriterion("userLoginName not between", value1, value2, "userloginname");
            return (Criteria) this;
        }

        public Criteria andUserloginphoneIsNull() {
            addCriterion("userLoginPhone is null");
            return (Criteria) this;
        }

        public Criteria andUserloginphoneIsNotNull() {
            addCriterion("userLoginPhone is not null");
            return (Criteria) this;
        }

        public Criteria andUserloginphoneEqualTo(String value) {
            addCriterion("userLoginPhone =", value, "userloginphone");
            return (Criteria) this;
        }

        public Criteria andUserloginphoneNotEqualTo(String value) {
            addCriterion("userLoginPhone <>", value, "userloginphone");
            return (Criteria) this;
        }

        public Criteria andUserloginphoneGreaterThan(String value) {
            addCriterion("userLoginPhone >", value, "userloginphone");
            return (Criteria) this;
        }

        public Criteria andUserloginphoneGreaterThanOrEqualTo(String value) {
            addCriterion("userLoginPhone >=", value, "userloginphone");
            return (Criteria) this;
        }

        public Criteria andUserloginphoneLessThan(String value) {
            addCriterion("userLoginPhone <", value, "userloginphone");
            return (Criteria) this;
        }

        public Criteria andUserloginphoneLessThanOrEqualTo(String value) {
            addCriterion("userLoginPhone <=", value, "userloginphone");
            return (Criteria) this;
        }

        public Criteria andUserloginphoneLike(String value) {
            addCriterion("userLoginPhone like", value, "userloginphone");
            return (Criteria) this;
        }

        public Criteria andUserloginphoneNotLike(String value) {
            addCriterion("userLoginPhone not like", value, "userloginphone");
            return (Criteria) this;
        }

        public Criteria andUserloginphoneIn(List<String> values) {
            addCriterion("userLoginPhone in", values, "userloginphone");
            return (Criteria) this;
        }

        public Criteria andUserloginphoneNotIn(List<String> values) {
            addCriterion("userLoginPhone not in", values, "userloginphone");
            return (Criteria) this;
        }

        public Criteria andUserloginphoneBetween(String value1, String value2) {
            addCriterion("userLoginPhone between", value1, value2, "userloginphone");
            return (Criteria) this;
        }

        public Criteria andUserloginphoneNotBetween(String value1, String value2) {
            addCriterion("userLoginPhone not between", value1, value2, "userloginphone");
            return (Criteria) this;
        }

        public Criteria andUserloginpwdIsNull() {
            addCriterion("userLoginPwd is null");
            return (Criteria) this;
        }

        public Criteria andUserloginpwdIsNotNull() {
            addCriterion("userLoginPwd is not null");
            return (Criteria) this;
        }

        public Criteria andUserloginpwdEqualTo(String value) {
            addCriterion("userLoginPwd =", value, "userloginpwd");
            return (Criteria) this;
        }

        public Criteria andUserloginpwdNotEqualTo(String value) {
            addCriterion("userLoginPwd <>", value, "userloginpwd");
            return (Criteria) this;
        }

        public Criteria andUserloginpwdGreaterThan(String value) {
            addCriterion("userLoginPwd >", value, "userloginpwd");
            return (Criteria) this;
        }

        public Criteria andUserloginpwdGreaterThanOrEqualTo(String value) {
            addCriterion("userLoginPwd >=", value, "userloginpwd");
            return (Criteria) this;
        }

        public Criteria andUserloginpwdLessThan(String value) {
            addCriterion("userLoginPwd <", value, "userloginpwd");
            return (Criteria) this;
        }

        public Criteria andUserloginpwdLessThanOrEqualTo(String value) {
            addCriterion("userLoginPwd <=", value, "userloginpwd");
            return (Criteria) this;
        }

        public Criteria andUserloginpwdLike(String value) {
            addCriterion("userLoginPwd like", value, "userloginpwd");
            return (Criteria) this;
        }

        public Criteria andUserloginpwdNotLike(String value) {
            addCriterion("userLoginPwd not like", value, "userloginpwd");
            return (Criteria) this;
        }

        public Criteria andUserloginpwdIn(List<String> values) {
            addCriterion("userLoginPwd in", values, "userloginpwd");
            return (Criteria) this;
        }

        public Criteria andUserloginpwdNotIn(List<String> values) {
            addCriterion("userLoginPwd not in", values, "userloginpwd");
            return (Criteria) this;
        }

        public Criteria andUserloginpwdBetween(String value1, String value2) {
            addCriterion("userLoginPwd between", value1, value2, "userloginpwd");
            return (Criteria) this;
        }

        public Criteria andUserloginpwdNotBetween(String value1, String value2) {
            addCriterion("userLoginPwd not between", value1, value2, "userloginpwd");
            return (Criteria) this;
        }

        public Criteria andUserloginsaltIsNull() {
            addCriterion("userLoginSalt is null");
            return (Criteria) this;
        }

        public Criteria andUserloginsaltIsNotNull() {
            addCriterion("userLoginSalt is not null");
            return (Criteria) this;
        }

        public Criteria andUserloginsaltEqualTo(String value) {
            addCriterion("userLoginSalt =", value, "userloginsalt");
            return (Criteria) this;
        }

        public Criteria andUserloginsaltNotEqualTo(String value) {
            addCriterion("userLoginSalt <>", value, "userloginsalt");
            return (Criteria) this;
        }

        public Criteria andUserloginsaltGreaterThan(String value) {
            addCriterion("userLoginSalt >", value, "userloginsalt");
            return (Criteria) this;
        }

        public Criteria andUserloginsaltGreaterThanOrEqualTo(String value) {
            addCriterion("userLoginSalt >=", value, "userloginsalt");
            return (Criteria) this;
        }

        public Criteria andUserloginsaltLessThan(String value) {
            addCriterion("userLoginSalt <", value, "userloginsalt");
            return (Criteria) this;
        }

        public Criteria andUserloginsaltLessThanOrEqualTo(String value) {
            addCriterion("userLoginSalt <=", value, "userloginsalt");
            return (Criteria) this;
        }

        public Criteria andUserloginsaltLike(String value) {
            addCriterion("userLoginSalt like", value, "userloginsalt");
            return (Criteria) this;
        }

        public Criteria andUserloginsaltNotLike(String value) {
            addCriterion("userLoginSalt not like", value, "userloginsalt");
            return (Criteria) this;
        }

        public Criteria andUserloginsaltIn(List<String> values) {
            addCriterion("userLoginSalt in", values, "userloginsalt");
            return (Criteria) this;
        }

        public Criteria andUserloginsaltNotIn(List<String> values) {
            addCriterion("userLoginSalt not in", values, "userloginsalt");
            return (Criteria) this;
        }

        public Criteria andUserloginsaltBetween(String value1, String value2) {
            addCriterion("userLoginSalt between", value1, value2, "userloginsalt");
            return (Criteria) this;
        }

        public Criteria andUserloginsaltNotBetween(String value1, String value2) {
            addCriterion("userLoginSalt not between", value1, value2, "userloginsalt");
            return (Criteria) this;
        }

        public Criteria andUserlogintokenIsNull() {
            addCriterion("userLoginToken is null");
            return (Criteria) this;
        }

        public Criteria andUserlogintokenIsNotNull() {
            addCriterion("userLoginToken is not null");
            return (Criteria) this;
        }

        public Criteria andUserlogintokenEqualTo(String value) {
            addCriterion("userLoginToken =", value, "userlogintoken");
            return (Criteria) this;
        }

        public Criteria andUserlogintokenNotEqualTo(String value) {
            addCriterion("userLoginToken <>", value, "userlogintoken");
            return (Criteria) this;
        }

        public Criteria andUserlogintokenGreaterThan(String value) {
            addCriterion("userLoginToken >", value, "userlogintoken");
            return (Criteria) this;
        }

        public Criteria andUserlogintokenGreaterThanOrEqualTo(String value) {
            addCriterion("userLoginToken >=", value, "userlogintoken");
            return (Criteria) this;
        }

        public Criteria andUserlogintokenLessThan(String value) {
            addCriterion("userLoginToken <", value, "userlogintoken");
            return (Criteria) this;
        }

        public Criteria andUserlogintokenLessThanOrEqualTo(String value) {
            addCriterion("userLoginToken <=", value, "userlogintoken");
            return (Criteria) this;
        }

        public Criteria andUserlogintokenLike(String value) {
            addCriterion("userLoginToken like", value, "userlogintoken");
            return (Criteria) this;
        }

        public Criteria andUserlogintokenNotLike(String value) {
            addCriterion("userLoginToken not like", value, "userlogintoken");
            return (Criteria) this;
        }

        public Criteria andUserlogintokenIn(List<String> values) {
            addCriterion("userLoginToken in", values, "userlogintoken");
            return (Criteria) this;
        }

        public Criteria andUserlogintokenNotIn(List<String> values) {
            addCriterion("userLoginToken not in", values, "userlogintoken");
            return (Criteria) this;
        }

        public Criteria andUserlogintokenBetween(String value1, String value2) {
            addCriterion("userLoginToken between", value1, value2, "userlogintoken");
            return (Criteria) this;
        }

        public Criteria andUserlogintokenNotBetween(String value1, String value2) {
            addCriterion("userLoginToken not between", value1, value2, "userlogintoken");
            return (Criteria) this;
        }

        public Criteria andUserlogindldIsNull() {
            addCriterion("userLoginDld is null");
            return (Criteria) this;
        }

        public Criteria andUserlogindldIsNotNull() {
            addCriterion("userLoginDld is not null");
            return (Criteria) this;
        }

        public Criteria andUserlogindldEqualTo(Long value) {
            addCriterion("userLoginDld =", value, "userlogindld");
            return (Criteria) this;
        }

        public Criteria andUserlogindldNotEqualTo(Long value) {
            addCriterion("userLoginDld <>", value, "userlogindld");
            return (Criteria) this;
        }

        public Criteria andUserlogindldGreaterThan(Long value) {
            addCriterion("userLoginDld >", value, "userlogindld");
            return (Criteria) this;
        }

        public Criteria andUserlogindldGreaterThanOrEqualTo(Long value) {
            addCriterion("userLoginDld >=", value, "userlogindld");
            return (Criteria) this;
        }

        public Criteria andUserlogindldLessThan(Long value) {
            addCriterion("userLoginDld <", value, "userlogindld");
            return (Criteria) this;
        }

        public Criteria andUserlogindldLessThanOrEqualTo(Long value) {
            addCriterion("userLoginDld <=", value, "userlogindld");
            return (Criteria) this;
        }

        public Criteria andUserlogindldIn(List<Long> values) {
            addCriterion("userLoginDld in", values, "userlogindld");
            return (Criteria) this;
        }

        public Criteria andUserlogindldNotIn(List<Long> values) {
            addCriterion("userLoginDld not in", values, "userlogindld");
            return (Criteria) this;
        }

        public Criteria andUserlogindldBetween(Long value1, Long value2) {
            addCriterion("userLoginDld between", value1, value2, "userlogindld");
            return (Criteria) this;
        }

        public Criteria andUserlogindldNotBetween(Long value1, Long value2) {
            addCriterion("userLoginDld not between", value1, value2, "userlogindld");
            return (Criteria) this;
        }

        public Criteria andUserloginlonIsNull() {
            addCriterion("userLoginLon is null");
            return (Criteria) this;
        }

        public Criteria andUserloginlonIsNotNull() {
            addCriterion("userLoginLon is not null");
            return (Criteria) this;
        }

        public Criteria andUserloginlonEqualTo(String value) {
            addCriterion("userLoginLon =", value, "userloginlon");
            return (Criteria) this;
        }

        public Criteria andUserloginlonNotEqualTo(String value) {
            addCriterion("userLoginLon <>", value, "userloginlon");
            return (Criteria) this;
        }

        public Criteria andUserloginlonGreaterThan(String value) {
            addCriterion("userLoginLon >", value, "userloginlon");
            return (Criteria) this;
        }

        public Criteria andUserloginlonGreaterThanOrEqualTo(String value) {
            addCriterion("userLoginLon >=", value, "userloginlon");
            return (Criteria) this;
        }

        public Criteria andUserloginlonLessThan(String value) {
            addCriterion("userLoginLon <", value, "userloginlon");
            return (Criteria) this;
        }

        public Criteria andUserloginlonLessThanOrEqualTo(String value) {
            addCriterion("userLoginLon <=", value, "userloginlon");
            return (Criteria) this;
        }

        public Criteria andUserloginlonLike(String value) {
            addCriterion("userLoginLon like", value, "userloginlon");
            return (Criteria) this;
        }

        public Criteria andUserloginlonNotLike(String value) {
            addCriterion("userLoginLon not like", value, "userloginlon");
            return (Criteria) this;
        }

        public Criteria andUserloginlonIn(List<String> values) {
            addCriterion("userLoginLon in", values, "userloginlon");
            return (Criteria) this;
        }

        public Criteria andUserloginlonNotIn(List<String> values) {
            addCriterion("userLoginLon not in", values, "userloginlon");
            return (Criteria) this;
        }

        public Criteria andUserloginlonBetween(String value1, String value2) {
            addCriterion("userLoginLon between", value1, value2, "userloginlon");
            return (Criteria) this;
        }

        public Criteria andUserloginlonNotBetween(String value1, String value2) {
            addCriterion("userLoginLon not between", value1, value2, "userloginlon");
            return (Criteria) this;
        }

        public Criteria andUserloginlatIsNull() {
            addCriterion("userLoginLat is null");
            return (Criteria) this;
        }

        public Criteria andUserloginlatIsNotNull() {
            addCriterion("userLoginLat is not null");
            return (Criteria) this;
        }

        public Criteria andUserloginlatEqualTo(String value) {
            addCriterion("userLoginLat =", value, "userloginlat");
            return (Criteria) this;
        }

        public Criteria andUserloginlatNotEqualTo(String value) {
            addCriterion("userLoginLat <>", value, "userloginlat");
            return (Criteria) this;
        }

        public Criteria andUserloginlatGreaterThan(String value) {
            addCriterion("userLoginLat >", value, "userloginlat");
            return (Criteria) this;
        }

        public Criteria andUserloginlatGreaterThanOrEqualTo(String value) {
            addCriterion("userLoginLat >=", value, "userloginlat");
            return (Criteria) this;
        }

        public Criteria andUserloginlatLessThan(String value) {
            addCriterion("userLoginLat <", value, "userloginlat");
            return (Criteria) this;
        }

        public Criteria andUserloginlatLessThanOrEqualTo(String value) {
            addCriterion("userLoginLat <=", value, "userloginlat");
            return (Criteria) this;
        }

        public Criteria andUserloginlatLike(String value) {
            addCriterion("userLoginLat like", value, "userloginlat");
            return (Criteria) this;
        }

        public Criteria andUserloginlatNotLike(String value) {
            addCriterion("userLoginLat not like", value, "userloginlat");
            return (Criteria) this;
        }

        public Criteria andUserloginlatIn(List<String> values) {
            addCriterion("userLoginLat in", values, "userloginlat");
            return (Criteria) this;
        }

        public Criteria andUserloginlatNotIn(List<String> values) {
            addCriterion("userLoginLat not in", values, "userloginlat");
            return (Criteria) this;
        }

        public Criteria andUserloginlatBetween(String value1, String value2) {
            addCriterion("userLoginLat between", value1, value2, "userloginlat");
            return (Criteria) this;
        }

        public Criteria andUserloginlatNotBetween(String value1, String value2) {
            addCriterion("userLoginLat not between", value1, value2, "userloginlat");
            return (Criteria) this;
        }

        public Criteria andUserlogintimeIsNull() {
            addCriterion("userLoginTime is null");
            return (Criteria) this;
        }

        public Criteria andUserlogintimeIsNotNull() {
            addCriterion("userLoginTime is not null");
            return (Criteria) this;
        }

        public Criteria andUserlogintimeEqualTo(Date value) {
            addCriterion("userLoginTime =", value, "userlogintime");
            return (Criteria) this;
        }

        public Criteria andUserlogintimeNotEqualTo(Date value) {
            addCriterion("userLoginTime <>", value, "userlogintime");
            return (Criteria) this;
        }

        public Criteria andUserlogintimeGreaterThan(Date value) {
            addCriterion("userLoginTime >", value, "userlogintime");
            return (Criteria) this;
        }

        public Criteria andUserlogintimeGreaterThanOrEqualTo(Date value) {
            addCriterion("userLoginTime >=", value, "userlogintime");
            return (Criteria) this;
        }

        public Criteria andUserlogintimeLessThan(Date value) {
            addCriterion("userLoginTime <", value, "userlogintime");
            return (Criteria) this;
        }

        public Criteria andUserlogintimeLessThanOrEqualTo(Date value) {
            addCriterion("userLoginTime <=", value, "userlogintime");
            return (Criteria) this;
        }

        public Criteria andUserlogintimeIn(List<Date> values) {
            addCriterion("userLoginTime in", values, "userlogintime");
            return (Criteria) this;
        }

        public Criteria andUserlogintimeNotIn(List<Date> values) {
            addCriterion("userLoginTime not in", values, "userlogintime");
            return (Criteria) this;
        }

        public Criteria andUserlogintimeBetween(Date value1, Date value2) {
            addCriterion("userLoginTime between", value1, value2, "userlogintime");
            return (Criteria) this;
        }

        public Criteria andUserlogintimeNotBetween(Date value1, Date value2) {
            addCriterion("userLoginTime not between", value1, value2, "userlogintime");
            return (Criteria) this;
        }

        public Criteria andUserloginprovinceIsNull() {
            addCriterion("userLoginProvince is null");
            return (Criteria) this;
        }

        public Criteria andUserloginprovinceIsNotNull() {
            addCriterion("userLoginProvince is not null");
            return (Criteria) this;
        }

        public Criteria andUserloginprovinceEqualTo(String value) {
            addCriterion("userLoginProvince =", value, "userloginprovince");
            return (Criteria) this;
        }

        public Criteria andUserloginprovinceNotEqualTo(String value) {
            addCriterion("userLoginProvince <>", value, "userloginprovince");
            return (Criteria) this;
        }

        public Criteria andUserloginprovinceGreaterThan(String value) {
            addCriterion("userLoginProvince >", value, "userloginprovince");
            return (Criteria) this;
        }

        public Criteria andUserloginprovinceGreaterThanOrEqualTo(String value) {
            addCriterion("userLoginProvince >=", value, "userloginprovince");
            return (Criteria) this;
        }

        public Criteria andUserloginprovinceLessThan(String value) {
            addCriterion("userLoginProvince <", value, "userloginprovince");
            return (Criteria) this;
        }

        public Criteria andUserloginprovinceLessThanOrEqualTo(String value) {
            addCriterion("userLoginProvince <=", value, "userloginprovince");
            return (Criteria) this;
        }

        public Criteria andUserloginprovinceLike(String value) {
            addCriterion("userLoginProvince like", value, "userloginprovince");
            return (Criteria) this;
        }

        public Criteria andUserloginprovinceNotLike(String value) {
            addCriterion("userLoginProvince not like", value, "userloginprovince");
            return (Criteria) this;
        }

        public Criteria andUserloginprovinceIn(List<String> values) {
            addCriterion("userLoginProvince in", values, "userloginprovince");
            return (Criteria) this;
        }

        public Criteria andUserloginprovinceNotIn(List<String> values) {
            addCriterion("userLoginProvince not in", values, "userloginprovince");
            return (Criteria) this;
        }

        public Criteria andUserloginprovinceBetween(String value1, String value2) {
            addCriterion("userLoginProvince between", value1, value2, "userloginprovince");
            return (Criteria) this;
        }

        public Criteria andUserloginprovinceNotBetween(String value1, String value2) {
            addCriterion("userLoginProvince not between", value1, value2, "userloginprovince");
            return (Criteria) this;
        }

        public Criteria andUserlogincityIsNull() {
            addCriterion("userLoginCity is null");
            return (Criteria) this;
        }

        public Criteria andUserlogincityIsNotNull() {
            addCriterion("userLoginCity is not null");
            return (Criteria) this;
        }

        public Criteria andUserlogincityEqualTo(String value) {
            addCriterion("userLoginCity =", value, "userlogincity");
            return (Criteria) this;
        }

        public Criteria andUserlogincityNotEqualTo(String value) {
            addCriterion("userLoginCity <>", value, "userlogincity");
            return (Criteria) this;
        }

        public Criteria andUserlogincityGreaterThan(String value) {
            addCriterion("userLoginCity >", value, "userlogincity");
            return (Criteria) this;
        }

        public Criteria andUserlogincityGreaterThanOrEqualTo(String value) {
            addCriterion("userLoginCity >=", value, "userlogincity");
            return (Criteria) this;
        }

        public Criteria andUserlogincityLessThan(String value) {
            addCriterion("userLoginCity <", value, "userlogincity");
            return (Criteria) this;
        }

        public Criteria andUserlogincityLessThanOrEqualTo(String value) {
            addCriterion("userLoginCity <=", value, "userlogincity");
            return (Criteria) this;
        }

        public Criteria andUserlogincityLike(String value) {
            addCriterion("userLoginCity like", value, "userlogincity");
            return (Criteria) this;
        }

        public Criteria andUserlogincityNotLike(String value) {
            addCriterion("userLoginCity not like", value, "userlogincity");
            return (Criteria) this;
        }

        public Criteria andUserlogincityIn(List<String> values) {
            addCriterion("userLoginCity in", values, "userlogincity");
            return (Criteria) this;
        }

        public Criteria andUserlogincityNotIn(List<String> values) {
            addCriterion("userLoginCity not in", values, "userlogincity");
            return (Criteria) this;
        }

        public Criteria andUserlogincityBetween(String value1, String value2) {
            addCriterion("userLoginCity between", value1, value2, "userlogincity");
            return (Criteria) this;
        }

        public Criteria andUserlogincityNotBetween(String value1, String value2) {
            addCriterion("userLoginCity not between", value1, value2, "userlogincity");
            return (Criteria) this;
        }

        public Criteria andUserloginareaIsNull() {
            addCriterion("userLoginArea is null");
            return (Criteria) this;
        }

        public Criteria andUserloginareaIsNotNull() {
            addCriterion("userLoginArea is not null");
            return (Criteria) this;
        }

        public Criteria andUserloginareaEqualTo(String value) {
            addCriterion("userLoginArea =", value, "userloginarea");
            return (Criteria) this;
        }

        public Criteria andUserloginareaNotEqualTo(String value) {
            addCriterion("userLoginArea <>", value, "userloginarea");
            return (Criteria) this;
        }

        public Criteria andUserloginareaGreaterThan(String value) {
            addCriterion("userLoginArea >", value, "userloginarea");
            return (Criteria) this;
        }

        public Criteria andUserloginareaGreaterThanOrEqualTo(String value) {
            addCriterion("userLoginArea >=", value, "userloginarea");
            return (Criteria) this;
        }

        public Criteria andUserloginareaLessThan(String value) {
            addCriterion("userLoginArea <", value, "userloginarea");
            return (Criteria) this;
        }

        public Criteria andUserloginareaLessThanOrEqualTo(String value) {
            addCriterion("userLoginArea <=", value, "userloginarea");
            return (Criteria) this;
        }

        public Criteria andUserloginareaLike(String value) {
            addCriterion("userLoginArea like", value, "userloginarea");
            return (Criteria) this;
        }

        public Criteria andUserloginareaNotLike(String value) {
            addCriterion("userLoginArea not like", value, "userloginarea");
            return (Criteria) this;
        }

        public Criteria andUserloginareaIn(List<String> values) {
            addCriterion("userLoginArea in", values, "userloginarea");
            return (Criteria) this;
        }

        public Criteria andUserloginareaNotIn(List<String> values) {
            addCriterion("userLoginArea not in", values, "userloginarea");
            return (Criteria) this;
        }

        public Criteria andUserloginareaBetween(String value1, String value2) {
            addCriterion("userLoginArea between", value1, value2, "userloginarea");
            return (Criteria) this;
        }

        public Criteria andUserloginareaNotBetween(String value1, String value2) {
            addCriterion("userLoginArea not between", value1, value2, "userloginarea");
            return (Criteria) this;
        }

        public Criteria andUserloginotherIsNull() {
            addCriterion("userLoginOther is null");
            return (Criteria) this;
        }

        public Criteria andUserloginotherIsNotNull() {
            addCriterion("userLoginOther is not null");
            return (Criteria) this;
        }

        public Criteria andUserloginotherEqualTo(String value) {
            addCriterion("userLoginOther =", value, "userloginother");
            return (Criteria) this;
        }

        public Criteria andUserloginotherNotEqualTo(String value) {
            addCriterion("userLoginOther <>", value, "userloginother");
            return (Criteria) this;
        }

        public Criteria andUserloginotherGreaterThan(String value) {
            addCriterion("userLoginOther >", value, "userloginother");
            return (Criteria) this;
        }

        public Criteria andUserloginotherGreaterThanOrEqualTo(String value) {
            addCriterion("userLoginOther >=", value, "userloginother");
            return (Criteria) this;
        }

        public Criteria andUserloginotherLessThan(String value) {
            addCriterion("userLoginOther <", value, "userloginother");
            return (Criteria) this;
        }

        public Criteria andUserloginotherLessThanOrEqualTo(String value) {
            addCriterion("userLoginOther <=", value, "userloginother");
            return (Criteria) this;
        }

        public Criteria andUserloginotherLike(String value) {
            addCriterion("userLoginOther like", value, "userloginother");
            return (Criteria) this;
        }

        public Criteria andUserloginotherNotLike(String value) {
            addCriterion("userLoginOther not like", value, "userloginother");
            return (Criteria) this;
        }

        public Criteria andUserloginotherIn(List<String> values) {
            addCriterion("userLoginOther in", values, "userloginother");
            return (Criteria) this;
        }

        public Criteria andUserloginotherNotIn(List<String> values) {
            addCriterion("userLoginOther not in", values, "userloginother");
            return (Criteria) this;
        }

        public Criteria andUserloginotherBetween(String value1, String value2) {
            addCriterion("userLoginOther between", value1, value2, "userloginother");
            return (Criteria) this;
        }

        public Criteria andUserloginotherNotBetween(String value1, String value2) {
            addCriterion("userLoginOther not between", value1, value2, "userloginother");
            return (Criteria) this;
        }

        public Criteria andUserloginmodelIsNull() {
            addCriterion("userLoginModel is null");
            return (Criteria) this;
        }

        public Criteria andUserloginmodelIsNotNull() {
            addCriterion("userLoginModel is not null");
            return (Criteria) this;
        }

        public Criteria andUserloginmodelEqualTo(String value) {
            addCriterion("userLoginModel =", value, "userloginmodel");
            return (Criteria) this;
        }

        public Criteria andUserloginmodelNotEqualTo(String value) {
            addCriterion("userLoginModel <>", value, "userloginmodel");
            return (Criteria) this;
        }

        public Criteria andUserloginmodelGreaterThan(String value) {
            addCriterion("userLoginModel >", value, "userloginmodel");
            return (Criteria) this;
        }

        public Criteria andUserloginmodelGreaterThanOrEqualTo(String value) {
            addCriterion("userLoginModel >=", value, "userloginmodel");
            return (Criteria) this;
        }

        public Criteria andUserloginmodelLessThan(String value) {
            addCriterion("userLoginModel <", value, "userloginmodel");
            return (Criteria) this;
        }

        public Criteria andUserloginmodelLessThanOrEqualTo(String value) {
            addCriterion("userLoginModel <=", value, "userloginmodel");
            return (Criteria) this;
        }

        public Criteria andUserloginmodelLike(String value) {
            addCriterion("userLoginModel like", value, "userloginmodel");
            return (Criteria) this;
        }

        public Criteria andUserloginmodelNotLike(String value) {
            addCriterion("userLoginModel not like", value, "userloginmodel");
            return (Criteria) this;
        }

        public Criteria andUserloginmodelIn(List<String> values) {
            addCriterion("userLoginModel in", values, "userloginmodel");
            return (Criteria) this;
        }

        public Criteria andUserloginmodelNotIn(List<String> values) {
            addCriterion("userLoginModel not in", values, "userloginmodel");
            return (Criteria) this;
        }

        public Criteria andUserloginmodelBetween(String value1, String value2) {
            addCriterion("userLoginModel between", value1, value2, "userloginmodel");
            return (Criteria) this;
        }

        public Criteria andUserloginmodelNotBetween(String value1, String value2) {
            addCriterion("userLoginModel not between", value1, value2, "userloginmodel");
            return (Criteria) this;
        }

        public Criteria andUserloginpverIsNull() {
            addCriterion("userLoginPVer is null");
            return (Criteria) this;
        }

        public Criteria andUserloginpverIsNotNull() {
            addCriterion("userLoginPVer is not null");
            return (Criteria) this;
        }

        public Criteria andUserloginpverEqualTo(String value) {
            addCriterion("userLoginPVer =", value, "userloginpver");
            return (Criteria) this;
        }

        public Criteria andUserloginpverNotEqualTo(String value) {
            addCriterion("userLoginPVer <>", value, "userloginpver");
            return (Criteria) this;
        }

        public Criteria andUserloginpverGreaterThan(String value) {
            addCriterion("userLoginPVer >", value, "userloginpver");
            return (Criteria) this;
        }

        public Criteria andUserloginpverGreaterThanOrEqualTo(String value) {
            addCriterion("userLoginPVer >=", value, "userloginpver");
            return (Criteria) this;
        }

        public Criteria andUserloginpverLessThan(String value) {
            addCriterion("userLoginPVer <", value, "userloginpver");
            return (Criteria) this;
        }

        public Criteria andUserloginpverLessThanOrEqualTo(String value) {
            addCriterion("userLoginPVer <=", value, "userloginpver");
            return (Criteria) this;
        }

        public Criteria andUserloginpverLike(String value) {
            addCriterion("userLoginPVer like", value, "userloginpver");
            return (Criteria) this;
        }

        public Criteria andUserloginpverNotLike(String value) {
            addCriterion("userLoginPVer not like", value, "userloginpver");
            return (Criteria) this;
        }

        public Criteria andUserloginpverIn(List<String> values) {
            addCriterion("userLoginPVer in", values, "userloginpver");
            return (Criteria) this;
        }

        public Criteria andUserloginpverNotIn(List<String> values) {
            addCriterion("userLoginPVer not in", values, "userloginpver");
            return (Criteria) this;
        }

        public Criteria andUserloginpverBetween(String value1, String value2) {
            addCriterion("userLoginPVer between", value1, value2, "userloginpver");
            return (Criteria) this;
        }

        public Criteria andUserloginpverNotBetween(String value1, String value2) {
            addCriterion("userLoginPVer not between", value1, value2, "userloginpver");
            return (Criteria) this;
        }

        public Criteria andUserloginmacIsNull() {
            addCriterion("userLoginMac is null");
            return (Criteria) this;
        }

        public Criteria andUserloginmacIsNotNull() {
            addCriterion("userLoginMac is not null");
            return (Criteria) this;
        }

        public Criteria andUserloginmacEqualTo(String value) {
            addCriterion("userLoginMac =", value, "userloginmac");
            return (Criteria) this;
        }

        public Criteria andUserloginmacNotEqualTo(String value) {
            addCriterion("userLoginMac <>", value, "userloginmac");
            return (Criteria) this;
        }

        public Criteria andUserloginmacGreaterThan(String value) {
            addCriterion("userLoginMac >", value, "userloginmac");
            return (Criteria) this;
        }

        public Criteria andUserloginmacGreaterThanOrEqualTo(String value) {
            addCriterion("userLoginMac >=", value, "userloginmac");
            return (Criteria) this;
        }

        public Criteria andUserloginmacLessThan(String value) {
            addCriterion("userLoginMac <", value, "userloginmac");
            return (Criteria) this;
        }

        public Criteria andUserloginmacLessThanOrEqualTo(String value) {
            addCriterion("userLoginMac <=", value, "userloginmac");
            return (Criteria) this;
        }

        public Criteria andUserloginmacLike(String value) {
            addCriterion("userLoginMac like", value, "userloginmac");
            return (Criteria) this;
        }

        public Criteria andUserloginmacNotLike(String value) {
            addCriterion("userLoginMac not like", value, "userloginmac");
            return (Criteria) this;
        }

        public Criteria andUserloginmacIn(List<String> values) {
            addCriterion("userLoginMac in", values, "userloginmac");
            return (Criteria) this;
        }

        public Criteria andUserloginmacNotIn(List<String> values) {
            addCriterion("userLoginMac not in", values, "userloginmac");
            return (Criteria) this;
        }

        public Criteria andUserloginmacBetween(String value1, String value2) {
            addCriterion("userLoginMac between", value1, value2, "userloginmac");
            return (Criteria) this;
        }

        public Criteria andUserloginmacNotBetween(String value1, String value2) {
            addCriterion("userLoginMac not between", value1, value2, "userloginmac");
            return (Criteria) this;
        }

        public Criteria andUserloginipIsNull() {
            addCriterion("userLoginIp is null");
            return (Criteria) this;
        }

        public Criteria andUserloginipIsNotNull() {
            addCriterion("userLoginIp is not null");
            return (Criteria) this;
        }

        public Criteria andUserloginipEqualTo(String value) {
            addCriterion("userLoginIp =", value, "userloginip");
            return (Criteria) this;
        }

        public Criteria andUserloginipNotEqualTo(String value) {
            addCriterion("userLoginIp <>", value, "userloginip");
            return (Criteria) this;
        }

        public Criteria andUserloginipGreaterThan(String value) {
            addCriterion("userLoginIp >", value, "userloginip");
            return (Criteria) this;
        }

        public Criteria andUserloginipGreaterThanOrEqualTo(String value) {
            addCriterion("userLoginIp >=", value, "userloginip");
            return (Criteria) this;
        }

        public Criteria andUserloginipLessThan(String value) {
            addCriterion("userLoginIp <", value, "userloginip");
            return (Criteria) this;
        }

        public Criteria andUserloginipLessThanOrEqualTo(String value) {
            addCriterion("userLoginIp <=", value, "userloginip");
            return (Criteria) this;
        }

        public Criteria andUserloginipLike(String value) {
            addCriterion("userLoginIp like", value, "userloginip");
            return (Criteria) this;
        }

        public Criteria andUserloginipNotLike(String value) {
            addCriterion("userLoginIp not like", value, "userloginip");
            return (Criteria) this;
        }

        public Criteria andUserloginipIn(List<String> values) {
            addCriterion("userLoginIp in", values, "userloginip");
            return (Criteria) this;
        }

        public Criteria andUserloginipNotIn(List<String> values) {
            addCriterion("userLoginIp not in", values, "userloginip");
            return (Criteria) this;
        }

        public Criteria andUserloginipBetween(String value1, String value2) {
            addCriterion("userLoginIp between", value1, value2, "userloginip");
            return (Criteria) this;
        }

        public Criteria andUserloginipNotBetween(String value1, String value2) {
            addCriterion("userLoginIp not between", value1, value2, "userloginip");
            return (Criteria) this;
        }

        public Criteria andUserlogintypeIsNull() {
            addCriterion("userLoginType is null");
            return (Criteria) this;
        }

        public Criteria andUserlogintypeIsNotNull() {
            addCriterion("userLoginType is not null");
            return (Criteria) this;
        }

        public Criteria andUserlogintypeEqualTo(Integer value) {
            addCriterion("userLoginType =", value, "userlogintype");
            return (Criteria) this;
        }

        public Criteria andUserlogintypeNotEqualTo(Integer value) {
            addCriterion("userLoginType <>", value, "userlogintype");
            return (Criteria) this;
        }

        public Criteria andUserlogintypeGreaterThan(Integer value) {
            addCriterion("userLoginType >", value, "userlogintype");
            return (Criteria) this;
        }

        public Criteria andUserlogintypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("userLoginType >=", value, "userlogintype");
            return (Criteria) this;
        }

        public Criteria andUserlogintypeLessThan(Integer value) {
            addCriterion("userLoginType <", value, "userlogintype");
            return (Criteria) this;
        }

        public Criteria andUserlogintypeLessThanOrEqualTo(Integer value) {
            addCriterion("userLoginType <=", value, "userlogintype");
            return (Criteria) this;
        }

        public Criteria andUserlogintypeIn(List<Integer> values) {
            addCriterion("userLoginType in", values, "userlogintype");
            return (Criteria) this;
        }

        public Criteria andUserlogintypeNotIn(List<Integer> values) {
            addCriterion("userLoginType not in", values, "userlogintype");
            return (Criteria) this;
        }

        public Criteria andUserlogintypeBetween(Integer value1, Integer value2) {
            addCriterion("userLoginType between", value1, value2, "userlogintype");
            return (Criteria) this;
        }

        public Criteria andUserlogintypeNotBetween(Integer value1, Integer value2) {
            addCriterion("userLoginType not between", value1, value2, "userlogintype");
            return (Criteria) this;
        }

        public Criteria andUserloginsubchecktimeIsNull() {
            addCriterion("userLoginSubCheckTime is null");
            return (Criteria) this;
        }

        public Criteria andUserloginsubchecktimeIsNotNull() {
            addCriterion("userLoginSubCheckTime is not null");
            return (Criteria) this;
        }

        public Criteria andUserloginsubchecktimeEqualTo(Date value) {
            addCriterion("userLoginSubCheckTime =", value, "userloginsubchecktime");
            return (Criteria) this;
        }

        public Criteria andUserloginsubchecktimeNotEqualTo(Date value) {
            addCriterion("userLoginSubCheckTime <>", value, "userloginsubchecktime");
            return (Criteria) this;
        }

        public Criteria andUserloginsubchecktimeGreaterThan(Date value) {
            addCriterion("userLoginSubCheckTime >", value, "userloginsubchecktime");
            return (Criteria) this;
        }

        public Criteria andUserloginsubchecktimeGreaterThanOrEqualTo(Date value) {
            addCriterion("userLoginSubCheckTime >=", value, "userloginsubchecktime");
            return (Criteria) this;
        }

        public Criteria andUserloginsubchecktimeLessThan(Date value) {
            addCriterion("userLoginSubCheckTime <", value, "userloginsubchecktime");
            return (Criteria) this;
        }

        public Criteria andUserloginsubchecktimeLessThanOrEqualTo(Date value) {
            addCriterion("userLoginSubCheckTime <=", value, "userloginsubchecktime");
            return (Criteria) this;
        }

        public Criteria andUserloginsubchecktimeIn(List<Date> values) {
            addCriterion("userLoginSubCheckTime in", values, "userloginsubchecktime");
            return (Criteria) this;
        }

        public Criteria andUserloginsubchecktimeNotIn(List<Date> values) {
            addCriterion("userLoginSubCheckTime not in", values, "userloginsubchecktime");
            return (Criteria) this;
        }

        public Criteria andUserloginsubchecktimeBetween(Date value1, Date value2) {
            addCriterion("userLoginSubCheckTime between", value1, value2, "userloginsubchecktime");
            return (Criteria) this;
        }

        public Criteria andUserloginsubchecktimeNotBetween(Date value1, Date value2) {
            addCriterion("userLoginSubCheckTime not between", value1, value2, "userloginsubchecktime");
            return (Criteria) this;
        }

        public Criteria andUserloginpixIsNull() {
            addCriterion("userLoginPix is null");
            return (Criteria) this;
        }

        public Criteria andUserloginpixIsNotNull() {
            addCriterion("userLoginPix is not null");
            return (Criteria) this;
        }

        public Criteria andUserloginpixEqualTo(String value) {
            addCriterion("userLoginPix =", value, "userloginpix");
            return (Criteria) this;
        }

        public Criteria andUserloginpixNotEqualTo(String value) {
            addCriterion("userLoginPix <>", value, "userloginpix");
            return (Criteria) this;
        }

        public Criteria andUserloginpixGreaterThan(String value) {
            addCriterion("userLoginPix >", value, "userloginpix");
            return (Criteria) this;
        }

        public Criteria andUserloginpixGreaterThanOrEqualTo(String value) {
            addCriterion("userLoginPix >=", value, "userloginpix");
            return (Criteria) this;
        }

        public Criteria andUserloginpixLessThan(String value) {
            addCriterion("userLoginPix <", value, "userloginpix");
            return (Criteria) this;
        }

        public Criteria andUserloginpixLessThanOrEqualTo(String value) {
            addCriterion("userLoginPix <=", value, "userloginpix");
            return (Criteria) this;
        }

        public Criteria andUserloginpixLike(String value) {
            addCriterion("userLoginPix like", value, "userloginpix");
            return (Criteria) this;
        }

        public Criteria andUserloginpixNotLike(String value) {
            addCriterion("userLoginPix not like", value, "userloginpix");
            return (Criteria) this;
        }

        public Criteria andUserloginpixIn(List<String> values) {
            addCriterion("userLoginPix in", values, "userloginpix");
            return (Criteria) this;
        }

        public Criteria andUserloginpixNotIn(List<String> values) {
            addCriterion("userLoginPix not in", values, "userloginpix");
            return (Criteria) this;
        }

        public Criteria andUserloginpixBetween(String value1, String value2) {
            addCriterion("userLoginPix between", value1, value2, "userloginpix");
            return (Criteria) this;
        }

        public Criteria andUserloginpixNotBetween(String value1, String value2) {
            addCriterion("userLoginPix not between", value1, value2, "userloginpix");
            return (Criteria) this;
        }

        public Criteria andUserloginchannelidIsNull() {
            addCriterion("userLoginChannelId is null");
            return (Criteria) this;
        }

        public Criteria andUserloginchannelidIsNotNull() {
            addCriterion("userLoginChannelId is not null");
            return (Criteria) this;
        }

        public Criteria andUserloginchannelidEqualTo(String value) {
            addCriterion("userLoginChannelId =", value, "userloginchannelid");
            return (Criteria) this;
        }

        public Criteria andUserloginchannelidNotEqualTo(String value) {
            addCriterion("userLoginChannelId <>", value, "userloginchannelid");
            return (Criteria) this;
        }

        public Criteria andUserloginchannelidGreaterThan(String value) {
            addCriterion("userLoginChannelId >", value, "userloginchannelid");
            return (Criteria) this;
        }

        public Criteria andUserloginchannelidGreaterThanOrEqualTo(String value) {
            addCriterion("userLoginChannelId >=", value, "userloginchannelid");
            return (Criteria) this;
        }

        public Criteria andUserloginchannelidLessThan(String value) {
            addCriterion("userLoginChannelId <", value, "userloginchannelid");
            return (Criteria) this;
        }

        public Criteria andUserloginchannelidLessThanOrEqualTo(String value) {
            addCriterion("userLoginChannelId <=", value, "userloginchannelid");
            return (Criteria) this;
        }

        public Criteria andUserloginchannelidLike(String value) {
            addCriterion("userLoginChannelId like", value, "userloginchannelid");
            return (Criteria) this;
        }

        public Criteria andUserloginchannelidNotLike(String value) {
            addCriterion("userLoginChannelId not like", value, "userloginchannelid");
            return (Criteria) this;
        }

        public Criteria andUserloginchannelidIn(List<String> values) {
            addCriterion("userLoginChannelId in", values, "userloginchannelid");
            return (Criteria) this;
        }

        public Criteria andUserloginchannelidNotIn(List<String> values) {
            addCriterion("userLoginChannelId not in", values, "userloginchannelid");
            return (Criteria) this;
        }

        public Criteria andUserloginchannelidBetween(String value1, String value2) {
            addCriterion("userLoginChannelId between", value1, value2, "userloginchannelid");
            return (Criteria) this;
        }

        public Criteria andUserloginchannelidNotBetween(String value1, String value2) {
            addCriterion("userLoginChannelId not between", value1, value2, "userloginchannelid");
            return (Criteria) this;
        }

        public Criteria andUserlogindevIsNull() {
            addCriterion("userLoginDev is null");
            return (Criteria) this;
        }

        public Criteria andUserlogindevIsNotNull() {
            addCriterion("userLoginDev is not null");
            return (Criteria) this;
        }

        public Criteria andUserlogindevEqualTo(Integer value) {
            addCriterion("userLoginDev =", value, "userlogindev");
            return (Criteria) this;
        }

        public Criteria andUserlogindevNotEqualTo(Integer value) {
            addCriterion("userLoginDev <>", value, "userlogindev");
            return (Criteria) this;
        }

        public Criteria andUserlogindevGreaterThan(Integer value) {
            addCriterion("userLoginDev >", value, "userlogindev");
            return (Criteria) this;
        }

        public Criteria andUserlogindevGreaterThanOrEqualTo(Integer value) {
            addCriterion("userLoginDev >=", value, "userlogindev");
            return (Criteria) this;
        }

        public Criteria andUserlogindevLessThan(Integer value) {
            addCriterion("userLoginDev <", value, "userlogindev");
            return (Criteria) this;
        }

        public Criteria andUserlogindevLessThanOrEqualTo(Integer value) {
            addCriterion("userLoginDev <=", value, "userlogindev");
            return (Criteria) this;
        }

        public Criteria andUserlogindevIn(List<Integer> values) {
            addCriterion("userLoginDev in", values, "userlogindev");
            return (Criteria) this;
        }

        public Criteria andUserlogindevNotIn(List<Integer> values) {
            addCriterion("userLoginDev not in", values, "userlogindev");
            return (Criteria) this;
        }

        public Criteria andUserlogindevBetween(Integer value1, Integer value2) {
            addCriterion("userLoginDev between", value1, value2, "userlogindev");
            return (Criteria) this;
        }

        public Criteria andUserlogindevNotBetween(Integer value1, Integer value2) {
            addCriterion("userLoginDev not between", value1, value2, "userlogindev");
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