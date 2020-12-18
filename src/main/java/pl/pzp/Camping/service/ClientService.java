package pl.pzp.Camping.service;


import pl.pzp.Camping.dao.ClientDao;
import pl.pzp.Camping.model.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ClientService {

    private final ClientDao clientDao;

    public ClientService(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public int addClient(Client client) { return clientDao.insertClient(client); }

    public List<Client> getAllClients() { return clientDao.getAllClients(); }

    public Optional<Client> getClientById(UUID id) { return clientDao.selectClientById(id); }

    public int deleteClientById(UUID id) {return clientDao.deleteClientById(id); }

}
