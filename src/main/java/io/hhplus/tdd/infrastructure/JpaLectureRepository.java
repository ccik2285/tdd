package io.hhplus.tdd.infrastructure;

import io.hhplus.tdd.entity.Lecture;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface JpaLectureRepository extends JpaRepository<Lecture,Long>{
    List<Lecture> findByLectureDateAndCurrentCapacityLessThan(LocalDate date, long capacity);
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Lecture> findByIdLectureIdWithLock(long lectureId);
}
