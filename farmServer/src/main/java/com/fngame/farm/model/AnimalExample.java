package com.fngame.farm.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnimalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnimalExample() {
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

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Integer> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Integer> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("count not between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andWarehouseIsNull() {
            addCriterion("warehouse is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseIsNotNull() {
            addCriterion("warehouse is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseEqualTo(Integer value) {
            addCriterion("warehouse =", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseNotEqualTo(Integer value) {
            addCriterion("warehouse <>", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseGreaterThan(Integer value) {
            addCriterion("warehouse >", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseGreaterThanOrEqualTo(Integer value) {
            addCriterion("warehouse >=", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseLessThan(Integer value) {
            addCriterion("warehouse <", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseLessThanOrEqualTo(Integer value) {
            addCriterion("warehouse <=", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseIn(List<Integer> values) {
            addCriterion("warehouse in", values, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseNotIn(List<Integer> values) {
            addCriterion("warehouse not in", values, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseBetween(Integer value1, Integer value2) {
            addCriterion("warehouse between", value1, value2, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseNotBetween(Integer value1, Integer value2) {
            addCriterion("warehouse not between", value1, value2, "warehouse");
            return (Criteria) this;
        }

        public Criteria andOwneridIsNull() {
            addCriterion("ownerid is null");
            return (Criteria) this;
        }

        public Criteria andOwneridIsNotNull() {
            addCriterion("ownerid is not null");
            return (Criteria) this;
        }

        public Criteria andOwneridEqualTo(Integer value) {
            addCriterion("ownerid =", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridNotEqualTo(Integer value) {
            addCriterion("ownerid <>", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridGreaterThan(Integer value) {
            addCriterion("ownerid >", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridGreaterThanOrEqualTo(Integer value) {
            addCriterion("ownerid >=", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridLessThan(Integer value) {
            addCriterion("ownerid <", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridLessThanOrEqualTo(Integer value) {
            addCriterion("ownerid <=", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridIn(List<Integer> values) {
            addCriterion("ownerid in", values, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridNotIn(List<Integer> values) {
            addCriterion("ownerid not in", values, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridBetween(Integer value1, Integer value2) {
            addCriterion("ownerid between", value1, value2, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridNotBetween(Integer value1, Integer value2) {
            addCriterion("ownerid not between", value1, value2, "ownerid");
            return (Criteria) this;
        }

        public Criteria andFeedtimeIsNull() {
            addCriterion("feedtime is null");
            return (Criteria) this;
        }

        public Criteria andFeedtimeIsNotNull() {
            addCriterion("feedtime is not null");
            return (Criteria) this;
        }

        public Criteria andFeedtimeEqualTo(Date value) {
            addCriterion("feedtime =", value, "feedtime");
            return (Criteria) this;
        }

        public Criteria andFeedtimeNotEqualTo(Date value) {
            addCriterion("feedtime <>", value, "feedtime");
            return (Criteria) this;
        }

        public Criteria andFeedtimeGreaterThan(Date value) {
            addCriterion("feedtime >", value, "feedtime");
            return (Criteria) this;
        }

        public Criteria andFeedtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("feedtime >=", value, "feedtime");
            return (Criteria) this;
        }

        public Criteria andFeedtimeLessThan(Date value) {
            addCriterion("feedtime <", value, "feedtime");
            return (Criteria) this;
        }

        public Criteria andFeedtimeLessThanOrEqualTo(Date value) {
            addCriterion("feedtime <=", value, "feedtime");
            return (Criteria) this;
        }

        public Criteria andFeedtimeIn(List<Date> values) {
            addCriterion("feedtime in", values, "feedtime");
            return (Criteria) this;
        }

        public Criteria andFeedtimeNotIn(List<Date> values) {
            addCriterion("feedtime not in", values, "feedtime");
            return (Criteria) this;
        }

        public Criteria andFeedtimeBetween(Date value1, Date value2) {
            addCriterion("feedtime between", value1, value2, "feedtime");
            return (Criteria) this;
        }

        public Criteria andFeedtimeNotBetween(Date value1, Date value2) {
            addCriterion("feedtime not between", value1, value2, "feedtime");
            return (Criteria) this;
        }

        public Criteria andCanreapIsNull() {
            addCriterion("canreap is null");
            return (Criteria) this;
        }

        public Criteria andCanreapIsNotNull() {
            addCriterion("canreap is not null");
            return (Criteria) this;
        }

        public Criteria andCanreapEqualTo(Integer value) {
            addCriterion("canreap =", value, "canreap");
            return (Criteria) this;
        }

        public Criteria andCanreapNotEqualTo(Integer value) {
            addCriterion("canreap <>", value, "canreap");
            return (Criteria) this;
        }

        public Criteria andCanreapGreaterThan(Integer value) {
            addCriterion("canreap >", value, "canreap");
            return (Criteria) this;
        }

        public Criteria andCanreapGreaterThanOrEqualTo(Integer value) {
            addCriterion("canreap >=", value, "canreap");
            return (Criteria) this;
        }

        public Criteria andCanreapLessThan(Integer value) {
            addCriterion("canreap <", value, "canreap");
            return (Criteria) this;
        }

        public Criteria andCanreapLessThanOrEqualTo(Integer value) {
            addCriterion("canreap <=", value, "canreap");
            return (Criteria) this;
        }

        public Criteria andCanreapIn(List<Integer> values) {
            addCriterion("canreap in", values, "canreap");
            return (Criteria) this;
        }

        public Criteria andCanreapNotIn(List<Integer> values) {
            addCriterion("canreap not in", values, "canreap");
            return (Criteria) this;
        }

        public Criteria andCanreapBetween(Integer value1, Integer value2) {
            addCriterion("canreap between", value1, value2, "canreap");
            return (Criteria) this;
        }

        public Criteria andCanreapNotBetween(Integer value1, Integer value2) {
            addCriterion("canreap not between", value1, value2, "canreap");
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