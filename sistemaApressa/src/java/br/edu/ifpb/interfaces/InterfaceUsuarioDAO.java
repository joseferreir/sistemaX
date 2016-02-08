package br.edu.ifpb.interfaces;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.edu.ifpb.medelo.Usuario;
import java.util.List;

/**
 *
 * @author José
 */
public interface InterfaceUsuarioDAO {
    //throws PersistenciaException;

    public boolean editarPirfio(Usuario usuario);

    public Usuario login(String nomeOuEmail, String senha);

    public boolean alterarSenha(Usuario u);
}
