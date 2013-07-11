package com.sos.mabs.fso.grh.jsf;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sos.mabs.fso.grh.ejb.CadreFacade;
import com.sos.mabs.fso.grh.entities.Cadre;
import com.sun.org.apache.xpath.internal.axes.ContextNodeList;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;

/**
 *
 * @author mab.salhi
 */

@Named(value = "cadreController")
@SessionScoped
public class CadreController implements Serializable {

    @Inject
    private CadreFacade ejbFacade;
    private Cadre current = null;
    private List<Cadre> cadres = null;
    private Cadre nouveau = new Cadre();

    public Cadre getNouveau() {
        return nouveau;
    }

    public void setNouveau(Cadre nouveau) {
        this.nouveau = nouveau;
    }

    public CadreController() {
    }
    
    public List<Cadre> getAll(){
        cadres = ejbFacade.findAll();
        return cadres;
    }

    public Cadre getCurrent() {
        return current;
    }

    public void setCurrent(Cadre current) {
        this.current = current;
    }
    
    public String showDetails(Cadre item){
        this.current = item;
        return "detail?faces-redirect=true";
    }
    
    public String doCreate(){
        ejbFacade.create(nouveau);
        return "list?faces-redirect=true";
    }
    
    public String showList(){
        this.getAll();
        return "list?faces-redirect=true";
    }

    public String doUpdate(){
        try {
            current = ejbFacade.update(current);
            FacesContext context = FacesContext.getCurrentInstance();
            Flash flash = context.getExternalContext().getFlash();
            flash.setKeepMessages(true);
        addMessage("update", FacesMessage.SEVERITY_INFO, "La mise a jour de l'enregistrement : " + this.current.getIntitule() + " a ete effectuer", "Succes !!");
        return "list?faces-redirect=true";
            
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            Flash flash = context.getExternalContext().getFlash();
            flash.setKeepMessages(true);
            addMessage("error", FacesMessage.SEVERITY_FATAL, "Une autre personne a modifier l'enregistrement : " + this.current.getIntitule() + ", veuillez revenir sur la liste, revoir les donnees et reassayer ", "Fail !!");
            
        return "detail?faces-redirect=true";
        }
        
    }
    
    
    
    private void addMessage(String key, FacesMessage.Severity severity, String message, String detail) {
        FacesMessage msg = new FacesMessage(severity, message, detail);
        FacesContext.getCurrentInstance().addMessage(key, msg);
    }
    
}
