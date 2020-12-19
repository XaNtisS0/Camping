package pl.pzp.Camping.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.pzp.Camping.dao.ClientDao;
import pl.pzp.Camping.model.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {

    private final ClientDao clientDao;

    @Autowired
    public ClientService(@Qualifier("memoryClient") ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public int addClient(Client client) { return clientDao.insertClient(client); }

    public List<Client> getAllClients() { return clientDao.getAllClients(); }

    public Optional<Client> getClientById(UUID id) { return clientDao.selectClientById(id); }

    public int deleteClientById(UUID id) {return clientDao.deleteClientById(id); }

    public int updateClientById(UUID id, Client clientToUpdate) { return clientDao.updateClientById(id, clientToUpdate); }

}
