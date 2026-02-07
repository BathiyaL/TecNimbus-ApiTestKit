package petstore_api.pet;

import io.github.tecnimbus.apitestkit.actions.RestCaller;
import io.github.tecnimbus.apitestkit.common.RequestMethod;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class PetStoreApiTests {

    @BeforeAll
    static void setup() {
        RestCaller.baseURI = "https://petstore.swagger.io/v2";
    }

    @BeforeEach
    void resetRestCaller() {
        RestCaller.endpoint = "";
        RestCaller.headers.clear();
        RestCaller.queryParams.clear();
        RestCaller.pathParams.clear();
        RestCaller.requestBody = "";
        RestCaller.authorization = null;
    }

    @Order(3)
    @Test
    void testFindPetsByStatus() {
        RestCaller.endpoint = "/pet/findByStatus";
        RestCaller.requestMethod = RequestMethod.GET;
        RestCaller.queryParams.put("status", "available");

        Response response = RestCaller.send();

        // Assertions
        assertEquals(200, response.getStatusCode(), "Expected HTTP status code 200");
        assertEquals("application/json", response.getContentType(), "Expected content type JSON");
        assertFalse(response.getBody().asString().isEmpty(), "Response JSON should not be empty");
    }

    @Order(1)
    @Test
    void testAddNewPet() {
        RestCaller.endpoint = "/pet";
        RestCaller.requestMethod = RequestMethod.POST;
        RestCaller.headers.put("Content-Type", "application/json");
        RestCaller.requestBody = """
        {
            "id": 12345,
            "name": "TestPet",
            "status": "available"
        }
        """;

        Response response = RestCaller.send();

        // Assertions
        assertEquals(200, response.getStatusCode(), "Expected HTTP status code 200");
        assertEquals("application/json", response.getContentType(), "Expected content type JSON");
        assertEquals(12345, response.getBody().jsonPath().getInt("id"), "Expected pet ID to be 12345");
    }

    @Order(2)
    @Test
    void testGetPetById() {
        RestCaller.endpoint = "/pet/{petId}";
        RestCaller.requestMethod = RequestMethod.GET;
        RestCaller.pathParams.put("petId", "12345");

        Response response = RestCaller.send();

        // Assertions
        assertEquals(200, response.getStatusCode(), "Expected HTTP status code 200");
        assertEquals("application/json", response.getContentType(), "Expected content type JSON");
        assertEquals(12345, response.getBody().jsonPath().getInt("id"), "Expected pet ID to be 12345");
    }

    @Order(4)
    @Test
    void testDeletePet() {
        RestCaller.endpoint = "/pet/{petId}";
        RestCaller.requestMethod = RequestMethod.DELETE;
        RestCaller.pathParams.put("petId", "12345");

        Response response = RestCaller.send();

        // Assertions
        assertEquals(200, response.getStatusCode(), "Expected HTTP status code 200");
        assertEquals("application/json", response.getContentType(), "Expected content type JSON");
        assertEquals("unknown", response.getBody().jsonPath().getString("type"), "Expected response type to be 'unknown'");
    }

}