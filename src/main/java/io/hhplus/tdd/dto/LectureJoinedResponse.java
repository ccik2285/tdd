package io.hhplus.tdd.dto;

public class LectureJoinedResponse {
    private Long lectureId;
    private String name;
    private String professor;

    public LectureJoinedResponse(Long id, String name, String professor) {
        this.lectureId = id;
        this.name = name;
        this.professor = professor;
    }
}
