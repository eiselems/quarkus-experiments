package com.programmerfriend.quarkus.gettingstarted;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
            .queryParam("name", "Marcus")
        .when().get("/hello")
        .then()
            .statusCode(200)
            .body(is("hello Marcus"));
    }

    @Test
    public void testAsyncHelloEndpoint() {
        given()
            .queryParam("name", "Marcus")
            .when().get("/hello/async")
            .then()
            .statusCode(200)
            .body(is("hello Marcus"));
    }

}