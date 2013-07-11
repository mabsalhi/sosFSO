/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.mabs.fso.grh.jsf;

import com.sos.mabs.fso.grh.ejb.PersonneFacade;
import com.sos.mabs.fso.grh.entities.Personne;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.inject.Named;
import org.eclipse.persistence.internal.libraries.asm.tree.TryCatchBlockNode;

/**
 *
 * @author mab.salhi
 */
@Named(value = "personneController")
@SessionScoped
public class PersonneController implements Serializable{

    @Inject
    private PersonneFacade ejbFacade;
    private Personne current = null;
    private List<Personne> personnes = null;
    private Personne nouveau = new Personne();
    
    public PersonneController() {
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
