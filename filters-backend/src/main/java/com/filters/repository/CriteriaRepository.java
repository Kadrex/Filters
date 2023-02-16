package com.filters.repository;

import com.filters.model.Criteria;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.UUID;

public interface CriteriaRepository extends Repository<Criteria, UUID> {

    void save(Criteria criteria);

    List<Criteria> getByFilterId(UUID filterId);
}
