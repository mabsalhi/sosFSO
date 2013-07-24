/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.mabs.fso.grh.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mab.salhi
 */
@Entity
@Table(name = "t_situation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Situation.findAll", query = "SELECT s FROM Situation s"),
    @NamedQuery(name = "Situation.findByIdSituation", query = "SELECT s FROM Situation s WHERE s.idSituation = :idSituation"),
    @NamedQuery(name = "Situation.findByEchelon", query = "SELECT s FROM Situation s WHERE s.echelon = :echelon"),
    @NamedQuery(name = "Situation.findByNumeroIndicatif", query = "SELECT s FROM Situation s WHERE s.numeroIndicatif = :numeroIndicatif"),
    @NamedQuery(name = "Situation.findByDateEffet", query = "SELECT s FROM Situation s WHERE s.dateEffet = :dateEffet"),
    @NamedQuery(name = "Situation.findBySalaireEstimatif", query = "SELECT s FROM Situation s WHERE s.salaireEstimatif = :salaireEstimatif"),
    @NamedQuery(name = "Situation.findByRemarques", query = "SELECT s FROM Situation s WHERE s.remarques = :remarques")})
public class Situation implements Serializable {
    // ======================================
    // = Attributes =
    // ======================================
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_situation")
    private Integer idSituation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "echelon")
    private int echelon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_indicatif")
    private int numeroIndicatif;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_effet")
    @Temporal(TemporalType.DATE)
    private Date dateEffet;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salaire_estimatif")
    private Float salaireEstimatif;
    @Size(max = 255)
    @Column(name = "remarques")
    private String remarques;
    @JoinColumn(name = "id_fonction", referencedColumnName = "id_fonction")
    @ManyToOne(optional = false)
    private Fonction fonction;
    @JoinColumn(name = "id_personne", referencedColumnName = "id_personne")
    @ManyToOne(optional = false)
    private Personne personne;

    // ======================================
    // = Constructors =
    // ======================================
    public Situation() {
    }

    public Situation(int echelon, Date dateEffet) {
        this.echelon = echelon;
        this.dateEffet = dateEffet;
    }

    // ======================================
    // = Getters & setters =
    // ======================================
    public Integer getIdSituation() {
        return idSituation;
    }

    public void setIdSituation(Integer idSituation) {
        this.idSituation = idSituation;
    }

    public int getEchelon() {
        return echelon;
    }

    public void setEchelon(int echelon) {
        this.echelon = echelon;
    }

    public int getNumeroIndicatif() {
        return numeroIndicatif;
    }

    public void setNumeroIndicatif(int numeroIndicatif) {
        this.numeroIndicatif = numeroIndicatif;
    }

    public Date getDateEffet() {
        return dateEffet;
    }

    public void setDateEffet(Date dateEffet) {
        this.dateEffet = dateEffet;
    }

    public Float getSalaireEstimatif() {
        return salaireEstimatif;
    }

    public void setSalaireEstimatif(Float salaireEstimatif) {
        this.salaireEstimatif = salaireEstimatif;
    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }

    public Fonction getFonction() {
        return fonction;
    }

    public void setFonction(Fonction fonction) {
        this.fonction = fonction;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    // ======================================
    // = Methods hash, equals, toString =
    // ======================================
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.idSituation);
        hash = 31 * hash + this.echelon;
        hash = 31 * hash + this.numeroIndicatif;
        hash = 31 * hash + Objects.hashCode(this.dateEffet);
        hash = 31 * hash + Objects.hashCode(this.salaireEstimatif);
        hash = 31 * hash + Objects.hashCode(this.remarques);
        hash = 31 * hash + Objects.hashCode(this.fonction);
        hash = 31 * hash + Objects.hashCode(this.personne);
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
        final Situation other = (Situation) obj;
        if (!Objects.equals(this.idSituation, other.idSituation)) {
            return false;
        }
        if (this.echelon != other.echelon) {
            return false;
        }
        if (this.numeroIndicatif != other.numeroIndicatif) {
            return false;
        }
        if (!Objects.equals(this.dateEffet, other.dateEffet)) {
            return false;
        }
        if (!Objects.equals(this.salaireEstimatif, other.salaireEstimatif)) {
            return false;
        }
        if (!Objects.equals(this.remarques, other.remarques)) {
            return false;
        }
        if (!Objects.equals(this.fonction, other.fonction)) {
            return false;
        }
        if (!Objects.equals(this.personne, other.personne)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Situation{" + "echelon=" + echelon + ", dateEffet=" + dateEffet + '}';
    }
    
    
}
