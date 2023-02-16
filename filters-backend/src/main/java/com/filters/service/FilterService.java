package com.filters.service;


import com.filters.to.FilterTO;

import java.util.List;

public interface FilterService {

    List<FilterTO> getFilters();

    FilterTO saveFilter(FilterTO filterTO);
}
