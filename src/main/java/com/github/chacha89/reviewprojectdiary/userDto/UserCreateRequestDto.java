package com.github.chacha89.reviewprojectdiary.userDto;

public class UserCreateRequestDto {
    // 속성
    private String userName;
    private String email;
    private String password;
    private String checkPassword;

    // 생성자

    public UserCreateRequestDto(String userName, String email, String password, String checkPassword) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.checkPassword = checkPassword;
    }

    // 기능
    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCheckPassword() {
        return checkPassword;
    }
}
