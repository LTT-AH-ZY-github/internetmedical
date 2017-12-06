package com.medical.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HosplogininfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HosplogininfoExample() {
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

        public Criteria andHosploginidIsNull() {
            addCriterion("hospLoginId is null");
            return (Criteria) this;
        }

        public Criteria andHosploginidIsNotNull() {
            addCriterion("hospLoginId is not null");
            return (Criteria) this;
        }

        public Criteria andHosploginidEqualTo(Integer value) {
            addCriterion("hospLoginId =", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidNotEqualTo(Integer value) {
            addCriterion("hospLoginId <>", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidGreaterThan(Integer value) {
            addCriterion("hospLoginId >", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hospLoginId >=", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidLessThan(Integer value) {
            addCriterion("hospLoginId <", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidLessThanOrEqualTo(Integer value) {
            addCriterion("hospLoginId <=", value, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidIn(List<Integer> values) {
            addCriterion("hospLoginId in", values, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidNotIn(List<Integer> values) {
            addCriterion("hospLoginId not in", values, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidBetween(Integer value1, Integer value2) {
            addCriterion("hospLoginId between", value1, value2, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginidNotBetween(Integer value1, Integer value2) {
            addCriterion("hospLoginId not between", value1, value2, "hosploginid");
            return (Criteria) this;
        }

        public Criteria andHosploginnameIsNull() {
            addCriterion("hospLoginName is null");
            return (Criteria) this;
        }

        public Criteria andHosploginnameIsNotNull() {
            addCriterion("hospLoginName is not null");
            return (Criteria) this;
        }

        public Criteria andHosploginnameEqualTo(String value) {
            addCriterion("hospLoginName =", value, "hosploginname");
            return (Criteria) this;
        }

        public Criteria andHosploginnameNotEqualTo(String value) {
            addCriterion("hospLoginName <>", value, "hosploginname");
            return (Criteria) this;
        }

        public Criteria andHosploginnameGreaterThan(String value) {
            addCriterion("hospLoginName >", value, "hosploginname");
            return (Criteria) this;
        }

        public Criteria andHosploginnameGreaterThanOrEqualTo(String value) {
            addCriterion("hospLoginName >=", value, "hosploginname");
            return (Criteria) this;
        }

        public Criteria andHosploginnameLessThan(String value) {
            addCriterion("hospLoginName <", value, "hosploginname");
            return (Criteria) this;
        }

        public Criteria andHosploginnameLessThanOrEqualTo(String value) {
            addCriterion("hospLoginName <=", value, "hosploginname");
            return (Criteria) this;
        }

        public Criteria andHosploginnameLike(String value) {
            addCriterion("hospLoginName like", value, "hosploginname");
            return (Criteria) this;
        }

        public Criteria andHosploginnameNotLike(String value) {
            addCriterion("hospLoginName not like", value, "hosploginname");
            return (Criteria) this;
        }

        public Criteria andHosploginnameIn(List<String> values) {
            addCriterion("hospLoginName in", values, "hosploginname");
            return (Criteria) this;
        }

        public Criteria andHosploginnameNotIn(List<String> values) {
            addCriterion("hospLoginName not in", values, "hosploginname");
            return (Criteria) this;
        }

        public Criteria andHosploginnameBetween(String value1, String value2) {
            addCriterion("hospLoginName between", value1, value2, "hosploginname");
            return (Criteria) this;
        }

        public Criteria andHosploginnameNotBetween(String value1, String value2) {
            addCriterion("hospLoginName not between", value1, value2, "hosploginname");
            return (Criteria) this;
        }

        public Criteria andHosploginsaltIsNull() {
            addCriterion("hospLoginSalt is null");
            return (Criteria) this;
        }

        public Criteria andHosploginsaltIsNotNull() {
            addCriterion("hospLoginSalt is not null");
            return (Criteria) this;
        }

        public Criteria andHosploginsaltEqualTo(String value) {
            addCriterion("hospLoginSalt =", value, "hosploginsalt");
            return (Criteria) this;
        }

        public Criteria andHosploginsaltNotEqualTo(String value) {
            addCriterion("hospLoginSalt <>", value, "hosploginsalt");
            return (Criteria) this;
        }

        public Criteria andHosploginsaltGreaterThan(String value) {
            addCriterion("hospLoginSalt >", value, "hosploginsalt");
            return (Criteria) this;
        }

        public Criteria andHosploginsaltGreaterThanOrEqualTo(String value) {
            addCriterion("hospLoginSalt >=", value, "hosploginsalt");
            return (Criteria) this;
        }

        public Criteria andHosploginsaltLessThan(String value) {
            addCriterion("hospLoginSalt <", value, "hosploginsalt");
            return (Criteria) this;
        }

        public Criteria andHosploginsaltLessThanOrEqualTo(String value) {
            addCriterion("hospLoginSalt <=", value, "hosploginsalt");
            return (Criteria) this;
        }

        public Criteria andHosploginsaltLike(String value) {
            addCriterion("hospLoginSalt like", value, "hosploginsalt");
            return (Criteria) this;
        }

        public Criteria andHosploginsaltNotLike(String value) {
            addCriterion("hospLoginSalt not like", value, "hosploginsalt");
            return (Criteria) this;
        }

        public Criteria andHosploginsaltIn(List<String> values) {
            addCriterion("hospLoginSalt in", values, "hosploginsalt");
            return (Criteria) this;
        }

        public Criteria andHosploginsaltNotIn(List<String> values) {
            addCriterion("hospLoginSalt not in", values, "hosploginsalt");
            return (Criteria) this;
        }

        public Criteria andHosploginsaltBetween(String value1, String value2) {
            addCriterion("hospLoginSalt between", value1, value2, "hosploginsalt");
            return (Criteria) this;
        }

        public Criteria andHosploginsaltNotBetween(String value1, String value2) {
            addCriterion("hospLoginSalt not between", value1, value2, "hosploginsalt");
            return (Criteria) this;
        }

        public Criteria andHosploginpwdIsNull() {
            addCriterion("hospLoginPwd is null");
            return (Criteria) this;
        }

        public Criteria andHosploginpwdIsNotNull() {
            addCriterion("hospLoginPwd is not null");
            return (Criteria) this;
        }

        public Criteria andHosploginpwdEqualTo(String value) {
            addCriterion("hospLoginPwd =", value, "hosploginpwd");
            return (Criteria) this;
        }

        public Criteria andHosploginpwdNotEqualTo(String value) {
            addCriterion("hospLoginPwd <>", value, "hosploginpwd");
            return (Criteria) this;
        }

        public Criteria andHosploginpwdGreaterThan(String value) {
            addCriterion("hospLoginPwd >", value, "hosploginpwd");
            return (Criteria) this;
        }

        public Criteria andHosploginpwdGreaterThanOrEqualTo(String value) {
            addCriterion("hospLoginPwd >=", value, "hosploginpwd");
            return (Criteria) this;
        }

        public Criteria andHosploginpwdLessThan(String value) {
            addCriterion("hospLoginPwd <", value, "hosploginpwd");
            return (Criteria) this;
        }

        public Criteria andHosploginpwdLessThanOrEqualTo(String value) {
            addCriterion("hospLoginPwd <=", value, "hosploginpwd");
            return (Criteria) this;
        }

        public Criteria andHosploginpwdLike(String value) {
            addCriterion("hospLoginPwd like", value, "hosploginpwd");
            return (Criteria) this;
        }

        public Criteria andHosploginpwdNotLike(String value) {
            addCriterion("hospLoginPwd not like", value, "hosploginpwd");
            return (Criteria) this;
        }

        public Criteria andHosploginpwdIn(List<String> values) {
            addCriterion("hospLoginPwd in", values, "hosploginpwd");
            return (Criteria) this;
        }

        public Criteria andHosploginpwdNotIn(List<String> values) {
            addCriterion("hospLoginPwd not in", values, "hosploginpwd");
            return (Criteria) this;
        }

        public Criteria andHosploginpwdBetween(String value1, String value2) {
            addCriterion("hospLoginPwd between", value1, value2, "hosploginpwd");
            return (Criteria) this;
        }

        public Criteria andHosploginpwdNotBetween(String value1, String value2) {
            addCriterion("hospLoginPwd not between", value1, value2, "hosploginpwd");
            return (Criteria) this;
        }

        public Criteria andHosplogintokenIsNull() {
            addCriterion("hospLoginToken is null");
            return (Criteria) this;
        }

        public Criteria andHosplogintokenIsNotNull() {
            addCriterion("hospLoginToken is not null");
            return (Criteria) this;
        }

        public Criteria andHosplogintokenEqualTo(String value) {
            addCriterion("hospLoginToken =", value, "hosplogintoken");
            return (Criteria) this;
        }

        public Criteria andHosplogintokenNotEqualTo(String value) {
            addCriterion("hospLoginToken <>", value, "hosplogintoken");
            return (Criteria) this;
        }

        public Criteria andHosplogintokenGreaterThan(String value) {
            addCriterion("hospLoginToken >", value, "hosplogintoken");
            return (Criteria) this;
        }

        public Criteria andHosplogintokenGreaterThanOrEqualTo(String value) {
            addCriterion("hospLoginToken >=", value, "hosplogintoken");
            return (Criteria) this;
        }

        public Criteria andHosplogintokenLessThan(String value) {
            addCriterion("hospLoginToken <", value, "hosplogintoken");
            return (Criteria) this;
        }

        public Criteria andHosplogintokenLessThanOrEqualTo(String value) {
            addCriterion("hospLoginToken <=", value, "hosplogintoken");
            return (Criteria) this;
        }

        public Criteria andHosplogintokenLike(String value) {
            addCriterion("hospLoginToken like", value, "hosplogintoken");
            return (Criteria) this;
        }

        public Criteria andHosplogintokenNotLike(String value) {
            addCriterion("hospLoginToken not like", value, "hosplogintoken");
            return (Criteria) this;
        }

        public Criteria andHosplogintokenIn(List<String> values) {
            addCriterion("hospLoginToken in", values, "hosplogintoken");
            return (Criteria) this;
        }

        public Criteria andHosplogintokenNotIn(List<String> values) {
            addCriterion("hospLoginToken not in", values, "hosplogintoken");
            return (Criteria) this;
        }

        public Criteria andHosplogintokenBetween(String value1, String value2) {
            addCriterion("hospLoginToken between", value1, value2, "hosplogintoken");
            return (Criteria) this;
        }

        public Criteria andHosplogintokenNotBetween(String value1, String value2) {
            addCriterion("hospLoginToken not between", value1, value2, "hosplogintoken");
            return (Criteria) this;
        }

        public Criteria andHosplogintimeIsNull() {
            addCriterion("hospLoginTime is null");
            return (Criteria) this;
        }

        public Criteria andHosplogintimeIsNotNull() {
            addCriterion("hospLoginTime is not null");
            return (Criteria) this;
        }

        public Criteria andHosplogintimeEqualTo(Date value) {
            addCriterion("hospLoginTime =", value, "hosplogintime");
            return (Criteria) this;
        }

        public Criteria andHosplogintimeNotEqualTo(Date value) {
            addCriterion("hospLoginTime <>", value, "hosplogintime");
            return (Criteria) this;
        }

        public Criteria andHosplogintimeGreaterThan(Date value) {
            addCriterion("hospLoginTime >", value, "hosplogintime");
            return (Criteria) this;
        }

        public Criteria andHosplogintimeGreaterThanOrEqualTo(Date value) {
            addCriterion("hospLoginTime >=", value, "hosplogintime");
            return (Criteria) this;
        }

        public Criteria andHosplogintimeLessThan(Date value) {
            addCriterion("hospLoginTime <", value, "hosplogintime");
            return (Criteria) this;
        }

        public Criteria andHosplogintimeLessThanOrEqualTo(Date value) {
            addCriterion("hospLoginTime <=", value, "hosplogintime");
            return (Criteria) this;
        }

        public Criteria andHosplogintimeIn(List<Date> values) {
            addCriterion("hospLoginTime in", values, "hosplogintime");
            return (Criteria) this;
        }

        public Criteria andHosplogintimeNotIn(List<Date> values) {
            addCriterion("hospLoginTime not in", values, "hosplogintime");
            return (Criteria) this;
        }

        public Criteria andHosplogintimeBetween(Date value1, Date value2) {
            addCriterion("hospLoginTime between", value1, value2, "hosplogintime");
            return (Criteria) this;
        }

        public Criteria andHosplogintimeNotBetween(Date value1, Date value2) {
            addCriterion("hospLoginTime not between", value1, value2, "hosplogintime");
            return (Criteria) this;
        }

        public Criteria andHosploginlocIsNull() {
            addCriterion("hospLoginLoc is null");
            return (Criteria) this;
        }

        public Criteria andHosploginlocIsNotNull() {
            addCriterion("hospLoginLoc is not null");
            return (Criteria) this;
        }

        public Criteria andHosploginlocEqualTo(String value) {
            addCriterion("hospLoginLoc =", value, "hosploginloc");
            return (Criteria) this;
        }

        public Criteria andHosploginlocNotEqualTo(String value) {
            addCriterion("hospLoginLoc <>", value, "hosploginloc");
            return (Criteria) this;
        }

        public Criteria andHosploginlocGreaterThan(String value) {
            addCriterion("hospLoginLoc >", value, "hosploginloc");
            return (Criteria) this;
        }

        public Criteria andHosploginlocGreaterThanOrEqualTo(String value) {
            addCriterion("hospLoginLoc >=", value, "hosploginloc");
            return (Criteria) this;
        }

        public Criteria andHosploginlocLessThan(String value) {
            addCriterion("hospLoginLoc <", value, "hosploginloc");
            return (Criteria) this;
        }

        public Criteria andHosploginlocLessThanOrEqualTo(String value) {
            addCriterion("hospLoginLoc <=", value, "hosploginloc");
            return (Criteria) this;
        }

        public Criteria andHosploginlocLike(String value) {
            addCriterion("hospLoginLoc like", value, "hosploginloc");
            return (Criteria) this;
        }

        public Criteria andHosploginlocNotLike(String value) {
            addCriterion("hospLoginLoc not like", value, "hosploginloc");
            return (Criteria) this;
        }

        public Criteria andHosploginlocIn(List<String> values) {
            addCriterion("hospLoginLoc in", values, "hosploginloc");
            return (Criteria) this;
        }

        public Criteria andHosploginlocNotIn(List<String> values) {
            addCriterion("hospLoginLoc not in", values, "hosploginloc");
            return (Criteria) this;
        }

        public Criteria andHosploginlocBetween(String value1, String value2) {
            addCriterion("hospLoginLoc between", value1, value2, "hosploginloc");
            return (Criteria) this;
        }

        public Criteria andHosploginlocNotBetween(String value1, String value2) {
            addCriterion("hospLoginLoc not between", value1, value2, "hosploginloc");
            return (Criteria) this;
        }

        public Criteria andHosploginbverIsNull() {
            addCriterion("hospLoginBVer is null");
            return (Criteria) this;
        }

        public Criteria andHosploginbverIsNotNull() {
            addCriterion("hospLoginBVer is not null");
            return (Criteria) this;
        }

        public Criteria andHosploginbverEqualTo(String value) {
            addCriterion("hospLoginBVer =", value, "hosploginbver");
            return (Criteria) this;
        }

        public Criteria andHosploginbverNotEqualTo(String value) {
            addCriterion("hospLoginBVer <>", value, "hosploginbver");
            return (Criteria) this;
        }

        public Criteria andHosploginbverGreaterThan(String value) {
            addCriterion("hospLoginBVer >", value, "hosploginbver");
            return (Criteria) this;
        }

        public Criteria andHosploginbverGreaterThanOrEqualTo(String value) {
            addCriterion("hospLoginBVer >=", value, "hosploginbver");
            return (Criteria) this;
        }

        public Criteria andHosploginbverLessThan(String value) {
            addCriterion("hospLoginBVer <", value, "hosploginbver");
            return (Criteria) this;
        }

        public Criteria andHosploginbverLessThanOrEqualTo(String value) {
            addCriterion("hospLoginBVer <=", value, "hosploginbver");
            return (Criteria) this;
        }

        public Criteria andHosploginbverLike(String value) {
            addCriterion("hospLoginBVer like", value, "hosploginbver");
            return (Criteria) this;
        }

        public Criteria andHosploginbverNotLike(String value) {
            addCriterion("hospLoginBVer not like", value, "hosploginbver");
            return (Criteria) this;
        }

        public Criteria andHosploginbverIn(List<String> values) {
            addCriterion("hospLoginBVer in", values, "hosploginbver");
            return (Criteria) this;
        }

        public Criteria andHosploginbverNotIn(List<String> values) {
            addCriterion("hospLoginBVer not in", values, "hosploginbver");
            return (Criteria) this;
        }

        public Criteria andHosploginbverBetween(String value1, String value2) {
            addCriterion("hospLoginBVer between", value1, value2, "hosploginbver");
            return (Criteria) this;
        }

        public Criteria andHosploginbverNotBetween(String value1, String value2) {
            addCriterion("hospLoginBVer not between", value1, value2, "hosploginbver");
            return (Criteria) this;
        }

        public Criteria andHosploginmacIsNull() {
            addCriterion("hospLoginMac is null");
            return (Criteria) this;
        }

        public Criteria andHosploginmacIsNotNull() {
            addCriterion("hospLoginMac is not null");
            return (Criteria) this;
        }

        public Criteria andHosploginmacEqualTo(String value) {
            addCriterion("hospLoginMac =", value, "hosploginmac");
            return (Criteria) this;
        }

        public Criteria andHosploginmacNotEqualTo(String value) {
            addCriterion("hospLoginMac <>", value, "hosploginmac");
            return (Criteria) this;
        }

        public Criteria andHosploginmacGreaterThan(String value) {
            addCriterion("hospLoginMac >", value, "hosploginmac");
            return (Criteria) this;
        }

        public Criteria andHosploginmacGreaterThanOrEqualTo(String value) {
            addCriterion("hospLoginMac >=", value, "hosploginmac");
            return (Criteria) this;
        }

        public Criteria andHosploginmacLessThan(String value) {
            addCriterion("hospLoginMac <", value, "hosploginmac");
            return (Criteria) this;
        }

        public Criteria andHosploginmacLessThanOrEqualTo(String value) {
            addCriterion("hospLoginMac <=", value, "hosploginmac");
            return (Criteria) this;
        }

        public Criteria andHosploginmacLike(String value) {
            addCriterion("hospLoginMac like", value, "hosploginmac");
            return (Criteria) this;
        }

        public Criteria andHosploginmacNotLike(String value) {
            addCriterion("hospLoginMac not like", value, "hosploginmac");
            return (Criteria) this;
        }

        public Criteria andHosploginmacIn(List<String> values) {
            addCriterion("hospLoginMac in", values, "hosploginmac");
            return (Criteria) this;
        }

        public Criteria andHosploginmacNotIn(List<String> values) {
            addCriterion("hospLoginMac not in", values, "hosploginmac");
            return (Criteria) this;
        }

        public Criteria andHosploginmacBetween(String value1, String value2) {
            addCriterion("hospLoginMac between", value1, value2, "hosploginmac");
            return (Criteria) this;
        }

        public Criteria andHosploginmacNotBetween(String value1, String value2) {
            addCriterion("hospLoginMac not between", value1, value2, "hosploginmac");
            return (Criteria) this;
        }

        public Criteria andHosploginipIsNull() {
            addCriterion("hospLoginIp is null");
            return (Criteria) this;
        }

        public Criteria andHosploginipIsNotNull() {
            addCriterion("hospLoginIp is not null");
            return (Criteria) this;
        }

        public Criteria andHosploginipEqualTo(String value) {
            addCriterion("hospLoginIp =", value, "hosploginip");
            return (Criteria) this;
        }

        public Criteria andHosploginipNotEqualTo(String value) {
            addCriterion("hospLoginIp <>", value, "hosploginip");
            return (Criteria) this;
        }

        public Criteria andHosploginipGreaterThan(String value) {
            addCriterion("hospLoginIp >", value, "hosploginip");
            return (Criteria) this;
        }

        public Criteria andHosploginipGreaterThanOrEqualTo(String value) {
            addCriterion("hospLoginIp >=", value, "hosploginip");
            return (Criteria) this;
        }

        public Criteria andHosploginipLessThan(String value) {
            addCriterion("hospLoginIp <", value, "hosploginip");
            return (Criteria) this;
        }

        public Criteria andHosploginipLessThanOrEqualTo(String value) {
            addCriterion("hospLoginIp <=", value, "hosploginip");
            return (Criteria) this;
        }

        public Criteria andHosploginipLike(String value) {
            addCriterion("hospLoginIp like", value, "hosploginip");
            return (Criteria) this;
        }

        public Criteria andHosploginipNotLike(String value) {
            addCriterion("hospLoginIp not like", value, "hosploginip");
            return (Criteria) this;
        }

        public Criteria andHosploginipIn(List<String> values) {
            addCriterion("hospLoginIp in", values, "hosploginip");
            return (Criteria) this;
        }

        public Criteria andHosploginipNotIn(List<String> values) {
            addCriterion("hospLoginIp not in", values, "hosploginip");
            return (Criteria) this;
        }

        public Criteria andHosploginipBetween(String value1, String value2) {
            addCriterion("hospLoginIp between", value1, value2, "hosploginip");
            return (Criteria) this;
        }

        public Criteria andHosploginipNotBetween(String value1, String value2) {
            addCriterion("hospLoginIp not between", value1, value2, "hosploginip");
            return (Criteria) this;
        }

        public Criteria andHosplogintypeIsNull() {
            addCriterion("hospLoginType is null");
            return (Criteria) this;
        }

        public Criteria andHosplogintypeIsNotNull() {
            addCriterion("hospLoginType is not null");
            return (Criteria) this;
        }

        public Criteria andHosplogintypeEqualTo(Integer value) {
            addCriterion("hospLoginType =", value, "hosplogintype");
            return (Criteria) this;
        }

        public Criteria andHosplogintypeNotEqualTo(Integer value) {
            addCriterion("hospLoginType <>", value, "hosplogintype");
            return (Criteria) this;
        }

        public Criteria andHosplogintypeGreaterThan(Integer value) {
            addCriterion("hospLoginType >", value, "hosplogintype");
            return (Criteria) this;
        }

        public Criteria andHosplogintypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("hospLoginType >=", value, "hosplogintype");
            return (Criteria) this;
        }

        public Criteria andHosplogintypeLessThan(Integer value) {
            addCriterion("hospLoginType <", value, "hosplogintype");
            return (Criteria) this;
        }

        public Criteria andHosplogintypeLessThanOrEqualTo(Integer value) {
            addCriterion("hospLoginType <=", value, "hosplogintype");
            return (Criteria) this;
        }

        public Criteria andHosplogintypeIn(List<Integer> values) {
            addCriterion("hospLoginType in", values, "hosplogintype");
            return (Criteria) this;
        }

        public Criteria andHosplogintypeNotIn(List<Integer> values) {
            addCriterion("hospLoginType not in", values, "hosplogintype");
            return (Criteria) this;
        }

        public Criteria andHosplogintypeBetween(Integer value1, Integer value2) {
            addCriterion("hospLoginType between", value1, value2, "hosplogintype");
            return (Criteria) this;
        }

        public Criteria andHosplogintypeNotBetween(Integer value1, Integer value2) {
            addCriterion("hospLoginType not between", value1, value2, "hosplogintype");
            return (Criteria) this;
        }

        public Criteria andHosploginsubchecktimeIsNull() {
            addCriterion("hospLoginSubCheckTime is null");
            return (Criteria) this;
        }

        public Criteria andHosploginsubchecktimeIsNotNull() {
            addCriterion("hospLoginSubCheckTime is not null");
            return (Criteria) this;
        }

        public Criteria andHosploginsubchecktimeEqualTo(Date value) {
            addCriterion("hospLoginSubCheckTime =", value, "hosploginsubchecktime");
            return (Criteria) this;
        }

        public Criteria andHosploginsubchecktimeNotEqualTo(Date value) {
            addCriterion("hospLoginSubCheckTime <>", value, "hosploginsubchecktime");
            return (Criteria) this;
        }

        public Criteria andHosploginsubchecktimeGreaterThan(Date value) {
            addCriterion("hospLoginSubCheckTime >", value, "hosploginsubchecktime");
            return (Criteria) this;
        }

        public Criteria andHosploginsubchecktimeGreaterThanOrEqualTo(Date value) {
            addCriterion("hospLoginSubCheckTime >=", value, "hosploginsubchecktime");
            return (Criteria) this;
        }

        public Criteria andHosploginsubchecktimeLessThan(Date value) {
            addCriterion("hospLoginSubCheckTime <", value, "hosploginsubchecktime");
            return (Criteria) this;
        }

        public Criteria andHosploginsubchecktimeLessThanOrEqualTo(Date value) {
            addCriterion("hospLoginSubCheckTime <=", value, "hosploginsubchecktime");
            return (Criteria) this;
        }

        public Criteria andHosploginsubchecktimeIn(List<Date> values) {
            addCriterion("hospLoginSubCheckTime in", values, "hosploginsubchecktime");
            return (Criteria) this;
        }

        public Criteria andHosploginsubchecktimeNotIn(List<Date> values) {
            addCriterion("hospLoginSubCheckTime not in", values, "hosploginsubchecktime");
            return (Criteria) this;
        }

        public Criteria andHosploginsubchecktimeBetween(Date value1, Date value2) {
            addCriterion("hospLoginSubCheckTime between", value1, value2, "hosploginsubchecktime");
            return (Criteria) this;
        }

        public Criteria andHosploginsubchecktimeNotBetween(Date value1, Date value2) {
            addCriterion("hospLoginSubCheckTime not between", value1, value2, "hosploginsubchecktime");
            return (Criteria) this;
        }

        public Criteria andHosploginphoneIsNull() {
            addCriterion("hospLoginPhone is null");
            return (Criteria) this;
        }

        public Criteria andHosploginphoneIsNotNull() {
            addCriterion("hospLoginPhone is not null");
            return (Criteria) this;
        }

        public Criteria andHosploginphoneEqualTo(String value) {
            addCriterion("hospLoginPhone =", value, "hosploginphone");
            return (Criteria) this;
        }

        public Criteria andHosploginphoneNotEqualTo(String value) {
            addCriterion("hospLoginPhone <>", value, "hosploginphone");
            return (Criteria) this;
        }

        public Criteria andHosploginphoneGreaterThan(String value) {
            addCriterion("hospLoginPhone >", value, "hosploginphone");
            return (Criteria) this;
        }

        public Criteria andHosploginphoneGreaterThanOrEqualTo(String value) {
            addCriterion("hospLoginPhone >=", value, "hosploginphone");
            return (Criteria) this;
        }

        public Criteria andHosploginphoneLessThan(String value) {
            addCriterion("hospLoginPhone <", value, "hosploginphone");
            return (Criteria) this;
        }

        public Criteria andHosploginphoneLessThanOrEqualTo(String value) {
            addCriterion("hospLoginPhone <=", value, "hosploginphone");
            return (Criteria) this;
        }

        public Criteria andHosploginphoneLike(String value) {
            addCriterion("hospLoginPhone like", value, "hosploginphone");
            return (Criteria) this;
        }

        public Criteria andHosploginphoneNotLike(String value) {
            addCriterion("hospLoginPhone not like", value, "hosploginphone");
            return (Criteria) this;
        }

        public Criteria andHosploginphoneIn(List<String> values) {
            addCriterion("hospLoginPhone in", values, "hosploginphone");
            return (Criteria) this;
        }

        public Criteria andHosploginphoneNotIn(List<String> values) {
            addCriterion("hospLoginPhone not in", values, "hosploginphone");
            return (Criteria) this;
        }

        public Criteria andHosploginphoneBetween(String value1, String value2) {
            addCriterion("hospLoginPhone between", value1, value2, "hosploginphone");
            return (Criteria) this;
        }

        public Criteria andHosploginphoneNotBetween(String value1, String value2) {
            addCriterion("hospLoginPhone not between", value1, value2, "hosploginphone");
            return (Criteria) this;
        }

        public Criteria andHosploginpixIsNull() {
            addCriterion("hospLoginPix is null");
            return (Criteria) this;
        }

        public Criteria andHosploginpixIsNotNull() {
            addCriterion("hospLoginPix is not null");
            return (Criteria) this;
        }

        public Criteria andHosploginpixEqualTo(String value) {
            addCriterion("hospLoginPix =", value, "hosploginpix");
            return (Criteria) this;
        }

        public Criteria andHosploginpixNotEqualTo(String value) {
            addCriterion("hospLoginPix <>", value, "hosploginpix");
            return (Criteria) this;
        }

        public Criteria andHosploginpixGreaterThan(String value) {
            addCriterion("hospLoginPix >", value, "hosploginpix");
            return (Criteria) this;
        }

        public Criteria andHosploginpixGreaterThanOrEqualTo(String value) {
            addCriterion("hospLoginPix >=", value, "hosploginpix");
            return (Criteria) this;
        }

        public Criteria andHosploginpixLessThan(String value) {
            addCriterion("hospLoginPix <", value, "hosploginpix");
            return (Criteria) this;
        }

        public Criteria andHosploginpixLessThanOrEqualTo(String value) {
            addCriterion("hospLoginPix <=", value, "hosploginpix");
            return (Criteria) this;
        }

        public Criteria andHosploginpixLike(String value) {
            addCriterion("hospLoginPix like", value, "hosploginpix");
            return (Criteria) this;
        }

        public Criteria andHosploginpixNotLike(String value) {
            addCriterion("hospLoginPix not like", value, "hosploginpix");
            return (Criteria) this;
        }

        public Criteria andHosploginpixIn(List<String> values) {
            addCriterion("hospLoginPix in", values, "hosploginpix");
            return (Criteria) this;
        }

        public Criteria andHosploginpixNotIn(List<String> values) {
            addCriterion("hospLoginPix not in", values, "hosploginpix");
            return (Criteria) this;
        }

        public Criteria andHosploginpixBetween(String value1, String value2) {
            addCriterion("hospLoginPix between", value1, value2, "hosploginpix");
            return (Criteria) this;
        }

        public Criteria andHosploginpixNotBetween(String value1, String value2) {
            addCriterion("hospLoginPix not between", value1, value2, "hosploginpix");
            return (Criteria) this;
        }

        public Criteria andHosphuanxinaccountIsNull() {
            addCriterion("hospHuanXinAccount is null");
            return (Criteria) this;
        }

        public Criteria andHosphuanxinaccountIsNotNull() {
            addCriterion("hospHuanXinAccount is not null");
            return (Criteria) this;
        }

        public Criteria andHosphuanxinaccountEqualTo(String value) {
            addCriterion("hospHuanXinAccount =", value, "hosphuanxinaccount");
            return (Criteria) this;
        }

        public Criteria andHosphuanxinaccountNotEqualTo(String value) {
            addCriterion("hospHuanXinAccount <>", value, "hosphuanxinaccount");
            return (Criteria) this;
        }

        public Criteria andHosphuanxinaccountGreaterThan(String value) {
            addCriterion("hospHuanXinAccount >", value, "hosphuanxinaccount");
            return (Criteria) this;
        }

        public Criteria andHosphuanxinaccountGreaterThanOrEqualTo(String value) {
            addCriterion("hospHuanXinAccount >=", value, "hosphuanxinaccount");
            return (Criteria) this;
        }

        public Criteria andHosphuanxinaccountLessThan(String value) {
            addCriterion("hospHuanXinAccount <", value, "hosphuanxinaccount");
            return (Criteria) this;
        }

        public Criteria andHosphuanxinaccountLessThanOrEqualTo(String value) {
            addCriterion("hospHuanXinAccount <=", value, "hosphuanxinaccount");
            return (Criteria) this;
        }

        public Criteria andHosphuanxinaccountLike(String value) {
            addCriterion("hospHuanXinAccount like", value, "hosphuanxinaccount");
            return (Criteria) this;
        }

        public Criteria andHosphuanxinaccountNotLike(String value) {
            addCriterion("hospHuanXinAccount not like", value, "hosphuanxinaccount");
            return (Criteria) this;
        }

        public Criteria andHosphuanxinaccountIn(List<String> values) {
            addCriterion("hospHuanXinAccount in", values, "hosphuanxinaccount");
            return (Criteria) this;
        }

        public Criteria andHosphuanxinaccountNotIn(List<String> values) {
            addCriterion("hospHuanXinAccount not in", values, "hosphuanxinaccount");
            return (Criteria) this;
        }

        public Criteria andHosphuanxinaccountBetween(String value1, String value2) {
            addCriterion("hospHuanXinAccount between", value1, value2, "hosphuanxinaccount");
            return (Criteria) this;
        }

        public Criteria andHosphuanxinaccountNotBetween(String value1, String value2) {
            addCriterion("hospHuanXinAccount not between", value1, value2, "hosphuanxinaccount");
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