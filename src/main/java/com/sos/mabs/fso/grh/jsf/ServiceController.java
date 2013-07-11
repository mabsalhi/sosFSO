/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.mabs.fso.grh.jsf;

import com.sos.mabs.fso.grh.ejb.ServiceFacade;
import com.sos.mabs.fso.grh.entities.Service;
import java.io.Serializable;
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
@Named
@SessionScoped
public class ServiceController implements Serializable{

    /**
     * Creates a new instance of ServiceController
     */
    @Inject
    private ServiceFacade ejbFacade;
    private Service current = null;
    private Service nouveau = new Service();
    private List<Service> services = null;
    
    
    public ServiceController() {
    }

    public Service getCurrent() {
        return current;
    }

    public void setCurrent(Service current) {
        this.current = current;
    }

    public Service getNouveau() {
        return nouveau;
    }

    public void setNouveau(Service nouveau) {
        this.nouveau = nouveau;
    }
    
    public List<Service> getServices(){
        return ejbFacade.findAll();
    }
    
    public String showDetails(Service item){
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
            
        addMessage("update", FacesMessage.SEVERITY_INFO, "La mise a jour de l'enregistrement : " + this.current.getIntitule()+ " a ete effectuer", "Succes !!");
        return "list?faces-redirect=true";
            
        } catch (Exception e) {
            
            addMessage("error", FacesMessage.SEVERITY_FATAL, "Une autre personne a modifier l'enregistrement : " + this.current.getIntitule() + ", veuillez revenir sur la liste, revoir les donnees et reassayer ", "Fail !!");
            
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
