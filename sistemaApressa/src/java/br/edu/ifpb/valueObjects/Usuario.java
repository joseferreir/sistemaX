/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.valueObjects;

import br.edu.ifpb.enums.PapelUser;

/**Classe para objetos do tipo Usuario, onde serão contidos, valores e métodos para o mesmo.

 * @Aluísio , josé e zilderlan

 * @version 1.05

 * @since Release 02 da aplicação

 */

public class Usuario implements Comparable<Usuario>{

    private String matricula;
    private String nome;
    private String email;
    private String senha;
    private String foto;
    private boolean status;
    private PapelUser papel;
/** Construtor default para class  Usuário
 */
    public Usuario() {
        this.status = true;
    }
/** Construtor parametrizado  para class  Usuário
 */
    public Usuario(String matricula, String nome, String email, String senha, String foto, boolean status, PapelUser papel) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.foto = foto;
        this.status = status;
        this.papel = papel;
    }

  /** Método que retorna a matricula do usuário
   * @return String corespondente a matricula
   */
    public String getMatricula() {
        return matricula;
    }
/** Método para atualizar amatricula do usuário 
 * @param matricula
 */
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
 /** Método que retorna a nome do usuário
   * @return String corespondente a o nome do usuario
   */
 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
 /** Método que retorna o email do usuário
   * @return String corespondente a email
   */
    public String getEmail() {
        return email;
    }
    /** Método que atualiza o email do usuário
     @param String volor do email*/

    public void setEmail(String email) {
        this.email = email;
    }
    /**Método para retorna a senha do usuário */
    public String getSenha() {
        return senha;
    }
/** Método para edita a senha do usario */
    public void setSenha(String senha) {
        this.senha = senha;
    }
/**Método retona a foto do usuario
 * @return String URL da foto do usuario
 */
    public String getFoto() {
        return foto;
    }
/** Método para atualira a foto do usuario
 * @param String nova URL da foto
 */
    public void setFoto(String foto) {
        this.foto = foto;
    }
/** Método para retorna o status do usuário
 * @return boolean status do usuário
 */
   
/**Método para edita o status do usuario
 * @param boolean stutus do usuario
 */
    public void setStatus(boolean status) {
        this.status = status;
    }
    /** retorna o papel do usuário
     * @return PapelUser
     */

    public PapelUser getPapel() {
        return papel;
    }
   /** Método para atualizar o papel do Usuário
    * @param pelUser corespondente a o papel do suario 
    */
    public void setPapel(PapelUser papel) {
        this.papel = papel;
    }

    public boolean getStatus() {
        return status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.matricula != null ? this.matricula.hashCode() : 0);
        hash = 71 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if ((this.matricula == null) ? (other.matricula != null) : !this.matricula.equals(other.matricula)) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "matricula " + matricula + ", nome " + nome + ", email" + email + ", senha " + senha + ", foto " + foto + ", status " + status + ", papel " + papel + '}';
    }

    @Override
    public int compareTo(Usuario o) {
        
      return this.nome.toUpperCase().compareTo(o.getNome().toUpperCase());
    }
    

}
