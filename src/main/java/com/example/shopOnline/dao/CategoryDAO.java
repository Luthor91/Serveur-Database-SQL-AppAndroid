package com.example.shopOnline.dao;


import com.example.shopOnline.dto.CategoryDto;
import com.example.shopOnline.entities.Cart;
import com.example.shopOnline.entities.Category;
import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;

import java.util.List;

public class CategoryDAO implements ActionDAO<Category> {
    @Override
    public boolean create(Category o) {
        return HibernateUtil.create(o);
    }

    @Override
    public Category update(Category o) {
        return (Category) HibernateUtil.update(o);
    }

    @Override
    public boolean delete(Category o) {
        return HibernateUtil.delete(o);
    }

    @Override
    public boolean deleteById(String id) {
        return HibernateUtil.removeByID(id,Cart.class);
    }

    @Override
    public List<Category> retrieveAll() {

        try(Session session=HibernateUtil.getSessionFactory().openSession()) {
            SelectionQuery<Category> query=session.createSelectionQuery("from Category", Category.class);
            List<Category> products=query.getResultList();
            return products;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;

    }
    public List<CategoryDto> retrieveAllDto() {

        try(Session session=HibernateUtil.getSessionFactory().openSession()) {
            SelectionQuery<CategoryDto> query=
                    session.createSelectionQuery("select " +
                            "new com.example.shopOnline.dto.CategoryDto(" +
                            "c.id," +
                            "c.title," +
                            "c.webTitle," +
                            "c.leval)  from Category c", CategoryDto.class);
            List<CategoryDto> categoryDtos=query.getResultList();
            return categoryDtos;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;

    }
    @Override
    public Category retrieveById(String id) {
        return (Category) HibernateUtil.getByID(id,Category.class);
    }
}
