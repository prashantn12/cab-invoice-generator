package com.bridgelabz.cabinvoicegenerator;

public class CabInvoiceGenerator {

    private static final double NORMAL_COST_PER_KM = 10.0;
    private static final double NORMAL_COST_PER_MINUTE = 1.0;
    private static final double NORMAL_MINIMUM_FARE = 5.0;

    private static final double PREMIUM_COST_PER_KM = 15.0;
    private static final double PREMIUM_COST_PER_MINUTE = 2.0;
    private static final double PREMIUM_MINIMUM_FARE = 20.0;

    public double calculateFare(double distance, double time, RideType rideType) {
        double totalFare = 0;

        if (rideType == RideType.NORMAL) {
            totalFare = (distance * NORMAL_COST_PER_KM) + (time * NORMAL_COST_PER_MINUTE);
            return Math.max(totalFare, NORMAL_MINIMUM_FARE);
        } else if (rideType == RideType.PREMIUM) {
            totalFare = (distance * PREMIUM_COST_PER_KM) + (time * PREMIUM_COST_PER_MINUTE);
            return Math.max(totalFare, PREMIUM_MINIMUM_FARE);
        }
        return totalFare;
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.distance, ride.time, ride.rideType);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }
    public static void main(String[] args) {
        InvoiceService invoiceService = new InvoiceService();

        // rides for different users
        Ride[] user1Rides = {
                new Ride(3.0, 15.0, RideType.NORMAL),
                new Ride(5.0, 20.0, RideType.PREMIUM)
        };
        Ride[] user2Rides = {
                new Ride(10.0, 25.0, RideType.PREMIUM),
                new Ride(7.0, 15.0, RideType.NORMAL)
        };

        invoiceService.addRides("user1", user1Rides);
        invoiceService.addRides("user2", user2Rides);

        // Generate and display the invoice for user1
        InvoiceSummary user1Invoice = invoiceService.getInvoice("user1");
        System.out.println("Invoice for user1:\n" + user1Invoice);

        // Generate and display the invoice for user2
        InvoiceSummary user2Invoice = invoiceService.getInvoice("user2");
        System.out.println("Invoice for user2:\n" + user2Invoice);
    }

}
