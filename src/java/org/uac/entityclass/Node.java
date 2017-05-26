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
@Table(name = "NODE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Node.findAll", query = "SELECT n FROM Node n")
    , @NamedQuery(name = "Node.findByNodeid", query = "SELECT n FROM Node n WHERE n.nodeid = :nodeid")
    , @NamedQuery(name = "Node.findByGpname", query = "SELECT n FROM Node n WHERE n.gpname = :gpname")})
public class Node implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NODEID")
    private String nodeid;
    @Size(max = 50)
    @Column(name = "GPNAME")
    private String gpname;

    public Node() {
    }

    public Node(String nodeid) {
        this.nodeid = nodeid;
    }

    public String getNodeid() {
        return nodeid;
    }

    public void setNodeid(String nodeid) {
        this.nodeid = nodeid;
    }

    public String getGpname() {
        return gpname;
    }

    public void setGpname(String gpname) {
        this.gpname = gpname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nodeid != null ? nodeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Node)) {
            return false;
        }
        Node other = (Node) object;
        if ((this.nodeid == null && other.nodeid != null) || (this.nodeid != null && !this.nodeid.equals(other.nodeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.uac.entityclass.Node[ nodeid=" + nodeid + " ]";
    }
    
}
