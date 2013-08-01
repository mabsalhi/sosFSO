/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.mabs.fso.grh.jsf;

import com.sos.mabs.fso.grh.ejb.CadreFacade;
import com.sos.mabs.fso.grh.ejb.PersonneFacade;
import com.sos.mabs.fso.grh.entities.Fonction;
import com.sos.mabs.fso.grh.entities.Personne;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;


/**
 *
 * @author abdel
 */
@Named(value = "personneController")
@SessionScoped
public class PersonneController implements Serializable {

    // ======================================
    // = Attributes =
    // ======================================
    private static final Logger logger = Logger.getLogger(PersonneController.class.getName());
    
    
    @Inject
    private PersonneFacade ejbFacade;
    @Inject
    private CadreFacade cadreFacade;
    
    private Personne current = null;
    private List<Personne> personnes = null;
    private Personne nouveau = new Personne();
    
    private Fonction selectedFonction = new Fonction();
    private List<Fonction> fonctions;
    
    private Date dateEffet;
    private int echelon;
    private Float salaireEstimatif;
    private int numeroIndicatif;
    private String remarques;
    
    
    // ======================================
    // = Constructor =
    // ======================================
    /**
     * Creates a new instance of PersonneController
     */
    public PersonneController() {
    }
    
    // ======================================
    // = Public Methods =
    // ======================================
    
    public List<Personne> getAll() {
        return ejbFacade.findAll();
    }
    
    public String showList(){
        this.getAll();
        return "list?faces-redirect=true";
    }
    
    public String showCreate(){
        this.nouveau = new Personne();
        return "create?faces-redirect=true";
    }
    
    public String showDetails(Personne item){
        this.current = item;
        return "view?faces-redirect=true";
    }
    
    
    public String doCreate(){
        logger.log(Level.INFO, "Debut de la procedure d'ajout !!");
        try {
            ejbFacade.create(nouveau);
            addMessage("update", FacesMessage.SEVERITY_INFO, "Nouvel Enregistrement ajouter avec succes", "Succes !!");
            this.nouveau = null;
        return "list?faces-redirect=true";
        
        } catch (Exception e) {
            addMessage("update", FacesMessage.SEVERITY_INFO, "Erreur lors de la tentative d'ajout", "Error !!");
            this.nouveau = null;
        return "list?faces-redirect=true";
        }
        
    }
    public String doUpdate(){
        try {
            current = ejbFacade.edit(current);
            
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

    // ======================================
    // = Getters & setters =
    // ======================================
    public Personne getCurrent() {
        return current;
    }

    public void setCurrent(Personne current) {
        this.current = current;
    }

    public Personne getNouveau() {
        return nouveau;
    }

    public void setNouveau(Personne nouveau) {
        this.nouveau = nouveau;
    }
     
}
