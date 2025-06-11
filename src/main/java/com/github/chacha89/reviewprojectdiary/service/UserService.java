package com.github.chacha89.reviewprojectdiary.service;

import com.github.chacha89.reviewprojectdiary.domain.User;
import com.github.chacha89.reviewprojectdiary.exception.UserCreateException;
import com.github.chacha89.reviewprojectdiary.repository.UserRepository;
import com.github.chacha89.reviewprojectdiary.userDto.UserCreateRequestDto;
import com.github.chacha89.reviewprojectdiary.userDto.UserCreateResponseDto;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// Return domain data or a DTO, NOT a ResponseEntity.
@Service
public class UserService {
    // 속성
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    // 생성자
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //기능

    /**
     * 회원 가입 기능
     */
    @Transactional
    public UserCreateResponseDto createUserService(UserCreateRequestDto requestDto) {
        // 데이터 준비
        String userName = requestDto.getUserName();
        String email = requestDto.getEmail();
        String password = requestDto.getPassword();
        String checkPassword = requestDto.getCheckPassword();

        // 빈 값 체크
        if(userName.isBlank() || email.isBlank() || password.isBlank() || checkPassword.isBlank()) {
            throw new UserCreateException(400, "회원가입 입력정보 중 빈 항목이 있습니다.");
        }

        // 이메일 중복 체크
        if(userRepository.existsByEmail(email)) {
            throw new UserCreateException(400, "이미 존재하는 아아디입니다.");
        }

        // 아이디가 이메일이 아닌 경우 : 정규식(Regular Expression) 사용
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!email.matches(emailRegex)) {
            throw new UserCreateException(400, "아이디는 이메일 형식이어야 합니다.");
        }

        // 비밀번호 복잡도 체크
        System.out.println("비밀번호 입력값: [" + password + "]");
        System.out.println("일치 여부: " + password.equals(checkPassword));

        if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\w\\s])[\\S]{8,20}$")) {
            throw new UserCreateException(400, "비밀번호는 최소 8자리, 최대 20자리이며, 대소문자, 숫자, 특수문자를 포함해야 합니다.");
        }

        // 비민번호 확인 일치 여부 체크
        if (!password.equals(checkPassword)) {
            throw new UserCreateException(400, "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        }

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(password);

        // 유저 엔티티 생성
        User newUser = new User(userName, email, encodedPassword);

        // 저장
        userRepository.save(newUser);

        // 응답
        return new UserCreateResponseDto(200, "회원가입이 정상적으로 완료 되었습니다.");
    }
}
