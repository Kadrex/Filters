package com.filters.to;

import java.util.List;
import java.util.UUID;

public class FilterTO {

    private UUID id;
    private String filterName;
    private List<CriteriaTO> criteria;
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

    public List<CriteriaTO> getCriteria() {
        return criteria;
    }

    public void setCriteria(List<CriteriaTO> criteria) {
        this.criteria = criteria;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

}
