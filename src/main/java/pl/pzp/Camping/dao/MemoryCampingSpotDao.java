package pl.pzp.Camping.dao;

import org.springframework.stereotype.Repository;
import pl.pzp.Camping.model.CampingSpot;
import pl.pzp.Camping.model.Reservation;

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

    @Override
    public int updateCampingSpotById(UUID id, CampingSpot campingSpotToUpdate) {
        return selectCampingSpotById(id)
                .map(reservation -> {
                    int indexOfCampingSpotToUpdate = CS.indexOf(reservation);
                    if (indexOfCampingSpotToUpdate >= 0) {
                        CS.set(indexOfCampingSpotToUpdate,
                                new CampingSpot(
                                        id,
                                        campingSpotToUpdate.getBasePrice(),
                                        campingSpotToUpdate.getGuestsLimit()
                                ));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

}
