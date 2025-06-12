package com.github.chacha89.reviewprojectdiary.service;

import com.github.chacha89.reviewprojectdiary.diaryDto.*;
import com.github.chacha89.reviewprojectdiary.domain.Diary;
import com.github.chacha89.reviewprojectdiary.domain.User;
import com.github.chacha89.reviewprojectdiary.repository.DiaryRepository;
import com.github.chacha89.reviewprojectdiary.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class DiaryService {

    private final DiaryRepository diaryRepository;
    private final UserRepository userRepository;

    @Value("${file.path}")
    private String uploadFolder;

    public DiaryService(DiaryRepository diaryRepository, UserRepository userRepository) {
        this.diaryRepository = diaryRepository;
        this.userRepository = userRepository;
    }

    /**
     * 게시글 작성 기능
     */
    @Transactional
    public DiaryCreateResponseDto createDiaryService(DiaryCreateRequestDto requestDto) {
        // 1. 데이터 준비
        String userName = requestDto.getUserName();
        String title = requestDto.getTitle();
        MultipartFile image = requestDto.getImage();
        String content = requestDto.getContent();
        Long userId = requestDto.getUserId();

        // 1) userId 조회
        User foundUser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException());


        // 2) 사진 파일 준비
        String url = null;
        if (image != null) {
            UUID uuid = UUID.randomUUID();
            String imageFileName = uuid + "_" + requestDto.getImage().getOriginalFilename();
            System.out.println("이미지 파일 이름: " + imageFileName);
            url = uploadFolder + imageFileName;
            Path imageFilePath = Paths.get(url); // String -> Path

            // The code below writes data(image bytes) to the path represented by imageFilePath.
            try {
                Files.write(imageFilePath, requestDto.getImage().getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        // 2. 엔티티 만들기
        Diary newDiary = new Diary(foundUser, title, url, content);

        Diary savedDiary = diaryRepository.save(newDiary);

        return new DiaryCreateResponseDto(
                savedDiary.getId(),
                foundUser.getUserName(),
                savedDiary.getTitle(),
                savedDiary.getImage(),
                savedDiary.getContent()
        );

    }


    /**
     * 게시물 단건 조회 기능
     */
    public DiaryDetailResponseDto diaryDetailService(Long diaryId) {
        Diary foundDiary = diaryRepository.findById(diaryId).orElseThrow(() -> new RuntimeException("게시물 정보를 조회할 수 없습니다."));
        // 1. 데이터 준비
        Long foundDiaryId = foundDiary.getId();
        User foundUser = foundDiary.getUser();
        String foundUserName = foundUser.getUserName();
        String foundTitle = foundDiary.getTitle();
        String foundImage = foundDiary.getImage();
        String foundContent = foundDiary.getContent();
        LocalDateTime createdAt = foundDiary.getCreatedAt();
        LocalDateTime updatedAt = foundDiary.getUpdatedAt();


        // 2. 엔티티 만들기 및 반환
        DiaryDetailResponseDto responseDto = new DiaryDetailResponseDto(foundDiaryId, foundUserName, foundTitle, foundImage, foundContent, createdAt, updatedAt);
        return responseDto;
    }

    public Page<DiaryListResponseDto> diaryListService(int page, int size) {
        Pageable pageable = PageRequest.of(page, size); // PageRequest.of(page, size) creates the pagination object.
        return diaryRepository.findAll(pageable)
                .map(diary -> new DiaryListResponseDto(
                        diary.getId(),
                        diary.getUser().getUserName(),
                        diary.getTitle(),
                        diary.getImage(),
                        diary.getContent(),
                        diary.getCreatedAt(),
                        diary.getUpdatedAt()
                ));

    }


    /**
     * 게시물 수정 기능
     */
    public void diaryUpdateService(Long id, DiaryUpdateRequestDto requestDto) {



    }


}
