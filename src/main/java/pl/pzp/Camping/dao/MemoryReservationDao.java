package pl.pzp.Camping.dao;

import org.springframework.stereotype.Repository;
import pl.pzp.Camping.model.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("memoryReservation")
public class MemoryReservationDao implements ReservationDao {

    private static List<Reservation> RL = new ArrayList<>();

    @Override
    public int insertReservation(UUID id, Reservation reservation) {
        RL.add(new Reservation(id,reservation.getClients(), reservation.getSpot()));
        return 1;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return RL;
    }

    @Override
    public Optional<Reservation> selectReservationById(UUID id) {
        return RL.stream()
                .filter(reservation -> reservation.getId().equals(id))
                .findFirst();
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

    @Override
    public int updateReservationById(UUID id, Reservation reservationToUpdate) {
        return selectReservationById(id)
                .map(reservation -> {
                    int indexOfReservationToUpdate = RL.indexOf(reservation);
                    if (indexOfReservationToUpdate >= 0) {
                        RL.set(indexOfReservationToUpdate,
                                new Reservation(
                                        id,
                                        reservationToUpdate.getClients(),
                                        reservationToUpdate.getSpot()
                                ));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

}
