package com.test.infrastructure.restconsumer;

import ch.qos.logback.core.util.StringUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.core.model.Character;
import com.test.core.model.Location;
import com.test.infrastructure.restconsumer.entity.ApiResponseCharacter;
import com.test.infrastructure.restconsumer.entity.ApiResponseLocation;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestRickandMortyService {

    @Autowired
    private RestTemplate restTemplate;

    private final ObjectMapper objectMapper;
    private final EntityManager entityManager;

    private static final String BASE_URL = "https://rickandmortyapi.com/api/";

    @Transactional
    public List<Character> getCharacters() {
        String jsonResponse = restTemplate.getForObject(BASE_URL+"character", String.class);
        try {
            ApiResponseCharacter response = objectMapper.readValue(jsonResponse, ApiResponseCharacter.class);
            entityManager.clear();
            return response.getResults();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public List<Location> getLocations() {
        String jsonResponse = restTemplate.getForObject(BASE_URL+"location", String.class);
        try {
            ApiResponseLocation response = objectMapper.readValue(jsonResponse, ApiResponseLocation.class);
            entityManager.clear();
            return response.getResults();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
