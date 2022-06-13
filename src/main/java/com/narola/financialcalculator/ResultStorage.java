package com.narola.financialcalculator;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ResultStorage {
    private static List<Result> results;

    public ResultStorage getInstance(){
        return this;
    }

    public List<Result> getResults() {
        if(results == null){
            results = new ArrayList<>();
        }
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
