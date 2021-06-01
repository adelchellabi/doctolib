package com.project.doctolib.services;

import com.project.doctolib.models.Experiance;
import com.project.doctolib.repositories.ExperianceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperianceService {
    @Autowired
    ExperianceRepository experianceRepository;

    public List<Experiance> getAll(int id){
        return experianceRepository.findAllByIdProfessionnel(id);
    }
    public void add(Experiance experiance){
        experianceRepository.save(experiance);
    }
}
