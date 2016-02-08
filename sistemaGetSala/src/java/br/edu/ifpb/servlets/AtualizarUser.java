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
import javax.swing.JOptionPane;

/**
 *
 * @author José
 */
@WebServlet(name = "AtualizarUser",urlPatterns = {"/AtualizarUser"})
public class AtualizarUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPut(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String novaSenha = request.getParameter("senha");
            JOptionPane.showMessageDialog(null, "senha "+novaSenha);
            if (ValidaUser.validaPassword(novaSenha)) {

                Usuario user = (Usuario) request.getSession().getAttribute("user");

                String nome = request.getParameter("name");
                JOptionPane.showMessageDialog(null, "nome 2" + nome);
                String email = request.getParameter("email");
                JOptionPane.showMessageDialog(null, "email 2" + email);

                String tipo = request.getParameter("tipo");

                String matricula = request.getParameter("matricula");
                JOptionPane.showMessageDialog(null, "mat  " + matricula);
                String foto = request.getParameter("foto");
                
// ajeita da qui
                ServletContext context = getServletContext();
                String fotoperfil = context.getRealPath(foto);
                JOptionPane.showMessageDialog(null, "foto" + fotoperfil);

                Usuario usuario = new Usuario(matricula, nome, email, novaSenha, fotoperfil, true, PapelUser.ALUNO);
                JOptionPane.showMessageDialog(null, "crio usuario" );

               
                
                JOptionPane.showMessageDialog(null, "user" + usuario.toString());
              boolean x =  DAOFactoy.criarFactoy().criaUsuarioAdmDAO().editarUsuario(usuario);
                JOptionPane.showMessageDialog(null, "DAO "+x );
                
            }
            else{
            JOptionPane.showMessageDialog(null, "Fomato de senha invalido");
            response.sendRedirect("gerenciarUser.jsp");
            }
        } catch (Exception e) {
            
        }
    }

    

}
