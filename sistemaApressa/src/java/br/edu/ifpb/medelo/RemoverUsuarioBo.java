package br.edu.ifpb.medelo;

import br.edu.ifpb.valueObjects.Usuario;
import br.edu.ifpb.DAO.UsuarioAdmDAO;
import br.edu.ifpb.enums.PapelUser;


public class RemoverUsuarioBo {
    
    public UsuarioAdmDAO dao;
   
    public boolean removeUsuario(Usuario usuario){
        
        if(dao == null)
            dao = new UsuarioAdmDAO();
        
        if(usuario.getPapel()== PapelUser.ADMISTRAD0R)
            return false;
        
        return dao.remover(usuario.getMatricula());
    }
    
    public boolean atualizarUsuario(Usuario usuario, String nome){
    
        usuario.setNome(nome);
        
        return removeUsuario(usuario);
    }
    
}
