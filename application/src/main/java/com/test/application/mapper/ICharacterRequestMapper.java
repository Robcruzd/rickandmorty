package com.test.application.mapper;

import com.test.application.dto.request.CharacterRequestDto;
import com.test.application.dto.request.CharacterUpdateRequestDto;
import com.test.application.dto.response.CharacterResponseDto;
import com.test.core.model.Character;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICharacterRequestMapper {

    ICharacterRequestMapper MAPPER = Mappers.getMapper(ICharacterRequestMapper.class);

    Character toCharacter(CharacterRequestDto characterRequestDto);

    CharacterRequestDto toCharacterRequestDto(Character character);

    Character toCharacterUpdate(CharacterUpdateRequestDto characterUpdateRequestDto);

    CharacterResponseDto toCharacterResponseDto(Character character);

    List<CharacterResponseDto> toCharacterResponseDtoList(List<Character> characters);
}
