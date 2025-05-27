package dao;

import models.CarPart;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class CarPartDao {

    public CarPart findById(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(CarPart.class, id);
        }
    }

    public void save(CarPart carPart) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(carPart);
            transaction.commit();
        }
    }

    public void update(CarPart carPart) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(carPart);
            transaction.commit();
        }
    }

    public void delete(CarPart carPart) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(carPart);
            transaction.commit();
        }
    }

    public List<CarPart> findAll() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("from CarPart", CarPart.class).list();
        }
    }
}