package com.filters.utils.mappers;

import com.filters.model.Criteria;
import com.filters.to.CriteriaTO;
import com.filters.utils.enums.FilterCondition;
import org.springframework.stereotype.Component;

@Component
public class CriteriaMapper {

    public Criteria toEntity(CriteriaTO criteria) {
        Criteria entity = new Criteria();
        entity.setId(criteria.getId());
        entity.setFilterType(criteria.getFilterType());
        entity.setFilterCondition(criteria.getCondition());
        entity.setValue(criteria.getValue());
        entity.setFilterId(criteria.getFilterId());
        return entity;
    }

    public CriteriaTO toTO(Criteria entity) {
        CriteriaTO criteria = new CriteriaTO();
        criteria.setId(entity.getId());
        criteria.setFilterType(entity.getFilterType());
        criteria.setCondition(FilterCondition.valueOf(entity.getFilterCondition().toString()));
        criteria.setValue(entity.getValue());
        return criteria;
    }
}
