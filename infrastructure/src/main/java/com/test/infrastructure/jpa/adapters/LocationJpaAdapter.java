package com.test.infrastructure.jpa.adapters;

import com.test.infrastructure.jpa.entities.LocationEntity;
import com.test.infrastructure.jpa.mapper.ILocationEntityMapper;
import com.test.infrastructure.jpa.repositories.ILocationJpaRepository;
import com.test.core.model.Location;
import com.test.core.output.ILocationOutputPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class LocationJpaAdapter implements ILocationOutputPort {

    private final ILocationJpaRepository locationJpaRepository;
    private final ILocationEntityMapper locationMapper;
    @Override
    public List<Location> findAll() {
        List<LocationEntity> locationEntities = this.locationJpaRepository.findAll();
        return locationMapper.MAPPER.toLocationList(locationEntities);
    }

    @Override
    public Location findById(int id) {
        LocationEntity locationEntity = this.locationJpaRepository.findById(id).orElse(null);
        return locationMapper.MAPPER.toLocation(locationEntity);
    }

    @Override
    public Location save(Location location) {
        LocationEntity locationEntity = locationMapper.MAPPER.toLocationEntity(location);
        locationEntity = this.locationJpaRepository.save(locationEntity);
        return locationMapper.MAPPER.toLocation(locationEntity);
    }

    @Override
    public void deleteById(int id) {
        this.locationJpaRepository.deleteById(id);
    }

    @Override
    public Location update(Location location) {
        LocationEntity locationEntity = locationMapper.MAPPER.toLocationEntity(location);
        locationEntity = this.locationJpaRepository.save(locationEntity);
        return locationMapper.MAPPER.toLocation(locationEntity);
    }

    @Override
    public void saveAll(List<Location> locations) {
        List<LocationEntity> locationEntities = locationMapper.MAPPER.toLocationEntityList(locations);
        this.locationJpaRepository.saveAll(locationEntities);
    }
}
