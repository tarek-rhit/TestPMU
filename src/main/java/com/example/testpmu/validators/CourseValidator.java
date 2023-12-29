package com.example.testpmu.validators;

import com.example.testpmu.dto.CourseDto;
import org.springframework.util.StringUtils;


import java.util.ArrayList;
import java.util.List;

public class CourseValidator {

    public static List<String> validate(CourseDto courseDto){
        List<String> errors = new ArrayList<>();
        if(courseDto == null){
            errors.add("veuillez introduire le numero de la course");
            errors.add("veuillez introduire le nom de la course");
            errors.add("veuillez introduire la date de la course");
            return errors;
        }
        if (courseDto.getPartants().size()<3) {
            errors.add("veuillez ajouter trois partants pour créer une course");
        }
        if (!StringUtils.hasLength(courseDto.getName())){
            errors.add("veuillez saisir le nom de la course");
        }
        if (!StringUtils.hasLength((CharSequence) courseDto.getDate())){
            errors.add("veuillez saisir la date de la course");
        }
        if (!StringUtils.hasLength( String.valueOf(courseDto.getNumero()))){
            errors.add("veuillez saisir le numero de la course");
        }
        return errors;
    }
}
