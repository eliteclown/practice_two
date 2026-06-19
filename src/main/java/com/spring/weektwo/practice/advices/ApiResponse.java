package com.spring.weektwo.practice.advices;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {

    private T data;
    private LocalDateTime timeStamp;
    private ApiError apiError;

    public ApiResponse(T data){
        this();
        this.data = data;
    }
    public ApiResponse(){
        this.timeStamp = LocalDateTime.now();
    }

    public ApiResponse(ApiError apiError){
        this();
        this.apiError = apiError;
    }
}
