package com.bridgelabz.cabinvoicegenerator;

public class InvoiceService {
    private RideRepository rideRepository;
    private CabInvoiceGenerator cabInvoiceGenerator;

    public InvoiceService() {
        this.rideRepository = new RideRepository();
        this.cabInvoiceGenerator = new CabInvoiceGenerator();
    }

    // add rides for a specific user
    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId, rides);
    }

    // get the invoice summary for a specific user
    public InvoiceSummary getInvoice(String userId) {
        Ride[] rides = rideRepository.getRides(userId);
        return cabInvoiceGenerator.calculateFare(rides);
    }
}
