package com.narola.financialcalculator;

public class MoreValues {
    private double mediclame;
    private double emergencyFund;
    private double savingAmount;

    public MoreValues(double mediclame, double emergencyFund, double savingAmount) {
        this.mediclame = mediclame;
        this.emergencyFund = emergencyFund;
        this.savingAmount = savingAmount;
    }

    public double getMediclame() {
        return mediclame;
    }

    public void setMediclame(double mediclame) {
        this.mediclame = mediclame;
    }

    public double getEmergencyFund() {
        return emergencyFund;
    }

    public void setEmergencyFund(double emergencyFund) {
        this.emergencyFund = emergencyFund;
    }

    public double getSavingAmount() {
        return savingAmount;
    }

    public void setSavingAmount(double savingAmount) {
        this.savingAmount = savingAmount;
    }
}