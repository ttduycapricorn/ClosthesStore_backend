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
    @Size(min = 2, max = 50, message = "USERNAME_INVALID")
    private String username;
    @Size(min = 8, max = 64, message = "PASSWORD_INVALID")
    private String password;
    private String firstName;
    private String lastName;
    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotEmpty(message = "Email cannot be empty")
    private String email;
    private String phone;
    private LocalDate birthDay;
}
