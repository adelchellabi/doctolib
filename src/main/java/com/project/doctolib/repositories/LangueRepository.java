package com.project.doctolib.repositories;

import com.project.doctolib.models.Langue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LangueRepository extends JpaRepository<Langue,Integer> {
    @Query(value = "select l from Langue_professionnel  lp, Langue  l ,Professionnel p where lp.id_langue=l.id and lp.id_professionnel =?1")
    List<Langue> findByPro(int id);
}
