package com.bridgelabz.cabinvoicegenerator;

public class CabInvoiceGenerator {
    private static final double COST_PER_KM = 10.0;
    private static final double COST_PER_MINUTE = 1.0;
    private static final double MINIMUM_FARE = 5.0;

    public double calculateFare(double distance, double time) {

        double totalFare = (distance * COST_PER_KM) + (time * COST_PER_MINUTE);

        return Math.max(totalFare, MINIMUM_FARE);
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }
    public static void main(String[] args) {
        CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();
        double distance = 3.0;
        double time = 15.0;

        Ride[] rides = {new Ride(3.0, 15.0), new Ride(5.0, 20.0)};

        System.out.println("Total fare for all rides: Rs. " + invoiceGenerator.calculateFare(rides));

        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);

        System.out.println(summary);
    }
}
