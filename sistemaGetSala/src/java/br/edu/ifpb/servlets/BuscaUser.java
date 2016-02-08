/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.servlets;

import br.edu.ifpb.controle.ControleUsuarioAdmin;
import br.edu.ifpb.medelo.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author José
 */
@WebServlet(name = "BuscaUser",urlPatterns = {"/BuscaUser"})
public class BuscaUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ControleUsuarioAdmin controle = new ControleUsuarioAdmin();
          List<Usuario> usuarios ;
          usuarios = controle.buscaTotosUsuarios();
            JOptionPane.showMessageDialog(null, usuarios);
            request.setAttribute("usuariosBuscados", usuarios);
        } catch (Exception e) {
        }
    }

}
