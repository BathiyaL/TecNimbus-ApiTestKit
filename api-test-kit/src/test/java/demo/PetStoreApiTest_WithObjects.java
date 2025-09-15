package demo;

import demo.Category;
import demo.Pet;
import demo.Tag;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class PetStoreApiTest_WithObjects {
    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    void testCreatePetWithObject() {
        // Build Pet object
        Pet pet = new Pet();
        pet.setId(987654L);
        pet.setCategory(new Category() {{
            setId(1L);
            setName("dog");
        }});
        pet.setName("Max");
        pet.setPhotoUrls(List.of("http://example.com/max.jpg"));
        pet.setTags(List.of(new Tag() {{
            setId(1L);
            setName("playful");
        }}));
        pet.setStatus("available");

        // Send request
        given()
                .contentType(ContentType.JSON)
                .body(pet)   // <-- Rest Assured converts POJO to JSON
                .when()
                .post("/pet")
                .then()
                .statusCode(200)
                .body("name", equalTo("Max"))
                .body("status", equalTo("available"));
    }
}