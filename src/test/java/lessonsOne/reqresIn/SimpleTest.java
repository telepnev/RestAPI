package lessonsOne.reqresIn;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

public class SimpleTest {

    @BeforeEach
    public void baseUrl() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test
    void getTest() {
        given()
                .when()
        .get("/users?page=2")
                .then()
                .statusCode(200)
                .body("total", is(12))
                .body("total_pages", is(2))
                .body("support.url", is("https://reqres.in/#support-heading"));

    }

    @Test
    void loginTest() {
        given()
                .contentType(JSON)
                .body("{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }")
                .when()
                .post("/login")
                .then()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));

    }
}
