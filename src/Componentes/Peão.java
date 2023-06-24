/**
 * Criado por Rafael Masato Haga Costa em 22/06/2023
 */

package Componentes;

public class Peão extends Peça{

    public Peão(Coordenada coordenada, Jogador jogador, char simbolo, int valor, boolean capturada) {
        super(coordenada, jogador, SimboloConj.PEAO.getSimboloConj(),Simbolo.PEAO_N.getSimbolo(), ValorConj.PEAO.getValorConj(),Valor.PEAO_N.getValor(), capturada, false);
    }

    // métodos de get e set

    /**
     * 
     */
    public boolean andarPara(Coordenada Pi, Coordenada Pf) {
        Coordenada vetor = Coordenada.calculaVetor(Pi, Pf);
        int estaPromovida;
        if (getPromovida() == true)
            estaPromovida = 1;
        else
            estaPromovida = 0;
            
        switch(estaPromovida){
            case 0:
                if (vetor.estaNaLista(Movimento.PEAO_N.getMovimentos())) {
                    setCoordenada(Coordenada.transladarCoordenada(getCoordenada(), vetor));
                    return true;
                } else
                    return false;
            case 1:
                if (vetor.estaNaLista(Movimento.PEAO_P.getMovimentos())) {
                    setCoordenada(Coordenada.transladarCoordenada(getCoordenada(), vetor));
                    return true;
                } else
                    return false;
        }
        return false;
    }

}
