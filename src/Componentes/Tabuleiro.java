package Componentes;

import java.io.*;
import java.util.Random;

public class Tabuleiro implements Serializable {
	private static final long serialVersionUID = 144L;
	private final long id = (new Random()).nextLong();
    private Jogador sente;
    private Jogador gote;
    private Peça[][] grid;

    /**
     * Construtor da classe tabuleiro
     * @param sente No shogi, Sente é o primeiro jogador a fazer uma jogada, equivalente as brancas no xadrez, vencedor do furigoma
     * @param gote No shogi, Gote é o segundo jogador a fazer uma jogada, equivalente as pretas no xadrez
     * @param grid Matriz que representa o conjunto de casas do tabuleiro, e guarda as peças, que estão nos elementos respectivos
     */
    public Tabuleiro(Jogador sente, Jogador gote) {
        this.sente = sente;
        this.gote = gote;
        this.grid = new Peça[9][9]; //! no tabuleiro de Shogi a numeração é da direita para a esquerda, de cima para baixo, logo as coordenadas não serão as mesmas da matriz
    }
    
    public Tabuleiro() { // Construtor vazio para teste de leitura e escrita. Pode sair depois.
    	this.sente = new JogadorGyokushou();
    	this.gote = new JogadorOushou();
    	this.grid = new Peça[9][9];
    }

    //métodos de get e set
    
    /**
     * @return  Sente, o jogador equivalente as brancas no xadrez, o primeiro a fazer uma jogada
     */
    public Jogador getSente() {
        return this.sente;
    }

    /**
     * @return Gote, o jogador equivalente as pretas no xadrez, o segundo a jogar
     */
    public Jogador getGote() {
        return this.gote;
    }

    /**
     * @return O endereço para a matriz do grid
     */
    public Peça[][] getGrid() {
        return this.grid;
    }
    
    /**
     * @return O id do tabuleiro.
     */
    public long getID() {
        return this.id;
    }

    /**
     * @param grid Atribui um diagrama salvo no grid ao tabuleiro
     */
    public void setGrid(Peça[][] grid) {
        this.grid = grid;
    }

    //demais métodos

    public void destacarPossiveisJogadas() {}

    /**
     * Função para testes
     */
    public static void main(String[] args) {
    }
}
