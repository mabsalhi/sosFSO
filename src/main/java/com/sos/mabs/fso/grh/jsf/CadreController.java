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
import javax.inject.Inject;

/**
 *
 * @author mab.salhi
 */
@Named(value = "cadreController")
@SessionScoped
public class CadreController implements Serializable {

    private Cadre current;
    @Inject
    private CadreFacade ejbFacade;
    
    /**
     * Creates a new instance of CadreController
     */
    public CadreController() {
    }
    
    public List<Cadre> getCadres() {
        return ejbFacade.findAll();
    }
    
}
