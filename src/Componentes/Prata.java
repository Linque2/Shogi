/**
 * Criado por Rafael Masato Haga Costa em 22/06/2023
 */

package Componentes;

import java.util.ArrayList;

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

    public ArrayList<Coordenada> podeAndar() {
        ArrayList<Coordenada> jogadasPossíveis = new ArrayList<Coordenada>();
        int estaPromovida;
        if (getPromovida() == true)
            estaPromovida = 1;
        else
            estaPromovida = 0;

        switch(estaPromovida){
            case 0: 
                for (Coordenada coordenada : Movimento.PRATA_N.getMovimentos()) {
                Coordenada posiçãoFinal = Coordenada.transladarCoordenada(getCoordenada(), coordenada);
                    if (getTabuleiro().estaNoTabuleiro(posiçãoFinal))
                        if (!(getTabuleiro().getGrid()[posiçãoFinal.getC_x()][posiçãoFinal.getC_y()] != null && getTabuleiro().getGrid()[posiçãoFinal.getC_x()][posiçãoFinal.getC_y()].getJogador().equals(getJogador())))
                            jogadasPossíveis.add(Coordenada.transladarCoordenada(getCoordenada(), coordenada));
                }

                return jogadasPossíveis;
            case 1: 
                for (Coordenada coordenada : Movimento.PRATA_P.getMovimentos()) {
                Coordenada posiçãoFinal = Coordenada.transladarCoordenada(getCoordenada(), coordenada);
                    if (getTabuleiro().estaNoTabuleiro(posiçãoFinal))
                        if (!(getTabuleiro().getGrid()[posiçãoFinal.getC_x()][posiçãoFinal.getC_y()] != null && getTabuleiro().getGrid()[posiçãoFinal.getC_x()][posiçãoFinal.getC_y()].getJogador().equals(getJogador())))
                            jogadasPossíveis.add(Coordenada.transladarCoordenada(getCoordenada(), coordenada));

                return jogadasPossíveis;
                }
        }
        return null;
    }
}
