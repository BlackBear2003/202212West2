package com.wzl.customer;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Customer {
    private String  customerName;
    private int arriveTimes;
    private LocalDate arrivalDate;
    private double consume;

    public Customer(String customerName, int arriveTimes, LocalDate arrivalDate, double consume) {
        this.customerName = customerName;
        this.arriveTimes = arriveTimes;
        this.arrivalDate = arrivalDate;
        this.consume = consume;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", arriveTimes=" + arriveTimes +
                ", arrivalDateTime=" + arrivalDate +
                ", consume=" + consume +
                '}';
    }

    public double getConsume() {
        return consume;
    }

    public void setConsume(double consume) {
        this.consume = consume;
    }

    public Customer() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getArriveTimes() {
        return arriveTimes;
    }

    public void setArriveTimes(int arriveTimes) {
        this.arriveTimes = arriveTimes;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

}
