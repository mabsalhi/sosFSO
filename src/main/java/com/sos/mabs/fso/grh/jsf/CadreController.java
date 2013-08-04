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
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author mab.salhi
 */
@Named(value = "cadreController")
@SessionScoped
public class CadreController implements Serializable {

     // ======================================
    // = Attributes =
    // ======================================
    
    @Inject
    private CadreFacade ejbFacade;
    
    private Cadre current = null;
    private List<Cadre> cadres = null;
    private Cadre nouveau = new Cadre();
    
    /**
     * Creates a new instance of CadreController
     */
    public CadreController() {
    }

    
    
    
     // ======================================
    // = Public Methods =
    // ======================================
    public List<Cadre> getAll() {
        return ejbFacade.findAll();
    }
    
     public String showDetails(Cadre item){
        this.current = item;
        return "edit?faces-redirect=true";
    }
    
    public String doCreate(){
        ejbFacade.create(nouveau);
        this.nouveau = null;
        return "list?faces-redirect=true";
    }
    
    public String showList(){
        this.getAll();
        return "list?faces-redirect=true";
    }

    public String showCreate(){
        this.nouveau = new Cadre();
        return "create?faces-redirect=true";
    }

    public Cadre getCadre(java.lang.Integer id) {
        return ejbFacade.find(id);
    }
    
    public String doUpdate(){
        try {
            current = ejbFacade.edit(current);
            
        addMessage("update", FacesMessage.SEVERITY_INFO, "La mise a jour de l'enregistrement : " + this.current.getIntitule()+ " a ete effectuer", "Succes !!");
        return "list?faces-redirect=true";
            
        } catch (Exception e) {
            
            addMessage("error", FacesMessage.SEVERITY_FATAL, "Une autre personne a modifier l'enregistrement : " + this.current.getIntitule()+ ", veuillez revenir sur la liste, revoir les donnees et reassayer ", "Fail !!");
            
        return "edit?faces-redirect=true";
        }
    
    }
    
    private void addMessage(String key, FacesMessage.Severity severity, String message, String detail) {
        FacesContext context = FacesContext.getCurrentInstance();
        Flash flash = context.getExternalContext().getFlash();
        flash.setKeepMessages(true);
        FacesMessage msg = new FacesMessage(severity, message, detail);
        FacesContext.getCurrentInstance().addMessage(key, msg);
    }
    // ======================================
    // = Getters & setters =
    // ======================================
    public CadreFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(CadreFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public Cadre getCurrent() {
        return current;
    }

    public void setCurrent(Cadre current) {
        this.current = current;
    }

    public Cadre getNouveau() {
        return nouveau;
    }

    public void setNouveau(Cadre nouveau) {
        this.nouveau = nouveau;
    }

   
    
    @FacesConverter(forClass = Cadre.class)
    public static class CadreControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CadreController controller = (CadreController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cadreController");
            return controller.getCadre(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Cadre) {
                Cadre o = (Cadre) object;
                return getStringKey(o.getIdCadre());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Cadre.class.getName());
            }
        }
    
}
}
