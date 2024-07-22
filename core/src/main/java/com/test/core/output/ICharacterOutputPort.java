package com.test.core.output;

import com.test.core.model.Character;

import java.util.List;

public interface ICharacterOutputPort {

    List<Character> findAll();
    Character findById(int id);
    Character save(Character character);
    void deleteById(int id);
    Character update(Character character);

    void saveAll(List<Character> characters);
}
