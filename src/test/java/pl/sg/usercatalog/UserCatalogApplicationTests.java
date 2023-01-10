package pl.sg.usercatalog;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class UserCatalogApplicationTests {

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