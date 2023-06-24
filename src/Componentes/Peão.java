/**
 * Criado por Rafael Masato Haga Costa em 22/06/2023
 */

package Componentes;

public class Peão extends Peça{

    public Peão(Coordenada coordenada, Jogador jogador, char simbolo, int valor, boolean capturada) {
        super(coordenada, jogador, SimboloConj.PEAO.getSimboloConj(),Simbolo.PEAO_N, ValorConj.PEAO.getValorConj(),Valor.PEAO_N, capturada, false);
    }

    // métodos de get e set

    /**
     * 
     */
    public boolean andarPara(Coordenada Pi, Coordenada Pf) {
        Coordenada vetor = Coordenada.calculaVetor(Pi, Pf);
        switch(getPromovida()) {
            case false:
                if (vetor.estaNaLista(Movimento.PEAO_N.getMovimentos())) {
                    setCoordenada(Coordenada.transladarCoordenada(getCoordenada(), vetor));
                    return true;
                } else
                    return false;
            case true:
                if (vetor.estaNaLista(Movimento.PEAO_P.getMovimentos())) {
                    setCoordenada(Coordenada.transladarCoordenada(getCoordenada(), vetor));
                    return true;
                } else
                    return false;
        }
    }

}
