package pl.pzp.Camping.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class CampingSpot {
    private final UUID id;
    private final int basePrice;
    private final int guestsLimit;


    public CampingSpot(@JsonProperty("id") UUID id,
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
