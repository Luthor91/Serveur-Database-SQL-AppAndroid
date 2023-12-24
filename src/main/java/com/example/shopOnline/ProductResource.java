package com.example.shopOnline;

import com.example.shopOnline.dao.ProductDAO;

import com.example.shopOnline.dao.ProductDAO;
import com.example.shopOnline.entities.Product;
import com.example.shopOnline.entities.Product;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/Product")
public class ProductResource {
    private final ProductDAO productDAO=new ProductDAO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProducts(){
        List<Product> products=productDAO.retrieveAll();
        if(products==null)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return products;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProductById(@PathParam("id") String id) {
        Product product = productDAO.retrieveById(id);
        if(product==null)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return product;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean createProduct(Product product) {
        boolean isCreated = productDAO.create(product);
        if(!isCreated)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return true;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Product updateProduct(Product product) {
        Product newProduct = productDAO.update(product);
        if(newProduct == null)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return newProduct;
    }

    @DELETE
    @Path("/{id}")
    public boolean deleteProduct(@PathParam("id") String id) {
        boolean product = productDAO.deleteById(id);
        if(!product)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return true;
    }
}
