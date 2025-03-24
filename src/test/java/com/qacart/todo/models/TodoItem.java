package com.qacart.todo.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class TodoItem {

    @JsonProperty("isCompleted")
    private boolean isCompleted;
    private String item;
}
