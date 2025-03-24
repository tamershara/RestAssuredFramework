package com.qacart.todo.clients;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public final class BaseClient {
    private BaseClient(){}
    public static RequestSpecification getDefaultRequestSpecification() {
        return given()
                .baseUri("https://todo.qacart.com/api/v1")
                .contentType(ContentType.JSON);
    }

    public static RequestSpecification getRequestSpecificationWithAuthorization(String accessToken) {
        return getDefaultRequestSpecification()
                .auth().oauth2(accessToken);
    }
}
