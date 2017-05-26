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
@Table(name = "EDGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Edge.findAll", query = "SELECT e FROM Edge e")
    , @NamedQuery(name = "Edge.findByEdgeid", query = "SELECT e FROM Edge e WHERE e.edgeid = :edgeid")
    , @NamedQuery(name = "Edge.findByLeftnode", query = "SELECT e FROM Edge e WHERE e.leftnode = :leftnode")
    , @NamedQuery(name = "Edge.findByRightnode", query = "SELECT e FROM Edge e WHERE e.rightnode = :rightnode")
    , @NamedQuery(name = "Edge.findByGrname", query = "SELECT e FROM Edge e WHERE e.grname = :grname")})
public class Edge implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EDGEID")
    private String edgeid;
    @Size(max = 50)
    @Column(name = "LEFTNODE")
    private String leftnode;
    @Size(max = 50)
    @Column(name = "RIGHTNODE")
    private String rightnode;
    @Size(max = 50)
    @Column(name = "GRNAME")
    private String grname;

    public Edge() {
    }

    public Edge(String edgeid) {
        this.edgeid = edgeid;
    }

    public String getEdgeid() {
        return edgeid;
    }

    public void setEdgeid(String edgeid) {
        this.edgeid = edgeid;
    }

    public String getLeftnode() {
        return leftnode;
    }

    public void setLeftnode(String leftnode) {
        this.leftnode = leftnode;
    }

    public String getRightnode() {
        return rightnode;
    }

    public void setRightnode(String rightnode) {
        this.rightnode = rightnode;
    }

    public String getGrname() {
        return grname;
    }

    public void setGrname(String grname) {
        this.grname = grname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (edgeid != null ? edgeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Edge)) {
            return false;
        }
        Edge other = (Edge) object;
        if ((this.edgeid == null && other.edgeid != null) || (this.edgeid != null && !this.edgeid.equals(other.edgeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.uac.entityclass.Edge[ edgeid=" + edgeid + " ]";
    }
    
}
