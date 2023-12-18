package com.example.shopOnline;

import com.example.shopOnline.dao.CountryDAO;
import com.example.shopOnline.dto.CountryDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/Country")
public class CountryResource {
    private CountryDAO countryDAO=new CountryDAO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CountryDto> getCountrys(){
        List<CountryDto> Countrys=countryDAO.retrieveAllDto();
        if(Countrys==null)
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        return Countrys;
    }
}
