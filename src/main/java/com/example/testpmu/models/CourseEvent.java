package com.example.testpmu.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseEvent {

    private Long courseId;
    private String courseName;
    private int courseNumber;
}
