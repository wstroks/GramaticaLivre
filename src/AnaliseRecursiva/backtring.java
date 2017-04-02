/*
/*algoritmo que faz coisas fantásticas
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnaliseRecursiva;

import java.util.ArrayList;

/**
 * Classe responsável por realizar as operações de combinação para verificar se
 * a string é validada pela gramática
 *
 * @author Hugo Filho e Washington Batista
 */
public class backtring {

    /**
     * Recebe um array de strings e junta em apenas uma
     * @param original string original
     * @param substituto string se encaixará na original
     * @param index posição do encaixe
     * @return String final
     */
    public String formaPalavraChave(String original, String substituto, int index) {
        String[] splitada = original.split("");
        splitada[index] = substituto;
        String depois = juntaTudoString(splitada);

        return depois;

    }
    
     public String juntaTudoString(String[] b) {
        String i = new String();
        for (String b1 : b) {
            i = i + b1;
        }
        return i;
    }

    /**
     * Método responsável por remover as regras vazias nas expressões de
     * variação da gramática
     *
     * @param expressao expressão da gramática que será verificada
     * @return string tratada
     */
    public String trataVazios(String expressao) {

        expressao = expressao.replace("e", "");//qualquer vazio (e) é trocado por "nulo" 

        if (expressao.contains("  ")) {//se houver duas ocorrencias de espaço, troca por uma
            expressao = expressao.replace("  ", " ");
        }

        if (expressao.startsWith(" ")) {//se string começar com vazio (espaço em branco)
            expressao = expressao.substring(1, expressao.length());
        }
        if (expressao.endsWith(" ")) {//se string terminar em vazio(espaço em branco)
            expressao = expressao.substring(0, expressao.length() - 1);
        }
        return expressao;

    }

    /**
     * Método recursivo capaz de fazer TODAS as combinações possíveis da
     * gramática
     *
     * @param expressao string a ser tratada
     * @return boolean inidicando se a string passou ou não nos testes
     */
    public boolean trabalhe(String expressao) {

        String nextVar = proximaVariavel(expressao); //verifica a próxima variável existente na string
        Producao producao = trabalhoMain.gramatica.getProducao(nextVar);//pega toda array de string daquela gramática que será usado para as trocas
        String entrada = trabalhoMain.usuario;
        if (nextVar == null) {

            if (trataVazios(expressao).equals(entrada)) {//se a string recebida já é igual a string que o usuário digitou
                System.out.println(expressao);
                return true;

            } else {
                return false;

            }

        }
        int posicao = posicao(expressao); // posição que será usada nas trocas
        ArrayList<String> regras = producao.getRegras();
        for (int i = 0; i < regras.size(); i++) { // iteração das produções
            String aux2 = formaPalavraChave(expressao, regras.get(i), posicao);//forma a palavra trocando a variável por uma produção sua
            System.out.println(aux2);
            if (trataVazios(aux2).equals(entrada)) { //se a string recebida é igual a string que o usuário digitou
                return true;
            } else if (proximaVariavel(aux2) != null) {//se ainda existir uma variável
                boolean retorno = trabalhe(aux2);
                if (retorno == true) {
                    return true;
                }
            }

        }
        System.out.println("nenhuma das opções foi válida =( mas, não perca as esperanças, no próximo ciclo sua string será validada (ou não)");
        return false;//caso tudo tenha sido feito e a string n foi encontrada
    }

    /**
     * Método que verifica se existe uma variavel na string passada
     * @param palavra palavra a ser verificada
     * @return a variável encontrada ou null caso não seja encontrado nada
     */
    public String proximaVariavel(String palavra) {

        char[] x = palavra.toCharArray();

        for (int i = 0; i < x.length; i++) {

            if (Character.isUpperCase(x[i])) {
                String u = Character.toString(x[i]);
                return u;

            }
        }

        return null;
    }

    /**
     * Retorna a posicão de uma variável que foi encontrada
     * @param palavra palavra a ser verificada
     * @return posição da variável ou -1 caso não seja encontrada
     */
    public int posicao(String palavra) {

        char[] x = palavra.toCharArray();

        for (int i = 0; i < x.length; i++) {

            if (Character.isUpperCase(x[i])) {
                return i;
            }
        }

        return -1;
    }

}
