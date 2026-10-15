package com.fpt.shopflow.user.service;

import java.util.List;

import com.fpt.shopflow.user.dto.CreateUserRequestDTO;
import com.fpt.shopflow.user.dto.UserResponseDTO;

public interface UserService {

    List<UserResponseDTO> getAllUsers();

    void insertUser(CreateUserRequestDTO user);
}
