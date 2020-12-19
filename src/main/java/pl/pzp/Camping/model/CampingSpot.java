package pl.pzp.Camping.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.UUID;

public class CampingSpot {
    private final UUID id;
    @NotEmpty
    private final int basePrice;
    @Min(1)
    @Max(5)
    @NotEmpty
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
