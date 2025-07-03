package igathlete.ilt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor  // Generates no-arg constructor
@AllArgsConstructor // Generates all-args constructor
public class Issue {
    private Long id;
    private String name;
    private String description;
    private String city;
}