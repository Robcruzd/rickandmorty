package com.test.infrastructure.jpa.repositories;

import com.test.infrastructure.jpa.entities.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICharacterJpaRepository extends JpaRepository<CharacterEntity, Integer> {
}
