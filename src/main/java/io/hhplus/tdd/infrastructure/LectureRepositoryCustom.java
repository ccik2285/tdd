package io.hhplus.tdd.infrastructure;

import io.hhplus.tdd.common.StateCd;
import io.hhplus.tdd.entity.Lecture;
import io.hhplus.tdd.entity.LectureJoin;
import io.hhplus.tdd.entity.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface LectureRepositoryCustom {
    List<LectureJoin> findAllByStudentIdAndLectureId(long studentId, long lectureId);
    Optional<Lecture> findByIdLectureId(long lectureId);
    Optional<Student> findByIdStudentId(long studentId);
    void saveLectureJoin(LectureJoin lectureJoin);
    List<Lecture> findByLectureDateAndCurrentCapacityLessThan(LocalDate date, long capacity);
    List<LectureJoin> findAllByStudentIdAndStateCd(long studentId, StateCd stateCd);
}
