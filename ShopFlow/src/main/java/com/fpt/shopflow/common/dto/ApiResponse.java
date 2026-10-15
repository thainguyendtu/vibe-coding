package com.fpt.shopflow.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ApiResponse<T> {

    private String message;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private T data;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> errors;
}
