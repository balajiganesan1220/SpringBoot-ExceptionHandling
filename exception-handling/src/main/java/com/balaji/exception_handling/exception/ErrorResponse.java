package com.balaji.exception_handling.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private LocalDateTime timestamp;
    private String message;
    private String details;

    public ErrorResponse(LocalDateTime timestamp, String message, String details){
        this.timestamp=timestamp;
        this.message=message;
        this.details=details;
    }


}
