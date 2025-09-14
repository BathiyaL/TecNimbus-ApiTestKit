package demo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class PetStoreApiTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    void testCreatePet() {
        String petJson = """
            {
              "id": 123456,
              "category": {
                "id": 1,
                "name": "dog"
              },
              "name": "Rex",
              "photoUrls": [
                "http://example.com/dog.jpg"
              ],
              "tags": [
                {
                  "id": 1,
                  "name": "friendly"
                }
              ],
              "status": "available"
            }
            """;

        given()
                .contentType(ContentType.JSON)
                .body(petJson)
                .when()
                .post("/pet")
                .then()
                .statusCode(200)
                .body("name", equalTo("Rex"))
                .body("status", equalTo("available"));
    }
}
