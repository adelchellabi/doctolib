package com.project.doctolib.repositories;

import com.project.doctolib.models.Experiance;
import com.project.doctolib.models.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperianceRepository extends JpaRepository<Experiance,Integer> {

    List<Experiance> findAllByIdProfessionnel(int id);
}
