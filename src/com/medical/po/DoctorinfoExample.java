package com.medical.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DoctorinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DoctorinfoExample() {
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

        public Criteria andDocidIsNull() {
            addCriterion("docId is null");
            return (Criteria) this;
        }

        public Criteria andDocidIsNotNull() {
            addCriterion("docId is not null");
            return (Criteria) this;
        }

        public Criteria andDocidEqualTo(Integer value) {
            addCriterion("docId =", value, "docid");
            return (Criteria) this;
        }

        public Criteria andDocidNotEqualTo(Integer value) {
            addCriterion("docId <>", value, "docid");
            return (Criteria) this;
        }

        public Criteria andDocidGreaterThan(Integer value) {
            addCriterion("docId >", value, "docid");
            return (Criteria) this;
        }

        public Criteria andDocidGreaterThanOrEqualTo(Integer value) {
            addCriterion("docId >=", value, "docid");
            return (Criteria) this;
        }

        public Criteria andDocidLessThan(Integer value) {
            addCriterion("docId <", value, "docid");
            return (Criteria) this;
        }

        public Criteria andDocidLessThanOrEqualTo(Integer value) {
            addCriterion("docId <=", value, "docid");
            return (Criteria) this;
        }

        public Criteria andDocidIn(List<Integer> values) {
            addCriterion("docId in", values, "docid");
            return (Criteria) this;
        }

        public Criteria andDocidNotIn(List<Integer> values) {
            addCriterion("docId not in", values, "docid");
            return (Criteria) this;
        }

        public Criteria andDocidBetween(Integer value1, Integer value2) {
            addCriterion("docId between", value1, value2, "docid");
            return (Criteria) this;
        }

        public Criteria andDocidNotBetween(Integer value1, Integer value2) {
            addCriterion("docId not between", value1, value2, "docid");
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

        public Criteria andDocnameIsNull() {
            addCriterion("docName is null");
            return (Criteria) this;
        }

        public Criteria andDocnameIsNotNull() {
            addCriterion("docName is not null");
            return (Criteria) this;
        }

        public Criteria andDocnameEqualTo(String value) {
            addCriterion("docName =", value, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameNotEqualTo(String value) {
            addCriterion("docName <>", value, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameGreaterThan(String value) {
            addCriterion("docName >", value, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameGreaterThanOrEqualTo(String value) {
            addCriterion("docName >=", value, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameLessThan(String value) {
            addCriterion("docName <", value, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameLessThanOrEqualTo(String value) {
            addCriterion("docName <=", value, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameLike(String value) {
            addCriterion("docName like", value, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameNotLike(String value) {
            addCriterion("docName not like", value, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameIn(List<String> values) {
            addCriterion("docName in", values, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameNotIn(List<String> values) {
            addCriterion("docName not in", values, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameBetween(String value1, String value2) {
            addCriterion("docName between", value1, value2, "docname");
            return (Criteria) this;
        }

        public Criteria andDocnameNotBetween(String value1, String value2) {
            addCriterion("docName not between", value1, value2, "docname");
            return (Criteria) this;
        }

        public Criteria andDocmaleIsNull() {
            addCriterion("docMale is null");
            return (Criteria) this;
        }

        public Criteria andDocmaleIsNotNull() {
            addCriterion("docMale is not null");
            return (Criteria) this;
        }

        public Criteria andDocmaleEqualTo(String value) {
            addCriterion("docMale =", value, "docmale");
            return (Criteria) this;
        }

        public Criteria andDocmaleNotEqualTo(String value) {
            addCriterion("docMale <>", value, "docmale");
            return (Criteria) this;
        }

        public Criteria andDocmaleGreaterThan(String value) {
            addCriterion("docMale >", value, "docmale");
            return (Criteria) this;
        }

        public Criteria andDocmaleGreaterThanOrEqualTo(String value) {
            addCriterion("docMale >=", value, "docmale");
            return (Criteria) this;
        }

        public Criteria andDocmaleLessThan(String value) {
            addCriterion("docMale <", value, "docmale");
            return (Criteria) this;
        }

        public Criteria andDocmaleLessThanOrEqualTo(String value) {
            addCriterion("docMale <=", value, "docmale");
            return (Criteria) this;
        }

        public Criteria andDocmaleLike(String value) {
            addCriterion("docMale like", value, "docmale");
            return (Criteria) this;
        }

        public Criteria andDocmaleNotLike(String value) {
            addCriterion("docMale not like", value, "docmale");
            return (Criteria) this;
        }

        public Criteria andDocmaleIn(List<String> values) {
            addCriterion("docMale in", values, "docmale");
            return (Criteria) this;
        }

        public Criteria andDocmaleNotIn(List<String> values) {
            addCriterion("docMale not in", values, "docmale");
            return (Criteria) this;
        }

        public Criteria andDocmaleBetween(String value1, String value2) {
            addCriterion("docMale between", value1, value2, "docmale");
            return (Criteria) this;
        }

        public Criteria andDocmaleNotBetween(String value1, String value2) {
            addCriterion("docMale not between", value1, value2, "docmale");
            return (Criteria) this;
        }

        public Criteria andDocageIsNull() {
            addCriterion("docAge is null");
            return (Criteria) this;
        }

        public Criteria andDocageIsNotNull() {
            addCriterion("docAge is not null");
            return (Criteria) this;
        }

        public Criteria andDocageEqualTo(Integer value) {
            addCriterion("docAge =", value, "docage");
            return (Criteria) this;
        }

        public Criteria andDocageNotEqualTo(Integer value) {
            addCriterion("docAge <>", value, "docage");
            return (Criteria) this;
        }

        public Criteria andDocageGreaterThan(Integer value) {
            addCriterion("docAge >", value, "docage");
            return (Criteria) this;
        }

        public Criteria andDocageGreaterThanOrEqualTo(Integer value) {
            addCriterion("docAge >=", value, "docage");
            return (Criteria) this;
        }

        public Criteria andDocageLessThan(Integer value) {
            addCriterion("docAge <", value, "docage");
            return (Criteria) this;
        }

        public Criteria andDocageLessThanOrEqualTo(Integer value) {
            addCriterion("docAge <=", value, "docage");
            return (Criteria) this;
        }

        public Criteria andDocageIn(List<Integer> values) {
            addCriterion("docAge in", values, "docage");
            return (Criteria) this;
        }

        public Criteria andDocageNotIn(List<Integer> values) {
            addCriterion("docAge not in", values, "docage");
            return (Criteria) this;
        }

        public Criteria andDocageBetween(Integer value1, Integer value2) {
            addCriterion("docAge between", value1, value2, "docage");
            return (Criteria) this;
        }

        public Criteria andDocageNotBetween(Integer value1, Integer value2) {
            addCriterion("docAge not between", value1, value2, "docage");
            return (Criteria) this;
        }

        public Criteria andDoctitleIsNull() {
            addCriterion("docTitle is null");
            return (Criteria) this;
        }

        public Criteria andDoctitleIsNotNull() {
            addCriterion("docTitle is not null");
            return (Criteria) this;
        }

        public Criteria andDoctitleEqualTo(String value) {
            addCriterion("docTitle =", value, "doctitle");
            return (Criteria) this;
        }

        public Criteria andDoctitleNotEqualTo(String value) {
            addCriterion("docTitle <>", value, "doctitle");
            return (Criteria) this;
        }

        public Criteria andDoctitleGreaterThan(String value) {
            addCriterion("docTitle >", value, "doctitle");
            return (Criteria) this;
        }

        public Criteria andDoctitleGreaterThanOrEqualTo(String value) {
            addCriterion("docTitle >=", value, "doctitle");
            return (Criteria) this;
        }

        public Criteria andDoctitleLessThan(String value) {
            addCriterion("docTitle <", value, "doctitle");
            return (Criteria) this;
        }

        public Criteria andDoctitleLessThanOrEqualTo(String value) {
            addCriterion("docTitle <=", value, "doctitle");
            return (Criteria) this;
        }

        public Criteria andDoctitleLike(String value) {
            addCriterion("docTitle like", value, "doctitle");
            return (Criteria) this;
        }

        public Criteria andDoctitleNotLike(String value) {
            addCriterion("docTitle not like", value, "doctitle");
            return (Criteria) this;
        }

        public Criteria andDoctitleIn(List<String> values) {
            addCriterion("docTitle in", values, "doctitle");
            return (Criteria) this;
        }

        public Criteria andDoctitleNotIn(List<String> values) {
            addCriterion("docTitle not in", values, "doctitle");
            return (Criteria) this;
        }

        public Criteria andDoctitleBetween(String value1, String value2) {
            addCriterion("docTitle between", value1, value2, "doctitle");
            return (Criteria) this;
        }

        public Criteria andDoctitleNotBetween(String value1, String value2) {
            addCriterion("docTitle not between", value1, value2, "doctitle");
            return (Criteria) this;
        }

        public Criteria andDoccardnumIsNull() {
            addCriterion("docCardNum is null");
            return (Criteria) this;
        }

        public Criteria andDoccardnumIsNotNull() {
            addCriterion("docCardNum is not null");
            return (Criteria) this;
        }

        public Criteria andDoccardnumEqualTo(String value) {
            addCriterion("docCardNum =", value, "doccardnum");
            return (Criteria) this;
        }

        public Criteria andDoccardnumNotEqualTo(String value) {
            addCriterion("docCardNum <>", value, "doccardnum");
            return (Criteria) this;
        }

        public Criteria andDoccardnumGreaterThan(String value) {
            addCriterion("docCardNum >", value, "doccardnum");
            return (Criteria) this;
        }

        public Criteria andDoccardnumGreaterThanOrEqualTo(String value) {
            addCriterion("docCardNum >=", value, "doccardnum");
            return (Criteria) this;
        }

        public Criteria andDoccardnumLessThan(String value) {
            addCriterion("docCardNum <", value, "doccardnum");
            return (Criteria) this;
        }

        public Criteria andDoccardnumLessThanOrEqualTo(String value) {
            addCriterion("docCardNum <=", value, "doccardnum");
            return (Criteria) this;
        }

        public Criteria andDoccardnumLike(String value) {
            addCriterion("docCardNum like", value, "doccardnum");
            return (Criteria) this;
        }

        public Criteria andDoccardnumNotLike(String value) {
            addCriterion("docCardNum not like", value, "doccardnum");
            return (Criteria) this;
        }

        public Criteria andDoccardnumIn(List<String> values) {
            addCriterion("docCardNum in", values, "doccardnum");
            return (Criteria) this;
        }

        public Criteria andDoccardnumNotIn(List<String> values) {
            addCriterion("docCardNum not in", values, "doccardnum");
            return (Criteria) this;
        }

        public Criteria andDoccardnumBetween(String value1, String value2) {
            addCriterion("docCardNum between", value1, value2, "doccardnum");
            return (Criteria) this;
        }

        public Criteria andDoccardnumNotBetween(String value1, String value2) {
            addCriterion("docCardNum not between", value1, value2, "doccardnum");
            return (Criteria) this;
        }

        public Criteria andDoccardphotoIsNull() {
            addCriterion("docCardPhoto is null");
            return (Criteria) this;
        }

        public Criteria andDoccardphotoIsNotNull() {
            addCriterion("docCardPhoto is not null");
            return (Criteria) this;
        }

        public Criteria andDoccardphotoEqualTo(String value) {
            addCriterion("docCardPhoto =", value, "doccardphoto");
            return (Criteria) this;
        }

        public Criteria andDoccardphotoNotEqualTo(String value) {
            addCriterion("docCardPhoto <>", value, "doccardphoto");
            return (Criteria) this;
        }

        public Criteria andDoccardphotoGreaterThan(String value) {
            addCriterion("docCardPhoto >", value, "doccardphoto");
            return (Criteria) this;
        }

        public Criteria andDoccardphotoGreaterThanOrEqualTo(String value) {
            addCriterion("docCardPhoto >=", value, "doccardphoto");
            return (Criteria) this;
        }

        public Criteria andDoccardphotoLessThan(String value) {
            addCriterion("docCardPhoto <", value, "doccardphoto");
            return (Criteria) this;
        }

        public Criteria andDoccardphotoLessThanOrEqualTo(String value) {
            addCriterion("docCardPhoto <=", value, "doccardphoto");
            return (Criteria) this;
        }

        public Criteria andDoccardphotoLike(String value) {
            addCriterion("docCardPhoto like", value, "doccardphoto");
            return (Criteria) this;
        }

        public Criteria andDoccardphotoNotLike(String value) {
            addCriterion("docCardPhoto not like", value, "doccardphoto");
            return (Criteria) this;
        }

        public Criteria andDoccardphotoIn(List<String> values) {
            addCriterion("docCardPhoto in", values, "doccardphoto");
            return (Criteria) this;
        }

        public Criteria andDoccardphotoNotIn(List<String> values) {
            addCriterion("docCardPhoto not in", values, "doccardphoto");
            return (Criteria) this;
        }

        public Criteria andDoccardphotoBetween(String value1, String value2) {
            addCriterion("docCardPhoto between", value1, value2, "doccardphoto");
            return (Criteria) this;
        }

        public Criteria andDoccardphotoNotBetween(String value1, String value2) {
            addCriterion("docCardPhoto not between", value1, value2, "doccardphoto");
            return (Criteria) this;
        }

        public Criteria andDocbirthdateIsNull() {
            addCriterion("docBirthDate is null");
            return (Criteria) this;
        }

        public Criteria andDocbirthdateIsNotNull() {
            addCriterion("docBirthDate is not null");
            return (Criteria) this;
        }

        public Criteria andDocbirthdateEqualTo(Date value) {
            addCriterionForJDBCDate("docBirthDate =", value, "docbirthdate");
            return (Criteria) this;
        }

        public Criteria andDocbirthdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("docBirthDate <>", value, "docbirthdate");
            return (Criteria) this;
        }

        public Criteria andDocbirthdateGreaterThan(Date value) {
            addCriterionForJDBCDate("docBirthDate >", value, "docbirthdate");
            return (Criteria) this;
        }

        public Criteria andDocbirthdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("docBirthDate >=", value, "docbirthdate");
            return (Criteria) this;
        }

        public Criteria andDocbirthdateLessThan(Date value) {
            addCriterionForJDBCDate("docBirthDate <", value, "docbirthdate");
            return (Criteria) this;
        }

        public Criteria andDocbirthdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("docBirthDate <=", value, "docbirthdate");
            return (Criteria) this;
        }

        public Criteria andDocbirthdateIn(List<Date> values) {
            addCriterionForJDBCDate("docBirthDate in", values, "docbirthdate");
            return (Criteria) this;
        }

        public Criteria andDocbirthdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("docBirthDate not in", values, "docbirthdate");
            return (Criteria) this;
        }

        public Criteria andDocbirthdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("docBirthDate between", value1, value2, "docbirthdate");
            return (Criteria) this;
        }

        public Criteria andDocbirthdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("docBirthDate not between", value1, value2, "docbirthdate");
            return (Criteria) this;
        }

        public Criteria andDocnationIsNull() {
            addCriterion("docNation is null");
            return (Criteria) this;
        }

        public Criteria andDocnationIsNotNull() {
            addCriterion("docNation is not null");
            return (Criteria) this;
        }

        public Criteria andDocnationEqualTo(String value) {
            addCriterion("docNation =", value, "docnation");
            return (Criteria) this;
        }

        public Criteria andDocnationNotEqualTo(String value) {
            addCriterion("docNation <>", value, "docnation");
            return (Criteria) this;
        }

        public Criteria andDocnationGreaterThan(String value) {
            addCriterion("docNation >", value, "docnation");
            return (Criteria) this;
        }

        public Criteria andDocnationGreaterThanOrEqualTo(String value) {
            addCriterion("docNation >=", value, "docnation");
            return (Criteria) this;
        }

        public Criteria andDocnationLessThan(String value) {
            addCriterion("docNation <", value, "docnation");
            return (Criteria) this;
        }

        public Criteria andDocnationLessThanOrEqualTo(String value) {
            addCriterion("docNation <=", value, "docnation");
            return (Criteria) this;
        }

        public Criteria andDocnationLike(String value) {
            addCriterion("docNation like", value, "docnation");
            return (Criteria) this;
        }

        public Criteria andDocnationNotLike(String value) {
            addCriterion("docNation not like", value, "docnation");
            return (Criteria) this;
        }

        public Criteria andDocnationIn(List<String> values) {
            addCriterion("docNation in", values, "docnation");
            return (Criteria) this;
        }

        public Criteria andDocnationNotIn(List<String> values) {
            addCriterion("docNation not in", values, "docnation");
            return (Criteria) this;
        }

        public Criteria andDocnationBetween(String value1, String value2) {
            addCriterion("docNation between", value1, value2, "docnation");
            return (Criteria) this;
        }

        public Criteria andDocnationNotBetween(String value1, String value2) {
            addCriterion("docNation not between", value1, value2, "docnation");
            return (Criteria) this;
        }

        public Criteria andDochospIsNull() {
            addCriterion("docHosp is null");
            return (Criteria) this;
        }

        public Criteria andDochospIsNotNull() {
            addCriterion("docHosp is not null");
            return (Criteria) this;
        }

        public Criteria andDochospEqualTo(String value) {
            addCriterion("docHosp =", value, "dochosp");
            return (Criteria) this;
        }

        public Criteria andDochospNotEqualTo(String value) {
            addCriterion("docHosp <>", value, "dochosp");
            return (Criteria) this;
        }

        public Criteria andDochospGreaterThan(String value) {
            addCriterion("docHosp >", value, "dochosp");
            return (Criteria) this;
        }

        public Criteria andDochospGreaterThanOrEqualTo(String value) {
            addCriterion("docHosp >=", value, "dochosp");
            return (Criteria) this;
        }

        public Criteria andDochospLessThan(String value) {
            addCriterion("docHosp <", value, "dochosp");
            return (Criteria) this;
        }

        public Criteria andDochospLessThanOrEqualTo(String value) {
            addCriterion("docHosp <=", value, "dochosp");
            return (Criteria) this;
        }

        public Criteria andDochospLike(String value) {
            addCriterion("docHosp like", value, "dochosp");
            return (Criteria) this;
        }

        public Criteria andDochospNotLike(String value) {
            addCriterion("docHosp not like", value, "dochosp");
            return (Criteria) this;
        }

        public Criteria andDochospIn(List<String> values) {
            addCriterion("docHosp in", values, "dochosp");
            return (Criteria) this;
        }

        public Criteria andDochospNotIn(List<String> values) {
            addCriterion("docHosp not in", values, "dochosp");
            return (Criteria) this;
        }

        public Criteria andDochospBetween(String value1, String value2) {
            addCriterion("docHosp between", value1, value2, "dochosp");
            return (Criteria) this;
        }

        public Criteria andDochospNotBetween(String value1, String value2) {
            addCriterion("docHosp not between", value1, value2, "dochosp");
            return (Criteria) this;
        }

        public Criteria andHosplevelIsNull() {
            addCriterion("hospLevel is null");
            return (Criteria) this;
        }

        public Criteria andHosplevelIsNotNull() {
            addCriterion("hospLevel is not null");
            return (Criteria) this;
        }

        public Criteria andHosplevelEqualTo(String value) {
            addCriterion("hospLevel =", value, "hosplevel");
            return (Criteria) this;
        }

        public Criteria andHosplevelNotEqualTo(String value) {
            addCriterion("hospLevel <>", value, "hosplevel");
            return (Criteria) this;
        }

        public Criteria andHosplevelGreaterThan(String value) {
            addCriterion("hospLevel >", value, "hosplevel");
            return (Criteria) this;
        }

        public Criteria andHosplevelGreaterThanOrEqualTo(String value) {
            addCriterion("hospLevel >=", value, "hosplevel");
            return (Criteria) this;
        }

        public Criteria andHosplevelLessThan(String value) {
            addCriterion("hospLevel <", value, "hosplevel");
            return (Criteria) this;
        }

        public Criteria andHosplevelLessThanOrEqualTo(String value) {
            addCriterion("hospLevel <=", value, "hosplevel");
            return (Criteria) this;
        }

        public Criteria andHosplevelLike(String value) {
            addCriterion("hospLevel like", value, "hosplevel");
            return (Criteria) this;
        }

        public Criteria andHosplevelNotLike(String value) {
            addCriterion("hospLevel not like", value, "hosplevel");
            return (Criteria) this;
        }

        public Criteria andHosplevelIn(List<String> values) {
            addCriterion("hospLevel in", values, "hosplevel");
            return (Criteria) this;
        }

        public Criteria andHosplevelNotIn(List<String> values) {
            addCriterion("hospLevel not in", values, "hosplevel");
            return (Criteria) this;
        }

        public Criteria andHosplevelBetween(String value1, String value2) {
            addCriterion("hospLevel between", value1, value2, "hosplevel");
            return (Criteria) this;
        }

        public Criteria andHosplevelNotBetween(String value1, String value2) {
            addCriterion("hospLevel not between", value1, value2, "hosplevel");
            return (Criteria) this;
        }

        public Criteria andDochospprovinceIsNull() {
            addCriterion("docHospProvince is null");
            return (Criteria) this;
        }

        public Criteria andDochospprovinceIsNotNull() {
            addCriterion("docHospProvince is not null");
            return (Criteria) this;
        }

        public Criteria andDochospprovinceEqualTo(String value) {
            addCriterion("docHospProvince =", value, "dochospprovince");
            return (Criteria) this;
        }

        public Criteria andDochospprovinceNotEqualTo(String value) {
            addCriterion("docHospProvince <>", value, "dochospprovince");
            return (Criteria) this;
        }

        public Criteria andDochospprovinceGreaterThan(String value) {
            addCriterion("docHospProvince >", value, "dochospprovince");
            return (Criteria) this;
        }

        public Criteria andDochospprovinceGreaterThanOrEqualTo(String value) {
            addCriterion("docHospProvince >=", value, "dochospprovince");
            return (Criteria) this;
        }

        public Criteria andDochospprovinceLessThan(String value) {
            addCriterion("docHospProvince <", value, "dochospprovince");
            return (Criteria) this;
        }

        public Criteria andDochospprovinceLessThanOrEqualTo(String value) {
            addCriterion("docHospProvince <=", value, "dochospprovince");
            return (Criteria) this;
        }

        public Criteria andDochospprovinceLike(String value) {
            addCriterion("docHospProvince like", value, "dochospprovince");
            return (Criteria) this;
        }

        public Criteria andDochospprovinceNotLike(String value) {
            addCriterion("docHospProvince not like", value, "dochospprovince");
            return (Criteria) this;
        }

        public Criteria andDochospprovinceIn(List<String> values) {
            addCriterion("docHospProvince in", values, "dochospprovince");
            return (Criteria) this;
        }

        public Criteria andDochospprovinceNotIn(List<String> values) {
            addCriterion("docHospProvince not in", values, "dochospprovince");
            return (Criteria) this;
        }

        public Criteria andDochospprovinceBetween(String value1, String value2) {
            addCriterion("docHospProvince between", value1, value2, "dochospprovince");
            return (Criteria) this;
        }

        public Criteria andDochospprovinceNotBetween(String value1, String value2) {
            addCriterion("docHospProvince not between", value1, value2, "dochospprovince");
            return (Criteria) this;
        }

        public Criteria andDochospcityIsNull() {
            addCriterion("docHospCity is null");
            return (Criteria) this;
        }

        public Criteria andDochospcityIsNotNull() {
            addCriterion("docHospCity is not null");
            return (Criteria) this;
        }

        public Criteria andDochospcityEqualTo(String value) {
            addCriterion("docHospCity =", value, "dochospcity");
            return (Criteria) this;
        }

        public Criteria andDochospcityNotEqualTo(String value) {
            addCriterion("docHospCity <>", value, "dochospcity");
            return (Criteria) this;
        }

        public Criteria andDochospcityGreaterThan(String value) {
            addCriterion("docHospCity >", value, "dochospcity");
            return (Criteria) this;
        }

        public Criteria andDochospcityGreaterThanOrEqualTo(String value) {
            addCriterion("docHospCity >=", value, "dochospcity");
            return (Criteria) this;
        }

        public Criteria andDochospcityLessThan(String value) {
            addCriterion("docHospCity <", value, "dochospcity");
            return (Criteria) this;
        }

        public Criteria andDochospcityLessThanOrEqualTo(String value) {
            addCriterion("docHospCity <=", value, "dochospcity");
            return (Criteria) this;
        }

        public Criteria andDochospcityLike(String value) {
            addCriterion("docHospCity like", value, "dochospcity");
            return (Criteria) this;
        }

        public Criteria andDochospcityNotLike(String value) {
            addCriterion("docHospCity not like", value, "dochospcity");
            return (Criteria) this;
        }

        public Criteria andDochospcityIn(List<String> values) {
            addCriterion("docHospCity in", values, "dochospcity");
            return (Criteria) this;
        }

        public Criteria andDochospcityNotIn(List<String> values) {
            addCriterion("docHospCity not in", values, "dochospcity");
            return (Criteria) this;
        }

        public Criteria andDochospcityBetween(String value1, String value2) {
            addCriterion("docHospCity between", value1, value2, "dochospcity");
            return (Criteria) this;
        }

        public Criteria andDochospcityNotBetween(String value1, String value2) {
            addCriterion("docHospCity not between", value1, value2, "dochospcity");
            return (Criteria) this;
        }

        public Criteria andDochospareaIsNull() {
            addCriterion("docHospArea is null");
            return (Criteria) this;
        }

        public Criteria andDochospareaIsNotNull() {
            addCriterion("docHospArea is not null");
            return (Criteria) this;
        }

        public Criteria andDochospareaEqualTo(String value) {
            addCriterion("docHospArea =", value, "dochosparea");
            return (Criteria) this;
        }

        public Criteria andDochospareaNotEqualTo(String value) {
            addCriterion("docHospArea <>", value, "dochosparea");
            return (Criteria) this;
        }

        public Criteria andDochospareaGreaterThan(String value) {
            addCriterion("docHospArea >", value, "dochosparea");
            return (Criteria) this;
        }

        public Criteria andDochospareaGreaterThanOrEqualTo(String value) {
            addCriterion("docHospArea >=", value, "dochosparea");
            return (Criteria) this;
        }

        public Criteria andDochospareaLessThan(String value) {
            addCriterion("docHospArea <", value, "dochosparea");
            return (Criteria) this;
        }

        public Criteria andDochospareaLessThanOrEqualTo(String value) {
            addCriterion("docHospArea <=", value, "dochosparea");
            return (Criteria) this;
        }

        public Criteria andDochospareaLike(String value) {
            addCriterion("docHospArea like", value, "dochosparea");
            return (Criteria) this;
        }

        public Criteria andDochospareaNotLike(String value) {
            addCriterion("docHospArea not like", value, "dochosparea");
            return (Criteria) this;
        }

        public Criteria andDochospareaIn(List<String> values) {
            addCriterion("docHospArea in", values, "dochosparea");
            return (Criteria) this;
        }

        public Criteria andDochospareaNotIn(List<String> values) {
            addCriterion("docHospArea not in", values, "dochosparea");
            return (Criteria) this;
        }

        public Criteria andDochospareaBetween(String value1, String value2) {
            addCriterion("docHospArea between", value1, value2, "dochosparea");
            return (Criteria) this;
        }

        public Criteria andDochospareaNotBetween(String value1, String value2) {
            addCriterion("docHospArea not between", value1, value2, "dochosparea");
            return (Criteria) this;
        }

        public Criteria andDochospotherIsNull() {
            addCriterion("docHospOther is null");
            return (Criteria) this;
        }

        public Criteria andDochospotherIsNotNull() {
            addCriterion("docHospOther is not null");
            return (Criteria) this;
        }

        public Criteria andDochospotherEqualTo(String value) {
            addCriterion("docHospOther =", value, "dochospother");
            return (Criteria) this;
        }

        public Criteria andDochospotherNotEqualTo(String value) {
            addCriterion("docHospOther <>", value, "dochospother");
            return (Criteria) this;
        }

        public Criteria andDochospotherGreaterThan(String value) {
            addCriterion("docHospOther >", value, "dochospother");
            return (Criteria) this;
        }

        public Criteria andDochospotherGreaterThanOrEqualTo(String value) {
            addCriterion("docHospOther >=", value, "dochospother");
            return (Criteria) this;
        }

        public Criteria andDochospotherLessThan(String value) {
            addCriterion("docHospOther <", value, "dochospother");
            return (Criteria) this;
        }

        public Criteria andDochospotherLessThanOrEqualTo(String value) {
            addCriterion("docHospOther <=", value, "dochospother");
            return (Criteria) this;
        }

        public Criteria andDochospotherLike(String value) {
            addCriterion("docHospOther like", value, "dochospother");
            return (Criteria) this;
        }

        public Criteria andDochospotherNotLike(String value) {
            addCriterion("docHospOther not like", value, "dochospother");
            return (Criteria) this;
        }

        public Criteria andDochospotherIn(List<String> values) {
            addCriterion("docHospOther in", values, "dochospother");
            return (Criteria) this;
        }

        public Criteria andDochospotherNotIn(List<String> values) {
            addCriterion("docHospOther not in", values, "dochospother");
            return (Criteria) this;
        }

        public Criteria andDochospotherBetween(String value1, String value2) {
            addCriterion("docHospOther between", value1, value2, "dochospother");
            return (Criteria) this;
        }

        public Criteria andDochospotherNotBetween(String value1, String value2) {
            addCriterion("docHospOther not between", value1, value2, "dochospother");
            return (Criteria) this;
        }

        public Criteria andDochosplonIsNull() {
            addCriterion("docHospLon is null");
            return (Criteria) this;
        }

        public Criteria andDochosplonIsNotNull() {
            addCriterion("docHospLon is not null");
            return (Criteria) this;
        }

        public Criteria andDochosplonEqualTo(String value) {
            addCriterion("docHospLon =", value, "dochosplon");
            return (Criteria) this;
        }

        public Criteria andDochosplonNotEqualTo(String value) {
            addCriterion("docHospLon <>", value, "dochosplon");
            return (Criteria) this;
        }

        public Criteria andDochosplonGreaterThan(String value) {
            addCriterion("docHospLon >", value, "dochosplon");
            return (Criteria) this;
        }

        public Criteria andDochosplonGreaterThanOrEqualTo(String value) {
            addCriterion("docHospLon >=", value, "dochosplon");
            return (Criteria) this;
        }

        public Criteria andDochosplonLessThan(String value) {
            addCriterion("docHospLon <", value, "dochosplon");
            return (Criteria) this;
        }

        public Criteria andDochosplonLessThanOrEqualTo(String value) {
            addCriterion("docHospLon <=", value, "dochosplon");
            return (Criteria) this;
        }

        public Criteria andDochosplonLike(String value) {
            addCriterion("docHospLon like", value, "dochosplon");
            return (Criteria) this;
        }

        public Criteria andDochosplonNotLike(String value) {
            addCriterion("docHospLon not like", value, "dochosplon");
            return (Criteria) this;
        }

        public Criteria andDochosplonIn(List<String> values) {
            addCriterion("docHospLon in", values, "dochosplon");
            return (Criteria) this;
        }

        public Criteria andDochosplonNotIn(List<String> values) {
            addCriterion("docHospLon not in", values, "dochosplon");
            return (Criteria) this;
        }

        public Criteria andDochosplonBetween(String value1, String value2) {
            addCriterion("docHospLon between", value1, value2, "dochosplon");
            return (Criteria) this;
        }

        public Criteria andDochosplonNotBetween(String value1, String value2) {
            addCriterion("docHospLon not between", value1, value2, "dochosplon");
            return (Criteria) this;
        }

        public Criteria andDochosplatIsNull() {
            addCriterion("docHospLat is null");
            return (Criteria) this;
        }

        public Criteria andDochosplatIsNotNull() {
            addCriterion("docHospLat is not null");
            return (Criteria) this;
        }

        public Criteria andDochosplatEqualTo(String value) {
            addCriterion("docHospLat =", value, "dochosplat");
            return (Criteria) this;
        }

        public Criteria andDochosplatNotEqualTo(String value) {
            addCriterion("docHospLat <>", value, "dochosplat");
            return (Criteria) this;
        }

        public Criteria andDochosplatGreaterThan(String value) {
            addCriterion("docHospLat >", value, "dochosplat");
            return (Criteria) this;
        }

        public Criteria andDochosplatGreaterThanOrEqualTo(String value) {
            addCriterion("docHospLat >=", value, "dochosplat");
            return (Criteria) this;
        }

        public Criteria andDochosplatLessThan(String value) {
            addCriterion("docHospLat <", value, "dochosplat");
            return (Criteria) this;
        }

        public Criteria andDochosplatLessThanOrEqualTo(String value) {
            addCriterion("docHospLat <=", value, "dochosplat");
            return (Criteria) this;
        }

        public Criteria andDochosplatLike(String value) {
            addCriterion("docHospLat like", value, "dochosplat");
            return (Criteria) this;
        }

        public Criteria andDochosplatNotLike(String value) {
            addCriterion("docHospLat not like", value, "dochosplat");
            return (Criteria) this;
        }

        public Criteria andDochosplatIn(List<String> values) {
            addCriterion("docHospLat in", values, "dochosplat");
            return (Criteria) this;
        }

        public Criteria andDochosplatNotIn(List<String> values) {
            addCriterion("docHospLat not in", values, "dochosplat");
            return (Criteria) this;
        }

        public Criteria andDochosplatBetween(String value1, String value2) {
            addCriterion("docHospLat between", value1, value2, "dochosplat");
            return (Criteria) this;
        }

        public Criteria andDochosplatNotBetween(String value1, String value2) {
            addCriterion("docHospLat not between", value1, value2, "dochosplat");
            return (Criteria) this;
        }

        public Criteria andDocprimarydeptIsNull() {
            addCriterion("docPrimaryDept is null");
            return (Criteria) this;
        }

        public Criteria andDocprimarydeptIsNotNull() {
            addCriterion("docPrimaryDept is not null");
            return (Criteria) this;
        }

        public Criteria andDocprimarydeptEqualTo(String value) {
            addCriterion("docPrimaryDept =", value, "docprimarydept");
            return (Criteria) this;
        }

        public Criteria andDocprimarydeptNotEqualTo(String value) {
            addCriterion("docPrimaryDept <>", value, "docprimarydept");
            return (Criteria) this;
        }

        public Criteria andDocprimarydeptGreaterThan(String value) {
            addCriterion("docPrimaryDept >", value, "docprimarydept");
            return (Criteria) this;
        }

        public Criteria andDocprimarydeptGreaterThanOrEqualTo(String value) {
            addCriterion("docPrimaryDept >=", value, "docprimarydept");
            return (Criteria) this;
        }

        public Criteria andDocprimarydeptLessThan(String value) {
            addCriterion("docPrimaryDept <", value, "docprimarydept");
            return (Criteria) this;
        }

        public Criteria andDocprimarydeptLessThanOrEqualTo(String value) {
            addCriterion("docPrimaryDept <=", value, "docprimarydept");
            return (Criteria) this;
        }

        public Criteria andDocprimarydeptLike(String value) {
            addCriterion("docPrimaryDept like", value, "docprimarydept");
            return (Criteria) this;
        }

        public Criteria andDocprimarydeptNotLike(String value) {
            addCriterion("docPrimaryDept not like", value, "docprimarydept");
            return (Criteria) this;
        }

        public Criteria andDocprimarydeptIn(List<String> values) {
            addCriterion("docPrimaryDept in", values, "docprimarydept");
            return (Criteria) this;
        }

        public Criteria andDocprimarydeptNotIn(List<String> values) {
            addCriterion("docPrimaryDept not in", values, "docprimarydept");
            return (Criteria) this;
        }

        public Criteria andDocprimarydeptBetween(String value1, String value2) {
            addCriterion("docPrimaryDept between", value1, value2, "docprimarydept");
            return (Criteria) this;
        }

        public Criteria andDocprimarydeptNotBetween(String value1, String value2) {
            addCriterion("docPrimaryDept not between", value1, value2, "docprimarydept");
            return (Criteria) this;
        }

        public Criteria andDocseconddeptIsNull() {
            addCriterion("docSecondDept is null");
            return (Criteria) this;
        }

        public Criteria andDocseconddeptIsNotNull() {
            addCriterion("docSecondDept is not null");
            return (Criteria) this;
        }

        public Criteria andDocseconddeptEqualTo(String value) {
            addCriterion("docSecondDept =", value, "docseconddept");
            return (Criteria) this;
        }

        public Criteria andDocseconddeptNotEqualTo(String value) {
            addCriterion("docSecondDept <>", value, "docseconddept");
            return (Criteria) this;
        }

        public Criteria andDocseconddeptGreaterThan(String value) {
            addCriterion("docSecondDept >", value, "docseconddept");
            return (Criteria) this;
        }

        public Criteria andDocseconddeptGreaterThanOrEqualTo(String value) {
            addCriterion("docSecondDept >=", value, "docseconddept");
            return (Criteria) this;
        }

        public Criteria andDocseconddeptLessThan(String value) {
            addCriterion("docSecondDept <", value, "docseconddept");
            return (Criteria) this;
        }

        public Criteria andDocseconddeptLessThanOrEqualTo(String value) {
            addCriterion("docSecondDept <=", value, "docseconddept");
            return (Criteria) this;
        }

        public Criteria andDocseconddeptLike(String value) {
            addCriterion("docSecondDept like", value, "docseconddept");
            return (Criteria) this;
        }

        public Criteria andDocseconddeptNotLike(String value) {
            addCriterion("docSecondDept not like", value, "docseconddept");
            return (Criteria) this;
        }

        public Criteria andDocseconddeptIn(List<String> values) {
            addCriterion("docSecondDept in", values, "docseconddept");
            return (Criteria) this;
        }

        public Criteria andDocseconddeptNotIn(List<String> values) {
            addCriterion("docSecondDept not in", values, "docseconddept");
            return (Criteria) this;
        }

        public Criteria andDocseconddeptBetween(String value1, String value2) {
            addCriterion("docSecondDept between", value1, value2, "docseconddept");
            return (Criteria) this;
        }

        public Criteria andDocseconddeptNotBetween(String value1, String value2) {
            addCriterion("docSecondDept not between", value1, value2, "docseconddept");
            return (Criteria) this;
        }

        public Criteria andDoctitlephotoIsNull() {
            addCriterion("docTitlePhoto is null");
            return (Criteria) this;
        }

        public Criteria andDoctitlephotoIsNotNull() {
            addCriterion("docTitlePhoto is not null");
            return (Criteria) this;
        }

        public Criteria andDoctitlephotoEqualTo(String value) {
            addCriterion("docTitlePhoto =", value, "doctitlephoto");
            return (Criteria) this;
        }

        public Criteria andDoctitlephotoNotEqualTo(String value) {
            addCriterion("docTitlePhoto <>", value, "doctitlephoto");
            return (Criteria) this;
        }

        public Criteria andDoctitlephotoGreaterThan(String value) {
            addCriterion("docTitlePhoto >", value, "doctitlephoto");
            return (Criteria) this;
        }

        public Criteria andDoctitlephotoGreaterThanOrEqualTo(String value) {
            addCriterion("docTitlePhoto >=", value, "doctitlephoto");
            return (Criteria) this;
        }

        public Criteria andDoctitlephotoLessThan(String value) {
            addCriterion("docTitlePhoto <", value, "doctitlephoto");
            return (Criteria) this;
        }

        public Criteria andDoctitlephotoLessThanOrEqualTo(String value) {
            addCriterion("docTitlePhoto <=", value, "doctitlephoto");
            return (Criteria) this;
        }

        public Criteria andDoctitlephotoLike(String value) {
            addCriterion("docTitlePhoto like", value, "doctitlephoto");
            return (Criteria) this;
        }

        public Criteria andDoctitlephotoNotLike(String value) {
            addCriterion("docTitlePhoto not like", value, "doctitlephoto");
            return (Criteria) this;
        }

        public Criteria andDoctitlephotoIn(List<String> values) {
            addCriterion("docTitlePhoto in", values, "doctitlephoto");
            return (Criteria) this;
        }

        public Criteria andDoctitlephotoNotIn(List<String> values) {
            addCriterion("docTitlePhoto not in", values, "doctitlephoto");
            return (Criteria) this;
        }

        public Criteria andDoctitlephotoBetween(String value1, String value2) {
            addCriterion("docTitlePhoto between", value1, value2, "doctitlephoto");
            return (Criteria) this;
        }

        public Criteria andDoctitlephotoNotBetween(String value1, String value2) {
            addCriterion("docTitlePhoto not between", value1, value2, "doctitlephoto");
            return (Criteria) this;
        }

        public Criteria andDocworkcardphotoIsNull() {
            addCriterion("docWorkCardPhoto is null");
            return (Criteria) this;
        }

        public Criteria andDocworkcardphotoIsNotNull() {
            addCriterion("docWorkCardPhoto is not null");
            return (Criteria) this;
        }

        public Criteria andDocworkcardphotoEqualTo(String value) {
            addCriterion("docWorkCardPhoto =", value, "docworkcardphoto");
            return (Criteria) this;
        }

        public Criteria andDocworkcardphotoNotEqualTo(String value) {
            addCriterion("docWorkCardPhoto <>", value, "docworkcardphoto");
            return (Criteria) this;
        }

        public Criteria andDocworkcardphotoGreaterThan(String value) {
            addCriterion("docWorkCardPhoto >", value, "docworkcardphoto");
            return (Criteria) this;
        }

        public Criteria andDocworkcardphotoGreaterThanOrEqualTo(String value) {
            addCriterion("docWorkCardPhoto >=", value, "docworkcardphoto");
            return (Criteria) this;
        }

        public Criteria andDocworkcardphotoLessThan(String value) {
            addCriterion("docWorkCardPhoto <", value, "docworkcardphoto");
            return (Criteria) this;
        }

        public Criteria andDocworkcardphotoLessThanOrEqualTo(String value) {
            addCriterion("docWorkCardPhoto <=", value, "docworkcardphoto");
            return (Criteria) this;
        }

        public Criteria andDocworkcardphotoLike(String value) {
            addCriterion("docWorkCardPhoto like", value, "docworkcardphoto");
            return (Criteria) this;
        }

        public Criteria andDocworkcardphotoNotLike(String value) {
            addCriterion("docWorkCardPhoto not like", value, "docworkcardphoto");
            return (Criteria) this;
        }

        public Criteria andDocworkcardphotoIn(List<String> values) {
            addCriterion("docWorkCardPhoto in", values, "docworkcardphoto");
            return (Criteria) this;
        }

        public Criteria andDocworkcardphotoNotIn(List<String> values) {
            addCriterion("docWorkCardPhoto not in", values, "docworkcardphoto");
            return (Criteria) this;
        }

        public Criteria andDocworkcardphotoBetween(String value1, String value2) {
            addCriterion("docWorkCardPhoto between", value1, value2, "docworkcardphoto");
            return (Criteria) this;
        }

        public Criteria andDocworkcardphotoNotBetween(String value1, String value2) {
            addCriterion("docWorkCardPhoto not between", value1, value2, "docworkcardphoto");
            return (Criteria) this;
        }

        public Criteria andDocqualphotoIsNull() {
            addCriterion("docQualPhoto is null");
            return (Criteria) this;
        }

        public Criteria andDocqualphotoIsNotNull() {
            addCriterion("docQualPhoto is not null");
            return (Criteria) this;
        }

        public Criteria andDocqualphotoEqualTo(String value) {
            addCriterion("docQualPhoto =", value, "docqualphoto");
            return (Criteria) this;
        }

        public Criteria andDocqualphotoNotEqualTo(String value) {
            addCriterion("docQualPhoto <>", value, "docqualphoto");
            return (Criteria) this;
        }

        public Criteria andDocqualphotoGreaterThan(String value) {
            addCriterion("docQualPhoto >", value, "docqualphoto");
            return (Criteria) this;
        }

        public Criteria andDocqualphotoGreaterThanOrEqualTo(String value) {
            addCriterion("docQualPhoto >=", value, "docqualphoto");
            return (Criteria) this;
        }

        public Criteria andDocqualphotoLessThan(String value) {
            addCriterion("docQualPhoto <", value, "docqualphoto");
            return (Criteria) this;
        }

        public Criteria andDocqualphotoLessThanOrEqualTo(String value) {
            addCriterion("docQualPhoto <=", value, "docqualphoto");
            return (Criteria) this;
        }

        public Criteria andDocqualphotoLike(String value) {
            addCriterion("docQualPhoto like", value, "docqualphoto");
            return (Criteria) this;
        }

        public Criteria andDocqualphotoNotLike(String value) {
            addCriterion("docQualPhoto not like", value, "docqualphoto");
            return (Criteria) this;
        }

        public Criteria andDocqualphotoIn(List<String> values) {
            addCriterion("docQualPhoto in", values, "docqualphoto");
            return (Criteria) this;
        }

        public Criteria andDocqualphotoNotIn(List<String> values) {
            addCriterion("docQualPhoto not in", values, "docqualphoto");
            return (Criteria) this;
        }

        public Criteria andDocqualphotoBetween(String value1, String value2) {
            addCriterion("docQualPhoto between", value1, value2, "docqualphoto");
            return (Criteria) this;
        }

        public Criteria andDocqualphotoNotBetween(String value1, String value2) {
            addCriterion("docQualPhoto not between", value1, value2, "docqualphoto");
            return (Criteria) this;
        }

        public Criteria andDocexpertIsNull() {
            addCriterion("docExpert is null");
            return (Criteria) this;
        }

        public Criteria andDocexpertIsNotNull() {
            addCriterion("docExpert is not null");
            return (Criteria) this;
        }

        public Criteria andDocexpertEqualTo(String value) {
            addCriterion("docExpert =", value, "docexpert");
            return (Criteria) this;
        }

        public Criteria andDocexpertNotEqualTo(String value) {
            addCriterion("docExpert <>", value, "docexpert");
            return (Criteria) this;
        }

        public Criteria andDocexpertGreaterThan(String value) {
            addCriterion("docExpert >", value, "docexpert");
            return (Criteria) this;
        }

        public Criteria andDocexpertGreaterThanOrEqualTo(String value) {
            addCriterion("docExpert >=", value, "docexpert");
            return (Criteria) this;
        }

        public Criteria andDocexpertLessThan(String value) {
            addCriterion("docExpert <", value, "docexpert");
            return (Criteria) this;
        }

        public Criteria andDocexpertLessThanOrEqualTo(String value) {
            addCriterion("docExpert <=", value, "docexpert");
            return (Criteria) this;
        }

        public Criteria andDocexpertLike(String value) {
            addCriterion("docExpert like", value, "docexpert");
            return (Criteria) this;
        }

        public Criteria andDocexpertNotLike(String value) {
            addCriterion("docExpert not like", value, "docexpert");
            return (Criteria) this;
        }

        public Criteria andDocexpertIn(List<String> values) {
            addCriterion("docExpert in", values, "docexpert");
            return (Criteria) this;
        }

        public Criteria andDocexpertNotIn(List<String> values) {
            addCriterion("docExpert not in", values, "docexpert");
            return (Criteria) this;
        }

        public Criteria andDocexpertBetween(String value1, String value2) {
            addCriterion("docExpert between", value1, value2, "docexpert");
            return (Criteria) this;
        }

        public Criteria andDocexpertNotBetween(String value1, String value2) {
            addCriterion("docExpert not between", value1, value2, "docexpert");
            return (Criteria) this;
        }

        public Criteria andDocotherphotoIsNull() {
            addCriterion("docOtherPhoto is null");
            return (Criteria) this;
        }

        public Criteria andDocotherphotoIsNotNull() {
            addCriterion("docOtherPhoto is not null");
            return (Criteria) this;
        }

        public Criteria andDocotherphotoEqualTo(String value) {
            addCriterion("docOtherPhoto =", value, "docotherphoto");
            return (Criteria) this;
        }

        public Criteria andDocotherphotoNotEqualTo(String value) {
            addCriterion("docOtherPhoto <>", value, "docotherphoto");
            return (Criteria) this;
        }

        public Criteria andDocotherphotoGreaterThan(String value) {
            addCriterion("docOtherPhoto >", value, "docotherphoto");
            return (Criteria) this;
        }

        public Criteria andDocotherphotoGreaterThanOrEqualTo(String value) {
            addCriterion("docOtherPhoto >=", value, "docotherphoto");
            return (Criteria) this;
        }

        public Criteria andDocotherphotoLessThan(String value) {
            addCriterion("docOtherPhoto <", value, "docotherphoto");
            return (Criteria) this;
        }

        public Criteria andDocotherphotoLessThanOrEqualTo(String value) {
            addCriterion("docOtherPhoto <=", value, "docotherphoto");
            return (Criteria) this;
        }

        public Criteria andDocotherphotoLike(String value) {
            addCriterion("docOtherPhoto like", value, "docotherphoto");
            return (Criteria) this;
        }

        public Criteria andDocotherphotoNotLike(String value) {
            addCriterion("docOtherPhoto not like", value, "docotherphoto");
            return (Criteria) this;
        }

        public Criteria andDocotherphotoIn(List<String> values) {
            addCriterion("docOtherPhoto in", values, "docotherphoto");
            return (Criteria) this;
        }

        public Criteria andDocotherphotoNotIn(List<String> values) {
            addCriterion("docOtherPhoto not in", values, "docotherphoto");
            return (Criteria) this;
        }

        public Criteria andDocotherphotoBetween(String value1, String value2) {
            addCriterion("docOtherPhoto between", value1, value2, "docotherphoto");
            return (Criteria) this;
        }

        public Criteria andDocotherphotoNotBetween(String value1, String value2) {
            addCriterion("docOtherPhoto not between", value1, value2, "docotherphoto");
            return (Criteria) this;
        }

        public Criteria andDocalldayIsNull() {
            addCriterion("docAllDay is null");
            return (Criteria) this;
        }

        public Criteria andDocalldayIsNotNull() {
            addCriterion("docAllDay is not null");
            return (Criteria) this;
        }

        public Criteria andDocalldayEqualTo(Boolean value) {
            addCriterion("docAllDay =", value, "docallday");
            return (Criteria) this;
        }

        public Criteria andDocalldayNotEqualTo(Boolean value) {
            addCriterion("docAllDay <>", value, "docallday");
            return (Criteria) this;
        }

        public Criteria andDocalldayGreaterThan(Boolean value) {
            addCriterion("docAllDay >", value, "docallday");
            return (Criteria) this;
        }

        public Criteria andDocalldayGreaterThanOrEqualTo(Boolean value) {
            addCriterion("docAllDay >=", value, "docallday");
            return (Criteria) this;
        }

        public Criteria andDocalldayLessThan(Boolean value) {
            addCriterion("docAllDay <", value, "docallday");
            return (Criteria) this;
        }

        public Criteria andDocalldayLessThanOrEqualTo(Boolean value) {
            addCriterion("docAllDay <=", value, "docallday");
            return (Criteria) this;
        }

        public Criteria andDocalldayIn(List<Boolean> values) {
            addCriterion("docAllDay in", values, "docallday");
            return (Criteria) this;
        }

        public Criteria andDocalldayNotIn(List<Boolean> values) {
            addCriterion("docAllDay not in", values, "docallday");
            return (Criteria) this;
        }

        public Criteria andDocalldayBetween(Boolean value1, Boolean value2) {
            addCriterion("docAllDay between", value1, value2, "docallday");
            return (Criteria) this;
        }

        public Criteria andDocalldayNotBetween(Boolean value1, Boolean value2) {
            addCriterion("docAllDay not between", value1, value2, "docallday");
            return (Criteria) this;
        }

        public Criteria andDocabsIsNull() {
            addCriterion("docAbs is null");
            return (Criteria) this;
        }

        public Criteria andDocabsIsNotNull() {
            addCriterion("docAbs is not null");
            return (Criteria) this;
        }

        public Criteria andDocabsEqualTo(String value) {
            addCriterion("docAbs =", value, "docabs");
            return (Criteria) this;
        }

        public Criteria andDocabsNotEqualTo(String value) {
            addCriterion("docAbs <>", value, "docabs");
            return (Criteria) this;
        }

        public Criteria andDocabsGreaterThan(String value) {
            addCriterion("docAbs >", value, "docabs");
            return (Criteria) this;
        }

        public Criteria andDocabsGreaterThanOrEqualTo(String value) {
            addCriterion("docAbs >=", value, "docabs");
            return (Criteria) this;
        }

        public Criteria andDocabsLessThan(String value) {
            addCriterion("docAbs <", value, "docabs");
            return (Criteria) this;
        }

        public Criteria andDocabsLessThanOrEqualTo(String value) {
            addCriterion("docAbs <=", value, "docabs");
            return (Criteria) this;
        }

        public Criteria andDocabsLike(String value) {
            addCriterion("docAbs like", value, "docabs");
            return (Criteria) this;
        }

        public Criteria andDocabsNotLike(String value) {
            addCriterion("docAbs not like", value, "docabs");
            return (Criteria) this;
        }

        public Criteria andDocabsIn(List<String> values) {
            addCriterion("docAbs in", values, "docabs");
            return (Criteria) this;
        }

        public Criteria andDocabsNotIn(List<String> values) {
            addCriterion("docAbs not in", values, "docabs");
            return (Criteria) this;
        }

        public Criteria andDocabsBetween(String value1, String value2) {
            addCriterion("docAbs between", value1, value2, "docabs");
            return (Criteria) this;
        }

        public Criteria andDocabsNotBetween(String value1, String value2) {
            addCriterion("docAbs not between", value1, value2, "docabs");
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

        public Criteria andDocdeptIsNull() {
            addCriterion("docDept is null");
            return (Criteria) this;
        }

        public Criteria andDocdeptIsNotNull() {
            addCriterion("docDept is not null");
            return (Criteria) this;
        }

        public Criteria andDocdeptEqualTo(String value) {
            addCriterion("docDept =", value, "docdept");
            return (Criteria) this;
        }

        public Criteria andDocdeptNotEqualTo(String value) {
            addCriterion("docDept <>", value, "docdept");
            return (Criteria) this;
        }

        public Criteria andDocdeptGreaterThan(String value) {
            addCriterion("docDept >", value, "docdept");
            return (Criteria) this;
        }

        public Criteria andDocdeptGreaterThanOrEqualTo(String value) {
            addCriterion("docDept >=", value, "docdept");
            return (Criteria) this;
        }

        public Criteria andDocdeptLessThan(String value) {
            addCriterion("docDept <", value, "docdept");
            return (Criteria) this;
        }

        public Criteria andDocdeptLessThanOrEqualTo(String value) {
            addCriterion("docDept <=", value, "docdept");
            return (Criteria) this;
        }

        public Criteria andDocdeptLike(String value) {
            addCriterion("docDept like", value, "docdept");
            return (Criteria) this;
        }

        public Criteria andDocdeptNotLike(String value) {
            addCriterion("docDept not like", value, "docdept");
            return (Criteria) this;
        }

        public Criteria andDocdeptIn(List<String> values) {
            addCriterion("docDept in", values, "docdept");
            return (Criteria) this;
        }

        public Criteria andDocdeptNotIn(List<String> values) {
            addCriterion("docDept not in", values, "docdept");
            return (Criteria) this;
        }

        public Criteria andDocdeptBetween(String value1, String value2) {
            addCriterion("docDept between", value1, value2, "docdept");
            return (Criteria) this;
        }

        public Criteria andDocdeptNotBetween(String value1, String value2) {
            addCriterion("docDept not between", value1, value2, "docdept");
            return (Criteria) this;
        }

        public Criteria andDocalipayaccountIsNull() {
            addCriterion("docAlipayAccount is null");
            return (Criteria) this;
        }

        public Criteria andDocalipayaccountIsNotNull() {
            addCriterion("docAlipayAccount is not null");
            return (Criteria) this;
        }

        public Criteria andDocalipayaccountEqualTo(String value) {
            addCriterion("docAlipayAccount =", value, "docalipayaccount");
            return (Criteria) this;
        }

        public Criteria andDocalipayaccountNotEqualTo(String value) {
            addCriterion("docAlipayAccount <>", value, "docalipayaccount");
            return (Criteria) this;
        }

        public Criteria andDocalipayaccountGreaterThan(String value) {
            addCriterion("docAlipayAccount >", value, "docalipayaccount");
            return (Criteria) this;
        }

        public Criteria andDocalipayaccountGreaterThanOrEqualTo(String value) {
            addCriterion("docAlipayAccount >=", value, "docalipayaccount");
            return (Criteria) this;
        }

        public Criteria andDocalipayaccountLessThan(String value) {
            addCriterion("docAlipayAccount <", value, "docalipayaccount");
            return (Criteria) this;
        }

        public Criteria andDocalipayaccountLessThanOrEqualTo(String value) {
            addCriterion("docAlipayAccount <=", value, "docalipayaccount");
            return (Criteria) this;
        }

        public Criteria andDocalipayaccountLike(String value) {
            addCriterion("docAlipayAccount like", value, "docalipayaccount");
            return (Criteria) this;
        }

        public Criteria andDocalipayaccountNotLike(String value) {
            addCriterion("docAlipayAccount not like", value, "docalipayaccount");
            return (Criteria) this;
        }

        public Criteria andDocalipayaccountIn(List<String> values) {
            addCriterion("docAlipayAccount in", values, "docalipayaccount");
            return (Criteria) this;
        }

        public Criteria andDocalipayaccountNotIn(List<String> values) {
            addCriterion("docAlipayAccount not in", values, "docalipayaccount");
            return (Criteria) this;
        }

        public Criteria andDocalipayaccountBetween(String value1, String value2) {
            addCriterion("docAlipayAccount between", value1, value2, "docalipayaccount");
            return (Criteria) this;
        }

        public Criteria andDocalipayaccountNotBetween(String value1, String value2) {
            addCriterion("docAlipayAccount not between", value1, value2, "docalipayaccount");
            return (Criteria) this;
        }

        public Criteria andDocpursebalanceIsNull() {
            addCriterion("docPurseBalance is null");
            return (Criteria) this;
        }

        public Criteria andDocpursebalanceIsNotNull() {
            addCriterion("docPurseBalance is not null");
            return (Criteria) this;
        }

        public Criteria andDocpursebalanceEqualTo(BigDecimal value) {
            addCriterion("docPurseBalance =", value, "docpursebalance");
            return (Criteria) this;
        }

        public Criteria andDocpursebalanceNotEqualTo(BigDecimal value) {
            addCriterion("docPurseBalance <>", value, "docpursebalance");
            return (Criteria) this;
        }

        public Criteria andDocpursebalanceGreaterThan(BigDecimal value) {
            addCriterion("docPurseBalance >", value, "docpursebalance");
            return (Criteria) this;
        }

        public Criteria andDocpursebalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("docPurseBalance >=", value, "docpursebalance");
            return (Criteria) this;
        }

        public Criteria andDocpursebalanceLessThan(BigDecimal value) {
            addCriterion("docPurseBalance <", value, "docpursebalance");
            return (Criteria) this;
        }

        public Criteria andDocpursebalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("docPurseBalance <=", value, "docpursebalance");
            return (Criteria) this;
        }

        public Criteria andDocpursebalanceIn(List<BigDecimal> values) {
            addCriterion("docPurseBalance in", values, "docpursebalance");
            return (Criteria) this;
        }

        public Criteria andDocpursebalanceNotIn(List<BigDecimal> values) {
            addCriterion("docPurseBalance not in", values, "docpursebalance");
            return (Criteria) this;
        }

        public Criteria andDocpursebalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("docPurseBalance between", value1, value2, "docpursebalance");
            return (Criteria) this;
        }

        public Criteria andDocpursebalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("docPurseBalance not between", value1, value2, "docpursebalance");
            return (Criteria) this;
        }

        public Criteria andDocalipaynameIsNull() {
            addCriterion("docAlipayName is null");
            return (Criteria) this;
        }

        public Criteria andDocalipaynameIsNotNull() {
            addCriterion("docAlipayName is not null");
            return (Criteria) this;
        }

        public Criteria andDocalipaynameEqualTo(String value) {
            addCriterion("docAlipayName =", value, "docalipayname");
            return (Criteria) this;
        }

        public Criteria andDocalipaynameNotEqualTo(String value) {
            addCriterion("docAlipayName <>", value, "docalipayname");
            return (Criteria) this;
        }

        public Criteria andDocalipaynameGreaterThan(String value) {
            addCriterion("docAlipayName >", value, "docalipayname");
            return (Criteria) this;
        }

        public Criteria andDocalipaynameGreaterThanOrEqualTo(String value) {
            addCriterion("docAlipayName >=", value, "docalipayname");
            return (Criteria) this;
        }

        public Criteria andDocalipaynameLessThan(String value) {
            addCriterion("docAlipayName <", value, "docalipayname");
            return (Criteria) this;
        }

        public Criteria andDocalipaynameLessThanOrEqualTo(String value) {
            addCriterion("docAlipayName <=", value, "docalipayname");
            return (Criteria) this;
        }

        public Criteria andDocalipaynameLike(String value) {
            addCriterion("docAlipayName like", value, "docalipayname");
            return (Criteria) this;
        }

        public Criteria andDocalipaynameNotLike(String value) {
            addCriterion("docAlipayName not like", value, "docalipayname");
            return (Criteria) this;
        }

        public Criteria andDocalipaynameIn(List<String> values) {
            addCriterion("docAlipayName in", values, "docalipayname");
            return (Criteria) this;
        }

        public Criteria andDocalipaynameNotIn(List<String> values) {
            addCriterion("docAlipayName not in", values, "docalipayname");
            return (Criteria) this;
        }

        public Criteria andDocalipaynameBetween(String value1, String value2) {
            addCriterion("docAlipayName between", value1, value2, "docalipayname");
            return (Criteria) this;
        }

        public Criteria andDocalipaynameNotBetween(String value1, String value2) {
            addCriterion("docAlipayName not between", value1, value2, "docalipayname");
            return (Criteria) this;
        }

        public Criteria andDocpriceIsNull() {
            addCriterion("docPrice is null");
            return (Criteria) this;
        }

        public Criteria andDocpriceIsNotNull() {
            addCriterion("docPrice is not null");
            return (Criteria) this;
        }

        public Criteria andDocpriceEqualTo(BigDecimal value) {
            addCriterion("docPrice =", value, "docprice");
            return (Criteria) this;
        }

        public Criteria andDocpriceNotEqualTo(BigDecimal value) {
            addCriterion("docPrice <>", value, "docprice");
            return (Criteria) this;
        }

        public Criteria andDocpriceGreaterThan(BigDecimal value) {
            addCriterion("docPrice >", value, "docprice");
            return (Criteria) this;
        }

        public Criteria andDocpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("docPrice >=", value, "docprice");
            return (Criteria) this;
        }

        public Criteria andDocpriceLessThan(BigDecimal value) {
            addCriterion("docPrice <", value, "docprice");
            return (Criteria) this;
        }

        public Criteria andDocpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("docPrice <=", value, "docprice");
            return (Criteria) this;
        }

        public Criteria andDocpriceIn(List<BigDecimal> values) {
            addCriterion("docPrice in", values, "docprice");
            return (Criteria) this;
        }

        public Criteria andDocpriceNotIn(List<BigDecimal> values) {
            addCriterion("docPrice not in", values, "docprice");
            return (Criteria) this;
        }

        public Criteria andDocpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("docPrice between", value1, value2, "docprice");
            return (Criteria) this;
        }

        public Criteria andDocpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("docPrice not between", value1, value2, "docprice");
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