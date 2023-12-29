package com.example.testpmu.handlers;

import com.example.testpmu.exceptions.ErrorCodes;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDto {


    private int httpCode;

    private ErrorCodes errorCodes;

    private String message;

    private List<String > errors = new ArrayList<>();
}
