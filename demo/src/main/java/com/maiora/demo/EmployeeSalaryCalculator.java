package com.maiora.demo;

import java.util.Scanner;

public class EmployeeSalaryCalculator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double weeklySalary;
        double salary;

        System.out.println("What is the employee's hourly rate");
        double hourlyRate = s.nextDouble();

        System.out.println("What is the number of hours worked in a week?");
        double weeklyHours = s.nextDouble();

        if(weeklyHours <= 40){
            weeklySalary = hourlyRate * weeklyHours;
        }
        else{
            double overtimeHours = weeklyHours - 40;
            weeklySalary = (40 * hourlyRate) + (overtimeHours * hourlyRate * 1.5);
        }

        //assuming there are 4 weeks in a month
        salary = weeklySalary * 4;

        double tax= salary * 10/100;

        System.out.println("total salary after tax deduction is: " + (salary - tax));
    }
}
