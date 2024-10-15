package com.bridgelabz.cabinvoicegenerator;

public class InvoiceSummary {
    private final int numberOfRides;
    private final double totalFare;
    private final double averageFare;

    public InvoiceSummary(int numberOfRides, double totalFare) {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.averageFare = totalFare / numberOfRides;
    }

    @Override
    public String toString() {
        return "Total Number of Rides: " + numberOfRides + "\n" +
                "Total Fare: Rs. " + totalFare + "\n" +
                "Average Fare per Ride: Rs. " + averageFare;
    }

    public int getNumberOfRides() {
        return numberOfRides;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public double getAverageFare() {
        return averageFare;
    }
}
