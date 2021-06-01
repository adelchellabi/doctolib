package com.project.doctolib.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Year;
import java.util.Date;

@Entity
public class Formation {
    @Id
    private int id;
    @NotNull
    @Size(min = 1)
    private String titre;
    @NotNull

    private int annee;
    @Column(name = "id_professionnel")
    private int idProfessionnel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getIdProfessionnel() {
        return idProfessionnel;
    }

    public void setIdProfessionnel(int idProfessionnel) {
        this.idProfessionnel = idProfessionnel;
    }
}
