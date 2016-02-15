package br.edu.ifpb.controle;

import br.edu.ifpb.DAO.UsuarioAdmDAO;
import br.edu.ifpb.enums.PapelUser;
import br.edu.ifpb.execao.EmailExistenteException;
import br.edu.ifpb.execao.NomeUsuarioExistenteException;
import br.edu.ifpb.medelo.EdiraUsuarioBo;
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
 * 
 */
@WebServlet(name = " EditaUsuario", urlPatterns = {"/EditaUsuario"})
public class EditaUsuario extends HttpServlet {

    private EdiraUsuarioBo atualizarUsuarioBo;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (atualizarUsuarioBo == null) {
            atualizarUsuarioBo = new EdiraUsuarioBo();
        }

         String nome = request.getParameter("name");

            String email = request.getParameter("email");

            String matricula = request.getParameter("matricula");

            String tipo = request.getParameter("papel");
            
            String senha = request.getParameter("senha");
        PapelUser papel = null;

        if (tipo != null && !tipo.trim().isEmpty()) {
            for (PapelUser p : papel.values()) {
                if (p.name().equals(tipo)) {
                    papel = p;
                    break;
                }
            }
        } else {
            papel = PapelUser.ADMISTRAD0R;
        }

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioEditado");
        request.getSession().setAttribute("usuarioEditado", null);

        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setMatricula(matricula);
        usuario.setPapel(papel);

        HttpSession session = request.getSession();

        String erro = "";

        try {
            if (atualizarUsuarioBo.editaUsuario(usuario)) {
                session.setAttribute("operacao", 1);
            } else {
            }
        } catch (EmailExistenteException emailEx) {
            erro += emailEx.getMessage();
        } catch (NomeUsuarioExistenteException nomeEx) {
            String nomeSugestivo1 = "";
            String nomeSugestivo2 = "";

            UsuarioAdmDAO dao = new UsuarioAdmDAO();

            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                if (nomeSugestivo1.isEmpty()) {
                    if (dao.buscaPorNome(nome + i) == null) {
                        nomeSugestivo1 = nome + i;
                    }
                } else if (nomeSugestivo2.isEmpty()) {
                    if (dao.buscaPorNome(nome + i) == null) {
                        nomeSugestivo2 = nome + i;
                    }
                } else {
                    break;
                }
            }

            erro += nomeEx.getMessage() + ". Nomes Sugeridos: " + nomeSugestivo1 + " ou " + nomeSugestivo2;
        } finally {
            if (!erro.isEmpty()) {
                erro = "Os seguintes erros foram encontrados ao atualizar o usuário: " + erro;
                session.setAttribute("erro", erro);
            }
            response.sendRedirect("gerenciar_usuario");
        }

    }

}
