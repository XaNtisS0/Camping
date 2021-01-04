package pl.pzp.Camping.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.UUID;

public class CampingSpot {
    private final UUID id;
    @Min(value = 100, message = "Minimum value is 100.")
    private final int basePrice;
    @Min(value = 1, message = "Minimum value is 1.")
    @Max(value = 5, message = "Maximum value is 5.")
    private final int guestsLimit;

    public CampingSpot(@JsonProperty("id") UUID id ,
                       @JsonProperty("basePrice") int basePrice,
                       @JsonProperty("guestsLimit") int guestsLimit) {
        this.id = id;
        this.basePrice = basePrice;
        this.guestsLimit = guestsLimit;
    }

    public UUID getId() {
        return id;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public int getGuestsLimit() {
        return guestsLimit;
    }

}
