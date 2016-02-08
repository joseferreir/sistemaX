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
@WebServlet(name = " AtualizarFeriado",urlPatterns = {"/ AtualizarFeriado"})
public class AtualizarFeriado extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        try {

            String nome = request.getParameter("nomeFeriado");
            String data = request.getParameter("dataFeriado");
            JOptionPane.showMessageDialog(null, nome +"----"+ data);
            Feriado novoFeriado = new Feriado(LocalDate.parse(data, DateTimeFormatter.ISO_DATE),nome);
JOptionPane.showMessageDialog(null, nome +"---- data"+ novoFeriado.getData());
           
            ControleFeriado controle = new ControleFeriado();
            controle.edita(novoFeriado);
            JOptionPane.showMessageDialog(null, nome +"DAO"+ data);

        } catch (Exception e) {
        }
    }

}
