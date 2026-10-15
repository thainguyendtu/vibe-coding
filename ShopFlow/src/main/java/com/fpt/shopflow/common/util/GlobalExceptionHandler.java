package com.fpt.shopflow.common.util;

import com.fpt.shopflow.common.dto.ApiResponse;
import com.fpt.shopflow.common.exception.ExistedEmailException;
import com.fpt.shopflow.common.exception.ExistedUsernameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleException(Exception ex, WebRequest request) {
        ApiResponse<Object> response = ApiResponse.builder()
                .errors(List.of(ex.getMessage()))
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(ExistedUsernameException.class)
    public ResponseEntity<ApiResponse<Object>> handleExistedUsernameException(ExistedUsernameException ex) {
        ApiResponse<Object> response = ApiResponse.builder()
                .errors(List.of(ex.getMessage()))
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(ExistedEmailException.class)
    public ResponseEntity<ApiResponse<Object>> handleExistedEmailException(ExistedEmailException ex) {
        ApiResponse<Object> response = ApiResponse.builder()
                .errors(List.of(ex.getMessage()))
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
