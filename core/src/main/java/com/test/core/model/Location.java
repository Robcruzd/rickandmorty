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
public class Location {

    private int id;
    private String name;
    private String type;
    private String dimension;
    private ArrayList<String> residents;
    private String url;
    private String created;

    @Override
    public String toString() {
        return "Location{" + "id=" + id + ", name='" + name + '\'' + ", type='" + type + '\'' + ", dimension='" + dimension + '\'' + ", residents=" + residents + ", url='" + url + '\'' + ", created='" + created + '\'' + '}';
    }
}
