package io.hhplus.tdd.entity;

import io.hhplus.tdd.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "lecture")
public class Lecture extends BaseEntity {

    private String name;
    private String professor;
    private long maxCapacity;
    private long currentCapacity;
}
