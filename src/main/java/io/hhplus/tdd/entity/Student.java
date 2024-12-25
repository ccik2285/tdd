package io.hhplus.tdd.entity;

import io.hhplus.tdd.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student extends BaseEntity {

    private String name;
    private long totLectureJoin;
}
