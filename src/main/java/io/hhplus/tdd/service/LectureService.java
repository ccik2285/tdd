package io.hhplus.tdd.service;

import io.hhplus.tdd.dto.LectureJoinedResponse;
import io.hhplus.tdd.entity.Lecture;

import java.util.List;

public interface LectureService {
    public void registLecture(long lecture_id,long student_id);
    public List<Lecture> getAvailableList(String dateParam);
    public List<LectureJoinedResponse> getRegisteredLectures(long lectureId);
}
