package com.bridgelabz.cabinvoicegenerator;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
    private Map<String, Ride[]> userRides;

    public RideRepository() {
        this.userRides = new HashMap<>();
    }

    public void addRides(String userId, Ride[] rides) {
        userRides.put(userId, rides);
    }

    public Ride[] getRides(String userId) {
        return userRides.get(userId);
    }
}
