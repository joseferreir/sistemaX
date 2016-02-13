
package br.edu.ifpb.medelo;

import br.edu.ifpb.valueObjects.Feriado ;
import br.edu.ifpb.execao.FeriadoException;
import br.edu.ifpb.DAO.FeriadoDAO;


public class EditaFeriadoBo {
    
    private FeriadoDAO dao;
    
    
    public boolean editaFeriado(Feriado feriado) throws FeriadoException{
        if(FeriadoBo.validaFeriado(feriado)){
            if(dao == null)
                dao = new FeriadoDAO();
            
            return dao.edita(feriado);
        }else{
            throw new FeriadoException();
        }
    }

  
    
    
}
