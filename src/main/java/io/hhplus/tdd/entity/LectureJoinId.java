package io.hhplus.tdd.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class LectureJoinId implements Serializable {

    private Long student_id;  // 학생 ID
    private Long lecture_id;  // 강의 ID

    public LectureJoinId() {
    }

    public LectureJoinId(Long student_id, Long lecture_id) {
        this.student_id = student_id;
        this.lecture_id = lecture_id;
    }

    // equals()와 hashCode() 메서드 구현 (복합키에서 필수)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LectureJoinId that = (LectureJoinId) o;
        return Objects.equals(student_id, that.student_id) &&
                Objects.equals(student_id, that.lecture_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student_id, lecture_id);
    }
}