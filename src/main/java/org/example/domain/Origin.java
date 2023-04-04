package org.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor //constructor with all fields
@NoArgsConstructor // constructor with no fields
@Builder // constructor with required fields
@JsonIgnoreProperties(ignoreUnknown = true)
public class Origin {
    String name;
    String url;
}
