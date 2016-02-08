/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.servlets;

import br.edu.ifpb.controle.ControleFeriado;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author José
 */
@WebServlet("/ServletImportarFeriado")

@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1MB
        maxFileSize = 1024 * 1024 * 25, // 4MB
        maxRequestSize = 1024 * 1024 * 10 // 4MB
)
public class ImportaFeriado extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        File dir = new File(getServletContext().getRealPath("uploads"));
        if (!dir.isDirectory()) {
            dir.mkdir();
            ControleFeriado cont = new ControleFeriado();

            boolean importou = cont.importFeriado(dir);

            request.setAttribute("impot  ", importou);

            request.getRequestDispatcher("import.jsp").forward(request, response);

        }
    }

}
