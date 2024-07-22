package com.test.infrastructure.restconsumer;

import com.test.core.output.ICharacterOutputPort;
import com.test.core.output.ILocationOutputPort;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationStartupListener {

    private final RestRickandMortyService restRickandMortyService;
    private final ICharacterOutputPort characterOutputPort;
    private final ILocationOutputPort locationOutputPort;

    @Autowired
    private EntityManager entityManager;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        locationOutputPort.saveAll(restRickandMortyService.getLocations());
        characterOutputPort.saveAll(restRickandMortyService.getCharacters());
    }
}