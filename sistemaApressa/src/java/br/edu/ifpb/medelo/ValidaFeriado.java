/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.medelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author José
 */
public class ValidaFeriado {
    public static boolean verificarFeriado(Feriado feriado){   
        Pattern ptt     = Pattern.compile("[A-Za-z0-9á-ú ]+");
        Matcher matcher = ptt.matcher(feriado.getNome());
        
        return matcher.matches();
        
        
    }
    
}
