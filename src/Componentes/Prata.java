/**
 * Criado por Rafael Masato Haga Costa em 22/06/2023
 */

package Componentes;

public class Prata extends Peça {

    public Prata(Coordenada coordenada, Jogador jogador, Simbolo[] simbolos, char simbolo, Valor[] valores, int valor, boolean capturada) {
        super(coordenada, jogador, SimboloConj.PRATA.getSimboloConj(), Simbolo.PRATA_N.getSimbolo() , ValorConj.PRATA.getValorConj() ,Valor.PRATA_N.getValor(), capturada, false);
    };

    public boolean andarPara(Coordenada Pi, Coordenada Pf) {
        Coordenada vetor = Coordenada.calculaVetor(Pi, Pf);
        switch(getPromovida()){
            case false: 
                if (vetor.contemVetorParalelo(Movimento.PRATA_N.getMovimentos())) {
                    setCoordenada(Coordenada.transladarCoordenada(getCoordenada(), vetor));
                    return true;
                } else
                    return false;
            case true: 
                if (vetor.estaNaLista(Movimento.PRATA_P.getMovimentos())) {
                    setCoordenada(Coordenada.transladarCoordenada(getCoordenada(), vetor));
                    return true;
                } else
                    return false;
        }
    }
}
