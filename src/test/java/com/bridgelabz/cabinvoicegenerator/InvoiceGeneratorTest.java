package com.bridgelabz.cabinvoicegenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceGeneratorTest {
    @Test
    public void testCalculateFare() {
        //Arrange
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        //Act
        double distance1 = 3;
        double time1 = 15;
        double expectedFare = (3 * 10) + (15 * 1);
        //Assert
        Assertions.assertEquals(expectedFare, cabInvoiceGenerator.calculateFare(distance1, time1));
    }
    @Test
    public void testCalculateFareForMultipleRides() {
        // Arrange
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        Ride[] rides = {new Ride(3.0, 15.0), new Ride(5.0, 20.0)};
        double expectedFare = (3 * 10) + (15 * 1) + (5 * 10) + (20 * 1); // Rs. 45 + Rs. 70 = Rs. 115
        // Act
        double totalFare = cabInvoiceGenerator.calculateFare(rides);
        // Assert
        Assertions.assertEquals(expectedFare, totalFare);
    }

}
