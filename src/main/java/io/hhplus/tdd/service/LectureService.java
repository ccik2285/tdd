package io.hhplus.tdd.service;

import io.hhplus.tdd.entity.Lecture;

import java.util.List;

public interface LectureService {
    public void registLecture(long lecture_id,long student_id);
    public List<Lecture> getavailablelist(String dateParam);
    //public void searchAvailableLectures();
}
