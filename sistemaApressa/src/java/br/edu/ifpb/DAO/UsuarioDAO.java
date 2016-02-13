/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.DAO;

import br.edu.ifpb.conexao.ConexaoBD;
import br.edu.ifpb.enums.PapelUser;
import br.edu.ifpb.interfaces.InterfaceUsuarioDAO;
import br.edu.ifpb.valueObjects.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José
 */
public class UsuarioDAO implements InterfaceUsuarioDAO {

    @Override
    public boolean editarPirfio(Usuario usuario) {
        boolean result = false;

        Connection conn = null;

        try {

            conn = ConexaoBD.abrirConexao();
            String sql = "UPDATE Usuario SET matricula = ?, nomeUsuario = ?, email = ?, senha = ?,foto = ?"
                    + "WHERE matricula = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, usuario.getMatricula());
            pst.setString(2, usuario.getNome());
            pst.setString(3, usuario.getEmail());
            pst.setString(4, usuario.getSenha());
            pst.setString(5, usuario.getFoto());
            pst.setString(6, usuario.getMatricula());
            if (pst.executeUpdate() == 1) {
                result = true;
            }
        } catch (SQLException e) {
            System.err.println("Erro " + e.getMessage());
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            result = false;
        } finally {
            ConexaoBD.fecharConexao(conn);
        }

        return result;
    }

    @Override
    public Usuario login(String nomeOuEmail, String senha) {

        Connection conn = null;
        PreparedStatement stm;
        Usuario us = null;

        try {
            String sql = "SELECT * FROM Usuario WHERE  nomeUsuario = ? OR email = ? and senha =? ";
            conn = ConexaoBD.abrirConexao();
            stm = conn.prepareStatement(sql);
            stm.setString(1, nomeOuEmail);
            stm.setString(2, nomeOuEmail);
            stm.setString(3, senha);
            ResultSet result = stm.executeQuery();

            if (result.next()) {
                us = new Usuario();

                us.setMatricula(result.getString("matricula"));
                us.setNome(result.getString("nomeUsuario"));
                us.setEmail(result.getString("email"));
                us.setSenha(result.getString("senha"));
                us.setFoto(result.getString("foto"));
                us.setPapel(PapelUser.valueOf(result.getString("papel")));

            }

        } catch (SQLException e) {
            System.err.println("Erro " + e.getMessage());
            e.getStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBD.fecharConexao(conn);
        }
        return us;

    }

    public boolean alterarSenha(Usuario u) {
        return editarPirfio(u);
    }
}
