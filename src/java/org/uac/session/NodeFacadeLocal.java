/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uac.session;

import java.util.List;
import javax.ejb.Local;
import org.uac.entityclass.Node;

/**
 *
 * @author Teja
 */
@Local
public interface NodeFacadeLocal {

    void create(Node node);

    void edit(Node node);

    void remove(Node node);

    Node find(Object id);

    List<Node> findAll();

    List<Node> findRange(int[] range);

    int count();

    Boolean delNode(String gn);
    
}
