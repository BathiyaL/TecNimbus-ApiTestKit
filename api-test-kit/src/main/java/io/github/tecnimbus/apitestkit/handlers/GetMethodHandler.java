package io.github.tecnimbus.apitestkit.handlers;

import io.github.tecnimbus.apitestkit.handlers.HttpMethodHandler;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

public class GetMethodHandler implements HttpMethodHandler {
    @Override
    public Response handle(RequestSpecification requestSpec, String fullUrl) {
        return requestSpec.get(fullUrl);
    }
}