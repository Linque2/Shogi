/**
 * Criado por Rafael Masato Haga Costa em 22/06/2023
 */
package Componentes;

public class Ouro extends Peça{

     /**
     * Construtor da classe Ouro que herda de "Peça"
     * @param coordenada Coordenadas da casa onde a peça está no momento
     * @param jogador Parâmetro que o construtor recebe como o jogador com que a peça está no momento
     * @param simbolo Kanji representativo do ouro
     * @param valor Valor do ouro segundo as regras do jogo
     * @param capturada "true" se a peça foi capturada e está no banco de peças,
     * "false" se a peça não foi capturada e está em jogo
     */
    public Ouro(Coordenada coordenada, Jogador jogador, char simbolo, int valor, boolean capturada) {
        super(coordenada, jogador, SimboloConj.OURO.getSimboloConj(), ValorConj.OURO.getValorConj(), capturada, 0);
    }

    // métodos de get e set

    public boolean andarPara(Coordenada Pi, Coordenada Pf) {
        Coordenada vetor = Coordenada.calculaVetor(Pi, Pf);
        if (MovimentoConj.OURO.getMovimentos().get(getPromovida()).getMovimentos().contains(vetor)) {
            return true;
        } else
            return false;

    }


    
    
}
