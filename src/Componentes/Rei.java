/**
 * Criado por Rafael Masato Haga Costa em 22/06/2023
 */

package Componentes;

public class Rei extends Peça{
    
    /**
     * Construtor da classe "Rei"
     * @param c_x Parâmetro que o construtor recebe como coordenada inicial em x
     * @param c_y Parâmetro que o construtor recebe como coordenada inicial em y
     * @param jogador Parâmetro que o construtor recebe como o jogador com que a peça começa o jogo
     * @param simbolo O construtor receberá um simbolo próprio da peça no construtor de sua subclasses
     * @param valor O construtor receberá o valor próprio da peça no contrutor de sua subclasee
     */
    public Rei(int c_x, int c_y, Jogador jogador){
        super(c_x, c_y, jogador, Simbolo.REI.getSimbolo(), Valor.REI.getValor(), false);
    }

}
