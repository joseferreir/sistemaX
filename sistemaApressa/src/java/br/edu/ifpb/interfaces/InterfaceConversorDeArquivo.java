/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.interfaces;


import br.edu.ifpb.valueObjects.Feriado;
import java.io.File;
import java.util.List;

/**
 *
 * @author José
 */
public interface InterfaceConversorDeArquivo {
     public List<Feriado> converteCsvEmFeriado(File arquivoCsv);
    
}
