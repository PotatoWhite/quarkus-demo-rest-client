package me.potato.demo.model;

import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Set;
import java.util.concurrent.CompletionStage;

@Path("/country")
public class CountriesResource {

  @Inject
  @RestClient
  CountriesClient countriesClient;

  @GET
  @Path("/name/{name}")
  public Set<Country> name(@PathParam String name) {
    return countriesClient.getByName(name);
  }

  @GET
  @Path("/name-async/{name}")
  public CompletionStage<Set<Country>> nameAsync(@PathParam String name) {
    return countriesClient.getByNameAsync(name);
  }

  @GET
  @Path("/name-uni/{name}")
  public Uni<Set<Country>> nameUni(@PathParam String name) {
    return countriesClient.getByNameUni(name)
                          .onFailure()
                          .retry()
                          .atMost(2);
  }
}
