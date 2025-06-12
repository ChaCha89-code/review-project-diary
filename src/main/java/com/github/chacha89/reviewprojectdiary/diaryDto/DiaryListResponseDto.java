package com.github.chacha89.reviewprojectdiary.diaryDto;

import java.time.LocalDateTime;

public class DiaryListResponseDto {
    private Long id;
    private String userName;
    private String title;
    private String image;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public DiaryListResponseDto(Long id, String userName, String title, String image, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.userName = userName;
        this.title = title;
        this.image = image;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAT() {
        return updatedAt;
    }
}
