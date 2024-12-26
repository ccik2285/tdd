package io.hhplus.tdd.entity;

import io.hhplus.tdd.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "lecture")
public class Lecture extends BaseEntity {

    private String name;
    private String professor;
    private long maxCapacity;
    private long currentCapacity;

    @Builder
    public Lecture(String name, String professor, long maxCapacity, long currentCapacity) {
        this.name = name;
        this.professor = professor;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
    }

    public void increaseCapacity() {
        this.currentCapacity += 1;
    }

    public void decreaseCapacity() {
        this.currentCapacity -= 1;
    }

}
