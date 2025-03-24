package com.qacart.todo.testcases;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteTodoTest {

    @Test
    public void userShouldBeAbleToDeleteTodo() {

        String registerBody = """
                {
                  "email": "amertamer89940@gmail.com",
                  "password": "12345qwe",
                  "firstName": "tamer",
                  "lastName": "alsharawneh"
                }
                """;
        Response registerResponse = given()
                .baseUri("https://todo.qacart.com/api/v1")
                .contentType(ContentType.JSON)
                .body(registerBody)
                .when()
                .post("/users/register");

        String accessToken = registerResponse.body().path("access_token");

        String todoItem = """
                {
                  "item": "automation",
                  "isCompleted": false
                }
                """;

        Response addTodoAPI = given()
                .baseUri("https://todo.qacart.com/api/v1")
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.JSON)
                .body(todoItem)
                .when()
                .post("/tasks");

        System.out.println(addTodoAPI.asPrettyString());
        String todo_ID = addTodoAPI.path("_id");
        Response deleteTodoResponse = given()
                .baseUri("https://todo.qacart.com/api/v1")
                .pathParam("id",todo_ID)
                .header("Authorization","Bearer " + accessToken)
                .when()
                .delete("/tasks/{id}");

        Assert.assertEquals(deleteTodoResponse.path("item"),"automation");
    }
}
