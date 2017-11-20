package com.medical.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HospitalcommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HospitalcommentExample() {
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

        public Criteria andHospcommentidIsNull() {
            addCriterion("hospCommentId is null");
            return (Criteria) this;
        }

        public Criteria andHospcommentidIsNotNull() {
            addCriterion("hospCommentId is not null");
            return (Criteria) this;
        }

        public Criteria andHospcommentidEqualTo(Integer value) {
            addCriterion("hospCommentId =", value, "hospcommentid");
            return (Criteria) this;
        }

        public Criteria andHospcommentidNotEqualTo(Integer value) {
            addCriterion("hospCommentId <>", value, "hospcommentid");
            return (Criteria) this;
        }

        public Criteria andHospcommentidGreaterThan(Integer value) {
            addCriterion("hospCommentId >", value, "hospcommentid");
            return (Criteria) this;
        }

        public Criteria andHospcommentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hospCommentId >=", value, "hospcommentid");
            return (Criteria) this;
        }

        public Criteria andHospcommentidLessThan(Integer value) {
            addCriterion("hospCommentId <", value, "hospcommentid");
            return (Criteria) this;
        }

        public Criteria andHospcommentidLessThanOrEqualTo(Integer value) {
            addCriterion("hospCommentId <=", value, "hospcommentid");
            return (Criteria) this;
        }

        public Criteria andHospcommentidIn(List<Integer> values) {
            addCriterion("hospCommentId in", values, "hospcommentid");
            return (Criteria) this;
        }

        public Criteria andHospcommentidNotIn(List<Integer> values) {
            addCriterion("hospCommentId not in", values, "hospcommentid");
            return (Criteria) this;
        }

        public Criteria andHospcommentidBetween(Integer value1, Integer value2) {
            addCriterion("hospCommentId between", value1, value2, "hospcommentid");
            return (Criteria) this;
        }

        public Criteria andHospcommentidNotBetween(Integer value1, Integer value2) {
            addCriterion("hospCommentId not between", value1, value2, "hospcommentid");
            return (Criteria) this;
        }

        public Criteria andHospcommentfatheridIsNull() {
            addCriterion("hospCommentFatherId is null");
            return (Criteria) this;
        }

        public Criteria andHospcommentfatheridIsNotNull() {
            addCriterion("hospCommentFatherId is not null");
            return (Criteria) this;
        }

        public Criteria andHospcommentfatheridEqualTo(Integer value) {
            addCriterion("hospCommentFatherId =", value, "hospcommentfatherid");
            return (Criteria) this;
        }

        public Criteria andHospcommentfatheridNotEqualTo(Integer value) {
            addCriterion("hospCommentFatherId <>", value, "hospcommentfatherid");
            return (Criteria) this;
        }

        public Criteria andHospcommentfatheridGreaterThan(Integer value) {
            addCriterion("hospCommentFatherId >", value, "hospcommentfatherid");
            return (Criteria) this;
        }

        public Criteria andHospcommentfatheridGreaterThanOrEqualTo(Integer value) {
            addCriterion("hospCommentFatherId >=", value, "hospcommentfatherid");
            return (Criteria) this;
        }

        public Criteria andHospcommentfatheridLessThan(Integer value) {
            addCriterion("hospCommentFatherId <", value, "hospcommentfatherid");
            return (Criteria) this;
        }

        public Criteria andHospcommentfatheridLessThanOrEqualTo(Integer value) {
            addCriterion("hospCommentFatherId <=", value, "hospcommentfatherid");
            return (Criteria) this;
        }

        public Criteria andHospcommentfatheridIn(List<Integer> values) {
            addCriterion("hospCommentFatherId in", values, "hospcommentfatherid");
            return (Criteria) this;
        }

        public Criteria andHospcommentfatheridNotIn(List<Integer> values) {
            addCriterion("hospCommentFatherId not in", values, "hospcommentfatherid");
            return (Criteria) this;
        }

        public Criteria andHospcommentfatheridBetween(Integer value1, Integer value2) {
            addCriterion("hospCommentFatherId between", value1, value2, "hospcommentfatherid");
            return (Criteria) this;
        }

        public Criteria andHospcommentfatheridNotBetween(Integer value1, Integer value2) {
            addCriterion("hospCommentFatherId not between", value1, value2, "hospcommentfatherid");
            return (Criteria) this;
        }

        public Criteria andHospcommentgradeIsNull() {
            addCriterion("hospCommentGrade is null");
            return (Criteria) this;
        }

        public Criteria andHospcommentgradeIsNotNull() {
            addCriterion("hospCommentGrade is not null");
            return (Criteria) this;
        }

        public Criteria andHospcommentgradeEqualTo(Integer value) {
            addCriterion("hospCommentGrade =", value, "hospcommentgrade");
            return (Criteria) this;
        }

        public Criteria andHospcommentgradeNotEqualTo(Integer value) {
            addCriterion("hospCommentGrade <>", value, "hospcommentgrade");
            return (Criteria) this;
        }

        public Criteria andHospcommentgradeGreaterThan(Integer value) {
            addCriterion("hospCommentGrade >", value, "hospcommentgrade");
            return (Criteria) this;
        }

        public Criteria andHospcommentgradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("hospCommentGrade >=", value, "hospcommentgrade");
            return (Criteria) this;
        }

        public Criteria andHospcommentgradeLessThan(Integer value) {
            addCriterion("hospCommentGrade <", value, "hospcommentgrade");
            return (Criteria) this;
        }

        public Criteria andHospcommentgradeLessThanOrEqualTo(Integer value) {
            addCriterion("hospCommentGrade <=", value, "hospcommentgrade");
            return (Criteria) this;
        }

        public Criteria andHospcommentgradeIn(List<Integer> values) {
            addCriterion("hospCommentGrade in", values, "hospcommentgrade");
            return (Criteria) this;
        }

        public Criteria andHospcommentgradeNotIn(List<Integer> values) {
            addCriterion("hospCommentGrade not in", values, "hospcommentgrade");
            return (Criteria) this;
        }

        public Criteria andHospcommentgradeBetween(Integer value1, Integer value2) {
            addCriterion("hospCommentGrade between", value1, value2, "hospcommentgrade");
            return (Criteria) this;
        }

        public Criteria andHospcommentgradeNotBetween(Integer value1, Integer value2) {
            addCriterion("hospCommentGrade not between", value1, value2, "hospcommentgrade");
            return (Criteria) this;
        }

        public Criteria andHospcommentservicelevelIsNull() {
            addCriterion("hospCommentServiceLevel is null");
            return (Criteria) this;
        }

        public Criteria andHospcommentservicelevelIsNotNull() {
            addCriterion("hospCommentServiceLevel is not null");
            return (Criteria) this;
        }

        public Criteria andHospcommentservicelevelEqualTo(Integer value) {
            addCriterion("hospCommentServiceLevel =", value, "hospcommentservicelevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentservicelevelNotEqualTo(Integer value) {
            addCriterion("hospCommentServiceLevel <>", value, "hospcommentservicelevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentservicelevelGreaterThan(Integer value) {
            addCriterion("hospCommentServiceLevel >", value, "hospcommentservicelevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentservicelevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("hospCommentServiceLevel >=", value, "hospcommentservicelevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentservicelevelLessThan(Integer value) {
            addCriterion("hospCommentServiceLevel <", value, "hospcommentservicelevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentservicelevelLessThanOrEqualTo(Integer value) {
            addCriterion("hospCommentServiceLevel <=", value, "hospcommentservicelevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentservicelevelIn(List<Integer> values) {
            addCriterion("hospCommentServiceLevel in", values, "hospcommentservicelevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentservicelevelNotIn(List<Integer> values) {
            addCriterion("hospCommentServiceLevel not in", values, "hospcommentservicelevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentservicelevelBetween(Integer value1, Integer value2) {
            addCriterion("hospCommentServiceLevel between", value1, value2, "hospcommentservicelevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentservicelevelNotBetween(Integer value1, Integer value2) {
            addCriterion("hospCommentServiceLevel not between", value1, value2, "hospcommentservicelevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentenvironmenlevelIsNull() {
            addCriterion("hospCommentEnvironmenLevel is null");
            return (Criteria) this;
        }

        public Criteria andHospcommentenvironmenlevelIsNotNull() {
            addCriterion("hospCommentEnvironmenLevel is not null");
            return (Criteria) this;
        }

        public Criteria andHospcommentenvironmenlevelEqualTo(Integer value) {
            addCriterion("hospCommentEnvironmenLevel =", value, "hospcommentenvironmenlevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentenvironmenlevelNotEqualTo(Integer value) {
            addCriterion("hospCommentEnvironmenLevel <>", value, "hospcommentenvironmenlevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentenvironmenlevelGreaterThan(Integer value) {
            addCriterion("hospCommentEnvironmenLevel >", value, "hospcommentenvironmenlevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentenvironmenlevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("hospCommentEnvironmenLevel >=", value, "hospcommentenvironmenlevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentenvironmenlevelLessThan(Integer value) {
            addCriterion("hospCommentEnvironmenLevel <", value, "hospcommentenvironmenlevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentenvironmenlevelLessThanOrEqualTo(Integer value) {
            addCriterion("hospCommentEnvironmenLevel <=", value, "hospcommentenvironmenlevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentenvironmenlevelIn(List<Integer> values) {
            addCriterion("hospCommentEnvironmenLevel in", values, "hospcommentenvironmenlevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentenvironmenlevelNotIn(List<Integer> values) {
            addCriterion("hospCommentEnvironmenLevel not in", values, "hospcommentenvironmenlevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentenvironmenlevelBetween(Integer value1, Integer value2) {
            addCriterion("hospCommentEnvironmenLevel between", value1, value2, "hospcommentenvironmenlevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentenvironmenlevelNotBetween(Integer value1, Integer value2) {
            addCriterion("hospCommentEnvironmenLevel not between", value1, value2, "hospcommentenvironmenlevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentpricelevelIsNull() {
            addCriterion("hospCommentPriceLevel is null");
            return (Criteria) this;
        }

        public Criteria andHospcommentpricelevelIsNotNull() {
            addCriterion("hospCommentPriceLevel is not null");
            return (Criteria) this;
        }

        public Criteria andHospcommentpricelevelEqualTo(Integer value) {
            addCriterion("hospCommentPriceLevel =", value, "hospcommentpricelevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentpricelevelNotEqualTo(Integer value) {
            addCriterion("hospCommentPriceLevel <>", value, "hospcommentpricelevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentpricelevelGreaterThan(Integer value) {
            addCriterion("hospCommentPriceLevel >", value, "hospcommentpricelevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentpricelevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("hospCommentPriceLevel >=", value, "hospcommentpricelevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentpricelevelLessThan(Integer value) {
            addCriterion("hospCommentPriceLevel <", value, "hospcommentpricelevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentpricelevelLessThanOrEqualTo(Integer value) {
            addCriterion("hospCommentPriceLevel <=", value, "hospcommentpricelevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentpricelevelIn(List<Integer> values) {
            addCriterion("hospCommentPriceLevel in", values, "hospcommentpricelevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentpricelevelNotIn(List<Integer> values) {
            addCriterion("hospCommentPriceLevel not in", values, "hospcommentpricelevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentpricelevelBetween(Integer value1, Integer value2) {
            addCriterion("hospCommentPriceLevel between", value1, value2, "hospcommentpricelevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentpricelevelNotBetween(Integer value1, Integer value2) {
            addCriterion("hospCommentPriceLevel not between", value1, value2, "hospcommentpricelevel");
            return (Criteria) this;
        }

        public Criteria andHospcommentwordsIsNull() {
            addCriterion("hospCommentWords is null");
            return (Criteria) this;
        }

        public Criteria andHospcommentwordsIsNotNull() {
            addCriterion("hospCommentWords is not null");
            return (Criteria) this;
        }

        public Criteria andHospcommentwordsEqualTo(String value) {
            addCriterion("hospCommentWords =", value, "hospcommentwords");
            return (Criteria) this;
        }

        public Criteria andHospcommentwordsNotEqualTo(String value) {
            addCriterion("hospCommentWords <>", value, "hospcommentwords");
            return (Criteria) this;
        }

        public Criteria andHospcommentwordsGreaterThan(String value) {
            addCriterion("hospCommentWords >", value, "hospcommentwords");
            return (Criteria) this;
        }

        public Criteria andHospcommentwordsGreaterThanOrEqualTo(String value) {
            addCriterion("hospCommentWords >=", value, "hospcommentwords");
            return (Criteria) this;
        }

        public Criteria andHospcommentwordsLessThan(String value) {
            addCriterion("hospCommentWords <", value, "hospcommentwords");
            return (Criteria) this;
        }

        public Criteria andHospcommentwordsLessThanOrEqualTo(String value) {
            addCriterion("hospCommentWords <=", value, "hospcommentwords");
            return (Criteria) this;
        }

        public Criteria andHospcommentwordsLike(String value) {
            addCriterion("hospCommentWords like", value, "hospcommentwords");
            return (Criteria) this;
        }

        public Criteria andHospcommentwordsNotLike(String value) {
            addCriterion("hospCommentWords not like", value, "hospcommentwords");
            return (Criteria) this;
        }

        public Criteria andHospcommentwordsIn(List<String> values) {
            addCriterion("hospCommentWords in", values, "hospcommentwords");
            return (Criteria) this;
        }

        public Criteria andHospcommentwordsNotIn(List<String> values) {
            addCriterion("hospCommentWords not in", values, "hospcommentwords");
            return (Criteria) this;
        }

        public Criteria andHospcommentwordsBetween(String value1, String value2) {
            addCriterion("hospCommentWords between", value1, value2, "hospcommentwords");
            return (Criteria) this;
        }

        public Criteria andHospcommentwordsNotBetween(String value1, String value2) {
            addCriterion("hospCommentWords not between", value1, value2, "hospcommentwords");
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

        public Criteria andUserorderidIsNull() {
            addCriterion("userOrderId is null");
            return (Criteria) this;
        }

        public Criteria andUserorderidIsNotNull() {
            addCriterion("userOrderId is not null");
            return (Criteria) this;
        }

        public Criteria andUserorderidEqualTo(Integer value) {
            addCriterion("userOrderId =", value, "userorderid");
            return (Criteria) this;
        }

        public Criteria andUserorderidNotEqualTo(Integer value) {
            addCriterion("userOrderId <>", value, "userorderid");
            return (Criteria) this;
        }

        public Criteria andUserorderidGreaterThan(Integer value) {
            addCriterion("userOrderId >", value, "userorderid");
            return (Criteria) this;
        }

        public Criteria andUserorderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("userOrderId >=", value, "userorderid");
            return (Criteria) this;
        }

        public Criteria andUserorderidLessThan(Integer value) {
            addCriterion("userOrderId <", value, "userorderid");
            return (Criteria) this;
        }

        public Criteria andUserorderidLessThanOrEqualTo(Integer value) {
            addCriterion("userOrderId <=", value, "userorderid");
            return (Criteria) this;
        }

        public Criteria andUserorderidIn(List<Integer> values) {
            addCriterion("userOrderId in", values, "userorderid");
            return (Criteria) this;
        }

        public Criteria andUserorderidNotIn(List<Integer> values) {
            addCriterion("userOrderId not in", values, "userorderid");
            return (Criteria) this;
        }

        public Criteria andUserorderidBetween(Integer value1, Integer value2) {
            addCriterion("userOrderId between", value1, value2, "userorderid");
            return (Criteria) this;
        }

        public Criteria andUserorderidNotBetween(Integer value1, Integer value2) {
            addCriterion("userOrderId not between", value1, value2, "userorderid");
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

        public Criteria andHospcommenttimeIsNull() {
            addCriterion("hospCommentTime is null");
            return (Criteria) this;
        }

        public Criteria andHospcommenttimeIsNotNull() {
            addCriterion("hospCommentTime is not null");
            return (Criteria) this;
        }

        public Criteria andHospcommenttimeEqualTo(Date value) {
            addCriterion("hospCommentTime =", value, "hospcommenttime");
            return (Criteria) this;
        }

        public Criteria andHospcommenttimeNotEqualTo(Date value) {
            addCriterion("hospCommentTime <>", value, "hospcommenttime");
            return (Criteria) this;
        }

        public Criteria andHospcommenttimeGreaterThan(Date value) {
            addCriterion("hospCommentTime >", value, "hospcommenttime");
            return (Criteria) this;
        }

        public Criteria andHospcommenttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("hospCommentTime >=", value, "hospcommenttime");
            return (Criteria) this;
        }

        public Criteria andHospcommenttimeLessThan(Date value) {
            addCriterion("hospCommentTime <", value, "hospcommenttime");
            return (Criteria) this;
        }

        public Criteria andHospcommenttimeLessThanOrEqualTo(Date value) {
            addCriterion("hospCommentTime <=", value, "hospcommenttime");
            return (Criteria) this;
        }

        public Criteria andHospcommenttimeIn(List<Date> values) {
            addCriterion("hospCommentTime in", values, "hospcommenttime");
            return (Criteria) this;
        }

        public Criteria andHospcommenttimeNotIn(List<Date> values) {
            addCriterion("hospCommentTime not in", values, "hospcommenttime");
            return (Criteria) this;
        }

        public Criteria andHospcommenttimeBetween(Date value1, Date value2) {
            addCriterion("hospCommentTime between", value1, value2, "hospcommenttime");
            return (Criteria) this;
        }

        public Criteria andHospcommenttimeNotBetween(Date value1, Date value2) {
            addCriterion("hospCommentTime not between", value1, value2, "hospcommenttime");
            return (Criteria) this;
        }

        public Criteria andHospcommentpatientnameIsNull() {
            addCriterion("hospCommentPatientName is null");
            return (Criteria) this;
        }

        public Criteria andHospcommentpatientnameIsNotNull() {
            addCriterion("hospCommentPatientName is not null");
            return (Criteria) this;
        }

        public Criteria andHospcommentpatientnameEqualTo(String value) {
            addCriterion("hospCommentPatientName =", value, "hospcommentpatientname");
            return (Criteria) this;
        }

        public Criteria andHospcommentpatientnameNotEqualTo(String value) {
            addCriterion("hospCommentPatientName <>", value, "hospcommentpatientname");
            return (Criteria) this;
        }

        public Criteria andHospcommentpatientnameGreaterThan(String value) {
            addCriterion("hospCommentPatientName >", value, "hospcommentpatientname");
            return (Criteria) this;
        }

        public Criteria andHospcommentpatientnameGreaterThanOrEqualTo(String value) {
            addCriterion("hospCommentPatientName >=", value, "hospcommentpatientname");
            return (Criteria) this;
        }

        public Criteria andHospcommentpatientnameLessThan(String value) {
            addCriterion("hospCommentPatientName <", value, "hospcommentpatientname");
            return (Criteria) this;
        }

        public Criteria andHospcommentpatientnameLessThanOrEqualTo(String value) {
            addCriterion("hospCommentPatientName <=", value, "hospcommentpatientname");
            return (Criteria) this;
        }

        public Criteria andHospcommentpatientnameLike(String value) {
            addCriterion("hospCommentPatientName like", value, "hospcommentpatientname");
            return (Criteria) this;
        }

        public Criteria andHospcommentpatientnameNotLike(String value) {
            addCriterion("hospCommentPatientName not like", value, "hospcommentpatientname");
            return (Criteria) this;
        }

        public Criteria andHospcommentpatientnameIn(List<String> values) {
            addCriterion("hospCommentPatientName in", values, "hospcommentpatientname");
            return (Criteria) this;
        }

        public Criteria andHospcommentpatientnameNotIn(List<String> values) {
            addCriterion("hospCommentPatientName not in", values, "hospcommentpatientname");
            return (Criteria) this;
        }

        public Criteria andHospcommentpatientnameBetween(String value1, String value2) {
            addCriterion("hospCommentPatientName between", value1, value2, "hospcommentpatientname");
            return (Criteria) this;
        }

        public Criteria andHospcommentpatientnameNotBetween(String value1, String value2) {
            addCriterion("hospCommentPatientName not between", value1, value2, "hospcommentpatientname");
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