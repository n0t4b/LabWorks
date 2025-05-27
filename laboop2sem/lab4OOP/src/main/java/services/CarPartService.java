package services;

import dao.CarPartDao;
import models.CarPart;

import java.util.List;

public class CarPartService {

    private CarPartDao carPartDao = new CarPartDao();

    public CarPartService() {
    }

    public CarPart findCarPart(int id) {
        return carPartDao.findById(id);
    }

    public void saveCarPart(CarPart carPart) {
        carPartDao.save(carPart);
    }

    public void updateCarPart(CarPart carPart) {
        carPartDao.update(carPart);
    }

    public void deleteCarPart(CarPart carPart) {
        carPartDao.delete(carPart);
    }

    public List<CarPart> findAllCarParts() {
        return carPartDao.findAll();
    }
}