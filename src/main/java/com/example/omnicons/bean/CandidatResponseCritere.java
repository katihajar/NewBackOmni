package com.example.omnicons.bean;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class CandidatResponseCritere implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idcandidatResponseCritere;
    private String response;
    @ManyToOne
    private Critere critere;
    @ManyToOne
    private Candidat candidat;
    @ManyToOne
    private Campagne campagne;

    public Long getIdcandidatResponseCritere() {
        return idcandidatResponseCritere;
    }

    public Campagne getCampagne() {
        return campagne;
    }

    public void setCampagne(Campagne campagne) {
        this.campagne = campagne;
    }

    public void setIdcandidatResponseCritere(Long idcandidatResponseCritere) {
        this.idcandidatResponseCritere = idcandidatResponseCritere;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Critere getCritere() {
        return critere;
    }

    public void setCritere(Critere critere) {
        this.critere = critere;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }
}
