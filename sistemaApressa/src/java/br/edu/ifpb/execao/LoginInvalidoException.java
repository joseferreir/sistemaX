/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.execao;

/**
 *
 * @author José
 */
public class LoginInvalidoException extends Exception{
     public LoginInvalidoException(){
        super("Login ou senha invalido");
    }
    
}
