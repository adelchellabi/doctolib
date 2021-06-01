package com.project.doctolib.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Experiance {
    @Id
    private int id;
    @NotNull
    @Size(min = 1)
    private String description;
    @Column(name = "id_professionnel")
    private int idProfessionnel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdProfessionnel() {
        return idProfessionnel;
    }

    public void setIdProfessionnel(int idProfessionnel) {
        this.idProfessionnel = idProfessionnel;
    }
}
