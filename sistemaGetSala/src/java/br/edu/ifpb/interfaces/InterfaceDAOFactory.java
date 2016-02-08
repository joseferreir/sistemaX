/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.interfaces;

/**
 *
 * @author José
 */



public interface InterfaceDAOFactory {

    public InterfaceUsuarioDAO criaUsuarioDAO();

    public InterfaceAdimDAO criaUsuarioAdmDAO();
    
    public InterfaceFeriadoDAO criaFeriadoDAO();
}
