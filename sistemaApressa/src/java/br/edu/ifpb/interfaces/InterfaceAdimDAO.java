/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.interfaces;

import br.edu.ifpb.valueObjects.Usuario;
import java.util.List;

/**
 *
 * @author José
 */
public interface InterfaceAdimDAO {

    public boolean addUsuario(Usuario usuario);

    public boolean remover(String matricula);

    public List<Usuario> buscaTotosUsuarios();

    public List<Usuario> buscaPorPalavraChave(String palavra);

    public boolean atualizarParaAdministrador(String email);

    public boolean editarUsuario(Usuario usuario);

    public Usuario buscaPorEmail(String email);
    
     public Usuario buscaPorNome(String nome);
    

}
