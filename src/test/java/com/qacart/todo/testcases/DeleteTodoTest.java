package com.qacart.todo.testcases;

import com.qacart.todo.models.*;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteTodoTest {

    @Test
    public void userShouldBeAbleToDeleteTodo() {

        UserData user = UserData
                .builder()
                .email("ema99io09l@email.com")
                .firstName("Test")
                .lastName("Automation")
                .password("test1234")
                .build();
        Response registerationResponse = given()
                .baseUri("https://todo.qacart.com/api/v1")
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/users/register");

        RegisterResponse registerResponse = registerationResponse.as(RegisterResponse.class);
        String accessToken = registerResponse.getAccessToken();

        TodoItem todoItem = TodoItem
                .builder()
                .isCompleted(false)
                .item("automation")
                .build();

        Response addTodoAPI = given()
                .baseUri("https://todo.qacart.com/api/v1")
                .auth().oauth2(accessToken)
                .contentType(ContentType.JSON)
                .body(todoItem)
                .when()
                .post("/tasks");

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
