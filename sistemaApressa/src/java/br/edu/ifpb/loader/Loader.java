package br.edu.ifpb.loader;



import br.edu.ifpb.DAO.FeriadoDAO;
import br.edu.ifpb.DAO.UsuarioAdmDAO;
import br.edu.ifpb.enums.PapelUser;
import br.edu.ifpb.medelo.EdiraUsuarioBo;
import br.edu.ifpb.medelo.AdicionaFeriadoBo;
import br.edu.ifpb.medelo.AdicinaUsuario;
import br.edu.ifpb.medelo.EditaFeriadoBo;
import br.edu.ifpb.valueObjects.Feriado;
import br.edu.ifpb.valueObjects.Usuario;
import br.edu.ifpb.medelo.ValidaUser;
import java.io.File;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author José
 */
public class Loader {
    public static void main(String[] args) {
        EdiraUsuarioBo a = new EdiraUsuarioBo();
        
        EditaFeriadoBo  fg = new EditaFeriadoBo();
        Feriado f = new Feriado();
        f.setNome("HOJE");
        f.setData(LocalDate.of(2016, 04,01));
        
      /// boolean x= fg.editaFeriado(f);
     boolean x=  a.editaUsuario(new Usuario("000002", "maria.Dias", "diogo@gmail.com", "AS123as@", "/../", true, PapelUser.ALUNO));
        System.out.println(" "+x);
       // c.adiciona(new Feriado(LocalDate.of(2016, 01, 23), "agora"));
        UsuarioAdmDAO ad = new UsuarioAdmDAO() ;
      List<Usuario> s = ad.buscaTotosUsuarios();
      for(Usuario u :s)
        System.out.println("US" +u.getNome());
        //  c.importFeriado(InputStream("D://feriados.csv"), true);
        // boolean x=  a.editarUsuario(new Usuario("000001", "Ana Gloria", "maria@gmail", "AS123as@", "/../", true, PapelUser.ALUNO));
        //  System.out.println("cadastrou "+x);
        // Usuario u =   a.login("Ana Gloria", "AS123as@");
        //  System.out.println(" usuario logado " +u);
        // boolean x=   ValidaUser.validarEmail("jose_m@ai.com");
        //  System.out.println("email  "+x);
     
              FeriadoDAO d= new FeriadoDAO();
               List<Feriado> fs = d.buscarTodos();
        for (Iterator<Feriado> it = fs.iterator(); it.hasNext();) {
            Feriado xo= it.next();
            System.out.println(" ddd"+ xo);
        }
            
            
        
        
         
        
    }

    private static InputStream InputStream(String dferiadoscsv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
