package pl.pzp.Camping.model;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

public class Reservation {

    private UUID id;
    @NotNull
    private final List<Client> clients;
    @NotNull
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
