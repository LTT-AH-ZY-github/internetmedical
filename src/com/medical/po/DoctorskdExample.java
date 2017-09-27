package com.medical.po;

import java.util.ArrayList;
import java.util.List;

public class DoctorskdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DoctorskdExample() {
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

        public Criteria andDocskdidIsNull() {
            addCriterion("docSkdId is null");
            return (Criteria) this;
        }

        public Criteria andDocskdidIsNotNull() {
            addCriterion("docSkdId is not null");
            return (Criteria) this;
        }

        public Criteria andDocskdidEqualTo(Integer value) {
            addCriterion("docSkdId =", value, "docskdid");
            return (Criteria) this;
        }

        public Criteria andDocskdidNotEqualTo(Integer value) {
            addCriterion("docSkdId <>", value, "docskdid");
            return (Criteria) this;
        }

        public Criteria andDocskdidGreaterThan(Integer value) {
            addCriterion("docSkdId >", value, "docskdid");
            return (Criteria) this;
        }

        public Criteria andDocskdidGreaterThanOrEqualTo(Integer value) {
            addCriterion("docSkdId >=", value, "docskdid");
            return (Criteria) this;
        }

        public Criteria andDocskdidLessThan(Integer value) {
            addCriterion("docSkdId <", value, "docskdid");
            return (Criteria) this;
        }

        public Criteria andDocskdidLessThanOrEqualTo(Integer value) {
            addCriterion("docSkdId <=", value, "docskdid");
            return (Criteria) this;
        }

        public Criteria andDocskdidIn(List<Integer> values) {
            addCriterion("docSkdId in", values, "docskdid");
            return (Criteria) this;
        }

        public Criteria andDocskdidNotIn(List<Integer> values) {
            addCriterion("docSkdId not in", values, "docskdid");
            return (Criteria) this;
        }

        public Criteria andDocskdidBetween(Integer value1, Integer value2) {
            addCriterion("docSkdId between", value1, value2, "docskdid");
            return (Criteria) this;
        }

        public Criteria andDocskdidNotBetween(Integer value1, Integer value2) {
            addCriterion("docSkdId not between", value1, value2, "docskdid");
            return (Criteria) this;
        }

        public Criteria andMonamIsNull() {
            addCriterion("monAm is null");
            return (Criteria) this;
        }

        public Criteria andMonamIsNotNull() {
            addCriterion("monAm is not null");
            return (Criteria) this;
        }

        public Criteria andMonamEqualTo(Boolean value) {
            addCriterion("monAm =", value, "monam");
            return (Criteria) this;
        }

        public Criteria andMonamNotEqualTo(Boolean value) {
            addCriterion("monAm <>", value, "monam");
            return (Criteria) this;
        }

        public Criteria andMonamGreaterThan(Boolean value) {
            addCriterion("monAm >", value, "monam");
            return (Criteria) this;
        }

        public Criteria andMonamGreaterThanOrEqualTo(Boolean value) {
            addCriterion("monAm >=", value, "monam");
            return (Criteria) this;
        }

        public Criteria andMonamLessThan(Boolean value) {
            addCriterion("monAm <", value, "monam");
            return (Criteria) this;
        }

        public Criteria andMonamLessThanOrEqualTo(Boolean value) {
            addCriterion("monAm <=", value, "monam");
            return (Criteria) this;
        }

        public Criteria andMonamIn(List<Boolean> values) {
            addCriterion("monAm in", values, "monam");
            return (Criteria) this;
        }

        public Criteria andMonamNotIn(List<Boolean> values) {
            addCriterion("monAm not in", values, "monam");
            return (Criteria) this;
        }

        public Criteria andMonamBetween(Boolean value1, Boolean value2) {
            addCriterion("monAm between", value1, value2, "monam");
            return (Criteria) this;
        }

        public Criteria andMonamNotBetween(Boolean value1, Boolean value2) {
            addCriterion("monAm not between", value1, value2, "monam");
            return (Criteria) this;
        }

        public Criteria andMonpmIsNull() {
            addCriterion("monPm is null");
            return (Criteria) this;
        }

        public Criteria andMonpmIsNotNull() {
            addCriterion("monPm is not null");
            return (Criteria) this;
        }

        public Criteria andMonpmEqualTo(Boolean value) {
            addCriterion("monPm =", value, "monpm");
            return (Criteria) this;
        }

        public Criteria andMonpmNotEqualTo(Boolean value) {
            addCriterion("monPm <>", value, "monpm");
            return (Criteria) this;
        }

        public Criteria andMonpmGreaterThan(Boolean value) {
            addCriterion("monPm >", value, "monpm");
            return (Criteria) this;
        }

        public Criteria andMonpmGreaterThanOrEqualTo(Boolean value) {
            addCriterion("monPm >=", value, "monpm");
            return (Criteria) this;
        }

        public Criteria andMonpmLessThan(Boolean value) {
            addCriterion("monPm <", value, "monpm");
            return (Criteria) this;
        }

        public Criteria andMonpmLessThanOrEqualTo(Boolean value) {
            addCriterion("monPm <=", value, "monpm");
            return (Criteria) this;
        }

        public Criteria andMonpmIn(List<Boolean> values) {
            addCriterion("monPm in", values, "monpm");
            return (Criteria) this;
        }

        public Criteria andMonpmNotIn(List<Boolean> values) {
            addCriterion("monPm not in", values, "monpm");
            return (Criteria) this;
        }

        public Criteria andMonpmBetween(Boolean value1, Boolean value2) {
            addCriterion("monPm between", value1, value2, "monpm");
            return (Criteria) this;
        }

        public Criteria andMonpmNotBetween(Boolean value1, Boolean value2) {
            addCriterion("monPm not between", value1, value2, "monpm");
            return (Criteria) this;
        }

        public Criteria andTueamIsNull() {
            addCriterion("tueAm is null");
            return (Criteria) this;
        }

        public Criteria andTueamIsNotNull() {
            addCriterion("tueAm is not null");
            return (Criteria) this;
        }

        public Criteria andTueamEqualTo(Boolean value) {
            addCriterion("tueAm =", value, "tueam");
            return (Criteria) this;
        }

        public Criteria andTueamNotEqualTo(Boolean value) {
            addCriterion("tueAm <>", value, "tueam");
            return (Criteria) this;
        }

        public Criteria andTueamGreaterThan(Boolean value) {
            addCriterion("tueAm >", value, "tueam");
            return (Criteria) this;
        }

        public Criteria andTueamGreaterThanOrEqualTo(Boolean value) {
            addCriterion("tueAm >=", value, "tueam");
            return (Criteria) this;
        }

        public Criteria andTueamLessThan(Boolean value) {
            addCriterion("tueAm <", value, "tueam");
            return (Criteria) this;
        }

        public Criteria andTueamLessThanOrEqualTo(Boolean value) {
            addCriterion("tueAm <=", value, "tueam");
            return (Criteria) this;
        }

        public Criteria andTueamIn(List<Boolean> values) {
            addCriterion("tueAm in", values, "tueam");
            return (Criteria) this;
        }

        public Criteria andTueamNotIn(List<Boolean> values) {
            addCriterion("tueAm not in", values, "tueam");
            return (Criteria) this;
        }

        public Criteria andTueamBetween(Boolean value1, Boolean value2) {
            addCriterion("tueAm between", value1, value2, "tueam");
            return (Criteria) this;
        }

        public Criteria andTueamNotBetween(Boolean value1, Boolean value2) {
            addCriterion("tueAm not between", value1, value2, "tueam");
            return (Criteria) this;
        }

        public Criteria andTuepmIsNull() {
            addCriterion("tuePm is null");
            return (Criteria) this;
        }

        public Criteria andTuepmIsNotNull() {
            addCriterion("tuePm is not null");
            return (Criteria) this;
        }

        public Criteria andTuepmEqualTo(Boolean value) {
            addCriterion("tuePm =", value, "tuepm");
            return (Criteria) this;
        }

        public Criteria andTuepmNotEqualTo(Boolean value) {
            addCriterion("tuePm <>", value, "tuepm");
            return (Criteria) this;
        }

        public Criteria andTuepmGreaterThan(Boolean value) {
            addCriterion("tuePm >", value, "tuepm");
            return (Criteria) this;
        }

        public Criteria andTuepmGreaterThanOrEqualTo(Boolean value) {
            addCriterion("tuePm >=", value, "tuepm");
            return (Criteria) this;
        }

        public Criteria andTuepmLessThan(Boolean value) {
            addCriterion("tuePm <", value, "tuepm");
            return (Criteria) this;
        }

        public Criteria andTuepmLessThanOrEqualTo(Boolean value) {
            addCriterion("tuePm <=", value, "tuepm");
            return (Criteria) this;
        }

        public Criteria andTuepmIn(List<Boolean> values) {
            addCriterion("tuePm in", values, "tuepm");
            return (Criteria) this;
        }

        public Criteria andTuepmNotIn(List<Boolean> values) {
            addCriterion("tuePm not in", values, "tuepm");
            return (Criteria) this;
        }

        public Criteria andTuepmBetween(Boolean value1, Boolean value2) {
            addCriterion("tuePm between", value1, value2, "tuepm");
            return (Criteria) this;
        }

        public Criteria andTuepmNotBetween(Boolean value1, Boolean value2) {
            addCriterion("tuePm not between", value1, value2, "tuepm");
            return (Criteria) this;
        }

        public Criteria andWedamIsNull() {
            addCriterion("wedAm is null");
            return (Criteria) this;
        }

        public Criteria andWedamIsNotNull() {
            addCriterion("wedAm is not null");
            return (Criteria) this;
        }

        public Criteria andWedamEqualTo(Boolean value) {
            addCriterion("wedAm =", value, "wedam");
            return (Criteria) this;
        }

        public Criteria andWedamNotEqualTo(Boolean value) {
            addCriterion("wedAm <>", value, "wedam");
            return (Criteria) this;
        }

        public Criteria andWedamGreaterThan(Boolean value) {
            addCriterion("wedAm >", value, "wedam");
            return (Criteria) this;
        }

        public Criteria andWedamGreaterThanOrEqualTo(Boolean value) {
            addCriterion("wedAm >=", value, "wedam");
            return (Criteria) this;
        }

        public Criteria andWedamLessThan(Boolean value) {
            addCriterion("wedAm <", value, "wedam");
            return (Criteria) this;
        }

        public Criteria andWedamLessThanOrEqualTo(Boolean value) {
            addCriterion("wedAm <=", value, "wedam");
            return (Criteria) this;
        }

        public Criteria andWedamIn(List<Boolean> values) {
            addCriterion("wedAm in", values, "wedam");
            return (Criteria) this;
        }

        public Criteria andWedamNotIn(List<Boolean> values) {
            addCriterion("wedAm not in", values, "wedam");
            return (Criteria) this;
        }

        public Criteria andWedamBetween(Boolean value1, Boolean value2) {
            addCriterion("wedAm between", value1, value2, "wedam");
            return (Criteria) this;
        }

        public Criteria andWedamNotBetween(Boolean value1, Boolean value2) {
            addCriterion("wedAm not between", value1, value2, "wedam");
            return (Criteria) this;
        }

        public Criteria andWedpmIsNull() {
            addCriterion("wedPm is null");
            return (Criteria) this;
        }

        public Criteria andWedpmIsNotNull() {
            addCriterion("wedPm is not null");
            return (Criteria) this;
        }

        public Criteria andWedpmEqualTo(Boolean value) {
            addCriterion("wedPm =", value, "wedpm");
            return (Criteria) this;
        }

        public Criteria andWedpmNotEqualTo(Boolean value) {
            addCriterion("wedPm <>", value, "wedpm");
            return (Criteria) this;
        }

        public Criteria andWedpmGreaterThan(Boolean value) {
            addCriterion("wedPm >", value, "wedpm");
            return (Criteria) this;
        }

        public Criteria andWedpmGreaterThanOrEqualTo(Boolean value) {
            addCriterion("wedPm >=", value, "wedpm");
            return (Criteria) this;
        }

        public Criteria andWedpmLessThan(Boolean value) {
            addCriterion("wedPm <", value, "wedpm");
            return (Criteria) this;
        }

        public Criteria andWedpmLessThanOrEqualTo(Boolean value) {
            addCriterion("wedPm <=", value, "wedpm");
            return (Criteria) this;
        }

        public Criteria andWedpmIn(List<Boolean> values) {
            addCriterion("wedPm in", values, "wedpm");
            return (Criteria) this;
        }

        public Criteria andWedpmNotIn(List<Boolean> values) {
            addCriterion("wedPm not in", values, "wedpm");
            return (Criteria) this;
        }

        public Criteria andWedpmBetween(Boolean value1, Boolean value2) {
            addCriterion("wedPm between", value1, value2, "wedpm");
            return (Criteria) this;
        }

        public Criteria andWedpmNotBetween(Boolean value1, Boolean value2) {
            addCriterion("wedPm not between", value1, value2, "wedpm");
            return (Criteria) this;
        }

        public Criteria andThuamIsNull() {
            addCriterion("thuAm is null");
            return (Criteria) this;
        }

        public Criteria andThuamIsNotNull() {
            addCriterion("thuAm is not null");
            return (Criteria) this;
        }

        public Criteria andThuamEqualTo(Boolean value) {
            addCriterion("thuAm =", value, "thuam");
            return (Criteria) this;
        }

        public Criteria andThuamNotEqualTo(Boolean value) {
            addCriterion("thuAm <>", value, "thuam");
            return (Criteria) this;
        }

        public Criteria andThuamGreaterThan(Boolean value) {
            addCriterion("thuAm >", value, "thuam");
            return (Criteria) this;
        }

        public Criteria andThuamGreaterThanOrEqualTo(Boolean value) {
            addCriterion("thuAm >=", value, "thuam");
            return (Criteria) this;
        }

        public Criteria andThuamLessThan(Boolean value) {
            addCriterion("thuAm <", value, "thuam");
            return (Criteria) this;
        }

        public Criteria andThuamLessThanOrEqualTo(Boolean value) {
            addCriterion("thuAm <=", value, "thuam");
            return (Criteria) this;
        }

        public Criteria andThuamIn(List<Boolean> values) {
            addCriterion("thuAm in", values, "thuam");
            return (Criteria) this;
        }

        public Criteria andThuamNotIn(List<Boolean> values) {
            addCriterion("thuAm not in", values, "thuam");
            return (Criteria) this;
        }

        public Criteria andThuamBetween(Boolean value1, Boolean value2) {
            addCriterion("thuAm between", value1, value2, "thuam");
            return (Criteria) this;
        }

        public Criteria andThuamNotBetween(Boolean value1, Boolean value2) {
            addCriterion("thuAm not between", value1, value2, "thuam");
            return (Criteria) this;
        }

        public Criteria andThupmIsNull() {
            addCriterion("thuPm is null");
            return (Criteria) this;
        }

        public Criteria andThupmIsNotNull() {
            addCriterion("thuPm is not null");
            return (Criteria) this;
        }

        public Criteria andThupmEqualTo(Boolean value) {
            addCriterion("thuPm =", value, "thupm");
            return (Criteria) this;
        }

        public Criteria andThupmNotEqualTo(Boolean value) {
            addCriterion("thuPm <>", value, "thupm");
            return (Criteria) this;
        }

        public Criteria andThupmGreaterThan(Boolean value) {
            addCriterion("thuPm >", value, "thupm");
            return (Criteria) this;
        }

        public Criteria andThupmGreaterThanOrEqualTo(Boolean value) {
            addCriterion("thuPm >=", value, "thupm");
            return (Criteria) this;
        }

        public Criteria andThupmLessThan(Boolean value) {
            addCriterion("thuPm <", value, "thupm");
            return (Criteria) this;
        }

        public Criteria andThupmLessThanOrEqualTo(Boolean value) {
            addCriterion("thuPm <=", value, "thupm");
            return (Criteria) this;
        }

        public Criteria andThupmIn(List<Boolean> values) {
            addCriterion("thuPm in", values, "thupm");
            return (Criteria) this;
        }

        public Criteria andThupmNotIn(List<Boolean> values) {
            addCriterion("thuPm not in", values, "thupm");
            return (Criteria) this;
        }

        public Criteria andThupmBetween(Boolean value1, Boolean value2) {
            addCriterion("thuPm between", value1, value2, "thupm");
            return (Criteria) this;
        }

        public Criteria andThupmNotBetween(Boolean value1, Boolean value2) {
            addCriterion("thuPm not between", value1, value2, "thupm");
            return (Criteria) this;
        }

        public Criteria andFriamIsNull() {
            addCriterion("friAm is null");
            return (Criteria) this;
        }

        public Criteria andFriamIsNotNull() {
            addCriterion("friAm is not null");
            return (Criteria) this;
        }

        public Criteria andFriamEqualTo(Boolean value) {
            addCriterion("friAm =", value, "friam");
            return (Criteria) this;
        }

        public Criteria andFriamNotEqualTo(Boolean value) {
            addCriterion("friAm <>", value, "friam");
            return (Criteria) this;
        }

        public Criteria andFriamGreaterThan(Boolean value) {
            addCriterion("friAm >", value, "friam");
            return (Criteria) this;
        }

        public Criteria andFriamGreaterThanOrEqualTo(Boolean value) {
            addCriterion("friAm >=", value, "friam");
            return (Criteria) this;
        }

        public Criteria andFriamLessThan(Boolean value) {
            addCriterion("friAm <", value, "friam");
            return (Criteria) this;
        }

        public Criteria andFriamLessThanOrEqualTo(Boolean value) {
            addCriterion("friAm <=", value, "friam");
            return (Criteria) this;
        }

        public Criteria andFriamIn(List<Boolean> values) {
            addCriterion("friAm in", values, "friam");
            return (Criteria) this;
        }

        public Criteria andFriamNotIn(List<Boolean> values) {
            addCriterion("friAm not in", values, "friam");
            return (Criteria) this;
        }

        public Criteria andFriamBetween(Boolean value1, Boolean value2) {
            addCriterion("friAm between", value1, value2, "friam");
            return (Criteria) this;
        }

        public Criteria andFriamNotBetween(Boolean value1, Boolean value2) {
            addCriterion("friAm not between", value1, value2, "friam");
            return (Criteria) this;
        }

        public Criteria andFripmIsNull() {
            addCriterion("friPm is null");
            return (Criteria) this;
        }

        public Criteria andFripmIsNotNull() {
            addCriterion("friPm is not null");
            return (Criteria) this;
        }

        public Criteria andFripmEqualTo(Boolean value) {
            addCriterion("friPm =", value, "fripm");
            return (Criteria) this;
        }

        public Criteria andFripmNotEqualTo(Boolean value) {
            addCriterion("friPm <>", value, "fripm");
            return (Criteria) this;
        }

        public Criteria andFripmGreaterThan(Boolean value) {
            addCriterion("friPm >", value, "fripm");
            return (Criteria) this;
        }

        public Criteria andFripmGreaterThanOrEqualTo(Boolean value) {
            addCriterion("friPm >=", value, "fripm");
            return (Criteria) this;
        }

        public Criteria andFripmLessThan(Boolean value) {
            addCriterion("friPm <", value, "fripm");
            return (Criteria) this;
        }

        public Criteria andFripmLessThanOrEqualTo(Boolean value) {
            addCriterion("friPm <=", value, "fripm");
            return (Criteria) this;
        }

        public Criteria andFripmIn(List<Boolean> values) {
            addCriterion("friPm in", values, "fripm");
            return (Criteria) this;
        }

        public Criteria andFripmNotIn(List<Boolean> values) {
            addCriterion("friPm not in", values, "fripm");
            return (Criteria) this;
        }

        public Criteria andFripmBetween(Boolean value1, Boolean value2) {
            addCriterion("friPm between", value1, value2, "fripm");
            return (Criteria) this;
        }

        public Criteria andFripmNotBetween(Boolean value1, Boolean value2) {
            addCriterion("friPm not between", value1, value2, "fripm");
            return (Criteria) this;
        }

        public Criteria andSatamIsNull() {
            addCriterion("satAm is null");
            return (Criteria) this;
        }

        public Criteria andSatamIsNotNull() {
            addCriterion("satAm is not null");
            return (Criteria) this;
        }

        public Criteria andSatamEqualTo(Boolean value) {
            addCriterion("satAm =", value, "satam");
            return (Criteria) this;
        }

        public Criteria andSatamNotEqualTo(Boolean value) {
            addCriterion("satAm <>", value, "satam");
            return (Criteria) this;
        }

        public Criteria andSatamGreaterThan(Boolean value) {
            addCriterion("satAm >", value, "satam");
            return (Criteria) this;
        }

        public Criteria andSatamGreaterThanOrEqualTo(Boolean value) {
            addCriterion("satAm >=", value, "satam");
            return (Criteria) this;
        }

        public Criteria andSatamLessThan(Boolean value) {
            addCriterion("satAm <", value, "satam");
            return (Criteria) this;
        }

        public Criteria andSatamLessThanOrEqualTo(Boolean value) {
            addCriterion("satAm <=", value, "satam");
            return (Criteria) this;
        }

        public Criteria andSatamIn(List<Boolean> values) {
            addCriterion("satAm in", values, "satam");
            return (Criteria) this;
        }

        public Criteria andSatamNotIn(List<Boolean> values) {
            addCriterion("satAm not in", values, "satam");
            return (Criteria) this;
        }

        public Criteria andSatamBetween(Boolean value1, Boolean value2) {
            addCriterion("satAm between", value1, value2, "satam");
            return (Criteria) this;
        }

        public Criteria andSatamNotBetween(Boolean value1, Boolean value2) {
            addCriterion("satAm not between", value1, value2, "satam");
            return (Criteria) this;
        }

        public Criteria andSatpmIsNull() {
            addCriterion("satPm is null");
            return (Criteria) this;
        }

        public Criteria andSatpmIsNotNull() {
            addCriterion("satPm is not null");
            return (Criteria) this;
        }

        public Criteria andSatpmEqualTo(Boolean value) {
            addCriterion("satPm =", value, "satpm");
            return (Criteria) this;
        }

        public Criteria andSatpmNotEqualTo(Boolean value) {
            addCriterion("satPm <>", value, "satpm");
            return (Criteria) this;
        }

        public Criteria andSatpmGreaterThan(Boolean value) {
            addCriterion("satPm >", value, "satpm");
            return (Criteria) this;
        }

        public Criteria andSatpmGreaterThanOrEqualTo(Boolean value) {
            addCriterion("satPm >=", value, "satpm");
            return (Criteria) this;
        }

        public Criteria andSatpmLessThan(Boolean value) {
            addCriterion("satPm <", value, "satpm");
            return (Criteria) this;
        }

        public Criteria andSatpmLessThanOrEqualTo(Boolean value) {
            addCriterion("satPm <=", value, "satpm");
            return (Criteria) this;
        }

        public Criteria andSatpmIn(List<Boolean> values) {
            addCriterion("satPm in", values, "satpm");
            return (Criteria) this;
        }

        public Criteria andSatpmNotIn(List<Boolean> values) {
            addCriterion("satPm not in", values, "satpm");
            return (Criteria) this;
        }

        public Criteria andSatpmBetween(Boolean value1, Boolean value2) {
            addCriterion("satPm between", value1, value2, "satpm");
            return (Criteria) this;
        }

        public Criteria andSatpmNotBetween(Boolean value1, Boolean value2) {
            addCriterion("satPm not between", value1, value2, "satpm");
            return (Criteria) this;
        }

        public Criteria andSunamIsNull() {
            addCriterion("sunAm is null");
            return (Criteria) this;
        }

        public Criteria andSunamIsNotNull() {
            addCriterion("sunAm is not null");
            return (Criteria) this;
        }

        public Criteria andSunamEqualTo(Boolean value) {
            addCriterion("sunAm =", value, "sunam");
            return (Criteria) this;
        }

        public Criteria andSunamNotEqualTo(Boolean value) {
            addCriterion("sunAm <>", value, "sunam");
            return (Criteria) this;
        }

        public Criteria andSunamGreaterThan(Boolean value) {
            addCriterion("sunAm >", value, "sunam");
            return (Criteria) this;
        }

        public Criteria andSunamGreaterThanOrEqualTo(Boolean value) {
            addCriterion("sunAm >=", value, "sunam");
            return (Criteria) this;
        }

        public Criteria andSunamLessThan(Boolean value) {
            addCriterion("sunAm <", value, "sunam");
            return (Criteria) this;
        }

        public Criteria andSunamLessThanOrEqualTo(Boolean value) {
            addCriterion("sunAm <=", value, "sunam");
            return (Criteria) this;
        }

        public Criteria andSunamIn(List<Boolean> values) {
            addCriterion("sunAm in", values, "sunam");
            return (Criteria) this;
        }

        public Criteria andSunamNotIn(List<Boolean> values) {
            addCriterion("sunAm not in", values, "sunam");
            return (Criteria) this;
        }

        public Criteria andSunamBetween(Boolean value1, Boolean value2) {
            addCriterion("sunAm between", value1, value2, "sunam");
            return (Criteria) this;
        }

        public Criteria andSunamNotBetween(Boolean value1, Boolean value2) {
            addCriterion("sunAm not between", value1, value2, "sunam");
            return (Criteria) this;
        }

        public Criteria andSunpmIsNull() {
            addCriterion("sunPm is null");
            return (Criteria) this;
        }

        public Criteria andSunpmIsNotNull() {
            addCriterion("sunPm is not null");
            return (Criteria) this;
        }

        public Criteria andSunpmEqualTo(Boolean value) {
            addCriterion("sunPm =", value, "sunpm");
            return (Criteria) this;
        }

        public Criteria andSunpmNotEqualTo(Boolean value) {
            addCriterion("sunPm <>", value, "sunpm");
            return (Criteria) this;
        }

        public Criteria andSunpmGreaterThan(Boolean value) {
            addCriterion("sunPm >", value, "sunpm");
            return (Criteria) this;
        }

        public Criteria andSunpmGreaterThanOrEqualTo(Boolean value) {
            addCriterion("sunPm >=", value, "sunpm");
            return (Criteria) this;
        }

        public Criteria andSunpmLessThan(Boolean value) {
            addCriterion("sunPm <", value, "sunpm");
            return (Criteria) this;
        }

        public Criteria andSunpmLessThanOrEqualTo(Boolean value) {
            addCriterion("sunPm <=", value, "sunpm");
            return (Criteria) this;
        }

        public Criteria andSunpmIn(List<Boolean> values) {
            addCriterion("sunPm in", values, "sunpm");
            return (Criteria) this;
        }

        public Criteria andSunpmNotIn(List<Boolean> values) {
            addCriterion("sunPm not in", values, "sunpm");
            return (Criteria) this;
        }

        public Criteria andSunpmBetween(Boolean value1, Boolean value2) {
            addCriterion("sunPm between", value1, value2, "sunpm");
            return (Criteria) this;
        }

        public Criteria andSunpmNotBetween(Boolean value1, Boolean value2) {
            addCriterion("sunPm not between", value1, value2, "sunpm");
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