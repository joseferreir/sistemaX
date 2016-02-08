/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.DAO;

import br.edu.ifpb.conexao.ConexaoBD;
import br.edu.ifpb.enums.PapelUser;
import br.edu.ifpb.factoy.DAOFactoy;
import br.edu.ifpb.interfaces.InterfaceAdimDAO;
import br.edu.ifpb.interfaces.InterfaceUsuarioDAO;
import br.edu.ifpb.medelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JosÃ©
 */
public class UsuarioAdmDAO implements InterfaceAdimDAO, InterfaceUsuarioDAO {

    @Override
    public boolean addUsuario(Usuario usuario) {
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        String sql = "INSERT INTO usuario (matricula , nomeUsuario, email, senha ,foto, papel)"
                + "VALUES(?, ?, ?, ? ,? ,?) ";
        //md5

        try {

            conn = ConexaoBD.abrirConexao();
            stm = ConexaoBD.abrirStatement(sql);
            stm.setString(1, usuario.getMatricula());
            stm.setString(2, usuario.getNome());
            stm.setString(3, usuario.getEmail());
            stm.setString(4, usuario.getSenha());
            stm.setString(5, usuario.getFoto());
            stm.setString(6, String.valueOf(usuario.getPapel()));
            stm.executeUpdate();

            result = true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioAdmDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ConexaoBD.fecharStatment(stm);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioAdmDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            ConexaoBD.fecharConexao(conn);
        }

        return result;

    }

    public boolean atualizarParaAdministrador(String email) {
        boolean result = false;

        Connection conn = null;

        try {
            try {
                conn = ConexaoBD.abrirConexao();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UsuarioAdmDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sql = "UPDATE Usuario SET papel = Administrador WHERE email = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, email);
            pst.executeUpdate();

            result = true;
        } catch (SQLException e) {
            System.err.println("Erro " + e.getMessage());
            e.printStackTrace();

        } finally {
            ConexaoBD.fecharConexao(conn);
        }

        return result;
    }

    @Override
    public boolean remover(String matricula) {

        boolean result = false;
        Connection conn = null;
        try {
            conn = ConexaoBD.abrirConexao();

            String sql = "DELETE FROM Usuario WHERE   matricula = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, matricula);
           if( stm.executeUpdate()==1) result = true;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioAdmDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.err.println("Erro " + ex.getMessage());

            Logger.getLogger(UsuarioAdmDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            ConexaoBD.fecharConexao(conn);
        }

        return result;
    }

    @Override
    public List<Usuario> buscaTotosUsuarios() {
        Connection conn = null;
        PreparedStatement stm;
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            String sql = "SELECT * FROM Usuario ";
            conn = ConexaoBD.abrirConexao();
            stm = conn.prepareStatement(sql);
            ResultSet result = stm.executeQuery();

            while (result.next()) {
                Usuario u = new Usuario();

                u.setMatricula(result.getString("matricula"));
                u.setNome(result.getString("NomeUsuario"));
                u.setEmail(result.getString("email"));
                u.setSenha(result.getString("senha"));
                u.setFoto(result.getString("foto"));
                u.setPapel(PapelUser.valueOf(result.getString("papel")));

                usuarios.add(u);
            }

        } catch (SQLException e) {
            System.err.println("Erro " + e.getMessage());
            e.getStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioAdmDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBD.fecharConexao(conn);
        }
        return usuarios;
    }

    @Override
    public List<Usuario> buscaPorPalavraChave(String palavra) {
        Connection conn = null;
        PreparedStatement stm;
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            String sql = "SELECT * FROM Usuario WHERE nomeUsuario LIKE ?";
            conn = ConexaoBD.abrirConexao();
            stm = conn.prepareStatement(sql);
           stm.setString(1, palavra);
            ResultSet result = stm.executeQuery();

            while (result.next()) {
                Usuario u = new Usuario();

                u.setMatricula(result.getString("matricula"));
                u.setNome(result.getString("NomeUsuario"));
                u.setEmail(result.getString("email"));
                u.setSenha(result.getString("senha"));
                u.setFoto(result.getString("foto"));
                u.setPapel(PapelUser.valueOf(result.getString("papel")));

                usuarios.add(u);
            }

        } catch (SQLException e) {
            System.err.println("Erro " + e.getMessage());
            e.getStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioAdmDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBD.fecharConexao(conn);
        }
        return usuarios;

    }

    @Override
    public boolean editarUsuario(Usuario usuario) {
        return DAOFactoy.criarFactoy().criaUsuarioDAO().editarPirfio(usuario);
    }

    @Override
    public boolean editarPirfio(Usuario usuario) {
        return DAOFactoy.criarFactoy().criaUsuarioDAO().editarPirfio(usuario);

    }

    @Override
    public Usuario login(String nomeUser, String senha) {
        return DAOFactoy.criarFactoy().criaUsuarioDAO().login(nomeUser, senha);
    }

    @Override
    public boolean alterarSenha(Usuario u) {
        return DAOFactoy.criarFactoy().criaUsuarioDAO().alterarSenha(u);
    }

}
