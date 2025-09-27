package petstore_api.pet;

import io.github.tecnimbus.apitestkit.actions.RestCaller;
import io.github.tecnimbus.apitestkit.common.RequestMethod;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FindOrderByIDTest {
    @BeforeAll
    static void setup() {
        RestCaller.baseURI = "https://petstore.swagger.io/v2";
        RestCaller.endpoint = "/store/order/4";
    }

    @Test
    void SuccessFindPetWithValidStatus() {
        RestCaller.requestMethod = RequestMethod.GET;
        Response response = RestCaller.send();

        assertEquals(200, response.getStatusCode(), "Expected HTTP status code 200");
        assertEquals("application/json", response.getContentType(), "Expected content type JSON");
        assertFalse(response.getBody().as(List.class).isEmpty(), "Response JSON array should not be empty");
    }
}
