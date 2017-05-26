/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uac.session;

import java.util.List;
import javax.ejb.Local;
import org.uac.entityclass.Edge;

/**
 *
 * @author Teja
 */
@Local
public interface EdgeFacadeLocal {

    void create(Edge edge);

    void edit(Edge edge);

    void remove(Edge edge);

    Edge find(Object id);

    List<Edge> findAll();

    List<Edge> findRange(int[] range);

    int count();

    void deleteEdge(String en);

    Boolean deleteNode(String n);

    Boolean delEdge(String gn);
    
}
