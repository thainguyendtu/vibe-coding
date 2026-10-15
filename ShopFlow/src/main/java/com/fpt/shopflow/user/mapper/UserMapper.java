package com.fpt.shopflow.user.mapper;

import java.util.List;

import com.fpt.shopflow.user.domain.User;
import org.apache.ibatis.annotations.Mapper;

import com.fpt.shopflow.user.dto.UserResponseDTO;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    List<User> getAllUser();

    User getUserByEmail(@Param("email") String email);

    boolean isExistedUsername(@Param("username") String username);

    boolean isExistedEmail(@Param("email") String email);

    void insertUser(User user);
}
