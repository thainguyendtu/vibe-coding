package com.fpt.shopflow.user.controller;

import com.fpt.shopflow.common.dto.ApiResponse;
import java.util.List;

import com.fpt.shopflow.user.dto.CreateUserRequestDTO;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fpt.shopflow.user.dto.UserResponseDTO;
import com.fpt.shopflow.user.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<ApiResponse<?>> getAllUserList() {
        List<UserResponseDTO> result = userService.getAllUsers();
        ApiResponse<?> response = ApiResponse.builder()
                .message("getAllUserList OK")
                .data(result)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<?>> insertUser(@RequestBody CreateUserRequestDTO requestDTO) {
        userService.insertUser(requestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
