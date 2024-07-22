package com.test.infrastructure.configuration;

import com.test.core.input.ILocationInputPort;
import com.test.core.input.impl.LocationInputPort;
import com.test.core.output.ILocationOutputPort;
import com.test.infrastructure.jpa.adapters.LocationJpaAdapter;
import com.test.infrastructure.jpa.mapper.ILocationEntityMapper;
import com.test.infrastructure.jpa.repositories.ILocationJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanLocationConfiguration {

    private final ILocationJpaRepository locationJpaRepository;
    private final ILocationEntityMapper locationMapper;
    
    @Bean
    public ILocationOutputPort locationJpaAdapter() {
        return new LocationJpaAdapter(locationJpaRepository, locationMapper);
    }
    @Bean
    public ILocationInputPort locationInputPort() {
        return new LocationInputPort(locationJpaAdapter());
    }

}
