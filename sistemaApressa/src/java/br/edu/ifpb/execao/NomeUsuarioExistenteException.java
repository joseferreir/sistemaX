
package br.edu.ifpb.execao;

/**
 * Exception que indica erro nas operaçõe de usuário caso já exista outro com mesmo nome. 
 * @author José
 */
public class NomeUsuarioExistenteException extends RuntimeException{
    
    public NomeUsuarioExistenteException(){
        super("Nome usuário já existe");
    }
    
}
