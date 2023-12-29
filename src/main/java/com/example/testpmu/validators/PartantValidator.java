package com.example.testpmu.validators;

import com.example.testpmu.dto.PartantDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class PartantValidator {

    public static List<String> validate(PartantDto partantDto) {
        List<String> errors = new ArrayList<>();
        if (partantDto == null) {
            errors.add("veuillez introduire le nom du partant");
            errors.add("veuillez introduire le numero du partant");
            errors.add("veuillez indiquer la course qu'il appartient");
            return errors;
        }
        if (!StringUtils.hasLength(partantDto.getNom())) {
            errors.add("veuillez saisir le nom du partant");
        }
        if (partantDto.getNumero()== 0) {
            errors.add("veuillez introduire un numero superieur à 0");
        }
        return errors;
    }
}
