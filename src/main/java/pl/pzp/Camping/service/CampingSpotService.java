package pl.pzp.Camping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.pzp.Camping.dao.interfaces.CampingSpotDao;
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
        try {
            //Checking if id of provided camping spot is not assigned to any other camping spot.
            if (campingSpotDao.getAllCampingSpots().stream().anyMatch(reservation -> reservation.getId() == campingSpot.getId())) {
                throw new Exception("There already is camping spot with this id.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return campingSpotDao.insertCampingSpot(campingSpot);
    }

    public List<CampingSpot> getAllCampingSpots() {
        try {
            //Checking if camping spot list is not empty.
            if (campingSpotDao.getAllCampingSpots().isEmpty()) {
                throw new Exception("There are no Camping Spots.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return campingSpotDao.getAllCampingSpots();
    }

    public Optional<CampingSpot> getCampingSpotById(UUID id) {
        try {
            //Checking if provided id is assigned to any camping spot.
            if (campingSpotDao.getAllCampingSpots().stream().noneMatch(reservation -> reservation.getId() == id)){
                throw new Exception("There is no client with this id.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return campingSpotDao.selectCampingSpotById(id);
    }

    public int deleteCampingSpotById(UUID id) {
        try {
            //Checking if provided id is assigned to any camping spot.
            if (campingSpotDao.getAllCampingSpots().stream().noneMatch(reservation -> reservation.getId() == id)){
                throw new Exception("There is no client with this id.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return campingSpotDao.deleteCampingSpotById(id);
    }

    public int updateCampingSpotById(UUID id, CampingSpot campingSpot) {
        try {
            //Checking if provided id is assigned to any camping spot.
            if (campingSpotDao.getAllCampingSpots().stream().noneMatch(reservation -> reservation.getId() == id)){
                throw new Exception("There is no client with this id.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return campingSpotDao.updateCampingSpotById(id, campingSpot);
    }

}
