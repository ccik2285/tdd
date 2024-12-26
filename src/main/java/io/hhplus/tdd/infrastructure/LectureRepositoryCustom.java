package io.hhplus.tdd.infrastructure;

import io.hhplus.tdd.entity.Lecture;
import io.hhplus.tdd.entity.LectureJoin;
import io.hhplus.tdd.entity.Student;

import java.util.List;
import java.util.Optional;

public interface LectureRepositoryCustom {
    public void registLecture(LectureJoin lectureJoin);
    List<LectureJoin> findAllByStudentIdAndLectureId(long studentId, long lectureId);
    public Optional<Lecture> findByIdLectureId(long lectureId);
    public Optional<Student> findByIdStudentId(long studentId);
    public LectureJoin saveLectureJoin(LectureJoin lectureJoin);
   // public void findLectureJoinHistory();
}
