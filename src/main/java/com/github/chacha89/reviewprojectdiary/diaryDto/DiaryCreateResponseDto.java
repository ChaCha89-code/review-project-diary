package com.github.chacha89.reviewprojectdiary.diaryDto;

public class DiaryCreateResponseDto {
    private Long id;
    private String userName;
    private String title;
    private String image;
    private String content;

    public DiaryCreateResponseDto(Long id, String userName, String title, String image, String content) {
        this.id = id;
        this.userName = userName;
        this.title = title;
        this.image = image;
        this.content = content;
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
}
