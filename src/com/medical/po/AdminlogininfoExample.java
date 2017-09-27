package com.medical.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminlogininfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminlogininfoExample() {
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

        public Criteria andAdminloginidIsNull() {
            addCriterion("adminLoginId is null");
            return (Criteria) this;
        }

        public Criteria andAdminloginidIsNotNull() {
            addCriterion("adminLoginId is not null");
            return (Criteria) this;
        }

        public Criteria andAdminloginidEqualTo(Integer value) {
            addCriterion("adminLoginId =", value, "adminloginid");
            return (Criteria) this;
        }

        public Criteria andAdminloginidNotEqualTo(Integer value) {
            addCriterion("adminLoginId <>", value, "adminloginid");
            return (Criteria) this;
        }

        public Criteria andAdminloginidGreaterThan(Integer value) {
            addCriterion("adminLoginId >", value, "adminloginid");
            return (Criteria) this;
        }

        public Criteria andAdminloginidGreaterThanOrEqualTo(Integer value) {
            addCriterion("adminLoginId >=", value, "adminloginid");
            return (Criteria) this;
        }

        public Criteria andAdminloginidLessThan(Integer value) {
            addCriterion("adminLoginId <", value, "adminloginid");
            return (Criteria) this;
        }

        public Criteria andAdminloginidLessThanOrEqualTo(Integer value) {
            addCriterion("adminLoginId <=", value, "adminloginid");
            return (Criteria) this;
        }

        public Criteria andAdminloginidIn(List<Integer> values) {
            addCriterion("adminLoginId in", values, "adminloginid");
            return (Criteria) this;
        }

        public Criteria andAdminloginidNotIn(List<Integer> values) {
            addCriterion("adminLoginId not in", values, "adminloginid");
            return (Criteria) this;
        }

        public Criteria andAdminloginidBetween(Integer value1, Integer value2) {
            addCriterion("adminLoginId between", value1, value2, "adminloginid");
            return (Criteria) this;
        }

        public Criteria andAdminloginidNotBetween(Integer value1, Integer value2) {
            addCriterion("adminLoginId not between", value1, value2, "adminloginid");
            return (Criteria) this;
        }

        public Criteria andAdminloginnameIsNull() {
            addCriterion("adminLoginName is null");
            return (Criteria) this;
        }

        public Criteria andAdminloginnameIsNotNull() {
            addCriterion("adminLoginName is not null");
            return (Criteria) this;
        }

        public Criteria andAdminloginnameEqualTo(String value) {
            addCriterion("adminLoginName =", value, "adminloginname");
            return (Criteria) this;
        }

        public Criteria andAdminloginnameNotEqualTo(String value) {
            addCriterion("adminLoginName <>", value, "adminloginname");
            return (Criteria) this;
        }

        public Criteria andAdminloginnameGreaterThan(String value) {
            addCriterion("adminLoginName >", value, "adminloginname");
            return (Criteria) this;
        }

        public Criteria andAdminloginnameGreaterThanOrEqualTo(String value) {
            addCriterion("adminLoginName >=", value, "adminloginname");
            return (Criteria) this;
        }

        public Criteria andAdminloginnameLessThan(String value) {
            addCriterion("adminLoginName <", value, "adminloginname");
            return (Criteria) this;
        }

        public Criteria andAdminloginnameLessThanOrEqualTo(String value) {
            addCriterion("adminLoginName <=", value, "adminloginname");
            return (Criteria) this;
        }

        public Criteria andAdminloginnameLike(String value) {
            addCriterion("adminLoginName like", value, "adminloginname");
            return (Criteria) this;
        }

        public Criteria andAdminloginnameNotLike(String value) {
            addCriterion("adminLoginName not like", value, "adminloginname");
            return (Criteria) this;
        }

        public Criteria andAdminloginnameIn(List<String> values) {
            addCriterion("adminLoginName in", values, "adminloginname");
            return (Criteria) this;
        }

        public Criteria andAdminloginnameNotIn(List<String> values) {
            addCriterion("adminLoginName not in", values, "adminloginname");
            return (Criteria) this;
        }

        public Criteria andAdminloginnameBetween(String value1, String value2) {
            addCriterion("adminLoginName between", value1, value2, "adminloginname");
            return (Criteria) this;
        }

        public Criteria andAdminloginnameNotBetween(String value1, String value2) {
            addCriterion("adminLoginName not between", value1, value2, "adminloginname");
            return (Criteria) this;
        }

        public Criteria andAdminloginpwdIsNull() {
            addCriterion("adminLoginPwd is null");
            return (Criteria) this;
        }

        public Criteria andAdminloginpwdIsNotNull() {
            addCriterion("adminLoginPwd is not null");
            return (Criteria) this;
        }

        public Criteria andAdminloginpwdEqualTo(String value) {
            addCriterion("adminLoginPwd =", value, "adminloginpwd");
            return (Criteria) this;
        }

        public Criteria andAdminloginpwdNotEqualTo(String value) {
            addCriterion("adminLoginPwd <>", value, "adminloginpwd");
            return (Criteria) this;
        }

        public Criteria andAdminloginpwdGreaterThan(String value) {
            addCriterion("adminLoginPwd >", value, "adminloginpwd");
            return (Criteria) this;
        }

        public Criteria andAdminloginpwdGreaterThanOrEqualTo(String value) {
            addCriterion("adminLoginPwd >=", value, "adminloginpwd");
            return (Criteria) this;
        }

        public Criteria andAdminloginpwdLessThan(String value) {
            addCriterion("adminLoginPwd <", value, "adminloginpwd");
            return (Criteria) this;
        }

        public Criteria andAdminloginpwdLessThanOrEqualTo(String value) {
            addCriterion("adminLoginPwd <=", value, "adminloginpwd");
            return (Criteria) this;
        }

        public Criteria andAdminloginpwdLike(String value) {
            addCriterion("adminLoginPwd like", value, "adminloginpwd");
            return (Criteria) this;
        }

        public Criteria andAdminloginpwdNotLike(String value) {
            addCriterion("adminLoginPwd not like", value, "adminloginpwd");
            return (Criteria) this;
        }

        public Criteria andAdminloginpwdIn(List<String> values) {
            addCriterion("adminLoginPwd in", values, "adminloginpwd");
            return (Criteria) this;
        }

        public Criteria andAdminloginpwdNotIn(List<String> values) {
            addCriterion("adminLoginPwd not in", values, "adminloginpwd");
            return (Criteria) this;
        }

        public Criteria andAdminloginpwdBetween(String value1, String value2) {
            addCriterion("adminLoginPwd between", value1, value2, "adminloginpwd");
            return (Criteria) this;
        }

        public Criteria andAdminloginpwdNotBetween(String value1, String value2) {
            addCriterion("adminLoginPwd not between", value1, value2, "adminloginpwd");
            return (Criteria) this;
        }

        public Criteria andAdminloginpixIsNull() {
            addCriterion("adminLoginPix is null");
            return (Criteria) this;
        }

        public Criteria andAdminloginpixIsNotNull() {
            addCriterion("adminLoginPix is not null");
            return (Criteria) this;
        }

        public Criteria andAdminloginpixEqualTo(String value) {
            addCriterion("adminLoginPix =", value, "adminloginpix");
            return (Criteria) this;
        }

        public Criteria andAdminloginpixNotEqualTo(String value) {
            addCriterion("adminLoginPix <>", value, "adminloginpix");
            return (Criteria) this;
        }

        public Criteria andAdminloginpixGreaterThan(String value) {
            addCriterion("adminLoginPix >", value, "adminloginpix");
            return (Criteria) this;
        }

        public Criteria andAdminloginpixGreaterThanOrEqualTo(String value) {
            addCriterion("adminLoginPix >=", value, "adminloginpix");
            return (Criteria) this;
        }

        public Criteria andAdminloginpixLessThan(String value) {
            addCriterion("adminLoginPix <", value, "adminloginpix");
            return (Criteria) this;
        }

        public Criteria andAdminloginpixLessThanOrEqualTo(String value) {
            addCriterion("adminLoginPix <=", value, "adminloginpix");
            return (Criteria) this;
        }

        public Criteria andAdminloginpixLike(String value) {
            addCriterion("adminLoginPix like", value, "adminloginpix");
            return (Criteria) this;
        }

        public Criteria andAdminloginpixNotLike(String value) {
            addCriterion("adminLoginPix not like", value, "adminloginpix");
            return (Criteria) this;
        }

        public Criteria andAdminloginpixIn(List<String> values) {
            addCriterion("adminLoginPix in", values, "adminloginpix");
            return (Criteria) this;
        }

        public Criteria andAdminloginpixNotIn(List<String> values) {
            addCriterion("adminLoginPix not in", values, "adminloginpix");
            return (Criteria) this;
        }

        public Criteria andAdminloginpixBetween(String value1, String value2) {
            addCriterion("adminLoginPix between", value1, value2, "adminloginpix");
            return (Criteria) this;
        }

        public Criteria andAdminloginpixNotBetween(String value1, String value2) {
            addCriterion("adminLoginPix not between", value1, value2, "adminloginpix");
            return (Criteria) this;
        }

        public Criteria andAdminlogintokenIsNull() {
            addCriterion("adminLoginToken is null");
            return (Criteria) this;
        }

        public Criteria andAdminlogintokenIsNotNull() {
            addCriterion("adminLoginToken is not null");
            return (Criteria) this;
        }

        public Criteria andAdminlogintokenEqualTo(String value) {
            addCriterion("adminLoginToken =", value, "adminlogintoken");
            return (Criteria) this;
        }

        public Criteria andAdminlogintokenNotEqualTo(String value) {
            addCriterion("adminLoginToken <>", value, "adminlogintoken");
            return (Criteria) this;
        }

        public Criteria andAdminlogintokenGreaterThan(String value) {
            addCriterion("adminLoginToken >", value, "adminlogintoken");
            return (Criteria) this;
        }

        public Criteria andAdminlogintokenGreaterThanOrEqualTo(String value) {
            addCriterion("adminLoginToken >=", value, "adminlogintoken");
            return (Criteria) this;
        }

        public Criteria andAdminlogintokenLessThan(String value) {
            addCriterion("adminLoginToken <", value, "adminlogintoken");
            return (Criteria) this;
        }

        public Criteria andAdminlogintokenLessThanOrEqualTo(String value) {
            addCriterion("adminLoginToken <=", value, "adminlogintoken");
            return (Criteria) this;
        }

        public Criteria andAdminlogintokenLike(String value) {
            addCriterion("adminLoginToken like", value, "adminlogintoken");
            return (Criteria) this;
        }

        public Criteria andAdminlogintokenNotLike(String value) {
            addCriterion("adminLoginToken not like", value, "adminlogintoken");
            return (Criteria) this;
        }

        public Criteria andAdminlogintokenIn(List<String> values) {
            addCriterion("adminLoginToken in", values, "adminlogintoken");
            return (Criteria) this;
        }

        public Criteria andAdminlogintokenNotIn(List<String> values) {
            addCriterion("adminLoginToken not in", values, "adminlogintoken");
            return (Criteria) this;
        }

        public Criteria andAdminlogintokenBetween(String value1, String value2) {
            addCriterion("adminLoginToken between", value1, value2, "adminlogintoken");
            return (Criteria) this;
        }

        public Criteria andAdminlogintokenNotBetween(String value1, String value2) {
            addCriterion("adminLoginToken not between", value1, value2, "adminlogintoken");
            return (Criteria) this;
        }

        public Criteria andAdminlogintimeIsNull() {
            addCriterion("adminLoginTime is null");
            return (Criteria) this;
        }

        public Criteria andAdminlogintimeIsNotNull() {
            addCriterion("adminLoginTime is not null");
            return (Criteria) this;
        }

        public Criteria andAdminlogintimeEqualTo(Date value) {
            addCriterion("adminLoginTime =", value, "adminlogintime");
            return (Criteria) this;
        }

        public Criteria andAdminlogintimeNotEqualTo(Date value) {
            addCriterion("adminLoginTime <>", value, "adminlogintime");
            return (Criteria) this;
        }

        public Criteria andAdminlogintimeGreaterThan(Date value) {
            addCriterion("adminLoginTime >", value, "adminlogintime");
            return (Criteria) this;
        }

        public Criteria andAdminlogintimeGreaterThanOrEqualTo(Date value) {
            addCriterion("adminLoginTime >=", value, "adminlogintime");
            return (Criteria) this;
        }

        public Criteria andAdminlogintimeLessThan(Date value) {
            addCriterion("adminLoginTime <", value, "adminlogintime");
            return (Criteria) this;
        }

        public Criteria andAdminlogintimeLessThanOrEqualTo(Date value) {
            addCriterion("adminLoginTime <=", value, "adminlogintime");
            return (Criteria) this;
        }

        public Criteria andAdminlogintimeIn(List<Date> values) {
            addCriterion("adminLoginTime in", values, "adminlogintime");
            return (Criteria) this;
        }

        public Criteria andAdminlogintimeNotIn(List<Date> values) {
            addCriterion("adminLoginTime not in", values, "adminlogintime");
            return (Criteria) this;
        }

        public Criteria andAdminlogintimeBetween(Date value1, Date value2) {
            addCriterion("adminLoginTime between", value1, value2, "adminlogintime");
            return (Criteria) this;
        }

        public Criteria andAdminlogintimeNotBetween(Date value1, Date value2) {
            addCriterion("adminLoginTime not between", value1, value2, "adminlogintime");
            return (Criteria) this;
        }

        public Criteria andAdminloginlocIsNull() {
            addCriterion("adminLoginLoc is null");
            return (Criteria) this;
        }

        public Criteria andAdminloginlocIsNotNull() {
            addCriterion("adminLoginLoc is not null");
            return (Criteria) this;
        }

        public Criteria andAdminloginlocEqualTo(String value) {
            addCriterion("adminLoginLoc =", value, "adminloginloc");
            return (Criteria) this;
        }

        public Criteria andAdminloginlocNotEqualTo(String value) {
            addCriterion("adminLoginLoc <>", value, "adminloginloc");
            return (Criteria) this;
        }

        public Criteria andAdminloginlocGreaterThan(String value) {
            addCriterion("adminLoginLoc >", value, "adminloginloc");
            return (Criteria) this;
        }

        public Criteria andAdminloginlocGreaterThanOrEqualTo(String value) {
            addCriterion("adminLoginLoc >=", value, "adminloginloc");
            return (Criteria) this;
        }

        public Criteria andAdminloginlocLessThan(String value) {
            addCriterion("adminLoginLoc <", value, "adminloginloc");
            return (Criteria) this;
        }

        public Criteria andAdminloginlocLessThanOrEqualTo(String value) {
            addCriterion("adminLoginLoc <=", value, "adminloginloc");
            return (Criteria) this;
        }

        public Criteria andAdminloginlocLike(String value) {
            addCriterion("adminLoginLoc like", value, "adminloginloc");
            return (Criteria) this;
        }

        public Criteria andAdminloginlocNotLike(String value) {
            addCriterion("adminLoginLoc not like", value, "adminloginloc");
            return (Criteria) this;
        }

        public Criteria andAdminloginlocIn(List<String> values) {
            addCriterion("adminLoginLoc in", values, "adminloginloc");
            return (Criteria) this;
        }

        public Criteria andAdminloginlocNotIn(List<String> values) {
            addCriterion("adminLoginLoc not in", values, "adminloginloc");
            return (Criteria) this;
        }

        public Criteria andAdminloginlocBetween(String value1, String value2) {
            addCriterion("adminLoginLoc between", value1, value2, "adminloginloc");
            return (Criteria) this;
        }

        public Criteria andAdminloginlocNotBetween(String value1, String value2) {
            addCriterion("adminLoginLoc not between", value1, value2, "adminloginloc");
            return (Criteria) this;
        }

        public Criteria andAdminloginbverIsNull() {
            addCriterion("adminLoginBVer is null");
            return (Criteria) this;
        }

        public Criteria andAdminloginbverIsNotNull() {
            addCriterion("adminLoginBVer is not null");
            return (Criteria) this;
        }

        public Criteria andAdminloginbverEqualTo(String value) {
            addCriterion("adminLoginBVer =", value, "adminloginbver");
            return (Criteria) this;
        }

        public Criteria andAdminloginbverNotEqualTo(String value) {
            addCriterion("adminLoginBVer <>", value, "adminloginbver");
            return (Criteria) this;
        }

        public Criteria andAdminloginbverGreaterThan(String value) {
            addCriterion("adminLoginBVer >", value, "adminloginbver");
            return (Criteria) this;
        }

        public Criteria andAdminloginbverGreaterThanOrEqualTo(String value) {
            addCriterion("adminLoginBVer >=", value, "adminloginbver");
            return (Criteria) this;
        }

        public Criteria andAdminloginbverLessThan(String value) {
            addCriterion("adminLoginBVer <", value, "adminloginbver");
            return (Criteria) this;
        }

        public Criteria andAdminloginbverLessThanOrEqualTo(String value) {
            addCriterion("adminLoginBVer <=", value, "adminloginbver");
            return (Criteria) this;
        }

        public Criteria andAdminloginbverLike(String value) {
            addCriterion("adminLoginBVer like", value, "adminloginbver");
            return (Criteria) this;
        }

        public Criteria andAdminloginbverNotLike(String value) {
            addCriterion("adminLoginBVer not like", value, "adminloginbver");
            return (Criteria) this;
        }

        public Criteria andAdminloginbverIn(List<String> values) {
            addCriterion("adminLoginBVer in", values, "adminloginbver");
            return (Criteria) this;
        }

        public Criteria andAdminloginbverNotIn(List<String> values) {
            addCriterion("adminLoginBVer not in", values, "adminloginbver");
            return (Criteria) this;
        }

        public Criteria andAdminloginbverBetween(String value1, String value2) {
            addCriterion("adminLoginBVer between", value1, value2, "adminloginbver");
            return (Criteria) this;
        }

        public Criteria andAdminloginbverNotBetween(String value1, String value2) {
            addCriterion("adminLoginBVer not between", value1, value2, "adminloginbver");
            return (Criteria) this;
        }

        public Criteria andAdminloginmacIsNull() {
            addCriterion("adminLoginMac is null");
            return (Criteria) this;
        }

        public Criteria andAdminloginmacIsNotNull() {
            addCriterion("adminLoginMac is not null");
            return (Criteria) this;
        }

        public Criteria andAdminloginmacEqualTo(String value) {
            addCriterion("adminLoginMac =", value, "adminloginmac");
            return (Criteria) this;
        }

        public Criteria andAdminloginmacNotEqualTo(String value) {
            addCriterion("adminLoginMac <>", value, "adminloginmac");
            return (Criteria) this;
        }

        public Criteria andAdminloginmacGreaterThan(String value) {
            addCriterion("adminLoginMac >", value, "adminloginmac");
            return (Criteria) this;
        }

        public Criteria andAdminloginmacGreaterThanOrEqualTo(String value) {
            addCriterion("adminLoginMac >=", value, "adminloginmac");
            return (Criteria) this;
        }

        public Criteria andAdminloginmacLessThan(String value) {
            addCriterion("adminLoginMac <", value, "adminloginmac");
            return (Criteria) this;
        }

        public Criteria andAdminloginmacLessThanOrEqualTo(String value) {
            addCriterion("adminLoginMac <=", value, "adminloginmac");
            return (Criteria) this;
        }

        public Criteria andAdminloginmacLike(String value) {
            addCriterion("adminLoginMac like", value, "adminloginmac");
            return (Criteria) this;
        }

        public Criteria andAdminloginmacNotLike(String value) {
            addCriterion("adminLoginMac not like", value, "adminloginmac");
            return (Criteria) this;
        }

        public Criteria andAdminloginmacIn(List<String> values) {
            addCriterion("adminLoginMac in", values, "adminloginmac");
            return (Criteria) this;
        }

        public Criteria andAdminloginmacNotIn(List<String> values) {
            addCriterion("adminLoginMac not in", values, "adminloginmac");
            return (Criteria) this;
        }

        public Criteria andAdminloginmacBetween(String value1, String value2) {
            addCriterion("adminLoginMac between", value1, value2, "adminloginmac");
            return (Criteria) this;
        }

        public Criteria andAdminloginmacNotBetween(String value1, String value2) {
            addCriterion("adminLoginMac not between", value1, value2, "adminloginmac");
            return (Criteria) this;
        }

        public Criteria andAdminloginipIsNull() {
            addCriterion("adminLoginIp is null");
            return (Criteria) this;
        }

        public Criteria andAdminloginipIsNotNull() {
            addCriterion("adminLoginIp is not null");
            return (Criteria) this;
        }

        public Criteria andAdminloginipEqualTo(String value) {
            addCriterion("adminLoginIp =", value, "adminloginip");
            return (Criteria) this;
        }

        public Criteria andAdminloginipNotEqualTo(String value) {
            addCriterion("adminLoginIp <>", value, "adminloginip");
            return (Criteria) this;
        }

        public Criteria andAdminloginipGreaterThan(String value) {
            addCriterion("adminLoginIp >", value, "adminloginip");
            return (Criteria) this;
        }

        public Criteria andAdminloginipGreaterThanOrEqualTo(String value) {
            addCriterion("adminLoginIp >=", value, "adminloginip");
            return (Criteria) this;
        }

        public Criteria andAdminloginipLessThan(String value) {
            addCriterion("adminLoginIp <", value, "adminloginip");
            return (Criteria) this;
        }

        public Criteria andAdminloginipLessThanOrEqualTo(String value) {
            addCriterion("adminLoginIp <=", value, "adminloginip");
            return (Criteria) this;
        }

        public Criteria andAdminloginipLike(String value) {
            addCriterion("adminLoginIp like", value, "adminloginip");
            return (Criteria) this;
        }

        public Criteria andAdminloginipNotLike(String value) {
            addCriterion("adminLoginIp not like", value, "adminloginip");
            return (Criteria) this;
        }

        public Criteria andAdminloginipIn(List<String> values) {
            addCriterion("adminLoginIp in", values, "adminloginip");
            return (Criteria) this;
        }

        public Criteria andAdminloginipNotIn(List<String> values) {
            addCriterion("adminLoginIp not in", values, "adminloginip");
            return (Criteria) this;
        }

        public Criteria andAdminloginipBetween(String value1, String value2) {
            addCriterion("adminLoginIp between", value1, value2, "adminloginip");
            return (Criteria) this;
        }

        public Criteria andAdminloginipNotBetween(String value1, String value2) {
            addCriterion("adminLoginIp not between", value1, value2, "adminloginip");
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