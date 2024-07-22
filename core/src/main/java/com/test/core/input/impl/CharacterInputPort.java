package com.test.core.input.impl;

import com.test.core.input.ICharacterInputPort;
import com.test.core.model.Character;
import com.test.core.output.ICharacterOutputPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CharacterInputPort implements ICharacterInputPort {

    private final ICharacterOutputPort characterOutputPort;

    @Override
    public List<Character> findAll() {
        return characterOutputPort.findAll();
    }

    @Override
    public Character findById(int id) {
        return characterOutputPort.findById(id);
    }

    @Override
    public Character save(Character character) {
        return characterOutputPort.save(character);
    }

    @Override
    public void deleteById(int id) {
        characterOutputPort.deleteById(id);
    }

    @Override
    public Character update(Character character) {
        return characterOutputPort.update(character);
    }
}
