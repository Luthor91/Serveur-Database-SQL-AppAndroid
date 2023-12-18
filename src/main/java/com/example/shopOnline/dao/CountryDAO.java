package com.example.shopOnline.dao;


import com.example.shopOnline.entities.Country;
import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;

import java.util.List;

public class CountryDAO implements ActionDAO<Country> {
    @Override
    public boolean create(Country o) {
        return HibernateUtil.create(o);
    }

    @Override
    public Country update(Country o) {
        return (Country) HibernateUtil.update(o);
    }

    @Override
    public boolean delete(Country o) {
        return HibernateUtil.delete(o);
    }

    @Override
    public boolean deleteById(String id) {
        return HibernateUtil.removeByID(id,Country.class);
    }

    @Override
    public List<Country> retrieveAll() {

        try(Session session=HibernateUtil.getSessionFactory().openSession()) {
            SelectionQuery<Country> query=session.createSelectionQuery("from Country", Country.class);
            return query.getResultList();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;

    }

    @Override
    public Country retrieveById(String id) {
        return (Country) HibernateUtil.getByID(id,Country.class);
    }
}
