package com.project.doctolib.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;


@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Professionnel extends User {


    @Column(name = "id")
    private int id;
    @Column(name = "id_specialite")
    private int idSpecialite;

    @Column(name = "is_visible")
    private boolean isVisible;
    @NotNull
    private String adresse;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getIdSpecialite() {
        return idSpecialite;
    }

    public void setIdSpecialite(int idSpecialite) {
        this.idSpecialite = idSpecialite;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public Professionnel() {
    }


}
