package com.fpt.shopflow.authentication.controller;

import com.fpt.shopflow.authentication.dto.LoginRequestDTO;
import com.fpt.shopflow.authentication.dto.LoginResponseDTO;
import com.fpt.shopflow.authentication.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class LoginController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO request) {
        return authenticationService.login(request);
    }

}
