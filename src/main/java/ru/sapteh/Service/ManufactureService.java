package ru.sapteh.Service;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.Manufacture;

import java.util.List;

public class ManufactureService implements DAO<Manufacture,Integer> {
    private final SessionFactory factory;

    public ManufactureService(SessionFactory factory) {
        this.factory = factory;
    }

    public void create(Manufacture manufacture) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(manufacture);
            session.getTransaction().commit();
        }
    }

    public void update(Manufacture manufacture) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(manufacture);
            session.getTransaction().commit();
        }
    }

    public List<Manufacture> readAllBy() {
        try(Session session = factory.openSession()) {
            Query<Manufacture> result = session.createQuery("FROM Manufacture");
            return result.list();
        }

    }

    public void delete(Manufacture manufacture) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(manufacture);
            session.getTransaction().commit();
        }
    }

    public Manufacture read(Integer integer) {
        try(Session session = factory.openSession()) {
            Manufacture result = session.get(Manufacture.class,integer);

            if (result != null){
                Hibernate.initialize(result.getProducts());
            }
            return result;
        }

    }
}
