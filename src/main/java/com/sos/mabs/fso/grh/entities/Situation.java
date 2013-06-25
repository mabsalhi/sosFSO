/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.mabs.fso.grh.entities;

import java.io.Serializable;
import java.util.Date;
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
    @JoinColumn(name = "id_cadre", referencedColumnName = "id_cadre")
    @ManyToOne(optional = false)
    private Cadre cadre;
    @JoinColumn(name = "id_personne", referencedColumnName = "id_personne")
    @ManyToOne(optional = false)
    private Personne personne;

    public Situation() {
    }

    public Situation(Integer idSituation) {
        this.idSituation = idSituation;
    }

    public Situation(Integer idSituation, int echelon, int numeroIndicatif, Date dateEffet) {
        this.idSituation = idSituation;
        this.echelon = echelon;
        this.numeroIndicatif = numeroIndicatif;
        this.dateEffet = dateEffet;
    }

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

    public Cadre getCadre() {
        return cadre;
    }

    public void setCadre(Cadre cadre) {
        this.cadre = cadre;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSituation != null ? idSituation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Situation)) {
            return false;
        }
        Situation other = (Situation) object;
        if ((this.idSituation == null && other.idSituation != null) || (this.idSituation != null && !this.idSituation.equals(other.idSituation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sos.mabs.fso.grh.entities.Situation[ idSituation=" + idSituation + " ]";
    }
    
}
