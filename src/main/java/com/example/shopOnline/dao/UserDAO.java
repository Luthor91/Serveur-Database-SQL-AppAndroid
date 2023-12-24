package com.example.shopOnline.dao;


import com.example.shopOnline.dto.UserDto;
import com.example.shopOnline.entities.User;
import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;

import java.util.List;

public class UserDAO implements ActionDAO<User> {
    @Override
    public boolean create(User o) {
        return HibernateUtil.create(o);
    }

    @Override
    public User update(User o) {
        return (User) HibernateUtil.update(o);
    }

    @Override
    public boolean delete(User o) {
        return HibernateUtil.delete(o);
    }

    @Override
    public boolean deleteById(String id) {
        return HibernateUtil.removeByID(id,User.class);
    }

    @Override
    public List<User> retrieveAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM User", User.class).list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


    @Override
    public User retrieveById(String id) {
        return (User) HibernateUtil.getByID(id,User.class);
    }
}
