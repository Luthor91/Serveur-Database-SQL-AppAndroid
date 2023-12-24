package com.example.shopOnline;

import com.example.shopOnline.dao.CategoryDAO;
import com.example.shopOnline.dao.CategoryDAO;
import com.example.shopOnline.entities.Category;
import com.example.shopOnline.entities.Category;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/Category")
public class CategoryResource {
    private final CategoryDAO categoryDAO=new CategoryDAO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getCategories(){
        List<Category> categories=categoryDAO.retrieveAll();
        if(categories==null)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return categories;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category getCategoryById(@PathParam("id") String id) {
        Category category = categoryDAO.retrieveById(id);
        if(category==null)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return category;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean createCategory(Category category) {
        boolean isCreated = categoryDAO.create(category);
        if(!isCreated)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return true;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Category updateCategory(Category category) {
        Category newCategory = categoryDAO.update(category);
        if(newCategory == null)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return newCategory;
    }

    @DELETE
    @Path("/{id}")
    public boolean deleteCategory(@PathParam("id") String id) {
        boolean category = categoryDAO.deleteById(id);
        if(!category)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return true;
    }
}
