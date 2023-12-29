package com.example.testpmu.services.impl;

import com.example.testpmu.dto.CourseDto;
import com.example.testpmu.dto.PartantDto;
import com.example.testpmu.exceptions.ErrorCodes;
import com.example.testpmu.exceptions.InvalidEntityException;
import com.example.testpmu.models.Course;
import com.example.testpmu.models.CourseEvent;
import com.example.testpmu.models.Partant;
import com.example.testpmu.repositories.CourseRepository;
import com.example.testpmu.repositories.PartantRepository;
import com.example.testpmu.services.CourseService;
import com.example.testpmu.validators.CourseValidator;
import com.example.testpmu.validators.PartantValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CourseServiceImpl implements CourseService {



    private final CourseRepository courseRepository;


    private final PartantRepository partantRepository;



    private final ModelMapper modelMapper;

    private final KafkaTemplate<String, CourseEvent> kafkaTemplate;
    private static final String COURSE_CREATED_TOPIC = "courseCreatedTopic";

    @Autowired
    public CourseServiceImpl(ModelMapper modelMapper, KafkaTemplate<String, CourseEvent> kafkaTemplate,
                             CourseRepository courseRepository,  PartantRepository partantRepository)
    {
        this.modelMapper = modelMapper;
        this.courseRepository = courseRepository;
        this.partantRepository = partantRepository;
        this.kafkaTemplate = kafkaTemplate;
    }


    @Override
    public CourseDto createCourse(CourseDto courseDto) {
        List<String> errors = CourseValidator.validate(courseDto);

        if(!errors.isEmpty()){
            throw new InvalidEntityException("Course n'est pas valide", ErrorCodes.NUMERO_DE_COURSE_INVALID);
        }

        Course course = modelMapper.map(courseDto,Course.class);
        Course created = courseRepository.save(course);
        CourseEvent event = new CourseEvent(created.getId(), created.getName(), created.getNumero());
        kafkaTemplate.send(COURSE_CREATED_TOPIC, event);
        return modelMapper.map(created,CourseDto.class);
    }


    @Override
    public PartantDto createPartant(PartantDto partantDto) {
        List<String> errors = PartantValidator.validate(partantDto);

        if(!errors.isEmpty()){
            throw new InvalidEntityException("Partant n'est pas valide", ErrorCodes.NOMBRE_PARTANTS_NOT_FOUND);
        }

        Partant partant = modelMapper.map(partantDto,Partant.class);
        Partant created = partantRepository.save(partant);
        return modelMapper.map(created,PartantDto.class);
    }

    @Override
    public List<PartantDto> addPartantToCourse(PartantDto partantDto, CourseDto courseDto) {

        return null;
    }


    @Override
    public CourseDto updateCourse(CourseDto courseDto) {
        List<String> errors = CourseValidator.validate(courseDto);

        if(!errors.isEmpty()){
            throw new InvalidEntityException("Course n'est pas valide", ErrorCodes.NUMERO_DE_COURSE_INVALID);
        }

        Course course = modelMapper.map(courseDto,Course.class);
        Course created = courseRepository.save(course);
        CourseEvent event = new CourseEvent(created.getId(), created.getName(), created.getNumero());
        kafkaTemplate.send(COURSE_CREATED_TOPIC, event);
        return modelMapper.map(created,CourseDto.class);
    }

    @Override
    public PartantDto updatePartant(PartantDto partantDto) {
        List<String> errors = PartantValidator.validate(partantDto);

        if(!errors.isEmpty()){
            throw new InvalidEntityException("Partant n'est pas valide", ErrorCodes.NOMBRE_PARTANTS_NOT_FOUND);
        }

        Partant partant = modelMapper.map(partantDto,Partant.class);
        Partant created = partantRepository.save(partant);
        return modelMapper.map(created,PartantDto.class);
    }

    @Override
    public CourseDto getCourseByID(Long cid) {
        if(cid == null){
            return null;
        }
        return modelMapper.map(courseRepository.findAllById(Collections.singleton(cid)),CourseDto.class);
    }

    @Override
    public PartantDto getPartantByID(Long pid) {
        if(pid == null){
            return null;
        }
        return modelMapper.map(partantRepository.findAllById(Collections.singleton(pid)),PartantDto.class);
    }

    @Override
    public List<CourseDto> getAll() {
        return courseRepository.findAll().stream()
                .map(c->modelMapper.map(c,CourseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PartantDto> getAllPartants() {
        return partantRepository.findAll().stream()
                .map(p->modelMapper.map(p,PartantDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteCourse(Long cid) {
        if(cid == null){
            return null;
        }
         courseRepository.deleteById(cid);
        return true;
    }

    @Override
    public Boolean deletePartant(Long pid) {
        if(pid == null){
            return null;
        }
        partantRepository.deleteById(pid);
        return true;
    }
}

