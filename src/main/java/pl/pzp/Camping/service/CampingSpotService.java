package pl.pzp.Camping.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.pzp.Camping.dao.CampingSpotDao;
import pl.pzp.Camping.model.CampingSpot;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CampingSpotService {

    private final CampingSpotDao campingSpotDao;

    @Autowired
    public CampingSpotService(@Qualifier("memoryCampingSpot") CampingSpotDao campingSpotDao) {
        this.campingSpotDao = campingSpotDao;
    }

    public int addCampingSpot(CampingSpot campingSpot) {
        return campingSpotDao.insertCampingSpot(campingSpot);
    }

    public List<CampingSpot> getAllCampingSpots() {
        return campingSpotDao.getAllCampingSpots();
    }

    public Optional<CampingSpot> getCampingSpotById(UUID id) {
        return campingSpotDao.selectCampingSpotById(id);
    }

    public int deleteCampingSpotById(UUID id) {
        return campingSpotDao.deleteCampingSpotById(id);
    }

}
