package io.github.tecnimbus.apitestkit.actions;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class RestCaller {
    public static RequestMethod requestMethod = RequestMethod.GET;
    public static String baseURI = "http://localhost";
    public static String endpoint = "";
    public static Map<String, String> headers = new HashMap<>();
    public static Map<String, String> queryParams = new HashMap<>();
    public static String requestBody = "";

    public static Response send() {
      // TODO: Implement the logic to send the HTTP request using the specified parameters.

        // Construct the full URL
        String fullUrl = baseURI + endpoint;

        // Configure Rest Assured
        var requestSpec = RestAssured.given();

        // Add headers if present
        if (!headers.isEmpty()) {
            requestSpec.headers(headers);
        }

        // Add query parameters if present
        if (!queryParams.isEmpty()) {
            System.out.println("Adding query params: " + queryParams);
            requestSpec.queryParams(queryParams);
        }

        HttpMethodHandler handler = getHandlerForMethod(requestMethod);
        return handler.handle(requestSpec, fullUrl);
    }

    private static HttpMethodHandler getHandlerForMethod(RequestMethod method) {
        return switch (method) {
            case GET -> new GetMethodHandler();
            case POST -> new PostMethodHandler();
            default -> throw new UnsupportedOperationException("Unsupported HTTP method: " + method);
        };
    }
}