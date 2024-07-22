package com.test.infrastructure.restconsumer.entity;

import com.test.core.model.Character;

import java.util.List;

public class ApiResponseCharacter {
    private Info info;
    private List<Character> results;

    // Getters y setters
    public List<Character> getResults() {
        return results;
    }

    public void setResults(List<Character> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
