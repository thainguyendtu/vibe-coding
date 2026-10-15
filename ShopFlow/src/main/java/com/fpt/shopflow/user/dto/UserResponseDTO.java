package com.fpt.shopflow.user.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
public class UserResponseDTO {

    @JsonIgnore
    private UUID id;
    private String username;
    private String email;
    @JsonIgnore
    private String password;
    private String fullName;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String gender;
    private String avatarUrl;
    private String role;
    private String status;
    @JsonIgnore
    private LocalDateTime lastLoginAt;
    @JsonIgnore
    private LocalDateTime createdAt;
    @JsonIgnore
    private LocalDateTime updatedAt;
}
