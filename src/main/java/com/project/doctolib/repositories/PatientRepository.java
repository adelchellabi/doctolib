package com.project.doctolib.repositories;

import com.project.doctolib.models.Patient;
import com.project.doctolib.models.Professionnel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;


@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {


    // Page<Professionnel> findAllByActive(boolean isActive,Pageable pageable);
     Page<Patient> findAll(Pageable pageable);

     @Override
     Optional<Patient> findById(Integer integer);

     @Transactional
     @Modifying
     @Query(value = "delete from Patient as p  where p.id=?1")
     void deleteById(Integer integer);
}

