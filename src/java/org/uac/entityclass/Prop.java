/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uac.entityclass;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Teja
 */
@Entity
@Table(name = "PROP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prop.findAll", query = "SELECT p FROM Prop p")
    , @NamedQuery(name = "Prop.findByPropid", query = "SELECT p FROM Prop p WHERE p.propid = :propid")
    , @NamedQuery(name = "Prop.findByPropname", query = "SELECT p FROM Prop p WHERE p.propname = :propname")
    , @NamedQuery(name = "Prop.findByPropvalue", query = "SELECT p FROM Prop p WHERE p.propvalue = :propvalue")
    , @NamedQuery(name = "Prop.findByEdname", query = "SELECT p FROM Prop p WHERE p.edname = :edname")})
public class Prop implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "PROPID")
    private String propid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "PROPNAME")
    private String propname;
    @Size(max = 55)
    @Column(name = "PROPVALUE")
    private String propvalue;
    @Size(max = 50)
    @Column(name = "EDNAME")
    private String edname;

    public Prop() {
    }

    public Prop(String propid) {
        this.propid = propid;
    }

    public Prop(String propid, String propname) {
        this.propid = propid;
        this.propname = propname;
    }

    public String getPropid() {
        return propid;
    }

    public void setPropid(String propid) {
        this.propid = propid;
    }

    public String getPropname() {
        return propname;
    }

    public void setPropname(String propname) {
        this.propname = propname;
    }

    public String getPropvalue() {
        return propvalue;
    }

    public void setPropvalue(String propvalue) {
        this.propvalue = propvalue;
    }

    public String getEdname() {
        return edname;
    }

    public void setEdname(String edname) {
        this.edname = edname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (propid != null ? propid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prop)) {
            return false;
        }
        Prop other = (Prop) object;
        if ((this.propid == null && other.propid != null) || (this.propid != null && !this.propid.equals(other.propid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.uac.entityclass.Prop[ propid=" + propid + " ]";
    }
    
}
