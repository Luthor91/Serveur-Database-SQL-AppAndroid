package com.example.shopOnline;

import com.example.shopOnline.dao.ProductDAO;

import com.example.shopOnline.dto.ProductDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/Product")
public class ProductResource {
    private ProductDAO productDAO=new ProductDAO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductDto> getProducts(){
        List<ProductDto> products=productDAO.retrieveAllDto();
        if(products==null)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return products;
    }
}
