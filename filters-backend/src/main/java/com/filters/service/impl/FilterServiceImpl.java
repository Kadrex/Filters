package com.filters.service.impl;


import com.filters.model.Filter;
import com.filters.repository.CriteriaRepository;
import com.filters.repository.FilterRepository;
import com.filters.service.FilterService;
import com.filters.to.FilterTO;
import com.filters.utils.mappers.CriteriaMapper;
import com.filters.utils.mappers.FilterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilterServiceImpl implements FilterService {

    @Autowired
    private FilterRepository filterRepository;

    @Autowired
    private CriteriaRepository criteriaRepository;

    @Autowired
    private FilterMapper filterMapper;

    @Autowired
    private CriteriaMapper criteriaMapper;

    @Override
    public List<FilterTO> getFilters() {
        List<FilterTO> filters = filterRepository.getAll().stream().map(filterMapper::toTO).toList();
        filters.forEach(f -> f.setCriteria(criteriaRepository.getByFilterId(f.getId()).stream().map(criteriaMapper::toTO).collect(Collectors.toList())));
        return filters;
    }

    @Override
    public FilterTO saveFilter(FilterTO filterTO) {
        Filter savedFilter = filterRepository.save(filterMapper.toEntity(filterTO));
        filterTO.getCriteria().forEach(c -> {
            c.setFilterId(savedFilter.getId());
            criteriaRepository.save(criteriaMapper.toEntity(c));
        });
        return filterMapper.toTO(savedFilter);
    }
}
