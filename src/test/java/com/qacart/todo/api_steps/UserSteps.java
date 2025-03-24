package com.qacart.todo.api_steps;

import com.qacart.todo.models.RegisterResponse;
import com.qacart.todo.models.UserData;
import io.restassured.response.Response;

import static com.qacart.todo.clients.UserClient.registerAPI;

public final class UserSteps {
    private UserSteps() {
    }

    public static String registerStep(UserData user) {
        Response registerationResponse = registerAPI(user);

        RegisterResponse registerResponse = registerationResponse.as(RegisterResponse.class);
        return registerResponse.getAccessToken();
    }
}
