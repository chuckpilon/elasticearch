package com.pilon.elasticsearch.spring.data.es.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pilon.elasticsearch.spring.data.es.model.Camp;

public interface CampService {
    Camp save(Camp article);

    Optional<Camp> findOne(String id);

    Iterable<Camp> findAll();

    Page<Camp> findByCostBetween(int lower, int upper, Pageable pageable);
    
    Page<Camp> findByActivityStartDateBetween(Date activityStartDateFrom, Date activityStartDateTo, Pageable pageable);

    long count();

    void delete(Camp article);
}
