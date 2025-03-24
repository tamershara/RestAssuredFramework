package com.qacart.todo.clients;

import com.qacart.todo.models.UserData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.qacart.todo.clients.BaseClient.getDefaultRequestSpecification;
import static com.qacart.todo.fixtures.UserFixture.generateDefaultUser;
import static io.restassured.RestAssured.given;

public final class UserClient {
    private UserClient(){}
    public static Response registerAPI(UserData user) {
        return getDefaultRequestSpecification()
                .body(user)
                .when()
                .post("/users/register");
    }
}
