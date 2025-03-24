package com.qacart.todo.clients;

import com.qacart.todo.models.TodoItem;
import io.restassured.response.Response;

import static com.qacart.todo.clients.BaseClient.getRequestSpecificationWithAuthorization;

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
