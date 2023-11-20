package com.technicaltest.frontend;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class Index {

    private Vehicle vehicle = new Vehicle();
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private List<Brand> brands = new ArrayList<>();
    private List<String> coverages = new ArrayList<>();

    private Customer customer = new Customer();

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Index() {
//        this.brands.add(new Brand("Toyota", "Toyota"));
//        this.brands.add(new Brand("Honda", "Honda"));
//        this.brands.add(new Brand("Hyundai", "Hyundai"));
//        this.brands.add(new Brand("Mitsubishi", "Mitsubishi"));
//        this.brands.add(new Brand("BMW", "BMW"));
//        this.brands.add(new Brand("Mercedes-Benz", "Mercedes-Benz"));
//
        this.coverages.add("Daños a la Propiedad Ajena 1,000,000");
        this.coverages.add("Lesiones o Muerte 1 Persona 1,000,000");
        this.coverages.add("Lesiones o Muerte a más de 1 Persona 2,000,000");
        this.coverages.add("Incendio y Robo 100% Valor Asegurado");
        this.coverages.add("Rotura Accidental de Cristales Límite 150,000 ");

    }

    public List<String> getCoverages() {
        return coverages;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    /*
      Agrega un vehiculo a la lista. No permite placa ni chasis duplicados
     */
    public void send(Vehicle vehicle) {
        this.vehicle = vehicle;
        boolean exists = false;
        for (Vehicle v : vehicles) {
            if (v.getVinNumber().equals(vehicle.getVinNumber()) || v.getPlateNumber().equals(vehicle.getPlateNumber())) {
                exists = true;
            }
        }
        if (!exists) {
            vehicles.add(vehicle);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Vehiculo Agregado"));
            this.vehicle = new Vehicle();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Info", "Este vehiculo ya existe"));
        }

    }

    /*
      Remueve el vehiculo de la lista
     */
    public void remove(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    /*
      Navega hacia la pagina de resumen, que muestra los vehiculos y la cobertura
     */
    public String navigateToResumePage() {
        return "resumen";
    }

    public String toJson() {

        if (vehicles.size() > 0) {

            Policy policy = new Policy();
            policy.setCustomer(customer);
            policy.setVehicles(vehicles);
            
            Gson gson = new Gson();
            String array = gson.toJson(policy);
            
            return array;
        }
        return "[]";
    }
    public String setCustomerName(String name) {
        System.out.println(name);
        customer.setName(name);
        return "policyinfo?faces-redirect=true";
    }
}
