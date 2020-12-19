package pl.pzp.Camping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.pzp.Camping.dao.ReservationDao;
import pl.pzp.Camping.model.Reservation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReservationService {

    private final ReservationDao reservationDao;

    @Autowired
    public ReservationService(@Qualifier("memoryReservation") ReservationDao reservationDao) {
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

    public int updateReservationById(UUID id, Reservation reservationToUpdate) {
        return reservationDao.updateReservationById(id, reservationToUpdate);
    }

}
