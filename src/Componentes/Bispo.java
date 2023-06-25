/**
 * Criado por Rafael Masato Haga Costa em 22/06/2023
 */

package Componentes;

import java.util.ArrayList;

public class Bispo extends Peça {
    /**
     * Construtor da classe Ouro que herda de "Peça"
     * @param coordenada Coordenadas da casa onde a peça está no momento
     * @param jogador Parâmetro que o construtor recebe como o jogador com que a peça está no momento
     * @param simbolo Kanji representativo do ouro
     * @param valor Valor do ouro segundo as regras do jogo
     * @param capturada "true" se a peça foi capturada e está no banco de peças,
     * "false" se a peça não foi capturada e está em jogo
     */
    public Bispo(int x, int y, Jogador jogador, Simbolo[] simbolos, char simbolo, Valor[] valores, int valor, boolean capturada, Tabuleiro tabuleiro) {
        super(x, y, jogador, SimboloConj.BISPO.getSimboloConj(), Simbolo.BISPO_N.getSimbolo(), ValorConj.BISPO.getValorConj() ,Valor.BISPO_N.getValor(), capturada, false, "Images/Bispo.png", "Images/Bispo_P.png", tabuleiro);
    }

    public boolean andarPara(Coordenada Pi, Coordenada Pf, Tabuleiro tabuleiro) {
        Coordenada vetor = Coordenada.calculaVetor(Pi, Pf);
        int estaPromovida;
        if (getPromovida() == true)
            estaPromovida = 1;
        else
            estaPromovida = 0;
            
        switch(estaPromovida){
            case 0: // 1 quando a peça está promovida
                if (vetor.estaNaLista(Movimento.BISPO_P.getMovimentos())) {
                    setCoordenada(Coordenada.transladarCoordenada(getCoordenada(), vetor));
                    return true;
                } else
                    return false;
            case 1: // O quando a peça não está  promovida
                if (vetor.contemVetorParalelo(Movimento.BISPO_N.getMovimentos())) {
                    setCoordenada(Coordenada.transladarCoordenada(getCoordenada(), vetor));
                    return true;
                } else
                    return false;
        }
        return false; 
    }

    public ArrayList<Coordenada> podeAndar() {
        ArrayList<Coordenada> jogadasPossíveis = new ArrayList<Coordenada>();
        Peça peçaBloq;
        Coordenada Pf = getCoordenada();
        int estaPromovida;
        if (getPromovida() == true)
            estaPromovida = 1;
        else
            estaPromovida = 0;

        switch(estaPromovida){
            case 1: 
                for (Coordenada coordenada : Movimento.TORRE_P.getMovimentos()) {
                Coordenada posiçãoFinal = Coordenada.transladarCoordenada(getCoordenada(), coordenada);
                    if (getTabuleiro().estaNoTabuleiro(posiçãoFinal))
                        if (!(getTabuleiro().getGrid()[posiçãoFinal.getC_x()][posiçãoFinal.getC_y()] != null && getTabuleiro().getGrid()[posiçãoFinal.getC_x()][posiçãoFinal.getC_y()].getJogador().equals(getJogador())))
                            jogadasPossíveis.add(Coordenada.transladarCoordenada(getCoordenada(), coordenada));
                }

            case 0: 
                for (Coordenada coordenada : Movimento.TORRE_N.getMovimentos()) {
                    peçaBloq = getTabuleiro().buscaPeça(coordenada, getCoordenada());
                    if (peçaBloq == null) { // Caso não hajam peças no caminho 
                        while (getTabuleiro().estaNoTabuleiro(Pf)) {
                            Pf = Coordenada.transladarCoordenada(coordenada, Pf);
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

    
    //métodos de get e set


}
