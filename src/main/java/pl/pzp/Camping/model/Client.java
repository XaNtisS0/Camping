package pl.pzp.Camping.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Client {
    private final UUID id;
    @NotBlank(message = "Name can't be blank.")
    private final String name;
    @Min(value = 1, message = "Minimum value is 1.")
    private final int age;

    public Client(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name,
                  @JsonProperty("age") int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
