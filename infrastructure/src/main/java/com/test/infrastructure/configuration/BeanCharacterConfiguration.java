package com.test.infrastructure.configuration;

import com.test.core.input.ICharacterInputPort;
import com.test.core.input.impl.CharacterInputPort;
import com.test.core.output.ICharacterOutputPort;
import com.test.infrastructure.jpa.adapters.CharacterJpaAdapter;
import com.test.infrastructure.jpa.mapper.ICharacterEntityMapper;
import com.test.infrastructure.jpa.repositories.ICharacterJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanCharacterConfiguration {

    private final ICharacterJpaRepository characterJpaRepository;
    private final ICharacterEntityMapper characterMapper;

    @Bean
    public ICharacterOutputPort characterOutputPortBean() {
        return new CharacterJpaAdapter(characterJpaRepository, characterMapper);
    }
    @Bean
    public ICharacterInputPort characterInputPortBean() {
        return new CharacterInputPort(characterOutputPortBean());
    }

}
