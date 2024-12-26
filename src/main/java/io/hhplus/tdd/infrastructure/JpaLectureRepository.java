package io.hhplus.tdd.infrastructure;

import io.hhplus.tdd.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface JpaLectureRepository extends JpaRepository<Lecture,Long>{
    List<Lecture> findByLectureDateAndCurrentCapacityLessThan(LocalDate date, long capacity);
}
