/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.servlets;

import br.edu.ifpb.controle.ControleUsuarioAdmin;
import br.edu.ifpb.factoy.DAOFactoy;
import br.edu.ifpb.medelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "RemoveUser",urlPatterns = {"/RemoveUser"})
public class RemoveUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            Usuario user = (Usuario) request.getSession().getAttribute("user");

            String matricula = request.getParameter("matricula");
            JOptionPane.showMessageDialog(null, matricula);
            ControleUsuarioAdmin controle = new ControleUsuarioAdmin();
           boolean x= controle.remover(matricula);
            JOptionPane.showMessageDialog(null, "DAO "+x);

        } catch (Exception e) {
        }
    }

}
