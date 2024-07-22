package com.test.core.input;

import com.test.core.model.Location;

import java.util.List;

public interface ILocationInputPort {
    List<Location> findAll();
    Location findById(int id);
    Location save(Location location);
    void deleteById(int id);
    Location update(Location location);
}
