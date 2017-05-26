/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uac.session;

import java.util.List;
import javax.ejb.Local;
import org.uac.entityclass.Prop;

/**
 *
 * @author Teja
 */
@Local
public interface PropFacadeLocal {

    void create(Prop prop);

    void edit(Prop prop);

    void remove(Prop prop);

    Prop find(Object id);

    List<Prop> findAll();

    List<Prop> findRange(int[] range);

    int count();
    
}
