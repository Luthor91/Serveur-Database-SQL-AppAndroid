package com.example.shopOnline;

import com.example.shopOnline.dao.CartDAO;
import com.example.shopOnline.dao.CartDAO;
import com.example.shopOnline.entities.Cart;
import com.example.shopOnline.entities.Cart;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/Cart")
public class CartResource {
    private final CartDAO cartDAO=new CartDAO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cart> getCarts(){
        List<Cart> carts=cartDAO.retrieveAll();
        if(carts==null)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return carts;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cart getCartById(@PathParam("id") String id) {
        Cart cart = cartDAO.retrieveById(id);
        if(cart==null)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return cart;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean createCart(Cart cart) {
        boolean isCreated = cartDAO.create(cart);
        if(!isCreated)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return true;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Cart updateCart(Cart cart) {
        Cart newCart = cartDAO.update(cart);
        if(newCart == null)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return newCart;
    }

    @DELETE
    @Path("/{id}")
    public boolean deleteCart(@PathParam("id") String id) {
        boolean cart = cartDAO.deleteById(id);
        if(!cart)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return true;
    }
}
