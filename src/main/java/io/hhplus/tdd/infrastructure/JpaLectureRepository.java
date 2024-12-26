package io.hhplus.tdd.infrastructure;

import io.hhplus.tdd.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaLectureRepository extends JpaRepository<Lecture,Long>{

}
