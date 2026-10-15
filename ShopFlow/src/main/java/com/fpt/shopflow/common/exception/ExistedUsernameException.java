package com.fpt.shopflow.common.exception;

public class ExistedUsernameException extends BusinessException {
    public ExistedUsernameException(String message) {
        super("EXISTED_USERNAME", message);
    }
}
