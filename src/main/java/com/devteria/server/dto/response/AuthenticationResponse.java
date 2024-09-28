package com.devteria.server.dto.response;

import com.devteria.server.exception.ErrorCode;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationResponse{
    String token;
    Boolean IsAuthenticated;
}
