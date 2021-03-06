package com.project.doctolib.repositories;


import com.project.doctolib.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String userName);
    User findUserByUsername(String username);

    Page<User> findAllByActiveEqualsAndRolesNotLike(boolean isActive, String roles, Pageable pageable);
    Page<User> findAllByActiveAndRolesLike(boolean isActive, String roles, Pageable pageable);



}
