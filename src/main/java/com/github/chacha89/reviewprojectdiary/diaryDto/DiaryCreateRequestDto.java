package com.github.chacha89.reviewprojectdiary.diaryDto;

import org.springframework.web.multipart.MultipartFile;

public class DiaryCreateRequestDto {
    private Long userId;
    private String userName;
    private String title;
    private MultipartFile image;
    private String content;

    public DiaryCreateRequestDto(Long userId, String userName, String title, MultipartFile image, String content) {
        this.userId = userId;
        this.userName = userName;
        this.title = title;
        this.image = image;
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getTitle() {
        return title;
    }

    public MultipartFile getImage() {
        return image;
    }

    public String getContent() {
        return content;
    }
}
