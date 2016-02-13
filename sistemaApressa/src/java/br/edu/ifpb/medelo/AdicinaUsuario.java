package br.edu.ifpb.medelo;

import br.edu.ifpb.valueObjects.Usuario;
import br.edu.ifpb.DAO.UsuarioAdmDAO;
import br.edu.ifpb.enums.PapelUser;
import br.edu.ifpb.execao.EmailExistenteException;
import br.edu.ifpb.execao.NomeUsuarioExistenteException;

public class AdicinaUsuario {

    private UsuarioAdmDAO dao;

    public boolean addUsuario(Usuario usuario) throws EmailExistenteException, NomeUsuarioExistenteException {
        if (ValidaUsuario(usuario)) {
            if (dao == null) {
                dao = new UsuarioAdmDAO();
            }
            return dao.addUsuario(usuario);
        }

        return false;

    }

    public boolean addUsuario(String nome, String email, String senha, String matricula, PapelUser tipo) throws EmailExistenteException, NomeUsuarioExistenteException {

        Usuario usuario = new Usuario();

        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setPapel(tipo);
        usuario.setMatricula(matricula);

        return AdicinaUsuario.this.addUsuario(usuario);
    }

    private boolean ValidaUsuario(Usuario usuario) throws EmailExistenteException, NomeUsuarioExistenteException {

        UsuarioAdmDAO DAO = new UsuarioAdmDAO();

        if (usuario.getPapel() == null) {
            return false;
        }

        if (usuario.getNome() == null || usuario.getNome().trim().isEmpty()) {
            return false;
        }

        if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
            return false;
        }

        if (usuario.getSenha() == null || usuario.getNome().trim().isEmpty()) {
            return false;
        }

        if (usuario.getMatricula() == null || usuario.getMatricula().trim().isEmpty()) {
            return false;
        }

        //verificar se o email existe
        if (DAO.buscaPorEmail(usuario.getEmail()).getEmail() == usuario.getEmail()) {
            throw new EmailExistenteException();
        }

        //verificar se o nome de usuario ja existe
        //  if (dao.buscaPorEmail(usuario.getEmail()).getNome() == usuario.getNome()) {
        //    throw new NomeUsuarioExistenteException();
        //}
        //verifica o formato do nome
        if (!ValidaUser.validaNome(usuario.getNome())) {
            System.out.println("p1");
            return false;
        }

        //verifica o formato do email
        if (!ValidaUser.validarEmail(usuario.getEmail())) {
            System.out.println("p2");
            return false;
        }

        //verifica se a senha possui ao menos 8 caracteres
        if (usuario.getSenha().length() < 8) {
            System.out.println("p3");
            return false;
        }

//        verifica se possui ao menos 1 caractere não alfabetico
        if (!ValidaUser.validaPassword(usuario.getSenha())) {
            System.out.println("p4");
            return false;
        }

        //verifica se a matricula possui 6 digitos numericos
        if (!ValidaUser.validaMatricula(usuario.getMatricula())) {
            System.out.println("p5");
            return false;
        }

        return true;
    }

}
