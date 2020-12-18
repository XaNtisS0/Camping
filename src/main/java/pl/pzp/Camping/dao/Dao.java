package pl.pzp.Camping.dao;

import pl.pzp.Camping.model.CampingSpot;
import pl.pzp.Camping.model.Client;
import pl.pzp.Camping.model.Reservation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Dao {
    int insertClient(UUID id, Client client);

    default int insertClient(Client client) {
        UUID id = UUID.randomUUID();
        return insertClient(id, client);
    }

    int insertCampingSpot(UUID id, CampingSpot campingSpot);

    default int insertCampingSpot(CampingSpot campingSpot) {
        UUID id = UUID.randomUUID();
        return insertCampingSpot(id, campingSpot);
    }

    int insertReservation(UUID id, Reservation reservation);

    default int insertReservation(Reservation reservation) {
        UUID id = UUID.randomUUID();
        return insertReservation(id, reservation);
    }

    Optional<Client> selectClientById(UUID id);
    Optional<CampingSpot> selectCampingSpotById(UUID id);
    Optional<Reservation> selectReservationById(UUID id);

    int deleteClientById(UUID id);

    int deleteCampingSpotById(UUID id);

    int deleteReservation(UUID id);

}
