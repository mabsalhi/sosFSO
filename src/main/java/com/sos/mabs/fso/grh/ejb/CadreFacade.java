/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.mabs.fso.grh.ejb;

import com.sos.mabs.fso.grh.entities.Cadre;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mab.salhi
 */
@Stateless
public class CadreFacade extends AbstractFacade<Cadre>{

    @PersistenceContext(unitName = "grhPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CadreFacade(){
        super(Cadre.class);
    }

}
