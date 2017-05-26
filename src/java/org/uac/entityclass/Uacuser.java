/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uac.entityclass;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "UACUSER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uacuser.findAll", query = "SELECT u FROM Uacuser u")
    , @NamedQuery(name = "Uacuser.findByUsername", query = "SELECT u FROM Uacuser u WHERE u.username = :username")
    , @NamedQuery(name = "Uacuser.findByPassword", query = "SELECT u FROM Uacuser u WHERE u.password = :password")
    , @NamedQuery(name = "Uacuser.findByFirstname", query = "SELECT u FROM Uacuser u WHERE u.firstname = :firstname")
    , @NamedQuery(name = "Uacuser.findByLastname", query = "SELECT u FROM Uacuser u WHERE u.lastname = :lastname")
    , @NamedQuery(name = "Uacuser.findByUsertype", query = "SELECT u FROM Uacuser u WHERE u.usertype = :usertype")
    , @NamedQuery(name = "Uacuser.findByEmail", query = "SELECT u FROM Uacuser u WHERE u.email = :email")})
public class Uacuser implements Serializable {

    

    @OneToMany(mappedBy = "username")

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 55)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 55)
    @Column(name = "LASTNAME")
    private String lastname;
    @Size(max = 55)
    @Column(name = "USERTYPE")
    private String usertype;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;

    public Uacuser() {
    }

    public Uacuser(String username) {
        this.username = username;
    }

    public Uacuser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uacuser)) {
            return false;
        }
        Uacuser other = (Uacuser) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.uac.entityclass.Uacuser[ username=" + username + " ]";
    }
    

}
