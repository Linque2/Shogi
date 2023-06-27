/**
 * Criado por Rafael Masato Haga Costa em 22/06/2023
 */

package Componentes;

import java.util.ArrayList;

import javax.swing.ImageIcon;

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
    public Bispo(int x, int y, JogadorOushou jogador, Simbolo[] simbolos, char simbolo, Valor[] valores, int valor, boolean capturada, Tabuleiro tabuleiro) {
        super(x, y, jogador, SimboloConj.BISPO.getSimboloConj(), Simbolo.BISPO_N.getSimbolo(), ValorConj.BISPO.getValorConj() ,Valor.BISPO_N.getValor(), capturada, false, "Images/Bispo.png", "Images/Bispo_P.png", tabuleiro);
    }

    public Bispo(int x, int y, JogadorGyokushou jogador, Simbolo[] simbolos, char simbolo, Valor[] valores, int valor, boolean capturada, Tabuleiro tabuleiro) {
        super(x, y, jogador, SimboloConj.BISPO.getSimboloConj(), Simbolo.BISPO_N.getSimbolo(), ValorConj.BISPO.getValorConj() ,Valor.BISPO_N.getValor(), capturada, false, "ImagensInvertidas/Bispo.png", "ImagensInvertidas/Bispo_P.png", tabuleiro);
    }

    public boolean andarPara(Coordenada Pf, Tabuleiro tabuleiro) {
        ArrayList<Coordenada> jogadasPossíveis = podeAndar();
            if (Pf.estaNaLista(jogadasPossíveis)) {
            if (getJogador() instanceof JogadorOushou)
                if (Pf.getC_x() < 3)
                    promoverPeça();
                if (getJogador() instanceof JogadorGyokushou)
                if (Pf.getC_x() > 5)
                    promoverPeça();
            setCoordenada(Pf);
            return true;
        } else
            return false;
    }

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
                for (Coordenada vetor : Movimento.BISPO_P.getMovimentos()) {
                    peçaBloq = getTabuleiro().buscaPeça(vetor, getCoordenada());
                    Coordenada posiçãoFinal = Coordenada.transladarCoordenada(getCoordenada(), vetor);
                    if (getTabuleiro().estaNoTabuleiro(posiçãoFinal))
                        if (!(getTabuleiro().getGrid()[posiçãoFinal.getC_x()][posiçãoFinal.getC_y()] != null && getTabuleiro().getGrid()[posiçãoFinal.getC_x()][posiçãoFinal.getC_y()].getJogador().equals(getJogador())))
                            jogadasPossíveis.add(Coordenada.transladarCoordenada(getCoordenada(), vetor));
                }

            case 0: 
                for (Coordenada vetor : Movimento.BISPO_N.getMovimentos()) {
                    Coordenada Pf = getCoordenada();
                    peçaBloq = getTabuleiro().buscaPeça(vetor, getCoordenada());
                    if (peçaBloq == null) { // Caso não hajam peças no caminho 
                        while (getTabuleiro().estaNoTabuleiro(Pf)) {
                            Pf = Coordenada.transladarCoordenada(vetor, Pf);
                            if (getTabuleiro().estaNoTabuleiro(Pf))
                                jogadasPossíveis.add(Pf);
                        }
                    }
                    
                    else if (peçaBloq != null) { // Quando há uma pessa que bloqueia o caminho
                        if (peçaBloq.getJogador().equals(getJogador())) { // A peça que bloqueia é aliada
                            while (!(Pf.equals(peçaBloq.getCoordenada()))) {
                                Pf = Coordenada.transladarCoordenada(vetor, Pf);
                                jogadasPossíveis.add(Pf);
                                if (Pf.equals(peçaBloq.getCoordenada()))
                                    jogadasPossíveis.remove(Pf);
                            } 

                        }else if (!(peçaBloq.getJogador().equals(getJogador()))) { // A peça que bloqueia é inimiga
                            while (!(Pf.equals(peçaBloq.getCoordenada()))) {
                                Pf = Coordenada.transladarCoordenada(vetor, Pf);
                                jogadasPossíveis.add(Pf);
                            } 
                        } 
                    }           
                }

            return jogadasPossíveis;
        }
        return null;
    }

    public void atualizarImagem() {
        getListImageIcon().clear();
        if (getJogador() instanceof JogadorGyokushou) {
            getListImageIcon().add(new ImageIcon("src/ImagensInvertidas/Bispo.png"));
            getListImageIcon().add(new ImageIcon("src/ImagensInvertidas/Bispo_P.png"));
        } else if (getJogador() instanceof JogadorGyokushou) {
            getListImageIcon().add(new ImageIcon("src/Images/Bispo.png"));
            getListImageIcon().add(new ImageIcon("src/Images/Bispo_P.png"));
        }
    }


}
