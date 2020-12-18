package pl.pzp.Camping.dao;

import pl.pzp.Camping.model.Client;

import java.util.UUID;

public interface Dao {
    int insertClient(UUID id, Client client);

    default int insertClient(Client client) {
        UUID id = UUID.randomUUID();
        return insertClient(id, client);
    }
}
