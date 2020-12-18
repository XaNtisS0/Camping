package pl.pzp.Camping.model;

import java.util.UUID;

public class CampingSpot {
    private final UUID id;
    private final int basePrice;
    private final int guestsLimit;

    public CampingSpot(UUID id, int basePrice, int guestsLimit) {
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
