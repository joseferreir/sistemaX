package br.edu.ifpb.medelo;

import br.edu.ifpb.valueObjects.Feriado;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FeriadoBo {
    
    
    public static boolean validaFeriado(Feriado feriado){
        
       return ValidaFeriado.verificarFeriado(feriado);
    }
    
}
