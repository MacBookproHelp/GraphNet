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
    public boolean verifyLogin(String n, String p) {
        Query q = em.createQuery("select u from Uacuser u where u.username=:n and u.password=:p");
        q.setParameter("n", n);
        q.setParameter("p", p);
        
        return q.getResultList().size()>0;
        
    }

    @Override
    public String getuserType(String n) {
        Query q = em.createQuery("select u.usertype from Uacuser u where u.username=:n");
        q.setParameter("n", n);
        return q.getResultList().toString();
    }

    @Override
    public Boolean verifyFb(String n, String m) {
        try{
          Query q = em.createQuery("select u from Uacuser u where u.username=:n and u.email=:m");
            q.setParameter("n", n);
             q.setParameter("m", m);
        
            return q.getResultList().size()>0;  
        }catch(Exception e){
            return false;
        }
        
       
    }
    
    
    @Override
    public Boolean registerUser(String e, String n, String t) {
        Query q = em.createNativeQuery("INSERT INTO UACUSER(EMAIL,"
                + "USERNAME,USERTYPE) values(?,?,?)");
        
        q.setParameter(1, e);
        q.setParameter(2, n);
        q.setParameter(3, t);
        int val = q.executeUpdate();
        if(val==1){
            return true;
        }else{
            return false;
        }
           
            
        
    }
    
    
    
    
    
}
