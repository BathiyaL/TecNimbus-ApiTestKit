package io.github.tecnimbus.apitestkit.handlers;

import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

public class PostMethodHandler implements HttpMethodHandler {
    @Override
    public Response handle(RequestSpecification requestSpec, String fullUrl) {
        return requestSpec.post(fullUrl);
    }
}