package com.devteria.server.controller;

import com.devteria.server.dto.request.ApiResponse;
import com.devteria.server.dto.request.UserCreateRequest;
import com.devteria.server.dto.request.UserUpdateRequest;
import com.devteria.server.dto.response.UserResponse;
import com.devteria.server.entity.User;
import com.devteria.server.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @CrossOrigin
    @PostMapping
    public ApiResponse<User> create(@RequestBody @Valid UserCreateRequest request) {
       ApiResponse<User> response = new ApiResponse<>();
       response.setResult(userService.createUser(request));
       return response;
    }

    @GetMapping
    public List<User> getAll() {
        return  userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable("id") String id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public UserResponse update(@PathVariable("id") String id, @RequestBody UserUpdateRequest user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") String id) {
        userService.deleteUser(id);
        return "Delete successfully user " + id;
    }
}
