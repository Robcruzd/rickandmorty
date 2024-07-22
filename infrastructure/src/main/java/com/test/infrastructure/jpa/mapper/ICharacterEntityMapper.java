package com.test.infrastructure.jpa.mapper;

import com.test.infrastructure.jpa.entities.CharacterEntity;
import com.test.core.model.Character;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICharacterEntityMapper {

    ICharacterEntityMapper MAPPER = Mappers.getMapper(ICharacterEntityMapper.class);

    Character toCharacter(CharacterEntity characterEntity);

    CharacterEntity toCharacterEntity(Character character);
    List<Character> toCharacterList(List<CharacterEntity> characterEntities);

    List<CharacterEntity> toCharacterEntityList(List<Character> characters);
}
