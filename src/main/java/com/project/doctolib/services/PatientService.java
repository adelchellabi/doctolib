package com.project.doctolib.services;

import com.project.doctolib.models.Patient;
import com.project.doctolib.models.Professionnel;
import com.project.doctolib.repositories.PatientRepository;
import com.project.doctolib.repositories.ProfessionnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    PatientRepository PatientRepository;


    // list des pros
    public Page<Patient> getAll(PageRequest pageRequest) {
        Page<Patient> users = PatientRepository.findAll(pageRequest);

        return users;
    }

    public Patient getById(int id ) {
        return PatientRepository.findById(id).get();
    }
    public void add (Patient p){
        PatientRepository.save(p);
    }
    public void delete (int id) {
        PatientRepository.deleteById(id);
    }
}
