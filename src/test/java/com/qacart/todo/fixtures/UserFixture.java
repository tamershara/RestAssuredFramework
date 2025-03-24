package com.qacart.todo.fixtures;

import com.qacart.todo.models.UserData;
import static com.qacart.todo.utils.RandomDataUtils.generateRandomEmail;

public final class UserFixture {
    private UserFixture(){}
    public static UserData generateDefaultUser() {
        return UserData
                .builder()
                .email(generateRandomEmail())
                .firstName("Test")
                .lastName("Automation")
                .password("test1234")
                .build();
    }
}
