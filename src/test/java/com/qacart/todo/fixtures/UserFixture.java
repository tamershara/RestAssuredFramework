package com.qacart.todo.fixtures;

import com.qacart.todo.models.UserData;

public class UserFixture {

    public static UserData generateDefaultUser() {
        return UserData
                .builder()
                .email("ema99io09l@email.com")
                .firstName("Test")
                .lastName("Automation")
                .password("test1234")
                .build();
    }
}
