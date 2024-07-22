package com.test.infrastructure.jpa.mapper;

import com.test.infrastructure.jpa.entities.LocationEntity;
import com.test.core.model.Location;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ILocationEntityMapper {

    ILocationEntityMapper MAPPER = Mappers.getMapper(ILocationEntityMapper.class);

    Location toLocation(LocationEntity locationEntity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "dimension", target = "dimension")
    LocationEntity toLocationEntity(Location location);

    List<Location> toLocationList(List<LocationEntity> locationEntities);

    @Mapping(target = "id", source = "location.id")
    List<LocationEntity> toLocationEntityList(List<Location> locations);
}
