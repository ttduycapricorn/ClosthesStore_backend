package com.devteria.server.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class UserCreateRequest {
    @NotEmpty
    @Size(min = 2, max = 50, message = "User name must be east 2 character and maximum 50 character!")
    private String username;
    @Size(min = 8, max = 64, message = "Password must be east 8 character and maximum 64 character!")
    private String password;
    private String firstName;
    private String lastName;
    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotEmpty(message = "Email cannot be empty")
    private String email;
    private String phone;
    private LocalDate birthDay;
}
