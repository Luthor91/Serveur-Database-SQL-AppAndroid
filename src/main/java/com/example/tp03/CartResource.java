package com.example.tp03;

import com.example.tp03.dao.CartDAO;
import com.example.tp03.entities.Cart;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/CART")
public class CartResource {
    private CartDAO cartDAO=new CartDAO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cart> getCarts(){
        List<Cart> carts=cartDAO.retrieveAll();
        if(carts==null)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return carts;
    }
}
