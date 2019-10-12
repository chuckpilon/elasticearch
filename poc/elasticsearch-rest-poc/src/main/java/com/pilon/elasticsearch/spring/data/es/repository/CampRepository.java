package com.pilon.elasticsearch.spring.data.es.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.pilon.elasticsearch.spring.data.es.model.Camp;

@Repository
public interface CampRepository extends ElasticsearchRepository<Camp, String> {

    @Query("{\"bool\" : {\"must\" : {\"range\" : {\"cost\" : {\"from\" : ?0,\"to\" : ?1,\"include_lower\" : true,\"include_upper\" : true}}}}}")
    Page<Camp> findByCostBetween(int lower, int upper, Pageable pageable);

    @Query("{\"bool\" : {\"must\" : {\"range\" : {\"activityStartDate\" : {\"from\" : \"?0\",\"to\" : \"?1\",\"include_lower\" : true,\"include_upper\" : true}}}}}")
    Page<Camp> findByActivityStartDateBetween(Date activityStartDateFrom, Date activityStartDateTo, Pageable pageable);

}
