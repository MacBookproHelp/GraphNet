/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uac.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.uac.entityclass.Edge;

/**
 *
 * @author Teja
 */
@Stateless
public class EdgeFacade extends AbstractFacade<Edge> implements EdgeFacadeLocal {

    @PersistenceContext(unitName = "ProjectAntwerpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EdgeFacade() {
        super(Edge.class);
    }

   
    @Override
    public void deleteEdge(String en) {
        Query q = em.createNativeQuery("DELETE FROM EDGE WHERE GRNAME=?");
        q.setParameter(1,en);
        q.executeUpdate();     
        
    }

    @Override
    public Boolean deleteNode(String n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean delEdge(String gn) {
        Query q = em.createNativeQuery("DELETE FROM EDGE WHERE GRNAME=?");
        q.setParameter(1,gn);
        int i = q.executeUpdate(); 
        if(i==1){
            return true;
        }else{
            return false;
        }
        
    }
    
}
