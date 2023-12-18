package com.example.shopOnline.dao;


import com.example.shopOnline.dto.ProductDto;
import com.example.shopOnline.entities.Cart;
import com.example.shopOnline.entities.Product;
import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;

import java.util.List;

public class ProductDAO implements ActionDAO<Product> {
    @Override
    public boolean create(Product o) {
        return HibernateUtil.create(o);
    }

    @Override
    public Product update(Product o) {
        return (Product) HibernateUtil.update(o);
    }

    @Override
    public boolean delete(Product o) {
        return HibernateUtil.delete(o);
    }

    @Override
    public boolean deleteById(String id) {
        return HibernateUtil.removeByID(id,Cart.class);
    }

    @Override
    public List<Product> retrieveAll() {

        try(Session session=HibernateUtil.getSessionFactory().openSession()) {
            SelectionQuery<Product> query=session.createSelectionQuery("from Product", Product.class);
            List<Product> products=query.getResultList();
            return products;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;

    }
    public List<ProductDto> retrieveAllDto() {

        try(Session session=HibernateUtil.getSessionFactory().openSession()) {
            SelectionQuery<ProductDto> query=
                    session.createSelectionQuery("select " +
                            "new com.example.shopOnline.dto.ProductDto(" +
                            "p.id," +
                            "p.productName," +
                            "p.productDescription," +
                            "p.dossier," +
                            "p.category.id," +
                            "p.inStock," +
                            "p.price," +
                            "p.brand," +
                            "p.nbrImage," +
                            "p.dateAdded)  from Product p", ProductDto.class);
            List<ProductDto> products=query.getResultList();
            return products;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;

    }
    @Override
    public Product retrieveById(String id) {
        return (Product) HibernateUtil.getByID(id,Product.class);
    }
}
