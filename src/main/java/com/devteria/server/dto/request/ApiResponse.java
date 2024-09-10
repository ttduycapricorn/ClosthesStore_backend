package com.devteria.server.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL) //made the "message" properties don't display on result
public class ApiResponse <T>{
    private int code = 1000; //1000: successfully
    private String message;
    private T result;
}
