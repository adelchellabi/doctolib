package com.project.doctolib.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Table
@Entity  @IdClass(LangueId.class)
public class Langue_professionnel  {
@Id
    private int id_langue;
@Id
    private int id_professionnel;

    public Langue_professionnel() {
    }

    public Langue_professionnel(int i, int s) {
        this.id_langue=s;
        this.id_professionnel=i;
    }

    public int getId_langue() {
        return id_langue;
    }

    public void setId_langue(int id_langue) {
        this.id_langue = id_langue;
    }

    public int getId_professionnel() {
        return id_professionnel;
    }

    public void setId_professionnel(int id_professionnel) {
        this.id_professionnel = id_professionnel;
    }
}
