/**
 * Criado por Rafael Masato Haga Costa em 22/06/2023
 */

package Componentes;

public class Peão extends Peça{

    /**
     * @param coordenada
     * @param jogador
     * @param simbolo
     * @param valor
     * @param capturada
     */
    public Peão(Coordenada coordenada, Jogador jogador, char simbolo, int valor, boolean capturada) {
        super(coordenada, jogador, SimboloConj.PEAO.getSimboloConj(), ValorConj.PEAO.getValorConj(), capturada, 0);
    }

    // métodos de get e set

    /**
     * 
     */
    public boolean andarPara(Coordenada Pi, Coordenada Pf) {
        Coordenada vetor = Coordenada.calculaVetor(Pi, Pf);
        if (vetor.estaNaLista(MovimentoConj.PEAO.getMovimentos().get(getPromovida()).getMovimentos())) {
            setCoordenada(Coordenada.transladarCoordenada(getCoordenada(), vetor));
            return true;
        } else
            return false;
    }

}
