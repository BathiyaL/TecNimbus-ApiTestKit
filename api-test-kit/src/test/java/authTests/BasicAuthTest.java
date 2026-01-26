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
        RestCaller.baseURI = "https://httpbin.org/basic-auth";
    }

    @Test
    void testWithBasicAuth() {
        RestCaller.authorization = new BasicAuth("user", "passwd");
        RestCaller.endpoint = "/user/passwd";
        RestCaller.requestMethod = RequestMethod.GET;

        Response response = RestCaller.send();

        assertEquals(200, response.getStatusCode());
    }
}
