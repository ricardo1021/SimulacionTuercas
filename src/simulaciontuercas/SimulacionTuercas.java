/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulaciontuercas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author RICARDO
 */
public class SimulacionTuercas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DecimalFormat dec = new DecimalFormat("0.0000");

        Integer n = 0;
        Float uA;
        Float uB;
        Double radioA;
        Double radioB;
        Integer aux = null;

        List<Double> listaRadioA = new ArrayList<>();
        List<Double> listaRadioB = new ArrayList<>();
        List<Double> listaRadioAFinal = new ArrayList<>();
        List<Double> listaRadioBFinal = new ArrayList<>();

        System.out.println("Ingrese número de parejas a evaluar-> ");
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(entrada.readLine());

        } catch (IOException e) {
        }

        for (int i = 0; i < n; i++) {
            uA = (float) Math.random();
            uB = (float) Math.random();
            radioA = 100 - ((Math.log(1 - uA)) / 50);
            radioB = 100 + (0.05 * uB);

            listaRadioA.add(radioA);
            listaRadioB.add(radioB);
            listaRadioAFinal.add(radioA - 100);
            listaRadioBFinal.add(radioB - 100);

        }

        Collections.sort(listaRadioA);
        Collections.sort(listaRadioB);

        for (int i = 0; i < listaRadioB.size(); i++) {
            for (int j = 0; j < listaRadioA.size(); j++) {
                if (listaRadioB.get(i) > listaRadioA.get(j)) {
                    listaRadioAFinal.add(listaRadioA.get(j));
                }
            }
            listaRadioBFinal.add(listaRadioB.get(i));
        }

        for (int i = 0; i < listaRadioA.size(); i++) {
//            System.out.println("Tornillo: "+dec.format(listaRadioA.get(i))+"\t"+"Tuerca: "+dec.format(listaRadioB.get(i)));
            System.out.println("Tornillo: " + dec.format(listaRadioA.get(i)) + "\t" + "Tuerca: " + dec.format(listaRadioB.get(i)));
        }

        for (int i = 0; i < listaRadioB.size(); i++) {
            aux = ((listaRadioAFinal.size() * 100)/n);
            System.out.println("Tornillo: " + dec.format(listaRadioAFinal.get(i)) + " con Tuerca: " + dec.format(listaRadioBFinal.get(i)));
        }
        System.out.println("% Defectuosos: " + aux);
    }
}