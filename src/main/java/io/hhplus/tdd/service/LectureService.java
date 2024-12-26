package io.hhplus.tdd.service;

import io.hhplus.tdd.dto.LectureJoinedResponse;
import io.hhplus.tdd.entity.Lecture;

import java.util.List;

public interface LectureService {
    void registLecture(long lecture_id,long student_id);
    List<Lecture> getAvailableList(String dateParam);
    List<LectureJoinedResponse> getRegisteredLectures(long studentId);
}
