package com.test.application.usecase;

import com.test.application.dto.request.CharacterRequestDto;
import com.test.application.dto.request.CharacterUpdateRequestDto;
import com.test.application.dto.response.CharacterResponseDto;

import java.util.List;

public interface ICharacterUseCase {

    List<CharacterResponseDto> findAll();
    CharacterResponseDto findById(int id);
    CharacterResponseDto save(CharacterRequestDto character);
    void deleteById(int id);
    CharacterResponseDto update(CharacterUpdateRequestDto character);
}
