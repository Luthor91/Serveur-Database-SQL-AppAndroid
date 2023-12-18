package com.example.shopOnline.dao;


import com.example.shopOnline.dto.UserDto;
import com.example.shopOnline.entities.Cart;
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
        return HibernateUtil.removeByID(id,Cart.class);
    }

    @Override
    public List<User> retrieveAll() {

        try(Session session=HibernateUtil.getSessionFactory().openSession()) {
            SelectionQuery<User> query=session.createSelectionQuery("from User", User.class);
            return query.getResultList();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;

    }
    public List<UserDto> retrieveAllDto() {

        try(Session session=HibernateUtil.getSessionFactory().openSession()) {
            SelectionQuery<UserDto> query=
                    session.createSelectionQuery("select " +
                            "new com.example.shopOnline.dto.UserDto(" +
                            "c.id," +
                            "c.userName," +
                            "c.userEmail," +
                            "c.userAdress)  from User c", UserDto.class);
            return query.getResultList();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;

    }
    @Override
    public User retrieveById(String id) {
        return (User) HibernateUtil.getByID(id,User.class);
    }
}
