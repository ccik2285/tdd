package io.hhplus.tdd.infrastructure;

import io.hhplus.tdd.common.StateCd;
import io.hhplus.tdd.entity.Lecture;
import io.hhplus.tdd.entity.LectureJoin;
import io.hhplus.tdd.entity.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface LectureRepositoryCustom {
    List<LectureJoin> findAllByStudentIdAndLectureId(long student_id, long lecture_id);
    Optional<Lecture> findByIdLectureIdWithLock(long lecture_id);
    Optional<Student> findByIdStudentId(long student_id);
    void saveLectureJoin(LectureJoin lectureJoin);
    List<Lecture> findByLectureDateAndCurrentCapacityLessThan(LocalDate date, long capacity);
    List<LectureJoin> findAllByStudentIdAndStateCd(long student_id, StateCd stateCd);
}
