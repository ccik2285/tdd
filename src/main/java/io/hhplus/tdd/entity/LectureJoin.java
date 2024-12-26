package io.hhplus.tdd.entity;

import io.hhplus.tdd.common.StateCd;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Builder
@Entity
@Getter
@Table(name = "lecturejoin")
public class LectureJoin {
    @EmbeddedId
    private LectureJoinId id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "studentId", insertable = false, updatable = false)
    private Student student;

    @ManyToOne
    @MapsId("lectureId")
    @JoinColumn(name = "lectureId", insertable = false, updatable = false)
    private Lecture lecture;

    @Enumerated(EnumType.STRING)
    private StateCd stateCd;

    public static LectureJoin createLectureJoin(Student student, Lecture lecture, StateCd stateCd) {
        LectureJoinId id = new LectureJoinId(student.getId(), lecture.getId());
        return LectureJoin.builder()
                .id(id)
                .student(student)
                .lecture(lecture)
                .stateCd(stateCd)
                .build();
    }

}
