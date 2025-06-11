package com.github.chacha89.reviewprojectdiary.repository;

import com.github.chacha89.reviewprojectdiary.domain.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
}
