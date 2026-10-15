package com.fpt.shopflow.catalog.enums;

/**
 * Category Status
 */
public enum CategoryStatus {

    ACTIVE(1),
    INACTIVE(0);

    private final int code;

    CategoryStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
