/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.controle;

import br.edu.ifpb.factoy.DAOFactoy;
import br.edu.ifpb.medelo.Usuario;


/**
 *
 * @author José
 */
public class ControleUsuario {
     public boolean editarPirfio(Usuario usuario){
      return DAOFactoy.criarFactoy().criaUsuarioDAO().editarPirfio(usuario);
         
     }

    public Usuario login(String nomeUser, String senha){
        return DAOFactoy.criarFactoy().criaUsuarioDAO().login(nomeUser, senha);
        
    }
    public boolean alterar(Usuario u){
    return DAOFactoy.criarFactoy().criaUsuarioDAO().alterarSenha(u);
    }
    
    
}
