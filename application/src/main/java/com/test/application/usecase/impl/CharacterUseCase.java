package com.test.application.usecase.impl;

import com.test.application.dto.request.CharacterRequestDto;
import com.test.application.dto.request.CharacterUpdateRequestDto;
import com.test.application.dto.response.CharacterResponseDto;
import com.test.core.input.ICharacterInputPort;
import com.test.application.mapper.ICharacterRequestMapper;
import com.test.core.model.Character;
import com.test.application.usecase.ICharacterUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class CharacterUseCase implements ICharacterUseCase {

    private final ICharacterInputPort characterInputPort;
    private final ICharacterRequestMapper characterMapper;
    @Override
    public List<CharacterResponseDto> findAll() {
        List<Character> characters = this.characterInputPort.findAll();
        return characterMapper.MAPPER.toCharacterResponseDtoList(characters);
    }

    @Override
    public CharacterResponseDto findById(int id) {
        Character character = this.characterInputPort.findById(id);
        return characterMapper.MAPPER.toCharacterResponseDto(character);
    }

    @Override
    public CharacterResponseDto save(CharacterRequestDto character) {
        Character characterModel = characterMapper.toCharacter(character);
        Character characterSaved = this.characterInputPort.save(characterModel);
        return characterMapper.toCharacterResponseDto(characterSaved);
    }

    @Override
    public void deleteById(int id) {
        this.characterInputPort.deleteById(id);
    }

    @Override
    public CharacterResponseDto update(CharacterUpdateRequestDto character) {
        Character characterModel = characterMapper.toCharacterUpdate(character);
        Character characterSaved = this.characterInputPort.save(characterModel);
        return characterMapper.toCharacterResponseDto(characterSaved);
    }
}
