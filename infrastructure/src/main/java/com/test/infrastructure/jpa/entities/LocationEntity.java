package com.test.infrastructure.jpa.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "Location")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LocationEntity implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "dimension")
    private String dimension;

    @ElementCollection
    @CollectionTable(name = "Location_residents")
    @Column(name = "resident")
    private List<String> residents;

    @Column(name = "url")
    private String url;

    @Column(name = "created")
    private String created;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public List<String> getResidents() {
        return residents;
    }

    public void setResidents(List<String> residents) {
        this.residents = residents;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LocationEntity that = (LocationEntity) o;
        return id == that.id && Objects.equals(name,
                that.name) && Objects.equals(type, that.type) && Objects.equals(
                dimension, that.dimension) && Objects.equals(residents,
                that.residents) && Objects.equals(url,
                that.url) && Objects.equals(created, that.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, dimension, residents, url, created);
    }

    @Override
    public String toString() {
        return "LocationEntity{" + "id=" + id + ", name='" + name + '\'' + ", type='" + type + '\'' + ", dimension='" + dimension + '\'' + ", residents=" + residents + ", url='" + url + '\'' + ", created='" + created + '\'' + '}';
    }
}
