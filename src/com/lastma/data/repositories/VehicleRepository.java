package com.lastma.data.repositories;

import com.lastma.data.models.Vehicle;

import java.util.List;

    public interface VehicleRepository {
        long count();

        void save(Vehicle vehicle);

        Vehicle findPlateNumber(String plateNumber);

        void delete(String plateNumber);

        void deleteAll();

        boolean plateNumberExists(String plateNumber);

        List<Vehicle> findAll();
    }



