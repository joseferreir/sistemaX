
package br.edu.ifpb.controle;

import br.edu.ifpb.factoy.DAOFactoy;
import br.edu.ifpb.medelo.Feriado;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControleFeriado {
    
    
    public boolean adiciona(Feriado feriado) {
        return DAOFactoy.criarFactoy().criaFeriadoDAO().adiciona(feriado);
    }

    public boolean edita(Feriado feriado) {
        return DAOFactoy.criarFactoy().criaFeriadoDAO().edita(feriado);

    }

    public Feriado buscarPorNome(String nome) {
        return DAOFactoy.criarFactoy().criaFeriadoDAO().buscarPorNome(nome);
    }

    public List<Feriado> buscarTodos() {
        return DAOFactoy.criarFactoy().criaFeriadoDAO().buscarTodos();
    }

    public boolean importFeriado(InputStream arquivo, boolean sobrescrever) {
       ImpoteCsv c = new ImpoteCsv();
        return DAOFactoy.criarFactoy().criaFeriadoDAO().importFeriado(c.importeCsv(arquivo, sobrescrever));
    }

    public boolean remover(String nome) {
        return DAOFactoy.criarFactoy().criaFeriadoDAO().remover(nome);

    }
}
