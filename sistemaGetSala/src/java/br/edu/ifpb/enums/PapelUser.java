/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.enums;

/**
 *
 * @author José
 */
public enum PapelUser {
     ADMINISTRADOR("ADNISTRAD0R") ,ASSISTENTE_SALA("ASSISTENTE_SALA"), PROFESSOR("Professor"), MONITOR("Monitor"), ALUNO("Aluno");
    
    public String id;
    
    PapelUser(String papel){
        id = papel;
    }
}
