package com.example.testpmu.services;

import com.example.testpmu.dto.CourseDto;
import com.example.testpmu.dto.PartantDto;

import java.util.List;

public interface CourseService {


    CourseDto createCourse(CourseDto courseDto);

    PartantDto createPartant(PartantDto partantDto);

    List<PartantDto> addPartantToCourse(PartantDto partantDto,CourseDto courseDto);

    CourseDto updateCourse(CourseDto courseDto);

    PartantDto updatePartant(PartantDto partantDto);

    CourseDto getCourseByID(Long cid);

    PartantDto getPartantByID(Long pid);

    List<CourseDto> getAll();

    List<PartantDto> getAllPartants();

    Boolean deleteCourse(Long cid);

    Boolean deletePartant(Long pid);
}
