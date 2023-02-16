package com.filters.repository;

import com.filters.model.Filter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface FilterRepository extends Repository<Filter, UUID> {

    Filter save(Filter filter);


    @Query("select f from Filter f")
    List<Filter> getAll();
}
