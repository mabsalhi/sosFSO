/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.mabs.fso.grh.jsfUtil;

import com.sos.mabs.fso.grh.ejb.CadreFacade;
import com.sos.mabs.fso.grh.ejb.PersonneFacade;
import com.sos.mabs.fso.grh.entities.Cadre;
import com.sos.mabs.fso.grh.jsf.PersonneController;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author mab.salhi
 */
@FacesConverter("com.sos.mabs.fso.grh.jsfUtil.CadreConverter")
public class CadreConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Integer id = Integer.valueOf(value);
        PersonneController controller = new PersonneController();
        Cadre cadre =  controller.getCadreFacade().find(id);
        return cadre;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Cadre cadre = (Cadre) value;
        String idAsString = String.valueOf(cadre.getIdCadre());
        return idAsString;
    }
    
}
