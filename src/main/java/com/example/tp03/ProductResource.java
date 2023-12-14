package com.example.tp03;

import com.example.tp03.dao.ProductDAO;

import com.example.tp03.dto.ProductDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/Product")
public class ProductResource {
    private ProductDAO cartDAO=new ProductDAO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductDto> getProducts(){
        List<ProductDto> products=cartDAO.retrieveAllDto();
        if(products==null)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return products;
    }
}
