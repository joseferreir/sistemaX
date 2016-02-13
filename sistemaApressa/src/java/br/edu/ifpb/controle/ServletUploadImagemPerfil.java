/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.controle;

import br.edu.ifpb.medelo.EdiraUsuarioBo;
import br.edu.ifpb.valueObjects.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileUploadException;

/**
 *
 * @author Natarajan
 */
@WebServlet(name = "uploadImagem", urlPatterns = {"/uploadImagem"})
public class ServletUploadImagemPerfil extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, FileUploadException {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        String foto = new ProcessadorFotos("img/profiles").processarArquivo(request, "imagemPerfil" + usuario.getEmail());
        if (foto != null) {

            usuario.setFoto(foto);
            EdiraUsuarioBo BO = new EdiraUsuarioBo();
            if (!BO.editaUsuario(usuario)) {
                return;
            }
        }
        response.sendRedirect("editar_perfil.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            processRequest(req, resp);
        } catch (FileUploadException ex) {
            Logger.getLogger(ServletUploadImagemPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            processRequest(req, resp);
        } catch (FileUploadException ex) {
            Logger.getLogger(ServletUploadImagemPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
