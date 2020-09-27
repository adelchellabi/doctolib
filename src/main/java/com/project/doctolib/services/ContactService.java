package com.project.doctolib.services;

import com.project.doctolib.models.Contact;
import com.project.doctolib.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    @Autowired
    ContactRepository contactRepository;

    public Page<Contact> allContact(PageRequest pageRequest){
        return contactRepository.findAll(pageRequest);
    }
}
