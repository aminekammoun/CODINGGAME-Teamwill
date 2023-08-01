package com.yt.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="reponse_table")
public class Reponse {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idrep;

    public long getIdrep() {
        return idrep;
    }

    public void setIdrep(long idrep) {
        this.idrep = idrep;
    }






    private String reponse1;
    private String reponse2;


    public String getReponse1() {
        return reponse1;
    }

    public void setReponse1(String reponse1) {
        this.reponse1 = reponse1;
    }

    public String getReponse2() {
        return reponse2;
    }

    public void setReponse2(String reponse2) {
        this.reponse2 = reponse2;
    }

    public String getReponse3() {
        return reponse3;
    }

    public void setReponse3(String reponse3) {
        this.reponse3 = reponse3;
    }

    public String getReponsecorrecte() {
        return reponsecorrecte;
    }

    public void setReponsecorrecte(String reponsecorrecte) {
        this.reponsecorrecte = reponsecorrecte;
    }

    private String reponse3;
    private String reponsecorrecte;






}
