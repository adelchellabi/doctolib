package com.project.doctolib.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Size(min = 3, max = 20,message = "Le prenom doit entre 3 et 20 caracters")
    @NotBlank(message = "Le prenom ne doit pas etre  vide")
    @NotNull(message = "Le prenom ne doit pas etre null")
    @Column(name = "prenom")
    private String firstName;

    @Size(min = 3, max = 20,message = "Le nom doit entre 3 et 20 caracters")
    @NotBlank(message = "Le nom ne doit pas etre  vide")
    @NotNull(message ="Le nom ne doit pas etre null" )
    @Column(name = "nom")
    private String lastName;


    @Column(unique = true)
    @Size(min = 3,max = 20 ,message = "Username doit entre 3 et 20 caracters.")
    @NotNull(message = "Username ne doit pas etre  null.")
    @NotBlank(message = "Username ne doit pas etre  vide")
    private String username;

    @NotBlank(message = "Email ne doit pas etre  vide")
    @Email(message = "Entrer une adresse email valide.")
    @NotNull(message = "Email ne doit pas etre  null.")
    private String email;

    private String tel;


    @Size(min = 6,max = 20 ,message = "mot de passe doit entre 6 et 20 caracters.")
    @NotNull(message = "mot de passe  ne doit pas etre  null.")
    @NotBlank(message = "mot de passe ne doit pas etre  vide")
    private String password;

    private boolean active;

    private String roles;

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                ", roles='" + roles + '\'' +
                '}';
    }
}
