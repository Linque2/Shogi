/**
 * Criado por Rafael Masato Haga Costa em 22/06/2023
 */

package Componentes;

abstract public class Peça {
    
    private Coordenada coordenada;
    private Jogador jogador;
    private final Simbolo[] simbolo;
    private final Valor[] valor;
    private boolean capturada;
    private int promovida;

    /**
     * Construtor da classe abstrata "Peça"
     * @param coordenada Coordenadas da casa onde a peça está no momento
     * @param jogador Parâmetro que o construtor recebe como o jogador com que a peça está no momento
     * @param simbolo O construtor receberá um simbolo próprio da peça no construtor de sua subclasses
     * @param valor O construtor receberá o valor próprio da peça no contrutor de sua subclasee
     * @param capturada "true" se a peça foi capturada e está no banco de peças,
     * "false" se a peça não foi capturada e está em jogo
     *@param promovida assume "0" se a peça está em sua forma normal, e "1" se a peça está na sua forma promovida       
     */
    public Peça(Coordenada coordenada, Jogador jogador, Simbolo[] simbolo, Valor[] valor, boolean capturada, int promovida) {
        this.coordenada = coordenada;
        this.jogador = jogador;
        this.simbolo = simbolo;
        this.valor = valor;
        this.capturada = capturada;
        this.promovida = promovida;
    }

    // métodos de get e set

    /**
     * @return As coordenadas da peça no tabuleiro
     */
    public Coordenada getCoordenada() {
        return this.coordenada;
    }

    /**
     * @param coordenada Novas coordenadas para a peça no tabuleiro
     */
    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
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
    public Simbolo[] getSimbolo() {
        return this.simbolo;
    }

    /**
     * @return O valor da peça segundo as regras do jogo
     */
    public Valor[] getValor() {
        return this.valor;
    }

    /**
     * @return "true" se a peça foi capturada e está no banco de peças de algum jogador,
     * @return "false" se a peça está posicionada no tabuleiro
     */
    public boolean getCapturada() {
        return this.capturada;
    }

    /**
     * @param capturada Se refere ao estado da peça, 
     * se "true", a peça foi capturada e está no banco de peças, 
     * se "false", a peça até pode já ter sofrido uma captura, mas no posicionada no tabuleiro
     */
    public void setCapturada(boolean capturada) {
        this.capturada = capturada;
    }

    /**
     * @return "0" se a peça está promovia,
     * "1" se a peça está promovida
     */
    public int getPromovida() {
        return this.promovida;
    }

    /**
     * @param promovida Altera a promoção da peça (pode ser 0 ou 1)
     */
    public void setPromovida(int promovida) {
        //! verificar se promovida = 0 || 1
        this.promovida = promovida;
    }

    
    
    //demais métodos

    /**
     * A função andarPara é comum a todas as peças do jogo, no entanto possui uma implementação distinta para cada uma
     * @param Pi Posição inicial da peça, coordenadas em que ela está antes do movimento acontecer
     * @param Pf Posição final da peça, coordenadas em que ela estará após o movimento
     * @return "true", caso o movimento seja possível
     * @return "false", caso o movimento não seja possível 
     */
    public boolean andarPara(Coordenada Pi, Coordenada Pf) {
        return true;
    }
}