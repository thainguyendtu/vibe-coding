package com.fpt.shopflow.authentication.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class LoginResponseDTO {

    private String accessToken;
    private String refreshToken;
}
