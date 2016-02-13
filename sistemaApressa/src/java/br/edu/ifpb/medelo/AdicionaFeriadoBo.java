package br.edu.ifpb.medelo;

import br.edu.ifpb.valueObjects.Feriado;
import br.edu.ifpb.DAO.FeriadoDAO;
import br.edu.ifpb.execao.FeriadoException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdicionaFeriadoBo {
    
    private FeriadoDAO dao;
    
    public boolean addFeriado(Feriado feriado, boolean sobrescrever) throws FeriadoException {
        
        if (FeriadoBo.validaFeriado(feriado)) {
            if (dao == null) {
                dao = new FeriadoDAO();
            }
            
            if (sobrescrever) {
                
                if (dao == null) {
                    dao = new FeriadoDAO();
                }
                
                if (ValidaFeriado.feriadoRepetido(feriado)) {
                    dao.removerData(feriado);
                    if (!dao.adiciona(feriado)) {
                        throw new FeriadoException();
                    }
                }
            }
            
            return dao.adiciona(feriado);
        } else {
            throw new FeriadoException();
        }
        
    }
    
    public boolean addFeriados(InputStream iSferiados, boolean sobrescrever) throws FeriadoException {
        Scanner in = new Scanner(iSferiados, "UTF-8");
        String s;
        List<Feriado> feriados = new ArrayList<>();
        
        while (in.hasNext()) {
            String linha = in.nextLine();
            String[] dados = linha.split(",");
            
            Feriado feriado = new Feriado();
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                feriado.setData(ConversoDeStringEmLocalDate.converteStringEmLocalDate(dados[0]));
                feriado.setNome(dados[1]);
                feriados.add(feriado);
            } catch (Exception ex) {
                throw new FeriadoException();
            }
            if (!FeriadoBo.validaFeriado(feriado)) {
                throw new FeriadoException();
            }
            
        }
        
        for (Feriado f : feriados) {
            addFeriado(f, sobrescrever);
        }
        
        return true;
    }

    
    public boolean addFeriados(String pathArquivoFeriados, boolean sobrescrever) throws FileNotFoundException, IOException, ParseException, FeriadoException {        
        
        return AdicionaFeriadoBo.this.addFeriados(new FileInputStream(pathArquivoFeriados), sobrescrever);
        
    }
    
}
