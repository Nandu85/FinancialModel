package com.narola.financialcalculator;

import org.springframework.stereotype.Repository;

@Repository
public class ResultDAO {

    private static ResultStorage results = new ResultStorage();

    public ResultStorage getResults(FinancialInfo financialInfo){
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

        //
        return results;
    }
}
