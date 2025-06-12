package com.github.chacha89.reviewprojectdiary.diaryDto;

import org.springframework.web.multipart.MultipartFile;

public class DiaryUpdateRequestDto {
    private String title;
    private MultipartFile image;
    private String content;

    public DiaryUpdateRequestDto(String title, MultipartFile image, String content) {
        this.title = title;
        this.image = image;
        this.content = content;
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
