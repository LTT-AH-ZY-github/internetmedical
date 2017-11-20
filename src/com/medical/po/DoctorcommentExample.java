package com.medical.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DoctorcommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DoctorcommentExample() {
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

        public Criteria andDoccommentidIsNull() {
            addCriterion("docCommentId is null");
            return (Criteria) this;
        }

        public Criteria andDoccommentidIsNotNull() {
            addCriterion("docCommentId is not null");
            return (Criteria) this;
        }

        public Criteria andDoccommentidEqualTo(Integer value) {
            addCriterion("docCommentId =", value, "doccommentid");
            return (Criteria) this;
        }

        public Criteria andDoccommentidNotEqualTo(Integer value) {
            addCriterion("docCommentId <>", value, "doccommentid");
            return (Criteria) this;
        }

        public Criteria andDoccommentidGreaterThan(Integer value) {
            addCriterion("docCommentId >", value, "doccommentid");
            return (Criteria) this;
        }

        public Criteria andDoccommentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("docCommentId >=", value, "doccommentid");
            return (Criteria) this;
        }

        public Criteria andDoccommentidLessThan(Integer value) {
            addCriterion("docCommentId <", value, "doccommentid");
            return (Criteria) this;
        }

        public Criteria andDoccommentidLessThanOrEqualTo(Integer value) {
            addCriterion("docCommentId <=", value, "doccommentid");
            return (Criteria) this;
        }

        public Criteria andDoccommentidIn(List<Integer> values) {
            addCriterion("docCommentId in", values, "doccommentid");
            return (Criteria) this;
        }

        public Criteria andDoccommentidNotIn(List<Integer> values) {
            addCriterion("docCommentId not in", values, "doccommentid");
            return (Criteria) this;
        }

        public Criteria andDoccommentidBetween(Integer value1, Integer value2) {
            addCriterion("docCommentId between", value1, value2, "doccommentid");
            return (Criteria) this;
        }

        public Criteria andDoccommentidNotBetween(Integer value1, Integer value2) {
            addCriterion("docCommentId not between", value1, value2, "doccommentid");
            return (Criteria) this;
        }

        public Criteria andDoccommentfatheridIsNull() {
            addCriterion("docCommentFatherId is null");
            return (Criteria) this;
        }

        public Criteria andDoccommentfatheridIsNotNull() {
            addCriterion("docCommentFatherId is not null");
            return (Criteria) this;
        }

        public Criteria andDoccommentfatheridEqualTo(Integer value) {
            addCriterion("docCommentFatherId =", value, "doccommentfatherid");
            return (Criteria) this;
        }

        public Criteria andDoccommentfatheridNotEqualTo(Integer value) {
            addCriterion("docCommentFatherId <>", value, "doccommentfatherid");
            return (Criteria) this;
        }

        public Criteria andDoccommentfatheridGreaterThan(Integer value) {
            addCriterion("docCommentFatherId >", value, "doccommentfatherid");
            return (Criteria) this;
        }

        public Criteria andDoccommentfatheridGreaterThanOrEqualTo(Integer value) {
            addCriterion("docCommentFatherId >=", value, "doccommentfatherid");
            return (Criteria) this;
        }

        public Criteria andDoccommentfatheridLessThan(Integer value) {
            addCriterion("docCommentFatherId <", value, "doccommentfatherid");
            return (Criteria) this;
        }

        public Criteria andDoccommentfatheridLessThanOrEqualTo(Integer value) {
            addCriterion("docCommentFatherId <=", value, "doccommentfatherid");
            return (Criteria) this;
        }

        public Criteria andDoccommentfatheridIn(List<Integer> values) {
            addCriterion("docCommentFatherId in", values, "doccommentfatherid");
            return (Criteria) this;
        }

        public Criteria andDoccommentfatheridNotIn(List<Integer> values) {
            addCriterion("docCommentFatherId not in", values, "doccommentfatherid");
            return (Criteria) this;
        }

        public Criteria andDoccommentfatheridBetween(Integer value1, Integer value2) {
            addCriterion("docCommentFatherId between", value1, value2, "doccommentfatherid");
            return (Criteria) this;
        }

        public Criteria andDoccommentfatheridNotBetween(Integer value1, Integer value2) {
            addCriterion("docCommentFatherId not between", value1, value2, "doccommentfatherid");
            return (Criteria) this;
        }

        public Criteria andDoccommentgradeIsNull() {
            addCriterion("docCommentGrade is null");
            return (Criteria) this;
        }

        public Criteria andDoccommentgradeIsNotNull() {
            addCriterion("docCommentGrade is not null");
            return (Criteria) this;
        }

        public Criteria andDoccommentgradeEqualTo(Integer value) {
            addCriterion("docCommentGrade =", value, "doccommentgrade");
            return (Criteria) this;
        }

        public Criteria andDoccommentgradeNotEqualTo(Integer value) {
            addCriterion("docCommentGrade <>", value, "doccommentgrade");
            return (Criteria) this;
        }

        public Criteria andDoccommentgradeGreaterThan(Integer value) {
            addCriterion("docCommentGrade >", value, "doccommentgrade");
            return (Criteria) this;
        }

        public Criteria andDoccommentgradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("docCommentGrade >=", value, "doccommentgrade");
            return (Criteria) this;
        }

        public Criteria andDoccommentgradeLessThan(Integer value) {
            addCriterion("docCommentGrade <", value, "doccommentgrade");
            return (Criteria) this;
        }

        public Criteria andDoccommentgradeLessThanOrEqualTo(Integer value) {
            addCriterion("docCommentGrade <=", value, "doccommentgrade");
            return (Criteria) this;
        }

        public Criteria andDoccommentgradeIn(List<Integer> values) {
            addCriterion("docCommentGrade in", values, "doccommentgrade");
            return (Criteria) this;
        }

        public Criteria andDoccommentgradeNotIn(List<Integer> values) {
            addCriterion("docCommentGrade not in", values, "doccommentgrade");
            return (Criteria) this;
        }

        public Criteria andDoccommentgradeBetween(Integer value1, Integer value2) {
            addCriterion("docCommentGrade between", value1, value2, "doccommentgrade");
            return (Criteria) this;
        }

        public Criteria andDoccommentgradeNotBetween(Integer value1, Integer value2) {
            addCriterion("docCommentGrade not between", value1, value2, "doccommentgrade");
            return (Criteria) this;
        }

        public Criteria andDoccommentservicelevelIsNull() {
            addCriterion("docCommentServiceLevel is null");
            return (Criteria) this;
        }

        public Criteria andDoccommentservicelevelIsNotNull() {
            addCriterion("docCommentServiceLevel is not null");
            return (Criteria) this;
        }

        public Criteria andDoccommentservicelevelEqualTo(Integer value) {
            addCriterion("docCommentServiceLevel =", value, "doccommentservicelevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentservicelevelNotEqualTo(Integer value) {
            addCriterion("docCommentServiceLevel <>", value, "doccommentservicelevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentservicelevelGreaterThan(Integer value) {
            addCriterion("docCommentServiceLevel >", value, "doccommentservicelevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentservicelevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("docCommentServiceLevel >=", value, "doccommentservicelevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentservicelevelLessThan(Integer value) {
            addCriterion("docCommentServiceLevel <", value, "doccommentservicelevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentservicelevelLessThanOrEqualTo(Integer value) {
            addCriterion("docCommentServiceLevel <=", value, "doccommentservicelevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentservicelevelIn(List<Integer> values) {
            addCriterion("docCommentServiceLevel in", values, "doccommentservicelevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentservicelevelNotIn(List<Integer> values) {
            addCriterion("docCommentServiceLevel not in", values, "doccommentservicelevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentservicelevelBetween(Integer value1, Integer value2) {
            addCriterion("docCommentServiceLevel between", value1, value2, "doccommentservicelevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentservicelevelNotBetween(Integer value1, Integer value2) {
            addCriterion("docCommentServiceLevel not between", value1, value2, "doccommentservicelevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentprofessionallevelIsNull() {
            addCriterion("docCommentProfessionalLevel is null");
            return (Criteria) this;
        }

        public Criteria andDoccommentprofessionallevelIsNotNull() {
            addCriterion("docCommentProfessionalLevel is not null");
            return (Criteria) this;
        }

        public Criteria andDoccommentprofessionallevelEqualTo(Integer value) {
            addCriterion("docCommentProfessionalLevel =", value, "doccommentprofessionallevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentprofessionallevelNotEqualTo(Integer value) {
            addCriterion("docCommentProfessionalLevel <>", value, "doccommentprofessionallevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentprofessionallevelGreaterThan(Integer value) {
            addCriterion("docCommentProfessionalLevel >", value, "doccommentprofessionallevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentprofessionallevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("docCommentProfessionalLevel >=", value, "doccommentprofessionallevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentprofessionallevelLessThan(Integer value) {
            addCriterion("docCommentProfessionalLevel <", value, "doccommentprofessionallevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentprofessionallevelLessThanOrEqualTo(Integer value) {
            addCriterion("docCommentProfessionalLevel <=", value, "doccommentprofessionallevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentprofessionallevelIn(List<Integer> values) {
            addCriterion("docCommentProfessionalLevel in", values, "doccommentprofessionallevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentprofessionallevelNotIn(List<Integer> values) {
            addCriterion("docCommentProfessionalLevel not in", values, "doccommentprofessionallevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentprofessionallevelBetween(Integer value1, Integer value2) {
            addCriterion("docCommentProfessionalLevel between", value1, value2, "doccommentprofessionallevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentprofessionallevelNotBetween(Integer value1, Integer value2) {
            addCriterion("docCommentProfessionalLevel not between", value1, value2, "doccommentprofessionallevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentpricelevelIsNull() {
            addCriterion("docCommentPriceLevel is null");
            return (Criteria) this;
        }

        public Criteria andDoccommentpricelevelIsNotNull() {
            addCriterion("docCommentPriceLevel is not null");
            return (Criteria) this;
        }

        public Criteria andDoccommentpricelevelEqualTo(Integer value) {
            addCriterion("docCommentPriceLevel =", value, "doccommentpricelevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentpricelevelNotEqualTo(Integer value) {
            addCriterion("docCommentPriceLevel <>", value, "doccommentpricelevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentpricelevelGreaterThan(Integer value) {
            addCriterion("docCommentPriceLevel >", value, "doccommentpricelevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentpricelevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("docCommentPriceLevel >=", value, "doccommentpricelevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentpricelevelLessThan(Integer value) {
            addCriterion("docCommentPriceLevel <", value, "doccommentpricelevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentpricelevelLessThanOrEqualTo(Integer value) {
            addCriterion("docCommentPriceLevel <=", value, "doccommentpricelevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentpricelevelIn(List<Integer> values) {
            addCriterion("docCommentPriceLevel in", values, "doccommentpricelevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentpricelevelNotIn(List<Integer> values) {
            addCriterion("docCommentPriceLevel not in", values, "doccommentpricelevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentpricelevelBetween(Integer value1, Integer value2) {
            addCriterion("docCommentPriceLevel between", value1, value2, "doccommentpricelevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentpricelevelNotBetween(Integer value1, Integer value2) {
            addCriterion("docCommentPriceLevel not between", value1, value2, "doccommentpricelevel");
            return (Criteria) this;
        }

        public Criteria andDoccommentwordsIsNull() {
            addCriterion("docCommentWords is null");
            return (Criteria) this;
        }

        public Criteria andDoccommentwordsIsNotNull() {
            addCriterion("docCommentWords is not null");
            return (Criteria) this;
        }

        public Criteria andDoccommentwordsEqualTo(String value) {
            addCriterion("docCommentWords =", value, "doccommentwords");
            return (Criteria) this;
        }

        public Criteria andDoccommentwordsNotEqualTo(String value) {
            addCriterion("docCommentWords <>", value, "doccommentwords");
            return (Criteria) this;
        }

        public Criteria andDoccommentwordsGreaterThan(String value) {
            addCriterion("docCommentWords >", value, "doccommentwords");
            return (Criteria) this;
        }

        public Criteria andDoccommentwordsGreaterThanOrEqualTo(String value) {
            addCriterion("docCommentWords >=", value, "doccommentwords");
            return (Criteria) this;
        }

        public Criteria andDoccommentwordsLessThan(String value) {
            addCriterion("docCommentWords <", value, "doccommentwords");
            return (Criteria) this;
        }

        public Criteria andDoccommentwordsLessThanOrEqualTo(String value) {
            addCriterion("docCommentWords <=", value, "doccommentwords");
            return (Criteria) this;
        }

        public Criteria andDoccommentwordsLike(String value) {
            addCriterion("docCommentWords like", value, "doccommentwords");
            return (Criteria) this;
        }

        public Criteria andDoccommentwordsNotLike(String value) {
            addCriterion("docCommentWords not like", value, "doccommentwords");
            return (Criteria) this;
        }

        public Criteria andDoccommentwordsIn(List<String> values) {
            addCriterion("docCommentWords in", values, "doccommentwords");
            return (Criteria) this;
        }

        public Criteria andDoccommentwordsNotIn(List<String> values) {
            addCriterion("docCommentWords not in", values, "doccommentwords");
            return (Criteria) this;
        }

        public Criteria andDoccommentwordsBetween(String value1, String value2) {
            addCriterion("docCommentWords between", value1, value2, "doccommentwords");
            return (Criteria) this;
        }

        public Criteria andDoccommentwordsNotBetween(String value1, String value2) {
            addCriterion("docCommentWords not between", value1, value2, "doccommentwords");
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

        public Criteria andDoccommentpatientnameIsNull() {
            addCriterion("docCommentPatientName is null");
            return (Criteria) this;
        }

        public Criteria andDoccommentpatientnameIsNotNull() {
            addCriterion("docCommentPatientName is not null");
            return (Criteria) this;
        }

        public Criteria andDoccommentpatientnameEqualTo(String value) {
            addCriterion("docCommentPatientName =", value, "doccommentpatientname");
            return (Criteria) this;
        }

        public Criteria andDoccommentpatientnameNotEqualTo(String value) {
            addCriterion("docCommentPatientName <>", value, "doccommentpatientname");
            return (Criteria) this;
        }

        public Criteria andDoccommentpatientnameGreaterThan(String value) {
            addCriterion("docCommentPatientName >", value, "doccommentpatientname");
            return (Criteria) this;
        }

        public Criteria andDoccommentpatientnameGreaterThanOrEqualTo(String value) {
            addCriterion("docCommentPatientName >=", value, "doccommentpatientname");
            return (Criteria) this;
        }

        public Criteria andDoccommentpatientnameLessThan(String value) {
            addCriterion("docCommentPatientName <", value, "doccommentpatientname");
            return (Criteria) this;
        }

        public Criteria andDoccommentpatientnameLessThanOrEqualTo(String value) {
            addCriterion("docCommentPatientName <=", value, "doccommentpatientname");
            return (Criteria) this;
        }

        public Criteria andDoccommentpatientnameLike(String value) {
            addCriterion("docCommentPatientName like", value, "doccommentpatientname");
            return (Criteria) this;
        }

        public Criteria andDoccommentpatientnameNotLike(String value) {
            addCriterion("docCommentPatientName not like", value, "doccommentpatientname");
            return (Criteria) this;
        }

        public Criteria andDoccommentpatientnameIn(List<String> values) {
            addCriterion("docCommentPatientName in", values, "doccommentpatientname");
            return (Criteria) this;
        }

        public Criteria andDoccommentpatientnameNotIn(List<String> values) {
            addCriterion("docCommentPatientName not in", values, "doccommentpatientname");
            return (Criteria) this;
        }

        public Criteria andDoccommentpatientnameBetween(String value1, String value2) {
            addCriterion("docCommentPatientName between", value1, value2, "doccommentpatientname");
            return (Criteria) this;
        }

        public Criteria andDoccommentpatientnameNotBetween(String value1, String value2) {
            addCriterion("docCommentPatientName not between", value1, value2, "doccommentpatientname");
            return (Criteria) this;
        }

        public Criteria andDoccommenttimeIsNull() {
            addCriterion("docCommentTime is null");
            return (Criteria) this;
        }

        public Criteria andDoccommenttimeIsNotNull() {
            addCriterion("docCommentTime is not null");
            return (Criteria) this;
        }

        public Criteria andDoccommenttimeEqualTo(Date value) {
            addCriterion("docCommentTime =", value, "doccommenttime");
            return (Criteria) this;
        }

        public Criteria andDoccommenttimeNotEqualTo(Date value) {
            addCriterion("docCommentTime <>", value, "doccommenttime");
            return (Criteria) this;
        }

        public Criteria andDoccommenttimeGreaterThan(Date value) {
            addCriterion("docCommentTime >", value, "doccommenttime");
            return (Criteria) this;
        }

        public Criteria andDoccommenttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("docCommentTime >=", value, "doccommenttime");
            return (Criteria) this;
        }

        public Criteria andDoccommenttimeLessThan(Date value) {
            addCriterion("docCommentTime <", value, "doccommenttime");
            return (Criteria) this;
        }

        public Criteria andDoccommenttimeLessThanOrEqualTo(Date value) {
            addCriterion("docCommentTime <=", value, "doccommenttime");
            return (Criteria) this;
        }

        public Criteria andDoccommenttimeIn(List<Date> values) {
            addCriterion("docCommentTime in", values, "doccommenttime");
            return (Criteria) this;
        }

        public Criteria andDoccommenttimeNotIn(List<Date> values) {
            addCriterion("docCommentTime not in", values, "doccommenttime");
            return (Criteria) this;
        }

        public Criteria andDoccommenttimeBetween(Date value1, Date value2) {
            addCriterion("docCommentTime between", value1, value2, "doccommenttime");
            return (Criteria) this;
        }

        public Criteria andDoccommenttimeNotBetween(Date value1, Date value2) {
            addCriterion("docCommentTime not between", value1, value2, "doccommenttime");
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