/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.mabs.fso.grh.jsfUtil;

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
        if (value == null || value.length() == 0) {
            return null;
        }
        Integer id = new Integer(value);
        PersonneFacade controller = (PersonneFacade) context.getApplication()
                .getELResolver().getValue(context.getELContext(), null, "cadre");
        return controller.find(id);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null){
            return null;
        }
        if(value instanceof Cadre){
            Cadre o = (Cadre) value;
            return o.getIdCadre() == null ? "" : o.getIdCadre().toString();
        }else{
            throw new IllegalArgumentException("object" + value + "is of type" + value.getClass().getName() + "; expected type : Cadre");
        }
    }
    
}
