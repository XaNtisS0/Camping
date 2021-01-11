package pl.pzp.Camping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
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
            return campingSpotDao.insertCampingSpot(campingSpot);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Can't add.");
        }
    }

    public List<CampingSpot> getAllCampingSpots() {
        try {
            //Checking if camping spot list is not empty.
            if (campingSpotDao.getAllCampingSpots().isEmpty()) {
                throw new Exception("There are no camping spots.");
            }
            return campingSpotDao.getAllCampingSpots();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Can't add.");
        }
    }

    public Optional<CampingSpot> getCampingSpotById(UUID id) {
        try {
            //Checking if provided id is assigned to any camping spot.
            if (campingSpotDao.getAllCampingSpots().stream().noneMatch(reservation -> reservation.getId() == id)){
                throw new Exception("There is no camping spot with this id.");
            }
            return campingSpotDao.selectCampingSpotById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Can't add.");
        }
    }

    public int deleteCampingSpotById(UUID id) {
        try {
            //Checking if provided id is assigned to any camping spot.
            if (campingSpotDao.getAllCampingSpots().stream().noneMatch(reservation -> reservation.getId() == id)){
                throw new Exception("There is no camping spot with this id.");
            }
            return campingSpotDao.deleteCampingSpotById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Can't add.");
        }
    }

    public int updateCampingSpotById(UUID id, CampingSpot campingSpot) {
        try {
            //Checking if provided id is assigned to any camping spot.
            if (campingSpotDao.getAllCampingSpots().stream().noneMatch(reservation -> reservation.getId() == id)){
                throw new Exception("There is no camping spot with this id.");
            }
            return campingSpotDao.updateCampingSpotById(id, campingSpot);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Can't update");
        }
    }

}
