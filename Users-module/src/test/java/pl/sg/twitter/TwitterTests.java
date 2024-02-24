package pl.sg.twitter;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class TwitterTests {

    @Test
    void contextLoads() {
    }

    @Test
    void shouldReturnPong() {
        RestAssured
                .given()
                .get("http://localhost:8080/ping")
                .then()
                .statusCode(200)
                .body(Matchers.matchesPattern("pong"));
    }
}