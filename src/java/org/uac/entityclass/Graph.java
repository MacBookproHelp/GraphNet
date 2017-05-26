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
@Table(name = "GRAPH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Graph.findAll", query = "SELECT g FROM Graph g")
    , @NamedQuery(name = "Graph.findByGraphname", query = "SELECT g FROM Graph g WHERE g.graphname = :graphname")
    , @NamedQuery(name = "Graph.findByDescription", query = "SELECT g FROM Graph g WHERE g.description = :description")
    , @NamedQuery(name = "Graph.findByTotalnodes", query = "SELECT g FROM Graph g WHERE g.totalnodes = :totalnodes")
    , @NamedQuery(name = "Graph.findByTotaledges", query = "SELECT g FROM Graph g WHERE g.totaledges = :totaledges")
    , @NamedQuery(name = "Graph.findByGsize", query = "SELECT g FROM Graph g WHERE g.gsize = :gsize")
    , @NamedQuery(name = "Graph.findByWeighted", query = "SELECT g FROM Graph g WHERE g.weighted = :weighted")
    , @NamedQuery(name = "Graph.findByUsrname", query = "SELECT g FROM Graph g WHERE g.usrname = :usrname")})
public class Graph implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "GRAPHNAME")
    private String graphname;
    @Size(max = 150)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 50)
    @Column(name = "TOTALNODES")
    private String totalnodes;
    @Size(max = 50)
    @Column(name = "TOTALEDGES")
    private String totaledges;
    @Size(max = 50)
    @Column(name = "GSIZE")
    private String gsize;
    @Size(max = 50)
    @Column(name = "WEIGHTED")
    private String weighted;
    @Size(max = 50)
    @Column(name = "USRNAME")
    private String usrname;

    public Graph() {
    }

    public Graph(String graphname) {
        this.graphname = graphname;
    }

    public String getGraphname() {
        return graphname;
    }

    public void setGraphname(String graphname) {
        this.graphname = graphname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTotalnodes() {
        return totalnodes;
    }

    public void setTotalnodes(String totalnodes) {
        this.totalnodes = totalnodes;
    }

    public String getTotaledges() {
        return totaledges;
    }

    public void setTotaledges(String totaledges) {
        this.totaledges = totaledges;
    }

    public String getGsize() {
        return gsize;
    }

    public void setGsize(String gsize) {
        this.gsize = gsize;
    }

    public String getWeighted() {
        return weighted;
    }

    public void setWeighted(String weighted) {
        this.weighted = weighted;
    }

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (graphname != null ? graphname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Graph)) {
            return false;
        }
        Graph other = (Graph) object;
        if ((this.graphname == null && other.graphname != null) || (this.graphname != null && !this.graphname.equals(other.graphname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.uac.entityclass.Graph[ graphname=" + graphname + " ]";
    }
    
}
