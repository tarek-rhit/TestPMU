package com.example.testpmu.controllers.Api;

import com.example.testpmu.dto.CourseDto;
import com.example.testpmu.dto.PartantDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CourseApi {

    @PostMapping(value="/course/creer")
    CourseDto createCourse(@RequestBody CourseDto courseDto);

    @PostMapping(value="/partant/creer")
    PartantDto createPartant(@RequestBody PartantDto partantDto);

    @PutMapping(value="/course/modifier")
    CourseDto updateCourse(@RequestBody CourseDto courseDto);

    @PutMapping(value="/partant/modifier")
    PartantDto updatePartant(@RequestBody PartantDto partantDto);

    @GetMapping(value="/course/{cid}")
    CourseDto getCourseByID(@PathVariable Long cid);

    @GetMapping(value="/paratnt/{pid}")
    PartantDto getPartantById(@PathVariable Long pid);

    @GetMapping(value="/course/all")
    List<CourseDto> getAll();

    @GetMapping(value="/partant/all")
    List<PartantDto> getAllPartants();

    @DeleteMapping(value="/course/supprimer/{cid}")
    Boolean deleteCourse(@PathVariable Long cid);

    @DeleteMapping(value="/partant/supprimer/{pid}")
    Boolean deletePartant(@PathVariable Long pid);



}
