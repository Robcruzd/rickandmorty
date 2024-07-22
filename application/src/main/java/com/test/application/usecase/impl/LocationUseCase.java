package com.test.application.usecase.impl;

import com.test.application.dto.request.LocationRequestDto;
import com.test.application.dto.request.LocationUpdateRequestDto;
import com.test.application.dto.response.LocationResponseDto;
import com.test.application.mapper.ILocationRequestMapper;
import com.test.application.usecase.ILocationUseCase;
import com.test.core.input.ILocationInputPort;
import com.test.core.model.Location;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
@Transactional
public class LocationUseCase implements ILocationUseCase {
    private final ILocationInputPort locationInputPort;
    private final ILocationRequestMapper locationMapper;
    @Override
    public List<LocationResponseDto> findAll() {
        List<Location> locations = this.locationInputPort.findAll();
        return locationMapper.MAPPER.toLocationResponseDtoList(locations);
    }

    @Override
    public LocationResponseDto findById(int id) {
        Location location = this.locationInputPort.findById(id);
        return locationMapper.MAPPER.toLocationResponseDto(location);
    }

    @Override
    public LocationResponseDto save(LocationRequestDto location) {
        Location locationModel = locationMapper.MAPPER.toLocation(location);
        Location locationSaved = this.locationInputPort.save(locationModel);
        return locationMapper.MAPPER.toLocationResponseDto(locationSaved);
    }

    @Override
    public void deleteById(int id) {
        this.locationInputPort.deleteById(id);
    }

    @Override
    public LocationResponseDto update(LocationUpdateRequestDto location) {
        Location locationModel = locationMapper.MAPPER.toLocationUpdate(location);
        Location locationSaved = this.locationInputPort.save(locationModel);
        return locationMapper.MAPPER.toLocationResponseDto(locationSaved);
    }
}
