package com.test.application.dto.request;

import com.test.core.model.Location;
import lombok.Data;

import java.util.ArrayList;

@Data
public class CharacterUpdateRequestDto {
    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Location origin;
    private Location location;
    private String image;
    private ArrayList<String> episode;
    private String url;
    private String created;
}
