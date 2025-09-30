package io.github.tecnimbus.apitestkit.handlers;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatchMethodHandler implements HttpMethodHandler {
    @Override
    public Response handle(RequestSpecification requestSpec, String fullUrl) {
        return requestSpec.patch(fullUrl);
    }
}
