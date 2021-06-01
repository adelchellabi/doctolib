package com.project.doctolib.services;

import com.project.doctolib.models.Langue;
import com.project.doctolib.repositories.LangueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LangueService {
    @Autowired
    LangueRepository langueRepository;
    public List<Langue> getByIdPro(int id) {
        return langueRepository.findByPro(id);
    }
    public List<Langue> getAll() {
        return langueRepository.findAll();
    }
}
