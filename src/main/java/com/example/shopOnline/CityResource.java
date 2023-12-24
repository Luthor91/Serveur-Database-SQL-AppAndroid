package com.example.shopOnline;

import com.example.shopOnline.dao.CityDAO;
import com.example.shopOnline.dao.CityDAO;
import com.example.shopOnline.entities.City;
import com.example.shopOnline.entities.City;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/City")
public class CityResource {
    private final CityDAO cityDAO=new CityDAO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<City> getCities(){
        List<City> cities=cityDAO.retrieveAll();
        if(cities==null)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return cities;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public City getCityById(@PathParam("id") String id) {
        City city = cityDAO.retrieveById(id);
        if(city==null)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return city;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean createCity(City city) {
        boolean isCreated = cityDAO.create(city);
        if(!isCreated)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return true;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public City updateCity(City city) {
        City newCity = cityDAO.update(city);
        if(newCity == null)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return newCity;
    }

    @DELETE
    @Path("/{id}")
    public boolean deleteCity(@PathParam("id") String id) {
        boolean city = cityDAO.deleteById(id);
        if(!city)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return true;
    }
}
