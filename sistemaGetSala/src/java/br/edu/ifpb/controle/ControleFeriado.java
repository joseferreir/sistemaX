/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.controle;

import br.edu.ifpb.factoy.DAOFactoy;
import br.edu.ifpb.medelo.Feriado;

import java.io.File;
import java.util.List;

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

    public boolean importFeriado(File arquivo) {
       ImpoteCsv c = new ImpoteCsv();
        return DAOFactoy.criarFactoy().criaFeriadoDAO().importFeriado(c.importeCsv(arquivo));
    }

    public boolean remover(String nome) {
        return DAOFactoy.criarFactoy().criaFeriadoDAO().remover(nome);

    }
}
