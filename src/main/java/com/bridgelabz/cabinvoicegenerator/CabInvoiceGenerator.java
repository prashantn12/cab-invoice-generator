package com.bridgelabz.cabinvoicegenerator;

public class CabInvoiceGenerator {
    private static final double COST_PER_KM = 10.0;
    private static final double COST_PER_MINUTE = 1.0;
    private static final double MINIMUM_FARE = 5.0;

    public double calculateFare(double distance, double time) {

        double totalFare = (distance * COST_PER_KM) + (time * COST_PER_MINUTE);

        return Math.max(totalFare, MINIMUM_FARE);
    }

    public static void main(String[] args) {
        CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
        double distance = 3.0;
        double time = 15.0;
        System.out.println(invoiceGenerator.calculateFare(distance,time));
    }
}
