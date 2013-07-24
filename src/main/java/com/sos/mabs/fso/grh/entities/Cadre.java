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
@Table(name = "t_cadre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cadre.findAll", query = "SELECT c FROM Cadre c"),
    @NamedQuery(name = "Cadre.findByIdCadre", query = "SELECT c FROM Cadre c WHERE c.idCadre = :idCadre"),
    @NamedQuery(name = "Cadre.findByIntitule", query = "SELECT c FROM Cadre c WHERE c.intitule = :intitule"),
    @NamedQuery(name = "Cadre.findByDescription", query = "SELECT c FROM Cadre c WHERE c.description = :description")})
public class Cadre implements Serializable {
    
    // ======================================
    // = Attributes =
    // ======================================
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cadre")
    private Integer idCadre;
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
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cadre")
    private List<Fonction> fonctions;
    
     // ======================================
    // = Constructors =
    // ======================================
    public Cadre() {
    }

    public Cadre(String intitule, String description, List<Fonction> fonctions) {
        this.intitule = intitule;
        this.description = description;
        this.fonctions = fonctions;
    }
    
    
    
    // ======================================
    // = Getters & setters =
    // ======================================
    public Integer getIdCadre() {
        return idCadre;
    }

    public void setIdCadre(Integer idCadre) {
        this.idCadre = idCadre;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Fonction> getFonctions() {
        return fonctions;
    }

    public void setFonctions(List<Fonction> fonctions) {
        this.fonctions = fonctions;
    }
    
    
    
    // ======================================
    // = Methods hash, equals, toString =
    // ======================================
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.idCadre);
        hash = 89 * hash + this.version;
        hash = 89 * hash + Objects.hashCode(this.intitule);
        hash = 89 * hash + Objects.hashCode(this.intituleAr);
        hash = 89 * hash + Objects.hashCode(this.description);
        hash = 89 * hash + Objects.hashCode(this.fonctions);
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
        final Cadre other = (Cadre) obj;
        if (!Objects.equals(this.idCadre, other.idCadre)) {
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
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.fonctions, other.fonctions)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cadre{" + "intitule=" + intitule + '}';
    }

    
    
   
    
}
