package ru.sapteh.Service;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.ProductSale;

import java.util.List;

public class ProductSaleService implements DAO<ProductSale,Integer> {
    private final SessionFactory factory;

    public ProductSaleService(SessionFactory factory) {
        this.factory = factory;
    }

    public void create(ProductSale productSale) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(productSale);
            session.getTransaction().commit();
        }
    }

    public void update(ProductSale productSale) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(productSale);
            session.getTransaction().commit();
        }
    }

    public List<ProductSale> readAllBy() {
        try(Session session = factory.openSession()) {
            Query<ProductSale> result = session.createQuery("FROM ProductSale");
            return result.list();
        }

    }

    public void delete(ProductSale productSale) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(productSale);
            session.getTransaction().commit();
        }
    }

    public ProductSale read(Integer integer) {
        try(Session session = factory.openSession()) {
            ProductSale result = session.get(ProductSale.class,integer);
            return result;
        }

    }
}
