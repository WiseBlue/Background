package com.wiseblue.bean;

import java.util.ArrayList;
import java.util.List;

public class ActivityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActivityExample() {
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

        public Criteria andActivityIdIsNull() {
            addCriterion("activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(Integer value) {
            addCriterion("activity_id =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(Integer value) {
            addCriterion("activity_id <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(Integer value) {
            addCriterion("activity_id >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_id >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(Integer value) {
            addCriterion("activity_id <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(Integer value) {
            addCriterion("activity_id <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<Integer> values) {
            addCriterion("activity_id in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<Integer> values) {
            addCriterion("activity_id not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(Integer value1, Integer value2) {
            addCriterion("activity_id between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_id not between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityTitleIsNull() {
            addCriterion("activity_title is null");
            return (Criteria) this;
        }

        public Criteria andActivityTitleIsNotNull() {
            addCriterion("activity_title is not null");
            return (Criteria) this;
        }

        public Criteria andActivityTitleEqualTo(String value) {
            addCriterion("activity_title =", value, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleNotEqualTo(String value) {
            addCriterion("activity_title <>", value, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleGreaterThan(String value) {
            addCriterion("activity_title >", value, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleGreaterThanOrEqualTo(String value) {
            addCriterion("activity_title >=", value, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleLessThan(String value) {
            addCriterion("activity_title <", value, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleLessThanOrEqualTo(String value) {
            addCriterion("activity_title <=", value, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleLike(String value) {
            addCriterion("activity_title like", value, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleNotLike(String value) {
            addCriterion("activity_title not like", value, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleIn(List<String> values) {
            addCriterion("activity_title in", values, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleNotIn(List<String> values) {
            addCriterion("activity_title not in", values, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleBetween(String value1, String value2) {
            addCriterion("activity_title between", value1, value2, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleNotBetween(String value1, String value2) {
            addCriterion("activity_title not between", value1, value2, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityPlaceIsNull() {
            addCriterion("activity_place is null");
            return (Criteria) this;
        }

        public Criteria andActivityPlaceIsNotNull() {
            addCriterion("activity_place is not null");
            return (Criteria) this;
        }

        public Criteria andActivityPlaceEqualTo(String value) {
            addCriterion("activity_place =", value, "activityPlace");
            return (Criteria) this;
        }

        public Criteria andActivityPlaceNotEqualTo(String value) {
            addCriterion("activity_place <>", value, "activityPlace");
            return (Criteria) this;
        }

        public Criteria andActivityPlaceGreaterThan(String value) {
            addCriterion("activity_place >", value, "activityPlace");
            return (Criteria) this;
        }

        public Criteria andActivityPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("activity_place >=", value, "activityPlace");
            return (Criteria) this;
        }

        public Criteria andActivityPlaceLessThan(String value) {
            addCriterion("activity_place <", value, "activityPlace");
            return (Criteria) this;
        }

        public Criteria andActivityPlaceLessThanOrEqualTo(String value) {
            addCriterion("activity_place <=", value, "activityPlace");
            return (Criteria) this;
        }

        public Criteria andActivityPlaceLike(String value) {
            addCriterion("activity_place like", value, "activityPlace");
            return (Criteria) this;
        }

        public Criteria andActivityPlaceNotLike(String value) {
            addCriterion("activity_place not like", value, "activityPlace");
            return (Criteria) this;
        }

        public Criteria andActivityPlaceIn(List<String> values) {
            addCriterion("activity_place in", values, "activityPlace");
            return (Criteria) this;
        }

        public Criteria andActivityPlaceNotIn(List<String> values) {
            addCriterion("activity_place not in", values, "activityPlace");
            return (Criteria) this;
        }

        public Criteria andActivityPlaceBetween(String value1, String value2) {
            addCriterion("activity_place between", value1, value2, "activityPlace");
            return (Criteria) this;
        }

        public Criteria andActivityPlaceNotBetween(String value1, String value2) {
            addCriterion("activity_place not between", value1, value2, "activityPlace");
            return (Criteria) this;
        }

        public Criteria andCreateuserIsNull() {
            addCriterion("createUser is null");
            return (Criteria) this;
        }

        public Criteria andCreateuserIsNotNull() {
            addCriterion("createUser is not null");
            return (Criteria) this;
        }

        public Criteria andCreateuserEqualTo(String value) {
            addCriterion("createUser =", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotEqualTo(String value) {
            addCriterion("createUser <>", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThan(String value) {
            addCriterion("createUser >", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("createUser >=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThan(String value) {
            addCriterion("createUser <", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThanOrEqualTo(String value) {
            addCriterion("createUser <=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLike(String value) {
            addCriterion("createUser like", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotLike(String value) {
            addCriterion("createUser not like", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserIn(List<String> values) {
            addCriterion("createUser in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotIn(List<String> values) {
            addCriterion("createUser not in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserBetween(String value1, String value2) {
            addCriterion("createUser between", value1, value2, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotBetween(String value1, String value2) {
            addCriterion("createUser not between", value1, value2, "createuser");
            return (Criteria) this;
        }

        public Criteria andTimestartIsNull() {
            addCriterion("timeStart is null");
            return (Criteria) this;
        }

        public Criteria andTimestartIsNotNull() {
            addCriterion("timeStart is not null");
            return (Criteria) this;
        }

        public Criteria andTimestartEqualTo(String value) {
            addCriterion("timeStart =", value, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimestartNotEqualTo(String value) {
            addCriterion("timeStart <>", value, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimestartGreaterThan(String value) {
            addCriterion("timeStart >", value, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimestartGreaterThanOrEqualTo(String value) {
            addCriterion("timeStart >=", value, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimestartLessThan(String value) {
            addCriterion("timeStart <", value, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimestartLessThanOrEqualTo(String value) {
            addCriterion("timeStart <=", value, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimestartLike(String value) {
            addCriterion("timeStart like", value, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimestartNotLike(String value) {
            addCriterion("timeStart not like", value, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimestartIn(List<String> values) {
            addCriterion("timeStart in", values, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimestartNotIn(List<String> values) {
            addCriterion("timeStart not in", values, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimestartBetween(String value1, String value2) {
            addCriterion("timeStart between", value1, value2, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimestartNotBetween(String value1, String value2) {
            addCriterion("timeStart not between", value1, value2, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimeendIsNull() {
            addCriterion("timeEnd is null");
            return (Criteria) this;
        }

        public Criteria andTimeendIsNotNull() {
            addCriterion("timeEnd is not null");
            return (Criteria) this;
        }

        public Criteria andTimeendEqualTo(String value) {
            addCriterion("timeEnd =", value, "timeend");
            return (Criteria) this;
        }

        public Criteria andTimeendNotEqualTo(String value) {
            addCriterion("timeEnd <>", value, "timeend");
            return (Criteria) this;
        }

        public Criteria andTimeendGreaterThan(String value) {
            addCriterion("timeEnd >", value, "timeend");
            return (Criteria) this;
        }

        public Criteria andTimeendGreaterThanOrEqualTo(String value) {
            addCriterion("timeEnd >=", value, "timeend");
            return (Criteria) this;
        }

        public Criteria andTimeendLessThan(String value) {
            addCriterion("timeEnd <", value, "timeend");
            return (Criteria) this;
        }

        public Criteria andTimeendLessThanOrEqualTo(String value) {
            addCriterion("timeEnd <=", value, "timeend");
            return (Criteria) this;
        }

        public Criteria andTimeendLike(String value) {
            addCriterion("timeEnd like", value, "timeend");
            return (Criteria) this;
        }

        public Criteria andTimeendNotLike(String value) {
            addCriterion("timeEnd not like", value, "timeend");
            return (Criteria) this;
        }

        public Criteria andTimeendIn(List<String> values) {
            addCriterion("timeEnd in", values, "timeend");
            return (Criteria) this;
        }

        public Criteria andTimeendNotIn(List<String> values) {
            addCriterion("timeEnd not in", values, "timeend");
            return (Criteria) this;
        }

        public Criteria andTimeendBetween(String value1, String value2) {
            addCriterion("timeEnd between", value1, value2, "timeend");
            return (Criteria) this;
        }

        public Criteria andTimeendNotBetween(String value1, String value2) {
            addCriterion("timeEnd not between", value1, value2, "timeend");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNull() {
            addCriterion("introduction is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("introduction is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("introduction =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("introduction <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("introduction >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("introduction >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("introduction <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("introduction <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("introduction like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("introduction not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("introduction in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("introduction not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("introduction not between", value1, value2, "introduction");
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