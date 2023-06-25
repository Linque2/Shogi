package Componentes;

import java.io.*;
import java.util.Random;

public class Tabuleiro implements Serializable {
	private static final long serialVersionUID = 144L;
	private final long id = (new Random()).nextLong(); // Para encontrar o tabuleiro quando ele for salvo a um arquivo.
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
        this.grid = new Peça[9][9]; // No tabuleiro de Shogi a numeração é da direita para a esquerda, de cima para baixo. Logo,
        // as coordenadas não serão as mesmas da matriz.
    }
    
    public Tabuleiro(JogadorOushou oushou, JogadorGyokushou gyokushou) {
        this.grid = new Peça[9][9];
        furigoma(gyokushou, oushou);
    }
    
    public Tabuleiro() { 
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
    
    public void setSente(Jogador jogador) {
        this.sente = jogador;
    }

    /**
     * @return Gote, o jogador equivalente as pretas no xadrez, o segundo a jogar
     */
    public Jogador getGote() {
        return this.gote;
    }
    
    public void setGote(Jogador jogador) {
    	this.gote = jogador;
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

    public boolean estaNoTabuleiro(Coordenada coordenada) {
        if ((coordenada.getC_x() >= 0 && coordenada.getC_x() <= 8) && (coordenada.getC_y() >= 0 && coordenada.getC_y() <= 8))
            return true;
        else    
            return false;
    }
    
    /**
     * No Shogi, o Furigoma é a maneira de determinar quem é o primeiro a jogar (Sente) e quem joga em seguida (Gote).
     * O Oushou, jogador com maior score, arremessa 5 peões
     * se o número de peões com a face padrão virada para cima for maior ou igual a 3, o Oushou começa a partida
     * caso o número de peões com a face promovida virada para cima for maior ou igual a 3, o Gyokushou começa a partida
     */
    public void furigoma(Jogador gyokushou, Jogador oushou) {
    	// Simula o furigoma e estabelece sente e gote.
        Random random = new Random();
        int numCartasPadrao = random.nextInt(6);
        
        if (numCartasPadrao >= 3) {
            gyokushou.setEh_sente(false);
            oushou.setEh_sente(true);
            setSente(oushou);
            setGote(gyokushou);
        } else {
            gyokushou.setEh_sente(true);
            oushou.setEh_sente(false);
            setSente(gyokushou);
            setGote(oushou);
        }
    }

    /**
     * Função para testes
     */
    public static void main(String[] args) {
    }
}
