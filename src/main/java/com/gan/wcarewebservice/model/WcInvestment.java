package com.gan.wcarewebservice.model;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

public class WcInvestment {

    private int id;

    private int wcGoalId;

    private Date investmentDate;

    private double investmentAmount;

    private double stockAmount;

    private double mutualFundAmount;

    private double fixedDepositAmount;

    ///--------------------- The below information for Investment Planning with Watson

    private String gender;

    private int age;

    private double avgIncome;

    private boolean married;

    private int spouseAge;

    private double spouseAvgIncome;

    private int noOfChildren;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWcGoalId() {
        return wcGoalId;
    }

    public void setWcGoalId(int wcGoalId) {
        this.wcGoalId = wcGoalId;
    }

    public Date getInvestmentDate() {
        return investmentDate;
    }

    public void setInvestmentDate(Date investmentDate) {
        this.investmentDate = investmentDate;
    }

    public double getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(double investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public double getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(double stockAmount) {
        this.stockAmount = stockAmount;
    }

    public double getMutualFundAmount() {
        return mutualFundAmount;
    }

    public void setMutualFundAmount(double mutualFundAmount) {
        this.mutualFundAmount = mutualFundAmount;
    }

    public double getFixedDepositAmount() {
        return fixedDepositAmount;
    }

    public void setFixedDepositAmount(double fixedDepositAmount) {
        this.fixedDepositAmount = fixedDepositAmount;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAvgIncome() {
        return avgIncome;
    }

    public void setAvgIncome(double avgIncome) {
        this.avgIncome = avgIncome;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public int getSpouseAge() {
        return spouseAge;
    }

    public void setSpouseAge(int spouseAge) {
        this.spouseAge = spouseAge;
    }

    public double getSpouseAvgIncome() {
        return spouseAvgIncome;
    }

    public void setSpouseAvgIncome(double spouseAvgIncome) {
        this.spouseAvgIncome = spouseAvgIncome;
    }

    public int getNoOfChildren() {
        return noOfChildren;
    }

    public void setNoOfChildren(int noOfChildren) {
        this.noOfChildren = noOfChildren;
    }
}
