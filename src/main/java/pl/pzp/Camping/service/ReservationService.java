package pl.pzp.Camping.service;

import pl.pzp.Camping.dao.ReservationDao;
import pl.pzp.Camping.model.Reservation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ReservationService {

    private final ReservationDao reservationDao;

    public ReservationService(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }

    public int addReservation(Reservation reservation) {
        return reservationDao.insertReservation(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationDao.getAllReservations();
    }

    public Optional<Reservation> getReservationById(UUID id) {
        return reservationDao.selectReservationById(id);
    }

    public int deleteReservationById(UUID id) {
        return reservationDao.deleteReservation(id);
    }
}
