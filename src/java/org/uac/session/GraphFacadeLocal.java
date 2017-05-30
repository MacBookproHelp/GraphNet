/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uac.session;

import java.util.List;
import javax.ejb.Local;
import org.uac.entityclass.Graph;


@Local
public interface GraphFacadeLocal {

    void create(Graph graph);

    void edit(Graph graph);

    void remove(Graph graph);

    Graph find(Object id);

    List<Graph> findAll();

    List<Graph> findRange(int[] range);

    int count();

    Boolean addGraph(String gn, String gd, String gw, String gu, String gs, String go, String ge);

    List<Graph> getUsergraphs(String gu, String gn);

    String getGraph(String u, String gn);
    
}
