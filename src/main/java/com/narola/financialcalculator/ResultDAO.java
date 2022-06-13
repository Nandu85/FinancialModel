package com.narola.financialcalculator;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ResultDAO {

    private static ResultStorage results = new ResultStorage();
    List<Result> list = null;

    public ResultStorage getResults(FinancialInfo financialInfo){
        list = new ArrayList<>();

        Result result1 = new Result();
        result1.setCurrentYear(financialInfo.getCurrentYear());
        result1.setIncome(financialInfo.getIncome());
        result1.setExpense(financialInfo.getExpense());
        double balance = financialInfo.getFixedAmount()+financialInfo.getIncome()-financialInfo.getExpense();
        result1.setBalance(balance);
        result1.setInvestment5(balance*0.2);
        result1.setInvestment8(balance*0.3);
        result1.setInvestment15(balance*0.5);
        double roi = result1.getInvestment5()*0.05+result1.getInvestment8()*0.08+result1.getInvestment15()*0.15;
        result1.setRoi(roi);
        result1.setTotalBalance(balance+roi);

        list.add(result1);

        for(int i=1;i<=financialInfo.getNoOfYears();i++){
            Result result2 = new Result();
            result2.setCurrentYear(result1.getCurrentYear()+1);
            result2.setIncome(result1.getIncome()*1.06);
            result2.setExpense(result1.getExpense()*1.06);
            balance = financialInfo.getFixedAmount()+financialInfo.getIncome()-financialInfo.getExpense();
            result2.setBalance(balance);
            result2.setInvestment5(balance*0.2);
            result2.setInvestment8(balance*0.3);
            result2.setInvestment15(balance*0.5);
            roi = result2.getInvestment5()*0.05+result2.getInvestment8()*0.08+result2.getInvestment15()*0.15;
            result2.setRoi(roi);
            result2.setTotalBalance(balance+roi);

            list.add(result2);

            result1 = result2;
        }

        results.setResults(list);
        return results;
    }

    public ResultStorage getResults(){
        return results;
    }


//    public void main(String[] args) {
//        FinancialInfo info = new FinancialInfo();
//        info.setFixedAmount(50);
//        info.setCurrentYear(2022);
//        info.setIncome(6.25);
//        info.setExpense(6);
//        info.setNoOfYears(15);
//
//        ResultStorage results = getResults(info);
//    }
}
