package com.example.omnicons.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Entity
public class Candidat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idcandidat;
    private String nomCandidat;
    private String prenomCandidat;
    private String emailCandidat;
    private String telephone;
    private String cv;
    private boolean reussiSelectionAuto;
    private String commentaire1;
    private String commentaire2;
    private String commentaire3;
    private String commentaire4;
    private int Score;
    private String IsCreatedBy;
    @ManyToOne
    private Campagne campagne;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "candidat")
    private List<CandidatResponseCritere> candidatResponseCriteres;
   /* @ManyToOne
    private Statut statut;*/

    public Long getIdcandidat() {
        return idcandidat;
    }

    public void setIdcandidat(Long idcandidat) {
        this.idcandidat = idcandidat;
    }

    public String getNomCandidat() {
        return nomCandidat;
    }

    public void setNomCandidat(String nomCandidat) {
        this.nomCandidat = nomCandidat;
    }

    public String getPrenomCandidat() {
        return prenomCandidat;
    }

    public void setPrenomCandidat(String prenomCandidat) {
        this.prenomCandidat = prenomCandidat;
    }

    public String getEmailCandidat() {
        return emailCandidat;
    }

    public void setEmailCandidat(String emailCandidat) {
        this.emailCandidat = emailCandidat;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public boolean getReussiSelectionAuto() {
        return reussiSelectionAuto;
    }

    public void setReussiSelectionAuto(boolean reussiSelectionAuto) {
        this.reussiSelectionAuto = reussiSelectionAuto;
    }

    public String getCommentaire1() {
        return commentaire1;
    }

    public void setCommentaire1(String commentaire1) {
        this.commentaire1 = commentaire1;
    }

    public String getCommentaire2() {
        return commentaire2;
    }

    public void setCommentaire2(String commentaire2) {
        this.commentaire2 = commentaire2;
    }

    public String getCommentaire3() {
        return commentaire3;
    }

    public void setCommentaire3(String commentaire3) {
        this.commentaire3 = commentaire3;
    }

    public String getCommentaire4() {
        return commentaire4;
    }

    public void setCommentaire4(String commentaire4) {
        this.commentaire4 = commentaire4;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public String getIsCreatedBy() {
        return IsCreatedBy;
    }

    public void setIsCreatedBy(String isCreatedBy) {
        IsCreatedBy = isCreatedBy;
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

    /*public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }*/
}
