package com.example.testpmu.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="COURSE")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private int numero;
    @Column
    private String name;
    @Column
    private Date date;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PARTANT_COURSE")
    private List<Partant> partants = new ArrayList<>();

    public List<Partant> getPartants() {
        return partants;
    }

    public void setPartants(List<Partant> partants) {
        this.partants = partants;
    }


}
