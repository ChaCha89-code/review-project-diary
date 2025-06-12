package com.github.chacha89.reviewprojectdiary.diaryDto;

import java.time.LocalDateTime;

public class DiaryDetailResponseDto {
    private Long diaryId;
    private String userName;
    private String title;
    private String image;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public DiaryDetailResponseDto(Long diaryId, String userName, String title, String image, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.diaryId = diaryId;
        this.userName = userName;
        this.title = title;
        this.image = image;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getDiaryId() {
        return diaryId;
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

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
