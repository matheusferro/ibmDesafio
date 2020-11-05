package com.ibmDesafio.service;

import com.ibmDesafio.model.MiojoTempoModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CalculaTempoService {

    public String calculaTempo(MiojoTempoModel tempo){
        int tempoPreparo = tempo.getTempoPreparo();
        int ampulheta1 = tempo.getAmpulheta1();
        int ampulheta2 = tempo.getAmpulheta2();
        validaParametros(tempoPreparo, ampulheta1, ampulheta2);
        try {
            int tempoMinimo = numeroMenor(ampulheta1, ampulheta2);

            int tempoCorrente = Math.abs(ampulheta1 - ampulheta2); //valorMaior - valorMenor;
            if ((tempoPreparo % mdc(ampulheta1, ampulheta2) != 0)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não é possível calcular com essas ampulhetas !");
            }
            while (tempoCorrente != tempoPreparo) {
                if (ampulheta1 > ampulheta2) {
                    ampulheta1 = tempoCorrente;
                    ampulheta2 = tempo.getAmpulheta2();

                } else if (ampulheta2 > ampulheta1) {
                    ampulheta2 = tempoCorrente;
                    ampulheta1 = tempo.getAmpulheta1();

                }
                tempoMinimo += tempoCorrente;
                tempoCorrente = Math.abs(ampulheta1 - ampulheta2);
            }
            tempoMinimo += tempoPreparo;
            return String.valueOf(tempoMinimo);
        }catch(Exception error){
            error.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ocorreu um erro inesperado. Tente novamente.");
        }
    }

    private void validaParametros(int tempoPreparo, int ampulheta1, int ampulheta2){
        if(tempoPreparo < 0 || ampulheta1 < 0 ||  ampulheta2 < 0
                || tempoPreparo > ampulheta1 || tempoPreparo > ampulheta2){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não é possível calcular com esses valores!");
        }
    }

    private int numeroMenor(int ampulheta1, int ampulheta2){
        return ampulheta1 < ampulheta2 ? ampulheta1 : ampulheta2;
    }

    private int mdc(int num1, int num2) {
        int resto;
        do {
            resto = num1 % num2;
            num1 = num2;
            num2 = resto;

        } while (resto != 0);

        return num1;
    }
}
