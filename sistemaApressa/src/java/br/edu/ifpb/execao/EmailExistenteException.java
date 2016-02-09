
package br.edu.ifpb.execao;

/**
 * Exception de erro ao tentar adiiciona um usuário com email já existente no sistema. 
 * @ José
 */
public class EmailExistenteException extends RuntimeException {
    
    public EmailExistenteException(){
        super("Email de usuário já está em uso no sistema");
    }
    
}
