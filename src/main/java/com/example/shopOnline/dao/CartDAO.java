package com.example.shopOnline.dao;


import com.example.shopOnline.entities.Cart;
import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;

import java.util.List;

public class CartDAO implements ActionDAO<Cart> {
    @Override
    public boolean create(Cart o) {
        return HibernateUtil.create(o);
    }

    @Override
    public Cart update(Cart o) {
        return (Cart) HibernateUtil.update(o);
    }

    @Override
    public boolean delete(Cart o) {
        return HibernateUtil.delete(o);
    }

    @Override
    public boolean deleteById(String id) {
        return HibernateUtil.removeByID(id,Cart.class);
    }

    @Override
    public List<Cart> retrieveAll() {

        try(Session session=HibernateUtil.getSessionFactory().openSession()) {
            SelectionQuery<Cart> query=session.createSelectionQuery("from Cart", Cart.class);
            List<Cart> carts=query.getResultList();
            return carts;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;

    }

    @Override
    public Cart retrieveById(String id) {
        return (Cart) HibernateUtil.getByID(id,Cart.class);
    }
}
