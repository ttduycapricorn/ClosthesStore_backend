package com.devteria.server.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)//made the "message" properties don't display on result
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiResponse <T>{
     int code = 1000; //1000: successfully
     String message;
     T result;
}
