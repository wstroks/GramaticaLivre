/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnaliseRecursiva;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author wstro
 */
public class trabalhoMain {

    /**
     */
    public static Gramatica gramatica;
    public static String usuario;
    public static boolean verifica = false;

    public static void main(String[] args) {

        gramatica = new Gramatica(ManipulaArquivo.arquivoLeitura("arquivo.txt"));
        Scanner entrada = new Scanner(System.in);

        System.out.println("digite a string");
        usuario = entrada.nextLine();

        ArrayList<Producao> a = gramatica.getElementos();

        backtring vai = new backtring();
        ArrayList<String> regra = a.get(0).getRegras();

        for (int i = 0; i < regra.size(); i++) {
            verifica = vai.trabalhe(regra.get(i));
            if (verifica == true) {
                System.out.println("Sua String foi validada!!!!!");
                break;
            }
            if (i == regra.size() - 1 && verifica == false) {
                System.out.println("Poxa =( a gramática não aceitou a sua string por favor, tente novamente");
            }
        }

        {

        }
    }

}
