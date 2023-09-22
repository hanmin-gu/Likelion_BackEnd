package com.example.exception;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;


@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    NOT_FOUND_OFFER(HttpStatus.BAD_REQUEST, "게시글을 작성해주세요"),
    ALREADY_REGISTER_USER(HttpStatus.BAD_REQUEST, "이미 가입된 회원입니다."),
    NOT_FOUND_USER(HttpStatus.BAD_REQUEST,  "회원가입이 되어있지 않습니다."),
    ALREADY_VERIFY(HttpStatus.BAD_REQUEST,  "이미 인증이 완료되었습니다."),
    EXPIRE_CODE(HttpStatus.BAD_REQUEST,  "인증 시간이 만료되었습니다."),
    WRONG_VERIFICATION(HttpStatus.BAD_REQUEST,  "잘못된 인증 시도입니다."),
    LOGIN_CHECK_FAIL(HttpStatus.BAD_REQUEST,  "아이디, 패스워드를 확인해 주세요."),
    NOT_ENOUGH_BALANCE(HttpStatus.BAD_REQUEST, "잔액이 부족합니다.");

    private final HttpStatus httpStatus;
    private final String detail;
}
