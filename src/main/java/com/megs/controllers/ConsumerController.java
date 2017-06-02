package com.megs.controllers;

import com.megs.models.Consumer;
import com.megs.services.IConsumerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLDataException;
import java.util.List;

@Controller
@RequestMapping("/consumers")
public class ConsumerController {
    @Autowired
    IConsumerService consumerService;
    private static final Logger logger  = Logger.getLogger(SupplierController.class);

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<Consumer> getAllConsumers() {
        logger.info("retrieving all consumers info");
        List<Consumer> consumers = consumerService.getAll();
        return consumers;

    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> saveConsumer(@RequestBody Consumer consumer) {
        logger.info("Adding consumer");
        try {
            consumerService.saveConsumer(consumer);
        } catch (SQLDataException e) {
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
