package com.fngame.farm.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PetDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PetDataExample() {
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andBegintimeIsNull() {
            addCriterion("begintime is null");
            return (Criteria) this;
        }

        public Criteria andBegintimeIsNotNull() {
            addCriterion("begintime is not null");
            return (Criteria) this;
        }

        public Criteria andBegintimeEqualTo(Date value) {
            addCriterion("begintime =", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeNotEqualTo(Date value) {
            addCriterion("begintime <>", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeGreaterThan(Date value) {
            addCriterion("begintime >", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeGreaterThanOrEqualTo(Date value) {
            addCriterion("begintime >=", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeLessThan(Date value) {
            addCriterion("begintime <", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeLessThanOrEqualTo(Date value) {
            addCriterion("begintime <=", value, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeIn(List<Date> values) {
            addCriterion("begintime in", values, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeNotIn(List<Date> values) {
            addCriterion("begintime not in", values, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeBetween(Date value1, Date value2) {
            addCriterion("begintime between", value1, value2, "begintime");
            return (Criteria) this;
        }

        public Criteria andBegintimeNotBetween(Date value1, Date value2) {
            addCriterion("begintime not between", value1, value2, "begintime");
            return (Criteria) this;
        }

        public Criteria andTargetidIsNull() {
            addCriterion("targetid is null");
            return (Criteria) this;
        }

        public Criteria andTargetidIsNotNull() {
            addCriterion("targetid is not null");
            return (Criteria) this;
        }

        public Criteria andTargetidEqualTo(Long value) {
            addCriterion("targetid =", value, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidNotEqualTo(Long value) {
            addCriterion("targetid <>", value, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidGreaterThan(Long value) {
            addCriterion("targetid >", value, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidGreaterThanOrEqualTo(Long value) {
            addCriterion("targetid >=", value, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidLessThan(Long value) {
            addCriterion("targetid <", value, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidLessThanOrEqualTo(Long value) {
            addCriterion("targetid <=", value, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidIn(List<Long> values) {
            addCriterion("targetid in", values, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidNotIn(List<Long> values) {
            addCriterion("targetid not in", values, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidBetween(Long value1, Long value2) {
            addCriterion("targetid between", value1, value2, "targetid");
            return (Criteria) this;
        }

        public Criteria andTargetidNotBetween(Long value1, Long value2) {
            addCriterion("targetid not between", value1, value2, "targetid");
            return (Criteria) this;
        }

        public Criteria andSkillstatusIsNull() {
            addCriterion("skillstatus is null");
            return (Criteria) this;
        }

        public Criteria andSkillstatusIsNotNull() {
            addCriterion("skillstatus is not null");
            return (Criteria) this;
        }

        public Criteria andSkillstatusEqualTo(Integer value) {
            addCriterion("skillstatus =", value, "skillstatus");
            return (Criteria) this;
        }

        public Criteria andSkillstatusNotEqualTo(Integer value) {
            addCriterion("skillstatus <>", value, "skillstatus");
            return (Criteria) this;
        }

        public Criteria andSkillstatusGreaterThan(Integer value) {
            addCriterion("skillstatus >", value, "skillstatus");
            return (Criteria) this;
        }

        public Criteria andSkillstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("skillstatus >=", value, "skillstatus");
            return (Criteria) this;
        }

        public Criteria andSkillstatusLessThan(Integer value) {
            addCriterion("skillstatus <", value, "skillstatus");
            return (Criteria) this;
        }

        public Criteria andSkillstatusLessThanOrEqualTo(Integer value) {
            addCriterion("skillstatus <=", value, "skillstatus");
            return (Criteria) this;
        }

        public Criteria andSkillstatusIn(List<Integer> values) {
            addCriterion("skillstatus in", values, "skillstatus");
            return (Criteria) this;
        }

        public Criteria andSkillstatusNotIn(List<Integer> values) {
            addCriterion("skillstatus not in", values, "skillstatus");
            return (Criteria) this;
        }

        public Criteria andSkillstatusBetween(Integer value1, Integer value2) {
            addCriterion("skillstatus between", value1, value2, "skillstatus");
            return (Criteria) this;
        }

        public Criteria andSkillstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("skillstatus not between", value1, value2, "skillstatus");
            return (Criteria) this;
        }

        public Criteria andPropsidIsNull() {
            addCriterion("propsid is null");
            return (Criteria) this;
        }

        public Criteria andPropsidIsNotNull() {
            addCriterion("propsid is not null");
            return (Criteria) this;
        }

        public Criteria andPropsidEqualTo(Integer value) {
            addCriterion("propsid =", value, "propsid");
            return (Criteria) this;
        }

        public Criteria andPropsidNotEqualTo(Integer value) {
            addCriterion("propsid <>", value, "propsid");
            return (Criteria) this;
        }

        public Criteria andPropsidGreaterThan(Integer value) {
            addCriterion("propsid >", value, "propsid");
            return (Criteria) this;
        }

        public Criteria andPropsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("propsid >=", value, "propsid");
            return (Criteria) this;
        }

        public Criteria andPropsidLessThan(Integer value) {
            addCriterion("propsid <", value, "propsid");
            return (Criteria) this;
        }

        public Criteria andPropsidLessThanOrEqualTo(Integer value) {
            addCriterion("propsid <=", value, "propsid");
            return (Criteria) this;
        }

        public Criteria andPropsidIn(List<Integer> values) {
            addCriterion("propsid in", values, "propsid");
            return (Criteria) this;
        }

        public Criteria andPropsidNotIn(List<Integer> values) {
            addCriterion("propsid not in", values, "propsid");
            return (Criteria) this;
        }

        public Criteria andPropsidBetween(Integer value1, Integer value2) {
            addCriterion("propsid between", value1, value2, "propsid");
            return (Criteria) this;
        }

        public Criteria andPropsidNotBetween(Integer value1, Integer value2) {
            addCriterion("propsid not between", value1, value2, "propsid");
            return (Criteria) this;
        }

        public Criteria andSkillidIsNull() {
            addCriterion("skillid is null");
            return (Criteria) this;
        }

        public Criteria andSkillidIsNotNull() {
            addCriterion("skillid is not null");
            return (Criteria) this;
        }

        public Criteria andSkillidEqualTo(Integer value) {
            addCriterion("skillid =", value, "skillid");
            return (Criteria) this;
        }

        public Criteria andSkillidNotEqualTo(Integer value) {
            addCriterion("skillid <>", value, "skillid");
            return (Criteria) this;
        }

        public Criteria andSkillidGreaterThan(Integer value) {
            addCriterion("skillid >", value, "skillid");
            return (Criteria) this;
        }

        public Criteria andSkillidGreaterThanOrEqualTo(Integer value) {
            addCriterion("skillid >=", value, "skillid");
            return (Criteria) this;
        }

        public Criteria andSkillidLessThan(Integer value) {
            addCriterion("skillid <", value, "skillid");
            return (Criteria) this;
        }

        public Criteria andSkillidLessThanOrEqualTo(Integer value) {
            addCriterion("skillid <=", value, "skillid");
            return (Criteria) this;
        }

        public Criteria andSkillidIn(List<Integer> values) {
            addCriterion("skillid in", values, "skillid");
            return (Criteria) this;
        }

        public Criteria andSkillidNotIn(List<Integer> values) {
            addCriterion("skillid not in", values, "skillid");
            return (Criteria) this;
        }

        public Criteria andSkillidBetween(Integer value1, Integer value2) {
            addCriterion("skillid between", value1, value2, "skillid");
            return (Criteria) this;
        }

        public Criteria andSkillidNotBetween(Integer value1, Integer value2) {
            addCriterion("skillid not between", value1, value2, "skillid");
            return (Criteria) this;
        }

        public Criteria andPropscountIsNull() {
            addCriterion("propscount is null");
            return (Criteria) this;
        }

        public Criteria andPropscountIsNotNull() {
            addCriterion("propscount is not null");
            return (Criteria) this;
        }

        public Criteria andPropscountEqualTo(Integer value) {
            addCriterion("propscount =", value, "propscount");
            return (Criteria) this;
        }

        public Criteria andPropscountNotEqualTo(Integer value) {
            addCriterion("propscount <>", value, "propscount");
            return (Criteria) this;
        }

        public Criteria andPropscountGreaterThan(Integer value) {
            addCriterion("propscount >", value, "propscount");
            return (Criteria) this;
        }

        public Criteria andPropscountGreaterThanOrEqualTo(Integer value) {
            addCriterion("propscount >=", value, "propscount");
            return (Criteria) this;
        }

        public Criteria andPropscountLessThan(Integer value) {
            addCriterion("propscount <", value, "propscount");
            return (Criteria) this;
        }

        public Criteria andPropscountLessThanOrEqualTo(Integer value) {
            addCriterion("propscount <=", value, "propscount");
            return (Criteria) this;
        }

        public Criteria andPropscountIn(List<Integer> values) {
            addCriterion("propscount in", values, "propscount");
            return (Criteria) this;
        }

        public Criteria andPropscountNotIn(List<Integer> values) {
            addCriterion("propscount not in", values, "propscount");
            return (Criteria) this;
        }

        public Criteria andPropscountBetween(Integer value1, Integer value2) {
            addCriterion("propscount between", value1, value2, "propscount");
            return (Criteria) this;
        }

        public Criteria andPropscountNotBetween(Integer value1, Integer value2) {
            addCriterion("propscount not between", value1, value2, "propscount");
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