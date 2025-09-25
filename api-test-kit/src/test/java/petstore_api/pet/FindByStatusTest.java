package petstore_api.pet;

import io.github.tecnimbus.apitestkit.actions.RestCaller;
import io.github.tecnimbus.apitestkit.common.RequestMethod;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindByStatusTest {

    @BeforeAll
    static void setup() {
        RestCaller.baseURI = "https://petstore.swagger.io/v2";
        RestCaller.endpoint = "/pet/findByStatus";
    }

    @ParameterizedTest
    @ValueSource(strings = {"available", "pending", "sold"})
    void SuccessFindPetWithValidStatus(String status) {
        RestCaller.requestMethod = RequestMethod.GET;
        RestCaller.queryParams.put("status", status);
        Response response = RestCaller.send();

        assertEquals(200, response.getStatusCode(), "Expected HTTP status code 200");
        assertEquals("application/json", response.getContentType(), "Expected content type JSON");
        assertFalse(response.getBody().as(List.class).isEmpty(), "Response JSON array should not be empty");
    }

    @Test
    void ErrorFindPetWithInvalidStatus() {
        RestCaller.requestMethod = RequestMethod.GET;
        RestCaller.queryParams.put("status", "INVALID");
        Response response = RestCaller.send();

        assertEquals(200, response.getStatusCode(), "Expected HTTP status code 200");
        assertEquals("application/json", response.getContentType(), "Expected content type JSON");
        assertTrue(response.getBody().as(List.class).isEmpty(), "Response JSON array should not be empty");
    }
}