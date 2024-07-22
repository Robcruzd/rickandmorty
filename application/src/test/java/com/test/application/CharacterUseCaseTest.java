package com.test.application;

import com.test.application.dto.request.CharacterRequestDto;
import com.test.application.dto.request.CharacterUpdateRequestDto;
import com.test.application.dto.response.CharacterResponseDto;
import com.test.application.mapper.ICharacterRequestMapper;
import com.test.application.usecase.impl.CharacterUseCase;
import com.test.core.input.ICharacterInputPort;
import com.test.core.model.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CharacterUseCaseTest {

    @Mock
    private ICharacterInputPort characterInputPort;
    @Mock
    private ICharacterRequestMapper characterMapper;

    @InjectMocks
    private CharacterUseCase characterUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Character character = new Character();
        List<Character> characters = Collections.singletonList(character);
        when(characterInputPort.findAll()).thenReturn(characters);

        List<CharacterResponseDto> response = characterUseCase.findAll();

        assertEquals(1, response.size());
        verify(characterInputPort, times(1)).findAll();
    }

    @Test
    void testFindById() {
        Character character = new Character();
        when(characterInputPort.findById(1)).thenReturn(character);

        CharacterResponseDto response = characterUseCase.findById(1);

        assertEquals(new CharacterResponseDto(), response);
        verify(characterInputPort, times(1)).findById(1);
    }

    @Test
    void testSave() {
        Character character = new Character();
        CharacterRequestDto characterRequestDto = new CharacterRequestDto();
        when(characterMapper.toCharacter(characterRequestDto)).thenReturn(character);
        when(characterInputPort.save(character)).thenReturn(character);
        when(characterMapper.toCharacterResponseDto(character)).thenReturn(new CharacterResponseDto());

        CharacterResponseDto response = characterUseCase.save(
                characterRequestDto);

        assertEquals(new CharacterResponseDto(), response);
        verify(characterInputPort, times(1)).save(character);
    }

    @Test
    void testDeleteById() {
        doNothing().when(characterInputPort).deleteById(1);

        characterUseCase.deleteById(1);

        verify(characterInputPort, times(1)).deleteById(1);
    }

    @Test
    void testUpdate() {
        Character character = new Character();
        CharacterUpdateRequestDto characterUpdateRequestDto = new CharacterUpdateRequestDto();
        when(characterMapper.toCharacterUpdate(characterUpdateRequestDto)).thenReturn(character);
        when(characterInputPort.save(character)).thenReturn(character);
        when(characterMapper.toCharacterResponseDto(character)).thenReturn(new CharacterResponseDto());

        CharacterResponseDto response = characterUseCase.update(
                characterUpdateRequestDto);

        assertEquals(new CharacterResponseDto(), response);
    }
}

