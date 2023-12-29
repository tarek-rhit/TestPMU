package com.example.testpmu.exceptions;

public enum ErrorCodes {

    NUMERO_DE_COURSE_INVALID(1001),
    NUMERO_DE_COURSE_NOT_FOUND(1002),
    NOMBRE_PARTANTS_INSUFISANT(1003),
    NOMBRE_PARTANTS_NOT_FOUND(1004);



    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }


}
