package pl.pzp.Camping.dao.interfaces;

import pl.pzp.Camping.model.CampingSpot;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CampingSpotDao {

    int insertCampingSpot(UUID id, CampingSpot campingSpot);

    default int insertCampingSpot(CampingSpot campingSpot) {
        UUID id = UUID.randomUUID();
        return insertCampingSpot(id, campingSpot);
    }

    List<CampingSpot> getAllCampingSpots();

    Optional<CampingSpot> selectCampingSpotById(UUID id);

    int deleteCampingSpotById(UUID id);

    int updateCampingSpotById(UUID id, CampingSpot campingSpotToUpdate);

}
