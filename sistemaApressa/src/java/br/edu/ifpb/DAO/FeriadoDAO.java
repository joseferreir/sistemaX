/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.DAO;


import br.edu.ifpb.conexao.ConexaoBD;
import br.edu.ifpb.interfaces.InterfaceFeriadoDAO;
import br.edu.ifpb.medelo.Feriado;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José
 */
public class FeriadoDAO implements InterfaceFeriadoDAO {

    @Override
    public boolean adiciona(Feriado feriado) {
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        String sql = "INSERT INTO Feriado (data,nome)"
                + " VALUES (?, ?)";
        //md5

        try {

            conn = ConexaoBD.abrirConexao();
            stm = ConexaoBD.abrirStatement(sql);
            stm.setDate(1, Date.valueOf(feriado.getData()));
            stm.setString(2, feriado.getNome());
            stm.executeUpdate();

            result = true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FeriadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ConexaoBD.fecharStatment(stm);
            } catch (SQLException ex) {
                Logger.getLogger(FeriadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            ConexaoBD.fecharConexao(conn);
        }

        return result;
    }

    @Override
    public boolean edita(Feriado feriado) {
        boolean result = false;

        Connection conn = null;

        try {
            conn = ConexaoBD.abrirConexao();
            String sql = "UPDATE Feriado SET data = ?, nome = ? "
                    + "WHERE nome = ?";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setDate(1, Date.valueOf(feriado.getData()));
            pst.setString(2, feriado.getNome());
            pst.setString(3, feriado.getNome());
            pst.executeUpdate();
            pst.close();

            result = true;
        } catch (SQLException e) {
            System.err.println("Erro " + e.getMessage());
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FeriadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBD.fecharConexao(conn);
        }

        return result;
    }

    @Override
    public Feriado buscarPorNome(String nome) {
        Connection conn = null;
        PreparedStatement stm;
        Feriado f = null;
        try {
            String sql = "SELECT * FROM Feriado where nome = ?";
            conn = ConexaoBD.abrirConexao();
            stm = conn.prepareStatement(sql);
            stm.setString(1, nome);
            ResultSet result = stm.executeQuery();

            while (result.next()) {
                f = new Feriado();

                f.setNome(result.getString("nome"));
                f.setData(result.getDate("data").toLocalDate());

            }

        } catch (SQLException e) {
            System.err.println("Erro " + e.getMessage());
            e.getStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FeriadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBD.fecharConexao(conn);
        }
        return f;
    }

    @Override
    public List<Feriado> buscarTodos() {
        Connection conn = null;
        PreparedStatement stm;
        List<Feriado> feriados = new ArrayList<Feriado>();
        try {
            String sql = "SELECT * FROM Feriado ";
            conn = ConexaoBD.abrirConexao();
            stm = conn.prepareStatement(sql);
            ResultSet result = stm.executeQuery();

            while (result.next()) {
                Feriado f = new Feriado();
                f.setData(result.getDate("data").toLocalDate());
                f.setNome(result.getString("nome"));
                feriados.add(f);
            }

        } catch (SQLException e) {
            System.err.println("Erro " + e.getMessage());
            e.getStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FeriadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBD.fecharConexao(conn);
        }
        return feriados;

    }

    @Override
    public boolean importFeriado(List<Feriado> feriados) {
        //abre um arquivo e cria um file
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        String sql = "INSERT INTO Feriado (data,nome)"
                + " VALUES (?, ?)";
        
        
        try {

            conn = ConexaoBD.abrirConexao();
            int i = 0;
            do {
                stm = ConexaoBD.abrirStatement(sql);
                stm.setDate(1, Date.valueOf(feriados.get(i).getData()));
                stm.setString(2, feriados.get(i).getNome());
                stm.executeUpdate();
                stm.close();
                i++;
                result = true;
            } while (result && i < feriados.size());

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FeriadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ConexaoBD.fecharConexao(conn);
                ConexaoBD.fecharStatment(stm);
            } catch (SQLException ex) {
                Logger.getLogger(FeriadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return result;

    }

    @Override
    public boolean remover(String nome) {
        Connection conn = null;
        try {
            conn = ConexaoBD.abrirConexao();
            String sql = "DELETE FROM Feriado WHERE nome = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, nome);
            stm.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FeriadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
