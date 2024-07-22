package com.test.infrastructure.jpa.adapters;

import ch.qos.logback.core.util.StringUtil;
import com.test.infrastructure.jpa.entities.CharacterEntity;
import com.test.infrastructure.jpa.entities.LocationEntity;
import com.test.infrastructure.jpa.mapper.ICharacterEntityMapper;
import com.test.infrastructure.jpa.repositories.ICharacterJpaRepository;
import com.test.core.model.Character;
import com.test.core.output.ICharacterOutputPort;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RequiredArgsConstructor
public class CharacterJpaAdapter implements ICharacterOutputPort {

    private final ICharacterJpaRepository characterJpaRepository;
    private final ICharacterEntityMapper characterMapper;

    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Character> findAll() {
        List<CharacterEntity> characterEntities = this.characterJpaRepository.findAll();
        return characterMapper.MAPPER.toCharacterList(characterEntities);
    }

    @Override
    public Character findById(int id) {
        CharacterEntity characterEntity = this.characterJpaRepository.findById(id).orElse(null);
        return characterMapper.MAPPER.toCharacter(characterEntity);
    }

    @Override
    public Character save(Character character) {
        CharacterEntity characterEntity = characterMapper.MAPPER.toCharacterEntity(character);
        characterEntity = this.characterJpaRepository.save(characterEntity);
        return characterMapper.MAPPER.toCharacter(characterEntity);
    }

    @Override
    public void deleteById(int id) {
        this.characterJpaRepository.deleteById(id);
    }

    @Override
    public Character update(Character character) {
        CharacterEntity characterEntity = characterMapper.MAPPER.toCharacterEntity(character);
        characterEntity = this.characterJpaRepository.save(characterEntity);
        return characterMapper.MAPPER.toCharacter(characterEntity);
    }

    @Override
    public void saveAll(List<Character> characters) {
        List<CharacterEntity> characterEntities = characterMapper.MAPPER.toCharacterEntityList(characters);
        for(CharacterEntity characterEntity : characterEntities){
            if (!StringUtil.isNullOrEmpty(characterEntity.getLocation().getUrl())) {
                int lastSlashIndex = characterEntity.getLocation().getUrl().lastIndexOf('/');
                String numberStr = characterEntity.getLocation().getUrl().substring(lastSlashIndex + 1);
                if(Integer.parseInt(numberStr)<21){
                    characterEntity.setLocation(entityManager.getReference(LocationEntity.class, Integer.parseInt(numberStr)));
                } else {
                    characterEntity.setLocation(null);
                }
            }else {
                characterEntity.setLocation(null);
            }
            if (!StringUtil.isNullOrEmpty(characterEntity.getOrigin().getUrl())) {
                int lastSlashIndex = characterEntity.getOrigin().getUrl().lastIndexOf('/');
                String numberStr = characterEntity.getOrigin().getUrl().substring(lastSlashIndex + 1);
                if(Integer.parseInt(numberStr)<21){
                    characterEntity.setOrigin(entityManager.getReference(LocationEntity.class, Integer.parseInt(numberStr)));
                } else {
                    characterEntity.setOrigin(null);
                }
            }else {
                characterEntity.setOrigin(null);
            }
        }
        this.characterJpaRepository.saveAll(characterEntities);
    }
}
