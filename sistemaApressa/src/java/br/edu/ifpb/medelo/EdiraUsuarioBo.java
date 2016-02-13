package br.edu.ifpb.medelo;

import br.edu.ifpb.valueObjects.Usuario;
import br.edu.ifpb.DAO.UsuarioAdmDAO;
import br.edu.ifpb.execao.EmailExistenteException;
import br.edu.ifpb.execao.NomeUsuarioExistenteException;

public class EdiraUsuarioBo {

    public UsuarioAdmDAO dao;

    public boolean editaUsuario(Usuario usuario) throws EmailExistenteException, NomeUsuarioExistenteException {

        if (validaUsuario(usuario)) {
            if (dao == null) {
                dao = new UsuarioAdmDAO();
            }
            return dao.editarUsuario(usuario);
        }

        return false;

    }

    public boolean editaUsuario(Usuario usuario, String nome) {

        usuario.setNome(nome);

        return EdiraUsuarioBo.this.editaUsuario(usuario);
    }

    private boolean validaUsuario(Usuario usuario) throws EmailExistenteException, NomeUsuarioExistenteException {

        UsuarioAdmDAO dao = new UsuarioAdmDAO();

        if (usuario.getPapel() == null) {
            return false;
        }

        if (usuario.getNome() == null || usuario.getNome().trim().isEmpty()) {
            return false;
        }

        if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
            return false;
        }

        if (usuario.getMatricula() == null || usuario.getMatricula().trim().isEmpty()) {
            return false;
        }

        Usuario usuarioOriginal = dao.buscaPorEmail(usuario.getEmail());
        Usuario aux = dao.buscaPorEmail(usuario.getEmail());

        //verificar se o email existe e se pertenced ao usuario
        if (aux != null && !aux.getEmail().equals(usuarioOriginal.getEmail())) {
            throw new EmailExistenteException();
        }

        aux = dao.buscaPorEmail(usuario.getEmail());
        //verificar se o nome de usuario existe e se pertence ao usuario
        if (aux != null && !aux.getNome().equals(usuarioOriginal.getNome())) {
            throw new NomeUsuarioExistenteException();
        }

        //verifica o formato do nome
        if (!ValidaUser.validaNome(usuario.getNome())) {
            return false;
        }

        //verifica o formato do email
        if (!ValidaUser.validarEmail(usuario.getEmail())) {
            return false;
        }

        //verifica se a matricula possui 6 digitos numericos
        if (!ValidaUser.validaMatricula(usuario.getMatricula())) {
            return false;
        }

        return true;
    }

}
