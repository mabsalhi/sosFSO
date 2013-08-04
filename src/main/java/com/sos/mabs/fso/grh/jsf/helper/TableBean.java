/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.mabs.fso.grh.jsf.helper;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.sql.DataSource;

@Named(value = "tableBean")
@SessionScoped
 
public class TableBean implements Serializable{
     @Resource(name="jta/mysql_grh")
	private DataSource ds;
    
    private String imageID;
    private String imageName;
 
    public String getImageName() {
        return imageName;
    }
 
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
 
    public String getImageLength() {
        return imageLength;
    }
 
    public void setImageLength(String imageLength) {
        this.imageLength = imageLength;
    }
    private String imageLength;
 
    public String getImageID() {
        return imageID;
    }
 
    public void setImageID(String imageID) {
        this.imageID = imageID;
    }
    Connection MySQLcon = null;
    Statement stmt = null;
    PreparedStatement ps;
    ResultSet rs;
 
    public List<TableBean> getAllImage() {
        List<TableBean> imageInfo = new ArrayList<TableBean>();
        Connection con = null;
         try {
             con = ds.getConnection();
         } catch (SQLException ex) {
             Logger.getLogger(TableBean.class.getName()).log(Level.SEVERE, null, ex);
         }
        try {
            stmt = con.createStatement();
            String strSql = "select image_id,Image_name from t_image order by image_id ";
            //System.err.println("*select all***" + strSql);
            rs = stmt.executeQuery(strSql);
            while (rs.next()) {
                TableBean tbl = new TableBean();
                tbl.setImageID(rs.getString("image_id"));
                tbl.setImageName(rs.getString("Image_name"));
                imageInfo.add(tbl);
            }
        } catch (SQLException e) {
            System.out.println("Exception in getAllImage::" + e.getMessage());
        }
        return imageInfo;
    }
}