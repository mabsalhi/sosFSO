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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mab.salhi
 */
@Entity
@Table(name = "t_diplome")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diplome.findAll", query = "SELECT d FROM Diplome d"),
    @NamedQuery(name = "Diplome.findByIdDiplome", query = "SELECT d FROM Diplome d WHERE d.idDiplome = :idDiplome"),
    @NamedQuery(name = "Diplome.findByIntitule", query = "SELECT d FROM Diplome d WHERE d.intitule = :intitule"),
    @NamedQuery(name = "Diplome.findByType", query = "SELECT d FROM Diplome d WHERE d.type = :type"),
    @NamedQuery(name = "Diplome.findByDescription", query = "SELECT d FROM Diplome d WHERE d.description = :description")})
public class Diplome implements Serializable {
    
    // ======================================
    // = Attributes =
    // ======================================
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_diplome")
    private Integer idDiplome;
     @Version
    @Column(name = "optimistic_Lock_version")
    private int version;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "intitule")
    private String intitule;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "intitule_ar")
    private String intituleAr;
    @Size(max = 45)
    @Column(name = "type")
    private String type;
    @Size(max = 45)
    @Column(name = "type_ar")
    private String typeAr;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diplome")
    private List<Qualification> qualifications;

    // ======================================
    // = Constructors =
    // ======================================
    public Diplome() {
    }

    public Diplome(String intitule, String type, String description) {
        this.intitule = intitule;
        this.type = type;
        this.description = description;
    }
    
    
    // ======================================
    // = Getters & setters =
    // ======================================
    public Integer getIdDiplome() {
        return idDiplome;
    }

    public void setIdDiplome(Integer idDiplome) {
        this.idDiplome = idDiplome;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeAr() {
        return typeAr;
    }

    public void setTypeAr(String typeAr) {
        this.typeAr = typeAr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    // ======================================
    // = Methods hash, equals, toString =
    // ======================================
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.idDiplome);
        hash = 29 * hash + this.version;
        hash = 29 * hash + Objects.hashCode(this.intitule);
        hash = 29 * hash + Objects.hashCode(this.intituleAr);
        hash = 29 * hash + Objects.hashCode(this.type);
        hash = 29 * hash + Objects.hashCode(this.typeAr);
        hash = 29 * hash + Objects.hashCode(this.description);
        hash = 29 * hash + Objects.hashCode(this.qualifications);
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
        final Diplome other = (Diplome) obj;
        if (!Objects.equals(this.idDiplome, other.idDiplome)) {
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
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.typeAr, other.typeAr)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.qualifications, other.qualifications)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Diplome{" + "intitule=" + intitule + ", type=" + type + '}';
    }
    
    
}
