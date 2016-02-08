/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.factoy;

import br.edu.ifpb.interfaces.InterfaceDAOFactory;



/**
 *
 * @author José
 */
public class DAOFactoy {
    public static InterfaceDAOFactory criarFactoy() {
        return new DAOFactoryBD();
    }
    
}
