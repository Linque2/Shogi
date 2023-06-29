import java.util.ArrayList;
import java.util.Scanner;
import Componentes.*;

public class Main {
//	private static ArrayList<Tabuleiro> jogosAbertos;
	
    public static void main(String[] args){  
    	ArrayList<Tabuleiro> jogosAbertos = new ArrayList<Tabuleiro>();
    	// Menu
    	Menu.main(args, jogosAbertos);
    }

    public static class Menu {
        public static void main(String[] args, ArrayList<Tabuleiro> jogosAbertos) {
            Scanner scanner = new Scanner(System.in);
            MenuOperacoes menu = MenuOperacoes.HOME;

            while (menu != MenuOperacoes.SAIR) {
            	// Mostrar o menu
                System.out.println(menu.texto());

                // Pegar o input do usuário
                String input = scanner.nextLine();
                // Tirar todos os caracteres não numéricos
                input = input.replaceAll("[^0-9]", "");
                
                if (input.isEmpty())
                	System.out.println("Entrada inválida. Por favor selecione uma das opções listadas.");
                else {
                	try {
                		int inputInt = Integer.valueOf(input);
                    	// Processar o input
                    	menu = menu.processarInput(inputInt, scanner, jogosAbertos);
                    } catch (NumberFormatException e) {
                    	System.out.println("Entrada inválida. Por favor informe um valor numérico.");
                    }
                }
            }

            scanner.close();
        }
    
        
        public static void novoJogo(Scanner scanner) {
        	// Cria um tabuleiro novo.
        	
        	// Pegar os jogadores:
        	JogadorOushou oushou = getOushou(scanner);
        	JogadorGyokushou gyokushou = getGyokushou(scanner);
        	
        	// Criar o jogo, salvar e mostrar a interface gráfica.
        	Tabuleiro novoTabuleiro = new Tabuleiro(oushou, gyokushou);
        	AdminArquivos.salvarTabuleiro(novoTabuleiro);
        	
        	// Mostrar o novo tabuleiro na GUI.
			ShogiGUI gui = new ShogiGUI(novoTabuleiro);
        }
        
        public static boolean listarJogosSalvos() {
        	// Imprime todos os jogos salvos. Retorna true se houver pelo menos um jogo, false caso contrário.
        	
        	// Pegar jogos salvos:
        	ArrayList<Tabuleiro> jogosSalvos = AdminArquivos.lerTodosOsTabuleiros();
        	
        	if (jogosSalvos.size() == 0) {
        		System.out.println("Não há nenhum jogo salvo.");
        		return false;
        	} else {
        		for (Tabuleiro jogo : jogosSalvos)
        			System.out.println(jogo);
        		return true;
        	}
        }
        
        public static void abrirJogo(Scanner scanner, ArrayList<Tabuleiro> jogosAbertos) {
        	// Pegar jogo do terminal:
        	Tabuleiro jogo = getJogoSalvo(scanner);
        	
        	if (jogo == null)
        		return;
        	
        	// Abrir jogo na GUI.
        	jogosAbertos.add(jogo);
			ShogiGUI gui = new ShogiGUI(jogo);
		}
        
        public static void salvarJogo(Scanner scanner, ArrayList<Tabuleiro> jogosAbertos) {
        	// Salva o jogo.
        	
        	if (jogosAbertos.size() == 0) {
        		System.out.println("Nenhum jogo está aberto.");
        		return;
        	}
        	
        	// Listar todos os jogos para o usuário consultar o ID:
        	for (Tabuleiro jogo : jogosAbertos) {
        		System.out.println(jogo);
        	}
        	
        	// Pegar a ID do jogo do terminal:
        	Tabuleiro jogo = getJogoAberto(scanner, jogosAbertos);
        	
        	if (jogo == null) // Jogo especificado não foi encontrado.
        		return;
        	
        	if (AdminArquivos.salvarTabuleiro(jogo))
        		System.out.println("Jogo salvo com sucesso!");
        	else 
        		System.out.println("O jogo não pôde ser salvo.");
        }
        
        public static void deletarJogo(Scanner scanner) {
        	// Pegar jogo do terminal:
        	Tabuleiro jogo = getJogoSalvo(scanner);
        	int deletar = AdminArquivos.deletarTabuleiro(jogo);
        	
        	if (deletar == 1)
        		System.out.println("Jogo deletado com sucesso!");
        	else if (deletar == 0)
        		System.out.println("O arquivo do jogo não foi encontrado.");
        	else if (deletar == -1)
        		System.out.println("O jogo não pôde ser deletado");        	
        }

        public static void deletarTodosOsJogos() {
        	// Deleta os arquivos de todos os jogos.
        	
        	ArrayList<Integer> resultado = AdminArquivos.deletarTodosOsTabuleiros();
        	// resultado = [# jogos deletados, # jogos não encontrados, # jogos não deletados].
        	
        	if (resultado == null) {
        		System.out.println("Nenhum jogo foi encontrado.");
        		return;
        	}
        	
        	if (resultado.get(1) == 0 && resultado.get(2) == 0) {
        		System.out.println("Todos os jogos foram deletados!");
        		return;
        	}
        	
        	int nJogos = resultado.get(0) + resultado.get(1) + resultado.get(2);
        	// Imprimir mensagem do resultado:
        	System.out.println(String.format("%d/%d foram deletados\n%d/%d não foram encontrados\n%d/%d não puderam ser deletados", 
        			resultado.get(0), nJogos, resultado.get(1), nJogos, resultado.get(2), nJogos));
        }
        
        private static Tabuleiro getJogo(Scanner scanner, ArrayList<Tabuleiro> listaJogos) {
        	// Pega um jogo do terminal. Retorna null se a id fornecida não for um long
        	// ou se nenhum jogo tiver a id fornecida.
        	long id = getID(scanner);
        	
        	if (id == -1)
        		return null;
        	
        	// Procurar jogo com a id fornecida:        	
        	for (Tabuleiro jogo : listaJogos)
        		if (jogo.getID() == id)
        			return jogo;
        	return null;
        }
        
        private static Tabuleiro getJogoSalvo(Scanner scanner) {
        	// Pega um tabuleiro da lista de jogos salvos
        	return getJogo(scanner, AdminArquivos.lerTodosOsTabuleiros());
        }
        
        private static Tabuleiro getJogoAberto(Scanner scanner, ArrayList<Tabuleiro> jogosAbertos) {
        	// Pega um tabuleiro da lista de jogos abertos
        	return getJogo(scanner, jogosAbertos);
        }
        
        private static long getID(Scanner scanner) {
        	// Pega uma long do terminal. Se a entrada for inválida, retorna -1;
        	
        	System.out.println("Digite a ID do jogo:");
        	String entrada = scanner.nextLine();
            long id = -1;
            
            try {
            	id = Long.parseLong(entrada);
            } catch (NumberFormatException e) {
            	System.out.println("Entrada inválida. Por favor informe um valor numérico.");
            }
            
            return id;
        }
    
        private static JogadorOushou getOushou(Scanner scanner) {
        	// Pega um jogador oushou do terminal. Se ele não existir, cria um jogador novo.
        	
        	System.out.println("Nome do oushou:");
        	String nome = scanner.nextLine();
        	
        	// Procurar o jogador nos jogos salvos:
        	ArrayList<Tabuleiro> jogosSalvos = AdminArquivos.lerTodosOsTabuleiros();
        	
        	for (Tabuleiro jogo : jogosSalvos)
        		if (jogo.getOushou().getNome().equals(nome))
        			return jogo.getOushou();
        	
        	JogadorOushou oushou = new JogadorOushou(nome, 0, false);
        	return oushou;
        }
        
        private static JogadorGyokushou getGyokushou(Scanner scanner) {
        	// Pega um jogador oushou do terminal. Se ele não existir, cria um jogador novo.
        	
        	System.out.println("Nome do gyokushou:");
        	String nome = scanner.nextLine();
        	
        	ArrayList<Tabuleiro> jogosSalvos = AdminArquivos.lerTodosOsTabuleiros();
        	
        	for (Tabuleiro jogo : jogosSalvos)
        		if (jogo.getGyokushou().getNome().equals(nome))
        			return jogo.getGyokushou();
        	
        	JogadorGyokushou gyokushou = new JogadorGyokushou(nome, 0, false);
        	return gyokushou;
        }
        
//        private static void listarJogosAbertos() {
//        	for (Tabuleiro jogo : jogosAbertos) {
//        		System.out.println(jogo);
//        	}
//        }
    }
}