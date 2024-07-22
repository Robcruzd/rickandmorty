package com.test.core.model;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Character {

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

    @Override
    public String toString() {
        return "Character{" + "id=" + id + ", name='" + name + '\'' + ", status='" + status + '\'' + ", species='" + species + '\'' + ", type='" + type + '\'' + ", gender='" + gender + '\'' + ", origin=" + origin + ", location=" + location + ", image='" + image + '\'' + ", episode=" + episode + ", url='" + url + '\'' + ", created='" + created + '\'' + '}';
    }
}
