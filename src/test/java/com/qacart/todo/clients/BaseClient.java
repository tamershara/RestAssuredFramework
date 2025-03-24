package com.qacart.todo.clients;

import com.qacart.todo.configs.ConfigFactory;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static com.qacart.todo.configs.ConfigFactory.getConfig;
import static io.restassured.RestAssured.given;

public final class BaseClient {
    private BaseClient(){}
    public static RequestSpecification getDefaultRequestSpecification() {
        return given()
                .baseUri(getConfig().baseUri())
                .contentType(ContentType.JSON);
    }

    public static RequestSpecification getRequestSpecificationWithAuthorization(String accessToken) {
        return getDefaultRequestSpecification()
                .auth().oauth2(accessToken);
    }
}
