package petstore_api.bdd;

import io.github.tecnimbus.apitestkit.actions.RestCaller;
import io.github.tecnimbus.apitestkit.common.RequestMethod;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PetStoreSteps {

    private Response response;

    public void setBaseURI(String baseURI) {
        RestCaller.baseURI = baseURI;
    }

    public void setEndpoint(String endpoint) {
        RestCaller.endpoint = endpoint;
    }

    public void setRequestMethod(String method) {
        RestCaller.requestMethod = RequestMethod.valueOf(method.toUpperCase());
    }

    public void setQueryParam(String key, String value) {
        RestCaller.queryParams.put(key, value);
    }

    public void setRequestBody(String body) {
        RestCaller.requestBody = body;
    }

    public void setPathParam(String key, String value) {
        RestCaller.pathParams.put(key, value);
    }

    public void sendRequest() {
        response = RestCaller.send();
    }

    public void verifyStatusCode(int statusCode) {
        assertEquals(statusCode, response.getStatusCode(), "Unexpected HTTP status code");
    }

    public void verifyContentType(String contentType) {
        assertEquals(contentType, response.getContentType(), "Unexpected content type");
    }

    public void verifyResponseNotEmpty() {
        assertFalse(response.getBody().asString().isEmpty(), "Response JSON should not be empty");
    }

    public void verifyResponseField(String field, Object expectedValue) {
        Object actualValue = response.getBody().jsonPath().get(field);
        assertEquals(expectedValue, actualValue, "Unexpected value for field: " + field);
    }
}