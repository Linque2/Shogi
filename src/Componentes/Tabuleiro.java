package Componentes;

import java.io.*;
import java.util.Random;

public class Tabuleiro implements Serializable {
	private static final long serialVersionUID = 144L;
	private final long id = Math.abs((new Random()).nextLong()); // Para encontrar o tabuleiro quando ele for salvo a um arquivo.
    private JogadorOushou oushou;
    private JogadorGyokushou gyokushou;
    private Peça[][] grid;

    /**
     * Construtor da classe tabuleiro
     * @param gyokushou No shogi, Sente é o primeiro jogador a fazer uma jogada, equivalente as brancas no xadrez, vencedor do furigoma
     * @param gote No shogi, Gote é o segundo jogador a fazer uma jogada, equivalente as pretas no xadrez
     * @param grid Matriz que representa o conjunto de casas do tabuleiro, e guarda as peças, que estão nos elementos respectivos
     */
    public Tabuleiro(JogadorOushou oushou, JogadorGyokushou gyokushou) {
        this.gyokushou = gyokushou;
        this.oushou = oushou;
        this.grid = new Peça[9][9]; // No tabuleiro de Shogi a numeração é da direita para a esquerda, de cima para baixo. Logo,
        furigoma(gyokushou, oushou);
        // as coordenadas não serão as mesmas da matriz.
    }
    
    public Tabuleiro() { 
    	this.gyokushou = new JogadorGyokushou();
    	this.oushou = new JogadorOushou();
    	this.grid = new Peça[9][9];
    }

    //métodos de get e set
    
    /**
     * @return  Gyokushou, o jogador equivalente as brancas no xadrez, o primeiro a fazer uma jogada
     */
    public JogadorGyokushou getGyokushou() {
        return this.gyokushou;
    }
    
    public void setGyokushou(JogadorGyokushou gyokushou) {
        this.gyokushou = gyokushou;
    }

    /**
     * @return Oushou, o jogador equivalente as pretas no xadrez, o segundo a jogar
     */
    public JogadorOushou getOushou() {
        return this.oushou;
    }
    
    public void setOushou(JogadorOushou oushou) {
    	this.oushou = oushou;
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
        } else {
            gyokushou.setEh_sente(true);
            oushou.setEh_sente(false);
        }
    }

    /**
     * @param vetor vetor que indica em que região ocorrerá a busca da peça
     * @param Pi ponto inicial de onde começará a busca
     * @return A primeira peça encontrada nesta região 
     */
    public Peça buscaPeça(Coordenada vetor, Coordenada Pi) {
        Peça peça = null;
        Coordenada Pf = Pi;
        while ((peça == null) && estaNoTabuleiro(Pf)) {
            Pf = Coordenada.transladarCoordenada(Pf, vetor);
            if (estaNoTabuleiro(Pf) && (getGrid()[Pf.getC_x()][Pf.getC_y()] != null))
                return getGrid()[Pf.getC_x()][Pf.getC_y()];
        }
        return null;
    }
    
    @Override
    public String toString() {
    	return ("ID " + getID() + " - Oushou: " + oushou.getNome() + " - Gyokushou: " + gyokushou.getNome());
    }

    /**
     * Função para testes
     */
    public static void main(String[] args) {
    }
}
