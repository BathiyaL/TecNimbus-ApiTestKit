package io.github.tecnimbus.apitestkit.auth;

import io.restassured.specification.RequestSpecification;

public interface Auth {
    void apply(RequestSpecification request);
}