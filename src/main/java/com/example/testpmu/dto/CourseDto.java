package com.example.testpmu.dto;


import com.example.testpmu.models.Partant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

    private int numero;

    private String name;

    private Date date;

    private List<Partant> partants;
}
