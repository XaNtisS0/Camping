package pl.pzp.Camping.dao;

import pl.pzp.Camping.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class fakeDao implements Dao {

    private static List<Client> DB = new ArrayList<>();

    @Override
    public int insertClient(UUID id, Client client) {
        DB.add(new Client(id, client.getName(), client.getAge()));
        return 1;
    }

}
