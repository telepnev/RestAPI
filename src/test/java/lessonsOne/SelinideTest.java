package lessonsOne;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelinideTest {

    @Test
    void successStatusTest() {
        given().when()
                .get("https://selenoid.autotests.cloud/status")
                .then()
                .statusCode(200);
    }

    @Test
    void shortVerTest() {
        get("https://selenoid.autotests.cloud/status")
                .then()
                .statusCode(200);
    }

    @Test
    void test1Test() {
       Response response =  get("https://selenoid.autotests.cloud/status")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println(response.asString());
        System.out.println(response.toString());  // - работать не будет
        System.out.println(response);              // - работать не будет
    }

    @Test
    void test2Test() {
        get("https://selenoid.autotests.cloud/status")
                .then()
                .statusCode(200)
                .body("state.total",is(5));

    }

    @Test
    void test3Test() {
       Integer response =  get("https://selenoid.autotests.cloud/status")
                .then()
                .statusCode(200)
               .extract()
                .path("state.total");

                assertEquals(5,response);

    }

    @Test
    void withAssertJTest() {
        Integer response =  get("https://selenoid.autotests.cloud/status")
                .then()
                .statusCode(200)
                .extract()
                .path("state.total");

        assertThat(response).isEqualTo(6);

    }
}
