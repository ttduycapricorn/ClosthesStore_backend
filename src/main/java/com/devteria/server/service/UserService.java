package com.devteria.server.service;

import com.devteria.server.dto.request.UserCreateRequest;
import com.devteria.server.dto.request.UserUpdateRequest;
import com.devteria.server.entity.User;
import com.devteria.server.exception.AppException;
import com.devteria.server.exception.ErrorCode;
import com.devteria.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreateRequest req){
        User user = new User();

        if(userRepository.existsByUsername(req.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        user.setUsername(req.getUsername());
        user.setPassword(req.getPassword());
        user.setEmail(req.getEmail());
        user.setFirstName(req.getFirstName());
        user.setLastName(req.getLastName());
        user.setBirthDay(req.getBirthDay());
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(String id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(String id, UserUpdateRequest request){
       User user = getUserById(id);
       user.setFirstName(request.getFirstName());
       user.setLastName(request.getLastName());
       user.setEmail(request.getEmail());
       user.setPassword(request.getPassword());
       return userRepository.save(user);
    }

    public void deleteUser(String id){
        userRepository.deleteById(id);
    }
}
