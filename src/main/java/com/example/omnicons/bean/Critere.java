package com.example.omnicons.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Critere implements Serializable {
    @Id
    @GeneratedValue
    private Long idcritere;
    private String nomCritere;
    private String valPositive;
    private String valNegative;
    private boolean actif;
    private int poids;
    @ManyToOne
    private Campagne campagne;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "critere")
    private List<CandidatResponseCritere> candidatResponseCriteres;

    public Long getIdcritere() {
        return idcritere;
    }

    public void setIdcritere(Long idcritere) {
        this.idcritere = idcritere;
    }

    public String getNomCritere() {
        return nomCritere;
    }

    public void setNomCritere(String nomCritere) {
        this.nomCritere = nomCritere;
    }

    public String getValPositive() {
        return valPositive;
    }

    public void setValPositive(String valPositive) {
        this.valPositive = valPositive;
    }

    public String getValNegative() {
        return valNegative;
    }

    public void setValNegative(String valNegative) {
        this.valNegative = valNegative;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public Campagne getCampagne() {
        return campagne;
    }

    public void setCampagne(Campagne campagne) {
        this.campagne = campagne;
    }

    public List<CandidatResponseCritere> getCandidatResponseCriteres() {
        return candidatResponseCriteres;
    }

    public void setCandidatResponseCriteres(List<CandidatResponseCritere> candidatResponseCriteres) {
        this.candidatResponseCriteres = candidatResponseCriteres;
    }
}
