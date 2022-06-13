package com.narola.financialcalculator;

public class FinancialInfo {
    int currentYear;


    double fixedAmount;
    double income;
    double expense;
    double eGrowthRate;
    double iGrowthRate;
    int noOfYears;
    double savingAmount;

    public int getCurrentYear() {
        return currentYear;
    }
    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public double getFixedAmount() {
        return fixedAmount;
    }

    public void setFixedAmount(double fixedAmount) {
        this.fixedAmount = fixedAmount;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    public double geteGrowthRate() {
        return eGrowthRate;
    }

    public void seteGrowthRate(double eGrowthRate) {
        this.eGrowthRate = eGrowthRate;
    }

    public double getiGrowthRate() {
        return iGrowthRate;
    }

    public void setiGrowthRate(double iGrowthRate) {
        this.iGrowthRate = iGrowthRate;
    }

    public int getNoOfYears() {
        return noOfYears;
    }

    public void setNoOfYears(int noOfYears) {
        this.noOfYears = noOfYears;
    }

    public double getSavingAmount() {
        return savingAmount;
    }

    public void setSavingAmount(double savingAmount) {
        this.savingAmount = savingAmount;
    }
}
