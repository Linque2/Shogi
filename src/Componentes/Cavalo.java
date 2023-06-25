/**
 * Criado por Rafael Masato Haga Costa em 22/06/2023
 */

package Componentes;

public class Cavalo extends Peça{

    public Cavalo(int x, int y, Jogador jogador, Simbolo[] simbolos ,char simbolo, Valor[] valores, int valor, boolean capturada, Tabuleiro tabuleiro) {
        super(x, y, jogador, SimboloConj.CAVALO.getSimboloConj(), Simbolo.CAVALO_N.getSimbolo(), ValorConj.CAVALO.getValorConj(),Valor.CAVALO_N.getValor(), capturada, false, "src/Images/Cavalo.png", "src/Images/Cavalo_P.png", tabuleiro);
    }

    //métodos de get e set

    public boolean andarPara(Coordenada Pi, Coordenada Pf, Tabuleiro tabuleiro) {
        Coordenada vetor = Coordenada.calculaVetor(Pi, Pf);
        int estaPromovida;
        if (getPromovida() == true)
            estaPromovida = 1;
        else
            estaPromovida = 0;
            
        switch(estaPromovida){
            case 0:
                if (vetor.estaNaLista(Movimento.CAVALO_N.getMovimentos())) {
                    setCoordenada(Coordenada.transladarCoordenada(getCoordenada(), vetor));
                    return true;
                } else
                    return false;
            case 1:
                if (vetor.estaNaLista(Movimento.CAVALO_P.getMovimentos())) {
                    setCoordenada(Coordenada.transladarCoordenada(getCoordenada(), vetor));
                    return true;
                } else
                    return false;
        }
        return false;
    }
}
