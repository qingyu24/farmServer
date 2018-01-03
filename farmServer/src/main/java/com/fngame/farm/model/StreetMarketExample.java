package com.fngame.farm.model;

import java.util.ArrayList;
import java.util.List;

public class StreetMarketExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StreetMarketExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Long value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Long value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Long value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Long value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Long value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Long> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Long> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Long value1, Long value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Long value1, Long value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andBaseidIsNull() {
            addCriterion("baseid is null");
            return (Criteria) this;
        }

        public Criteria andBaseidIsNotNull() {
            addCriterion("baseid is not null");
            return (Criteria) this;
        }

        public Criteria andBaseidEqualTo(Integer value) {
            addCriterion("baseid =", value, "baseid");
            return (Criteria) this;
        }

        public Criteria andBaseidNotEqualTo(Integer value) {
            addCriterion("baseid <>", value, "baseid");
            return (Criteria) this;
        }

        public Criteria andBaseidGreaterThan(Integer value) {
            addCriterion("baseid >", value, "baseid");
            return (Criteria) this;
        }

        public Criteria andBaseidGreaterThanOrEqualTo(Integer value) {
            addCriterion("baseid >=", value, "baseid");
            return (Criteria) this;
        }

        public Criteria andBaseidLessThan(Integer value) {
            addCriterion("baseid <", value, "baseid");
            return (Criteria) this;
        }

        public Criteria andBaseidLessThanOrEqualTo(Integer value) {
            addCriterion("baseid <=", value, "baseid");
            return (Criteria) this;
        }

        public Criteria andBaseidIn(List<Integer> values) {
            addCriterion("baseid in", values, "baseid");
            return (Criteria) this;
        }

        public Criteria andBaseidNotIn(List<Integer> values) {
            addCriterion("baseid not in", values, "baseid");
            return (Criteria) this;
        }

        public Criteria andBaseidBetween(Integer value1, Integer value2) {
            addCriterion("baseid between", value1, value2, "baseid");
            return (Criteria) this;
        }

        public Criteria andBaseidNotBetween(Integer value1, Integer value2) {
            addCriterion("baseid not between", value1, value2, "baseid");
            return (Criteria) this;
        }

        public Criteria andOnshelfnumIsNull() {
            addCriterion("onshelfnum is null");
            return (Criteria) this;
        }

        public Criteria andOnshelfnumIsNotNull() {
            addCriterion("onshelfnum is not null");
            return (Criteria) this;
        }

        public Criteria andOnshelfnumEqualTo(Integer value) {
            addCriterion("onshelfnum =", value, "onshelfnum");
            return (Criteria) this;
        }

        public Criteria andOnshelfnumNotEqualTo(Integer value) {
            addCriterion("onshelfnum <>", value, "onshelfnum");
            return (Criteria) this;
        }

        public Criteria andOnshelfnumGreaterThan(Integer value) {
            addCriterion("onshelfnum >", value, "onshelfnum");
            return (Criteria) this;
        }

        public Criteria andOnshelfnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("onshelfnum >=", value, "onshelfnum");
            return (Criteria) this;
        }

        public Criteria andOnshelfnumLessThan(Integer value) {
            addCriterion("onshelfnum <", value, "onshelfnum");
            return (Criteria) this;
        }

        public Criteria andOnshelfnumLessThanOrEqualTo(Integer value) {
            addCriterion("onshelfnum <=", value, "onshelfnum");
            return (Criteria) this;
        }

        public Criteria andOnshelfnumIn(List<Integer> values) {
            addCriterion("onshelfnum in", values, "onshelfnum");
            return (Criteria) this;
        }

        public Criteria andOnshelfnumNotIn(List<Integer> values) {
            addCriterion("onshelfnum not in", values, "onshelfnum");
            return (Criteria) this;
        }

        public Criteria andOnshelfnumBetween(Integer value1, Integer value2) {
            addCriterion("onshelfnum between", value1, value2, "onshelfnum");
            return (Criteria) this;
        }

        public Criteria andOnshelfnumNotBetween(Integer value1, Integer value2) {
            addCriterion("onshelfnum not between", value1, value2, "onshelfnum");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Integer value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Integer value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Integer value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Integer value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Integer value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Integer> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Integer> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Integer value1, Integer value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andIsselloffIsNull() {
            addCriterion("isselloff is null");
            return (Criteria) this;
        }

        public Criteria andIsselloffIsNotNull() {
            addCriterion("isselloff is not null");
            return (Criteria) this;
        }

        public Criteria andIsselloffEqualTo(Integer value) {
            addCriterion("isselloff =", value, "isselloff");
            return (Criteria) this;
        }

        public Criteria andIsselloffNotEqualTo(Integer value) {
            addCriterion("isselloff <>", value, "isselloff");
            return (Criteria) this;
        }

        public Criteria andIsselloffGreaterThan(Integer value) {
            addCriterion("isselloff >", value, "isselloff");
            return (Criteria) this;
        }

        public Criteria andIsselloffGreaterThanOrEqualTo(Integer value) {
            addCriterion("isselloff >=", value, "isselloff");
            return (Criteria) this;
        }

        public Criteria andIsselloffLessThan(Integer value) {
            addCriterion("isselloff <", value, "isselloff");
            return (Criteria) this;
        }

        public Criteria andIsselloffLessThanOrEqualTo(Integer value) {
            addCriterion("isselloff <=", value, "isselloff");
            return (Criteria) this;
        }

        public Criteria andIsselloffIn(List<Integer> values) {
            addCriterion("isselloff in", values, "isselloff");
            return (Criteria) this;
        }

        public Criteria andIsselloffNotIn(List<Integer> values) {
            addCriterion("isselloff not in", values, "isselloff");
            return (Criteria) this;
        }

        public Criteria andIsselloffBetween(Integer value1, Integer value2) {
            addCriterion("isselloff between", value1, value2, "isselloff");
            return (Criteria) this;
        }

        public Criteria andIsselloffNotBetween(Integer value1, Integer value2) {
            addCriterion("isselloff not between", value1, value2, "isselloff");
            return (Criteria) this;
        }

        public Criteria andStallnumberIsNull() {
            addCriterion("stallnumber is null");
            return (Criteria) this;
        }

        public Criteria andStallnumberIsNotNull() {
            addCriterion("stallnumber is not null");
            return (Criteria) this;
        }

        public Criteria andStallnumberEqualTo(Integer value) {
            addCriterion("stallnumber =", value, "stallnumber");
            return (Criteria) this;
        }

        public Criteria andStallnumberNotEqualTo(Integer value) {
            addCriterion("stallnumber <>", value, "stallnumber");
            return (Criteria) this;
        }

        public Criteria andStallnumberGreaterThan(Integer value) {
            addCriterion("stallnumber >", value, "stallnumber");
            return (Criteria) this;
        }

        public Criteria andStallnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("stallnumber >=", value, "stallnumber");
            return (Criteria) this;
        }

        public Criteria andStallnumberLessThan(Integer value) {
            addCriterion("stallnumber <", value, "stallnumber");
            return (Criteria) this;
        }

        public Criteria andStallnumberLessThanOrEqualTo(Integer value) {
            addCriterion("stallnumber <=", value, "stallnumber");
            return (Criteria) this;
        }

        public Criteria andStallnumberIn(List<Integer> values) {
            addCriterion("stallnumber in", values, "stallnumber");
            return (Criteria) this;
        }

        public Criteria andStallnumberNotIn(List<Integer> values) {
            addCriterion("stallnumber not in", values, "stallnumber");
            return (Criteria) this;
        }

        public Criteria andStallnumberBetween(Integer value1, Integer value2) {
            addCriterion("stallnumber between", value1, value2, "stallnumber");
            return (Criteria) this;
        }

        public Criteria andStallnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("stallnumber not between", value1, value2, "stallnumber");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Integer value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Integer value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Integer value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Integer value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Integer value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Integer> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Integer> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Integer value1, Integer value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("flag not between", value1, value2, "flag");
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