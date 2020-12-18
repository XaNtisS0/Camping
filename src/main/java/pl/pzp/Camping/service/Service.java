package pl.pzp.Camping.service;

import pl.pzp.Camping.dao.Dao;
import pl.pzp.Camping.model.CampingSpot;
import pl.pzp.Camping.model.Client;
import pl.pzp.Camping.model.Reservation;

public class Service {

    private final Dao dao;

    public Service(Dao dao) {
        this.dao = dao;
    }

    public int addClient(Client client) {
        return dao.insertClient(client);
    }

    public int addCampingSpot(CampingSpot campingSpot) { return dao.insertCampingSpot(campingSpot); }

    public int addReservation(Reservation reservation) { return dao.insertReservation(reservation); }
}
