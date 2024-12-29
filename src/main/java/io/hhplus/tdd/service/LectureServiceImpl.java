package io.hhplus.tdd.service;

import io.hhplus.tdd.common.StateCd;
import io.hhplus.tdd.dto.LectureJoinedResponse;
import io.hhplus.tdd.entity.Lecture;
import io.hhplus.tdd.entity.LectureJoin;
import io.hhplus.tdd.entity.Student;
import io.hhplus.tdd.infrastructure.LectureRepository;
import io.hhplus.tdd.util.LectureValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class LectureServiceImpl implements LectureService{

    private final LectureRepository lectureRepository;
    private final LectureValidator  lectureValidator;

    public LectureServiceImpl(LectureRepository lectureRepository, LectureValidator lectureValidator) {
        this.lectureRepository = lectureRepository;
        this.lectureValidator = lectureValidator;
    }


    @Override
    public void registLecture(long lecture_id,long student_id) {

        //lectureId,studentId로 먼저 조회
        Optional<Lecture> optionalLecture = lectureRepository.findByIdLectureIdWithLock(lecture_id);
        Optional<Student> optionalStudent = lectureRepository.findByIdStudentId(student_id);
        List<LectureJoin> lectureJoinList = lectureRepository.findAllByStudentIdAndLectureId(lecture_id,student_id);

        if(optionalLecture.isEmpty()){
            throw new IllegalArgumentException("해당 강좌는 없는 강좌입니다.");
        }

        if(optionalStudent.isEmpty()){
            throw new IllegalArgumentException("해당 userId는 없는 Id입니다.");
        }

        Lecture lecture = optionalLecture.get();
        Student studentInfo = optionalStudent.get();

        lectureValidator.validateLectureCapacity(lecture);
        lectureValidator.validateLectureJoin(lectureJoinList);

        LectureJoin lectureJoin = LectureJoin.createLectureJoin(studentInfo, lecture, StateCd.REGISTERED);
        log.info("hello" + studentInfo.getId() + " " + lecture.getId());
        log.info("hello" + lectureJoin.getLecture().getId() + " " + lectureJoin.getStudent().getId());
        lectureRepository.saveLectureJoin(lectureJoin);

        lecture.increaseCapacity();
    }

    @Override
    public List<Lecture> getAvailableList(String dateParam) {
        LocalDate date = LocalDate.parse(dateParam);
        return lectureRepository.findByLectureDateAndCurrentCapacityLessThan(date,30);
    }

    @Override
    public List<LectureJoinedResponse> getRegisteredLectures(long userid) {
        List<LectureJoin> lectures = lectureRepository.findAllByStudentIdAndStateCd(userid,StateCd.REGISTERED);
        return lectures.stream()
                .map(mp -> {
                    Lecture lecture = lectureRepository.findByIdLectureIdWithLock(mp.getLecture().getId())
                            .orElseThrow(() -> new RuntimeException("Lecture not found"));
                    return new LectureJoinedResponse(
                            lecture.getId(),
                            lecture.getName(),
                            lecture.getProfessor()
                    );
                })
                .collect(Collectors.toList());
    }

}
