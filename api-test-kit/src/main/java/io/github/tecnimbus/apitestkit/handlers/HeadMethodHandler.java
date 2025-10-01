package io.github.tecnimbus.apitestkit.handlers;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HeadMethodHandler implements HttpMethodHandler {
    @Override
    public Response handle(RequestSpecification requestSpec, String fullUrl) {
        return requestSpec.head(fullUrl);
    }
}