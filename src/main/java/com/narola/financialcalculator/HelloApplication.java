package com.narola.financialcalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@ApplicationPath("/result")
@Controller
@RequestMapping("/information")
public class HelloApplication{

    @Autowired
    private ResultDAO resultDAO;

    @GetMapping(
            value = "/getResult",
            produces = "application/json")
    public List<Result> getResults() {
        return resultDAO.getResults();
    }

    @PostMapping(value = "/")
    public @ResponseBody List<Result> giveInfo(@RequestBody FinancialInfo info) {
        return resultDAO.getResults(info);
    }

    @GetMapping(value = "/hello",produces = "text/plain")
    public String hello() {
        return "Hello, World!";
    }
}