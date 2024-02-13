/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mesanfaz.uas_pbo_2;

import com.mesanfaz.uas_pbo_2.employee.*;

/**
 *
 * @author mesanfaz
 */
public class UAS_PBO_2 {
    public static void main(String[] args) {
        System.out.println("---START UAS PBO 2---");
        
        // Employee Satu
        String employeeName = "employee satu";        
        String employeeCode = "SPV";
        boolean employeeWife = true;
        int employeeChild = 1;
        int timeIn = 8;
        int timeOut = 18;
        
        Employee employeeSatu = new EmployeeHandler(employeeName, employeeCode, employeeWife, employeeChild, timeIn, timeOut);
        System.out.println(employeeSatu.presence());
        // END Employee Satu
        
        System.out.println("---END UAS PBO 2---");
    }
}
