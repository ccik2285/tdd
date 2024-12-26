package io.hhplus.tdd.util;

import io.hhplus.tdd.common.StateCd;
import io.hhplus.tdd.entity.Lecture;
import io.hhplus.tdd.entity.LectureJoin;
import io.hhplus.tdd.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LectureValidatorImpl implements LectureValidator {

    @Override
    public void validateLectureCapacity(Lecture lecture) {
        if (lecture.getCurrentCapacity() >= lecture.getMaxCapacity()) {
            throw new IllegalStateException("이미 정원을 초과한 강의입니다.");
        }
    }



    public void validateLectureJoin(List<LectureJoin> lectureJoinList) {
        boolean isAlreadyRegistered = lectureJoinList.stream()
                .anyMatch(lectureJoin -> lectureJoin != null &&
                        StateCd.REGISTERED.equals(lectureJoin.getStateCd()));

        if (isAlreadyRegistered) {
            throw new IllegalStateException("이미 신청하신 강의입니다.");
        }
    }
}
