package io.hhplus.tdd.infrastructure;

import io.hhplus.tdd.entity.Lecture;
import io.hhplus.tdd.entity.LectureJoin;
import io.hhplus.tdd.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LectureRepository implements LectureRepositoryCustom{
    private final JpaLectureRepository jpaLectureRepository;
    private final JpaLectureJoinRepository jpaLectureJoinRepository;
    private final JpaStudentRepository jpaStudentRepository;

    public LectureRepository(JpaLectureRepository jpaLectureRepository, JpaLectureJoinRepository jpaLectureJoinRepository, JpaStudentRepository jpaStudentRepository) {
        this.jpaLectureRepository = jpaLectureRepository;
        this.jpaLectureJoinRepository = jpaLectureJoinRepository;
        this.jpaStudentRepository = jpaStudentRepository;
    }

    @Override
    public void registLecture(LectureJoin lectureJoin) {
        jpaLectureJoinRepository.save(lectureJoin);
    }

    @Override
    public List<LectureJoin> findAllByStudentIdAndLectureId(long studentId, long lectureId) {
        return jpaLectureJoinRepository.findAllByStudentIdAndLectureId(studentId,lectureId);
    }

    @Override
    public Optional<Lecture> findByIdLectureId(long lectureId) {
        return jpaLectureRepository.findById(lectureId);
    }

    @Override
    public Optional<Student> findByIdStudentId(long studentId) {
        return jpaStudentRepository.findById(studentId);
    }

    @Override
    public LectureJoin saveLectureJoin(LectureJoin lectureJoin) {
        return jpaLectureJoinRepository.save(lectureJoin);
    }


}
