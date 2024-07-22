package com.test.core.input;

import com.test.core.model.Character;

import java.util.List;

public interface ICharacterInputPort {

    List<Character> findAll();
    Character findById(int id);
    Character save(Character character);
    void deleteById(int id);
    Character update(Character character);
}
