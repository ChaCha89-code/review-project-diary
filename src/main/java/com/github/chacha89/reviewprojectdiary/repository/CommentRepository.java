package com.github.chacha89.reviewprojectdiary.repository;

import com.github.chacha89.reviewprojectdiary.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
