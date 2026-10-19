package com.lastma.data.repositories;

import com.lastma.data.models.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepositoryImpl implements VehicleRepository {

    private List<Vehicle> vehicles = new ArrayList<>();
    private int numberOfVehicles;

    @Override
    public long count() {
        return numberOfVehicles;
    }

    @Override
    public void save(Vehicle vehicle) {
        vehicles.add(vehicle);
        numberOfVehicles++;
    }

    @Override
    public Vehicle findPlateNumber(String plateNumber) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlateNumber().equals(plateNumber)) {
                return vehicle;
            }
        }
        throw new IllegalArgumentException("Vehicle with plate number " + plateNumber + " not found");
    }

    @Override
    public void delete(String plateNumber) {
        Vehicle lookedUpVehicle = findPlateNumber(plateNumber);
        vehicles.remove(lookedUpVehicle);
        numberOfVehicles--;
    }

    @Override
    public void deleteAll() {
        vehicles.clear();
        numberOfVehicles = 0;
    }

    @Override
    public boolean plateNumberExists(String plateNumber) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPlateNumber().equals(plateNumber)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Vehicle> findAll() {
        if (numberOfVehicles == 0) {
            throw new IllegalArgumentException("no vehicles found");
        }
        return vehicles;
    }
}