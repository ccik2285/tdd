package io.hhplus.tdd.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class LectureJoinId implements Serializable {

    private Long studentId;
    private Long lectureId;


    public LectureJoinId() {

    }

    public LectureJoinId(Long studentId, Long lectureId) {
        this.studentId = studentId;
        this.lectureId = lectureId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LectureJoinId that = (LectureJoinId) o;
        return studentId.equals(that.studentId) && lectureId.equals(that.lectureId);
    }

    @Override
    public int hashCode() {
        return 31 * studentId.hashCode() + lectureId.hashCode();
    }
}
