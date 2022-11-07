package com.bankingexample.error;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BusinessException extends Exception{
    private int code;
    private String message;
    @JsonIgnore
    private String internalMessage;
}
