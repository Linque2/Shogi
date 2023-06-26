package Componentes;
import java.util.*;
import java.io.*;

public class JogadorOushou extends Jogador implements Serializable {
	private static final long serialVersionUID = 729L;
    
    public JogadorOushou(String nome, int score, boolean eh_sente) {
        super(nome, score, eh_sente);
    }
    
    public JogadorOushou() { // Construtor vazio para teste de leitura e escrita. Pode sair depois.
        super();
    }

    /**
     * No Shogi, o Furigoma é a maneira de determinar quem é o primeiro a jogar (Sente) e quem joga em seguida (Gote).
     * O Oushou, jogador com maior score, arremessa 5 peões
     * se o número de peões com a face padrão virada para cima for maior ou igual a 3, o Oushou começa a partida
     * caso o número de peões com a face promovida virada para cima for maior ou igual a 3, o Gyokushou começa a partida
     * @return o jogador Sente (quem começa a partida)
     */
    public Jogador Furigoma(Jogador gyokushou, Jogador oushou) {
        Random random = new Random();
        int numCartasPadrao = random.nextInt(6);
        if (numCartasPadrao >= 3) {
            gyokushou.setEh_sente(false);
            oushou.setEh_sente(true);
            return oushou;  
        }
        else {
            gyokushou.setEh_sente(true);
            oushou.setEh_sente(false);
            return gyokushou;        
        }
    }

    /**
     * @return Lista de Coordenadas em que é possível colocar a peça
     */
    public ArrayList<Coordenada> colocarPeça(Tabuleiro tabuleiro, Peça peça) {
        peça.setPromovida(false); // Só é permitido colocar peças não promovidas
        ArrayList<Coordenada> movesValidos = new ArrayList<Coordenada>(); // Lista das coordenadas em que é o possível colocar a peça
        if (peça instanceof Peão) { // Se a peça for um peão há várias restrições:
            /**
             * Não pode ser inserido na última linha
             * Não pode ser inserido em casas de uma coluna que já possui um peão não promovido do jogador
             * Não pode ser inserido em uma casa em que ocorra cheque-mate
             */

            // Criando uma lista com todos os numeros de coluna
            ArrayList<Integer> colunasSemPeao = new ArrayList<Integer>();
            for (int i = 0; i < 9; i++)
                colunasSemPeao.add(i);

            // Passando por todas as casas do tabuleiro para ver quais colunas já possuem um peão não promovido do jogador
            for (int linha = 0; linha < 9; linha++) {
                for (int coluna = 0; coluna < 9; coluna++) {
                    if (tabuleiro.getGrid()[linha][coluna] instanceof Peão && tabuleiro.getGrid()[linha][coluna].getPromovida() == false && tabuleiro.getGrid()[linha][coluna].getJogador() == this) {
                        colunasSemPeao.remove(coluna);
                    }
                }
            }         

            // Passando por todas as casas, com excessão da última linha   
            for (int linha = 1; linha < 9; linha++) { 
                for (int coluna : colunasSemPeao) {
                        if (tabuleiro.getGrid()[linha][coluna] != null && !(tabuleiro.getGrid()[linha-1][coluna] instanceof ReiJoia)) {
                            Coordenada coordenada = new Coordenada(linha, coluna);
                            movesValidos.add(coordenada);
                        }
                }
            }
        } else if (peça instanceof Cavalo || peça instanceof Lanceiro) { // Não é permitido colocar um cavalo ou um lanceiro na última linha
            for (int linha = 1; linha < 9; linha++) {
                for (int coluna = 0; coluna < 9; coluna++) {
                    if (tabuleiro.getGrid()[linha][coluna] != null) {
                        Coordenada coordenada = new Coordenada(linha, coluna);
                        movesValidos.add(coordenada);
                    }
                }
            }
        } else {
            for (int linha = 0; linha < 9; linha++) {
                for (int coluna = 0; coluna < 9; coluna++) {
                    if (tabuleiro.getGrid()[linha][coluna] != null) {
                        Coordenada coordenada = new Coordenada(linha, coluna);
                        movesValidos.add(coordenada);
                    }
                }
            }            
        }
        return movesValidos;
    }
}
