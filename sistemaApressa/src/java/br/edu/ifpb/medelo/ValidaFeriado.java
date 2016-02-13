/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.medelo;

import br.edu.ifpb.valueObjects.Feriado;
import br.edu.ifpb.DAO.FeriadoDAO;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author José
 */
public class ValidaFeriado {

    public static boolean verificarFeriado(Feriado feriado) {
        Pattern ptt = Pattern.compile("[A-Za-z0-9á-ú ]+");
        Matcher matcher = ptt.matcher(feriado.getNome());

        return matcher.matches();

    }

    public static boolean feriadoRepetido(Feriado feriado) {
        boolean repetido = false;
        FeriadoDAO dao = null;

        Map<String, String> map = new HashMap<String, String>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/DD");

        map.put("data", sdf.format(feriado.getData()));

        if (dao == null) {
            dao = new FeriadoDAO();
        }

        if (!dao.buscarAtributos(map).isEmpty()) {
            repetido = true;
        }

        return repetido;
    }

}
