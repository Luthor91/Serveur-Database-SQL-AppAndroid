package com.example.shopOnline;

import com.example.shopOnline.dao.UserDAO;
import com.example.shopOnline.dto.UserDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/User")
public class UserResource {
    private final UserDAO userDAO=new UserDAO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDto> getUsers(){
        List<UserDto> Users=userDAO.retrieveAllDto();
        if(Users==null)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return Users;
    }
}
