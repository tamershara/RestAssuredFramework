package com.qacart.todo.utils;

import java.time.Instant;

public class RandomDataUtils {

    public static String generateRandomEmail() {
        long currentTimeStamp = Instant.now().toEpochMilli();
        return "TestAutomation" + currentTimeStamp + "@email.com";
    }
}
