package com.project.doctolib.services;


import com.project.doctolib.models.User;
import com.project.doctolib.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public boolean addUser(User user){
        User u =repository.save(user);
        return !u.getUsername().equals("") ;
    }

    public User getUserById(int id){
        return repository.getOne(id);
    }
    public User getUserByUserName(String username){
        return repository.findUserByUsername(username);
    }

    // list des utilisateurs
    public Page<User> listUsers(boolean isActive, String roles, PageRequest pageRequest) {
        Page<User> users = repository.findAllByActiveAndRolesLike(isActive, roles, pageRequest);

        return users;
    }

}
