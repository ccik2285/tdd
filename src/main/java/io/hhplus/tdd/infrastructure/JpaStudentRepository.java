package io.hhplus.tdd.infrastructure;

import io.hhplus.tdd.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaStudentRepository extends JpaRepository<Student,Long> {

}
