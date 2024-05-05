package com.example.lab2_3th4;

public class EmployeeFullTime extends Employee{
    @Override
    public double TinhLuong() {
        return 500;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() +" --> FullTime = "+TinhLuong();
    }
}
