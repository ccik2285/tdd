package io.hhplus.tdd.util;

import io.hhplus.tdd.entity.Lecture;
import io.hhplus.tdd.entity.LectureJoin;
import io.hhplus.tdd.entity.Student;

import java.util.List;

public interface LectureValidator {
    public void validateLectureCapacity(Lecture lecture);
    public void validateLectureJoin(List<LectureJoin> lectureJoinList);
}
