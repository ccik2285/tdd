package io.hhplus.tdd.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;
import io.hhplus.tdd.dto.LectureResponse;
import io.hhplus.tdd.dto.LectureJoinedResponse;

@RestController
@RequestMapping("/lecture")
public class LectureController {


    @PostMapping("/register")
    public ResponseEntity<String> register() {

        return new ResponseEntity<>("수강신청이 완료되었습니다.", HttpStatus.OK);
    }

    @GetMapping("/available-lectures")
    public List<LectureResponse> availablelist() {

        return List.of();
    }

    @GetMapping("/registerd-lectures")
    public List<LectureJoinedResponse> joinedlectures() {

        return List.of();
    }


}
