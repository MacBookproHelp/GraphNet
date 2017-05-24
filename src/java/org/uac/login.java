/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uac;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Keerthana
 */
public class login {
    
    private String username;
    private String password;
    private String useremail;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    public int verify() throws ClassNotFoundException, SQLException{
        int a=0;
        
        String url = "jdbc:derby://localhost:1527/sample;user=app;password=app";
        String query = "SELECT * FROM UACUSER WHERE username=? AND password=?";
       
        Connection con = DriverManager.getConnection(url);
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,username);
        ps.setString(2,password);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
            a=1;             
        else
            a=0;      
        
        return a;
    }     
    
    
    /**
     * @return the useremail
     */
    public String getUseremail() {
        return useremail;
    }

    /**
     * @param useremail the useremail to set
     */
    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }
    
       
    
    public int faceverify() throws ClassNotFoundException, SQLException{
        int a=0;
        Class.forName("org.apache.derby.jdbc.ClientDriver");        
        String url = "jdbc:derby://localhost:1527/sample;user=app;password=app";
        String query = "SELECT * FROM UACUSER WHERE username=? AND email=?";
       
        Connection con = DriverManager.getConnection(url);
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,username);
        ps.setString(2,useremail);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            a=1;
        }                        
        else{
           String fquery = "INSERT INTO UACUSER (username,email) VALUES (?,?)"; 
           PreparedStatement fps = con.prepareStatement(fquery);
           fps.setString(1,username);
           fps.setString(2,useremail);
           a = fps.executeUpdate();
        }       
        return a;
    }    

}