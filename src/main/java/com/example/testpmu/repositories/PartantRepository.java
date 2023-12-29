package com.example.testpmu.repositories;

import com.example.testpmu.models.Partant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartantRepository extends JpaRepository <Partant, Long> {
}
