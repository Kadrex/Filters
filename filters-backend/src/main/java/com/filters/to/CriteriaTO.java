package com.filters.to;


import com.filters.utils.enums.FilterCondition;
import com.filters.utils.enums.FilterType;

import java.util.UUID;

public class CriteriaTO {

    private UUID id;
    private FilterType filterType;
    private FilterCondition condition;
    private String value;

    private UUID filterId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public FilterType getFilterType() {
        return filterType;
    }

    public void setFilterType(FilterType filterType) {
        this.filterType = filterType;
    }

    public FilterCondition getCondition() {
        return condition;
    }

    public void setCondition(FilterCondition condition) {
        this.condition = condition;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public UUID getFilterId() {
        return filterId;
    }

    public void setFilterId(UUID filterId) {
        this.filterId = filterId;
    }

}
