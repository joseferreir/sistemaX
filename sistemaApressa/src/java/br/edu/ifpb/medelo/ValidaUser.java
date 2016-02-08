/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.medelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author José
 */
public class ValidaUser {

    private final static String EXPRESSAO_REGULAR_SENHA_FORTE = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$";
    private final static String EXPRESSAO_REGULAR_EMAIL = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
    private final static String EXPRESSAO_REGULAR_MATRICULA = "[0-9]{6}";

    public static boolean validaPassword(final String password) {

        Pattern p = Pattern.compile(EXPRESSAO_REGULAR_SENHA_FORTE);
        Matcher m = p.matcher(password);
        return m.matches();
    }

    public static boolean validarEmail(String email) {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            Pattern pattern = Pattern.compile(EXPRESSAO_REGULAR_EMAIL, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;

    }

    public static boolean validaMatricula(String matricula) {

        Pattern pattern = Pattern.compile(EXPRESSAO_REGULAR_MATRICULA);

        Matcher matcher = pattern.matcher(matricula);
        if (matcher.find() && matcher.group().equals(matricula)) {
            System.out.println("matricula válido");
            return true;
        } else {
            System.out.println("mat inválido");
            return false;
        }
    }

   
}
