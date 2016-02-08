/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.servlets;

import br.edu.ifpb.enums.PapelUser;
import br.edu.ifpb.factoy.DAOFactoy;
import br.edu.ifpb.medelo.Usuario;
import br.edu.ifpb.medelo.ValidaUser;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author José
 */
@WebServlet(name = " CadastroUser",urlPatterns = {"/CadastroUser"})
public class CadastroUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String nome = request.getParameter("name");

            JOptionPane.showMessageDialog(null, "nome " + nome);

            String email = request.getParameter("email");

            JOptionPane.showMessageDialog(null, "email 2" + email);

            String matricula = request.getParameter("matricula");

            JOptionPane.showMessageDialog(null, "mat " + matricula);

            String tipo = request.getParameter("papel");

            JOptionPane.showMessageDialog(null, "tipo 1" + tipo);

            String senha = request.getParameter("senha");

            JOptionPane.showMessageDialog(null, "senha 1" + senha);

            String foto = request.getParameter("foto");
            ServletContext context = getServletContext();
            String fotoperfil = context.getRealPath(foto);

            JOptionPane.showMessageDialog(null, "foto 1" + fotoperfil);
            if(ValidaUser.validaPassword(senha)){
            Usuario usuario = new Usuario(matricula, nome, email, senha, fotoperfil, true, PapelUser.ADMINISTRADOR);

            JOptionPane.showMessageDialog(null, "usario" + usuario.toString());

            DAOFactoy.criarFactoy().criaUsuarioAdmDAO().addUsuario(usuario);

            JOptionPane.showMessageDialog(null, " DAO 123" + usuario.toString());

            HttpSession session = request.getSession();
            JOptionPane.showMessageDialog(null, " session" + usuario.toString());
            Usuario user = (Usuario) request.getSession().getAttribute("user");

            JOptionPane.showMessageDialog(null, " sessiodep" + usuario.toString());
            session.setAttribute("user", user);
            request.getRequestDispatcher("JSP/cadastrou.jsp").forward(request, response);
            }else{
             JOptionPane.showMessageDialog(null, "fomato de senha invalido " + senha);
             response.sendRedirect("gerenciarUser.jsp");
            }
        } catch (Exception e) {
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
