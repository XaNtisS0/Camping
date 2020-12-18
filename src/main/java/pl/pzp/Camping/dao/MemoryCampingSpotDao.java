package pl.pzp.Camping.dao;

import org.springframework.stereotype.Repository;
import pl.pzp.Camping.model.CampingSpot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("memoryCampingSpot")
public class MemoryCampingSpotDao implements CampingSpotDao {

    private static List<CampingSpot> CS = new ArrayList<>();

    @Override
    public int insertCampingSpot(UUID id, CampingSpot campingSpot) {
        CS.add(new CampingSpot(id, campingSpot.getBasePrice(), campingSpot.getGuestsLimit()));
        return 1;
    }

    @Override
    public List<CampingSpot> getAllCampingSpots() {
        return CS;
    }

    @Override
    public Optional<CampingSpot> selectCampingSpotById(UUID id) {
        return CS.stream()
                .filter(campingSpot -> campingSpot.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteCampingSpotById(UUID id) {
        Optional<CampingSpot> campingSpotOptional = selectCampingSpotById(id);
        if(campingSpotOptional.isEmpty()) {
            return 0;
        } else {
            CS.remove(campingSpotOptional.get());
            return 1;
        }
    }

}
