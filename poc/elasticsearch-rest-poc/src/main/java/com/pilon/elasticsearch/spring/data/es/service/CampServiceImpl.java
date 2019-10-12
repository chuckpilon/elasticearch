package com.pilon.elasticsearch.spring.data.es.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pilon.elasticsearch.spring.data.es.model.Camp;
import com.pilon.elasticsearch.spring.data.es.repository.CampRepository;

@Service
public class CampServiceImpl implements CampService {

    private final CampRepository campRepository;
    
    @Autowired
    public CampServiceImpl(CampRepository campRepository) {
        this.campRepository = campRepository;
    }

    @Override
    public Camp save(Camp camp) {
        return campRepository.save(camp);
    }

    @Override
    public Optional<Camp> findOne(String id) {
        return campRepository.findById(id);
    }

    @Override
    public Iterable<Camp> findAll() {
        return campRepository.findAll();
    }

    @Override
    public Page<Camp> findByCostBetween(int lower, int upper, Pageable pageable) {
        return campRepository.findByCostBetween(lower, upper, pageable);
    }

    @Override
    public Page<Camp> findByActivityStartDateBetween(Date activityStartDateFrom, Date activityStartDateTo, Pageable pageable) {
        return campRepository.findByActivityStartDateBetween(activityStartDateFrom, activityStartDateTo, pageable);
    }

    @Override
    public long count() {
        return campRepository.count();
    }

    @Override
    public void delete(Camp camp) {
        campRepository.delete(camp);
    }

}
