package com.filters.utils.mappers;

import com.filters.model.Filter;
import com.filters.to.FilterTO;
import org.springframework.stereotype.Component;

@Component
public class FilterMapper {

    public Filter toEntity(FilterTO filter) {
        Filter entity = new Filter();
        entity.setId(filter.getId());
        entity.setFilterName(filter.getFilterName());
        //entity.setCriteria(filter.getCriteria().stream().map(c -> criteriaMapper.toEntity(c)).collect(Collectors.toList()));
        entity.setSelection(filter.getSelection());
        return entity;
    }

    public FilterTO toTO(Filter entity) {
        FilterTO filter = new FilterTO();
        filter.setId(entity.getId());
        filter.setFilterName(entity.getFilterName());
        filter.setSelection(entity.getSelection());
        //filter.setCriteria(entity.getCriteria().stream().map(c -> criteriaMapper.toTO(c)).collect(Collectors.toList()));
        return filter;
    }
}
