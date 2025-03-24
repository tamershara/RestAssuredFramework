package com.qacart.todo.clients;

import com.qacart.todo.models.TodoItem;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.qacart.todo.clients.BaseClient.getRequestSpecificationWithAuthorization;
import static com.qacart.todo.fixtures.TodoFixture.generateDefaultTodoItem;
import static io.restassured.RestAssured.given;

public final class TodoClient {

    private TodoClient(){}
    public static Response addTodoAPI(TodoItem todoItem, String accessToken)
    {
        return getRequestSpecificationWithAuthorization(accessToken)
                .body(todoItem)
                .when()
                .post("/tasks");
    }
}
