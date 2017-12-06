package com.medical.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PayExample() {
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

        public Criteria andPayidIsNull() {
            addCriterion("payId is null");
            return (Criteria) this;
        }

        public Criteria andPayidIsNotNull() {
            addCriterion("payId is not null");
            return (Criteria) this;
        }

        public Criteria andPayidEqualTo(Integer value) {
            addCriterion("payId =", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidNotEqualTo(Integer value) {
            addCriterion("payId <>", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidGreaterThan(Integer value) {
            addCriterion("payId >", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidGreaterThanOrEqualTo(Integer value) {
            addCriterion("payId >=", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidLessThan(Integer value) {
            addCriterion("payId <", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidLessThanOrEqualTo(Integer value) {
            addCriterion("payId <=", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidIn(List<Integer> values) {
            addCriterion("payId in", values, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidNotIn(List<Integer> values) {
            addCriterion("payId not in", values, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidBetween(Integer value1, Integer value2) {
            addCriterion("payId between", value1, value2, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidNotBetween(Integer value1, Integer value2) {
            addCriterion("payId not between", value1, value2, "payid");
            return (Criteria) this;
        }

        public Criteria andPayorderidIsNull() {
            addCriterion("payOrderId is null");
            return (Criteria) this;
        }

        public Criteria andPayorderidIsNotNull() {
            addCriterion("payOrderId is not null");
            return (Criteria) this;
        }

        public Criteria andPayorderidEqualTo(Integer value) {
            addCriterion("payOrderId =", value, "payorderid");
            return (Criteria) this;
        }

        public Criteria andPayorderidNotEqualTo(Integer value) {
            addCriterion("payOrderId <>", value, "payorderid");
            return (Criteria) this;
        }

        public Criteria andPayorderidGreaterThan(Integer value) {
            addCriterion("payOrderId >", value, "payorderid");
            return (Criteria) this;
        }

        public Criteria andPayorderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("payOrderId >=", value, "payorderid");
            return (Criteria) this;
        }

        public Criteria andPayorderidLessThan(Integer value) {
            addCriterion("payOrderId <", value, "payorderid");
            return (Criteria) this;
        }

        public Criteria andPayorderidLessThanOrEqualTo(Integer value) {
            addCriterion("payOrderId <=", value, "payorderid");
            return (Criteria) this;
        }

        public Criteria andPayorderidIn(List<Integer> values) {
            addCriterion("payOrderId in", values, "payorderid");
            return (Criteria) this;
        }

        public Criteria andPayorderidNotIn(List<Integer> values) {
            addCriterion("payOrderId not in", values, "payorderid");
            return (Criteria) this;
        }

        public Criteria andPayorderidBetween(Integer value1, Integer value2) {
            addCriterion("payOrderId between", value1, value2, "payorderid");
            return (Criteria) this;
        }

        public Criteria andPayorderidNotBetween(Integer value1, Integer value2) {
            addCriterion("payOrderId not between", value1, value2, "payorderid");
            return (Criteria) this;
        }

        public Criteria andPaytradenoIsNull() {
            addCriterion("PayTradeNo is null");
            return (Criteria) this;
        }

        public Criteria andPaytradenoIsNotNull() {
            addCriterion("PayTradeNo is not null");
            return (Criteria) this;
        }

        public Criteria andPaytradenoEqualTo(String value) {
            addCriterion("PayTradeNo =", value, "paytradeno");
            return (Criteria) this;
        }

        public Criteria andPaytradenoNotEqualTo(String value) {
            addCriterion("PayTradeNo <>", value, "paytradeno");
            return (Criteria) this;
        }

        public Criteria andPaytradenoGreaterThan(String value) {
            addCriterion("PayTradeNo >", value, "paytradeno");
            return (Criteria) this;
        }

        public Criteria andPaytradenoGreaterThanOrEqualTo(String value) {
            addCriterion("PayTradeNo >=", value, "paytradeno");
            return (Criteria) this;
        }

        public Criteria andPaytradenoLessThan(String value) {
            addCriterion("PayTradeNo <", value, "paytradeno");
            return (Criteria) this;
        }

        public Criteria andPaytradenoLessThanOrEqualTo(String value) {
            addCriterion("PayTradeNo <=", value, "paytradeno");
            return (Criteria) this;
        }

        public Criteria andPaytradenoLike(String value) {
            addCriterion("PayTradeNo like", value, "paytradeno");
            return (Criteria) this;
        }

        public Criteria andPaytradenoNotLike(String value) {
            addCriterion("PayTradeNo not like", value, "paytradeno");
            return (Criteria) this;
        }

        public Criteria andPaytradenoIn(List<String> values) {
            addCriterion("PayTradeNo in", values, "paytradeno");
            return (Criteria) this;
        }

        public Criteria andPaytradenoNotIn(List<String> values) {
            addCriterion("PayTradeNo not in", values, "paytradeno");
            return (Criteria) this;
        }

        public Criteria andPaytradenoBetween(String value1, String value2) {
            addCriterion("PayTradeNo between", value1, value2, "paytradeno");
            return (Criteria) this;
        }

        public Criteria andPaytradenoNotBetween(String value1, String value2) {
            addCriterion("PayTradeNo not between", value1, value2, "paytradeno");
            return (Criteria) this;
        }

        public Criteria andPayalipaytradenoIsNull() {
            addCriterion("payAlipayTradeNo is null");
            return (Criteria) this;
        }

        public Criteria andPayalipaytradenoIsNotNull() {
            addCriterion("payAlipayTradeNo is not null");
            return (Criteria) this;
        }

        public Criteria andPayalipaytradenoEqualTo(String value) {
            addCriterion("payAlipayTradeNo =", value, "payalipaytradeno");
            return (Criteria) this;
        }

        public Criteria andPayalipaytradenoNotEqualTo(String value) {
            addCriterion("payAlipayTradeNo <>", value, "payalipaytradeno");
            return (Criteria) this;
        }

        public Criteria andPayalipaytradenoGreaterThan(String value) {
            addCriterion("payAlipayTradeNo >", value, "payalipaytradeno");
            return (Criteria) this;
        }

        public Criteria andPayalipaytradenoGreaterThanOrEqualTo(String value) {
            addCriterion("payAlipayTradeNo >=", value, "payalipaytradeno");
            return (Criteria) this;
        }

        public Criteria andPayalipaytradenoLessThan(String value) {
            addCriterion("payAlipayTradeNo <", value, "payalipaytradeno");
            return (Criteria) this;
        }

        public Criteria andPayalipaytradenoLessThanOrEqualTo(String value) {
            addCriterion("payAlipayTradeNo <=", value, "payalipaytradeno");
            return (Criteria) this;
        }

        public Criteria andPayalipaytradenoLike(String value) {
            addCriterion("payAlipayTradeNo like", value, "payalipaytradeno");
            return (Criteria) this;
        }

        public Criteria andPayalipaytradenoNotLike(String value) {
            addCriterion("payAlipayTradeNo not like", value, "payalipaytradeno");
            return (Criteria) this;
        }

        public Criteria andPayalipaytradenoIn(List<String> values) {
            addCriterion("payAlipayTradeNo in", values, "payalipaytradeno");
            return (Criteria) this;
        }

        public Criteria andPayalipaytradenoNotIn(List<String> values) {
            addCriterion("payAlipayTradeNo not in", values, "payalipaytradeno");
            return (Criteria) this;
        }

        public Criteria andPayalipaytradenoBetween(String value1, String value2) {
            addCriterion("payAlipayTradeNo between", value1, value2, "payalipaytradeno");
            return (Criteria) this;
        }

        public Criteria andPayalipaytradenoNotBetween(String value1, String value2) {
            addCriterion("payAlipayTradeNo not between", value1, value2, "payalipaytradeno");
            return (Criteria) this;
        }

        public Criteria andPaywxtradenoIsNull() {
            addCriterion("payWXTradeNo is null");
            return (Criteria) this;
        }

        public Criteria andPaywxtradenoIsNotNull() {
            addCriterion("payWXTradeNo is not null");
            return (Criteria) this;
        }

        public Criteria andPaywxtradenoEqualTo(String value) {
            addCriterion("payWXTradeNo =", value, "paywxtradeno");
            return (Criteria) this;
        }

        public Criteria andPaywxtradenoNotEqualTo(String value) {
            addCriterion("payWXTradeNo <>", value, "paywxtradeno");
            return (Criteria) this;
        }

        public Criteria andPaywxtradenoGreaterThan(String value) {
            addCriterion("payWXTradeNo >", value, "paywxtradeno");
            return (Criteria) this;
        }

        public Criteria andPaywxtradenoGreaterThanOrEqualTo(String value) {
            addCriterion("payWXTradeNo >=", value, "paywxtradeno");
            return (Criteria) this;
        }

        public Criteria andPaywxtradenoLessThan(String value) {
            addCriterion("payWXTradeNo <", value, "paywxtradeno");
            return (Criteria) this;
        }

        public Criteria andPaywxtradenoLessThanOrEqualTo(String value) {
            addCriterion("payWXTradeNo <=", value, "paywxtradeno");
            return (Criteria) this;
        }

        public Criteria andPaywxtradenoLike(String value) {
            addCriterion("payWXTradeNo like", value, "paywxtradeno");
            return (Criteria) this;
        }

        public Criteria andPaywxtradenoNotLike(String value) {
            addCriterion("payWXTradeNo not like", value, "paywxtradeno");
            return (Criteria) this;
        }

        public Criteria andPaywxtradenoIn(List<String> values) {
            addCriterion("payWXTradeNo in", values, "paywxtradeno");
            return (Criteria) this;
        }

        public Criteria andPaywxtradenoNotIn(List<String> values) {
            addCriterion("payWXTradeNo not in", values, "paywxtradeno");
            return (Criteria) this;
        }

        public Criteria andPaywxtradenoBetween(String value1, String value2) {
            addCriterion("payWXTradeNo between", value1, value2, "paywxtradeno");
            return (Criteria) this;
        }

        public Criteria andPaywxtradenoNotBetween(String value1, String value2) {
            addCriterion("payWXTradeNo not between", value1, value2, "paywxtradeno");
            return (Criteria) this;
        }

        public Criteria andPaytotalamountIsNull() {
            addCriterion("payTotalAmount is null");
            return (Criteria) this;
        }

        public Criteria andPaytotalamountIsNotNull() {
            addCriterion("payTotalAmount is not null");
            return (Criteria) this;
        }

        public Criteria andPaytotalamountEqualTo(BigDecimal value) {
            addCriterion("payTotalAmount =", value, "paytotalamount");
            return (Criteria) this;
        }

        public Criteria andPaytotalamountNotEqualTo(BigDecimal value) {
            addCriterion("payTotalAmount <>", value, "paytotalamount");
            return (Criteria) this;
        }

        public Criteria andPaytotalamountGreaterThan(BigDecimal value) {
            addCriterion("payTotalAmount >", value, "paytotalamount");
            return (Criteria) this;
        }

        public Criteria andPaytotalamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("payTotalAmount >=", value, "paytotalamount");
            return (Criteria) this;
        }

        public Criteria andPaytotalamountLessThan(BigDecimal value) {
            addCriterion("payTotalAmount <", value, "paytotalamount");
            return (Criteria) this;
        }

        public Criteria andPaytotalamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("payTotalAmount <=", value, "paytotalamount");
            return (Criteria) this;
        }

        public Criteria andPaytotalamountIn(List<BigDecimal> values) {
            addCriterion("payTotalAmount in", values, "paytotalamount");
            return (Criteria) this;
        }

        public Criteria andPaytotalamountNotIn(List<BigDecimal> values) {
            addCriterion("payTotalAmount not in", values, "paytotalamount");
            return (Criteria) this;
        }

        public Criteria andPaytotalamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payTotalAmount between", value1, value2, "paytotalamount");
            return (Criteria) this;
        }

        public Criteria andPaytotalamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payTotalAmount not between", value1, value2, "paytotalamount");
            return (Criteria) this;
        }

        public Criteria andPayreceiptamountIsNull() {
            addCriterion("payReceiptAmount is null");
            return (Criteria) this;
        }

        public Criteria andPayreceiptamountIsNotNull() {
            addCriterion("payReceiptAmount is not null");
            return (Criteria) this;
        }

        public Criteria andPayreceiptamountEqualTo(BigDecimal value) {
            addCriterion("payReceiptAmount =", value, "payreceiptamount");
            return (Criteria) this;
        }

        public Criteria andPayreceiptamountNotEqualTo(BigDecimal value) {
            addCriterion("payReceiptAmount <>", value, "payreceiptamount");
            return (Criteria) this;
        }

        public Criteria andPayreceiptamountGreaterThan(BigDecimal value) {
            addCriterion("payReceiptAmount >", value, "payreceiptamount");
            return (Criteria) this;
        }

        public Criteria andPayreceiptamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("payReceiptAmount >=", value, "payreceiptamount");
            return (Criteria) this;
        }

        public Criteria andPayreceiptamountLessThan(BigDecimal value) {
            addCriterion("payReceiptAmount <", value, "payreceiptamount");
            return (Criteria) this;
        }

        public Criteria andPayreceiptamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("payReceiptAmount <=", value, "payreceiptamount");
            return (Criteria) this;
        }

        public Criteria andPayreceiptamountIn(List<BigDecimal> values) {
            addCriterion("payReceiptAmount in", values, "payreceiptamount");
            return (Criteria) this;
        }

        public Criteria andPayreceiptamountNotIn(List<BigDecimal> values) {
            addCriterion("payReceiptAmount not in", values, "payreceiptamount");
            return (Criteria) this;
        }

        public Criteria andPayreceiptamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payReceiptAmount between", value1, value2, "payreceiptamount");
            return (Criteria) this;
        }

        public Criteria andPayreceiptamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payReceiptAmount not between", value1, value2, "payreceiptamount");
            return (Criteria) this;
        }

        public Criteria andPaycreattimeIsNull() {
            addCriterion("payCreatTime is null");
            return (Criteria) this;
        }

        public Criteria andPaycreattimeIsNotNull() {
            addCriterion("payCreatTime is not null");
            return (Criteria) this;
        }

        public Criteria andPaycreattimeEqualTo(Date value) {
            addCriterion("payCreatTime =", value, "paycreattime");
            return (Criteria) this;
        }

        public Criteria andPaycreattimeNotEqualTo(Date value) {
            addCriterion("payCreatTime <>", value, "paycreattime");
            return (Criteria) this;
        }

        public Criteria andPaycreattimeGreaterThan(Date value) {
            addCriterion("payCreatTime >", value, "paycreattime");
            return (Criteria) this;
        }

        public Criteria andPaycreattimeGreaterThanOrEqualTo(Date value) {
            addCriterion("payCreatTime >=", value, "paycreattime");
            return (Criteria) this;
        }

        public Criteria andPaycreattimeLessThan(Date value) {
            addCriterion("payCreatTime <", value, "paycreattime");
            return (Criteria) this;
        }

        public Criteria andPaycreattimeLessThanOrEqualTo(Date value) {
            addCriterion("payCreatTime <=", value, "paycreattime");
            return (Criteria) this;
        }

        public Criteria andPaycreattimeIn(List<Date> values) {
            addCriterion("payCreatTime in", values, "paycreattime");
            return (Criteria) this;
        }

        public Criteria andPaycreattimeNotIn(List<Date> values) {
            addCriterion("payCreatTime not in", values, "paycreattime");
            return (Criteria) this;
        }

        public Criteria andPaycreattimeBetween(Date value1, Date value2) {
            addCriterion("payCreatTime between", value1, value2, "paycreattime");
            return (Criteria) this;
        }

        public Criteria andPaycreattimeNotBetween(Date value1, Date value2) {
            addCriterion("payCreatTime not between", value1, value2, "paycreattime");
            return (Criteria) this;
        }

        public Criteria andPayendtimeIsNull() {
            addCriterion("payEndTime is null");
            return (Criteria) this;
        }

        public Criteria andPayendtimeIsNotNull() {
            addCriterion("payEndTime is not null");
            return (Criteria) this;
        }

        public Criteria andPayendtimeEqualTo(Date value) {
            addCriterion("payEndTime =", value, "payendtime");
            return (Criteria) this;
        }

        public Criteria andPayendtimeNotEqualTo(Date value) {
            addCriterion("payEndTime <>", value, "payendtime");
            return (Criteria) this;
        }

        public Criteria andPayendtimeGreaterThan(Date value) {
            addCriterion("payEndTime >", value, "payendtime");
            return (Criteria) this;
        }

        public Criteria andPayendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("payEndTime >=", value, "payendtime");
            return (Criteria) this;
        }

        public Criteria andPayendtimeLessThan(Date value) {
            addCriterion("payEndTime <", value, "payendtime");
            return (Criteria) this;
        }

        public Criteria andPayendtimeLessThanOrEqualTo(Date value) {
            addCriterion("payEndTime <=", value, "payendtime");
            return (Criteria) this;
        }

        public Criteria andPayendtimeIn(List<Date> values) {
            addCriterion("payEndTime in", values, "payendtime");
            return (Criteria) this;
        }

        public Criteria andPayendtimeNotIn(List<Date> values) {
            addCriterion("payEndTime not in", values, "payendtime");
            return (Criteria) this;
        }

        public Criteria andPayendtimeBetween(Date value1, Date value2) {
            addCriterion("payEndTime between", value1, value2, "payendtime");
            return (Criteria) this;
        }

        public Criteria andPayendtimeNotBetween(Date value1, Date value2) {
            addCriterion("payEndTime not between", value1, value2, "payendtime");
            return (Criteria) this;
        }

        public Criteria andPaybuyeridIsNull() {
            addCriterion("payBuyerId is null");
            return (Criteria) this;
        }

        public Criteria andPaybuyeridIsNotNull() {
            addCriterion("payBuyerId is not null");
            return (Criteria) this;
        }

        public Criteria andPaybuyeridEqualTo(Integer value) {
            addCriterion("payBuyerId =", value, "paybuyerid");
            return (Criteria) this;
        }

        public Criteria andPaybuyeridNotEqualTo(Integer value) {
            addCriterion("payBuyerId <>", value, "paybuyerid");
            return (Criteria) this;
        }

        public Criteria andPaybuyeridGreaterThan(Integer value) {
            addCriterion("payBuyerId >", value, "paybuyerid");
            return (Criteria) this;
        }

        public Criteria andPaybuyeridGreaterThanOrEqualTo(Integer value) {
            addCriterion("payBuyerId >=", value, "paybuyerid");
            return (Criteria) this;
        }

        public Criteria andPaybuyeridLessThan(Integer value) {
            addCriterion("payBuyerId <", value, "paybuyerid");
            return (Criteria) this;
        }

        public Criteria andPaybuyeridLessThanOrEqualTo(Integer value) {
            addCriterion("payBuyerId <=", value, "paybuyerid");
            return (Criteria) this;
        }

        public Criteria andPaybuyeridIn(List<Integer> values) {
            addCriterion("payBuyerId in", values, "paybuyerid");
            return (Criteria) this;
        }

        public Criteria andPaybuyeridNotIn(List<Integer> values) {
            addCriterion("payBuyerId not in", values, "paybuyerid");
            return (Criteria) this;
        }

        public Criteria andPaybuyeridBetween(Integer value1, Integer value2) {
            addCriterion("payBuyerId between", value1, value2, "paybuyerid");
            return (Criteria) this;
        }

        public Criteria andPaybuyeridNotBetween(Integer value1, Integer value2) {
            addCriterion("payBuyerId not between", value1, value2, "paybuyerid");
            return (Criteria) this;
        }

        public Criteria andPayselleridIsNull() {
            addCriterion("paySellerId is null");
            return (Criteria) this;
        }

        public Criteria andPayselleridIsNotNull() {
            addCriterion("paySellerId is not null");
            return (Criteria) this;
        }

        public Criteria andPayselleridEqualTo(Integer value) {
            addCriterion("paySellerId =", value, "paysellerid");
            return (Criteria) this;
        }

        public Criteria andPayselleridNotEqualTo(Integer value) {
            addCriterion("paySellerId <>", value, "paysellerid");
            return (Criteria) this;
        }

        public Criteria andPayselleridGreaterThan(Integer value) {
            addCriterion("paySellerId >", value, "paysellerid");
            return (Criteria) this;
        }

        public Criteria andPayselleridGreaterThanOrEqualTo(Integer value) {
            addCriterion("paySellerId >=", value, "paysellerid");
            return (Criteria) this;
        }

        public Criteria andPayselleridLessThan(Integer value) {
            addCriterion("paySellerId <", value, "paysellerid");
            return (Criteria) this;
        }

        public Criteria andPayselleridLessThanOrEqualTo(Integer value) {
            addCriterion("paySellerId <=", value, "paysellerid");
            return (Criteria) this;
        }

        public Criteria andPayselleridIn(List<Integer> values) {
            addCriterion("paySellerId in", values, "paysellerid");
            return (Criteria) this;
        }

        public Criteria andPayselleridNotIn(List<Integer> values) {
            addCriterion("paySellerId not in", values, "paysellerid");
            return (Criteria) this;
        }

        public Criteria andPayselleridBetween(Integer value1, Integer value2) {
            addCriterion("paySellerId between", value1, value2, "paysellerid");
            return (Criteria) this;
        }

        public Criteria andPayselleridNotBetween(Integer value1, Integer value2) {
            addCriterion("paySellerId not between", value1, value2, "paysellerid");
            return (Criteria) this;
        }

        public Criteria andPaysellernameIsNull() {
            addCriterion("paySellerName is null");
            return (Criteria) this;
        }

        public Criteria andPaysellernameIsNotNull() {
            addCriterion("paySellerName is not null");
            return (Criteria) this;
        }

        public Criteria andPaysellernameEqualTo(String value) {
            addCriterion("paySellerName =", value, "paysellername");
            return (Criteria) this;
        }

        public Criteria andPaysellernameNotEqualTo(String value) {
            addCriterion("paySellerName <>", value, "paysellername");
            return (Criteria) this;
        }

        public Criteria andPaysellernameGreaterThan(String value) {
            addCriterion("paySellerName >", value, "paysellername");
            return (Criteria) this;
        }

        public Criteria andPaysellernameGreaterThanOrEqualTo(String value) {
            addCriterion("paySellerName >=", value, "paysellername");
            return (Criteria) this;
        }

        public Criteria andPaysellernameLessThan(String value) {
            addCriterion("paySellerName <", value, "paysellername");
            return (Criteria) this;
        }

        public Criteria andPaysellernameLessThanOrEqualTo(String value) {
            addCriterion("paySellerName <=", value, "paysellername");
            return (Criteria) this;
        }

        public Criteria andPaysellernameLike(String value) {
            addCriterion("paySellerName like", value, "paysellername");
            return (Criteria) this;
        }

        public Criteria andPaysellernameNotLike(String value) {
            addCriterion("paySellerName not like", value, "paysellername");
            return (Criteria) this;
        }

        public Criteria andPaysellernameIn(List<String> values) {
            addCriterion("paySellerName in", values, "paysellername");
            return (Criteria) this;
        }

        public Criteria andPaysellernameNotIn(List<String> values) {
            addCriterion("paySellerName not in", values, "paysellername");
            return (Criteria) this;
        }

        public Criteria andPaysellernameBetween(String value1, String value2) {
            addCriterion("paySellerName between", value1, value2, "paysellername");
            return (Criteria) this;
        }

        public Criteria andPaysellernameNotBetween(String value1, String value2) {
            addCriterion("paySellerName not between", value1, value2, "paysellername");
            return (Criteria) this;
        }

        public Criteria andPaytypeidIsNull() {
            addCriterion("payTypeId is null");
            return (Criteria) this;
        }

        public Criteria andPaytypeidIsNotNull() {
            addCriterion("payTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andPaytypeidEqualTo(Integer value) {
            addCriterion("payTypeId =", value, "paytypeid");
            return (Criteria) this;
        }

        public Criteria andPaytypeidNotEqualTo(Integer value) {
            addCriterion("payTypeId <>", value, "paytypeid");
            return (Criteria) this;
        }

        public Criteria andPaytypeidGreaterThan(Integer value) {
            addCriterion("payTypeId >", value, "paytypeid");
            return (Criteria) this;
        }

        public Criteria andPaytypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("payTypeId >=", value, "paytypeid");
            return (Criteria) this;
        }

        public Criteria andPaytypeidLessThan(Integer value) {
            addCriterion("payTypeId <", value, "paytypeid");
            return (Criteria) this;
        }

        public Criteria andPaytypeidLessThanOrEqualTo(Integer value) {
            addCriterion("payTypeId <=", value, "paytypeid");
            return (Criteria) this;
        }

        public Criteria andPaytypeidIn(List<Integer> values) {
            addCriterion("payTypeId in", values, "paytypeid");
            return (Criteria) this;
        }

        public Criteria andPaytypeidNotIn(List<Integer> values) {
            addCriterion("payTypeId not in", values, "paytypeid");
            return (Criteria) this;
        }

        public Criteria andPaytypeidBetween(Integer value1, Integer value2) {
            addCriterion("payTypeId between", value1, value2, "paytypeid");
            return (Criteria) this;
        }

        public Criteria andPaytypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("payTypeId not between", value1, value2, "paytypeid");
            return (Criteria) this;
        }

        public Criteria andPaystateidIsNull() {
            addCriterion("payStateId is null");
            return (Criteria) this;
        }

        public Criteria andPaystateidIsNotNull() {
            addCriterion("payStateId is not null");
            return (Criteria) this;
        }

        public Criteria andPaystateidEqualTo(Integer value) {
            addCriterion("payStateId =", value, "paystateid");
            return (Criteria) this;
        }

        public Criteria andPaystateidNotEqualTo(Integer value) {
            addCriterion("payStateId <>", value, "paystateid");
            return (Criteria) this;
        }

        public Criteria andPaystateidGreaterThan(Integer value) {
            addCriterion("payStateId >", value, "paystateid");
            return (Criteria) this;
        }

        public Criteria andPaystateidGreaterThanOrEqualTo(Integer value) {
            addCriterion("payStateId >=", value, "paystateid");
            return (Criteria) this;
        }

        public Criteria andPaystateidLessThan(Integer value) {
            addCriterion("payStateId <", value, "paystateid");
            return (Criteria) this;
        }

        public Criteria andPaystateidLessThanOrEqualTo(Integer value) {
            addCriterion("payStateId <=", value, "paystateid");
            return (Criteria) this;
        }

        public Criteria andPaystateidIn(List<Integer> values) {
            addCriterion("payStateId in", values, "paystateid");
            return (Criteria) this;
        }

        public Criteria andPaystateidNotIn(List<Integer> values) {
            addCriterion("payStateId not in", values, "paystateid");
            return (Criteria) this;
        }

        public Criteria andPaystateidBetween(Integer value1, Integer value2) {
            addCriterion("payStateId between", value1, value2, "paystateid");
            return (Criteria) this;
        }

        public Criteria andPaystateidNotBetween(Integer value1, Integer value2) {
            addCriterion("payStateId not between", value1, value2, "paystateid");
            return (Criteria) this;
        }

        public Criteria andPaymodeidIsNull() {
            addCriterion("payModeId is null");
            return (Criteria) this;
        }

        public Criteria andPaymodeidIsNotNull() {
            addCriterion("payModeId is not null");
            return (Criteria) this;
        }

        public Criteria andPaymodeidEqualTo(Integer value) {
            addCriterion("payModeId =", value, "paymodeid");
            return (Criteria) this;
        }

        public Criteria andPaymodeidNotEqualTo(Integer value) {
            addCriterion("payModeId <>", value, "paymodeid");
            return (Criteria) this;
        }

        public Criteria andPaymodeidGreaterThan(Integer value) {
            addCriterion("payModeId >", value, "paymodeid");
            return (Criteria) this;
        }

        public Criteria andPaymodeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("payModeId >=", value, "paymodeid");
            return (Criteria) this;
        }

        public Criteria andPaymodeidLessThan(Integer value) {
            addCriterion("payModeId <", value, "paymodeid");
            return (Criteria) this;
        }

        public Criteria andPaymodeidLessThanOrEqualTo(Integer value) {
            addCriterion("payModeId <=", value, "paymodeid");
            return (Criteria) this;
        }

        public Criteria andPaymodeidIn(List<Integer> values) {
            addCriterion("payModeId in", values, "paymodeid");
            return (Criteria) this;
        }

        public Criteria andPaymodeidNotIn(List<Integer> values) {
            addCriterion("payModeId not in", values, "paymodeid");
            return (Criteria) this;
        }

        public Criteria andPaymodeidBetween(Integer value1, Integer value2) {
            addCriterion("payModeId between", value1, value2, "paymodeid");
            return (Criteria) this;
        }

        public Criteria andPaymodeidNotBetween(Integer value1, Integer value2) {
            addCriterion("payModeId not between", value1, value2, "paymodeid");
            return (Criteria) this;
        }

        public Criteria andPayremarkIsNull() {
            addCriterion("payRemark is null");
            return (Criteria) this;
        }

        public Criteria andPayremarkIsNotNull() {
            addCriterion("payRemark is not null");
            return (Criteria) this;
        }

        public Criteria andPayremarkEqualTo(String value) {
            addCriterion("payRemark =", value, "payremark");
            return (Criteria) this;
        }

        public Criteria andPayremarkNotEqualTo(String value) {
            addCriterion("payRemark <>", value, "payremark");
            return (Criteria) this;
        }

        public Criteria andPayremarkGreaterThan(String value) {
            addCriterion("payRemark >", value, "payremark");
            return (Criteria) this;
        }

        public Criteria andPayremarkGreaterThanOrEqualTo(String value) {
            addCriterion("payRemark >=", value, "payremark");
            return (Criteria) this;
        }

        public Criteria andPayremarkLessThan(String value) {
            addCriterion("payRemark <", value, "payremark");
            return (Criteria) this;
        }

        public Criteria andPayremarkLessThanOrEqualTo(String value) {
            addCriterion("payRemark <=", value, "payremark");
            return (Criteria) this;
        }

        public Criteria andPayremarkLike(String value) {
            addCriterion("payRemark like", value, "payremark");
            return (Criteria) this;
        }

        public Criteria andPayremarkNotLike(String value) {
            addCriterion("payRemark not like", value, "payremark");
            return (Criteria) this;
        }

        public Criteria andPayremarkIn(List<String> values) {
            addCriterion("payRemark in", values, "payremark");
            return (Criteria) this;
        }

        public Criteria andPayremarkNotIn(List<String> values) {
            addCriterion("payRemark not in", values, "payremark");
            return (Criteria) this;
        }

        public Criteria andPayremarkBetween(String value1, String value2) {
            addCriterion("payRemark between", value1, value2, "payremark");
            return (Criteria) this;
        }

        public Criteria andPayremarkNotBetween(String value1, String value2) {
            addCriterion("payRemark not between", value1, value2, "payremark");
            return (Criteria) this;
        }

        public Criteria andPaybuyernameIsNull() {
            addCriterion("payBuyerName is null");
            return (Criteria) this;
        }

        public Criteria andPaybuyernameIsNotNull() {
            addCriterion("payBuyerName is not null");
            return (Criteria) this;
        }

        public Criteria andPaybuyernameEqualTo(String value) {
            addCriterion("payBuyerName =", value, "paybuyername");
            return (Criteria) this;
        }

        public Criteria andPaybuyernameNotEqualTo(String value) {
            addCriterion("payBuyerName <>", value, "paybuyername");
            return (Criteria) this;
        }

        public Criteria andPaybuyernameGreaterThan(String value) {
            addCriterion("payBuyerName >", value, "paybuyername");
            return (Criteria) this;
        }

        public Criteria andPaybuyernameGreaterThanOrEqualTo(String value) {
            addCriterion("payBuyerName >=", value, "paybuyername");
            return (Criteria) this;
        }

        public Criteria andPaybuyernameLessThan(String value) {
            addCriterion("payBuyerName <", value, "paybuyername");
            return (Criteria) this;
        }

        public Criteria andPaybuyernameLessThanOrEqualTo(String value) {
            addCriterion("payBuyerName <=", value, "paybuyername");
            return (Criteria) this;
        }

        public Criteria andPaybuyernameLike(String value) {
            addCriterion("payBuyerName like", value, "paybuyername");
            return (Criteria) this;
        }

        public Criteria andPaybuyernameNotLike(String value) {
            addCriterion("payBuyerName not like", value, "paybuyername");
            return (Criteria) this;
        }

        public Criteria andPaybuyernameIn(List<String> values) {
            addCriterion("payBuyerName in", values, "paybuyername");
            return (Criteria) this;
        }

        public Criteria andPaybuyernameNotIn(List<String> values) {
            addCriterion("payBuyerName not in", values, "paybuyername");
            return (Criteria) this;
        }

        public Criteria andPaybuyernameBetween(String value1, String value2) {
            addCriterion("payBuyerName between", value1, value2, "paybuyername");
            return (Criteria) this;
        }

        public Criteria andPaybuyernameNotBetween(String value1, String value2) {
            addCriterion("payBuyerName not between", value1, value2, "paybuyername");
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