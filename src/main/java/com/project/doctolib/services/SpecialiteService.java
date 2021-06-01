package com.project.doctolib.services;

import com.project.doctolib.models.Specialite;
import com.project.doctolib.repositories.SpecialiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialiteService {
    @Autowired
    SpecialiteRepository specialiteRepository;

    public List<Specialite> getAll(){
        return specialiteRepository.findAll();
    }
}
