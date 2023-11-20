package com.technicaltest.frontend;

import java.util.ArrayList;
import java.util.List;

public class Policy {

    private Customer customer = new Customer();
    private List<Vehicle> vehicles = new ArrayList<>();

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
