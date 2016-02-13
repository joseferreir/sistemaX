/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.medelo;

import br.edu.ifpb.execao.FeriadoException;
import static br.edu.ifpb.medelo.ConversoDeStringEmLocalDate.converteStringEmLocalDate;
import br.edu.ifpb.valueObjects.Feriado;
import br.edu.ifpb.medelo.ValidaFeriado;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author José
 */
class ImpoteCsv {

    public List<Feriado> importeCsv(InputStream inputferiados, boolean sobrescrever) {
        Scanner in = new Scanner(inputferiados, "UTF-8");
        String s;
        List<Feriado> feriados = new ArrayList<>();

        while (in.hasNext()) {
            String linha = in.nextLine();
            String[] dados = linha.split(",");

            Feriado feriado = new Feriado();

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                feriado.setData(converteStringEmLocalDate(dados[0]));
                feriado.setNome(dados[1]);
                feriados.add(feriado);
            } catch (Exception ex) {
                throw new FeriadoException();
            }
            if (!ValidaFeriado.verificarFeriado(feriado)) {
                throw new FeriadoException();
            }

        }

        return feriados;
    }

}
