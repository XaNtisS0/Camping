package pl.pzp.Camping.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.pzp.Camping.model.Reservation;
import pl.pzp.Camping.service.ReservationService;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/reservation")
@RestController
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public void addReservation(@RequestBody Reservation reservation) {
        reservationService.addReservation(reservation);
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping
    public Reservation getReservationById(UUID id) {
        return reservationService.getReservationById(id).orElse(null);
    }

    @DeleteMapping
    public void deleteReservationById(UUID id) {
        reservationService.deleteReservationById(id);
    }
}
