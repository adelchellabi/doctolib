package com.project.doctolib.repositories;

import com.project.doctolib.models.Langue_professionnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Langue_professionnelRepository extends JpaRepository<Langue_professionnel,Integer> {
}
