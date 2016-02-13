/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.controle;

import br.edu.ifpb.medelo.LoginBo;
import br.edu.ifpb.valueObjects.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author José
 */
public class Loga extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        Usuario usuario;
        LoginBo BO = new LoginBo();
        usuario = BO.login(login, senha);

        if (usuario != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", usuario);
            response.sendRedirect("home.jsp");

        } else {
            response.sendRedirect("loginFalha.jsp");

        }
    }

}
