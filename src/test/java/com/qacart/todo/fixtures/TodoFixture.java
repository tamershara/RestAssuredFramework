package com.qacart.todo.fixtures;

import com.qacart.todo.models.TodoItem;

public final class TodoFixture {
    private TodoFixture(){}
    public static TodoItem generateDefaultTodoItem() {
        return TodoItem
                .builder()
                .isCompleted(false)
                .item("automation")
                .build();
    }
}
