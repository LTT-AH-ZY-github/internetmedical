package com.medical.po;

import java.util.ArrayList;
import java.util.List;

public class HospinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HospinfoExample() {
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

        public Criteria andHospidIsNull() {
            addCriterion("hospId is null");
            return (Criteria) this;
        }

        public Criteria andHospidIsNotNull() {
            addCriterion("hospId is not null");
            return (Criteria) this;
        }

        public Criteria andHospidEqualTo(Integer value) {
            addCriterion("hospId =", value, "hospid");
            return (Criteria) this;
        }

        public Criteria andHospidNotEqualTo(Integer value) {
            addCriterion("hospId <>", value, "hospid");
            return (Criteria) this;
        }

        public Criteria andHospidGreaterThan(Integer value) {
            addCriterion("hospId >", value, "hospid");
            return (Criteria) this;
        }

        public Criteria andHospidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hospId >=", value, "hospid");
            return (Criteria) this;
        }

        public Criteria andHospidLessThan(Integer value) {
            addCriterion("hospId <", value, "hospid");
            return (Criteria) this;
        }

        public Criteria andHospidLessThanOrEqualTo(Integer value) {
            addCriterion("hospId <=", value, "hospid");
            return (Criteria) this;
        }

        public Criteria andHospidIn(List<Integer> values) {
            addCriterion("hospId in", values, "hospid");
            return (Criteria) this;
        }

        public Criteria andHospidNotIn(List<Integer> values) {
            addCriterion("hospId not in", values, "hospid");
            return (Criteria) this;
        }

        public Criteria andHospidBetween(Integer value1, Integer value2) {
            addCriterion("hospId between", value1, value2, "hospid");
            return (Criteria) this;
        }

        public Criteria andHospidNotBetween(Integer value1, Integer value2) {
            addCriterion("hospId not between", value1, value2, "hospid");
            return (Criteria) this;
        }

        public Criteria andHospnameIsNull() {
            addCriterion("hospName is null");
            return (Criteria) this;
        }

        public Criteria andHospnameIsNotNull() {
            addCriterion("hospName is not null");
            return (Criteria) this;
        }

        public Criteria andHospnameEqualTo(String value) {
            addCriterion("hospName =", value, "hospname");
            return (Criteria) this;
        }

        public Criteria andHospnameNotEqualTo(String value) {
            addCriterion("hospName <>", value, "hospname");
            return (Criteria) this;
        }

        public Criteria andHospnameGreaterThan(String value) {
            addCriterion("hospName >", value, "hospname");
            return (Criteria) this;
        }

        public Criteria andHospnameGreaterThanOrEqualTo(String value) {
            addCriterion("hospName >=", value, "hospname");
            return (Criteria) this;
        }

        public Criteria andHospnameLessThan(String value) {
            addCriterion("hospName <", value, "hospname");
            return (Criteria) this;
        }

        public Criteria andHospnameLessThanOrEqualTo(String value) {
            addCriterion("hospName <=", value, "hospname");
            return (Criteria) this;
        }

        public Criteria andHospnameLike(String value) {
            addCriterion("hospName like", value, "hospname");
            return (Criteria) this;
        }

        public Criteria andHospnameNotLike(String value) {
            addCriterion("hospName not like", value, "hospname");
            return (Criteria) this;
        }

        public Criteria andHospnameIn(List<String> values) {
            addCriterion("hospName in", values, "hospname");
            return (Criteria) this;
        }

        public Criteria andHospnameNotIn(List<String> values) {
            addCriterion("hospName not in", values, "hospname");
            return (Criteria) this;
        }

        public Criteria andHospnameBetween(String value1, String value2) {
            addCriterion("hospName between", value1, value2, "hospname");
            return (Criteria) this;
        }

        public Criteria andHospnameNotBetween(String value1, String value2) {
            addCriterion("hospName not between", value1, value2, "hospname");
            return (Criteria) this;
        }

        public Criteria andHospadrIsNull() {
            addCriterion("hospAdr is null");
            return (Criteria) this;
        }

        public Criteria andHospadrIsNotNull() {
            addCriterion("hospAdr is not null");
            return (Criteria) this;
        }

        public Criteria andHospadrEqualTo(String value) {
            addCriterion("hospAdr =", value, "hospadr");
            return (Criteria) this;
        }

        public Criteria andHospadrNotEqualTo(String value) {
            addCriterion("hospAdr <>", value, "hospadr");
            return (Criteria) this;
        }

        public Criteria andHospadrGreaterThan(String value) {
            addCriterion("hospAdr >", value, "hospadr");
            return (Criteria) this;
        }

        public Criteria andHospadrGreaterThanOrEqualTo(String value) {
            addCriterion("hospAdr >=", value, "hospadr");
            return (Criteria) this;
        }

        public Criteria andHospadrLessThan(String value) {
            addCriterion("hospAdr <", value, "hospadr");
            return (Criteria) this;
        }

        public Criteria andHospadrLessThanOrEqualTo(String value) {
            addCriterion("hospAdr <=", value, "hospadr");
            return (Criteria) this;
        }

        public Criteria andHospadrLike(String value) {
            addCriterion("hospAdr like", value, "hospadr");
            return (Criteria) this;
        }

        public Criteria andHospadrNotLike(String value) {
            addCriterion("hospAdr not like", value, "hospadr");
            return (Criteria) this;
        }

        public Criteria andHospadrIn(List<String> values) {
            addCriterion("hospAdr in", values, "hospadr");
            return (Criteria) this;
        }

        public Criteria andHospadrNotIn(List<String> values) {
            addCriterion("hospAdr not in", values, "hospadr");
            return (Criteria) this;
        }

        public Criteria andHospadrBetween(String value1, String value2) {
            addCriterion("hospAdr between", value1, value2, "hospadr");
            return (Criteria) this;
        }

        public Criteria andHospadrNotBetween(String value1, String value2) {
            addCriterion("hospAdr not between", value1, value2, "hospadr");
            return (Criteria) this;
        }

        public Criteria andHospphoneIsNull() {
            addCriterion("hospPhone is null");
            return (Criteria) this;
        }

        public Criteria andHospphoneIsNotNull() {
            addCriterion("hospPhone is not null");
            return (Criteria) this;
        }

        public Criteria andHospphoneEqualTo(String value) {
            addCriterion("hospPhone =", value, "hospphone");
            return (Criteria) this;
        }

        public Criteria andHospphoneNotEqualTo(String value) {
            addCriterion("hospPhone <>", value, "hospphone");
            return (Criteria) this;
        }

        public Criteria andHospphoneGreaterThan(String value) {
            addCriterion("hospPhone >", value, "hospphone");
            return (Criteria) this;
        }

        public Criteria andHospphoneGreaterThanOrEqualTo(String value) {
            addCriterion("hospPhone >=", value, "hospphone");
            return (Criteria) this;
        }

        public Criteria andHospphoneLessThan(String value) {
            addCriterion("hospPhone <", value, "hospphone");
            return (Criteria) this;
        }

        public Criteria andHospphoneLessThanOrEqualTo(String value) {
            addCriterion("hospPhone <=", value, "hospphone");
            return (Criteria) this;
        }

        public Criteria andHospphoneLike(String value) {
            addCriterion("hospPhone like", value, "hospphone");
            return (Criteria) this;
        }

        public Criteria andHospphoneNotLike(String value) {
            addCriterion("hospPhone not like", value, "hospphone");
            return (Criteria) this;
        }

        public Criteria andHospphoneIn(List<String> values) {
            addCriterion("hospPhone in", values, "hospphone");
            return (Criteria) this;
        }

        public Criteria andHospphoneNotIn(List<String> values) {
            addCriterion("hospPhone not in", values, "hospphone");
            return (Criteria) this;
        }

        public Criteria andHospphoneBetween(String value1, String value2) {
            addCriterion("hospPhone between", value1, value2, "hospphone");
            return (Criteria) this;
        }

        public Criteria andHospphoneNotBetween(String value1, String value2) {
            addCriterion("hospPhone not between", value1, value2, "hospphone");
            return (Criteria) this;
        }

        public Criteria andHospabsIsNull() {
            addCriterion("hospAbs is null");
            return (Criteria) this;
        }

        public Criteria andHospabsIsNotNull() {
            addCriterion("hospAbs is not null");
            return (Criteria) this;
        }

        public Criteria andHospabsEqualTo(String value) {
            addCriterion("hospAbs =", value, "hospabs");
            return (Criteria) this;
        }

        public Criteria andHospabsNotEqualTo(String value) {
            addCriterion("hospAbs <>", value, "hospabs");
            return (Criteria) this;
        }

        public Criteria andHospabsGreaterThan(String value) {
            addCriterion("hospAbs >", value, "hospabs");
            return (Criteria) this;
        }

        public Criteria andHospabsGreaterThanOrEqualTo(String value) {
            addCriterion("hospAbs >=", value, "hospabs");
            return (Criteria) this;
        }

        public Criteria andHospabsLessThan(String value) {
            addCriterion("hospAbs <", value, "hospabs");
            return (Criteria) this;
        }

        public Criteria andHospabsLessThanOrEqualTo(String value) {
            addCriterion("hospAbs <=", value, "hospabs");
            return (Criteria) this;
        }

        public Criteria andHospabsLike(String value) {
            addCriterion("hospAbs like", value, "hospabs");
            return (Criteria) this;
        }

        public Criteria andHospabsNotLike(String value) {
            addCriterion("hospAbs not like", value, "hospabs");
            return (Criteria) this;
        }

        public Criteria andHospabsIn(List<String> values) {
            addCriterion("hospAbs in", values, "hospabs");
            return (Criteria) this;
        }

        public Criteria andHospabsNotIn(List<String> values) {
            addCriterion("hospAbs not in", values, "hospabs");
            return (Criteria) this;
        }

        public Criteria andHospabsBetween(String value1, String value2) {
            addCriterion("hospAbs between", value1, value2, "hospabs");
            return (Criteria) this;
        }

        public Criteria andHospabsNotBetween(String value1, String value2) {
            addCriterion("hospAbs not between", value1, value2, "hospabs");
            return (Criteria) this;
        }

        public Criteria andHospgradeIsNull() {
            addCriterion("hospGrade is null");
            return (Criteria) this;
        }

        public Criteria andHospgradeIsNotNull() {
            addCriterion("hospGrade is not null");
            return (Criteria) this;
        }

        public Criteria andHospgradeEqualTo(String value) {
            addCriterion("hospGrade =", value, "hospgrade");
            return (Criteria) this;
        }

        public Criteria andHospgradeNotEqualTo(String value) {
            addCriterion("hospGrade <>", value, "hospgrade");
            return (Criteria) this;
        }

        public Criteria andHospgradeGreaterThan(String value) {
            addCriterion("hospGrade >", value, "hospgrade");
            return (Criteria) this;
        }

        public Criteria andHospgradeGreaterThanOrEqualTo(String value) {
            addCriterion("hospGrade >=", value, "hospgrade");
            return (Criteria) this;
        }

        public Criteria andHospgradeLessThan(String value) {
            addCriterion("hospGrade <", value, "hospgrade");
            return (Criteria) this;
        }

        public Criteria andHospgradeLessThanOrEqualTo(String value) {
            addCriterion("hospGrade <=", value, "hospgrade");
            return (Criteria) this;
        }

        public Criteria andHospgradeLike(String value) {
            addCriterion("hospGrade like", value, "hospgrade");
            return (Criteria) this;
        }

        public Criteria andHospgradeNotLike(String value) {
            addCriterion("hospGrade not like", value, "hospgrade");
            return (Criteria) this;
        }

        public Criteria andHospgradeIn(List<String> values) {
            addCriterion("hospGrade in", values, "hospgrade");
            return (Criteria) this;
        }

        public Criteria andHospgradeNotIn(List<String> values) {
            addCriterion("hospGrade not in", values, "hospgrade");
            return (Criteria) this;
        }

        public Criteria andHospgradeBetween(String value1, String value2) {
            addCriterion("hospGrade between", value1, value2, "hospgrade");
            return (Criteria) this;
        }

        public Criteria andHospgradeNotBetween(String value1, String value2) {
            addCriterion("hospGrade not between", value1, value2, "hospgrade");
            return (Criteria) this;
        }

        public Criteria andHospdeptIsNull() {
            addCriterion("hospDept is null");
            return (Criteria) this;
        }

        public Criteria andHospdeptIsNotNull() {
            addCriterion("hospDept is not null");
            return (Criteria) this;
        }

        public Criteria andHospdeptEqualTo(String value) {
            addCriterion("hospDept =", value, "hospdept");
            return (Criteria) this;
        }

        public Criteria andHospdeptNotEqualTo(String value) {
            addCriterion("hospDept <>", value, "hospdept");
            return (Criteria) this;
        }

        public Criteria andHospdeptGreaterThan(String value) {
            addCriterion("hospDept >", value, "hospdept");
            return (Criteria) this;
        }

        public Criteria andHospdeptGreaterThanOrEqualTo(String value) {
            addCriterion("hospDept >=", value, "hospdept");
            return (Criteria) this;
        }

        public Criteria andHospdeptLessThan(String value) {
            addCriterion("hospDept <", value, "hospdept");
            return (Criteria) this;
        }

        public Criteria andHospdeptLessThanOrEqualTo(String value) {
            addCriterion("hospDept <=", value, "hospdept");
            return (Criteria) this;
        }

        public Criteria andHospdeptLike(String value) {
            addCriterion("hospDept like", value, "hospdept");
            return (Criteria) this;
        }

        public Criteria andHospdeptNotLike(String value) {
            addCriterion("hospDept not like", value, "hospdept");
            return (Criteria) this;
        }

        public Criteria andHospdeptIn(List<String> values) {
            addCriterion("hospDept in", values, "hospdept");
            return (Criteria) this;
        }

        public Criteria andHospdeptNotIn(List<String> values) {
            addCriterion("hospDept not in", values, "hospdept");
            return (Criteria) this;
        }

        public Criteria andHospdeptBetween(String value1, String value2) {
            addCriterion("hospDept between", value1, value2, "hospdept");
            return (Criteria) this;
        }

        public Criteria andHospdeptNotBetween(String value1, String value2) {
            addCriterion("hospDept not between", value1, value2, "hospdept");
            return (Criteria) this;
        }

        public Criteria andHospfeatureIsNull() {
            addCriterion("hospFeature is null");
            return (Criteria) this;
        }

        public Criteria andHospfeatureIsNotNull() {
            addCriterion("hospFeature is not null");
            return (Criteria) this;
        }

        public Criteria andHospfeatureEqualTo(String value) {
            addCriterion("hospFeature =", value, "hospfeature");
            return (Criteria) this;
        }

        public Criteria andHospfeatureNotEqualTo(String value) {
            addCriterion("hospFeature <>", value, "hospfeature");
            return (Criteria) this;
        }

        public Criteria andHospfeatureGreaterThan(String value) {
            addCriterion("hospFeature >", value, "hospfeature");
            return (Criteria) this;
        }

        public Criteria andHospfeatureGreaterThanOrEqualTo(String value) {
            addCriterion("hospFeature >=", value, "hospfeature");
            return (Criteria) this;
        }

        public Criteria andHospfeatureLessThan(String value) {
            addCriterion("hospFeature <", value, "hospfeature");
            return (Criteria) this;
        }

        public Criteria andHospfeatureLessThanOrEqualTo(String value) {
            addCriterion("hospFeature <=", value, "hospfeature");
            return (Criteria) this;
        }

        public Criteria andHospfeatureLike(String value) {
            addCriterion("hospFeature like", value, "hospfeature");
            return (Criteria) this;
        }

        public Criteria andHospfeatureNotLike(String value) {
            addCriterion("hospFeature not like", value, "hospfeature");
            return (Criteria) this;
        }

        public Criteria andHospfeatureIn(List<String> values) {
            addCriterion("hospFeature in", values, "hospfeature");
            return (Criteria) this;
        }

        public Criteria andHospfeatureNotIn(List<String> values) {
            addCriterion("hospFeature not in", values, "hospfeature");
            return (Criteria) this;
        }

        public Criteria andHospfeatureBetween(String value1, String value2) {
            addCriterion("hospFeature between", value1, value2, "hospfeature");
            return (Criteria) this;
        }

        public Criteria andHospfeatureNotBetween(String value1, String value2) {
            addCriterion("hospFeature not between", value1, value2, "hospfeature");
            return (Criteria) this;
        }

        public Criteria andHospregdocquacerIsNull() {
            addCriterion("hospRegDocQuaCer is null");
            return (Criteria) this;
        }

        public Criteria andHospregdocquacerIsNotNull() {
            addCriterion("hospRegDocQuaCer is not null");
            return (Criteria) this;
        }

        public Criteria andHospregdocquacerEqualTo(String value) {
            addCriterion("hospRegDocQuaCer =", value, "hospregdocquacer");
            return (Criteria) this;
        }

        public Criteria andHospregdocquacerNotEqualTo(String value) {
            addCriterion("hospRegDocQuaCer <>", value, "hospregdocquacer");
            return (Criteria) this;
        }

        public Criteria andHospregdocquacerGreaterThan(String value) {
            addCriterion("hospRegDocQuaCer >", value, "hospregdocquacer");
            return (Criteria) this;
        }

        public Criteria andHospregdocquacerGreaterThanOrEqualTo(String value) {
            addCriterion("hospRegDocQuaCer >=", value, "hospregdocquacer");
            return (Criteria) this;
        }

        public Criteria andHospregdocquacerLessThan(String value) {
            addCriterion("hospRegDocQuaCer <", value, "hospregdocquacer");
            return (Criteria) this;
        }

        public Criteria andHospregdocquacerLessThanOrEqualTo(String value) {
            addCriterion("hospRegDocQuaCer <=", value, "hospregdocquacer");
            return (Criteria) this;
        }

        public Criteria andHospregdocquacerLike(String value) {
            addCriterion("hospRegDocQuaCer like", value, "hospregdocquacer");
            return (Criteria) this;
        }

        public Criteria andHospregdocquacerNotLike(String value) {
            addCriterion("hospRegDocQuaCer not like", value, "hospregdocquacer");
            return (Criteria) this;
        }

        public Criteria andHospregdocquacerIn(List<String> values) {
            addCriterion("hospRegDocQuaCer in", values, "hospregdocquacer");
            return (Criteria) this;
        }

        public Criteria andHospregdocquacerNotIn(List<String> values) {
            addCriterion("hospRegDocQuaCer not in", values, "hospregdocquacer");
            return (Criteria) this;
        }

        public Criteria andHospregdocquacerBetween(String value1, String value2) {
            addCriterion("hospRegDocQuaCer between", value1, value2, "hospregdocquacer");
            return (Criteria) this;
        }

        public Criteria andHospregdocquacerNotBetween(String value1, String value2) {
            addCriterion("hospRegDocQuaCer not between", value1, value2, "hospregdocquacer");
            return (Criteria) this;
        }

        public Criteria andHospregidcardIsNull() {
            addCriterion("hospRegIdCard is null");
            return (Criteria) this;
        }

        public Criteria andHospregidcardIsNotNull() {
            addCriterion("hospRegIdCard is not null");
            return (Criteria) this;
        }

        public Criteria andHospregidcardEqualTo(String value) {
            addCriterion("hospRegIdCard =", value, "hospregidcard");
            return (Criteria) this;
        }

        public Criteria andHospregidcardNotEqualTo(String value) {
            addCriterion("hospRegIdCard <>", value, "hospregidcard");
            return (Criteria) this;
        }

        public Criteria andHospregidcardGreaterThan(String value) {
            addCriterion("hospRegIdCard >", value, "hospregidcard");
            return (Criteria) this;
        }

        public Criteria andHospregidcardGreaterThanOrEqualTo(String value) {
            addCriterion("hospRegIdCard >=", value, "hospregidcard");
            return (Criteria) this;
        }

        public Criteria andHospregidcardLessThan(String value) {
            addCriterion("hospRegIdCard <", value, "hospregidcard");
            return (Criteria) this;
        }

        public Criteria andHospregidcardLessThanOrEqualTo(String value) {
            addCriterion("hospRegIdCard <=", value, "hospregidcard");
            return (Criteria) this;
        }

        public Criteria andHospregidcardLike(String value) {
            addCriterion("hospRegIdCard like", value, "hospregidcard");
            return (Criteria) this;
        }

        public Criteria andHospregidcardNotLike(String value) {
            addCriterion("hospRegIdCard not like", value, "hospregidcard");
            return (Criteria) this;
        }

        public Criteria andHospregidcardIn(List<String> values) {
            addCriterion("hospRegIdCard in", values, "hospregidcard");
            return (Criteria) this;
        }

        public Criteria andHospregidcardNotIn(List<String> values) {
            addCriterion("hospRegIdCard not in", values, "hospregidcard");
            return (Criteria) this;
        }

        public Criteria andHospregidcardBetween(String value1, String value2) {
            addCriterion("hospRegIdCard between", value1, value2, "hospregidcard");
            return (Criteria) this;
        }

        public Criteria andHospregidcardNotBetween(String value1, String value2) {
            addCriterion("hospRegIdCard not between", value1, value2, "hospregidcard");
            return (Criteria) this;
        }

        public Criteria andHosporgcodecerIsNull() {
            addCriterion("hospOrgCodeCer is null");
            return (Criteria) this;
        }

        public Criteria andHosporgcodecerIsNotNull() {
            addCriterion("hospOrgCodeCer is not null");
            return (Criteria) this;
        }

        public Criteria andHosporgcodecerEqualTo(String value) {
            addCriterion("hospOrgCodeCer =", value, "hosporgcodecer");
            return (Criteria) this;
        }

        public Criteria andHosporgcodecerNotEqualTo(String value) {
            addCriterion("hospOrgCodeCer <>", value, "hosporgcodecer");
            return (Criteria) this;
        }

        public Criteria andHosporgcodecerGreaterThan(String value) {
            addCriterion("hospOrgCodeCer >", value, "hosporgcodecer");
            return (Criteria) this;
        }

        public Criteria andHosporgcodecerGreaterThanOrEqualTo(String value) {
            addCriterion("hospOrgCodeCer >=", value, "hosporgcodecer");
            return (Criteria) this;
        }

        public Criteria andHosporgcodecerLessThan(String value) {
            addCriterion("hospOrgCodeCer <", value, "hosporgcodecer");
            return (Criteria) this;
        }

        public Criteria andHosporgcodecerLessThanOrEqualTo(String value) {
            addCriterion("hospOrgCodeCer <=", value, "hosporgcodecer");
            return (Criteria) this;
        }

        public Criteria andHosporgcodecerLike(String value) {
            addCriterion("hospOrgCodeCer like", value, "hosporgcodecer");
            return (Criteria) this;
        }

        public Criteria andHosporgcodecerNotLike(String value) {
            addCriterion("hospOrgCodeCer not like", value, "hosporgcodecer");
            return (Criteria) this;
        }

        public Criteria andHosporgcodecerIn(List<String> values) {
            addCriterion("hospOrgCodeCer in", values, "hosporgcodecer");
            return (Criteria) this;
        }

        public Criteria andHosporgcodecerNotIn(List<String> values) {
            addCriterion("hospOrgCodeCer not in", values, "hosporgcodecer");
            return (Criteria) this;
        }

        public Criteria andHosporgcodecerBetween(String value1, String value2) {
            addCriterion("hospOrgCodeCer between", value1, value2, "hosporgcodecer");
            return (Criteria) this;
        }

        public Criteria andHosporgcodecerNotBetween(String value1, String value2) {
            addCriterion("hospOrgCodeCer not between", value1, value2, "hosporgcodecer");
            return (Criteria) this;
        }

        public Criteria andHosppraclicenseIsNull() {
            addCriterion("hospPracLicense is null");
            return (Criteria) this;
        }

        public Criteria andHosppraclicenseIsNotNull() {
            addCriterion("hospPracLicense is not null");
            return (Criteria) this;
        }

        public Criteria andHosppraclicenseEqualTo(String value) {
            addCriterion("hospPracLicense =", value, "hosppraclicense");
            return (Criteria) this;
        }

        public Criteria andHosppraclicenseNotEqualTo(String value) {
            addCriterion("hospPracLicense <>", value, "hosppraclicense");
            return (Criteria) this;
        }

        public Criteria andHosppraclicenseGreaterThan(String value) {
            addCriterion("hospPracLicense >", value, "hosppraclicense");
            return (Criteria) this;
        }

        public Criteria andHosppraclicenseGreaterThanOrEqualTo(String value) {
            addCriterion("hospPracLicense >=", value, "hosppraclicense");
            return (Criteria) this;
        }

        public Criteria andHosppraclicenseLessThan(String value) {
            addCriterion("hospPracLicense <", value, "hosppraclicense");
            return (Criteria) this;
        }

        public Criteria andHosppraclicenseLessThanOrEqualTo(String value) {
            addCriterion("hospPracLicense <=", value, "hosppraclicense");
            return (Criteria) this;
        }

        public Criteria andHosppraclicenseLike(String value) {
            addCriterion("hospPracLicense like", value, "hosppraclicense");
            return (Criteria) this;
        }

        public Criteria andHosppraclicenseNotLike(String value) {
            addCriterion("hospPracLicense not like", value, "hosppraclicense");
            return (Criteria) this;
        }

        public Criteria andHosppraclicenseIn(List<String> values) {
            addCriterion("hospPracLicense in", values, "hosppraclicense");
            return (Criteria) this;
        }

        public Criteria andHosppraclicenseNotIn(List<String> values) {
            addCriterion("hospPracLicense not in", values, "hosppraclicense");
            return (Criteria) this;
        }

        public Criteria andHosppraclicenseBetween(String value1, String value2) {
            addCriterion("hospPracLicense between", value1, value2, "hosppraclicense");
            return (Criteria) this;
        }

        public Criteria andHosppraclicenseNotBetween(String value1, String value2) {
            addCriterion("hospPracLicense not between", value1, value2, "hosppraclicense");
            return (Criteria) this;
        }

        public Criteria andHosplegalcerIsNull() {
            addCriterion("hospLegalCer is null");
            return (Criteria) this;
        }

        public Criteria andHosplegalcerIsNotNull() {
            addCriterion("hospLegalCer is not null");
            return (Criteria) this;
        }

        public Criteria andHosplegalcerEqualTo(String value) {
            addCriterion("hospLegalCer =", value, "hosplegalcer");
            return (Criteria) this;
        }

        public Criteria andHosplegalcerNotEqualTo(String value) {
            addCriterion("hospLegalCer <>", value, "hosplegalcer");
            return (Criteria) this;
        }

        public Criteria andHosplegalcerGreaterThan(String value) {
            addCriterion("hospLegalCer >", value, "hosplegalcer");
            return (Criteria) this;
        }

        public Criteria andHosplegalcerGreaterThanOrEqualTo(String value) {
            addCriterion("hospLegalCer >=", value, "hosplegalcer");
            return (Criteria) this;
        }

        public Criteria andHosplegalcerLessThan(String value) {
            addCriterion("hospLegalCer <", value, "hosplegalcer");
            return (Criteria) this;
        }

        public Criteria andHosplegalcerLessThanOrEqualTo(String value) {
            addCriterion("hospLegalCer <=", value, "hosplegalcer");
            return (Criteria) this;
        }

        public Criteria andHosplegalcerLike(String value) {
            addCriterion("hospLegalCer like", value, "hosplegalcer");
            return (Criteria) this;
        }

        public Criteria andHosplegalcerNotLike(String value) {
            addCriterion("hospLegalCer not like", value, "hosplegalcer");
            return (Criteria) this;
        }

        public Criteria andHosplegalcerIn(List<String> values) {
            addCriterion("hospLegalCer in", values, "hosplegalcer");
            return (Criteria) this;
        }

        public Criteria andHosplegalcerNotIn(List<String> values) {
            addCriterion("hospLegalCer not in", values, "hosplegalcer");
            return (Criteria) this;
        }

        public Criteria andHosplegalcerBetween(String value1, String value2) {
            addCriterion("hospLegalCer between", value1, value2, "hosplegalcer");
            return (Criteria) this;
        }

        public Criteria andHosplegalcerNotBetween(String value1, String value2) {
            addCriterion("hospLegalCer not between", value1, value2, "hosplegalcer");
            return (Criteria) this;
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