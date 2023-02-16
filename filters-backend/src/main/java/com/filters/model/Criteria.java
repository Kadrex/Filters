package com.filters.model;

import com.filters.utils.enums.FilterCondition;
import com.filters.utils.enums.FilterType;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Criteria {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "filter_type")
    private FilterType filterType;

    @Column(name = "filter_condition")
    private FilterCondition filterCondition;

    @Column
    private String value;

    //@ManyToOne
    //@JoinColumn(name = "filter_id", referencedColumnName = "id")
    //private Filter filter;

    @Column(name = "filter_id")
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

    public FilterCondition getFilterCondition() {
        return filterCondition;
    }

    public void setFilterCondition(FilterCondition condition) {
        this.filterCondition = condition;
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
