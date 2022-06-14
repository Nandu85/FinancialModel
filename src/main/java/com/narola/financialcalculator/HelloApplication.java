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
    @ResponseBody
    public List<Result> getResults() {
        return resultDAO.getResults();
    }

    @PostMapping(value = "/")
    public @ResponseBody List<Result> giveInfo(@RequestBody FinancialInfo info) {
        return resultDAO.getResults(info);
    }

    @GetMapping(value = "/othervalues")
    @ResponseBody
    public MoreValues getVals(FinancialInfo info) {
        return resultDAO.getOtherValues();
    }

    @GetMapping(value = "/hello",produces = "text/plain")
    public String hello() {
        return "Hello, World!";
    }
}