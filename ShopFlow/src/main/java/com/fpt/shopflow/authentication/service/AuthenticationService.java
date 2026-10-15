package com.fpt.shopflow.authentication.service;

import com.fpt.shopflow.authentication.dto.LoginRequestDTO;
import com.fpt.shopflow.authentication.dto.LoginResponseDTO;
import com.fpt.shopflow.user.domain.User;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    public LoginResponseDTO login(LoginRequestDTO request) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        User user = (User) authentication.getPrincipal();
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("User not found.");
        }

        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        return LoginResponseDTO.builder()
                                .accessToken(accessToken)
                                .refreshToken(refreshToken)
                                .build();
    }

    public void logout(String token) {

    }
}
