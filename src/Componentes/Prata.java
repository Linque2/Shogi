/**
 * Criado por Rafael Masato Haga Costa em 22/06/2023
 */

package Componentes;

public class Prata extends Peça {

    public Prata(int x, int y, Jogador jogador, Simbolo[] simbolos, char simbolo, Valor[] valores, int valor, boolean capturada, Tabuleiro tabuleiro) {
        super(x, y, jogador, SimboloConj.PRATA.getSimboloConj(), Simbolo.PRATA_N.getSimbolo() , ValorConj.PRATA.getValorConj() ,Valor.PRATA_N.getValor(), capturada, false, "src/Images/Prata.png", "src/Images/Prata_P.png", tabuleiro);
    };

    public boolean andarPara(Coordenada Pi, Coordenada Pf, Tabuleiro tabuleiro) {
        Coordenada vetor = Coordenada.calculaVetor(Pi, Pf);
        int estaPromovida;
        if (getPromovida() == true)
            estaPromovida = 1;
        else
            estaPromovida = 0;

        switch(estaPromovida){
            case 0: 
                if (vetor.contemVetorParalelo(Movimento.PRATA_N.getMovimentos())) {
                    setCoordenada(Coordenada.transladarCoordenada(getCoordenada(), vetor));
                    return true;
                } else
                    return false;
            case 1: 
                if (vetor.estaNaLista(Movimento.PRATA_P.getMovimentos())) {
                    setCoordenada(Coordenada.transladarCoordenada(getCoordenada(), vetor));
                    return true;
                } else
                    return false;
        }
        return false;
    }
}
