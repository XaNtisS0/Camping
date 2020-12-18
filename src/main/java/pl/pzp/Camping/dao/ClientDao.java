package pl.pzp.Camping.dao;

import pl.pzp.Camping.model.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientDao  {

    int insertClient(UUID id, Client client);

    default int insertClient(Client client) {
        UUID id = UUID.randomUUID();
        return insertClient(id, client);
    }

    List<Client> getAllClients();

    Optional<Client> selectClientById(UUID id);

    int deleteClientById(UUID id);
}
