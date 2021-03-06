/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.interfaces;


import br.edu.ifpb.valueObjects.Feriado;
import java.io.File;
import java.io.InputStream;
import java.util.List;


/**
 *
 * @author José
 */
public interface InterfaceFeriadoDAO {

    public boolean adiciona(Feriado feriado);

    public boolean edita(Feriado feriado);

    public Feriado buscarPorNome(String nome);

    public List<Feriado> buscarTodos();

    public boolean importFeriado(List<Feriado> feriado);

    public boolean remover(String nome);
    
    public boolean removerData(Feriado feriado);
}
