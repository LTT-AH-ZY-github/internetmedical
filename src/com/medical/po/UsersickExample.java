package com.medical.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsersickExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UsersickExample() {
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

        public Criteria andUsersickidIsNull() {
            addCriterion("userSickId is null");
            return (Criteria) this;
        }

        public Criteria andUsersickidIsNotNull() {
            addCriterion("userSickId is not null");
            return (Criteria) this;
        }

        public Criteria andUsersickidEqualTo(Integer value) {
            addCriterion("userSickId =", value, "usersickid");
            return (Criteria) this;
        }

        public Criteria andUsersickidNotEqualTo(Integer value) {
            addCriterion("userSickId <>", value, "usersickid");
            return (Criteria) this;
        }

        public Criteria andUsersickidGreaterThan(Integer value) {
            addCriterion("userSickId >", value, "usersickid");
            return (Criteria) this;
        }

        public Criteria andUsersickidGreaterThanOrEqualTo(Integer value) {
            addCriterion("userSickId >=", value, "usersickid");
            return (Criteria) this;
        }

        public Criteria andUsersickidLessThan(Integer value) {
            addCriterion("userSickId <", value, "usersickid");
            return (Criteria) this;
        }

        public Criteria andUsersickidLessThanOrEqualTo(Integer value) {
            addCriterion("userSickId <=", value, "usersickid");
            return (Criteria) this;
        }

        public Criteria andUsersickidIn(List<Integer> values) {
            addCriterion("userSickId in", values, "usersickid");
            return (Criteria) this;
        }

        public Criteria andUsersickidNotIn(List<Integer> values) {
            addCriterion("userSickId not in", values, "usersickid");
            return (Criteria) this;
        }

        public Criteria andUsersickidBetween(Integer value1, Integer value2) {
            addCriterion("userSickId between", value1, value2, "usersickid");
            return (Criteria) this;
        }

        public Criteria andUsersickidNotBetween(Integer value1, Integer value2) {
            addCriterion("userSickId not between", value1, value2, "usersickid");
            return (Criteria) this;
        }

        public Criteria andUsersickdescIsNull() {
            addCriterion("userSickDesc is null");
            return (Criteria) this;
        }

        public Criteria andUsersickdescIsNotNull() {
            addCriterion("userSickDesc is not null");
            return (Criteria) this;
        }

        public Criteria andUsersickdescEqualTo(String value) {
            addCriterion("userSickDesc =", value, "usersickdesc");
            return (Criteria) this;
        }

        public Criteria andUsersickdescNotEqualTo(String value) {
            addCriterion("userSickDesc <>", value, "usersickdesc");
            return (Criteria) this;
        }

        public Criteria andUsersickdescGreaterThan(String value) {
            addCriterion("userSickDesc >", value, "usersickdesc");
            return (Criteria) this;
        }

        public Criteria andUsersickdescGreaterThanOrEqualTo(String value) {
            addCriterion("userSickDesc >=", value, "usersickdesc");
            return (Criteria) this;
        }

        public Criteria andUsersickdescLessThan(String value) {
            addCriterion("userSickDesc <", value, "usersickdesc");
            return (Criteria) this;
        }

        public Criteria andUsersickdescLessThanOrEqualTo(String value) {
            addCriterion("userSickDesc <=", value, "usersickdesc");
            return (Criteria) this;
        }

        public Criteria andUsersickdescLike(String value) {
            addCriterion("userSickDesc like", value, "usersickdesc");
            return (Criteria) this;
        }

        public Criteria andUsersickdescNotLike(String value) {
            addCriterion("userSickDesc not like", value, "usersickdesc");
            return (Criteria) this;
        }

        public Criteria andUsersickdescIn(List<String> values) {
            addCriterion("userSickDesc in", values, "usersickdesc");
            return (Criteria) this;
        }

        public Criteria andUsersickdescNotIn(List<String> values) {
            addCriterion("userSickDesc not in", values, "usersickdesc");
            return (Criteria) this;
        }

        public Criteria andUsersickdescBetween(String value1, String value2) {
            addCriterion("userSickDesc between", value1, value2, "usersickdesc");
            return (Criteria) this;
        }

        public Criteria andUsersickdescNotBetween(String value1, String value2) {
            addCriterion("userSickDesc not between", value1, value2, "usersickdesc");
            return (Criteria) this;
        }

        public Criteria andUsersickpicIsNull() {
            addCriterion("userSickPic is null");
            return (Criteria) this;
        }

        public Criteria andUsersickpicIsNotNull() {
            addCriterion("userSickPic is not null");
            return (Criteria) this;
        }

        public Criteria andUsersickpicEqualTo(String value) {
            addCriterion("userSickPic =", value, "usersickpic");
            return (Criteria) this;
        }

        public Criteria andUsersickpicNotEqualTo(String value) {
            addCriterion("userSickPic <>", value, "usersickpic");
            return (Criteria) this;
        }

        public Criteria andUsersickpicGreaterThan(String value) {
            addCriterion("userSickPic >", value, "usersickpic");
            return (Criteria) this;
        }

        public Criteria andUsersickpicGreaterThanOrEqualTo(String value) {
            addCriterion("userSickPic >=", value, "usersickpic");
            return (Criteria) this;
        }

        public Criteria andUsersickpicLessThan(String value) {
            addCriterion("userSickPic <", value, "usersickpic");
            return (Criteria) this;
        }

        public Criteria andUsersickpicLessThanOrEqualTo(String value) {
            addCriterion("userSickPic <=", value, "usersickpic");
            return (Criteria) this;
        }

        public Criteria andUsersickpicLike(String value) {
            addCriterion("userSickPic like", value, "usersickpic");
            return (Criteria) this;
        }

        public Criteria andUsersickpicNotLike(String value) {
            addCriterion("userSickPic not like", value, "usersickpic");
            return (Criteria) this;
        }

        public Criteria andUsersickpicIn(List<String> values) {
            addCriterion("userSickPic in", values, "usersickpic");
            return (Criteria) this;
        }

        public Criteria andUsersickpicNotIn(List<String> values) {
            addCriterion("userSickPic not in", values, "usersickpic");
            return (Criteria) this;
        }

        public Criteria andUsersickpicBetween(String value1, String value2) {
            addCriterion("userSickPic between", value1, value2, "usersickpic");
            return (Criteria) this;
        }

        public Criteria andUsersickpicNotBetween(String value1, String value2) {
            addCriterion("userSickPic not between", value1, value2, "usersickpic");
            return (Criteria) this;
        }

        public Criteria andUsersickprimarydeptIsNull() {
            addCriterion("userSickPrimaryDept is null");
            return (Criteria) this;
        }

        public Criteria andUsersickprimarydeptIsNotNull() {
            addCriterion("userSickPrimaryDept is not null");
            return (Criteria) this;
        }

        public Criteria andUsersickprimarydeptEqualTo(String value) {
            addCriterion("userSickPrimaryDept =", value, "usersickprimarydept");
            return (Criteria) this;
        }

        public Criteria andUsersickprimarydeptNotEqualTo(String value) {
            addCriterion("userSickPrimaryDept <>", value, "usersickprimarydept");
            return (Criteria) this;
        }

        public Criteria andUsersickprimarydeptGreaterThan(String value) {
            addCriterion("userSickPrimaryDept >", value, "usersickprimarydept");
            return (Criteria) this;
        }

        public Criteria andUsersickprimarydeptGreaterThanOrEqualTo(String value) {
            addCriterion("userSickPrimaryDept >=", value, "usersickprimarydept");
            return (Criteria) this;
        }

        public Criteria andUsersickprimarydeptLessThan(String value) {
            addCriterion("userSickPrimaryDept <", value, "usersickprimarydept");
            return (Criteria) this;
        }

        public Criteria andUsersickprimarydeptLessThanOrEqualTo(String value) {
            addCriterion("userSickPrimaryDept <=", value, "usersickprimarydept");
            return (Criteria) this;
        }

        public Criteria andUsersickprimarydeptLike(String value) {
            addCriterion("userSickPrimaryDept like", value, "usersickprimarydept");
            return (Criteria) this;
        }

        public Criteria andUsersickprimarydeptNotLike(String value) {
            addCriterion("userSickPrimaryDept not like", value, "usersickprimarydept");
            return (Criteria) this;
        }

        public Criteria andUsersickprimarydeptIn(List<String> values) {
            addCriterion("userSickPrimaryDept in", values, "usersickprimarydept");
            return (Criteria) this;
        }

        public Criteria andUsersickprimarydeptNotIn(List<String> values) {
            addCriterion("userSickPrimaryDept not in", values, "usersickprimarydept");
            return (Criteria) this;
        }

        public Criteria andUsersickprimarydeptBetween(String value1, String value2) {
            addCriterion("userSickPrimaryDept between", value1, value2, "usersickprimarydept");
            return (Criteria) this;
        }

        public Criteria andUsersickprimarydeptNotBetween(String value1, String value2) {
            addCriterion("userSickPrimaryDept not between", value1, value2, "usersickprimarydept");
            return (Criteria) this;
        }

        public Criteria andUsersickseconddeptIsNull() {
            addCriterion("userSickSecondDept is null");
            return (Criteria) this;
        }

        public Criteria andUsersickseconddeptIsNotNull() {
            addCriterion("userSickSecondDept is not null");
            return (Criteria) this;
        }

        public Criteria andUsersickseconddeptEqualTo(String value) {
            addCriterion("userSickSecondDept =", value, "usersickseconddept");
            return (Criteria) this;
        }

        public Criteria andUsersickseconddeptNotEqualTo(String value) {
            addCriterion("userSickSecondDept <>", value, "usersickseconddept");
            return (Criteria) this;
        }

        public Criteria andUsersickseconddeptGreaterThan(String value) {
            addCriterion("userSickSecondDept >", value, "usersickseconddept");
            return (Criteria) this;
        }

        public Criteria andUsersickseconddeptGreaterThanOrEqualTo(String value) {
            addCriterion("userSickSecondDept >=", value, "usersickseconddept");
            return (Criteria) this;
        }

        public Criteria andUsersickseconddeptLessThan(String value) {
            addCriterion("userSickSecondDept <", value, "usersickseconddept");
            return (Criteria) this;
        }

        public Criteria andUsersickseconddeptLessThanOrEqualTo(String value) {
            addCriterion("userSickSecondDept <=", value, "usersickseconddept");
            return (Criteria) this;
        }

        public Criteria andUsersickseconddeptLike(String value) {
            addCriterion("userSickSecondDept like", value, "usersickseconddept");
            return (Criteria) this;
        }

        public Criteria andUsersickseconddeptNotLike(String value) {
            addCriterion("userSickSecondDept not like", value, "usersickseconddept");
            return (Criteria) this;
        }

        public Criteria andUsersickseconddeptIn(List<String> values) {
            addCriterion("userSickSecondDept in", values, "usersickseconddept");
            return (Criteria) this;
        }

        public Criteria andUsersickseconddeptNotIn(List<String> values) {
            addCriterion("userSickSecondDept not in", values, "usersickseconddept");
            return (Criteria) this;
        }

        public Criteria andUsersickseconddeptBetween(String value1, String value2) {
            addCriterion("userSickSecondDept between", value1, value2, "usersickseconddept");
            return (Criteria) this;
        }

        public Criteria andUsersickseconddeptNotBetween(String value1, String value2) {
            addCriterion("userSickSecondDept not between", value1, value2, "usersickseconddept");
            return (Criteria) this;
        }

        public Criteria andFamilyidIsNull() {
            addCriterion("familyId is null");
            return (Criteria) this;
        }

        public Criteria andFamilyidIsNotNull() {
            addCriterion("familyId is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyidEqualTo(Integer value) {
            addCriterion("familyId =", value, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidNotEqualTo(Integer value) {
            addCriterion("familyId <>", value, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidGreaterThan(Integer value) {
            addCriterion("familyId >", value, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("familyId >=", value, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidLessThan(Integer value) {
            addCriterion("familyId <", value, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidLessThanOrEqualTo(Integer value) {
            addCriterion("familyId <=", value, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidIn(List<Integer> values) {
            addCriterion("familyId in", values, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidNotIn(List<Integer> values) {
            addCriterion("familyId not in", values, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidBetween(Integer value1, Integer value2) {
            addCriterion("familyId between", value1, value2, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidNotBetween(Integer value1, Integer value2) {
            addCriterion("familyId not between", value1, value2, "familyid");
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

        public Criteria andUsersicktimeIsNull() {
            addCriterion("userSickTime is null");
            return (Criteria) this;
        }

        public Criteria andUsersicktimeIsNotNull() {
            addCriterion("userSickTime is not null");
            return (Criteria) this;
        }

        public Criteria andUsersicktimeEqualTo(Date value) {
            addCriterion("userSickTime =", value, "usersicktime");
            return (Criteria) this;
        }

        public Criteria andUsersicktimeNotEqualTo(Date value) {
            addCriterion("userSickTime <>", value, "usersicktime");
            return (Criteria) this;
        }

        public Criteria andUsersicktimeGreaterThan(Date value) {
            addCriterion("userSickTime >", value, "usersicktime");
            return (Criteria) this;
        }

        public Criteria andUsersicktimeGreaterThanOrEqualTo(Date value) {
            addCriterion("userSickTime >=", value, "usersicktime");
            return (Criteria) this;
        }

        public Criteria andUsersicktimeLessThan(Date value) {
            addCriterion("userSickTime <", value, "usersicktime");
            return (Criteria) this;
        }

        public Criteria andUsersicktimeLessThanOrEqualTo(Date value) {
            addCriterion("userSickTime <=", value, "usersicktime");
            return (Criteria) this;
        }

        public Criteria andUsersicktimeIn(List<Date> values) {
            addCriterion("userSickTime in", values, "usersicktime");
            return (Criteria) this;
        }

        public Criteria andUsersicktimeNotIn(List<Date> values) {
            addCriterion("userSickTime not in", values, "usersicktime");
            return (Criteria) this;
        }

        public Criteria andUsersicktimeBetween(Date value1, Date value2) {
            addCriterion("userSickTime between", value1, value2, "usersicktime");
            return (Criteria) this;
        }

        public Criteria andUsersicktimeNotBetween(Date value1, Date value2) {
            addCriterion("userSickTime not between", value1, value2, "usersicktime");
            return (Criteria) this;
        }

        public Criteria andUsersickstateidIsNull() {
            addCriterion("userSickStateId is null");
            return (Criteria) this;
        }

        public Criteria andUsersickstateidIsNotNull() {
            addCriterion("userSickStateId is not null");
            return (Criteria) this;
        }

        public Criteria andUsersickstateidEqualTo(Integer value) {
            addCriterion("userSickStateId =", value, "usersickstateid");
            return (Criteria) this;
        }

        public Criteria andUsersickstateidNotEqualTo(Integer value) {
            addCriterion("userSickStateId <>", value, "usersickstateid");
            return (Criteria) this;
        }

        public Criteria andUsersickstateidGreaterThan(Integer value) {
            addCriterion("userSickStateId >", value, "usersickstateid");
            return (Criteria) this;
        }

        public Criteria andUsersickstateidGreaterThanOrEqualTo(Integer value) {
            addCriterion("userSickStateId >=", value, "usersickstateid");
            return (Criteria) this;
        }

        public Criteria andUsersickstateidLessThan(Integer value) {
            addCriterion("userSickStateId <", value, "usersickstateid");
            return (Criteria) this;
        }

        public Criteria andUsersickstateidLessThanOrEqualTo(Integer value) {
            addCriterion("userSickStateId <=", value, "usersickstateid");
            return (Criteria) this;
        }

        public Criteria andUsersickstateidIn(List<Integer> values) {
            addCriterion("userSickStateId in", values, "usersickstateid");
            return (Criteria) this;
        }

        public Criteria andUsersickstateidNotIn(List<Integer> values) {
            addCriterion("userSickStateId not in", values, "usersickstateid");
            return (Criteria) this;
        }

        public Criteria andUsersickstateidBetween(Integer value1, Integer value2) {
            addCriterion("userSickStateId between", value1, value2, "usersickstateid");
            return (Criteria) this;
        }

        public Criteria andUsersickstateidNotBetween(Integer value1, Integer value2) {
            addCriterion("userSickStateId not between", value1, value2, "usersickstateid");
            return (Criteria) this;
        }

        public Criteria andUsersickptimeIsNull() {
            addCriterion("userSickPTime is null");
            return (Criteria) this;
        }

        public Criteria andUsersickptimeIsNotNull() {
            addCriterion("userSickPTime is not null");
            return (Criteria) this;
        }

        public Criteria andUsersickptimeEqualTo(Date value) {
            addCriterion("userSickPTime =", value, "usersickptime");
            return (Criteria) this;
        }

        public Criteria andUsersickptimeNotEqualTo(Date value) {
            addCriterion("userSickPTime <>", value, "usersickptime");
            return (Criteria) this;
        }

        public Criteria andUsersickptimeGreaterThan(Date value) {
            addCriterion("userSickPTime >", value, "usersickptime");
            return (Criteria) this;
        }

        public Criteria andUsersickptimeGreaterThanOrEqualTo(Date value) {
            addCriterion("userSickPTime >=", value, "usersickptime");
            return (Criteria) this;
        }

        public Criteria andUsersickptimeLessThan(Date value) {
            addCriterion("userSickPTime <", value, "usersickptime");
            return (Criteria) this;
        }

        public Criteria andUsersickptimeLessThanOrEqualTo(Date value) {
            addCriterion("userSickPTime <=", value, "usersickptime");
            return (Criteria) this;
        }

        public Criteria andUsersickptimeIn(List<Date> values) {
            addCriterion("userSickPTime in", values, "usersickptime");
            return (Criteria) this;
        }

        public Criteria andUsersickptimeNotIn(List<Date> values) {
            addCriterion("userSickPTime not in", values, "usersickptime");
            return (Criteria) this;
        }

        public Criteria andUsersickptimeBetween(Date value1, Date value2) {
            addCriterion("userSickPTime between", value1, value2, "usersickptime");
            return (Criteria) this;
        }

        public Criteria andUsersickptimeNotBetween(Date value1, Date value2) {
            addCriterion("userSickPTime not between", value1, value2, "usersickptime");
            return (Criteria) this;
        }

        public Criteria andUsersickisdeleteIsNull() {
            addCriterion("userSickIsDelete is null");
            return (Criteria) this;
        }

        public Criteria andUsersickisdeleteIsNotNull() {
            addCriterion("userSickIsDelete is not null");
            return (Criteria) this;
        }

        public Criteria andUsersickisdeleteEqualTo(Boolean value) {
            addCriterion("userSickIsDelete =", value, "usersickisdelete");
            return (Criteria) this;
        }

        public Criteria andUsersickisdeleteNotEqualTo(Boolean value) {
            addCriterion("userSickIsDelete <>", value, "usersickisdelete");
            return (Criteria) this;
        }

        public Criteria andUsersickisdeleteGreaterThan(Boolean value) {
            addCriterion("userSickIsDelete >", value, "usersickisdelete");
            return (Criteria) this;
        }

        public Criteria andUsersickisdeleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("userSickIsDelete >=", value, "usersickisdelete");
            return (Criteria) this;
        }

        public Criteria andUsersickisdeleteLessThan(Boolean value) {
            addCriterion("userSickIsDelete <", value, "usersickisdelete");
            return (Criteria) this;
        }

        public Criteria andUsersickisdeleteLessThanOrEqualTo(Boolean value) {
            addCriterion("userSickIsDelete <=", value, "usersickisdelete");
            return (Criteria) this;
        }

        public Criteria andUsersickisdeleteIn(List<Boolean> values) {
            addCriterion("userSickIsDelete in", values, "usersickisdelete");
            return (Criteria) this;
        }

        public Criteria andUsersickisdeleteNotIn(List<Boolean> values) {
            addCriterion("userSickIsDelete not in", values, "usersickisdelete");
            return (Criteria) this;
        }

        public Criteria andUsersickisdeleteBetween(Boolean value1, Boolean value2) {
            addCriterion("userSickIsDelete between", value1, value2, "usersickisdelete");
            return (Criteria) this;
        }

        public Criteria andUsersickisdeleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("userSickIsDelete not between", value1, value2, "usersickisdelete");
            return (Criteria) this;
        }

        public Criteria andFamilynameIsNull() {
            addCriterion("familyName is null");
            return (Criteria) this;
        }

        public Criteria andFamilynameIsNotNull() {
            addCriterion("familyName is not null");
            return (Criteria) this;
        }

        public Criteria andFamilynameEqualTo(String value) {
            addCriterion("familyName =", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameNotEqualTo(String value) {
            addCriterion("familyName <>", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameGreaterThan(String value) {
            addCriterion("familyName >", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameGreaterThanOrEqualTo(String value) {
            addCriterion("familyName >=", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameLessThan(String value) {
            addCriterion("familyName <", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameLessThanOrEqualTo(String value) {
            addCriterion("familyName <=", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameLike(String value) {
            addCriterion("familyName like", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameNotLike(String value) {
            addCriterion("familyName not like", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameIn(List<String> values) {
            addCriterion("familyName in", values, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameNotIn(List<String> values) {
            addCriterion("familyName not in", values, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameBetween(String value1, String value2) {
            addCriterion("familyName between", value1, value2, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameNotBetween(String value1, String value2) {
            addCriterion("familyName not between", value1, value2, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilymaleIsNull() {
            addCriterion("familyMale is null");
            return (Criteria) this;
        }

        public Criteria andFamilymaleIsNotNull() {
            addCriterion("familyMale is not null");
            return (Criteria) this;
        }

        public Criteria andFamilymaleEqualTo(String value) {
            addCriterion("familyMale =", value, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleNotEqualTo(String value) {
            addCriterion("familyMale <>", value, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleGreaterThan(String value) {
            addCriterion("familyMale >", value, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleGreaterThanOrEqualTo(String value) {
            addCriterion("familyMale >=", value, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleLessThan(String value) {
            addCriterion("familyMale <", value, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleLessThanOrEqualTo(String value) {
            addCriterion("familyMale <=", value, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleLike(String value) {
            addCriterion("familyMale like", value, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleNotLike(String value) {
            addCriterion("familyMale not like", value, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleIn(List<String> values) {
            addCriterion("familyMale in", values, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleNotIn(List<String> values) {
            addCriterion("familyMale not in", values, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleBetween(String value1, String value2) {
            addCriterion("familyMale between", value1, value2, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilymaleNotBetween(String value1, String value2) {
            addCriterion("familyMale not between", value1, value2, "familymale");
            return (Criteria) this;
        }

        public Criteria andFamilyageIsNull() {
            addCriterion("familyAge is null");
            return (Criteria) this;
        }

        public Criteria andFamilyageIsNotNull() {
            addCriterion("familyAge is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyageEqualTo(Integer value) {
            addCriterion("familyAge =", value, "familyage");
            return (Criteria) this;
        }

        public Criteria andFamilyageNotEqualTo(Integer value) {
            addCriterion("familyAge <>", value, "familyage");
            return (Criteria) this;
        }

        public Criteria andFamilyageGreaterThan(Integer value) {
            addCriterion("familyAge >", value, "familyage");
            return (Criteria) this;
        }

        public Criteria andFamilyageGreaterThanOrEqualTo(Integer value) {
            addCriterion("familyAge >=", value, "familyage");
            return (Criteria) this;
        }

        public Criteria andFamilyageLessThan(Integer value) {
            addCriterion("familyAge <", value, "familyage");
            return (Criteria) this;
        }

        public Criteria andFamilyageLessThanOrEqualTo(Integer value) {
            addCriterion("familyAge <=", value, "familyage");
            return (Criteria) this;
        }

        public Criteria andFamilyageIn(List<Integer> values) {
            addCriterion("familyAge in", values, "familyage");
            return (Criteria) this;
        }

        public Criteria andFamilyageNotIn(List<Integer> values) {
            addCriterion("familyAge not in", values, "familyage");
            return (Criteria) this;
        }

        public Criteria andFamilyageBetween(Integer value1, Integer value2) {
            addCriterion("familyAge between", value1, value2, "familyage");
            return (Criteria) this;
        }

        public Criteria andFamilyageNotBetween(Integer value1, Integer value2) {
            addCriterion("familyAge not between", value1, value2, "familyage");
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