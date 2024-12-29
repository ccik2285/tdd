package io.hhplus.tdd.infrastructure;


import io.hhplus.tdd.common.StateCd;
import io.hhplus.tdd.entity.LectureJoin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaLectureJoinRepository extends JpaRepository<LectureJoin,Long>{
    List<LectureJoin> findAllByStudentIdAndLectureId(Long studentId, Long lectureId);
    List<LectureJoin> findAllByStudentIdAndStateCd(Long studentId, StateCd stateCd);
}
