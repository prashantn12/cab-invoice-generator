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

}
