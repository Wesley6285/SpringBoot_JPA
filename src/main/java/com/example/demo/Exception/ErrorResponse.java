package com.example.demo.Exception;

import java.time.LocalDateTime;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public  class ErrorResponse {
    private LocalDateTime date;
    private String Message;
    private String details;

}
