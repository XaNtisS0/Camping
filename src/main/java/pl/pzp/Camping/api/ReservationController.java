package pl.pzp.Camping.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.pzp.Camping.model.Reservation;
import pl.pzp.Camping.service.ReservationService;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/reservation")

@RestController
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) { this.reservationService = reservationService; }

    @PostMapping
    public void addReservation(@RequestBody Reservation reservation) {
        reservationService.addReservation(reservation);
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping(path = "{id}")
    public Reservation getReservationById(@Valid @PathVariable("id") UUID id) {
        return reservationService.getReservationById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteReservationById(@PathVariable("id") UUID id) {
        reservationService.deleteReservationById(id);
    }

    @PutMapping(path = "{id}")
    public void updateReservationById(@PathVariable("id") UUID id, @NotNull @Valid @RequestBody Reservation reservation) {
        reservationService.updateReservationById(id, reservation);
    }
}
