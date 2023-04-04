package org.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor //constructor with all fields
@NoArgsConstructor // constructor with no fields
@Builder // constructor with required fields
@JsonIgnoreProperties(ignoreUnknown = true)
public class Character {
    Integer id;
    String name;
    String status;
    String species;
    String type;
    String gender;
    List<String> episode;
    Origin origin;
    Location location;

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
