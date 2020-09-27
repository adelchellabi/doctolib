package com.project.doctolib.repositories;

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
public interface ProfessionnelRepository  extends JpaRepository<Professionnel,Integer> {


    // Page<Professionnel> findAllByActive(boolean isActive,Pageable pageable);
     Page<Professionnel> findAll(Pageable pageable);

     @Override
     Optional<Professionnel> findById(Integer integer);

     @Transactional
     @Modifying
     @Query(value = "delete from Professionnel as p  where p.id=?1")
     void deleteById(Integer integer);
}

