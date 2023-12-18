package com.example.shopOnline.dao;


import com.example.shopOnline.entities.City;
import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;

import java.util.List;

public class CityDAO implements ActionDAO<City> {
    @Override
    public boolean create(City o) {
        return HibernateUtil.create(o);
    }

    @Override
    public City update(City o) {
        return (City) HibernateUtil.update(o);
    }

    @Override
    public boolean delete(City o) {
        return HibernateUtil.delete(o);
    }

    @Override
    public boolean deleteById(String id) {
        return HibernateUtil.removeByID(id,City.class);
    }

    @Override
    public List<City> retrieveAll() {

        try(Session session=HibernateUtil.getSessionFactory().openSession()) {
            SelectionQuery<City> query=session.createSelectionQuery("from City", City.class);
            return query.getResultList();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;

    }

    @Override
    public City retrieveById(String id) {
        return (City) HibernateUtil.getByID(id,City.class);
    }
}
