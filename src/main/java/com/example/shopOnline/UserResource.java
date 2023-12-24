package com.example.shopOnline;

import com.example.shopOnline.dao.UserDAO;
import com.example.shopOnline.entities.User;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/User")
public class UserResource {
    private final UserDAO userDAO=new UserDAO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers(){
        List<User> users=userDAO.retrieveAll();
        if(users==null)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return users;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id") String id) {
        User user = userDAO.retrieveById(id);
        if(user==null)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return user;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean createUser(User user) {
        boolean isCreated = userDAO.create(user);
        if(!isCreated)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return true;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public User updateUser(User user) {
        User newUser = userDAO.update(user);
        if(newUser == null)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return newUser;
    }

    @DELETE
    @Path("/{id}")
    public boolean deleteUser(@PathParam("id") String id) {
        boolean user = userDAO.deleteById(id);
        if(!user)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return true;
    }

}
