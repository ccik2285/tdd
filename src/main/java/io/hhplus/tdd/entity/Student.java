package io.hhplus.tdd.entity;

import io.hhplus.tdd.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;


@Entity
@Getter
@lombok.NoArgsConstructor
@Table(name = "student")
public class Student extends BaseEntity {

    private String name;
    private long totLectureJoin;


    @Builder
    public static Student createStudent(String name,long totLectureJoin) {
        return Student.builder()
                .name(name)
                .totLectureJoin(totLectureJoin)
                .build();
    }
}
