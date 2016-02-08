/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.servlets;

import br.edu.ifpb.controle.ControleFeriado;
import br.edu.ifpb.medelo.Feriado;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
@WebServlet(name = "CadastraFeriado",urlPatterns = {"/CadastraFeriado"})
public class CadastraFeriado extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        
            String nome = request.getParameter("nome");
            JOptionPane.showMessageDialog(null, "feriado "+nome);
            
            String data = request.getParameter("data");
            JOptionPane.showMessageDialog(null, "feriado data"+data);

            ControleFeriado controle = new ControleFeriado();
            JOptionPane.showMessageDialog(null, "cotrole ");
            Feriado feriado = new Feriado( LocalDate.parse(data, DateTimeFormatter.ISO_DATE), nome);
            JOptionPane.showMessageDialog(null, "crio"+feriado.toString());
            controle.adiciona(feriado);
            JOptionPane.showMessageDialog(null, "feriado dao"+feriado.toString());

        } catch (Exception e) {

        }
    }

}
