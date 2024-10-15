package com.bridgelabz.cabinvoicegenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InvoiceGeneratorTest {
    private InvoiceService invoiceService;

    @BeforeEach
    public void setup() {
        invoiceService = new InvoiceService();
    }

    @Test
    public void testCalculateFareForSingleRide() {
        // Arrange
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 3.0;
        double time = 15.0;
        double expectedFare = (distance * 10.0) + (time * 1.0);

        // Act
        double fare = cabInvoiceGenerator.calculateFare(distance, time);

        // Assert
        Assertions.assertEquals(expectedFare, fare);
    }

    @Test
    public void testCalculateFareForMultipleRides() {
        // Arrange
        Ride[] rides = { new Ride(3.0, 15.0), new Ride(5.0, 20.0) };
        invoiceService.addRides("user1", rides);

        // Act
        InvoiceSummary summary = invoiceService.getInvoice("user1");

        // Assert
        Assertions.assertEquals(2, summary.getNumberOfRides());
        Assertions.assertEquals(115.0, summary.getTotalFare());
        Assertions.assertEquals(115.0 / 2, summary.getAverageFare());
    }

    @Test
    public void testInvoiceForMultipleUsers() {
        // Arrange
        Ride[] user1Rides = { new Ride(3.0, 15.0), new Ride(5.0, 20.0) };
        Ride[] user2Rides = { new Ride(10.0, 25.0), new Ride(7.0, 15.0) };

        invoiceService.addRides("user1", user1Rides);
        invoiceService.addRides("user2", user2Rides);

        // Act
        InvoiceSummary user1Summary = invoiceService.getInvoice("user1");
        InvoiceSummary user2Summary = invoiceService.getInvoice("user2");

        // Assert
        // Check for user1's total fare is calculated correctly
        Assertions.assertEquals(115.0, user1Summary.getTotalFare(), 0.0);

        // Check that user2's total fare is calculated correctly
        Assertions.assertEquals(210.0, user2Summary.getTotalFare(), 0.0);
    }

}
