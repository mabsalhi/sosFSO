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
@Table(name = "t_affectation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Affectation.findAll", query = "SELECT a FROM Affectation a"),
    @NamedQuery(name = "Affectation.findByIdAffectation", query = "SELECT a FROM Affectation a WHERE a.idAffectation = :idAffectation"),
    @NamedQuery(name = "Affectation.findByDateAffectation", query = "SELECT a FROM Affectation a WHERE a.dateAffectation = :dateAffectation"),
    @NamedQuery(name = "Affectation.findByPoste", query = "SELECT a FROM Affectation a WHERE a.poste = :poste"),
    @NamedQuery(name = "Affectation.findByDateDetachement", query = "SELECT a FROM Affectation a WHERE a.dateDetachement = :dateDetachement"),
    @NamedQuery(name = "Affectation.findByRemarques", query = "SELECT a FROM Affectation a WHERE a.remarques = :remarques")})
public class Affectation implements Serializable {
    
    // ======================================
    // = Attributes =
    // ======================================
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_affectation")
    private Integer idAffectation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_affectation")
    @Temporal(TemporalType.DATE)
    private Date dateAffectation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "poste")
    private String poste;
    @Column(name = "date_detachement")
    @Temporal(TemporalType.DATE)
    private Date dateDetachement;
    @Size(max = 255)
    @Column(name = "remarques")
    private String remarques;
    @JoinColumn(name = "id_personne", referencedColumnName = "id_personne")
    @ManyToOne(optional = false)
    private Personne personne;
    @JoinColumn(name = "id_service", referencedColumnName = "id_service")
    @ManyToOne(optional = false)
    private Service service;

    // ======================================
    // = Constructors =
    // ======================================
    public Affectation() {
    }

    public Affectation(Date dateAffectation, String poste, Personne personne, Service service) {
        this.dateAffectation = dateAffectation;
        this.poste = poste;
        this.personne = personne;
        this.service = service;
    }
    
    // ======================================
    // = Getters & setters =
    // ======================================
    public Integer getIdAffectation() {
        return idAffectation;
    }

    public void setIdAffectation(Integer idAffectation) {
        this.idAffectation = idAffectation;
    }

    public Date getDateAffectation() {
        return dateAffectation;
    }

    public void setDateAffectation(Date dateAffectation) {
        this.dateAffectation = dateAffectation;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public Date getDateDetachement() {
        return dateDetachement;
    }

    public void setDateDetachement(Date dateDetachement) {
        this.dateDetachement = dateDetachement;
    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
    
     // ======================================
    // = Methods hash, equals, toString =
    // ======================================
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.idAffectation);
        hash = 67 * hash + Objects.hashCode(this.dateAffectation);
        hash = 67 * hash + Objects.hashCode(this.poste);
        hash = 67 * hash + Objects.hashCode(this.dateDetachement);
        hash = 67 * hash + Objects.hashCode(this.remarques);
        hash = 67 * hash + Objects.hashCode(this.personne);
        hash = 67 * hash + Objects.hashCode(this.service);
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
        final Affectation other = (Affectation) obj;
        if (!Objects.equals(this.idAffectation, other.idAffectation)) {
            return false;
        }
        if (!Objects.equals(this.dateAffectation, other.dateAffectation)) {
            return false;
        }
        if (!Objects.equals(this.poste, other.poste)) {
            return false;
        }
        if (!Objects.equals(this.dateDetachement, other.dateDetachement)) {
            return false;
        }
        if (!Objects.equals(this.remarques, other.remarques)) {
            return false;
        }
        if (!Objects.equals(this.personne, other.personne)) {
            return false;
        }
        if (!Objects.equals(this.service, other.service)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Affectation{" + "dateAffectation=" + dateAffectation + ", poste=" + poste + '}';
    }
    
    
    
}
