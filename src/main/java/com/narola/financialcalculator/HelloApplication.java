package com.narola.financialcalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//@ApplicationPath("/result")
@RestController
@RequestMapping("/information")
public class HelloApplication extends Application {

    @Autowired
    private ResultDAO resultDAO;

    @GetMapping(
            value = "/getResult",
            produces = "application/json")
    public ResultStorage getEmployees() {
        return resultDAO.getResults();
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResultStorage giveInfo(@RequestBody FinancialInfo info){
        return resultDAO.getResults(info);
    }
}