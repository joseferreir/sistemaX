package br.edu.ifpb.controle;

import br.edu.ifpb.enums.PapelUser;
import br.edu.ifpb.valueObjects.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author José 01/02/2016
 */
@WebServlet(name = "homeAdmin", urlPatterns = {"/homeAdmincontrol"})
public class HomeAdmin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario usuario;

        HttpSession session = request.getSession();

        usuario = (Usuario) session.getAttribute("usuario");

        if (usuario != null) {
            if (usuario.getPapel().equals(PapelUser.ADMISTRAD0R)) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("homeAdmin");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("home");
                dispatcher.forward(request, response);
            }
        } else {
            response.sendRedirect("index.html");
        }
    }

}
