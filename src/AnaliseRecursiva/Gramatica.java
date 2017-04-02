/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnaliseRecursiva;

import java.util.ArrayList;

/**
 *
 * @author Washington e Hugo
 */
/*
Essa classe é responsável por receber toda a gramática seja ele variavel ou regra..

*/
public class Gramatica {
    ArrayList<Producao> gramatica = new ArrayList();
    /*
    Retorna um array de producao... que está contido tanto Variavel e Regra.. da gramatica
    */
    public Gramatica(ArrayList<Producao> gramatica){
        this.gramatica =  gramatica;
    }
    /*
    retorna um elemento especifico da gramatica
    */
    public Producao getElemento(int posicao){
        return gramatica.get(posicao);
    }
    public ArrayList<Producao> getElementos(){
        return gramatica;
    }
    /*
    Encontra a Variavel e retorna seu objeto .. com suas regras
    */
    public Producao getProducao(String a){
        for(Producao p: gramatica){
            if(p.getVariavel().equals(a)){
                     return p;
            }
        }
        
        return null;
    }
}
