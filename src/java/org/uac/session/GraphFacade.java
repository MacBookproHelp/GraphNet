/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uac.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.uac.entityclass.Graph;


@Stateless
public class GraphFacade extends AbstractFacade<Graph> implements GraphFacadeLocal {

    @PersistenceContext(unitName = "ProjectAntwerpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GraphFacade() {
        super(Graph.class);
    }

    @Override
    public Boolean addGraph(String gn, String gd, String go, String ge, String gs, String gw, String gu) {
        
        try{
            Query q = em.createNativeQuery("INSERT INTO GRAPH (GRAPHNAME,DESCRIPTION,TOTALNODES,TOTALEDGES,GSIZE,WEIGHTED,USRNAME)"
                + "values(?,?,?,?,?,?,?)");
        q.setParameter(1, gn);
        q.setParameter(2, gd);
        q.setParameter(3, go);
        q.setParameter(4, ge);
        q.setParameter(5, gs);
        q.setParameter(6, gw);
        q.setParameter(7, gu);
        int val = q.executeUpdate();
        if(val==1){
            return true;
        }else{
            return false;
        }
        }catch(Exception e){
            System.out.println("the exception in bean is "+e);
            return false;
        }
        
    }

    @Override
    public List<Graph> getUsergraphs(String gu) {
        Query q = em.createNamedQuery("select g from graph g where g.usrname=:gu");
        q.setParameter("gu", gu);
        return q.getResultList();
    }
    
    
    
    
}
