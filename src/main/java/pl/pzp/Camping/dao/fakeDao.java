package pl.pzp.Camping.dao;

import pl.pzp.Camping.model.CampingSpot;
import pl.pzp.Camping.model.Client;
import pl.pzp.Camping.model.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class fakeDao implements Dao {

    private static List<Client> CL = new ArrayList<>();
    private static List<CampingSpot> CS = new ArrayList<>();
    private static List<Reservation> RL = new ArrayList<>();

    @Override
    public int insertClient(UUID id, Client client) {
        CL.add(new Client(id, client.getName(), client.getAge()));
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

    @Override
    public Optional<Client> selectClientById(UUID id) {
        return CL.stream()
                .filter(client -> client.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<CampingSpot> selectCampingSpotById(UUID id) {
        return CS.stream()
                .filter(campingSpot -> campingSpot.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Reservation> selectReservationById(UUID id) {
        return RL.stream()
                .filter(reservation -> reservation.getId().equals(id))
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

    @Override
    public int deleteCampingSpotById(UUID id) {
        Optional<CampingSpot> campingSpotOptional = selectCampingSpotById(id);
        if(campingSpotOptional.isEmpty()) {
            return 0;
        } else {
            CS.remove(campingSpotOptional.get());
            return 1;
        }
    }

    @Override
    public int deleteReservation(UUID id) {
        Optional<Reservation> reservationOptional = selectReservationById(id);
        if(reservationOptional.isEmpty()) {
            return 0;
        } else {
            RL.remove(reservationOptional.get());
            return 1;
        }
    }

}
