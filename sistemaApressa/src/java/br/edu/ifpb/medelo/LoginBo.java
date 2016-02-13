package br.edu.ifpb.medelo;

import br.edu.ifpb.valueObjects.Usuario;
import br.edu.ifpb.DAO.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;

public class LoginBo {

    private UsuarioDAO usuarioDao;

   
    public Usuario login(String login, String senha) {
        Usuario usuario = null;
       
        if (usuarioDao == null) {
            usuarioDao = new UsuarioDAO();
        }
        List<Usuario> lstaUser = new ArrayList<Usuario>();
        lstaUser.add(usuarioDao.login(login, senha));

        if (lstaUser.size() > 0) {
            return usuario = lstaUser.get(0);
        }

        return usuario;
    }

}
