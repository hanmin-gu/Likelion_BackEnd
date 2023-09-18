package com.example.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorCode{

    ALREADY_RESISTER_USER(HttpStatus.BAD_REQUEST, "이미 회원가입 되어있습니다.");
    private final HttpStatus httpStatus;
    private final String detail;

}
