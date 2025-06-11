package com.github.chacha89.reviewprojectdiary.repository;

import com.github.chacha89.reviewprojectdiary.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email); // 이미 있는 이메일인지 확인
}
