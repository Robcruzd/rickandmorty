package com.test.core.input.impl;

import com.test.core.input.ILocationInputPort;
import com.test.core.model.Location;
import com.test.core.output.ILocationOutputPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class LocationInputPort implements ILocationInputPort {

    private final ILocationOutputPort locationOutputPort;

    @Override
    public List<Location> findAll() {
        return locationOutputPort.findAll();
    }

    @Override
    public Location findById(int id) {
        return locationOutputPort.findById(id);
    }

    @Override
    public Location save(Location location) {
        return locationOutputPort.save(location);
    }

    @Override
    public void deleteById(int id) {
        locationOutputPort.deleteById(id);
    }

    @Override
    public Location update(Location location) {
        return locationOutputPort.update(location);
    }
}
