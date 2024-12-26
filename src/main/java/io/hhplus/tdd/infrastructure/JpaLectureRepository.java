package io.hhplus.tdd.infrastructure;

import io.hhplus.tdd.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaLectureRepository extends JpaRepository<Lecture,Long>{
    Lecture findById();

}
