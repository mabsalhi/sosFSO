/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.mabs.fso.grh.ejb;

import com.sos.mabs.fso.grh.entities.Cadre;
import com.sos.mabs.fso.grh.entities.Personne;
import com.sos.mabs.fso.grh.entities.Situation;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mab.salhi
 */
@Stateless
public class PersonneFacade extends AbstractFacade<Personne> {

    @PersistenceContext(unitName = "grhPU")
    private EntityManager em;

    public PersonneFacade() {
        super(Personne.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public Personne addSituation(Personne personne, Cadre cadre, Date dateEffet, Integer echelon, Integer numeroIndicatif, String remarques, Float salaireEstimatif){
        personne = em.merge(personne);
        Situation situation = new Situation(cadre, dateEffet, echelon, numeroIndicatif, remarques, salaireEstimatif);
        personne.addSituation(situation);
        return personne;
    }
    
    public Personne removeSituation(Personne personne, Situation situation){
        personne = em.merge(personne);
        personne.remove(situation);
        return personne;
    }
    
}
