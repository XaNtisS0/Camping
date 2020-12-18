package pl.pzp.Camping.service;

import pl.pzp.Camping.dao.Dao;
import pl.pzp.Camping.model.Client;

public class Service {

    private final Dao dao;

    public Service(Dao dao) {
        this.dao = dao;
    }

    public int addClient(Client client) {
        return dao.insertClient(client);
    }
}
