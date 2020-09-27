package com.project.doctolib.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name="id")
public class Professionnel extends User{

    private int specialite;

    @Column(name = "id")
    private int id;


    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getSpecialite() {
        return specialite;


    }

    public Professionnel() {
    }

    public void setSpecialite(int specialite) {
        this.specialite = specialite;
    }
}
