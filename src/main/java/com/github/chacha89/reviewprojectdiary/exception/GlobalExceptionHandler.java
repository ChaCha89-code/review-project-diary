package com.github.chacha89.reviewprojectdiary.exception;

import com.github.chacha89.reviewprojectdiary.diaryDto.DiaryCreateResponseDto;
import com.github.chacha89.reviewprojectdiary.userDto.UserCreateResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserCreateException.class)
    public ResponseEntity<UserCreateResponseDto> handleUserCreateException(UserCreateException e) {
        return ResponseEntity.status(e.getStatus()).body(new UserCreateResponseDto(e.getStatus(), e.getMessage()));
    }

}
