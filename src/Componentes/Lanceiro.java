/**
 * Criado por Rafael Masato Haga Costa em 22/06/2023
 */

package Componentes;

import java.util.ArrayList;

public class Lanceiro extends Peça {
    /**
     * Construtor da classe Lanceiro que herda de "Peça"
     * @param coordenada Coordenadas da casa onde a peça está no momento
     * @param jogador Parâmetro que o construtor recebe como o jogador com que a peça está no momento
     * @param simbolo Kanji representativo do ouro
     * @param valor Valor do ouro segundo as regras do jogo
     * @param capturada "true" se a peça foi capturada e está no banco de peças,
     * "false" se a peça não foi capturada e está em jogo
     */
    public Lanceiro(int x, int y, Jogador jogador, Simbolo[] simbolos, char simbolo,Valor[] valores, int valor, boolean capturada, Tabuleiro tabuleiro) {
        super(x, y, jogador, SimboloConj.LANCEIRO.getSimboloConj(), Simbolo.LANCEIRO_N.getSimbolo(), ValorConj.LANCEIRO.getValorConj(), Valor.LANCEIRO_N.getValor(), capturada, false, "src/Images/Lanceiro.png", "src/Images/Lanceiro_P.png", tabuleiro);
    }

    // métodos de get e set

    /**
     * Calcula um vetor subtraindo Pi de Pf
     * Em seguida verifica se ele está na lista de movimentos possíveis da peça, registradas no enum MovimentoConj(index)
     * @return "true" caso a jogada seja possível, e translada a posição da peça para a nova posição
     * @return "false" caso a jogada seja impossível
     */
    /* public boolean andarPara(Coordenada Pi, Coordenada Pf, Tabuleiro tabuleiro) {
        Coordenada vetor = Coordenada.calculaVetor(Pi, Pf);
        int estaPromovida;
        if (getPromovida() == true)
            estaPromovida = 1;
        else
            estaPromovida = 0;
            
        switch(estaPromovida){
            case 0: // O quando a peçça não está  promovida
                if (vetor.contemVetorParalelo(Movimento.LANCEIRO_N.getMovimentos())) {
                    setCoordenada(Coordenada.transladarCoordenada(getCoordenada(), vetor));
                    return true;
                } else
                    return false;
            case 1: // 1 quando a peça está promovida
                if (vetor.estaNaLista(Movimento.LANCEIRO_P.getMovimentos())) {
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
        Coordenada Pf = getCoordenada();
        int estaPromovida;
        if (getPromovida() == true)
            estaPromovida = 1;
        else
            estaPromovida = 0;

        switch(estaPromovida){
            case 0: 
                for (Coordenada coordenada : Movimento.LANCEIRO_N.getMovimentos()) {
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
            case 1: 
                for (Coordenada coordenada : Movimento.LANCEIRO_P.getMovimentos()) {
                Coordenada posiçãoFinal = Coordenada.transladarCoordenada(getCoordenada(), coordenada);
                    if (getTabuleiro().estaNoTabuleiro(posiçãoFinal))
                        if (!(getTabuleiro().getGrid()[posiçãoFinal.getC_x()][posiçãoFinal.getC_y()] != null && getTabuleiro().getGrid()[posiçãoFinal.getC_x()][posiçãoFinal.getC_y()].getJogador().equals(getJogador())))
                            jogadasPossíveis.add(Coordenada.transladarCoordenada(getCoordenada(), coordenada));
                }

                return jogadasPossíveis;
        }
        return null;
    }

    /**
     * Função para testes
     * @param args
     */
    public static void main(String[] args) {
        Coordenada vetor = new Coordenada(0, 8);
        System.out.println(vetor);
        System.out.println(Movimento.LANCEIRO_N.getMovimentos());
        if (vetor.contemVetorParalelo(Movimento.LANCEIRO_N.getMovimentos())) 
            System.out.println("TRUE!");
        else
            System.out.println("FALSE!");
    }
}
