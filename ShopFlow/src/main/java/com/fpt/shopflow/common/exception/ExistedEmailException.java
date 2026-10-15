package com.fpt.shopflow.common.exception;

public class ExistedEmailException extends BusinessException {
    public ExistedEmailException(String message) {
        super("EXISTED_EMAIL", message);
    }
}
