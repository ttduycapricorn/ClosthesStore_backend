package com.devteria.server.service;

import com.devteria.server.dto.request.UserCreateRequest;
import com.devteria.server.dto.request.UserUpdateRequest;
import com.devteria.server.dto.response.UserResponse;
import com.devteria.server.entity.User;
import com.devteria.server.exception.AppException;
import com.devteria.server.exception.ErrorCode;
import com.devteria.server.mapper.UserMapper;
import com.devteria.server.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    public User createUser(UserCreateRequest req){
        if(userRepository.existsByUsername(req.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toUser(req);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(req.getPassword()));

        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public UserResponse getUserById(String id){
        return userMapper.toUserResponse(userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found")));
    }

    public UserResponse updateUser(String id, UserUpdateRequest request){
       User user = userRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("User not found"));

       userMapper.updateUser(user, request);

       return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(String id){
        userRepository.deleteById(id);
    }
}
