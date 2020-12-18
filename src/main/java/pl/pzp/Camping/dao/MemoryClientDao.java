package pl.pzp.Camping.dao;

import pl.pzp.Camping.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MemoryClientDao implements ClientDao {

    private static List<Client> CL = new ArrayList<>();

    @Override
    public int insertClient(UUID id, Client client) {
        return 0;
    }

    @Override
    public int insertClient(Client client) {
        return 0;
    }

    @Override
    public List<Client> getAllClients() {
        return CL;
    }

    @Override
    public Optional<Client> selectClientById(UUID id) {
        return CL.stream()
                .filter(client -> client.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteClientById(UUID id) {
        Optional<Client> clientOptional = selectClientById(id);
        if(clientOptional.isEmpty()) {
            return 0;
        } else {
            CL.remove(clientOptional.get());
            return 1;
        }
    }

}
