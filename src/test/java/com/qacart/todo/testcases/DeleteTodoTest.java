package com.qacart.todo.testcases;

import com.qacart.todo.models.DeleteTodoResponse;
import com.qacart.todo.models.TodoItem;
import com.qacart.todo.models.UserData;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.qacart.todo.api_steps.TodoSteps.addTodoStep;
import static com.qacart.todo.api_steps.UserSteps.registerStep;
import static com.qacart.todo.clients.TodoClient.deleteTodoAPI;
import static com.qacart.todo.fixtures.TodoFixture.generateDefaultTodoItem;
import static com.qacart.todo.fixtures.UserFixture.generateDefaultUser;

public class DeleteTodoTest {

    @Test
    public void userShouldBeAbleToDeleteTodo() {
        UserData user = generateDefaultUser();
        String accessToken = registerStep(user);
        TodoItem todoItem = generateDefaultTodoItem();
        String todoID = addTodoStep(todoItem, accessToken);
        Response deleteResponse = deleteTodoAPI(accessToken, todoID);
        DeleteTodoResponse deleteTodoResponse = deleteResponse.as(DeleteTodoResponse.class);
        Assert.assertEquals(deleteTodoResponse.getItem(), "automation");
    }
}
