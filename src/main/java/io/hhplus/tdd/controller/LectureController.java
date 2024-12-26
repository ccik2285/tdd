package io.hhplus.tdd.controller;


import io.hhplus.tdd.entity.Lecture;
import io.hhplus.tdd.service.LectureService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

import io.hhplus.tdd.dto.LectureJoinedResponse;

@RestController
@RequestMapping("/lecture")
public class LectureController {

    private final LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }


    @PostMapping("/register/{lectureId}/{studentId}")
    public ResponseEntity<String> registerlecture(@PathVariable long lectureId,@PathVariable long studentId) {
        lectureService.registLecture(lectureId,studentId);
        return new ResponseEntity<>("수강신청이 완료되었습니다.", HttpStatus.OK);
    }

    @GetMapping("/available-lectures")
    public ResponseEntity<List<Lecture>> getavailablelist(@RequestParam("date") String dateparam) {
        return ResponseEntity.ok(lectureService.getAvailableList(dateparam));
    }

    @GetMapping("/registerd-lectures/{studentId}")
    public ResponseEntity<List<LectureJoinedResponse>> getregisteredlectures(@PathVariable long studentId) {
        return ResponseEntity.ok(lectureService.getRegisteredLectures(studentId));
    }


}
