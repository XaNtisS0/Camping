package pl.pzp.Camping.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.pzp.Camping.dao.interfaces.ClientDao;
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

    public int addClient(Client client) {
        try {
            //Checking if id of provided client isn't already assigned to any other client.
            if (clientDao.getAllClients().stream().anyMatch(client1 -> client1.getId() == client.getId())){
                throw new Exception("There already is a client with this ID.");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return clientDao.insertClient(client);
    }

    public List<Client> getAllClients() {
        try {
            //Checking if clients list is not empty.
            if (clientDao.getAllClients().isEmpty()) {
                throw new Exception("There are no saved Clients.");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return clientDao.getAllClients();
    }

    public Optional<Client> getClientById(UUID id) {
        try {
            //Checking if provided id is assigned to any client.
            if (clientDao.getAllClients().stream().noneMatch(reservation -> reservation.getId() == id)){
                throw new Exception("There is no client with this id.");
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return clientDao.selectClientById(id);
    }

    public int deleteClientById(UUID id) {
        try {
            //Checking if provided id is assigned to any client.
            if (clientDao.getAllClients().stream().noneMatch(reservation -> reservation.getId() == id)){
                throw new Exception("There is no client with this id.");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return clientDao.deleteClientById(id);
    }

    public int updateClientById(UUID id, Client clientToUpdate) {
        try {
            //Checking if provided id is assigned to any client.
            if (clientDao.getAllClients().stream().noneMatch(reservation -> reservation.getId() == id)){
                throw new Exception("There is no client with this id.");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return clientDao.updateClientById(id, clientToUpdate);
    }

}
