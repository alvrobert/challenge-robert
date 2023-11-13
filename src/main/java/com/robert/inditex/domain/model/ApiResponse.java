package com.robert.inditex.domain.model;

import lombok.Data;

@Data
public class ApiResponse<T> {

    private T data;
    private String message;
    private int status;
}
