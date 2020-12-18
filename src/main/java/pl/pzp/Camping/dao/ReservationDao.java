package pl.pzp.Camping.dao;

import pl.pzp.Camping.model.Reservation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReservationDao {
    int insertReservation(UUID id, Reservation reservation);

    default int insertReservation(Reservation reservation) {
        UUID id = UUID.randomUUID();
        return insertReservation(id, reservation);
    }

    List<Reservation> getAllReservations();

    Optional<Reservation> selectReservationById(UUID id);


    int deleteReservation(UUID id);
}
