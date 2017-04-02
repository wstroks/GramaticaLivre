package AnaliseRecursiva;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author Washington e Hugo
 */

public class ManipulaArquivo {
		
    
   // Essa classe é responsável por manipular todo o txt 

	/*
            método responsavel por procurar se a variavel já existe ou não caso exista irá mandar -1
        */
	private static int buscarProducao(String variavel, ArrayList<Producao> gramatica){
		
		int indice = 0;
		for (Producao producao : gramatica){
			if(producao.getVariavel().equals(variavel)){
				return indice;
			}
			indice++;
		}
		return -1;
	}
	/*
        método responsável pela leitura do txt, abertura e a entrada .
        */
	public static ArrayList<Producao> arquivoLeitura(String caminho){
		
		try {
			BufferedReader buffRead = new BufferedReader(new FileReader(caminho));
			String linha;
			ArrayList<Producao> gramatica = new ArrayList<Producao>();
			String variavel;
			List<String> regras;
			int indiceProducao;
			do {
				linha = buffRead.readLine();
				if (linha != null) { 
					
                                        //recebe a variavel e as regras e quebra
					linha = linha.trim();
					variavel = String.valueOf(linha.charAt(0));
					regras = Arrays.asList(linha.split(":=")[1].split("\\|"));
					indiceProducao = buscarProducao(variavel, gramatica); 
					if(indiceProducao == -1){
						
                                                //caso não exista a variavel, é adicionado a nova gramatica no array
						gramatica.add(new Producao(variavel, new ArrayList<String>(regras)));
					}
					else{
						
                                                // caso existe um A:=a e ao percorrer a lista achou se A:=e 
                                                //é adicionado no mesmo a A:=a|e
						Producao producao = gramatica.get(indiceProducao);
						for(String regra : regras){
							producao.adicionarRegra(regra);
						}
					} 
				} 
			} while (linha != null);
			
			buffRead.close();
			return gramatica;

		} catch (IOException e) {
			System.out.println("Arquivo não encontrado!");
			return null;
		}
	}
	
	

}