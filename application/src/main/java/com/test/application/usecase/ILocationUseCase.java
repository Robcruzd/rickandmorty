package com.test.application.usecase;

import com.test.application.dto.request.LocationUpdateRequestDto;
import com.test.application.dto.response.LocationResponseDto;
import com.test.application.dto.request.LocationRequestDto;

import java.util.List;

public interface ILocationUseCase {

    List<LocationResponseDto> findAll();
    LocationResponseDto findById(int id);
    LocationResponseDto save(LocationRequestDto location);
    void deleteById(int id);
    LocationResponseDto update(LocationUpdateRequestDto location);
}
