package petstore_api.pet;

import io.github.tecnimbus.apitestkit.actions.RestCaller;
import io.github.tecnimbus.apitestkit.common.RequestMethod;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindOrderByIDTest {
    @BeforeAll
    static void setup() {
        RestCaller.baseURI = "https://petstore.swagger.io/v2";
        RestCaller.endpoint = "/store/order/{orderId}";
    }

    @Test
    void SuccessFindOrderWithValidID() {
        RestCaller.requestMethod = RequestMethod.GET;
        RestCaller.pathParams.put("orderId", "4");

        Response response = RestCaller.send();

        assertEquals(200, response.getStatusCode(), "Expected HTTP status code 200");
        assertEquals("application/json", response.getContentType(), "Expected content type JSON");

        int id = response.getBody().jsonPath().getInt("id");
        assertEquals(4, id, "Expected `id` field to be 4");
    }

    @Test
    void ErrorOrderIDNotFound() {
        RestCaller.requestMethod = RequestMethod.GET;
        RestCaller.pathParams.put("orderId", "-4");

        Response response = RestCaller.send();

        assertEquals(404, response.getStatusCode(), "Expected HTTP status code 404");
    }
}

