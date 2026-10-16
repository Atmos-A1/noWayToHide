package com.lastma.data.repositories;

import com.lastma.data.models.Officer;

import java.util.ArrayList;
import java.util.List;

public class OfficerRepositoryImpl implements OfficerRepository {

    private List<Officer> officers = new ArrayList<>();
    private int numberOfOfficers;

    @Override
    public Officer saveOfficer(Officer officer) {
        officer.setId(++numberOfOfficers);
        officers.add(officer);
        return officer;
    }

    @Override
    public long count() {
        return numberOfOfficers;
    }

    @Override
    public Officer findById(int id) {
        for (Officer officer : officers) {
            if (officer.getId() == id) {
                return officer;
            }
        }
        throw new IllegalArgumentException("Officer with id " + id + " not found");
    }

    @Override
    public List<Officer> findAll() {
        if (numberOfOfficers == 0) {
            throw new IllegalArgumentException("no officers found");
        }
        return officers;
    }

    @Override
    public void delete(int officerId) {
        Officer lookedUpOfficer = findById(officerId);
        officers.remove(lookedUpOfficer);
        numberOfOfficers--;
    }

    @Override
    public void deleteAll() {
        officers.clear();
        numberOfOfficers = 0;
    }
}