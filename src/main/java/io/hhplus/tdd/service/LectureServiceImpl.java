package io.hhplus.tdd.service;

import io.hhplus.tdd.common.StateCd;
import io.hhplus.tdd.entity.Lecture;
import io.hhplus.tdd.entity.LectureJoin;
import io.hhplus.tdd.entity.Student;
import io.hhplus.tdd.infrastructure.LectureRepository;
import io.hhplus.tdd.util.LectureValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LectureServiceImpl implements LectureService{

    private final LectureRepository lectureRepository;
    private final LectureValidator  lectureValidator;

    public LectureServiceImpl(LectureRepository lectureRepository, LectureValidator lectureValidator) {
        this.lectureRepository = lectureRepository;
        this.lectureValidator = lectureValidator;
    }


    @Override
    public void registLecture(long lectureId,long studentId) {

        //lectureId,studentId로 먼저 조회
        Optional<Lecture> optionalLecture = lectureRepository.findByIdLectureId(lectureId);
        Optional<Student> optionalStudent = lectureRepository.findByIdStudentId(studentId);
        List<LectureJoin> lectureJoinList = lectureRepository.findAllByStudentIdAndLectureId(lectureId,studentId);

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

        // LectureJoin 생성 및 저장
        Student student = Student.createStudent(studentInfo.getName(),studentInfo.getTotLectureJoin());
        LectureJoin lectureJoin = LectureJoin.createLectureJoin(student, lecture, StateCd.REGISTERED);
        lectureRepository.saveLectureJoin(lectureJoin);

        lecture.increaseCapacity();
    }

    /*
    @Override
    public void searchMyLectureList() {

    }

    @Override
    public void searchAvailableLectures() {

    } */

}
