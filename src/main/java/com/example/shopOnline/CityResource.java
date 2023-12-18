package com.example.shopOnline;

import com.example.shopOnline.dao.CityDAO;
import com.example.shopOnline.dto.CityDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/City")
public class CityResource {
    private final CityDAO CityDAO=new CityDAO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CityDto> getCategories(){
        List<CityDto> categories=CityDAO.retrieveAllDto();
        if(categories==null)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return categories;
    }
}
