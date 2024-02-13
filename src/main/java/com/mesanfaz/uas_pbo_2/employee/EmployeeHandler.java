/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mesanfaz.uas_pbo_2.employee;

/**
 *
 * @author mesanfaz
 */
public class EmployeeHandler implements Employee {
    private String employeeName;
    private String employeeCode;
    private boolean employeeWife;
    private int employeeChild;
    private int timeIn;
    private int timeOut;
    private boolean validTime;
    private int timePenaltyIn;
    private int timePenaltyOut;
    private int penalty;
    private int timeBonus;
    private int bonus;
    private int allowanceWife;
    private int allowanceChild;
    private int allowanceChildMore;
    
    public EmployeeHandler(String employeeName, String employeeCode, boolean employeeWife, int employeeChild, int timeIn, int timeOut){
        this.employeeName = employeeName;        
        this.employeeCode = employeeCode;
        this.employeeWife = employeeWife;
        this.employeeChild = employeeChild;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.validTime = timeIn < 25 && timeOut < 25 && timeIn < timeOut;
        this.timePenaltyIn = 0;
        this.timePenaltyOut = 0;
        this.penalty = 0;
        this.timeBonus = 0;
        this.bonus = 0;
        this.allowanceWife = 0;
        this.allowanceChild = 0;
        this.allowanceChildMore = 0;
    }
    
    // jumlah penalty dalam rupiah
    private void calculatePenalty(){
        if (timeIn > 7) {
            this.timePenaltyIn = timeIn - 7;
            this.penalty = 100000 * timePenaltyIn;
            
            if (timeOut < 16) {
                this.timePenaltyOut = 16 - timeOut;
                penalty += 100000 * timePenaltyOut;
            }
        } else if (timeOut < 16) {
            this.timePenaltyOut = 16 - timeOut;
            this.penalty = 100000 * timePenaltyOut;
        }
    }
    
    // jumlah bonus dalam rupiah
    private void calculateBonus(int overtimePay){
        if (timeOut > 16) {
            this.timeBonus = timeOut - 16;
            this.bonus = overtimePay * timeBonus;
        }
    }
    
    // jumlah tunjangan istri dalam rupiah
    private void calculateAllowanceWife(int allowance){
        if (employeeWife) {
            this.allowanceWife = allowance;
        }
    }
    
    // jumlah tunjangan anak 1 dalam rupiah
    private void calculateAllowanceChild(int allowance){
        if (employeeChild == 1) {
            this.allowanceChild = allowance;
        }
    }
    
    // jumlah tunjangan anak lebih dari 1 dalam rupiah
    private void calculateAllowanceChildMore(int allowance){
        if (employeeChild > 1) {
            this.allowanceChildMore = allowance;
        }
    }
    
    public String presence(){
        // time tidak boleh lebih dari nominal 24
        if (validTime) {
            // kondisi employeeCode
            if (employeeCode == "SPV" || employeeCode == "HRD" || employeeCode == "TKN" || employeeCode == "KRY") {
                calculatePenalty();
                calculateBonus(getOvertimeByCode());
                calculateAllowanceWife(getAllowanceWifeByCode());
                calculateAllowanceChild(getAllowanceChildByCode());
                calculateAllowanceChildMore(getAllowanceChildMoreByCode());
                
                int totalSalary = getSalaryByCode()
                        + getAllowanceTransportByCode()
                        + allowanceWife
                        + allowanceChild
                        + allowanceChildMore
                        + bonus
                        - penalty;
                        
                return "name: " + employeeName
                        + "\ncode: " + employeeCode
                        + "\ntime penalty in: " + timePenaltyIn
                        + "\ntime penalty out: " + timePenaltyOut
                        + "\npenalty: " + penalty
                        + "\ntime bonus: " + timeBonus
                        + "\nbonus: " + bonus
                        + "\nwife allowance: " + allowanceWife
                        + "\nchild allowance: " + allowanceChild
                        + "\nchild more allowance: " + allowanceChildMore
                        + "\ntotal salary: " + totalSalary;
            }
            // END kondisi employeeCode
        }
            
        return "wrong input!";
    }
    
    //
    private int getSalaryByCode() {
        switch (employeeCode) {
            case "SPV":
                return spvSalary;
            case "HRD":
                return hrdSalary;
            case "TKN":
                return tknSalary;
            case "KRY":
                return krySalary;
            default:
                return 0;
        }
    }
    //
    
    //
    private int getAllowanceTransportByCode() {
        switch (employeeCode) {
            case "SPV":
                return spvTransport;
            case "HRD":
                return hrdTransport;
            case "TKN":
                return tknTransport;
            case "KRY":
                return kryTransport;
            default:
                return 0;
        }
    }
    //
    
    //
    private int getOvertimeByCode() {
        switch (employeeCode) {
            case "SPV":
                return spvOvertime;
            case "HRD":
                return hrdOvertime;
            case "TKN":
                return tknOvertime;
            case "KRY":
                return kryOvertime;
            default:
                return 0;
        }
    }
    //
    
    //
    private int getAllowanceWifeByCode() {
        switch (employeeCode) {
            case "SPV":
                return spvWife;
            case "HRD":
                return hrdWife;
            case "TKN":
                return tknWife;
            case "KRY":
                return kryWife;
            default:
                return 0;
        }
    }
    //
    
    //
    private int getAllowanceChildByCode() {
        switch (employeeCode) {
            case "SPV":
                return spvChild;
            case "HRD":
                return hrdChild;
            case "TKN":
                return tknChild;
            case "KRY":
                return kryChild;
            default:
                return 0;
        }
    }
    //
    
    //
    private int getAllowanceChildMoreByCode() {
        switch (employeeCode) {
            case "SPV":
                return spvChildMore;
            case "HRD":
                return hrdChildMore;
            case "TKN":
                return tknChildMore;
            case "KRY":
                return kryChildMore;
            default:
                return 0;
        }
    }
    //
}
