package com.narola.financialcalculator;

import java.util.ArrayList;
import java.util.List;

public class ResultStorage {
    private List<Result> results;

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
