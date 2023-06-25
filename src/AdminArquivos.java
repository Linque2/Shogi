import java.io.*;

import Componentes.Tabuleiro;
import java.util.ArrayList;

/*
 * Os tabuleiros são salvos no diretório atual em arquivos com nome "tabX.dat", a começar por "tab0.dat". 
 * */

public abstract class AdminArquivos {
	// Escrita
	public static boolean salvarTabuleiro(Tabuleiro tabuleiro) {
		String nomeArquivo = nomeArquivoTabuleiro(tabuleiro);
//		System.out.println("nomeArquivo = " + nomeArquivo);
		
		if (nomeArquivo.equals(""))
			return escreverTabuleiro(tabuleiro, nomeNovoArquivoTabuleiro());
		else 
			return escreverTabuleiro(tabuleiro, nomeArquivo);
	}
	
    private static boolean escreverTabuleiro(Tabuleiro tabuleiro, String nomeArquivo) {
    	// Salva o tabuleiro no diretório atual.    	
        try {
        	ObjectOutputStream objetoSaida = new ObjectOutputStream(new FileOutputStream(nomeArquivo));
            objetoSaida.writeObject(tabuleiro);
            objetoSaida.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Leitura
    public static Tabuleiro lerTabuleiro(String nomeArquivo) {    	
    	Tabuleiro tabuleiro = null;
        try {
        	ObjectInputStream objetoEntrada = new ObjectInputStream(new FileInputStream(nomeArquivo));
        	tabuleiro = (Tabuleiro)objetoEntrada.readObject();
        } catch (ClassNotFoundException classNotFoundException) {
        	System.out.println("Classe incompatível.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tabuleiro;
    }
    
    public static Tabuleiro lerTabuleiroMaisRecente(int aPartirDe) {
    	// Devolve o tabuleiro mais recente depois do de índice aPartirDe. Retorna null se não houver nenhum. 
    	// Se aPartirDe for -1, retorna o mais recente de todos.
    	
    	int maiorIndice = indiceTabuleiroMaisRecente(aPartirDe);
        
        if (maiorIndice == -1)
        	return null;
        else
        	return lerTabuleiro("tab" + maiorIndice + ".dat");
    }
    
    public static Tabuleiro lerTabuleiroMaisRecente() {
    	// Devolve o tabuleiro mais recente de todos.
    	// Se não houver nenhum tabuleiro salvo, devolve null.
    	return lerTabuleiroMaisRecente(-1);
    }
    
    public static ArrayList<Tabuleiro> lerTodosOsTabuleiros(){
    	// Devolve uma lista com todos os objetos tabuleiros salvos no diretório atual, ordenados do mais recente ao mais antigo.
    	// Devolve uma lista vazia se não houver nenhum tabuleiro salvo.
    	
    	ArrayList<Tabuleiro> listaTabuleiros = new ArrayList<Tabuleiro>();
    	
    	// Pegar os tabuleiros, começando pelo mais recente:
    	int indiceMaisRecente = indiceTabuleiroMaisRecente();
    	Tabuleiro maisRecente = lerTabuleiroMaisRecente();
    	
    	while (maisRecente != null) {
    		listaTabuleiros.add(maisRecente);
    		maisRecente = lerTabuleiroMaisRecente(indiceMaisRecente);
    		indiceMaisRecente = indiceTabuleiroMaisRecente(indiceMaisRecente);
    	}
    	
    	return listaTabuleiros;
    }
    
    // Deletar
    public static int deletarTabuleiro(String nomeArquivo) {
    	// Deleta o arquivo. Devolve:
    	// 1 se o arquivo foi deletado;
    	// -1 se o arquivo existe mas não pôde ser deletado;
    	// 0 se o arquivo não existe.
    	
        File arquivo = new File(nomeArquivo);
        if (arquivo.exists()) {
        	if (arquivo.delete())
        		return 1;
        	return -1;
        }
        return 0;
    }
    
    public static int deletarTabuleiro(Tabuleiro tabuleiro) {
    	// Deleta o tabuleiro. Devolve:
    	// 1 se o arquivo do tabuleiro foi deletado;
    	// -1 se o arquivo existe mas não pôde ser deletado;
    	// 0 se o arquivo não existe.
    	
    	// Pegar o arquivo referente ao tabuleiro fornecido:
    	String nomeArquivo = nomeArquivoTabuleiro(tabuleiro);
    	
    	if (nomeArquivo.equals("")) // Tabuleiro não foi salvo.
    		return 0;
    	
    	// Deletar o tabuleiro encontrado:
    	return deletarTabuleiro(nomeArquivo);
    }
    
    public static int deletarTabuleiroMaisRecente() {
    	// Deleta o tabuleiro mais recente. Devolve:
    	// 1 se o arquivo do tabuleiro foi deletado;
    	// -1 se o arquivo existe mas não pôde ser deletado;
    	// 0 se o arquivo não existe.
    	
    	int indiceMaisRecente = indiceTabuleiroMaisRecente();
    	
    	if (indiceMaisRecente == -1)
    		return 0;
    	
    	return deletarTabuleiro("tab" + indiceMaisRecente + ".dat");
    }
    
    public static int deletarTodosOsTabuleiros() {
    	// Deleta o todos os arquivos dos tabuleiros. Devolve:
    	// 1 se todos foram deletados;
    	// -1 se pelo menos um arquivo existe mas não pôde ser deletado;
    	// 0 se não há nenhum arquivo.
    	
    	int resultado = 1;
    	
    	// Deletar o mais recente:
    	int deletarMaisRecente = deletarTabuleiroMaisRecente();
    	
    	if (deletarMaisRecente == 0) // Não há nenhum tabuleiro salvo.
    		return 0;
    	
    	if (deletarMaisRecente == -1) // O tabuleiro mais recente não pôde ser deletado. 
    		resultado = -1;    	
    	
    	// Deletar todos os outros:
    	while (deletarMaisRecente != 0) {
    		deletarMaisRecente = deletarTabuleiroMaisRecente();
    	}
    	
    	return resultado;
    }
    
    // Auxiliares
    private static String nomeNovoArquivoTabuleiro() {
    	// Devolve o nome do novo arquivo.
    	String nomeUltimoTabuleiro = ultimoTabuleiroSalvo();
    	int indiceUltimoTabuleiro = pegarIndiceDoNome(nomeUltimoTabuleiro);    	
    	indiceUltimoTabuleiro++;
    	String nomeNovoTabuleiro = "tab" + indiceUltimoTabuleiro + ".dat";
    	return nomeNovoTabuleiro;
    }
    
    private static String ultimoTabuleiroSalvo() {
    	// Devolve o nome do último tabuleiro salvo no diretório atual, i.e., aquele com maior X em "tabX.dat".
    	// Devolve "" se não houver nenhum tabuleiro salvo.
    	
    	int indiceMaisRecente = indiceTabuleiroMaisRecente();

    	if (indiceMaisRecente == -1)
    		return "";    	
        return "tab" + indiceMaisRecente + ".dat";
    }

    private static String nomeArquivoTabuleiro(Tabuleiro tabuleiro) {
    	// Devolve o nome do arquivo em que está salvo o tabuleiro.
    	// Devolve "" se o tabuleiro não estiver salvo.
    	String nomeArquivo = "";
    	int maiorIndiceAntes = indiceTabuleiroMaisRecente();
    	int maiorIndiceDepois = maiorIndiceAntes;
    	
    	if (maiorIndiceAntes == -1) // Não há tabuleiros salvos.
    		return nomeArquivo;
    	
    	do {
    		Tabuleiro tab = lerTabuleiro("tab" + maiorIndiceAntes + ".dat");
    		
    		if (tab != null && tab.getID() == tabuleiro.getID())
    			nomeArquivo = "tab" + maiorIndiceAntes + ".dat";
    		else {
    			int aux = maiorIndiceAntes;
    			maiorIndiceAntes = maiorIndiceDepois;
    			maiorIndiceDepois = indiceTabuleiroMaisRecente(aux);
    		}    			
    	} while (nomeArquivo.equals("") && maiorIndiceAntes != maiorIndiceDepois);
    	
    	return nomeArquivo;
    }
    
    private static int indiceTabuleiroMaisRecente(int aPartirDe) {
    	// Devolve o índice do tabuleiro mais recente salvo no diretório e mais antigo que aPartirDe.
    	// Se aPartirDe for -1, devolve o mais recente de todos.
    	// Devolve -1 se não houver nenhum salvo.
    	
    	String diretorioAtual = System.getProperty("user.dir");

        // Criar um objeto File para o diretório atual
        File diretorio = new File(diretorioAtual);

        // Pegar todos os arquivos no diretório
        File[] arquivos = diretorio.listFiles();
        
        int maiorIndice = -1;

        if (arquivos != null) {
            // Procurar o tabuleiro de maior índice:
            for (File arquivo : arquivos) {
                if (arquivo.isFile()) {
                	String nomeArquivo = arquivo.getName();
                	int indice = pegarIndiceDoNome(nomeArquivo);
                	
                	if (indice != -1) // É um nome no formato "tabX.dat"
                		if (indice > maiorIndice && (indice < aPartirDe || aPartirDe == -1))
                			maiorIndice = indice;
                }
            }
        }        
        return maiorIndice;
    }
    
    private static int pegarIndiceDoNome(String nomeArquivo) {
    	// Devolve o X em "tabX.dat"
    	// Devolve -1 se a string não for no formato "tabX.dat"
    	
    	if (nomeArquivo.length() < 8) // String curta demais.
    		return -1;
    	
    	if (!nomeArquivo.substring(0, 3).equals("tab")) // String não começa com "tab".
    		return -1;
    	    	    	
    	String indiceString = nomeArquivo.substring(3); // Tirar os três primeiros caracteres ("tab").
    	
    	if (!indiceString.substring(indiceString.length() - 4, indiceString.length()).equals(".dat")) // String não termina com ".dat"
    		return -1;
    	
    	indiceString = indiceString.substring(0, indiceString.length() - 4); // Tirar os quatro últimos caracteres (".dat").
    	
    	int indice = -1;

    	try {
    		indice = Integer.parseInt(indiceString);
    	} catch (NumberFormatException e) {
    		return indice;
    	}    	
    	return indice;
    }
    
    private static int indiceTabuleiroMaisRecente() {
    	// Devolve o índice do tabuleiro mais recente salvo.
    	// Devolve -1 se não houver nenhum tabuleiro salvo.
    	return indiceTabuleiroMaisRecente(-1);
    }
}