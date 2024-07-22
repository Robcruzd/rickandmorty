package com.test.infrastructure.restconsumer.entity;

import com.test.core.model.Location;

import java.util.List;

public class ApiResponseLocation {
    private Info info;
    private List<Location> results;

    // Getters y setters
    public List<Location> getResults() {
        return results;
    }

    public void setResults(List<Location> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
