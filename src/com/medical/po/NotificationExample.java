package com.medical.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotificationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NotificationExample() {
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

        public Criteria andNotificationidIsNull() {
            addCriterion("notificationId is null");
            return (Criteria) this;
        }

        public Criteria andNotificationidIsNotNull() {
            addCriterion("notificationId is not null");
            return (Criteria) this;
        }

        public Criteria andNotificationidEqualTo(Integer value) {
            addCriterion("notificationId =", value, "notificationid");
            return (Criteria) this;
        }

        public Criteria andNotificationidNotEqualTo(Integer value) {
            addCriterion("notificationId <>", value, "notificationid");
            return (Criteria) this;
        }

        public Criteria andNotificationidGreaterThan(Integer value) {
            addCriterion("notificationId >", value, "notificationid");
            return (Criteria) this;
        }

        public Criteria andNotificationidGreaterThanOrEqualTo(Integer value) {
            addCriterion("notificationId >=", value, "notificationid");
            return (Criteria) this;
        }

        public Criteria andNotificationidLessThan(Integer value) {
            addCriterion("notificationId <", value, "notificationid");
            return (Criteria) this;
        }

        public Criteria andNotificationidLessThanOrEqualTo(Integer value) {
            addCriterion("notificationId <=", value, "notificationid");
            return (Criteria) this;
        }

        public Criteria andNotificationidIn(List<Integer> values) {
            addCriterion("notificationId in", values, "notificationid");
            return (Criteria) this;
        }

        public Criteria andNotificationidNotIn(List<Integer> values) {
            addCriterion("notificationId not in", values, "notificationid");
            return (Criteria) this;
        }

        public Criteria andNotificationidBetween(Integer value1, Integer value2) {
            addCriterion("notificationId between", value1, value2, "notificationid");
            return (Criteria) this;
        }

        public Criteria andNotificationidNotBetween(Integer value1, Integer value2) {
            addCriterion("notificationId not between", value1, value2, "notificationid");
            return (Criteria) this;
        }

        public Criteria andNotificationtitleIsNull() {
            addCriterion("notificationTitle is null");
            return (Criteria) this;
        }

        public Criteria andNotificationtitleIsNotNull() {
            addCriterion("notificationTitle is not null");
            return (Criteria) this;
        }

        public Criteria andNotificationtitleEqualTo(String value) {
            addCriterion("notificationTitle =", value, "notificationtitle");
            return (Criteria) this;
        }

        public Criteria andNotificationtitleNotEqualTo(String value) {
            addCriterion("notificationTitle <>", value, "notificationtitle");
            return (Criteria) this;
        }

        public Criteria andNotificationtitleGreaterThan(String value) {
            addCriterion("notificationTitle >", value, "notificationtitle");
            return (Criteria) this;
        }

        public Criteria andNotificationtitleGreaterThanOrEqualTo(String value) {
            addCriterion("notificationTitle >=", value, "notificationtitle");
            return (Criteria) this;
        }

        public Criteria andNotificationtitleLessThan(String value) {
            addCriterion("notificationTitle <", value, "notificationtitle");
            return (Criteria) this;
        }

        public Criteria andNotificationtitleLessThanOrEqualTo(String value) {
            addCriterion("notificationTitle <=", value, "notificationtitle");
            return (Criteria) this;
        }

        public Criteria andNotificationtitleLike(String value) {
            addCriterion("notificationTitle like", value, "notificationtitle");
            return (Criteria) this;
        }

        public Criteria andNotificationtitleNotLike(String value) {
            addCriterion("notificationTitle not like", value, "notificationtitle");
            return (Criteria) this;
        }

        public Criteria andNotificationtitleIn(List<String> values) {
            addCriterion("notificationTitle in", values, "notificationtitle");
            return (Criteria) this;
        }

        public Criteria andNotificationtitleNotIn(List<String> values) {
            addCriterion("notificationTitle not in", values, "notificationtitle");
            return (Criteria) this;
        }

        public Criteria andNotificationtitleBetween(String value1, String value2) {
            addCriterion("notificationTitle between", value1, value2, "notificationtitle");
            return (Criteria) this;
        }

        public Criteria andNotificationtitleNotBetween(String value1, String value2) {
            addCriterion("notificationTitle not between", value1, value2, "notificationtitle");
            return (Criteria) this;
        }

        public Criteria andNotificationwordsIsNull() {
            addCriterion("notificationWords is null");
            return (Criteria) this;
        }

        public Criteria andNotificationwordsIsNotNull() {
            addCriterion("notificationWords is not null");
            return (Criteria) this;
        }

        public Criteria andNotificationwordsEqualTo(String value) {
            addCriterion("notificationWords =", value, "notificationwords");
            return (Criteria) this;
        }

        public Criteria andNotificationwordsNotEqualTo(String value) {
            addCriterion("notificationWords <>", value, "notificationwords");
            return (Criteria) this;
        }

        public Criteria andNotificationwordsGreaterThan(String value) {
            addCriterion("notificationWords >", value, "notificationwords");
            return (Criteria) this;
        }

        public Criteria andNotificationwordsGreaterThanOrEqualTo(String value) {
            addCriterion("notificationWords >=", value, "notificationwords");
            return (Criteria) this;
        }

        public Criteria andNotificationwordsLessThan(String value) {
            addCriterion("notificationWords <", value, "notificationwords");
            return (Criteria) this;
        }

        public Criteria andNotificationwordsLessThanOrEqualTo(String value) {
            addCriterion("notificationWords <=", value, "notificationwords");
            return (Criteria) this;
        }

        public Criteria andNotificationwordsLike(String value) {
            addCriterion("notificationWords like", value, "notificationwords");
            return (Criteria) this;
        }

        public Criteria andNotificationwordsNotLike(String value) {
            addCriterion("notificationWords not like", value, "notificationwords");
            return (Criteria) this;
        }

        public Criteria andNotificationwordsIn(List<String> values) {
            addCriterion("notificationWords in", values, "notificationwords");
            return (Criteria) this;
        }

        public Criteria andNotificationwordsNotIn(List<String> values) {
            addCriterion("notificationWords not in", values, "notificationwords");
            return (Criteria) this;
        }

        public Criteria andNotificationwordsBetween(String value1, String value2) {
            addCriterion("notificationWords between", value1, value2, "notificationwords");
            return (Criteria) this;
        }

        public Criteria andNotificationwordsNotBetween(String value1, String value2) {
            addCriterion("notificationWords not between", value1, value2, "notificationwords");
            return (Criteria) this;
        }

        public Criteria andNotificationdataIsNull() {
            addCriterion("notificationData is null");
            return (Criteria) this;
        }

        public Criteria andNotificationdataIsNotNull() {
            addCriterion("notificationData is not null");
            return (Criteria) this;
        }

        public Criteria andNotificationdataEqualTo(String value) {
            addCriterion("notificationData =", value, "notificationdata");
            return (Criteria) this;
        }

        public Criteria andNotificationdataNotEqualTo(String value) {
            addCriterion("notificationData <>", value, "notificationdata");
            return (Criteria) this;
        }

        public Criteria andNotificationdataGreaterThan(String value) {
            addCriterion("notificationData >", value, "notificationdata");
            return (Criteria) this;
        }

        public Criteria andNotificationdataGreaterThanOrEqualTo(String value) {
            addCriterion("notificationData >=", value, "notificationdata");
            return (Criteria) this;
        }

        public Criteria andNotificationdataLessThan(String value) {
            addCriterion("notificationData <", value, "notificationdata");
            return (Criteria) this;
        }

        public Criteria andNotificationdataLessThanOrEqualTo(String value) {
            addCriterion("notificationData <=", value, "notificationdata");
            return (Criteria) this;
        }

        public Criteria andNotificationdataLike(String value) {
            addCriterion("notificationData like", value, "notificationdata");
            return (Criteria) this;
        }

        public Criteria andNotificationdataNotLike(String value) {
            addCriterion("notificationData not like", value, "notificationdata");
            return (Criteria) this;
        }

        public Criteria andNotificationdataIn(List<String> values) {
            addCriterion("notificationData in", values, "notificationdata");
            return (Criteria) this;
        }

        public Criteria andNotificationdataNotIn(List<String> values) {
            addCriterion("notificationData not in", values, "notificationdata");
            return (Criteria) this;
        }

        public Criteria andNotificationdataBetween(String value1, String value2) {
            addCriterion("notificationData between", value1, value2, "notificationdata");
            return (Criteria) this;
        }

        public Criteria andNotificationdataNotBetween(String value1, String value2) {
            addCriterion("notificationData not between", value1, value2, "notificationdata");
            return (Criteria) this;
        }

        public Criteria andNotificationcreatetimeIsNull() {
            addCriterion("notificationCreateTime is null");
            return (Criteria) this;
        }

        public Criteria andNotificationcreatetimeIsNotNull() {
            addCriterion("notificationCreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andNotificationcreatetimeEqualTo(Date value) {
            addCriterion("notificationCreateTime =", value, "notificationcreatetime");
            return (Criteria) this;
        }

        public Criteria andNotificationcreatetimeNotEqualTo(Date value) {
            addCriterion("notificationCreateTime <>", value, "notificationcreatetime");
            return (Criteria) this;
        }

        public Criteria andNotificationcreatetimeGreaterThan(Date value) {
            addCriterion("notificationCreateTime >", value, "notificationcreatetime");
            return (Criteria) this;
        }

        public Criteria andNotificationcreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("notificationCreateTime >=", value, "notificationcreatetime");
            return (Criteria) this;
        }

        public Criteria andNotificationcreatetimeLessThan(Date value) {
            addCriterion("notificationCreateTime <", value, "notificationcreatetime");
            return (Criteria) this;
        }

        public Criteria andNotificationcreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("notificationCreateTime <=", value, "notificationcreatetime");
            return (Criteria) this;
        }

        public Criteria andNotificationcreatetimeIn(List<Date> values) {
            addCriterion("notificationCreateTime in", values, "notificationcreatetime");
            return (Criteria) this;
        }

        public Criteria andNotificationcreatetimeNotIn(List<Date> values) {
            addCriterion("notificationCreateTime not in", values, "notificationcreatetime");
            return (Criteria) this;
        }

        public Criteria andNotificationcreatetimeBetween(Date value1, Date value2) {
            addCriterion("notificationCreateTime between", value1, value2, "notificationcreatetime");
            return (Criteria) this;
        }

        public Criteria andNotificationcreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("notificationCreateTime not between", value1, value2, "notificationcreatetime");
            return (Criteria) this;
        }

        public Criteria andNotificationreadtimeIsNull() {
            addCriterion("notificationReadTime is null");
            return (Criteria) this;
        }

        public Criteria andNotificationreadtimeIsNotNull() {
            addCriterion("notificationReadTime is not null");
            return (Criteria) this;
        }

        public Criteria andNotificationreadtimeEqualTo(Date value) {
            addCriterion("notificationReadTime =", value, "notificationreadtime");
            return (Criteria) this;
        }

        public Criteria andNotificationreadtimeNotEqualTo(Date value) {
            addCriterion("notificationReadTime <>", value, "notificationreadtime");
            return (Criteria) this;
        }

        public Criteria andNotificationreadtimeGreaterThan(Date value) {
            addCriterion("notificationReadTime >", value, "notificationreadtime");
            return (Criteria) this;
        }

        public Criteria andNotificationreadtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("notificationReadTime >=", value, "notificationreadtime");
            return (Criteria) this;
        }

        public Criteria andNotificationreadtimeLessThan(Date value) {
            addCriterion("notificationReadTime <", value, "notificationreadtime");
            return (Criteria) this;
        }

        public Criteria andNotificationreadtimeLessThanOrEqualTo(Date value) {
            addCriterion("notificationReadTime <=", value, "notificationreadtime");
            return (Criteria) this;
        }

        public Criteria andNotificationreadtimeIn(List<Date> values) {
            addCriterion("notificationReadTime in", values, "notificationreadtime");
            return (Criteria) this;
        }

        public Criteria andNotificationreadtimeNotIn(List<Date> values) {
            addCriterion("notificationReadTime not in", values, "notificationreadtime");
            return (Criteria) this;
        }

        public Criteria andNotificationreadtimeBetween(Date value1, Date value2) {
            addCriterion("notificationReadTime between", value1, value2, "notificationreadtime");
            return (Criteria) this;
        }

        public Criteria andNotificationreadtimeNotBetween(Date value1, Date value2) {
            addCriterion("notificationReadTime not between", value1, value2, "notificationreadtime");
            return (Criteria) this;
        }

        public Criteria andNotificationsenderidIsNull() {
            addCriterion("notificationSenderId is null");
            return (Criteria) this;
        }

        public Criteria andNotificationsenderidIsNotNull() {
            addCriterion("notificationSenderId is not null");
            return (Criteria) this;
        }

        public Criteria andNotificationsenderidEqualTo(Integer value) {
            addCriterion("notificationSenderId =", value, "notificationsenderid");
            return (Criteria) this;
        }

        public Criteria andNotificationsenderidNotEqualTo(Integer value) {
            addCriterion("notificationSenderId <>", value, "notificationsenderid");
            return (Criteria) this;
        }

        public Criteria andNotificationsenderidGreaterThan(Integer value) {
            addCriterion("notificationSenderId >", value, "notificationsenderid");
            return (Criteria) this;
        }

        public Criteria andNotificationsenderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("notificationSenderId >=", value, "notificationsenderid");
            return (Criteria) this;
        }

        public Criteria andNotificationsenderidLessThan(Integer value) {
            addCriterion("notificationSenderId <", value, "notificationsenderid");
            return (Criteria) this;
        }

        public Criteria andNotificationsenderidLessThanOrEqualTo(Integer value) {
            addCriterion("notificationSenderId <=", value, "notificationsenderid");
            return (Criteria) this;
        }

        public Criteria andNotificationsenderidIn(List<Integer> values) {
            addCriterion("notificationSenderId in", values, "notificationsenderid");
            return (Criteria) this;
        }

        public Criteria andNotificationsenderidNotIn(List<Integer> values) {
            addCriterion("notificationSenderId not in", values, "notificationsenderid");
            return (Criteria) this;
        }

        public Criteria andNotificationsenderidBetween(Integer value1, Integer value2) {
            addCriterion("notificationSenderId between", value1, value2, "notificationsenderid");
            return (Criteria) this;
        }

        public Criteria andNotificationsenderidNotBetween(Integer value1, Integer value2) {
            addCriterion("notificationSenderId not between", value1, value2, "notificationsenderid");
            return (Criteria) this;
        }

        public Criteria andNotificationreceiveridIsNull() {
            addCriterion("notificationReceiverId is null");
            return (Criteria) this;
        }

        public Criteria andNotificationreceiveridIsNotNull() {
            addCriterion("notificationReceiverId is not null");
            return (Criteria) this;
        }

        public Criteria andNotificationreceiveridEqualTo(Integer value) {
            addCriterion("notificationReceiverId =", value, "notificationreceiverid");
            return (Criteria) this;
        }

        public Criteria andNotificationreceiveridNotEqualTo(Integer value) {
            addCriterion("notificationReceiverId <>", value, "notificationreceiverid");
            return (Criteria) this;
        }

        public Criteria andNotificationreceiveridGreaterThan(Integer value) {
            addCriterion("notificationReceiverId >", value, "notificationreceiverid");
            return (Criteria) this;
        }

        public Criteria andNotificationreceiveridGreaterThanOrEqualTo(Integer value) {
            addCriterion("notificationReceiverId >=", value, "notificationreceiverid");
            return (Criteria) this;
        }

        public Criteria andNotificationreceiveridLessThan(Integer value) {
            addCriterion("notificationReceiverId <", value, "notificationreceiverid");
            return (Criteria) this;
        }

        public Criteria andNotificationreceiveridLessThanOrEqualTo(Integer value) {
            addCriterion("notificationReceiverId <=", value, "notificationreceiverid");
            return (Criteria) this;
        }

        public Criteria andNotificationreceiveridIn(List<Integer> values) {
            addCriterion("notificationReceiverId in", values, "notificationreceiverid");
            return (Criteria) this;
        }

        public Criteria andNotificationreceiveridNotIn(List<Integer> values) {
            addCriterion("notificationReceiverId not in", values, "notificationreceiverid");
            return (Criteria) this;
        }

        public Criteria andNotificationreceiveridBetween(Integer value1, Integer value2) {
            addCriterion("notificationReceiverId between", value1, value2, "notificationreceiverid");
            return (Criteria) this;
        }

        public Criteria andNotificationreceiveridNotBetween(Integer value1, Integer value2) {
            addCriterion("notificationReceiverId not between", value1, value2, "notificationreceiverid");
            return (Criteria) this;
        }

        public Criteria andNotificationreadIsNull() {
            addCriterion("notificationRead is null");
            return (Criteria) this;
        }

        public Criteria andNotificationreadIsNotNull() {
            addCriterion("notificationRead is not null");
            return (Criteria) this;
        }

        public Criteria andNotificationreadEqualTo(Boolean value) {
            addCriterion("notificationRead =", value, "notificationread");
            return (Criteria) this;
        }

        public Criteria andNotificationreadNotEqualTo(Boolean value) {
            addCriterion("notificationRead <>", value, "notificationread");
            return (Criteria) this;
        }

        public Criteria andNotificationreadGreaterThan(Boolean value) {
            addCriterion("notificationRead >", value, "notificationread");
            return (Criteria) this;
        }

        public Criteria andNotificationreadGreaterThanOrEqualTo(Boolean value) {
            addCriterion("notificationRead >=", value, "notificationread");
            return (Criteria) this;
        }

        public Criteria andNotificationreadLessThan(Boolean value) {
            addCriterion("notificationRead <", value, "notificationread");
            return (Criteria) this;
        }

        public Criteria andNotificationreadLessThanOrEqualTo(Boolean value) {
            addCriterion("notificationRead <=", value, "notificationread");
            return (Criteria) this;
        }

        public Criteria andNotificationreadIn(List<Boolean> values) {
            addCriterion("notificationRead in", values, "notificationread");
            return (Criteria) this;
        }

        public Criteria andNotificationreadNotIn(List<Boolean> values) {
            addCriterion("notificationRead not in", values, "notificationread");
            return (Criteria) this;
        }

        public Criteria andNotificationreadBetween(Boolean value1, Boolean value2) {
            addCriterion("notificationRead between", value1, value2, "notificationread");
            return (Criteria) this;
        }

        public Criteria andNotificationreadNotBetween(Boolean value1, Boolean value2) {
            addCriterion("notificationRead not between", value1, value2, "notificationread");
            return (Criteria) this;
        }

        public Criteria andNotificationremoveIsNull() {
            addCriterion("notificationRemove is null");
            return (Criteria) this;
        }

        public Criteria andNotificationremoveIsNotNull() {
            addCriterion("notificationRemove is not null");
            return (Criteria) this;
        }

        public Criteria andNotificationremoveEqualTo(Boolean value) {
            addCriterion("notificationRemove =", value, "notificationremove");
            return (Criteria) this;
        }

        public Criteria andNotificationremoveNotEqualTo(Boolean value) {
            addCriterion("notificationRemove <>", value, "notificationremove");
            return (Criteria) this;
        }

        public Criteria andNotificationremoveGreaterThan(Boolean value) {
            addCriterion("notificationRemove >", value, "notificationremove");
            return (Criteria) this;
        }

        public Criteria andNotificationremoveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("notificationRemove >=", value, "notificationremove");
            return (Criteria) this;
        }

        public Criteria andNotificationremoveLessThan(Boolean value) {
            addCriterion("notificationRemove <", value, "notificationremove");
            return (Criteria) this;
        }

        public Criteria andNotificationremoveLessThanOrEqualTo(Boolean value) {
            addCriterion("notificationRemove <=", value, "notificationremove");
            return (Criteria) this;
        }

        public Criteria andNotificationremoveIn(List<Boolean> values) {
            addCriterion("notificationRemove in", values, "notificationremove");
            return (Criteria) this;
        }

        public Criteria andNotificationremoveNotIn(List<Boolean> values) {
            addCriterion("notificationRemove not in", values, "notificationremove");
            return (Criteria) this;
        }

        public Criteria andNotificationremoveBetween(Boolean value1, Boolean value2) {
            addCriterion("notificationRemove between", value1, value2, "notificationremove");
            return (Criteria) this;
        }

        public Criteria andNotificationremoveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("notificationRemove not between", value1, value2, "notificationremove");
            return (Criteria) this;
        }

        public Criteria andNotificationtypeidIsNull() {
            addCriterion("notificationTypeId is null");
            return (Criteria) this;
        }

        public Criteria andNotificationtypeidIsNotNull() {
            addCriterion("notificationTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andNotificationtypeidEqualTo(Integer value) {
            addCriterion("notificationTypeId =", value, "notificationtypeid");
            return (Criteria) this;
        }

        public Criteria andNotificationtypeidNotEqualTo(Integer value) {
            addCriterion("notificationTypeId <>", value, "notificationtypeid");
            return (Criteria) this;
        }

        public Criteria andNotificationtypeidGreaterThan(Integer value) {
            addCriterion("notificationTypeId >", value, "notificationtypeid");
            return (Criteria) this;
        }

        public Criteria andNotificationtypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("notificationTypeId >=", value, "notificationtypeid");
            return (Criteria) this;
        }

        public Criteria andNotificationtypeidLessThan(Integer value) {
            addCriterion("notificationTypeId <", value, "notificationtypeid");
            return (Criteria) this;
        }

        public Criteria andNotificationtypeidLessThanOrEqualTo(Integer value) {
            addCriterion("notificationTypeId <=", value, "notificationtypeid");
            return (Criteria) this;
        }

        public Criteria andNotificationtypeidIn(List<Integer> values) {
            addCriterion("notificationTypeId in", values, "notificationtypeid");
            return (Criteria) this;
        }

        public Criteria andNotificationtypeidNotIn(List<Integer> values) {
            addCriterion("notificationTypeId not in", values, "notificationtypeid");
            return (Criteria) this;
        }

        public Criteria andNotificationtypeidBetween(Integer value1, Integer value2) {
            addCriterion("notificationTypeId between", value1, value2, "notificationtypeid");
            return (Criteria) this;
        }

        public Criteria andNotificationtypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("notificationTypeId not between", value1, value2, "notificationtypeid");
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