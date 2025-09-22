package io.github.tecnimbus.apitestkit.actions;

public class RestCallerTest {

    public static void main(String[] args) {
        RestCaller.baseURI = "https://petstore.swagger.io/v2";
        RestCaller.endpoint = "/pet/findByStatus";
        RestCaller.requestMethod = RequestMethod.GET;
        RestCaller.queryParams.put("status", "available");
        RestCaller.queryParams.put("status2", "available2");

        var response = RestCaller.send();
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

    }
}
