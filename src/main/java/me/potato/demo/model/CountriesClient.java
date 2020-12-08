package me.potato.demo.model;

import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Set;
import java.util.concurrent.CompletionStage;

@Path("v2")
@RegisterRestClient(configKey="country-api")
public interface CountriesClient {

  @GET
  @Path("/name/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  Set<Country> getByName(@PathParam String name);


  @GET
  @Path("/name/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  CompletionStage<Set<Country>> getByNameAsync(@PathParam String name);

  @GET
  @Path("/name/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  Uni<Set<Country>> getByNameUni(@PathParam String name);


}
