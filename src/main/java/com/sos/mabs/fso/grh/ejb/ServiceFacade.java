/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.mabs.fso.grh.ejb;

import com.sos.mabs.fso.grh.entities.Service;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mab.salhi
 */
@Stateless
public class ServiceFacade extends AbstractFacade<Service>{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext(unitName = "grhPU")
    private EntityManager em;

    
    
    public ServiceFacade() {
        super(Service.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    

}
