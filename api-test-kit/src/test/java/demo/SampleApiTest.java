package demo;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class SampleApiTest {

    @BeforeAll
    static void setup() {
        // Base URI for your tests
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    void testGetUser() {
        var response = given()
                .when()
                .get("/users/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("username", equalTo("Bret"));
    }

    @Test
    void testGetUser_printBody() {
        var response =
                given()
                        .when()
                        .get("/users/1");

        // Print the body as string
        System.out.println(response.getBody().asString());
    }
}