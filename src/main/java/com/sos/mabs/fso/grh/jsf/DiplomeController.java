/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.mabs.fso.grh.jsf;

import com.sos.mabs.fso.grh.ejb.DiplomeFacade;
import com.sos.mabs.fso.grh.entities.Diplome;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author infoFSO5
 */
@Named(value = "diplomeController")
@SessionScoped
public class DiplomeController implements Serializable{

    private static final Logger logger = Logger.getLogger(DiplomeController.class.getName());
    
    @Inject
    private DiplomeFacade ejbFacade;
    private Diplome current = null;
    private List<Diplome> diplomes = null;
    private Diplome nouveau = new Diplome();
    
    
    /**
     * Creates a new instance of DiplomeController
     */
    public DiplomeController() {
    }

    public Diplome getCurrent() {
        return current;
    }

    public void setCurrent(Diplome current) {
        this.current = current;
    }

    public List<Diplome> getAll() {
        diplomes = ejbFacade.findAll();
        return diplomes;
    }


    public Diplome getNouveau() {
        return nouveau;
    }

    public void setNouveau(Diplome nouveau) {
        this.nouveau = nouveau;
    }
    
    public String showDetails(Diplome item){
        this.current = item;
        return "detail?faces-redirect=true";
    }
    
    public String doCreate(){
        try {
            ejbFacade.create(nouveau);
            logger.log(Level.INFO, "Success d'ajout du diplome " + nouveau.getIntitule() + " !!!");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erreur lors de la tentative d'ajout du diplome !!!");
        }
        return showList();
    }
    
    public String showList(){
        this.getAll();
        this.nouveau = null;
        return "list?faces-redirect=true";
    }
    
    public String showCreate(){
        this.nouveau = new Diplome();
        return "create?faces-redirect=true";
    }

}
