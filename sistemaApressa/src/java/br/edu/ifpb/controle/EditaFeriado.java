package br.edu.ifpb.controle;

import br.edu.ifpb.execao.FeriadoException;
import br.edu.ifpb.medelo.ConversoDeStringEmLocalDate;
import br.edu.ifpb.medelo.EditaFeriadoBo;
import br.edu.ifpb.valueObjects.Feriado;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author victor
 */
@WebServlet(name = "atualizarFeriado", urlPatterns = {"/atualizarFeriado"})
public class EditaFeriado extends HttpServlet {

    private EditaFeriadoBo editaUsuario;
    private Connection connection;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (editaUsuario == null) {
            editaUsuario = new EditaFeriadoBo();
        }

        String nome = request.getParameter("nome");
        String data = request.getParameter("data");
        

        Feriado feriado = new Feriado();
        feriado.setData(ConversoDeStringEmLocalDate.converteStringEmLocalDate(data));
        feriado.setNome(nome);

        HttpSession session = request.getSession();
        try {
            editaUsuario.editaFeriado(feriado);
            session.setAttribute("operacao", 1);
        } catch (FeriadoException ex) {
            String erro = "Uma falha ocorreu ao atualizar o feriado, certifique-se de ter utilizado uma data válida e que a descrição não conheta nenhum caractere especial (@, #, $, !, etc.)";
            session.setAttribute("erro", erro);
        } finally {
            response.sendRedirect("calendar.jsp");
        }

    }

}
