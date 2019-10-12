package com.pilon.elasticsearch.controller;

import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pilon.elasticsearch.spring.data.es.model.Camp;
import com.pilon.elasticsearch.spring.data.es.service.CampService;

@RestController
@RequestMapping("/")
public class ElasticSearchController {

    private static final Logger logger = LoggerFactory.getLogger(ElasticSearchController.class);

    @Autowired
    CampService campService;

    ObjectMapper mapper;

    @Autowired
    public ElasticSearchController(final HttpServletRequest request) {

        // this.request = request;
        logger.info("Constructing ElasticSearchController");

        mapper = new ObjectMapper();
        mapper.setDateFormat(new StdDateFormat());
    }

    @GetMapping(value = "/camps/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> lookupById(@PathVariable("id") final String id) {
        logger.info("Looking up camp " + id + ".");
        Optional<Camp> camp = campService.findOne(id);
        if (camp.isPresent()) {
            try {
                String json = mapper.writeValueAsString(camp.get());
                return ResponseEntity.ok().body(json);
            } catch (JsonProcessingException jpe) {
                logger.error(jpe.getLocalizedMessage(), jpe);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/camps", produces = { MediaType.APPLICATION_JSON_VALUE }) 
    public ResponseEntity<String> lookupAllCamps() {
        logger.info("Looking up all camps.");
        Iterable<Camp> camps = campService.findAll();
        try {
            String json = mapper.writeValueAsString(camps);
            return ResponseEntity.ok().body(json);
        } catch (JsonProcessingException jpe) {
            logger.error(jpe.getLocalizedMessage(), jpe);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/camps/cost", produces = { MediaType.APPLICATION_JSON_VALUE }) 
    public ResponseEntity<String> lookupByCostBetween() {
        logger.info("Looking up camps with cost between 0 and 500.");
        Iterable<Camp> camps = campService.findByCostBetween(0, 500, Pageable.unpaged());
        try {
            String json = mapper.writeValueAsString(camps);
            return ResponseEntity.ok().body(json);
        } catch (JsonProcessingException jpe) {
            logger.error(jpe.getLocalizedMessage(), jpe);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    
    @GetMapping(value = "/camps/startdate", produces = { MediaType.APPLICATION_JSON_VALUE }) 
    public ResponseEntity<String> lookupByActivityStartDateBetween(
        @RequestParam(value="from") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") Date activityStartDateFrom, 
        @RequestParam(value="to") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") Date activityStartDateTo) {
    
        logger.info("Looking up camps with start date between " + activityStartDateFrom + " and " + activityStartDateTo + ".");

        Page<Camp> camps = campService.findByActivityStartDateBetween(activityStartDateFrom, activityStartDateTo, Pageable.unpaged());
        try {
            String json = mapper.writeValueAsString(camps);
            return ResponseEntity.ok().body(json);
        } catch (JsonProcessingException jpe) {
            logger.error(jpe.getLocalizedMessage(), jpe);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}