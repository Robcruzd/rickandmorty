package com.test.application.mapper;

import com.test.application.dto.request.LocationRequestDto;
import com.test.application.dto.request.LocationUpdateRequestDto;
import com.test.application.dto.response.LocationResponseDto;
import com.test.core.model.Location;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ILocationRequestMapper {

    ILocationRequestMapper MAPPER = Mappers.getMapper(ILocationRequestMapper.class);

    Location toLocation(LocationRequestDto locationRequestDto);

    LocationRequestDto toLocationRequestDto(Location location);

    Location toLocationUpdate(LocationUpdateRequestDto locationUpdateRequestDto);

    LocationResponseDto toLocationResponseDto(Location location);

    List<LocationResponseDto> toLocationResponseDtoList(List<Location> locations);
}
