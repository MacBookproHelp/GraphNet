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
import org.uac.entityclass.Uacuser;

@Stateless
public class UacuserFacade extends AbstractFacade<Uacuser> implements UacuserFacadeLocal {

    @PersistenceContext(unitName = "ProjectAntwerpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UacuserFacade() {
        super(Uacuser.class);
    }

    @Override
    public boolean verifyLogin(String u, String p) {
        Query q = em.createQuery("SELECT u FROM UACUSER u "
                + "WHERE u.username=:u AND u.password=:p");
        q.setParameter("u", u);
        q.setParameter("p", p);
        
        return q.getResultList().size()>0;
        
    }
    
    
}
