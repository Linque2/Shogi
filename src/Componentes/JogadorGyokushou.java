package Componentes;

import java.io.*;
import java.util.ArrayList;

public class JogadorGyokushou extends Jogador implements Serializable {
	private static final long serialVersionUID = 576L;
    
    public JogadorGyokushou(String nome, int score, boolean eh_sente) {
        super(nome, score, eh_sente);
    }
    
    public JogadorGyokushou() { // Construtor vazio para teste de leitura e escrita. Pode sair depois.
        super();
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
            for (int linha = 0; linha < 8; linha++) { 
                for (int coluna : colunasSemPeao) {
                        if (tabuleiro.getGrid()[linha][coluna] != null && !(tabuleiro.getGrid()[linha+1][coluna] instanceof Rei)) {
                            Coordenada coordenada = new Coordenada(linha, coluna);
                            movesValidos.add(coordenada);
                        }
                }
            }
        } else if (peça instanceof Cavalo || peça instanceof Lanceiro) { // Não é permitido colocar um cavalo ou um lanceiro na última linha
            for (int linha = 0; linha < 8; linha++) {
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