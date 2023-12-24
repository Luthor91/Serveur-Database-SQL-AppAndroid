package com.example.shopOnline;

import com.example.shopOnline.dao.CountryDAO;
import com.example.shopOnline.dao.CountryDAO;
import com.example.shopOnline.entities.Country;
import com.example.shopOnline.entities.Country;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/Country")
public class CountryResource {
    private final CountryDAO countryDAO=new CountryDAO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Country> getCountrys(){
        List<Country> countrys=countryDAO.retrieveAll();
        if(countrys==null)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return countrys;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Country getCountryById(@PathParam("id") String id) {
        Country country = countryDAO.retrieveById(id);
        if(country==null)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return country;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean createCountry(Country country) {
        boolean isCreated = countryDAO.create(country);
        if(!isCreated)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return true;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Country updateCountry(Country country) {
        Country newCountry = countryDAO.update(country);
        if(newCountry == null)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return newCountry;
    }

    @DELETE
    @Path("/{id}")
    public boolean deleteCountry(@PathParam("id") String id) {
        boolean country = countryDAO.deleteById(id);
        if(!country)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return true;
    }
}
