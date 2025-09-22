package io.github.tecnimbus.apitestkit.actions;

import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

public interface HttpMethodHandler {
    Response handle(RequestSpecification requestSpec, String fullUrl);
}