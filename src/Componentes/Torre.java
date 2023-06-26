/**
 * Criado por Rafael Masato Haga Costa em 22/06/2023
 */
package Componentes;

import java.util.ArrayList;

public class Torre extends Peça{

    public Torre(int x, int y,Jogador jogador, Simbolo[] simbolos, char simbolo, Valor[] valores, int valor, boolean capturada, Tabuleiro tabuleiro) {
        super(x, y, jogador, SimboloConj.TORRE.getSimboloConj(), Simbolo.TORRE_N.getSimbolo() , ValorConj.TORRE.getValorConj() ,Valor.TORRE_N.getValor(), capturada, false, "src/Images/Torre.png", "src/Images/Torre_P.png", tabuleiro);
    };

    /* public boolean andarPara(Coordenada Pi, Coordenada Pf, Tabuleiro tabuleiro) {
        Coordenada vetor = Coordenada.calculaVetor(Pi, Pf);
        int estaPromovida;
        if (getPromovida() == true)
            estaPromovida = 1;
        else
            estaPromovida = 0;
            
        switch(estaPromovida){
            case 1: // 1 quando a peça está promovida
                if (vetor.estaNaLista(Movimento.TORRE_P.getMovimentos())) {
                    setCoordenada(Coordenada.transladarCoordenada(getCoordenada(), vetor));
                    return true;
                } else
                    return false;
            case 2: // O quando a peça não está  promovida
                if (vetor.contemVetorParalelo(Movimento.TORRE_N.getMovimentos())) {
                    setCoordenada(Coordenada.transladarCoordenada(getCoordenada(), vetor));
                    return true;
                } else
                    return false;
        }
        return false; 
    } */

    public ArrayList<Coordenada> podeAndar() {
        ArrayList<Coordenada> jogadasPossíveis = new ArrayList<Coordenada>();
        Peça peçaBloq;
        int estaPromovida;
        if (getPromovida() == true)
            estaPromovida = 1;
        else
            estaPromovida = 0;

        switch(estaPromovida){
            case 1: 
                for (Coordenada coordenada : Movimento.TORRE_P.getMovimentos()) {
                peçaBloq = getTabuleiro().buscaPeça(coordenada, getCoordenada());
                Coordenada posiçãoFinal = Coordenada.transladarCoordenada(getCoordenada(), coordenada);
                    if (getTabuleiro().estaNoTabuleiro(posiçãoFinal))
                        if (!(getTabuleiro().getGrid()[posiçãoFinal.getC_x()][posiçãoFinal.getC_y()] != null && getTabuleiro().getGrid()[posiçãoFinal.getC_x()][posiçãoFinal.getC_y()].getJogador().equals(getJogador())))
                            jogadasPossíveis.add(Coordenada.transladarCoordenada(getCoordenada(), coordenada));
                }

            case 0: 
                for (Coordenada coordenada : Movimento.TORRE_N.getMovimentos()) {
                    Coordenada Pf = getCoordenada();
                    peçaBloq = getTabuleiro().buscaPeça(coordenada, getCoordenada());
                    if (peçaBloq == null) { // Caso não hajam peças no caminho 
                        while (getTabuleiro().estaNoTabuleiro(Pf)) {
                            Pf = Coordenada.transladarCoordenada(coordenada, Pf);
                            if (getTabuleiro().estaNoTabuleiro(Pf))
                                jogadasPossíveis.add(Pf);
                        }
                    }
                    
                    else if (peçaBloq != null) { // Quando há uma pessa que bloqueia o caminho
                        if (peçaBloq.getJogador().equals(getJogador())) { // A peça que bloqueia é aliada
                            while (!(Pf.equals(peçaBloq.getCoordenada()))) {
                                Pf = Coordenada.transladarCoordenada(coordenada, Pf);
                                jogadasPossíveis.add(Pf);
                                if (Pf.equals(peçaBloq.getCoordenada()))
                                    jogadasPossíveis.remove(Pf);
                            } 

                        }else if (!(peçaBloq.getJogador().equals(getJogador()))) { // A peça que bloqueia é inimiga
                            while (!(Pf.equals(peçaBloq.getCoordenada()))) {
                                Pf = Coordenada.transladarCoordenada(coordenada, Pf);
                                jogadasPossíveis.add(Pf);
                            } 
                        } 
                    }       
                }

            return jogadasPossíveis;
        }
        return null;
    }
    
}
