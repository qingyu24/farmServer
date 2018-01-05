package com.fngame.farm.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BuildingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BuildingExample() {
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

        public Criteria andDirIsNull() {
            addCriterion("dir is null");
            return (Criteria) this;
        }

        public Criteria andDirIsNotNull() {
            addCriterion("dir is not null");
            return (Criteria) this;
        }

        public Criteria andDirEqualTo(Integer value) {
            addCriterion("dir =", value, "dir");
            return (Criteria) this;
        }

        public Criteria andDirNotEqualTo(Integer value) {
            addCriterion("dir <>", value, "dir");
            return (Criteria) this;
        }

        public Criteria andDirGreaterThan(Integer value) {
            addCriterion("dir >", value, "dir");
            return (Criteria) this;
        }

        public Criteria andDirGreaterThanOrEqualTo(Integer value) {
            addCriterion("dir >=", value, "dir");
            return (Criteria) this;
        }

        public Criteria andDirLessThan(Integer value) {
            addCriterion("dir <", value, "dir");
            return (Criteria) this;
        }

        public Criteria andDirLessThanOrEqualTo(Integer value) {
            addCriterion("dir <=", value, "dir");
            return (Criteria) this;
        }

        public Criteria andDirIn(List<Integer> values) {
            addCriterion("dir in", values, "dir");
            return (Criteria) this;
        }

        public Criteria andDirNotIn(List<Integer> values) {
            addCriterion("dir not in", values, "dir");
            return (Criteria) this;
        }

        public Criteria andDirBetween(Integer value1, Integer value2) {
            addCriterion("dir between", value1, value2, "dir");
            return (Criteria) this;
        }

        public Criteria andDirNotBetween(Integer value1, Integer value2) {
            addCriterion("dir not between", value1, value2, "dir");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Date value) {
            addCriterion("begin_time =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Date value) {
            addCriterion("begin_time <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Date value) {
            addCriterion("begin_time >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("begin_time >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Date value) {
            addCriterion("begin_time <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("begin_time <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Date> values) {
            addCriterion("begin_time in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Date> values) {
            addCriterion("begin_time not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Date value1, Date value2) {
            addCriterion("begin_time between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("begin_time not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andXposIsNull() {
            addCriterion("xpos is null");
            return (Criteria) this;
        }

        public Criteria andXposIsNotNull() {
            addCriterion("xpos is not null");
            return (Criteria) this;
        }

        public Criteria andXposEqualTo(Integer value) {
            addCriterion("xpos =", value, "xpos");
            return (Criteria) this;
        }

        public Criteria andXposNotEqualTo(Integer value) {
            addCriterion("xpos <>", value, "xpos");
            return (Criteria) this;
        }

        public Criteria andXposGreaterThan(Integer value) {
            addCriterion("xpos >", value, "xpos");
            return (Criteria) this;
        }

        public Criteria andXposGreaterThanOrEqualTo(Integer value) {
            addCriterion("xpos >=", value, "xpos");
            return (Criteria) this;
        }

        public Criteria andXposLessThan(Integer value) {
            addCriterion("xpos <", value, "xpos");
            return (Criteria) this;
        }

        public Criteria andXposLessThanOrEqualTo(Integer value) {
            addCriterion("xpos <=", value, "xpos");
            return (Criteria) this;
        }

        public Criteria andXposIn(List<Integer> values) {
            addCriterion("xpos in", values, "xpos");
            return (Criteria) this;
        }

        public Criteria andXposNotIn(List<Integer> values) {
            addCriterion("xpos not in", values, "xpos");
            return (Criteria) this;
        }

        public Criteria andXposBetween(Integer value1, Integer value2) {
            addCriterion("xpos between", value1, value2, "xpos");
            return (Criteria) this;
        }

        public Criteria andXposNotBetween(Integer value1, Integer value2) {
            addCriterion("xpos not between", value1, value2, "xpos");
            return (Criteria) this;
        }

        public Criteria andYposIsNull() {
            addCriterion("ypos is null");
            return (Criteria) this;
        }

        public Criteria andYposIsNotNull() {
            addCriterion("ypos is not null");
            return (Criteria) this;
        }

        public Criteria andYposEqualTo(Integer value) {
            addCriterion("ypos =", value, "ypos");
            return (Criteria) this;
        }

        public Criteria andYposNotEqualTo(Integer value) {
            addCriterion("ypos <>", value, "ypos");
            return (Criteria) this;
        }

        public Criteria andYposGreaterThan(Integer value) {
            addCriterion("ypos >", value, "ypos");
            return (Criteria) this;
        }

        public Criteria andYposGreaterThanOrEqualTo(Integer value) {
            addCriterion("ypos >=", value, "ypos");
            return (Criteria) this;
        }

        public Criteria andYposLessThan(Integer value) {
            addCriterion("ypos <", value, "ypos");
            return (Criteria) this;
        }

        public Criteria andYposLessThanOrEqualTo(Integer value) {
            addCriterion("ypos <=", value, "ypos");
            return (Criteria) this;
        }

        public Criteria andYposIn(List<Integer> values) {
            addCriterion("ypos in", values, "ypos");
            return (Criteria) this;
        }

        public Criteria andYposNotIn(List<Integer> values) {
            addCriterion("ypos not in", values, "ypos");
            return (Criteria) this;
        }

        public Criteria andYposBetween(Integer value1, Integer value2) {
            addCriterion("ypos between", value1, value2, "ypos");
            return (Criteria) this;
        }

        public Criteria andYposNotBetween(Integer value1, Integer value2) {
            addCriterion("ypos not between", value1, value2, "ypos");
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

        public Criteria andOwneridEqualTo(Long value) {
            addCriterion("ownerid =", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridNotEqualTo(Long value) {
            addCriterion("ownerid <>", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridGreaterThan(Long value) {
            addCriterion("ownerid >", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridGreaterThanOrEqualTo(Long value) {
            addCriterion("ownerid >=", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridLessThan(Long value) {
            addCriterion("ownerid <", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridLessThanOrEqualTo(Long value) {
            addCriterion("ownerid <=", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridIn(List<Long> values) {
            addCriterion("ownerid in", values, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridNotIn(List<Long> values) {
            addCriterion("ownerid not in", values, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridBetween(Long value1, Long value2) {
            addCriterion("ownerid between", value1, value2, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridNotBetween(Long value1, Long value2) {
            addCriterion("ownerid not between", value1, value2, "ownerid");
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