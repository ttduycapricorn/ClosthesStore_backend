package com.devteria.server.controller;

import com.devteria.server.dto.request.UserCreateRequest;
import com.devteria.server.dto.request.UserUpdateRequest;
import com.devteria.server.entity.User;
import com.devteria.server.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping
    public User create(@RequestBody @Valid UserCreateRequest request) {
       return userService.createUser(request);
    }

    @GetMapping
    public List<User> getAll() {
        return  userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") String id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable("id") String id, @RequestBody UserUpdateRequest user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") String id) {
        userService.deleteUser(id);
        return "Delete successfully user " + id;
    }
}
