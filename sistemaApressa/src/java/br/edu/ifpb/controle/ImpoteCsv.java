/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.controle;

import static br.edu.ifpb.medelo.ConversoDeStringEmLocalDate.converteStringEmLocalDate;
import br.edu.ifpb.medelo.Feriado;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.util.converter.LocalDateTimeStringConverter;
import javax.swing.JOptionPane;

/**
 *
 * @author José
 */
class ImpoteCsv {
     public   List<Feriado> importeCsv(File arquivo){
        List<Feriado> feriados = new ArrayList<Feriado>();
          try{
            
            //cria um scanner para ler o arquivo
            Scanner leitor = new Scanner(arquivo);
            
            //variavel que armazenara as linhas do arquivo
            String linhasDoArquivo = new String();
            
            //ignora a primeira linha do arquivo
            leitor.nextLine();
            
            //percorre todo o arquivo
            while(leitor.hasNext()){
                
                //recebe cada linha do arquivo
                linhasDoArquivo = leitor.nextLine();
                
                //separa os campos entre as virgulas de cada linha
                String[] valoresEntreVirgulas = linhasDoArquivo.split(",");
                //-----------------------
            LocalDate  data = ConversoDeStringEmLocalDate.converteStringEmLocalDate(valoresEntreVirgulas[0]);
                String nome = valoresEntreVirgulas[1];
                JOptionPane.showMessageDialog(null, nome+"---"+ data);
                
               Feriado f = new Feriado(data,nome);
               feriados.add(f);
            }
            return feriados;
        
        }catch(FileNotFoundException e){
            
        }
        return null;

    }
}
