/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.conexao;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author José
 */
public class ConexaoBD {

    private static Connection conn = null;
    private static Properties prop = null;
    private static PreparedStatement stm = null;

    public static Connection abrirConexao() throws ClassNotFoundException, SQLException {
        ConexaoBD bd = new ConexaoBD();
        return bd.abrirConexaoBanco();
    }
/** recupera as informaões de conexão co banco */
    public Connection abrirConexaoBanco() throws ClassNotFoundException, SQLException {
        try {
//            
            Properties prop = new Properties();
            FileInputStream file = new FileInputStream(".//nbproject/connection.properties");
            prop.load(file);
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection(url, user, password);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
        }
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
