package com.example.omnicons.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Statut implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idstatut;
    private String valeur;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "statut")
    private List<Candidat> candidats;

    public Long getIdstatut() {
        return idstatut;
    }

    public void setIdstatut(Long idstatut) {
        this.idstatut = idstatut;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public List<Candidat> getCandidats() {
        return candidats;
    }

    public void setCandidats(List<Candidat> candidats) {
        this.candidats = candidats;
    }
}
