package services;

import dao.AutoDao;
import models.Auto;

import java.util.List;

public class AutoService {

    private AutoDao autoDao = new AutoDao();

    public Auto findAuto(int id) {
        return autoDao.findById(id);
    }

    public void saveAuto(Auto auto) {
        autoDao.save(auto);
    }

    public void deleteAuto(Auto auto) {
        autoDao.delete(auto);
    }

    public void updateAuto(Auto auto) {
        autoDao.update(auto);
    }

    public List<Auto> findAllAutos() {
        return autoDao.findAll();
    }
}