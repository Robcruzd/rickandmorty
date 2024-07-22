package com.test.application.dto.request;

import lombok.Data;

import java.util.ArrayList;

@Data
public class LocationUpdateRequestDto {

    private int id;
    private String name;
    private String type;
    private String dimension;
    private ArrayList<String> residents;
    private String url;
    private String created;
}
