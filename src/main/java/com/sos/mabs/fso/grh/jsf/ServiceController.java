/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.mabs.fso.grh.jsf;

import com.sos.mabs.fso.grh.ejb.ServiceFacade;
import com.sos.mabs.fso.grh.entities.Service;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;

/**
 *
 * @author mab.salhi
 */
@Named(value = "serviceController")
@SessionScoped
public class ServiceController implements Serializable {

    // ======================================
    // = Attributes =
    // ======================================
    
    @Inject
    private ServiceFacade ejbFacade;
    
    private Service current = null;
    private List<Service> services = null;
    private Service nouveau = new Service();
    
    /**
     * Creates a new instance of ServiceController
     */
    public ServiceController() {
    }
    
    // ======================================
    // = Public Methods =
    // ======================================
    public List<Service> getAll() {
        return ejbFacade.findAll();
    }
    
     public String showDetails(Service item){
        this.current = item;
        return "edit?faces-redirect=true";
    }
    
    public String doCreate(){
        ejbFacade.create(nouveau);
        this.nouveau = null;
        return "list?faces-redirect=true";
    }
    
    public String showList(){
        this.getAll();
        return "list?faces-redirect=true";
    }

    public Service getService(java.lang.Integer id) {
        return ejbFacade.find(id);
    }
    
    public String doUpdate(){
        try {
            current = ejbFacade.edit(current);
            
        addMessage("update", FacesMessage.SEVERITY_INFO, "La mise a jour de l'enregistrement : " + this.current.getIntitule()+ " a ete effectuer", "Succes !!");
        return "list?faces-redirect=true";
            
        } catch (Exception e) {
            
            addMessage("error", FacesMessage.SEVERITY_FATAL, "Une autre personne a modifier l'enregistrement : " + this.current.getIntitule()+ ", veuillez revenir sur la liste, revoir les donnees et reassayer ", "Fail !!");
            
        return "edit?faces-redirect=true";
        }
    
    }
    
    private void addMessage(String key, FacesMessage.Severity severity, String message, String detail) {
        FacesContext context = FacesContext.getCurrentInstance();
        Flash flash = context.getExternalContext().getFlash();
        flash.setKeepMessages(true);
        FacesMessage msg = new FacesMessage(severity, message, detail);
        FacesContext.getCurrentInstance().addMessage(key, msg);
    }

    // ======================================
    // = Getters & setters =
    // ======================================
    public Service getCurrent() {
        return current;
    }

    public void setCurrent(Service current) {
        this.current = current;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public Service getNouveau() {
        return nouveau;
    }

    public void setNouveau(Service nouveau) {
        this.nouveau = nouveau;
    }
    
    
}
