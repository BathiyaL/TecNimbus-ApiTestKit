package authTests;

import io.github.tecnimbus.apitestkit.actions.RestCaller;
import io.github.tecnimbus.apitestkit.auth.BearerTokenAuth;
import io.github.tecnimbus.apitestkit.common.RequestMethod;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BearerTokenAuthTest {
    @BeforeAll
    static void setup() {
        RestCaller.baseURI = "https://httpbin.org";
    }

    @Test
    void testWithBearerTokenAuth() {
        RestCaller.authorization = new BearerTokenAuth("your-token-here");
        RestCaller.endpoint = "/bearer";
        RestCaller.requestMethod = RequestMethod.GET;

        Response response = RestCaller.send();

        assertEquals(200, response.getStatusCode());
    }
}
