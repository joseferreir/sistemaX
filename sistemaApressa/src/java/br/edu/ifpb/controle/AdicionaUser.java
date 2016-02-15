/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.controle;

import br.edu.ifpb.enums.PapelUser;
import br.edu.ifpb.medelo.AdicinaUsuario;
import br.edu.ifpb.valueObjects.Usuario;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author José
 */
@WebServlet(name = " CadastroUser", urlPatterns = {"/CadastroUser"})
public class AdicionaUser extends HttpServlet {

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

            String email = request.getParameter("email");

            String matricula = request.getParameter("matricula");

            String papel = request.getParameter("papel");

            String senha = request.getParameter("senha");
            Usuario usuario = new Usuario(matricula, nome, email, senha, "img\\profiles/reader-default.png", true, PapelUser.valueOf(papel));
            String foto = new ProcessadorFotos("img/profiles").processarArquivo(request, "imagemPerfil" + usuario.getNome());
            if (foto != null) {
                usuario.setFoto(foto);
            }
            AdicinaUsuario BO = new AdicinaUsuario();
            if (BO.addUsuario(usuario)) {

                HttpSession session = request.getSession();
                Usuario user = (Usuario) request.getSession().getAttribute("user");

                session.setAttribute("user", user);
                request.getRequestDispatcher("JSP/cadastrou.jsp").forward(request, response);
            } else {
                response.sendRedirect("gerenciarUser.jsp");
            }
        } catch (Exception e) {
        }

    }

}
