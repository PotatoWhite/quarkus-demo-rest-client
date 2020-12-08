package me.potato.demo.model;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class CountriesResourceTest {

  @Test
  public void testCountryNameEndPoint() {
    given().when()
           .get("/country/name/korea")
           .then()
           .statusCode(Response.Status.OK.getStatusCode())
           .body("$.size()", is(2));
  }

  @Test
  public void testCountryNameEndPointAsync() {
    given().when()
           .get("/country/name-async/korea")
           .then()
           .statusCode(Response.Status.OK.getStatusCode())
           .body("$.size()", is(2));
  }

  @Test
  public void testCountryNameEndPointUni() {
    given().when()
           .get("/country/name-uni/korea")
           .then()
           .statusCode(Response.Status.OK.getStatusCode())
           .body("$.size()", is(2));
  }


}