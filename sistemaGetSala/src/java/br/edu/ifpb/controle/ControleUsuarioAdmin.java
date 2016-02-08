/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.controle;

import br.edu.ifpb.factoy.DAOFactoy;
import br.edu.ifpb.medelo.Usuario;
import java.util.List;

/**
 *
 * @author José
 */
public class ControleUsuarioAdmin {

    public boolean addUsuario(Usuario usuario) {
        return DAOFactoy.criarFactoy().criaUsuarioAdmDAO().addUsuario(usuario);
    }

    public boolean remover(String matricula) {
        return DAOFactoy.criarFactoy().criaUsuarioAdmDAO().remover(matricula);
    }

    public List<Usuario> buscaTotosUsuarios() {
        return DAOFactoy.criarFactoy().criaUsuarioAdmDAO().buscaTotosUsuarios();
    }

    public List<Usuario> buscaPorPalavraCavhe(String palavra) {
        return DAOFactoy.criarFactoy().criaUsuarioAdmDAO().buscaPorPalavraChave(palavra);
    }

    public boolean editarUsuario(Usuario usuario) {
        return DAOFactoy.criarFactoy().criaUsuarioAdmDAO().editarUsuario(usuario);
    }

    public boolean alterar(Usuario u) {
        return DAOFactoy.criarFactoy().criaUsuarioDAO().alterarSenha(u);
    }

    public boolean atualizarParaAdministrador(String email) {
        return DAOFactoy.criarFactoy().criaUsuarioAdmDAO().atualizarParaAdministrador(email);

        
    }
     public Usuario login(String nomeUser, String senha) {
        return DAOFactoy.criarFactoy().criaUsuarioDAO().login(nomeUser, senha);
    }

}
