package com.qacart.todo.models;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class UserData {
    private String email;
    private String firstName;
    private String lastName;
    private String password;

}
