package com.sos.mabs.fso.grh.jsf;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sos.mabs.fso.grh.ejb.CadreFacade;
import com.sos.mabs.fso.grh.entities.Cadre;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.model.DataModel;
import javax.inject.Inject;

/**
 *
 * @author mab.salhi
 */

@Named(value = "cadreController")
@SessionScoped
public class CadreController implements Serializable {

    private Cadre current = new Cadre();
    @Inject
    private CadreFacade ejbFacade;
    private List<Cadre> cadresList;
    private DataModel<Cadre> cadres;
    
    /**
     * Creates a new instance of CadreController
     */
    public CadreController() {
    }

       
    public String create(){
        getEjbFacade().create(current);
        return "list";
    }
    
    public String update(){
        
        return "list";
    }
    
    public List<Cadre> getCadres() {
        return ejbFacade.findAll();
    }

    public Cadre getCurrent() {
        return current;
    }

    public void setCurrent(Cadre current) {
        this.current = current;
    }

    public CadreFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(CadreFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }
    
    
    
}
