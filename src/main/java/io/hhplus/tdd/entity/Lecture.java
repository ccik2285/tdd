package io.hhplus.tdd.entity;

import io.hhplus.tdd.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "lecture")
public class Lecture extends BaseEntity {

    private String name;
    private String professor;
    private long maxCapacity;
    private long currentCapacity;
    private LocalDate lectureDate;


    @Builder
    public Lecture(String name, String professor, long maxCapacity, long currentCapacity, LocalDate lectureDate) {
        this.name = name;
        this.professor = professor;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
        this.lectureDate = lectureDate;
    }


    public void increaseCapacity() {
        this.currentCapacity += 1;
    }

    public void decreaseCapacity() {
        this.currentCapacity -= 1;
    }

}
