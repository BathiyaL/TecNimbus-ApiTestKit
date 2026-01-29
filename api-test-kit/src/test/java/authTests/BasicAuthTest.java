package authTests;

import io.github.tecnimbus.apitestkit.actions.RestCaller;
import io.github.tecnimbus.apitestkit.auth.BasicAuth;
import io.github.tecnimbus.apitestkit.common.RequestMethod;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicAuthTest {
    @BeforeAll
    static void setup() {
        RestCaller.baseURI = "https://postman-echo.com";
    }

    @Test
    void testWithBasicAuth() {
        RestCaller.authorization = new BasicAuth("postman", "password");
        RestCaller.endpoint = "/basic-auth";
        RestCaller.requestMethod = RequestMethod.GET;

        Response response = RestCaller.send();

        assertEquals(200, response.getStatusCode());
        boolean isAuthenticated = response.getBody().jsonPath().getBoolean("authenticated");
        assertEquals(true, isAuthenticated, "Expected 'authenticated' to be true");
    }
}
