package com.project.doctolib.services;

import com.project.doctolib.models.Professionnel;
import com.project.doctolib.models.User;
import com.project.doctolib.repositories.ProfessionnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProfessionnelService {
    @Autowired
    ProfessionnelRepository professionnelRepository;


    // list des pros
    public Page<Professionnel> getAll( PageRequest pageRequest) {
        Page<Professionnel> users = professionnelRepository.findAll(pageRequest);

        return users;
    }

    public Professionnel getById(int id ) {
        return professionnelRepository.findById(id).get();
    }
    public void add (Professionnel p){
        professionnelRepository.save(p);
    }
    public void delete (int id) {
        professionnelRepository.deleteById(id);
    }
}
