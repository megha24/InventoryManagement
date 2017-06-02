package com.megs.controllers;

import com.megs.models.Supplier;
import com.megs.services.ISupplierService;
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
@RequestMapping("suppliers")
public class SupplierController {
    @Autowired
    ISupplierService supplierService;
    private static final Logger logger  = Logger.getLogger(SupplierController.class);

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<Supplier> getAllSuppliers() {
        logger.info("retrieving all suppliers info");
        List<Supplier> items = supplierService.getAll();
        return items;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> saveItem(@RequestBody Supplier supplier) {
        logger.info("Adding an item");
        try {
            supplierService.saveSupplier(supplier);
        } catch (SQLDataException e) {
            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
