/**
 * TODO: definir as subclasses de jogadores (um que contém o 玉将-Rei de joias- e outro que possui o 王将-Rei-), na classe do primeiro, adicionar o metodo Furigoma
 */

package Componentes;
import java.util.*;
import java.io.*;

abstract public class Jogador implements Serializable {
	private static final long serialVersionUID = 225L;
	private String nome;
    private int score;
    private boolean eh_sente;
    private ArrayList<Peça> peçasTab;
    private ArrayList<Peça> peçasBanco;

    /**
     * Construtor da classe abstrata "Peça"
     * @param nome Nome do jogador
     * @param score Numero de vitórias do jogador
     * @param eh_sente "true" se o jogador é Sente, "false" se o jogador é Gote
     * No Shogi, o jogador Sente (de cor preta) joga primeiro e o jogador Gote (de cor branca) joga em seguida. Isso é definido pelo Furigoma
     * @param peçasTab Lista de peças que o jogador possui no tabuleiro
     * @param peçasBanco Lista de peças que o jogador possui no banco (capturadas)     
     */
    public Jogador(String nome, int score, boolean eh_sente) {
        this.nome = nome;
        this.score = score;
        this.eh_sente = eh_sente;
        this.peçasTab = new ArrayList<Peça>();
        this.peçasBanco = new ArrayList<Peça>(); 
    }
    
    public Jogador() { // Construtor vazio para teste de leitura e escrita. Pode sair depois.
    	this.nome = "NOME";
    	this.score = 1;
    	this.eh_sente = true;
    	this.peçasTab = new ArrayList<Peça>();
        this.peçasBanco = new ArrayList<Peça>(); 
    }

    // Métodos get e set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean getEh_sente() {
        return eh_sente;
    }

    public void setEh_sente(boolean eh_sente) {
        this.eh_sente = eh_sente;
    }

    public ArrayList<Peça> getPeçasTab() {
        return peçasTab;
    }

    public void setPeçasTab(ArrayList<Peça> peçasTab) {
        this.peçasTab = peçasTab;
    }

    public ArrayList<Peça> getPeçasBanco() {
        return peçasBanco;
    }    

    public void setPeçasBanco(ArrayList<Peça> peçasBanco) {
        this.peçasBanco = peçasBanco;
    }    

    // Demais métodos

    public boolean desistir() {
        return true;
    }

    public boolean colocarPeça() {
        return true;
    }
    
    public String toString() {
    	if (getEh_sente())
    		return (getNome() + " - Score " + getScore() + " - Sente");
    	return (getNome() + " - Score " + getScore() + " - Gote");
    }
}