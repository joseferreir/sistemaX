/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author José
 */
public class ConexaoBD {
     private static Connection conn = null;

    private static PreparedStatement stm = null;

    public static Connection abrirConexao() throws ClassNotFoundException, SQLException {
        return abrirConexaoBanco("localhost", "padroes", "postgres", "123456");
    }

    public static Connection abrirConexaoBanco(String server, String dataBase, String user, String password) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection("jdbc:postgresql://" + server + ":5432/" + dataBase, user, password);
        return conn;
    }

    public static void fecharConexao(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public static PreparedStatement abrirStatement(String sql) {

        try {
            stm = conn.prepareStatement(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return stm;
    }

    public static boolean fecharStatment(PreparedStatement stm) throws SQLException {

        if (stm != null) {
            try {
                stm.close();
                return true;
            } finally {
                stm.close();
            }
        }
        return false;
    }
    
    
}
