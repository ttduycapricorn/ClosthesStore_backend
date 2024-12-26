package com.devteria.server.mapper;

import com.devteria.server.dto.request.UserCreateRequest;
import com.devteria.server.dto.request.UserUpdateRequest;
import com.devteria.server.dto.response.UserResponse;
import com.devteria.server.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "roles", ignore = true)
    User toUser(UserCreateRequest request);
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
