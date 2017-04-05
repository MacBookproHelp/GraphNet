/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uac;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Keerthana
 */
public class register {
    
    private String regusername;
    private String regemail;
    private String regpassword;    
    

    /**
     * @return the regusername
     */
    public String getRegusername() {
        return regusername;
    }

    /**
     * @param regusername the regusername to set
     */
    public void setRegusername(String regusername) {
        this.regusername = regusername;
    }

    /**
     * @return the regemail
     */
    public String getRegemail() {
        return regemail;
    }

    /**
     * @param regemail the regemail to set
     */
    public void setRegemail(String regemail) {
        this.regemail = regemail;
    }

    /**
     * @return the regpassword
     */
    public String getRegpassword() {
        return regpassword;
    }

    /**
     * @param regpassword the regpassword to set
     */
    public void setRegpassword(String regpassword) {
        this.regpassword = regpassword;
    } 
    
    
    
    public int registerUser() throws ClassNotFoundException, SQLException{
        int a=0;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        
        String url = "jdbc:derby://localhost:1527/sample;user=app;password=app";
        String query = "INSERT INTO UACUSER (username,password,email) VALUES (?,?,?)";
       
        Connection con = DriverManager.getConnection(url);
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,regusername);
        ps.setString(2,regpassword);
        ps.setString(3,regemail);
        a = ps.executeUpdate();
        if(a==1)
            return a;             
        else
            a=0;           
            return a;
    }     
    
}
