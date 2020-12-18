package pl.pzp.Camping.dao;

import pl.pzp.Camping.model.CampingSpot;
import pl.pzp.Camping.model.Client;
import pl.pzp.Camping.model.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class fakeDao implements Dao {

    private static List<Client> DB = new ArrayList<>();
    private static List<CampingSpot> CS = new ArrayList<>();
    private static List<Reservation> RL = new ArrayList<>();

    @Override
    public int insertClient(UUID id, Client client) {
        DB.add(new Client(id, client.getName(), client.getAge()));
        return 1;
    }

    @Override
    public int insertCampingSpot(UUID id, CampingSpot campingSpot) {
        CS.add(new CampingSpot(id, campingSpot.getBasePrice(), campingSpot.getGuestsLimit()));
        return 1;
    }

    @Override
    public int insertReservation(UUID id, Reservation reservation) {
        RL.add(new Reservation(id,reservation.getClients(), reservation.getSpot()));
        return 1;
    }



}
