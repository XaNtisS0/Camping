package pl.pzp.Camping.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.pzp.Camping.model.CampingSpot;
import pl.pzp.Camping.model.Client;
import pl.pzp.Camping.service.CampingSpotService;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/campingSpot")

@RestController
public class CampingSpotController {

    private final CampingSpotService campingSpotService;

    @Autowired
    public CampingSpotController(CampingSpotService campingSpotService) {
        this.campingSpotService = campingSpotService;
    }

    @PostMapping
    public void addClient(@RequestBody CampingSpot campingSpot) {
        campingSpotService.addCampingSpot(campingSpot);
    }

    @GetMapping
    public List<CampingSpot> getAllCampingSpots() {
        return campingSpotService.getAllCampingSpots();
    }

    @GetMapping
    public CampingSpot getCampingSpotById(UUID id) {
        return campingSpotService.getCampingSpotById(id)
                .orElse(null);
    }

    @DeleteMapping
    public void deleteCampingSpotById(UUID id) {
        campingSpotService.deleteCampingSpotById(id);
    }
}
