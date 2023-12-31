package com.example.tp03;

import com.example.tp03.dao.CategoryDAO;
import com.example.tp03.dao.ProductDAO;
import com.example.tp03.dto.CategoryDto;
import com.example.tp03.dto.ProductDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/Category")
public class CategoryResource {
    private CategoryDAO categoryDAO=new CategoryDAO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoryDto> getCategories(){
        List<CategoryDto> categories=categoryDAO.retrieveAllDto();
        if(categories==null)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return categories;
    }
}
