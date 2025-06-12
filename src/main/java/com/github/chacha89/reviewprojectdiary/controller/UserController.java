package com.github.chacha89.reviewprojectdiary.controller;

import com.github.chacha89.reviewprojectdiary.service.UserService;
import com.github.chacha89.reviewprojectdiary.userDto.UserCreateRequestDto;
import com.github.chacha89.reviewprojectdiary.userDto.UserCreateResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Controller catches exceptions, builds ResponseEntity.
@RestController
@RequestMapping("/api/users")
public class UserController {
    // 속성
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 회원 가입 API
     */
    @PostMapping
    public ResponseEntity<UserCreateResponseDto> createUserAPI(@RequestBody UserCreateRequestDto requestDto) {
        UserCreateResponseDto responseDto = userService.createUserService(requestDto);
        return ResponseEntity.ok(responseDto);
    }

}
