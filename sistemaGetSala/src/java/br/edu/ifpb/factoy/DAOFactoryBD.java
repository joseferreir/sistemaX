package br.edu.ifpb.factoy;

import br.edu.ifpb.DAO.FeriadoDAO;
import br.edu.ifpb.DAO.UsuarioAdmDAO;
import br.edu.ifpb.DAO.UsuarioDAO;
import br.edu.ifpb.interfaces.InterfaceAdimDAO;
import br.edu.ifpb.interfaces.InterfaceDAOFactory;
import br.edu.ifpb.interfaces.InterfaceFeriadoDAO;



public class DAOFactoryBD implements InterfaceDAOFactory{

    @Override
    public UsuarioDAO criaUsuarioDAO() {
        return new UsuarioDAO();
        
    }

    @Override
    public UsuarioAdmDAO criaUsuarioAdmDAO() {
        return new UsuarioAdmDAO();
    }
     @Override
    public InterfaceFeriadoDAO criaFeriadoDAO() {
        return new  FeriadoDAO();
    }

   

    
}
