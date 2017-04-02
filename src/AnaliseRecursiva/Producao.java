package AnaliseRecursiva;

import java.util.ArrayList;

/*
Classe responsável de ter toda a logica de variavel e regras
*/
public class Producao {
	
	private String variavel;
	private ArrayList<String> regras;
	
	public Producao(String variavel,ArrayList<String> regras ){
		this.variavel = variavel;
		this.regras = (ArrayList<String>) regras.clone();
	}
	
        /*
        Caso exista novas regras para um determinada variavel
        */
	public void adicionarRegra(String regra){
		
		if(regras.indexOf(regra) == -1){
			regras.add(regra);
		}
	}
	
	
	public String getVariavel() {
		return this.variavel;
	}
	public ArrayList<String> getRegras() {
		return this.regras;
	}
        public int tamanhoRegras(){
            return regras.size();
        }

	
	public void setVariavel(String variavel) {
		this.variavel = variavel;
	}
	public void setRegras(ArrayList<String> regras) {
		this.regras = (ArrayList<String>) regras.clone();
	}

        @Override 
        public String toString(){
            return variavel;
        }
}