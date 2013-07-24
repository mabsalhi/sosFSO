/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.mabs.fso.grh.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mab.salhi
 */
@Entity
@Table(name = "t_fonction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fonction.findAll", query = "SELECT c FROM Fonction c"),
    @NamedQuery(name = "Fonction.findByIdFonction", query = "SELECT c FROM Fonction c WHERE c.idFonction = :idFonction"),
    @NamedQuery(name = "Fonction.findByIntitule", query = "SELECT c FROM Fonction c WHERE c.intitule = :intitule"),
    @NamedQuery(name = "Fonction.findByEchelle", query = "SELECT c FROM Fonction c WHERE c.echelle = :echelle"),
    @NamedQuery(name = "Fonction.findByDescription", query = "SELECT c FROM Fonction c WHERE c.description = :description")})

public class Fonction implements Serializable{
    // ======================================
    // = Attributes =
    // ======================================
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fonction")
    private Integer idFonction;
    @Version
    @Column(name = "optimistic_Lock_version")
    private int version;
    @NotNull
    @Size(max = 255)
    @Column(name = "intitule")
    private String intitule;
    @NotNull
    @Size(max = 255)
    @Column(name = "intitule_ar")
    private String intituleAr;
    @Column(name = "echelle")
    private Integer echelle;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fonction")
    private List<Situation> situations;
    @ManyToOne(optional = false)
    private Cadre cadre;

    // ======================================
    // = Constructors =
    // ======================================
    public Fonction() {
    }

    public Fonction(String intitule, Integer echelle, String description) {
        this.intitule = intitule;
        this.echelle = echelle;
        this.description = description;
    }
    
    // ======================================
    // = Getters & setters =
    // ======================================
    public Integer getIdFonction() {
        return idFonction;
    }

    public void setIdFonction(Integer idFonction) {
        this.idFonction = idFonction;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getIntituleAr() {
        return intituleAr;
    }

    public void setIntituleAr(String intituleAr) {
        this.intituleAr = intituleAr;
    }

    public Integer getEchelle() {
        return echelle;
    }

    public void setEchelle(Integer echelle) {
        this.echelle = echelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Situation> getSituations() {
        return situations;
    }

    public void setSituations(List<Situation> situations) {
        this.situations = situations;
    }

    public Cadre getCadre() {
        return cadre;
    }

    public void setCadre(Cadre cadre) {
        this.cadre = cadre;
    }
    
    
    // ======================================
    // = Methods hash, equals, toString =
    // ======================================
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.idFonction);
        hash = 37 * hash + this.version;
        hash = 37 * hash + Objects.hashCode(this.intitule);
        hash = 37 * hash + Objects.hashCode(this.intituleAr);
        hash = 37 * hash + Objects.hashCode(this.echelle);
        hash = 37 * hash + Objects.hashCode(this.description);
        hash = 37 * hash + Objects.hashCode(this.situations);
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
        final Fonction other = (Fonction) obj;
        if (!Objects.equals(this.idFonction, other.idFonction)) {
            return false;
        }
        if (this.version != other.version) {
            return false;
        }
        if (!Objects.equals(this.intitule, other.intitule)) {
            return false;
        }
        if (!Objects.equals(this.intituleAr, other.intituleAr)) {
            return false;
        }
        if (!Objects.equals(this.echelle, other.echelle)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.situations, other.situations)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fonction{" + "intitule=" + intitule + ", echelle=" + echelle + '}';
    }
    
    
}
