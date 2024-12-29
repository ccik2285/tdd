package io.hhplus.tdd.infrastructure;

import io.hhplus.tdd.common.StateCd;
import io.hhplus.tdd.entity.Lecture;
import io.hhplus.tdd.entity.LectureJoin;
import io.hhplus.tdd.entity.Student;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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
    public List<LectureJoin> findAllByStudentIdAndLectureId(long student_id, long lecture_id) {
        return jpaLectureJoinRepository.findAllByStudentIdAndLectureId(student_id,lecture_id);
    }

    @Override
    public Optional<Lecture> findByIdLectureIdWithLock(long lecture_id) {
        return jpaLectureRepository.findById(lecture_id);
    }

    @Override
    public Optional<Student> findByIdStudentId(long student_id) {
        return jpaStudentRepository.findById(student_id);
    }

    @Override
    public void saveLectureJoin(LectureJoin lectureJoin) {
        jpaLectureJoinRepository.save(lectureJoin);
    }

    @Override
    public List<Lecture> findByLectureDateAndCurrentCapacityLessThan(LocalDate date, long capacity) {
        return jpaLectureRepository.findByLectureDateAndCurrentCapacityLessThan(date,capacity);
    }

    @Override
    public List<LectureJoin> findAllByStudentIdAndStateCd(long student_id,StateCd stateCd) {
        return jpaLectureJoinRepository.findAllByStudentIdAndStateCd(student_id, stateCd);
    }

}
