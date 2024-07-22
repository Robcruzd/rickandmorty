package com.test.core.output;

import com.test.core.model.Location;

import java.util.List;

public interface ILocationOutputPort {

    List<Location> findAll();
    Location findById(int id);
    Location save(Location location);
    void deleteById(int id);
    Location update(Location location);
    void saveAll(List<Location> locations);

}
