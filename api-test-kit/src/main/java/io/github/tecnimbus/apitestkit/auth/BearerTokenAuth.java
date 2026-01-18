package io.github.tecnimbus.apitestkit.auth;

import io.restassured.specification.RequestSpecification;

public class BearerTokenAuth implements Auth {
    private final String token;

    public BearerTokenAuth(String token) {
        this.token = token;
    }

    @Override
    public void apply(RequestSpecification request) {
        request.header("Authorization", "Bearer " + token);
    }
}