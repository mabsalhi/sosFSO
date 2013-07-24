/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.mabs.fso.grh.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
import javax.validation.constraints.NotNull;
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
    
    // ======================================
    // = Attributes =
    // ======================================
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_personne")
    private Integer idPersonne;
    @Basic(optional = false)
    @NotNull
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(max = 45)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Size(max = 45)
    @Column(name = "nom_ar")
    private String nomAr;
    @Basic(optional = false)
    @NotNull
    @Size(max = 45)
    @Column(name = "prenom_ar")
    private String prenomAr;
    @Basic(optional = false)
    @NotNull
    @Size(max = 45)
    @Column(name = "cin")
    private String cin;
    @Basic(optional = false)
    @NotNull
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_recrutement")
    @Temporal(TemporalType.DATE)
    private Date dateRecrutement;
    @Basic(optional = false)
    @NotNull
    @Column(name = "som")
    private Integer som;
    @Basic(optional = false)
    @NotNull
    @Column(name = "poste_budgetaire")
    private Integer posteBudgetaire;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personne")
    private List<Qualification> qualifications;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personne")
    private List<Affectation> affectations;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personne")
    private List<Situation> situations;

    // ======================================
    // = Constructors =
    // ======================================
    public Personne() {
    }

    public Personne(String nom, String prenom, String nomAr, String prenomAr, String cin, Date dateNaissance, Date dateRecrutement, Integer som, Integer posteBudgetaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.nomAr = nomAr;
        this.prenomAr = prenomAr;
        this.cin = cin;
        this.dateNaissance = dateNaissance;
        this.dateRecrutement = dateRecrutement;
        this.som = som;
        this.posteBudgetaire = posteBudgetaire;
    }
    
    // ======================================
    // = Getters & setters =
    // ======================================
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

    public List<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    public List<Affectation> getAffectations() {
        return affectations;
    }

    public void setAffectations(List<Affectation> affectations) {
        this.affectations = affectations;
    }

    public List<Situation> getSituations() {
        return situations;
    }

    public void setSituations(List<Situation> situations) {
        this.situations = situations;
    }
    
    // ======================================
    // = Methods hash, equals, toString =
    // ======================================
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.idPersonne);
        hash = 97 * hash + Objects.hashCode(this.nom);
        hash = 97 * hash + Objects.hashCode(this.prenom);
        hash = 97 * hash + Objects.hashCode(this.nomAr);
        hash = 97 * hash + Objects.hashCode(this.prenomAr);
        hash = 97 * hash + Objects.hashCode(this.cin);
        hash = 97 * hash + Objects.hashCode(this.dateNaissance);
        hash = 97 * hash + Objects.hashCode(this.lieuNaissance);
        hash = 97 * hash + Objects.hashCode(this.etatMatrimonial);
        hash = 97 * hash + Objects.hashCode(this.nbEnfants);
        hash = 97 * hash + Objects.hashCode(this.adresse);
        hash = 97 * hash + Objects.hashCode(this.telephonne);
        hash = 97 * hash + Arrays.hashCode(this.photo);
        hash = 97 * hash + Objects.hashCode(this.dateRecrutement);
        hash = 97 * hash + Objects.hashCode(this.som);
        hash = 97 * hash + Objects.hashCode(this.posteBudgetaire);
        hash = 97 * hash + Objects.hashCode(this.qualifications);
        hash = 97 * hash + Objects.hashCode(this.affectations);
        hash = 97 * hash + Objects.hashCode(this.situations);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Personne other = (Personne) obj;
        if (!Objects.equals(this.idPersonne, other.idPersonne)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.nomAr, other.nomAr)) {
            return false;
        }
        if (!Objects.equals(this.prenomAr, other.prenomAr)) {
            return false;
        }
        if (!Objects.equals(this.cin, other.cin)) {
            return false;
        }
        if (!Objects.equals(this.dateNaissance, other.dateNaissance)) {
            return false;
        }
        if (!Objects.equals(this.lieuNaissance, other.lieuNaissance)) {
            return false;
        }
        if (!Objects.equals(this.etatMatrimonial, other.etatMatrimonial)) {
            return false;
        }
        if (!Objects.equals(this.nbEnfants, other.nbEnfants)) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        if (!Objects.equals(this.telephonne, other.telephonne)) {
            return false;
        }
        if (!Arrays.equals(this.photo, other.photo)) {
            return false;
        }
        if (!Objects.equals(this.dateRecrutement, other.dateRecrutement)) {
            return false;
        }
        if (!Objects.equals(this.som, other.som)) {
            return false;
        }
        if (!Objects.equals(this.posteBudgetaire, other.posteBudgetaire)) {
            return false;
        }
        if (!Objects.equals(this.qualifications, other.qualifications)) {
            return false;
        }
        if (!Objects.equals(this.affectations, other.affectations)) {
            return false;
        }
        if (!Objects.equals(this.situations, other.situations)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Personne{" + "nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + ", som=" + som + '}';
    }
    
    
}
