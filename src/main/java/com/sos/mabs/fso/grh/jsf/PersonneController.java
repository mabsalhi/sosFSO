/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.mabs.fso.grh.jsf;

import com.sos.mabs.fso.grh.ejb.CadreFacade;
import com.sos.mabs.fso.grh.ejb.PersonneFacade;
import com.sos.mabs.fso.grh.entities.Cadre;
import com.sos.mabs.fso.grh.entities.Personne;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author mab.salhi
 */
@Named(value = "personneController")
@SessionScoped
public class PersonneController implements Serializable{

    @Inject
    private PersonneFacade ejbFacade;
    @Inject
    private CadreFacade cadreFacade;
    
    private Personne current = null;
    private List<Personne> personnes = null;
    private Personne nouveau = new Personne();
    
    private Cadre selectedCadre = null;
    private List<Cadre> cadres;
    
    private Date dateEffet;
    private int echelon;
    private Float salaireEstimatif;
    private int numeroIndicatif;
    private String remarques;
    
    
    public PersonneController() {
    }

    public void add(){
        Personne updatedPersonne = ejbFacade.addSituation(current, selectedCadre, dateEffet, echelon, numeroIndicatif, remarques, salaireEstimatif);
        System.out.println("le cadre selectionnee est :" + selectedCadre);
        current = updatedPersonne;
        showDetails(current);        
    }
    
    public String addSituationForm(){
        return "addSituation?faces-redirect=true";
    }
    
    
    public Personne getCurrent() {
        return current;
    }

    public void setCurrent(Personne current) {
        this.current = current;
    }

    public List<Personne> getPersonnes() {
        return ejbFacade.findAll();
    }

    public List<Cadre> getCadres(){
        return cadreFacade.findAll();
    }
    
    public PersonneFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(PersonneFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public CadreFacade getCadreFacade() {
        return cadreFacade;
    }

    public void setCadreFacade(CadreFacade cadreFacade) {
        this.cadreFacade = cadreFacade;
    }

    
    
    public Date getDateEffet() {
        return dateEffet;
    }

    public void setDateEffet(Date dateEffet) {
        this.dateEffet = dateEffet;
    }

    public int getEchelon() {
        return echelon;
    }

    public void setEchelon(int echelon) {
        this.echelon = echelon;
    }

    public Float getSalaireEstimatif() {
        return salaireEstimatif;
    }

    public void setSalaireEstimatif(Float salaireEstimatif) {
        this.salaireEstimatif = salaireEstimatif;
    }

    public int getNumeroIndicatif() {
        return numeroIndicatif;
    }

    public void setNumeroIndicatif(int numeroIndicatif) {
        this.numeroIndicatif = numeroIndicatif;
    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }

    public Cadre getSelectedCadre() {
        return selectedCadre;
    }

    public void setSelectedCadre(Cadre selectedCadre) {
        this.selectedCadre = selectedCadre;
    }

    

    public Personne getNouveau() {
        return nouveau;
    }

    public void setNouveau(Personne nouveau) {
        this.nouveau = nouveau;
    }
    
    public String showDetails(Personne item){
        this.current = item;
        return "detail?faces-redirect=true";
    }
    
    public String doCreate(){
        try {
            ejbFacade.create(nouveau);
            addMessage("update", FacesMessage.SEVERITY_INFO, "Nouvel Enregistrement ajouter avec succes", "Succes !!");
            this.nouveau = null;
        return "list?faces-redirect=true";
        
        } catch (Exception e) {
            addMessage("update", FacesMessage.SEVERITY_INFO, "Erreur lors de la tentative d'ajout", "Succes !!");
            this.nouveau = null;
        return "list?faces-redirect=true";
        }
        
    }
    
    public String doUpdate(){
        try {
            current = ejbFacade.update(current);
            
        addMessage("update", FacesMessage.SEVERITY_INFO, "La mise a jour de l'enregistrement : " + this.current.getSom() + " a ete effectuer", "Succes !!");
        return "list?faces-redirect=true";
            
        } catch (Exception e) {
            
            addMessage("error", FacesMessage.SEVERITY_FATAL, "Une autre personne a modifier l'enregistrement : " + this.current.getSom() + ", veuillez revenir sur la liste, revoir les donnees et reassayer ", "Fail !!");
            
        return "detail?faces-redirect=true";
        }
    
    }
    
    private void addMessage(String key, FacesMessage.Severity severity, String message, String detail) {
        FacesContext context = FacesContext.getCurrentInstance();
        Flash flash = context.getExternalContext().getFlash();
        flash.setKeepMessages(true);
        FacesMessage msg = new FacesMessage(severity, message, detail);
        FacesContext.getCurrentInstance().addMessage(key, msg);
    }
}
