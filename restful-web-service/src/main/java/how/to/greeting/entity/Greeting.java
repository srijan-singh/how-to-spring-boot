package how.to.greeting.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO class for storing greeting content
 */
@Getter
@Setter
@EqualsAndHashCode
public class Greeting {
    // Identifier
    private int id;
    // Content
    private String content;

    @JsonCreator
    public Greeting(@JsonProperty("id") int id, @JsonProperty("content") String content) {
        this.id = id;
        this.content = content;
    }
}
