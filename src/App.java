import java.util.ArrayList;
import java.io.*;
import Componentes.Tabuleiro;
import Componentes.JogadorGyokushou;
import Componentes.JogadorOushou;
import Componentes.Peça;

public class App {
    public static void main(String[] args) throws Exception {
        testeEscritaLeitura0();
    }
    
    public static void testeEscritaLeitura0() {
    	// Teste de leitura e escrita de arquivos
    	ArrayList<Tabuleiro> tabuleirosSalvos = AdminArquivos.lerTodosOsTabuleiros();
    	
    	System.out.println("Há " + tabuleirosSalvos.size() + " tabuleiros salvos."); // "Há 0 tabuleiros salvos."
    	
    	// Criar tabuleiros e salvar:
    	// tabuleiro0
    	Tabuleiro tabuleiro0 = new Tabuleiro();
    	
    	if (AdminArquivos.salvarTabuleiro(tabuleiro0))
    		System.out.println("tabuleiro0 salvo!");
    	else
    		System.out.println("tabuleiro0 não foi salvo.");    	

    	// tabuleiro1
    	Tabuleiro tabuleiro1 = new Tabuleiro();
    	
    	if (AdminArquivos.salvarTabuleiro(tabuleiro1))
    		System.out.println("tabuleiro1 salvo!");
    	else
    		System.out.println("tabuleiro1 não foi salvo.");
    	
    	// tabuleiro2
    	Tabuleiro tabuleiro2 = new Tabuleiro();
    	
    	if (AdminArquivos.salvarTabuleiro(tabuleiro2))
    		System.out.println("tabuleiro2 salvo!");
    	else
    		System.out.println("tabuleiro2 não foi salvo.");
    	
    	// Modificar tabuleiro0 e salvar de novo:
    	Peça[][] novoGrid = new Peça[4][4];
    	tabuleiro0.setGrid(novoGrid);
    	
    	if (AdminArquivos.salvarTabuleiro(tabuleiro0))
    		System.out.println("tabuleiro0 atualizado!");
    	else
    		System.out.println("Erro ao atualizar tabuleiro0.");
    	
    	// Deletar tabuleiros:
    	int deletarTab2 = AdminArquivos.deletarTabuleiro(tabuleiro2);
    	
    	if (deletarTab2 == 1)
    		System.out.println("tabuleiro2 deletado!");
    	else if (deletarTab2 == 0)
    		System.out.println("tabuleiro2 não encontrado.");
    	else if (deletarTab2 == -1)
    		System.out.println("tabuleiro 2 não pôde ser deletado.");
    	
    	int deletarTodos = AdminArquivos.deletarTodosOsTabuleiros();
    	
    	if (deletarTodos == 1)
    		System.out.println("Todos os tabuleiros deletados!");
    	else if (deletarTodos == 0)
    		System.out.println("Não há tabuleiros salvos.");
    	else if (deletarTodos == -1)
    		System.out.println("Erro deletando algum tabuleiro.");
    	
    }
}
