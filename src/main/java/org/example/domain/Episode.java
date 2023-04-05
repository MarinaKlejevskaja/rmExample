package org.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Episode {
    public Long id;
    public String name;
    public String air_date;
    public String episode;
    public List<String> characters;

    @Override
    public String toString() {
        return "Episode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", air_date='" + air_date + '\'' +
                ", episode='" + episode + '\'' +
                ", characterUrls=" + characters +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Episode episode1 = (Episode) o;
        return Objects.equals(id, episode1.id) && Objects.equals(name, episode1.name) && Objects.equals(air_date, episode1.air_date) && Objects.equals(episode, episode1.episode) && Objects.equals(characters, episode1.characters);
    }
}