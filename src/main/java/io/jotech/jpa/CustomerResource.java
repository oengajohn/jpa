package io.jotech.jpa;

import java.math.BigInteger;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.jotech.jpa.boundary.CustomerRepository;
import io.jotech.jpa.domain.Customer;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {
    @Inject
    private CustomerRepository customerRepository;

    @POST
    public Response insert(Customer customer) {
        return Response.ok().entity(
                customerRepository.insert(customer)
        ).build();
    }
    @GET
    @Path("{id}")
    public Response read(@PathParam("id")BigInteger id) {
        return Response.ok().entity(
                customerRepository.read(id)
        ).build();
    }
    @GET
    public Response list() {
        return Response.ok().entity(
                customerRepository.list()
        ).build();
    }


}