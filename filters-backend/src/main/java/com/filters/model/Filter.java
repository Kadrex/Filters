package com.filters.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Filter {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "filter_name")
    private String filterName;

    //@OneToMany(mappedBy = "filter")
    //private List<Criteria> criteria;

    @Column
    private String selection;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    /*public List<Criteria> getCriteria() {
        return criteria;
    }

    public void setCriteria(List<Criteria> criteria) {
        this.criteria = criteria;
    }*/

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

}
