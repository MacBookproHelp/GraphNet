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
import org.uac.entityclass.Node;

/**
 *
 * @author Teja
 */
@Stateless
public class NodeFacade extends AbstractFacade<Node> implements NodeFacadeLocal {

    @PersistenceContext(unitName = "ProjectAntwerpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NodeFacade() {
        super(Node.class);
    }

    @Override
    public Boolean delNode(String gn) {
         Query q = em.createNativeQuery("DELETE FROM NODE WHERE GPNAME=?");
        q.setParameter(1,gn);
        int i = q.executeUpdate();
        if(i==1){
            return true;
        }else{
            return false;
        }
        
    }
    
}
