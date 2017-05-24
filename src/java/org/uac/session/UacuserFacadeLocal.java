/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uac.session;

import java.util.List;
import javax.ejb.Local;
import org.uac.entityclass.Uacuser;


@Local
public interface UacuserFacadeLocal {

    void create(Uacuser uacuser);

    void edit(Uacuser uacuser);

    void remove(Uacuser uacuser);

    Uacuser find(Object id);

    List<Uacuser> findAll();

    List<Uacuser> findRange(int[] range);

    int count();

    boolean verifyLogin(String u, String p);

    String getuserType(String u);

    Boolean verifyFb(String n, String m);

    Boolean registerUser(String e, String n, String t);
    
}
