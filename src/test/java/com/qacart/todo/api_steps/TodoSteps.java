package com.qacart.todo.api_steps;

import com.qacart.todo.models.AddTodoResponse;
import com.qacart.todo.models.TodoItem;
import io.restassured.response.Response;

import static com.qacart.todo.clients.TodoClient.addTodoAPI;

public final class TodoSteps {
    private TodoSteps() {
    }

    public static String addTodoStep(TodoItem todoItem, String accessToken) {
        Response addTodoAPI = addTodoAPI(todoItem, accessToken);
        AddTodoResponse addTodoResponse = addTodoAPI.as(AddTodoResponse.class);
        return addTodoResponse.get_id();
    }
}
