package com.khan.api;

import com.khan.dao.GenericEntityDao;
import com.khan.entity.ZipCode;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("zip")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ZipCodeAPI {

    @Inject
    GenericEntityDao<ZipCode> zipcodeDAO;

    @GET
    public Response getAll() {
        return Response.ok(zipcodeDAO.find("01830", ZipCode.class)).build();
    }

}
