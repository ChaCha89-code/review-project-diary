package com.github.chacha89.reviewprojectdiary.controller;

import com.github.chacha89.reviewprojectdiary.diaryDto.*;
import com.github.chacha89.reviewprojectdiary.service.DiaryService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/diaries")
public class DiaryController {

    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }


    @PostMapping
    public ResponseEntity<DiaryCreateResponseDto> createDiaryAPI(@ModelAttribute DiaryCreateRequestDto requestDto) {
        DiaryCreateResponseDto responseDto = diaryService.createDiaryService(requestDto);
        return ResponseEntity.ok(responseDto);
    }


    @GetMapping("/{id}")
    public ResponseEntity<DiaryDetailResponseDto> detailDiaryAPI(@PathVariable Long id) {
        DiaryDetailResponseDto responseDto = diaryService.diaryDetailService(id);
        return ResponseEntity.ok(responseDto);
    }


    @GetMapping
    public ResponseEntity<Page<DiaryListResponseDto>> diaryListAPI(
            @RequestParam(defaultValue = "0") int page, // Spring pages are 0-indexed!
            @RequestParam(defaultValue = "10") int size // @RequestParam fetches URL params like ?page=1&size=10
    ) {
        Page<DiaryListResponseDto> diaries = diaryService.diaryListService(page, size);
        return ResponseEntity.ok(diaries);
    }


    @PatchMapping("/{id}")
    public void updateDiaryAPI(@PathVariable("id") Long id, @RequestBody DiaryUpdateRequestDto requestDto) {


    }
}
