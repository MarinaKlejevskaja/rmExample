package org.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor //constructor with all fields
@NoArgsConstructor // constructor with no fields
@Builder // constructor with required fields
public class Character {
    public Integer id;
    public String name;
    public String status;
    public String species;
    public String type;
    public String gender;
    public List<String> episode;
    public Origin origin;
    public Location location;

    @Override
    public String toString() {
        return "Character {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", species='" + species + '\'' +
                ", type='" + type + '\'' +
                ", gender='" + gender + '\'' +
                ", episode='" + episode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character1 = (Character) o;
        return Objects.equals(id, character1.id) && Objects.equals(name, character1.name) && Objects.equals(status, character1.status) && Objects.equals(species, character1.species) && Objects.equals(type, character1.type) && Objects.equals(gender, character1.gender) && Objects.equals(episode, character1.episode);
    }

}
