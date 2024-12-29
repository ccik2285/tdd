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
    private LectureJoinId id;  // 복합키 필드

    // Lecture와의 관계 설정
    @ManyToOne
    @MapsId("lecture_id")  // 복합키에서 lectureId를 가져와서 매핑
    @JoinColumn(name = "lecture_id")  // lectureId 컬럼
    private Lecture lecture;

    // Student와의 관계 설정
    @ManyToOne
    @MapsId("student_id")  // 복합키에서 studentId를 가져와서 매핑
    @JoinColumn(name = "student_id")  // studentId 컬럼

    private Student student;

    @Enumerated(EnumType.STRING)
    private StateCd stateCd;

    protected LectureJoin() {
    }

    public LectureJoin(LectureJoinId id, Lecture lecture, Student student, StateCd stateCd) {
        this.id = id;
        this.lecture = lecture;
        this.student = student;
        this.stateCd = stateCd;
    }

    public static LectureJoin createLectureJoin(Student student, Lecture lecture, StateCd stateCd) {
        if (lecture == null || student == null) {
            throw new IllegalArgumentException("Lecture and Student must not be null");
        }
        LectureJoinId id = new LectureJoinId(student.getId(), lecture.getId());
        return LectureJoin.builder()
                .id(id)
                .student(student)
                .lecture(lecture)
                .stateCd(stateCd)
                .build();
    }
}