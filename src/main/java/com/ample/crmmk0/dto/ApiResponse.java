package com.ample.crmmk0.dto;
//data transfer object:DTO


public class ApiResponse<T> {
    private String requestType;
    private T data;

    public ApiResponse(String requestType, T data) {
        this.requestType = requestType;
        this.data = data;
    }

    // Getters 和 Setters
    public String getRequestType() { return requestType; }
    public void setRequestType(String requestType) { this.requestType = requestType; }
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}