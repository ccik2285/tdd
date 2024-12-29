package io.hhplus.tdd.service;

import io.hhplus.tdd.common.StateCd;
import io.hhplus.tdd.entity.Lecture;
import io.hhplus.tdd.entity.Student;
import io.hhplus.tdd.infrastructure.LectureRepository;
import org.junit.jupiter.api.DisplayName;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;
import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class ServiceTest {

    @Autowired
    private LectureRepository lectureRepository;


    @Autowired
    private LectureService lectureService;

    @Test
    void 수강신청성공() {
        lectureService.registLecture(1,3);
        lectureRepository.findAllByStudentIdAndStateCd(1, StateCd.REGISTERED);
    }

    @Test
    void 없는강의번호(){
        lectureService.registLecture(1,1);
    }

    @Test
    void 전체강의내역조회() {

    }

}
