package com.qacart.todo.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class RegisterResponse {
    @JsonProperty("access_token")
    private String accessToken;
    private String firstName;
    private String userID;
}
