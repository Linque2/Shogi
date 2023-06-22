/*
 * Criado por Rafael Masato Haga Costa em 22/06/2023
 */

package Componentes;

abstract public class Peça {
    
    int c_x;
    int c_y;
    Jogador jogador;
    final char simbolo;
    final int valor;

    /**
     * Construtor da classe abstrata "Peça"
     * @param c_x Parâmetro que o construtor recebe como coordenada inicial em x
     * @param c_y Parâmetro que o construtor recebe como coordenada inicial em y
     * @param jogador Parâmetro que o construtor recebe como o jogador com que a peça começa o jogo
     * @param simbolo O construtor receberá um simbolo próprio da peça no construtor de sua subclasses
     * @param valor O construtor receberá o valor próprio da peça no contrutor de sua subclasee
     */
    public Peça(int c_x, int c_y, Jogador jogador, char simbolo, int valor) {
        this.c_x = c_x;
        this.c_y = c_y;
        this.jogador = jogador;
        this.simbolo = simbolo;
        this.valor = valor;
    }

    /**
     * @return A coordenada da peça em x
     */
    public int getC_x() {
        return this.c_x;
    }

    /**
     * @param c_x É atribuido a coordenada da peça em x
     */
    public void setC_x(int c_x) {
        this.c_x = c_x;
    }

    /**
     * @return A coordenada da peça em y
     */
    public int getC_y() {
        return this.c_y;
    }

    /**
     * @param c_y É atribuido a coordenada da peça em y
     */
    public void setC_y(int c_y) {
        this.c_y = c_y;
    }

    /**
     * @return O jogador que possui a peça no momento
     */
    public Jogador getJogador() {
        return this.jogador;
    }

    /**
     * @param jogador É atribuido ao jogador que contém a peça
     */
    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    /**
     * @return O kanji que representa a peça
     */
    public char getSimbolo() {
        return this.simbolo;
    }

    /**
     * @return O valor da peça segundo as regras do jogo
     */
    public int getValor() {
        return this.valor;
    }
    
}