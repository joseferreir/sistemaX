package br.edu.ifpb.controle;


import br.edu.ifpb.execao.FeriadoException;
import br.edu.ifpb.medelo.AdicionaFeriadoBo;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author victor
 */
@MultipartConfig
@WebServlet(name = "importarFeriados", urlPatterns = {"/importarferiados"})
public class ImportarFeriados extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          Part filePart = request.getPart("csv"); 
        InputStream fileContent = filePart.getInputStream();
        
        HttpSession session = request.getSession();

        String tipo[] = filePart.getContentType().split("/");
        if (!tipo[tipo.length - 1].equals("csv") && !tipo[tipo.length - 1].equals("vnd.ms-excel")) {
            String erro = " problema ao ler o arquivo, verifique o diretório e se o arquivo está num formato válido";
            session.setAttribute("erro", erro);
            response.sendRedirect("calendar.jsp");
        } else {
            String checkbox = request.getParameter("sobrescrever");
            boolean sobrescrever = false;

            if (checkbox != null && !checkbox.isEmpty()) {
                sobrescrever = true;
            }
              AdicionaFeriadoBo cadastrarFeriadoBo = null;

            if (cadastrarFeriadoBo == null) {
                cadastrarFeriadoBo = new AdicionaFeriadoBo();
            }

            try {
                cadastrarFeriadoBo.addFeriados(fileContent, sobrescrever);
                session.setAttribute("operacao", 1);
            } catch (FeriadoException ex) {
                String erro = " um problema ao ler o arquivo, verifique o diretório e se o arquivo está num formato válido";
                session.setAttribute("erro", erro);
            } finally {
                response.sendRedirect("calendar.jsp");
            }
        }


    }

}
