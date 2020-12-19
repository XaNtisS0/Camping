package pl.pzp.Camping.dao;

import org.springframework.stereotype.Repository;
import pl.pzp.Camping.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository("memoryClient")
public class MemoryClientDao implements ClientDao {

    private static List<Client> CL = new ArrayList<>();

    @Override
    public int insertClient(UUID id, Client client) {
        CL.add(new Client(id, client.getName(), client.getAge()));
        return 1;
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
