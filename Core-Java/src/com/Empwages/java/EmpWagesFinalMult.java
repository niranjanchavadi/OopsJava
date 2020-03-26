package com.Empwages.java;

public class EmpWagesFinalMult {
    public static final int Is_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;



    private final int EMP_RATE_PER_HOUR ;
    private final int NUM_OF_WORKING_DAYS ;
    private final int MAX_HOURS_IN_MONTH ;
    private final String Company;


    public EmpWagesFinalMult(String company,int EMP_RATE_PER_HOUR,int NUM_OF_WORKING_DAYS,int MAX_HOURS_IN_MONTH) {
        this.Company = company;
        this.EMP_RATE_PER_HOUR=EMP_RATE_PER_HOUR;
        this.NUM_OF_WORKING_DAYS=NUM_OF_WORKING_DAYS;
        this.MAX_HOURS_IN_MONTH=MAX_HOURS_IN_MONTH;
    }

    private int computeEmpWage()
     {
         int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;
         while (totalEmpHrs <= MAX_HOURS_IN_MONTH && totalWorkingDays < NUM_OF_WORKING_DAYS) {
             totalWorkingDays++;
             int empCheck = (int) Math.floor(Math.random() * 10) % 3;
             switch ((int) empCheck) {
                 case IS_FULL_TIME:
                     empHrs = 8;
                     break;
                 case Is_PART_TIME:
                     empHrs = 4;
                     break;
                 default:
                     empHrs = 0;
             }
             totalEmpHrs += empHrs;
             System.out.println("Day#: " + totalWorkingDays + "emp hrs " + empHrs);
         }
         int totalEmpWages = totalEmpHrs * EMP_RATE_PER_HOUR;
        // System.out.println("Total emp wages: " + totalEmpWages);
         return totalEmpWages;
     }


    public static void main(String[] args) {

        EmpWagesFinalMult dmart = new EmpWagesFinalMult("Dmart",12,13,15);
        EmpWagesFinalMult bigbasket = new EmpWagesFinalMult("Bigbasket",11,12,10);
        EmpWagesFinalMult reliance = new EmpWagesFinalMult("Reliance",17,19,18);
        System.out.println(dmart.computeEmpWage());
        System.out.println(bigbasket.computeEmpWage());
        System.out.println(reliance.computeEmpWage());

    }



}
