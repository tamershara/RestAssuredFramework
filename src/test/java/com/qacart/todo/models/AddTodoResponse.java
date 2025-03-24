package com.qacart.todo.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AddTodoResponse {

    private String createdAt;
    @JsonProperty("isCompleted")
    private boolean isCompleted;
    private String item;
    private String userID;
    private int __v;
    private String _id;
}
