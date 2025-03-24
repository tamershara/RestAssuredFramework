package com.qacart.todo.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class DeleteTodoResponse {
    private String createdAt;
    @JsonProperty("isCompleted")
    private boolean isCompleted;
    private String item;
    private String userID;
    private int __v;
    private String _id;
}
