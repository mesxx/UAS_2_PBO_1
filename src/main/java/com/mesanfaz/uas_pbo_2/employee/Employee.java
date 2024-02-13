/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.mesanfaz.uas_pbo_2.employee;

/**
 *
 * @author mesanfaz
 */
public interface Employee {
    // SPV
    // salary + transport 11.000.000
    int spvSalary = 10000000;
    int spvTransport = 1000000;
    int spvOvertime = 10000;
    int spvWife = 300000;
    int spvChild = 100000;
    int spvChildMore = 200000;
    // END SPV
    
    // HRD
    // salary + transport 5.750.000
    int hrdSalary = 5000000;
    int hrdTransport = 750000;
    int hrdOvertime = 7500;
    int hrdWife = 250000;
    int hrdChild = 90000;
    int hrdChildMore = 190000;
    // END HRD
    
    // TKN
    // salary + transport 3.500.000
    int tknSalary = 3000000;
    int tknTransport = 500000;
    int tknOvertime = 5000;
    int tknWife = 200000;
    int tknChild = 75000;
    int tknChildMore = 150000;
    // END TKN
    
    // KRY
    // salary + transport 1.750.000
    int krySalary = 1500000;
    int kryTransport = 250000;
    int kryOvertime = 5000;
    int kryWife = 200000;
    int kryChild = 60000;
    int kryChildMore = 130000;
    // END KRY
    
    public String presence();
}
