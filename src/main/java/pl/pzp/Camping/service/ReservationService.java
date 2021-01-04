package pl.pzp.Camping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.pzp.Camping.dao.interfaces.ReservationDao;
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
        try {
            //Checking if guestsLimit of  is bigger than size of List in provided reservation
            if (reservation.getClients().size() > reservation.getSpot().getGuestsLimit()){
                throw new Exception("You listed many clients for this camping spot.");
            }
            //Checking if spot in provided reservation equals any in already existing list of reservations.
            if (reservationDao.getAllReservations().stream().anyMatch(reservation1 -> reservation1.getSpot().equals(reservation.getSpot()))){
                throw new Exception("You can't make 2 reservation to the same camping spot.");
            }
            //Checking if id of provided reservation isn't already assigned to any other reservation.
            if (reservationDao.getAllReservations().stream().anyMatch(reservation1 -> reservation1.getId() == reservation.getId())){
                throw new Exception("There already is a reservation with this ID.");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return reservationDao.insertReservation(reservation);
    }

    public List<Reservation> getAllReservations() {
        try {
            //Checking if reservations list is not empty.
            if (reservationDao.getAllReservations().isEmpty()){
                throw new Exception("There are no reservations made.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservationDao.getAllReservations();
    }

    public Optional<Reservation> getReservationById(UUID id) {
        try {
            //Checking if provided id is assigned to any reservation.
            if (reservationDao.getAllReservations().stream().noneMatch(reservation -> reservation.getId() == id)){
                throw new Exception("There is no reservation with this id.");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return reservationDao.selectReservationById(id);
    }

    public int deleteReservationById(UUID id) {
        try {
            //Checking if provided id is assigned to any reservation.
            if (reservationDao.getAllReservations().stream().noneMatch(reservation -> reservation.getId() == id)){
                throw new Exception("There is no reservation with this id.");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return reservationDao.deleteReservation(id);
    }

    public int updateReservationById(UUID id, Reservation reservationToUpdate) {
        try {
            //Checking if provided id is assigned to any reservation.
            if (reservationDao.getAllReservations().stream().noneMatch(reservation -> reservation.getId() == id)){
                throw new Exception("There is no reservation with this id.");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return reservationDao.updateReservationById(id, reservationToUpdate);
    }

}
