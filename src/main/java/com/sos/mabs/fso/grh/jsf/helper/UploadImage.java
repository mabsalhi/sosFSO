/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.mabs.fso.grh.jsf.helper;

import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.sql.DataSource;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author abdel
 */
@Named(value = "uploadImage")
@SessionScoped
public class UploadImage implements Serializable {

     @Resource(name="jta/mysql_grh")
	private DataSource ds;
    
    /**
     * Creates a new instance of UploadImage
     */
    public UploadImage() {
    }
    
    private static final long serialVersionUID = 1L;
    private UploadedFile file;
 
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
 
    public void upload() {
        System.out.println("sssss");
        if (file != null) {
            try {
                System.out.println(file.getFileName());
                InputStream fin2 = file.getInputstream();
                Connection con = ds.getConnection();
                PreparedStatement pre = con.prepareStatement("insert into t_image (image_name,image) values(?,?)");
                pre.setString(1, file.getFileName().toString());
                pre.setBinaryStream(2, fin2, file.getSize());
                pre.executeUpdate();
                System.out.println("Inserting Successfully!");
                pre.close();
                FacesMessage msg = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
                FacesContext.getCurrentInstance().addMessage(null, msg);
 
            } catch (Exception e) {
                System.out.println("Exception-File Upload." + e.getMessage());
            }
        }
        else{
        FacesMessage msg = new FacesMessage("Please select image!!");
                FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
