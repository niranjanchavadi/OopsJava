package com.Empwages.java;

public class EmployeeWageMUlti {
    public static final int Is_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;
    public static final int EMP_RATE_PER_HOUR = 20;
    public static final int NUM_OF_WORKING_DAYS = 2;
    public static final int MAX_HOURS_IN_MONTH = 10;


    public static int calcEmpWageForCompany(String company, int empRate, int numOfDays, int maxHrs) {
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
        System.out.println("Total emp wages: " + totalEmpWages);
        return totalEmpWages;

    }


    public static void main(String[] args) {
        calcEmpWageForCompany("D-Mart",20,2,10);
        calcEmpWageForCompany("Reliance",23,21,8);
        calcEmpWageForCompany("Bigbasket",28,29,19);

    }
}