package com.panglin.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkLineUpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParkLineUpExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andParkIdIsNull() {
            addCriterion("park_id is null");
            return (Criteria) this;
        }

        public Criteria andParkIdIsNotNull() {
            addCriterion("park_id is not null");
            return (Criteria) this;
        }

        public Criteria andParkIdEqualTo(Integer value) {
            addCriterion("park_id =", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotEqualTo(Integer value) {
            addCriterion("park_id <>", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdGreaterThan(Integer value) {
            addCriterion("park_id >", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("park_id >=", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdLessThan(Integer value) {
            addCriterion("park_id <", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdLessThanOrEqualTo(Integer value) {
            addCriterion("park_id <=", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdIn(List<Integer> values) {
            addCriterion("park_id in", values, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotIn(List<Integer> values) {
            addCriterion("park_id not in", values, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdBetween(Integer value1, Integer value2) {
            addCriterion("park_id between", value1, value2, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("park_id not between", value1, value2, "parkId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andIsLineUpIsNull() {
            addCriterion("is_line_up is null");
            return (Criteria) this;
        }

        public Criteria andIsLineUpIsNotNull() {
            addCriterion("is_line_up is not null");
            return (Criteria) this;
        }

        public Criteria andIsLineUpEqualTo(Integer value) {
            addCriterion("is_line_up =", value, "isLineUp");
            return (Criteria) this;
        }

        public Criteria andIsLineUpNotEqualTo(Integer value) {
            addCriterion("is_line_up <>", value, "isLineUp");
            return (Criteria) this;
        }

        public Criteria andIsLineUpGreaterThan(Integer value) {
            addCriterion("is_line_up >", value, "isLineUp");
            return (Criteria) this;
        }

        public Criteria andIsLineUpGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_line_up >=", value, "isLineUp");
            return (Criteria) this;
        }

        public Criteria andIsLineUpLessThan(Integer value) {
            addCriterion("is_line_up <", value, "isLineUp");
            return (Criteria) this;
        }

        public Criteria andIsLineUpLessThanOrEqualTo(Integer value) {
            addCriterion("is_line_up <=", value, "isLineUp");
            return (Criteria) this;
        }

        public Criteria andIsLineUpIn(List<Integer> values) {
            addCriterion("is_line_up in", values, "isLineUp");
            return (Criteria) this;
        }

        public Criteria andIsLineUpNotIn(List<Integer> values) {
            addCriterion("is_line_up not in", values, "isLineUp");
            return (Criteria) this;
        }

        public Criteria andIsLineUpBetween(Integer value1, Integer value2) {
            addCriterion("is_line_up between", value1, value2, "isLineUp");
            return (Criteria) this;
        }

        public Criteria andIsLineUpNotBetween(Integer value1, Integer value2) {
            addCriterion("is_line_up not between", value1, value2, "isLineUp");
            return (Criteria) this;
        }

        public Criteria andLineUpTimeIsNull() {
            addCriterion("line_up_time is null");
            return (Criteria) this;
        }

        public Criteria andLineUpTimeIsNotNull() {
            addCriterion("line_up_time is not null");
            return (Criteria) this;
        }

        public Criteria andLineUpTimeEqualTo(Date value) {
            addCriterion("line_up_time =", value, "lineUpTime");
            return (Criteria) this;
        }

        public Criteria andLineUpTimeNotEqualTo(Date value) {
            addCriterion("line_up_time <>", value, "lineUpTime");
            return (Criteria) this;
        }

        public Criteria andLineUpTimeGreaterThan(Date value) {
            addCriterion("line_up_time >", value, "lineUpTime");
            return (Criteria) this;
        }

        public Criteria andLineUpTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("line_up_time >=", value, "lineUpTime");
            return (Criteria) this;
        }

        public Criteria andLineUpTimeLessThan(Date value) {
            addCriterion("line_up_time <", value, "lineUpTime");
            return (Criteria) this;
        }

        public Criteria andLineUpTimeLessThanOrEqualTo(Date value) {
            addCriterion("line_up_time <=", value, "lineUpTime");
            return (Criteria) this;
        }

        public Criteria andLineUpTimeIn(List<Date> values) {
            addCriterion("line_up_time in", values, "lineUpTime");
            return (Criteria) this;
        }

        public Criteria andLineUpTimeNotIn(List<Date> values) {
            addCriterion("line_up_time not in", values, "lineUpTime");
            return (Criteria) this;
        }

        public Criteria andLineUpTimeBetween(Date value1, Date value2) {
            addCriterion("line_up_time between", value1, value2, "lineUpTime");
            return (Criteria) this;
        }

        public Criteria andLineUpTimeNotBetween(Date value1, Date value2) {
            addCriterion("line_up_time not between", value1, value2, "lineUpTime");
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