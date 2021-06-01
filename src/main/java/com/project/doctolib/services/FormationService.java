package com.project.doctolib.services;

import com.project.doctolib.models.Formation;
import com.project.doctolib.repositories.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormationService {
    @Autowired
    FormationRepository formationRepository;
     public List<Formation> getAll(int id){
         return formationRepository.findAllByIdProfessionnel(id);
     }
     public void add(Formation formation){
         formationRepository.save(formation);
     }
}
