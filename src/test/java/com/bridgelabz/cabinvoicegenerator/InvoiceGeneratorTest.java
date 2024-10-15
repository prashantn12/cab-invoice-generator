package com.bridgelabz.cabinvoicegenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class InvoiceGeneratorTest {

    @Test
    public void testInvoiceForMultipleRideTypes() {
        // Arrange
        Ride[] user1Rides = {
                new Ride(3.0, 15.0, RideType.NORMAL),
                new Ride(5.0, 20.0, RideType.PREMIUM)
        };

        InvoiceService invoiceService = new InvoiceService();
        invoiceService.addRides("user1", user1Rides);

        // Act
        InvoiceSummary user1Invoice = invoiceService.getInvoice("user1");

        // Assert
        Assertions.assertEquals(160.0, user1Invoice.getTotalFare(), 0.0);
    }

    @Test
    public void testInvoiceForMultipleUsersWithRideTypes() {
        // Arrange
        Ride[] user1Rides = {
                new Ride(3.0, 15.0, RideType.NORMAL),
                new Ride(5.0, 20.0, RideType.PREMIUM)
        };

        Ride[] user2Rides = {
                new Ride(10.0, 25.0, RideType.PREMIUM),
                new Ride(7.0, 15.0, RideType.NORMAL)
        };

        InvoiceService invoiceService = new InvoiceService();
        invoiceService.addRides("user1", user1Rides);
        invoiceService.addRides("user2", user2Rides);

        // Act
        InvoiceSummary user1Invoice = invoiceService.getInvoice("user1");
        InvoiceSummary user2Invoice = invoiceService.getInvoice("user2");

        // Assert
        Assertions.assertEquals(160.0, user1Invoice.getTotalFare(), 0.0);
        Assertions.assertEquals(285.0, user2Invoice.getTotalFare(), 0.0);
    }
}
