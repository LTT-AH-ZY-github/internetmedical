package com.medical.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserinfoExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("userName is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("userName is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("userName =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("userName <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("userName >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("userName >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("userName <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("userName <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("userName like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("userName not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("userName in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("userName not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("userName between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("userName not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsermaleIsNull() {
            addCriterion("userMale is null");
            return (Criteria) this;
        }

        public Criteria andUsermaleIsNotNull() {
            addCriterion("userMale is not null");
            return (Criteria) this;
        }

        public Criteria andUsermaleEqualTo(String value) {
            addCriterion("userMale =", value, "usermale");
            return (Criteria) this;
        }

        public Criteria andUsermaleNotEqualTo(String value) {
            addCriterion("userMale <>", value, "usermale");
            return (Criteria) this;
        }

        public Criteria andUsermaleGreaterThan(String value) {
            addCriterion("userMale >", value, "usermale");
            return (Criteria) this;
        }

        public Criteria andUsermaleGreaterThanOrEqualTo(String value) {
            addCriterion("userMale >=", value, "usermale");
            return (Criteria) this;
        }

        public Criteria andUsermaleLessThan(String value) {
            addCriterion("userMale <", value, "usermale");
            return (Criteria) this;
        }

        public Criteria andUsermaleLessThanOrEqualTo(String value) {
            addCriterion("userMale <=", value, "usermale");
            return (Criteria) this;
        }

        public Criteria andUsermaleLike(String value) {
            addCriterion("userMale like", value, "usermale");
            return (Criteria) this;
        }

        public Criteria andUsermaleNotLike(String value) {
            addCriterion("userMale not like", value, "usermale");
            return (Criteria) this;
        }

        public Criteria andUsermaleIn(List<String> values) {
            addCriterion("userMale in", values, "usermale");
            return (Criteria) this;
        }

        public Criteria andUsermaleNotIn(List<String> values) {
            addCriterion("userMale not in", values, "usermale");
            return (Criteria) this;
        }

        public Criteria andUsermaleBetween(String value1, String value2) {
            addCriterion("userMale between", value1, value2, "usermale");
            return (Criteria) this;
        }

        public Criteria andUsermaleNotBetween(String value1, String value2) {
            addCriterion("userMale not between", value1, value2, "usermale");
            return (Criteria) this;
        }

        public Criteria andUserageIsNull() {
            addCriterion("userAge is null");
            return (Criteria) this;
        }

        public Criteria andUserageIsNotNull() {
            addCriterion("userAge is not null");
            return (Criteria) this;
        }

        public Criteria andUserageEqualTo(Integer value) {
            addCriterion("userAge =", value, "userage");
            return (Criteria) this;
        }

        public Criteria andUserageNotEqualTo(Integer value) {
            addCriterion("userAge <>", value, "userage");
            return (Criteria) this;
        }

        public Criteria andUserageGreaterThan(Integer value) {
            addCriterion("userAge >", value, "userage");
            return (Criteria) this;
        }

        public Criteria andUserageGreaterThanOrEqualTo(Integer value) {
            addCriterion("userAge >=", value, "userage");
            return (Criteria) this;
        }

        public Criteria andUserageLessThan(Integer value) {
            addCriterion("userAge <", value, "userage");
            return (Criteria) this;
        }

        public Criteria andUserageLessThanOrEqualTo(Integer value) {
            addCriterion("userAge <=", value, "userage");
            return (Criteria) this;
        }

        public Criteria andUserageIn(List<Integer> values) {
            addCriterion("userAge in", values, "userage");
            return (Criteria) this;
        }

        public Criteria andUserageNotIn(List<Integer> values) {
            addCriterion("userAge not in", values, "userage");
            return (Criteria) this;
        }

        public Criteria andUserageBetween(Integer value1, Integer value2) {
            addCriterion("userAge between", value1, value2, "userage");
            return (Criteria) this;
        }

        public Criteria andUserageNotBetween(Integer value1, Integer value2) {
            addCriterion("userAge not between", value1, value2, "userage");
            return (Criteria) this;
        }

        public Criteria andUsercardnumIsNull() {
            addCriterion("userCardNum is null");
            return (Criteria) this;
        }

        public Criteria andUsercardnumIsNotNull() {
            addCriterion("userCardNum is not null");
            return (Criteria) this;
        }

        public Criteria andUsercardnumEqualTo(String value) {
            addCriterion("userCardNum =", value, "usercardnum");
            return (Criteria) this;
        }

        public Criteria andUsercardnumNotEqualTo(String value) {
            addCriterion("userCardNum <>", value, "usercardnum");
            return (Criteria) this;
        }

        public Criteria andUsercardnumGreaterThan(String value) {
            addCriterion("userCardNum >", value, "usercardnum");
            return (Criteria) this;
        }

        public Criteria andUsercardnumGreaterThanOrEqualTo(String value) {
            addCriterion("userCardNum >=", value, "usercardnum");
            return (Criteria) this;
        }

        public Criteria andUsercardnumLessThan(String value) {
            addCriterion("userCardNum <", value, "usercardnum");
            return (Criteria) this;
        }

        public Criteria andUsercardnumLessThanOrEqualTo(String value) {
            addCriterion("userCardNum <=", value, "usercardnum");
            return (Criteria) this;
        }

        public Criteria andUsercardnumLike(String value) {
            addCriterion("userCardNum like", value, "usercardnum");
            return (Criteria) this;
        }

        public Criteria andUsercardnumNotLike(String value) {
            addCriterion("userCardNum not like", value, "usercardnum");
            return (Criteria) this;
        }

        public Criteria andUsercardnumIn(List<String> values) {
            addCriterion("userCardNum in", values, "usercardnum");
            return (Criteria) this;
        }

        public Criteria andUsercardnumNotIn(List<String> values) {
            addCriterion("userCardNum not in", values, "usercardnum");
            return (Criteria) this;
        }

        public Criteria andUsercardnumBetween(String value1, String value2) {
            addCriterion("userCardNum between", value1, value2, "usercardnum");
            return (Criteria) this;
        }

        public Criteria andUsercardnumNotBetween(String value1, String value2) {
            addCriterion("userCardNum not between", value1, value2, "usercardnum");
            return (Criteria) this;
        }

        public Criteria andUsercardphotoIsNull() {
            addCriterion("userCardPhoto is null");
            return (Criteria) this;
        }

        public Criteria andUsercardphotoIsNotNull() {
            addCriterion("userCardPhoto is not null");
            return (Criteria) this;
        }

        public Criteria andUsercardphotoEqualTo(String value) {
            addCriterion("userCardPhoto =", value, "usercardphoto");
            return (Criteria) this;
        }

        public Criteria andUsercardphotoNotEqualTo(String value) {
            addCriterion("userCardPhoto <>", value, "usercardphoto");
            return (Criteria) this;
        }

        public Criteria andUsercardphotoGreaterThan(String value) {
            addCriterion("userCardPhoto >", value, "usercardphoto");
            return (Criteria) this;
        }

        public Criteria andUsercardphotoGreaterThanOrEqualTo(String value) {
            addCriterion("userCardPhoto >=", value, "usercardphoto");
            return (Criteria) this;
        }

        public Criteria andUsercardphotoLessThan(String value) {
            addCriterion("userCardPhoto <", value, "usercardphoto");
            return (Criteria) this;
        }

        public Criteria andUsercardphotoLessThanOrEqualTo(String value) {
            addCriterion("userCardPhoto <=", value, "usercardphoto");
            return (Criteria) this;
        }

        public Criteria andUsercardphotoLike(String value) {
            addCriterion("userCardPhoto like", value, "usercardphoto");
            return (Criteria) this;
        }

        public Criteria andUsercardphotoNotLike(String value) {
            addCriterion("userCardPhoto not like", value, "usercardphoto");
            return (Criteria) this;
        }

        public Criteria andUsercardphotoIn(List<String> values) {
            addCriterion("userCardPhoto in", values, "usercardphoto");
            return (Criteria) this;
        }

        public Criteria andUsercardphotoNotIn(List<String> values) {
            addCriterion("userCardPhoto not in", values, "usercardphoto");
            return (Criteria) this;
        }

        public Criteria andUsercardphotoBetween(String value1, String value2) {
            addCriterion("userCardPhoto between", value1, value2, "usercardphoto");
            return (Criteria) this;
        }

        public Criteria andUsercardphotoNotBetween(String value1, String value2) {
            addCriterion("userCardPhoto not between", value1, value2, "usercardphoto");
            return (Criteria) this;
        }

        public Criteria andUserbirthdateIsNull() {
            addCriterion("userBirthDate is null");
            return (Criteria) this;
        }

        public Criteria andUserbirthdateIsNotNull() {
            addCriterion("userBirthDate is not null");
            return (Criteria) this;
        }

        public Criteria andUserbirthdateEqualTo(Date value) {
            addCriterionForJDBCDate("userBirthDate =", value, "userbirthdate");
            return (Criteria) this;
        }

        public Criteria andUserbirthdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("userBirthDate <>", value, "userbirthdate");
            return (Criteria) this;
        }

        public Criteria andUserbirthdateGreaterThan(Date value) {
            addCriterionForJDBCDate("userBirthDate >", value, "userbirthdate");
            return (Criteria) this;
        }

        public Criteria andUserbirthdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("userBirthDate >=", value, "userbirthdate");
            return (Criteria) this;
        }

        public Criteria andUserbirthdateLessThan(Date value) {
            addCriterionForJDBCDate("userBirthDate <", value, "userbirthdate");
            return (Criteria) this;
        }

        public Criteria andUserbirthdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("userBirthDate <=", value, "userbirthdate");
            return (Criteria) this;
        }

        public Criteria andUserbirthdateIn(List<Date> values) {
            addCriterionForJDBCDate("userBirthDate in", values, "userbirthdate");
            return (Criteria) this;
        }

        public Criteria andUserbirthdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("userBirthDate not in", values, "userbirthdate");
            return (Criteria) this;
        }

        public Criteria andUserbirthdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("userBirthDate between", value1, value2, "userbirthdate");
            return (Criteria) this;
        }

        public Criteria andUserbirthdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("userBirthDate not between", value1, value2, "userbirthdate");
            return (Criteria) this;
        }

        public Criteria andUseradrprovinceIsNull() {
            addCriterion("userAdrProvince is null");
            return (Criteria) this;
        }

        public Criteria andUseradrprovinceIsNotNull() {
            addCriterion("userAdrProvince is not null");
            return (Criteria) this;
        }

        public Criteria andUseradrprovinceEqualTo(String value) {
            addCriterion("userAdrProvince =", value, "useradrprovince");
            return (Criteria) this;
        }

        public Criteria andUseradrprovinceNotEqualTo(String value) {
            addCriterion("userAdrProvince <>", value, "useradrprovince");
            return (Criteria) this;
        }

        public Criteria andUseradrprovinceGreaterThan(String value) {
            addCriterion("userAdrProvince >", value, "useradrprovince");
            return (Criteria) this;
        }

        public Criteria andUseradrprovinceGreaterThanOrEqualTo(String value) {
            addCriterion("userAdrProvince >=", value, "useradrprovince");
            return (Criteria) this;
        }

        public Criteria andUseradrprovinceLessThan(String value) {
            addCriterion("userAdrProvince <", value, "useradrprovince");
            return (Criteria) this;
        }

        public Criteria andUseradrprovinceLessThanOrEqualTo(String value) {
            addCriterion("userAdrProvince <=", value, "useradrprovince");
            return (Criteria) this;
        }

        public Criteria andUseradrprovinceLike(String value) {
            addCriterion("userAdrProvince like", value, "useradrprovince");
            return (Criteria) this;
        }

        public Criteria andUseradrprovinceNotLike(String value) {
            addCriterion("userAdrProvince not like", value, "useradrprovince");
            return (Criteria) this;
        }

        public Criteria andUseradrprovinceIn(List<String> values) {
            addCriterion("userAdrProvince in", values, "useradrprovince");
            return (Criteria) this;
        }

        public Criteria andUseradrprovinceNotIn(List<String> values) {
            addCriterion("userAdrProvince not in", values, "useradrprovince");
            return (Criteria) this;
        }

        public Criteria andUseradrprovinceBetween(String value1, String value2) {
            addCriterion("userAdrProvince between", value1, value2, "useradrprovince");
            return (Criteria) this;
        }

        public Criteria andUseradrprovinceNotBetween(String value1, String value2) {
            addCriterion("userAdrProvince not between", value1, value2, "useradrprovince");
            return (Criteria) this;
        }

        public Criteria andUseradrcityIsNull() {
            addCriterion("userAdrCity is null");
            return (Criteria) this;
        }

        public Criteria andUseradrcityIsNotNull() {
            addCriterion("userAdrCity is not null");
            return (Criteria) this;
        }

        public Criteria andUseradrcityEqualTo(String value) {
            addCriterion("userAdrCity =", value, "useradrcity");
            return (Criteria) this;
        }

        public Criteria andUseradrcityNotEqualTo(String value) {
            addCriterion("userAdrCity <>", value, "useradrcity");
            return (Criteria) this;
        }

        public Criteria andUseradrcityGreaterThan(String value) {
            addCriterion("userAdrCity >", value, "useradrcity");
            return (Criteria) this;
        }

        public Criteria andUseradrcityGreaterThanOrEqualTo(String value) {
            addCriterion("userAdrCity >=", value, "useradrcity");
            return (Criteria) this;
        }

        public Criteria andUseradrcityLessThan(String value) {
            addCriterion("userAdrCity <", value, "useradrcity");
            return (Criteria) this;
        }

        public Criteria andUseradrcityLessThanOrEqualTo(String value) {
            addCriterion("userAdrCity <=", value, "useradrcity");
            return (Criteria) this;
        }

        public Criteria andUseradrcityLike(String value) {
            addCriterion("userAdrCity like", value, "useradrcity");
            return (Criteria) this;
        }

        public Criteria andUseradrcityNotLike(String value) {
            addCriterion("userAdrCity not like", value, "useradrcity");
            return (Criteria) this;
        }

        public Criteria andUseradrcityIn(List<String> values) {
            addCriterion("userAdrCity in", values, "useradrcity");
            return (Criteria) this;
        }

        public Criteria andUseradrcityNotIn(List<String> values) {
            addCriterion("userAdrCity not in", values, "useradrcity");
            return (Criteria) this;
        }

        public Criteria andUseradrcityBetween(String value1, String value2) {
            addCriterion("userAdrCity between", value1, value2, "useradrcity");
            return (Criteria) this;
        }

        public Criteria andUseradrcityNotBetween(String value1, String value2) {
            addCriterion("userAdrCity not between", value1, value2, "useradrcity");
            return (Criteria) this;
        }

        public Criteria andUseradrareaIsNull() {
            addCriterion("userAdrArea is null");
            return (Criteria) this;
        }

        public Criteria andUseradrareaIsNotNull() {
            addCriterion("userAdrArea is not null");
            return (Criteria) this;
        }

        public Criteria andUseradrareaEqualTo(String value) {
            addCriterion("userAdrArea =", value, "useradrarea");
            return (Criteria) this;
        }

        public Criteria andUseradrareaNotEqualTo(String value) {
            addCriterion("userAdrArea <>", value, "useradrarea");
            return (Criteria) this;
        }

        public Criteria andUseradrareaGreaterThan(String value) {
            addCriterion("userAdrArea >", value, "useradrarea");
            return (Criteria) this;
        }

        public Criteria andUseradrareaGreaterThanOrEqualTo(String value) {
            addCriterion("userAdrArea >=", value, "useradrarea");
            return (Criteria) this;
        }

        public Criteria andUseradrareaLessThan(String value) {
            addCriterion("userAdrArea <", value, "useradrarea");
            return (Criteria) this;
        }

        public Criteria andUseradrareaLessThanOrEqualTo(String value) {
            addCriterion("userAdrArea <=", value, "useradrarea");
            return (Criteria) this;
        }

        public Criteria andUseradrareaLike(String value) {
            addCriterion("userAdrArea like", value, "useradrarea");
            return (Criteria) this;
        }

        public Criteria andUseradrareaNotLike(String value) {
            addCriterion("userAdrArea not like", value, "useradrarea");
            return (Criteria) this;
        }

        public Criteria andUseradrareaIn(List<String> values) {
            addCriterion("userAdrArea in", values, "useradrarea");
            return (Criteria) this;
        }

        public Criteria andUseradrareaNotIn(List<String> values) {
            addCriterion("userAdrArea not in", values, "useradrarea");
            return (Criteria) this;
        }

        public Criteria andUseradrareaBetween(String value1, String value2) {
            addCriterion("userAdrArea between", value1, value2, "useradrarea");
            return (Criteria) this;
        }

        public Criteria andUseradrareaNotBetween(String value1, String value2) {
            addCriterion("userAdrArea not between", value1, value2, "useradrarea");
            return (Criteria) this;
        }

        public Criteria andUseradrotherIsNull() {
            addCriterion("userAdrOther is null");
            return (Criteria) this;
        }

        public Criteria andUseradrotherIsNotNull() {
            addCriterion("userAdrOther is not null");
            return (Criteria) this;
        }

        public Criteria andUseradrotherEqualTo(String value) {
            addCriterion("userAdrOther =", value, "useradrother");
            return (Criteria) this;
        }

        public Criteria andUseradrotherNotEqualTo(String value) {
            addCriterion("userAdrOther <>", value, "useradrother");
            return (Criteria) this;
        }

        public Criteria andUseradrotherGreaterThan(String value) {
            addCriterion("userAdrOther >", value, "useradrother");
            return (Criteria) this;
        }

        public Criteria andUseradrotherGreaterThanOrEqualTo(String value) {
            addCriterion("userAdrOther >=", value, "useradrother");
            return (Criteria) this;
        }

        public Criteria andUseradrotherLessThan(String value) {
            addCriterion("userAdrOther <", value, "useradrother");
            return (Criteria) this;
        }

        public Criteria andUseradrotherLessThanOrEqualTo(String value) {
            addCriterion("userAdrOther <=", value, "useradrother");
            return (Criteria) this;
        }

        public Criteria andUseradrotherLike(String value) {
            addCriterion("userAdrOther like", value, "useradrother");
            return (Criteria) this;
        }

        public Criteria andUseradrotherNotLike(String value) {
            addCriterion("userAdrOther not like", value, "useradrother");
            return (Criteria) this;
        }

        public Criteria andUseradrotherIn(List<String> values) {
            addCriterion("userAdrOther in", values, "useradrother");
            return (Criteria) this;
        }

        public Criteria andUseradrotherNotIn(List<String> values) {
            addCriterion("userAdrOther not in", values, "useradrother");
            return (Criteria) this;
        }

        public Criteria andUseradrotherBetween(String value1, String value2) {
            addCriterion("userAdrOther between", value1, value2, "useradrother");
            return (Criteria) this;
        }

        public Criteria andUseradrotherNotBetween(String value1, String value2) {
            addCriterion("userAdrOther not between", value1, value2, "useradrother");
            return (Criteria) this;
        }

        public Criteria andUsermarryIsNull() {
            addCriterion("userMarry is null");
            return (Criteria) this;
        }

        public Criteria andUsermarryIsNotNull() {
            addCriterion("userMarry is not null");
            return (Criteria) this;
        }

        public Criteria andUsermarryEqualTo(Boolean value) {
            addCriterion("userMarry =", value, "usermarry");
            return (Criteria) this;
        }

        public Criteria andUsermarryNotEqualTo(Boolean value) {
            addCriterion("userMarry <>", value, "usermarry");
            return (Criteria) this;
        }

        public Criteria andUsermarryGreaterThan(Boolean value) {
            addCriterion("userMarry >", value, "usermarry");
            return (Criteria) this;
        }

        public Criteria andUsermarryGreaterThanOrEqualTo(Boolean value) {
            addCriterion("userMarry >=", value, "usermarry");
            return (Criteria) this;
        }

        public Criteria andUsermarryLessThan(Boolean value) {
            addCriterion("userMarry <", value, "usermarry");
            return (Criteria) this;
        }

        public Criteria andUsermarryLessThanOrEqualTo(Boolean value) {
            addCriterion("userMarry <=", value, "usermarry");
            return (Criteria) this;
        }

        public Criteria andUsermarryIn(List<Boolean> values) {
            addCriterion("userMarry in", values, "usermarry");
            return (Criteria) this;
        }

        public Criteria andUsermarryNotIn(List<Boolean> values) {
            addCriterion("userMarry not in", values, "usermarry");
            return (Criteria) this;
        }

        public Criteria andUsermarryBetween(Boolean value1, Boolean value2) {
            addCriterion("userMarry between", value1, value2, "usermarry");
            return (Criteria) this;
        }

        public Criteria andUsermarryNotBetween(Boolean value1, Boolean value2) {
            addCriterion("userMarry not between", value1, value2, "usermarry");
            return (Criteria) this;
        }

        public Criteria andUsernationIsNull() {
            addCriterion("userNation is null");
            return (Criteria) this;
        }

        public Criteria andUsernationIsNotNull() {
            addCriterion("userNation is not null");
            return (Criteria) this;
        }

        public Criteria andUsernationEqualTo(String value) {
            addCriterion("userNation =", value, "usernation");
            return (Criteria) this;
        }

        public Criteria andUsernationNotEqualTo(String value) {
            addCriterion("userNation <>", value, "usernation");
            return (Criteria) this;
        }

        public Criteria andUsernationGreaterThan(String value) {
            addCriterion("userNation >", value, "usernation");
            return (Criteria) this;
        }

        public Criteria andUsernationGreaterThanOrEqualTo(String value) {
            addCriterion("userNation >=", value, "usernation");
            return (Criteria) this;
        }

        public Criteria andUsernationLessThan(String value) {
            addCriterion("userNation <", value, "usernation");
            return (Criteria) this;
        }

        public Criteria andUsernationLessThanOrEqualTo(String value) {
            addCriterion("userNation <=", value, "usernation");
            return (Criteria) this;
        }

        public Criteria andUsernationLike(String value) {
            addCriterion("userNation like", value, "usernation");
            return (Criteria) this;
        }

        public Criteria andUsernationNotLike(String value) {
            addCriterion("userNation not like", value, "usernation");
            return (Criteria) this;
        }

        public Criteria andUsernationIn(List<String> values) {
            addCriterion("userNation in", values, "usernation");
            return (Criteria) this;
        }

        public Criteria andUsernationNotIn(List<String> values) {
            addCriterion("userNation not in", values, "usernation");
            return (Criteria) this;
        }

        public Criteria andUsernationBetween(String value1, String value2) {
            addCriterion("userNation between", value1, value2, "usernation");
            return (Criteria) this;
        }

        public Criteria andUsernationNotBetween(String value1, String value2) {
            addCriterion("userNation not between", value1, value2, "usernation");
            return (Criteria) this;
        }

        public Criteria andUsercareerIsNull() {
            addCriterion("userCareer is null");
            return (Criteria) this;
        }

        public Criteria andUsercareerIsNotNull() {
            addCriterion("userCareer is not null");
            return (Criteria) this;
        }

        public Criteria andUsercareerEqualTo(String value) {
            addCriterion("userCareer =", value, "usercareer");
            return (Criteria) this;
        }

        public Criteria andUsercareerNotEqualTo(String value) {
            addCriterion("userCareer <>", value, "usercareer");
            return (Criteria) this;
        }

        public Criteria andUsercareerGreaterThan(String value) {
            addCriterion("userCareer >", value, "usercareer");
            return (Criteria) this;
        }

        public Criteria andUsercareerGreaterThanOrEqualTo(String value) {
            addCriterion("userCareer >=", value, "usercareer");
            return (Criteria) this;
        }

        public Criteria andUsercareerLessThan(String value) {
            addCriterion("userCareer <", value, "usercareer");
            return (Criteria) this;
        }

        public Criteria andUsercareerLessThanOrEqualTo(String value) {
            addCriterion("userCareer <=", value, "usercareer");
            return (Criteria) this;
        }

        public Criteria andUsercareerLike(String value) {
            addCriterion("userCareer like", value, "usercareer");
            return (Criteria) this;
        }

        public Criteria andUsercareerNotLike(String value) {
            addCriterion("userCareer not like", value, "usercareer");
            return (Criteria) this;
        }

        public Criteria andUsercareerIn(List<String> values) {
            addCriterion("userCareer in", values, "usercareer");
            return (Criteria) this;
        }

        public Criteria andUsercareerNotIn(List<String> values) {
            addCriterion("userCareer not in", values, "usercareer");
            return (Criteria) this;
        }

        public Criteria andUsercareerBetween(String value1, String value2) {
            addCriterion("userCareer between", value1, value2, "usercareer");
            return (Criteria) this;
        }

        public Criteria andUsercareerNotBetween(String value1, String value2) {
            addCriterion("userCareer not between", value1, value2, "usercareer");
            return (Criteria) this;
        }

        public Criteria andUserallergyIsNull() {
            addCriterion("userAllergy is null");
            return (Criteria) this;
        }

        public Criteria andUserallergyIsNotNull() {
            addCriterion("userAllergy is not null");
            return (Criteria) this;
        }

        public Criteria andUserallergyEqualTo(String value) {
            addCriterion("userAllergy =", value, "userallergy");
            return (Criteria) this;
        }

        public Criteria andUserallergyNotEqualTo(String value) {
            addCriterion("userAllergy <>", value, "userallergy");
            return (Criteria) this;
        }

        public Criteria andUserallergyGreaterThan(String value) {
            addCriterion("userAllergy >", value, "userallergy");
            return (Criteria) this;
        }

        public Criteria andUserallergyGreaterThanOrEqualTo(String value) {
            addCriterion("userAllergy >=", value, "userallergy");
            return (Criteria) this;
        }

        public Criteria andUserallergyLessThan(String value) {
            addCriterion("userAllergy <", value, "userallergy");
            return (Criteria) this;
        }

        public Criteria andUserallergyLessThanOrEqualTo(String value) {
            addCriterion("userAllergy <=", value, "userallergy");
            return (Criteria) this;
        }

        public Criteria andUserallergyLike(String value) {
            addCriterion("userAllergy like", value, "userallergy");
            return (Criteria) this;
        }

        public Criteria andUserallergyNotLike(String value) {
            addCriterion("userAllergy not like", value, "userallergy");
            return (Criteria) this;
        }

        public Criteria andUserallergyIn(List<String> values) {
            addCriterion("userAllergy in", values, "userallergy");
            return (Criteria) this;
        }

        public Criteria andUserallergyNotIn(List<String> values) {
            addCriterion("userAllergy not in", values, "userallergy");
            return (Criteria) this;
        }

        public Criteria andUserallergyBetween(String value1, String value2) {
            addCriterion("userAllergy between", value1, value2, "userallergy");
            return (Criteria) this;
        }

        public Criteria andUserallergyNotBetween(String value1, String value2) {
            addCriterion("userAllergy not between", value1, value2, "userallergy");
            return (Criteria) this;
        }

        public Criteria andUserdiseaseIsNull() {
            addCriterion("userDisease is null");
            return (Criteria) this;
        }

        public Criteria andUserdiseaseIsNotNull() {
            addCriterion("userDisease is not null");
            return (Criteria) this;
        }

        public Criteria andUserdiseaseEqualTo(String value) {
            addCriterion("userDisease =", value, "userdisease");
            return (Criteria) this;
        }

        public Criteria andUserdiseaseNotEqualTo(String value) {
            addCriterion("userDisease <>", value, "userdisease");
            return (Criteria) this;
        }

        public Criteria andUserdiseaseGreaterThan(String value) {
            addCriterion("userDisease >", value, "userdisease");
            return (Criteria) this;
        }

        public Criteria andUserdiseaseGreaterThanOrEqualTo(String value) {
            addCriterion("userDisease >=", value, "userdisease");
            return (Criteria) this;
        }

        public Criteria andUserdiseaseLessThan(String value) {
            addCriterion("userDisease <", value, "userdisease");
            return (Criteria) this;
        }

        public Criteria andUserdiseaseLessThanOrEqualTo(String value) {
            addCriterion("userDisease <=", value, "userdisease");
            return (Criteria) this;
        }

        public Criteria andUserdiseaseLike(String value) {
            addCriterion("userDisease like", value, "userdisease");
            return (Criteria) this;
        }

        public Criteria andUserdiseaseNotLike(String value) {
            addCriterion("userDisease not like", value, "userdisease");
            return (Criteria) this;
        }

        public Criteria andUserdiseaseIn(List<String> values) {
            addCriterion("userDisease in", values, "userdisease");
            return (Criteria) this;
        }

        public Criteria andUserdiseaseNotIn(List<String> values) {
            addCriterion("userDisease not in", values, "userdisease");
            return (Criteria) this;
        }

        public Criteria andUserdiseaseBetween(String value1, String value2) {
            addCriterion("userDisease between", value1, value2, "userdisease");
            return (Criteria) this;
        }

        public Criteria andUserdiseaseNotBetween(String value1, String value2) {
            addCriterion("userDisease not between", value1, value2, "userdisease");
            return (Criteria) this;
        }

        public Criteria andUseroperateIsNull() {
            addCriterion("userOperate is null");
            return (Criteria) this;
        }

        public Criteria andUseroperateIsNotNull() {
            addCriterion("userOperate is not null");
            return (Criteria) this;
        }

        public Criteria andUseroperateEqualTo(String value) {
            addCriterion("userOperate =", value, "useroperate");
            return (Criteria) this;
        }

        public Criteria andUseroperateNotEqualTo(String value) {
            addCriterion("userOperate <>", value, "useroperate");
            return (Criteria) this;
        }

        public Criteria andUseroperateGreaterThan(String value) {
            addCriterion("userOperate >", value, "useroperate");
            return (Criteria) this;
        }

        public Criteria andUseroperateGreaterThanOrEqualTo(String value) {
            addCriterion("userOperate >=", value, "useroperate");
            return (Criteria) this;
        }

        public Criteria andUseroperateLessThan(String value) {
            addCriterion("userOperate <", value, "useroperate");
            return (Criteria) this;
        }

        public Criteria andUseroperateLessThanOrEqualTo(String value) {
            addCriterion("userOperate <=", value, "useroperate");
            return (Criteria) this;
        }

        public Criteria andUseroperateLike(String value) {
            addCriterion("userOperate like", value, "useroperate");
            return (Criteria) this;
        }

        public Criteria andUseroperateNotLike(String value) {
            addCriterion("userOperate not like", value, "useroperate");
            return (Criteria) this;
        }

        public Criteria andUseroperateIn(List<String> values) {
            addCriterion("userOperate in", values, "useroperate");
            return (Criteria) this;
        }

        public Criteria andUseroperateNotIn(List<String> values) {
            addCriterion("userOperate not in", values, "useroperate");
            return (Criteria) this;
        }

        public Criteria andUseroperateBetween(String value1, String value2) {
            addCriterion("userOperate between", value1, value2, "useroperate");
            return (Criteria) this;
        }

        public Criteria andUseroperateNotBetween(String value1, String value2) {
            addCriterion("userOperate not between", value1, value2, "useroperate");
            return (Criteria) this;
        }

        public Criteria andUserdegreeIsNull() {
            addCriterion("userDegree is null");
            return (Criteria) this;
        }

        public Criteria andUserdegreeIsNotNull() {
            addCriterion("userDegree is not null");
            return (Criteria) this;
        }

        public Criteria andUserdegreeEqualTo(String value) {
            addCriterion("userDegree =", value, "userdegree");
            return (Criteria) this;
        }

        public Criteria andUserdegreeNotEqualTo(String value) {
            addCriterion("userDegree <>", value, "userdegree");
            return (Criteria) this;
        }

        public Criteria andUserdegreeGreaterThan(String value) {
            addCriterion("userDegree >", value, "userdegree");
            return (Criteria) this;
        }

        public Criteria andUserdegreeGreaterThanOrEqualTo(String value) {
            addCriterion("userDegree >=", value, "userdegree");
            return (Criteria) this;
        }

        public Criteria andUserdegreeLessThan(String value) {
            addCriterion("userDegree <", value, "userdegree");
            return (Criteria) this;
        }

        public Criteria andUserdegreeLessThanOrEqualTo(String value) {
            addCriterion("userDegree <=", value, "userdegree");
            return (Criteria) this;
        }

        public Criteria andUserdegreeLike(String value) {
            addCriterion("userDegree like", value, "userdegree");
            return (Criteria) this;
        }

        public Criteria andUserdegreeNotLike(String value) {
            addCriterion("userDegree not like", value, "userdegree");
            return (Criteria) this;
        }

        public Criteria andUserdegreeIn(List<String> values) {
            addCriterion("userDegree in", values, "userdegree");
            return (Criteria) this;
        }

        public Criteria andUserdegreeNotIn(List<String> values) {
            addCriterion("userDegree not in", values, "userdegree");
            return (Criteria) this;
        }

        public Criteria andUserdegreeBetween(String value1, String value2) {
            addCriterion("userDegree between", value1, value2, "userdegree");
            return (Criteria) this;
        }

        public Criteria andUserdegreeNotBetween(String value1, String value2) {
            addCriterion("userDegree not between", value1, value2, "userdegree");
            return (Criteria) this;
        }

        public Criteria andUserphoneIsNull() {
            addCriterion("userPhone is null");
            return (Criteria) this;
        }

        public Criteria andUserphoneIsNotNull() {
            addCriterion("userPhone is not null");
            return (Criteria) this;
        }

        public Criteria andUserphoneEqualTo(String value) {
            addCriterion("userPhone =", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneNotEqualTo(String value) {
            addCriterion("userPhone <>", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneGreaterThan(String value) {
            addCriterion("userPhone >", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneGreaterThanOrEqualTo(String value) {
            addCriterion("userPhone >=", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneLessThan(String value) {
            addCriterion("userPhone <", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneLessThanOrEqualTo(String value) {
            addCriterion("userPhone <=", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneLike(String value) {
            addCriterion("userPhone like", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneNotLike(String value) {
            addCriterion("userPhone not like", value, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneIn(List<String> values) {
            addCriterion("userPhone in", values, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneNotIn(List<String> values) {
            addCriterion("userPhone not in", values, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneBetween(String value1, String value2) {
            addCriterion("userPhone between", value1, value2, "userphone");
            return (Criteria) this;
        }

        public Criteria andUserphoneNotBetween(String value1, String value2) {
            addCriterion("userPhone not between", value1, value2, "userphone");
            return (Criteria) this;
        }

        public Criteria andUseremailIsNull() {
            addCriterion("userEmail is null");
            return (Criteria) this;
        }

        public Criteria andUseremailIsNotNull() {
            addCriterion("userEmail is not null");
            return (Criteria) this;
        }

        public Criteria andUseremailEqualTo(String value) {
            addCriterion("userEmail =", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailNotEqualTo(String value) {
            addCriterion("userEmail <>", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailGreaterThan(String value) {
            addCriterion("userEmail >", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailGreaterThanOrEqualTo(String value) {
            addCriterion("userEmail >=", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailLessThan(String value) {
            addCriterion("userEmail <", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailLessThanOrEqualTo(String value) {
            addCriterion("userEmail <=", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailLike(String value) {
            addCriterion("userEmail like", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailNotLike(String value) {
            addCriterion("userEmail not like", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailIn(List<String> values) {
            addCriterion("userEmail in", values, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailNotIn(List<String> values) {
            addCriterion("userEmail not in", values, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailBetween(String value1, String value2) {
            addCriterion("userEmail between", value1, value2, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailNotBetween(String value1, String value2) {
            addCriterion("userEmail not between", value1, value2, "useremail");
            return (Criteria) this;
        }

        public Criteria andUsercollectdocIsNull() {
            addCriterion("userCollectDoc is null");
            return (Criteria) this;
        }

        public Criteria andUsercollectdocIsNotNull() {
            addCriterion("userCollectDoc is not null");
            return (Criteria) this;
        }

        public Criteria andUsercollectdocEqualTo(String value) {
            addCriterion("userCollectDoc =", value, "usercollectdoc");
            return (Criteria) this;
        }

        public Criteria andUsercollectdocNotEqualTo(String value) {
            addCriterion("userCollectDoc <>", value, "usercollectdoc");
            return (Criteria) this;
        }

        public Criteria andUsercollectdocGreaterThan(String value) {
            addCriterion("userCollectDoc >", value, "usercollectdoc");
            return (Criteria) this;
        }

        public Criteria andUsercollectdocGreaterThanOrEqualTo(String value) {
            addCriterion("userCollectDoc >=", value, "usercollectdoc");
            return (Criteria) this;
        }

        public Criteria andUsercollectdocLessThan(String value) {
            addCriterion("userCollectDoc <", value, "usercollectdoc");
            return (Criteria) this;
        }

        public Criteria andUsercollectdocLessThanOrEqualTo(String value) {
            addCriterion("userCollectDoc <=", value, "usercollectdoc");
            return (Criteria) this;
        }

        public Criteria andUsercollectdocLike(String value) {
            addCriterion("userCollectDoc like", value, "usercollectdoc");
            return (Criteria) this;
        }

        public Criteria andUsercollectdocNotLike(String value) {
            addCriterion("userCollectDoc not like", value, "usercollectdoc");
            return (Criteria) this;
        }

        public Criteria andUsercollectdocIn(List<String> values) {
            addCriterion("userCollectDoc in", values, "usercollectdoc");
            return (Criteria) this;
        }

        public Criteria andUsercollectdocNotIn(List<String> values) {
            addCriterion("userCollectDoc not in", values, "usercollectdoc");
            return (Criteria) this;
        }

        public Criteria andUsercollectdocBetween(String value1, String value2) {
            addCriterion("userCollectDoc between", value1, value2, "usercollectdoc");
            return (Criteria) this;
        }

        public Criteria andUsercollectdocNotBetween(String value1, String value2) {
            addCriterion("userCollectDoc not between", value1, value2, "usercollectdoc");
            return (Criteria) this;
        }

        public Criteria andUserrelationIsNull() {
            addCriterion("userRelation is null");
            return (Criteria) this;
        }

        public Criteria andUserrelationIsNotNull() {
            addCriterion("userRelation is not null");
            return (Criteria) this;
        }

        public Criteria andUserrelationEqualTo(String value) {
            addCriterion("userRelation =", value, "userrelation");
            return (Criteria) this;
        }

        public Criteria andUserrelationNotEqualTo(String value) {
            addCriterion("userRelation <>", value, "userrelation");
            return (Criteria) this;
        }

        public Criteria andUserrelationGreaterThan(String value) {
            addCriterion("userRelation >", value, "userrelation");
            return (Criteria) this;
        }

        public Criteria andUserrelationGreaterThanOrEqualTo(String value) {
            addCriterion("userRelation >=", value, "userrelation");
            return (Criteria) this;
        }

        public Criteria andUserrelationLessThan(String value) {
            addCriterion("userRelation <", value, "userrelation");
            return (Criteria) this;
        }

        public Criteria andUserrelationLessThanOrEqualTo(String value) {
            addCriterion("userRelation <=", value, "userrelation");
            return (Criteria) this;
        }

        public Criteria andUserrelationLike(String value) {
            addCriterion("userRelation like", value, "userrelation");
            return (Criteria) this;
        }

        public Criteria andUserrelationNotLike(String value) {
            addCriterion("userRelation not like", value, "userrelation");
            return (Criteria) this;
        }

        public Criteria andUserrelationIn(List<String> values) {
            addCriterion("userRelation in", values, "userrelation");
            return (Criteria) this;
        }

        public Criteria andUserrelationNotIn(List<String> values) {
            addCriterion("userRelation not in", values, "userrelation");
            return (Criteria) this;
        }

        public Criteria andUserrelationBetween(String value1, String value2) {
            addCriterion("userRelation between", value1, value2, "userrelation");
            return (Criteria) this;
        }

        public Criteria andUserrelationNotBetween(String value1, String value2) {
            addCriterion("userRelation not between", value1, value2, "userrelation");
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

        public Criteria andUseralipayaccountIsNull() {
            addCriterion("userAlipayAccount is null");
            return (Criteria) this;
        }

        public Criteria andUseralipayaccountIsNotNull() {
            addCriterion("userAlipayAccount is not null");
            return (Criteria) this;
        }

        public Criteria andUseralipayaccountEqualTo(String value) {
            addCriterion("userAlipayAccount =", value, "useralipayaccount");
            return (Criteria) this;
        }

        public Criteria andUseralipayaccountNotEqualTo(String value) {
            addCriterion("userAlipayAccount <>", value, "useralipayaccount");
            return (Criteria) this;
        }

        public Criteria andUseralipayaccountGreaterThan(String value) {
            addCriterion("userAlipayAccount >", value, "useralipayaccount");
            return (Criteria) this;
        }

        public Criteria andUseralipayaccountGreaterThanOrEqualTo(String value) {
            addCriterion("userAlipayAccount >=", value, "useralipayaccount");
            return (Criteria) this;
        }

        public Criteria andUseralipayaccountLessThan(String value) {
            addCriterion("userAlipayAccount <", value, "useralipayaccount");
            return (Criteria) this;
        }

        public Criteria andUseralipayaccountLessThanOrEqualTo(String value) {
            addCriterion("userAlipayAccount <=", value, "useralipayaccount");
            return (Criteria) this;
        }

        public Criteria andUseralipayaccountLike(String value) {
            addCriterion("userAlipayAccount like", value, "useralipayaccount");
            return (Criteria) this;
        }

        public Criteria andUseralipayaccountNotLike(String value) {
            addCriterion("userAlipayAccount not like", value, "useralipayaccount");
            return (Criteria) this;
        }

        public Criteria andUseralipayaccountIn(List<String> values) {
            addCriterion("userAlipayAccount in", values, "useralipayaccount");
            return (Criteria) this;
        }

        public Criteria andUseralipayaccountNotIn(List<String> values) {
            addCriterion("userAlipayAccount not in", values, "useralipayaccount");
            return (Criteria) this;
        }

        public Criteria andUseralipayaccountBetween(String value1, String value2) {
            addCriterion("userAlipayAccount between", value1, value2, "useralipayaccount");
            return (Criteria) this;
        }

        public Criteria andUseralipayaccountNotBetween(String value1, String value2) {
            addCriterion("userAlipayAccount not between", value1, value2, "useralipayaccount");
            return (Criteria) this;
        }

        public Criteria andUserpursebalanceIsNull() {
            addCriterion("userPurseBalance is null");
            return (Criteria) this;
        }

        public Criteria andUserpursebalanceIsNotNull() {
            addCriterion("userPurseBalance is not null");
            return (Criteria) this;
        }

        public Criteria andUserpursebalanceEqualTo(BigDecimal value) {
            addCriterion("userPurseBalance =", value, "userpursebalance");
            return (Criteria) this;
        }

        public Criteria andUserpursebalanceNotEqualTo(BigDecimal value) {
            addCriterion("userPurseBalance <>", value, "userpursebalance");
            return (Criteria) this;
        }

        public Criteria andUserpursebalanceGreaterThan(BigDecimal value) {
            addCriterion("userPurseBalance >", value, "userpursebalance");
            return (Criteria) this;
        }

        public Criteria andUserpursebalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("userPurseBalance >=", value, "userpursebalance");
            return (Criteria) this;
        }

        public Criteria andUserpursebalanceLessThan(BigDecimal value) {
            addCriterion("userPurseBalance <", value, "userpursebalance");
            return (Criteria) this;
        }

        public Criteria andUserpursebalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("userPurseBalance <=", value, "userpursebalance");
            return (Criteria) this;
        }

        public Criteria andUserpursebalanceIn(List<BigDecimal> values) {
            addCriterion("userPurseBalance in", values, "userpursebalance");
            return (Criteria) this;
        }

        public Criteria andUserpursebalanceNotIn(List<BigDecimal> values) {
            addCriterion("userPurseBalance not in", values, "userpursebalance");
            return (Criteria) this;
        }

        public Criteria andUserpursebalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("userPurseBalance between", value1, value2, "userpursebalance");
            return (Criteria) this;
        }

        public Criteria andUserpursebalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("userPurseBalance not between", value1, value2, "userpursebalance");
            return (Criteria) this;
        }

        public Criteria andUseralipaynameIsNull() {
            addCriterion("userAlipayName is null");
            return (Criteria) this;
        }

        public Criteria andUseralipaynameIsNotNull() {
            addCriterion("userAlipayName is not null");
            return (Criteria) this;
        }

        public Criteria andUseralipaynameEqualTo(String value) {
            addCriterion("userAlipayName =", value, "useralipayname");
            return (Criteria) this;
        }

        public Criteria andUseralipaynameNotEqualTo(String value) {
            addCriterion("userAlipayName <>", value, "useralipayname");
            return (Criteria) this;
        }

        public Criteria andUseralipaynameGreaterThan(String value) {
            addCriterion("userAlipayName >", value, "useralipayname");
            return (Criteria) this;
        }

        public Criteria andUseralipaynameGreaterThanOrEqualTo(String value) {
            addCriterion("userAlipayName >=", value, "useralipayname");
            return (Criteria) this;
        }

        public Criteria andUseralipaynameLessThan(String value) {
            addCriterion("userAlipayName <", value, "useralipayname");
            return (Criteria) this;
        }

        public Criteria andUseralipaynameLessThanOrEqualTo(String value) {
            addCriterion("userAlipayName <=", value, "useralipayname");
            return (Criteria) this;
        }

        public Criteria andUseralipaynameLike(String value) {
            addCriterion("userAlipayName like", value, "useralipayname");
            return (Criteria) this;
        }

        public Criteria andUseralipaynameNotLike(String value) {
            addCriterion("userAlipayName not like", value, "useralipayname");
            return (Criteria) this;
        }

        public Criteria andUseralipaynameIn(List<String> values) {
            addCriterion("userAlipayName in", values, "useralipayname");
            return (Criteria) this;
        }

        public Criteria andUseralipaynameNotIn(List<String> values) {
            addCriterion("userAlipayName not in", values, "useralipayname");
            return (Criteria) this;
        }

        public Criteria andUseralipaynameBetween(String value1, String value2) {
            addCriterion("userAlipayName between", value1, value2, "useralipayname");
            return (Criteria) this;
        }

        public Criteria andUseralipaynameNotBetween(String value1, String value2) {
            addCriterion("userAlipayName not between", value1, value2, "useralipayname");
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