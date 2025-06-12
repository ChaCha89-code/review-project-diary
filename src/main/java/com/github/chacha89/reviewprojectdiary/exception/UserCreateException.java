package com.github.chacha89.reviewprojectdiary.exception;

public class UserCreateException extends RuntimeException {
    // 속성
    private int status;

    // 생성자
    public UserCreateException(int status, String message) {
        super(message);  // ← 부모에게 메시지 전달! 부모 생성자 호출은 반드시 첫줄!
        this.status = status;
    }

    // 기능
    public int getStatus() {
        return status;
    }
    // getMessage()는 부모(RuntimeException)가 이미 제공함!
    // public String getMessage() { return super.getMessage(); }
    // super(message) 빼먹으면: exception.getMessage() 호출 시 null이 나온다.
}
