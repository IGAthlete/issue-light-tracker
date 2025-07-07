package igathlete.ilt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data               // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor  // No-arg constructor (required by frameworks)
@AllArgsConstructor // All-args constructor
public class Filter {
    private List<Long> ids;
    private String name;
    private String description;
    private String city;
    private java.time.LocalDateTime fromTimestamp;
    private java.time.LocalDateTime toTimestamp;
}