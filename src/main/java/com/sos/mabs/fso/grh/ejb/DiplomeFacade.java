/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.mabs.fso.grh.ejb;

import com.sos.mabs.fso.grh.entities.Diplome;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mab.salhi
 */
@Stateless
public class DiplomeFacade extends AbstractFacade<Diplome>{

    // ======================================
    // = Attributes =
    // ======================================
    @PersistenceContext(unitName = "grhPU")
    private EntityManager em;
    
    
    // ======================================
    // = Methods =
    // ======================================
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiplomeFacade() {
        super(Diplome.class);
    }
    
    
}
