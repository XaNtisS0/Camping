package pl.pzp.Camping.model;

import java.util.List;
import java.util.UUID;

public class Reservation {
    private UUID id;
    private final List<Client> clients;
    private final CampingSpot spot;

    public Reservation(UUID id, List<Client> clients, CampingSpot spot) {
        this.id = id;
        this.clients = clients;
        this.spot = spot;
    }

    public UUID getId() {
        return id;
    }

    public List<Client> getClients() {
        return clients;
    }

    public CampingSpot getSpot() {
        return spot;
    }
}
