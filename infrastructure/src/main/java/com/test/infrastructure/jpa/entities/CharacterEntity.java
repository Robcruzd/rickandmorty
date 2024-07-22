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
@Table(name = "Character")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CharacterEntity implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "species")
    private String species;

    @Column(name = "type")
    private String type;

    @Column(name = "gender")
    private String gender;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "origin")
    private LocationEntity origin;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "location")
    private LocationEntity location;

    @Column(name = "image")
    private String image;

    @ElementCollection
    @CollectionTable(name = "character_episodes")
    @Column(name = "episode")
    private List<String> episode;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocationEntity getOrigin() {
        return origin;
    }

    public void setOrigin(LocationEntity origin) {
        this.origin = origin;
    }

    public LocationEntity getLocation() {
        return location;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getEpisode() {
        return episode;
    }

    public void setEpisode(List<String> episode) {
        this.episode = episode;
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
        CharacterEntity that = (CharacterEntity) o;
        return id == that.id && Objects.equals(name,
                that.name) && Objects.equals(status,
                that.status) && Objects.equals(species,
                that.species) && Objects.equals(type,
                that.type) && Objects.equals(gender,
                that.gender) && Objects.equals(origin,
                that.origin) && Objects.equals(location,
                that.location) && Objects.equals(image,
                that.image) && Objects.equals(episode,
                that.episode) && Objects.equals(url,
                that.url) && Objects.equals(created, that.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, species, type, gender, origin,
                location, image, episode, url, created);
    }

    @Override
    public String toString() {
        return "CharacterEntity{" + "id=" + id + ", name='" + name + '\'' + ", status='" + status + '\'' + ", species='" + species + '\'' + ", type='" + type + '\'' + ", gender='" + gender + '\'' + ", origin=" + origin + ", location=" + location + ", image='" + image + '\'' + ", episode=" + episode + ", url='" + url + '\'' + ", created='" + created + '\'' + '}';
    }
}