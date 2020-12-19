package pl.pzp.Camping.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.pzp.Camping.model.CampingSpot;
import pl.pzp.Camping.service.CampingSpotService;

import javax.validation.Valid;
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
    public void addCampingSpot(@RequestBody CampingSpot campingSpot) {
        campingSpotService.addCampingSpot(campingSpot);
    }

    @GetMapping
    public List<CampingSpot> getAllCampingSpots() {
        return campingSpotService.getAllCampingSpots();
    }

    @GetMapping(path = "{id}")
    public CampingSpot getCampingSpotById(@PathVariable("id") UUID id) {
        return campingSpotService.getCampingSpotById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCampingSpotById(@PathVariable("id") UUID id) {
        campingSpotService.deleteCampingSpotById(id);
    }

    @PutMapping(path = "{id}")
    public void updateCampingSpotById(@PathVariable("id") UUID id, @RequestBody CampingSpot campingSpotToUpdate){
        campingSpotService.updateCampingSpotById(id, campingSpotToUpdate);
    }

}
