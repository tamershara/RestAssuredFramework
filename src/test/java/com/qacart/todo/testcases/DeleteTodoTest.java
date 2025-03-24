package com.qacart.todo.testcases;

import com.qacart.todo.models.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.qacart.todo.clients.TodoClient.addTodoAPI;
import static com.qacart.todo.clients.UserClient.registerAPI;
import static com.qacart.todo.fixtures.TodoFixture.generateDefaultTodoItem;
import static com.qacart.todo.fixtures.UserFixture.generateDefaultUser;
import static io.restassured.RestAssured.given;

public class DeleteTodoTest {

    @Test
    public void userShouldBeAbleToDeleteTodo() {

        Response registerationResponse = registerAPI(generateDefaultUser());

        RegisterResponse registerResponse = registerationResponse.as(RegisterResponse.class);
        String accessToken = registerResponse.getAccessToken();

        Response addTodoAPI = addTodoAPI(generateDefaultTodoItem(),accessToken);

        AddTodoResponse addTodoResponse = addTodoAPI.as(AddTodoResponse.class);
        String todo_ID = addTodoResponse.get_id();
        Response deleteResponse = given()
                .baseUri("https://todo.qacart.com/api/v1")
                .pathParam("id",todo_ID)
                .auth().oauth2(accessToken)
                .when()
                .delete("/tasks/{id}");
        DeleteTodoResponse deleteTodoResponse = deleteResponse.as(DeleteTodoResponse.class);
        Assert.assertEquals(deleteTodoResponse.getItem(),"automation");
    }
}
