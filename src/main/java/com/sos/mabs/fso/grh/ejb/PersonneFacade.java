/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.mabs.fso.grh.ejb;

import com.sos.mabs.fso.grh.entities.Cadre;
import com.sos.mabs.fso.grh.entities.Personne;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mab.salhi
 */
@Stateless
public class PersonneFacade extends AbstractFacade<Personne>{

     @PersistenceContext(unitName = "grhPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonneFacade(){
        super(Personne.class);
    }

}
