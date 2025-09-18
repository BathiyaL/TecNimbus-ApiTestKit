package io.github.tecnimbus.apitestkit.actions;

import java.util.HashMap;
import java.util.Map;

public class RestCaller {
    public static RequestMethod requestMethod = RequestMethod.GET;
    public static String baseURI = "http://localhost";
    public static String endpoint = "";
    public static Map<String, String> headers = new HashMap<>();
    public static Map<String, String> queryParams = new HashMap<>();
    public static String requestBody = "";

    public static void send() {
      // TODO: Implement the logic to send the HTTP request using the specified parameters.
    }
}