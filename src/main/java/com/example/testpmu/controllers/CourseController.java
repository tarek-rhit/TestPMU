package com.example.testpmu.controllers;

import com.example.testpmu.controllers.Api.CourseApi;
import com.example.testpmu.dto.CourseDto;
import com.example.testpmu.dto.PartantDto;
import com.example.testpmu.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourseController implements CourseApi {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @Override
    public CourseDto createCourse(CourseDto courseDto) {
        return courseService.createCourse(courseDto);
    }

    @Override
    public PartantDto createPartant(PartantDto partantDto) {
        return courseService.createPartant(partantDto);
    }

    @Override
    public CourseDto updateCourse(CourseDto courseDto) {
        return courseService.updateCourse(courseDto);
    }

    @Override
    public PartantDto updatePartant(PartantDto partantDto) {
        return courseService.updatePartant(partantDto);
    }

    @Override
    public CourseDto getCourseByID(Long cid) {
        return courseService.getCourseByID(cid);
    }

    @Override
    public PartantDto getPartantById(Long pid) {
        return courseService.getPartantByID(pid);
    }

    @Override
    public List<CourseDto> getAll() {
        return courseService.getAll();
    }

    @Override
    public List<PartantDto> getAllPartants() {
        return courseService.getAllPartants();
    }

    @Override
    public Boolean deleteCourse(Long cid) {
        return courseService.deleteCourse(cid);
    }

    @Override
    public Boolean deletePartant(Long pid) {
        return courseService.deletePartant(pid);
    }
}
