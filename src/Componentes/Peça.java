/**
 * Criado por Rafael Masato Haga Costa em 22/06/2023
 */

package Componentes;

import javax.lang.model.util.ElementScanner6;

abstract public class Peça {
    
    private Coordenada coordenada;
    private Jogador jogador;
    private final Simbolo[] simbolos; // Par de ideogramas gravados na peça
    private char simbolo; // Ideograma do estado atual da peça
    private final Valor[] valores; //Par de valores correspondentes a cada peça
    private int valor;// Valor do estado atual da peça
    private boolean capturada;
    private boolean promovida;

    /**
     * Construtor da classe abstrata "Peça"
     * @param coordenada Coordenadas da casa onde a peça está no momento
     * @param jogador Parâmetro que o construtor recebe como o jogador com que a peça está no momento
     * @param simbolos Lista de ideogramas possíveis associados aos estados da peça, [0] para peça despromovida e [1] para a promovida
     * @param simbolo O construtor receberá um simbolo próprio da peça no construtor de sua subclasses
     * @param valores Lista de valores possíveis associados aos estados da peça, [0] para peça despromovida e [1] para a promovida 
     * @param valor O construtor receberá o valor próprio da peça no contrutor de sua subclasee
     * @param capturada "true" se a peça foi capturada e está no banco de peças,
     * "false" se a peça não foi capturada e está em jogo
     *@param promovida assume "0" se a peça está em sua forma normal, e "1" se a peça está na sua forma promovida       
     */
    public Peça(Coordenada coordenada, Jogador jogador, Simbolo[] simbolos, char simbolo, Valor[] valores, int valor, boolean capturada, boolean promovida) {
        this.coordenada = coordenada;
        this.jogador = jogador;
        this.simbolos = simbolos;
        this.simbolo = simbolo;
        this.valores = valores;
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
     * @return Lista de ideogramas associados a peça, segundo seus possíveis estados
     */
    public Simbolo[] getSimbolos() {
        return this.simbolos;
    }

    /**
     * @return Simbolo atual da peça
     */
    public char getSimbolo() {
        return this.simbolo;
    }

    /**
     * @param simblo Simbolo que desejamos atribuir a peça, segundo seu estado atual
     */
    public void setSimbolo(char simblo) {
        this.simbolo = simblo;
    }

    /**
     * @return Lista de valores associados a peça, segundo seus possíveis estados
     */
    public Valor[] getValores() {
        return this.valores;
    }

    /**
     * @return Valor atual da peça
     */
    public int getValor() {
        return this.valor;
    }

    /**
     * @param valor Valor que desejamos atribuir a peça, segundo seu estado atual
     */
    public void setValor(int valor) {
        this.valor = valor;
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
    public boolean getPromovida() {
        return this.promovida;
    }

    /**
     * @param promovida Altera a promoção da peça (pode ser 0 ou 1)
     */
    public void setPromovida(boolean promovida) {
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

    /**
     * Função que atualiza a peça para sua forma promovida
     * @return "true" se a peça foi promovida
     * @return "false" se a peça não foi promovida
     */
    public boolean promoverPeça() {
        if (getPromovida() == false) {
            setPromovida(true);
            setSimbolo(getSimbolos()[1].getSimbolo());
            setValor(getValores()[1].getValor());
            return true;
        } else 
            return false;
    }

    /**
     * Função que atualiza a peça para sua forma não promovida
     * @return "true" se ela foi despromovida
     * @return "false" se ela não foi despromovida
     */
    public boolean despromoverPeça() {
        if (getPromovida() == true) {
            setPromovida(false);
            setSimbolo(getSimbolos()[0].getSimbolo());
            setValor(getValores()[0].getValor());
            return true;
        } else 
            return false;
    }
}