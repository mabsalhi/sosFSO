/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.mabs.fso.grh.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mab.salhi
 */
@Entity
@Table(name = "t_personne")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personne.findAll", query = "SELECT p FROM Personne p"),
    @NamedQuery(name = "Personne.findByIdPersonne", query = "SELECT p FROM Personne p WHERE p.idPersonne = :idPersonne"),
    @NamedQuery(name = "Personne.findByNom", query = "SELECT p FROM Personne p WHERE p.nom = :nom"),
    @NamedQuery(name = "Personne.findByPrenom", query = "SELECT p FROM Personne p WHERE p.prenom = :prenom"),
    @NamedQuery(name = "Personne.findByNomAr", query = "SELECT p FROM Personne p WHERE p.nomAr = :nomAr"),
    @NamedQuery(name = "Personne.findByPrenomAr", query = "SELECT p FROM Personne p WHERE p.prenomAr = :prenomAr"),
    @NamedQuery(name = "Personne.findByCin", query = "SELECT p FROM Personne p WHERE p.cin = :cin"),
    @NamedQuery(name = "Personne.findByDateNaissance", query = "SELECT p FROM Personne p WHERE p.dateNaissance = :dateNaissance"),
    @NamedQuery(name = "Personne.findByLieuNaissance", query = "SELECT p FROM Personne p WHERE p.lieuNaissance = :lieuNaissance"),
    @NamedQuery(name = "Personne.findByEtatMatrimonial", query = "SELECT p FROM Personne p WHERE p.etatMatrimonial = :etatMatrimonial"),
    @NamedQuery(name = "Personne.findByNbEnfants", query = "SELECT p FROM Personne p WHERE p.nbEnfants = :nbEnfants"),
    @NamedQuery(name = "Personne.findByAdresse", query = "SELECT p FROM Personne p WHERE p.adresse = :adresse"),
    @NamedQuery(name = "Personne.findByTelephonne", query = "SELECT p FROM Personne p WHERE p.telephonne = :telephonne"),
    @NamedQuery(name = "Personne.findByDateRecrutement", query = "SELECT p FROM Personne p WHERE p.dateRecrutement = :dateRecrutement"),
    @NamedQuery(name = "Personne.findBySom", query = "SELECT p FROM Personne p WHERE p.som = :som"),
    @NamedQuery(name = "Personne.findByPosteBudgetaire", query = "SELECT p FROM Personne p WHERE p.posteBudgetaire = :posteBudgetaire")})
public class Personne implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_personne")
    private Integer idPersonne;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @Size(max = 45)
    @Column(name = "prenom")
    private String prenom;
    @Size(max = 45)
    @Column(name = "nom_ar")
    private String nomAr;
    @Size(max = 45)
    @Column(name = "prenom_ar")
    private String prenomAr;
    @Size(max = 45)
    @Column(name = "cin")
    private String cin;
    @Column(name = "date_naissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Size(max = 45)
    @Column(name = "lieu_naissance")
    private String lieuNaissance;
    @Size(max = 45)
    @Column(name = "etat_matrimonial")
    private String etatMatrimonial;
    @Column(name = "nb_enfants")
    private Integer nbEnfants;
    @Size(max = 255)
    @Column(name = "adresse")
    private String adresse;
    @Size(max = 45)
    @Column(name = "telephonne")
    private String telephonne;
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    @Column(name = "date_recrutement")
    @Temporal(TemporalType.DATE)
    private Date dateRecrutement;
    @Column(name = "som")
    private Integer som;
    @Column(name = "poste_budgetaire")
    private Integer posteBudgetaire;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personne")
    private List<Qualification> qualifications;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personne")
    private List<Affectation> affectations;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personne")
    private List<Situation> situations;

    public Personne() {
    }

    public Personne(Integer idPersonne) {
        this.idPersonne = idPersonne;
    }

    public Integer getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Integer idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNomAr() {
        return nomAr;
    }

    public void setNomAr(String nomAr) {
        this.nomAr = nomAr;
    }

    public String getPrenomAr() {
        return prenomAr;
    }

    public void setPrenomAr(String prenomAr) {
        this.prenomAr = prenomAr;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getEtatMatrimonial() {
        return etatMatrimonial;
    }

    public void setEtatMatrimonial(String etatMatrimonial) {
        this.etatMatrimonial = etatMatrimonial;
    }

    public Integer getNbEnfants() {
        return nbEnfants;
    }

    public void setNbEnfants(Integer nbEnfants) {
        this.nbEnfants = nbEnfants;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephonne() {
        return telephonne;
    }

    public void setTelephonne(String telephonne) {
        this.telephonne = telephonne;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Date getDateRecrutement() {
        return dateRecrutement;
    }

    public void setDateRecrutement(Date dateRecrutement) {
        this.dateRecrutement = dateRecrutement;
    }

    public Integer getSom() {
        return som;
    }

    public void setSom(Integer som) {
        this.som = som;
    }

    public Integer getPosteBudgetaire() {
        return posteBudgetaire;
    }

    public void setPosteBudgetaire(Integer posteBudgetaire) {
        this.posteBudgetaire = posteBudgetaire;
    }

    @XmlTransient
    public List<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    @XmlTransient
    public List<Affectation> getAffectations() {
        return affectations;
    }

    public void setAffectations(List<Affectation> affectations) {
        this.affectations = affectations;
    }

    @XmlTransient
    public List<Situation> getSituations() {
        return situations;
    }

    public void setSituations(List<Situation> situations) {
        this.situations = situations;
    }

    public boolean addQualification(Qualification qualification){
        if(qualifications == null){
            qualifications = new LinkedList<>();
        }
        if(qualification != null && !qualifications.contains(qualification)){
            qualifications.add(qualification);
            qualification.setPersonne(this);
            return true;
        }        
        return false;
    }
    
    public boolean removeQualification(Qualification qualification){
        if(qualifications != null && !qualifications.isEmpty()){
            return qualifications.remove(qualification);
        }else{
            return false;
        }
    }
    
    public boolean addSituation(Situation situation){
        if(situations == null){
            situations = new LinkedList<>();
        }
        if(situation != null && !situations.contains(situation)){
            situations.add(situation);
            situation.setPersonne(this);
            return true;
        }
        return false;
    }
    
    public boolean removeSituation(Situation situation){
        if(situations != null && !situations.isEmpty()){
            return situations.remove(situation);
        }else{
            return false;
        }
    }
    
    public boolean addAffectation(Affectation affectation){
        if(affectations == null){
            affectations = new LinkedList<>();
        }
        if(affectation != null && !affectations.contains(affectation)){
            affectations.add(affectation);
            affectation.setPersonne(this);
            return true;
        }
        return false;
    }
    
    public boolean removeAffectation(Affectation affectation){
        if(affectations != null && !affectations.isEmpty()){
            return affectations.remove(affectation);
        }else{
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonne != null ? idPersonne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personne)) {
            return false;
        }
        Personne other = (Personne) object;
        if ((this.idPersonne == null && other.idPersonne != null) || (this.idPersonne != null && !this.idPersonne.equals(other.idPersonne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sos.mabs.fso.grh.entities.Personne[ idPersonne=" + idPersonne + " ]";
    }
    
}
