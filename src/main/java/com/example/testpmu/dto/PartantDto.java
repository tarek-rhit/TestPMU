package com.example.testpmu.dto;


import com.example.testpmu.models.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartantDto {



    private String nom;

    private int numero;

    private Course course;
}
