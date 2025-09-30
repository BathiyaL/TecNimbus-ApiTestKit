package io.github.tecnimbus.apitestkit.actions;

import io.github.tecnimbus.apitestkit.common.RequestMethod;
import io.github.tecnimbus.apitestkit.handlers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class RestCaller {
    private static final Logger logger = LoggerFactory.getLogger(RestCaller.class);

    public static RequestMethod requestMethod = RequestMethod.GET;
    public static String baseURI = "http://localhost";
    public static String endpoint = "";
    public static Map<String, String> headers = new HashMap<>();
    public static Map<String, String> queryParams = new HashMap<>();
    public static Map<String, String> pathParams = new HashMap<>();

    public static String requestBody = "";
    public static boolean enableLogging = true;

    public static Response send() {
        String fullUrl = baseURI + endpoint;
        var requestSpec = RestAssured.given();

        if (!headers.isEmpty()) {
            requestSpec.headers(headers);
        }
        if (!queryParams.isEmpty()) {
            requestSpec.queryParams(queryParams);
        }
        if (!pathParams.isEmpty()) {
            requestSpec.pathParams(pathParams);
        }

        if (enableLogging) {
            logRequest(fullUrl);
        }

        HttpMethodHandler handler = getHandlerForMethod(requestMethod);
        Response response = handler.handle(requestSpec, fullUrl);

        if (enableLogging) {
            logResponse(response);
        }

        return response;
    }

    private static HttpMethodHandler getHandlerForMethod(RequestMethod method) {
        return switch (method) {
            case GET -> new GetMethodHandler();
            case POST -> new PostMethodHandler();
            case DELETE -> new DeleteMethodHandler();
            case PATCH -> new PatchMethodHandler();
            default -> throw new UnsupportedOperationException("Unsupported HTTP method: " + method);
        };
    }

    private static void logRequest(String fullUrl) {
        logger.info("""
        Request Details:
        - URL: {}
        - Method: {}
        - Headers: {}
        - Query Params: {}
        - Path Params: {}
        - Body: {}
        """,
                fullUrl, requestMethod, headers, queryParams, pathParams, requestBody.isEmpty() ? "N/A" : requestBody);
    }

    private static void logResponse(Response response) {
        logger.info("""
        Response Details:
        - Status Code: {}
        - Body: {}
        - Headers:\n{}
        """,
                response.getStatusCode(), response.getBody().asString(), response.getHeaders());
    }
}