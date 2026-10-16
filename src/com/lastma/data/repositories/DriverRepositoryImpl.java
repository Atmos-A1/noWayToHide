package com.lastma.data.repositories;

import com.lastma.data.models.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverRepositoryImpl implements DriverRepository {

    private List<Driver> drivers = new ArrayList<>();
    private int numberOfDrivers;

    @Override
    public Driver save(Driver driver) {
        driver.setId(++numberOfDrivers);
        drivers.add(driver);
        return driver;
    }

    @Override
    public long count() {
        return numberOfDrivers;
    }

    @Override
    public Driver findById(int id) {
        for (Driver driver : drivers) {
            if (driver.getId() == id) {
                return driver;
            }
        }
        throw new IllegalArgumentException("Driver with id " + id + " not found");
    }

    @Override
    public List<Driver> findAll() {
        if(numberOfDrivers == 0){
            throw new IllegalArgumentException("no drivers found");
        }
        return  drivers;
    }

    @Override
    public void delete(int driverId) {
        Driver lookedUpDriver = findById(driverId);
        drivers.remove(lookedUpDriver);
        numberOfDrivers--;

    }

    @Override
    public void deleteAll() {
        drivers.clear();
        numberOfDrivers = 0;

    }
}
