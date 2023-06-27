/**
 * Criado por Rafael Masato Haga Costa em 22/06/2023
 */

package Componentes;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Peão extends Peça{

    public Peão(int x, int y, JogadorOushou jogador, char simbolo, int valor, boolean capturada, Tabuleiro tabuleiro) {
        super(x, y, jogador, SimboloConj.PEAO.getSimboloConj(),Simbolo.PEAO_N.getSimbolo(), ValorConj.PEAO.getValorConj(),Valor.PEAO_N.getValor(), capturada, false, "Images/Peão.png", "Images/Peão_P.png", tabuleiro);
    }

    public Peão(int x, int y, JogadorGyokushou jogador, char simbolo, int valor, boolean capturada, Tabuleiro tabuleiro) {
        super(x, y, jogador, SimboloConj.PEAO.getSimboloConj(),Simbolo.PEAO_N.getSimbolo(), ValorConj.PEAO.getValorConj(),Valor.PEAO_N.getValor(), capturada, false, "ImagensInvertidas/Peão.png", "ImagensInvertidas/Peão_P.png", tabuleiro);
    }

    // métodos de get e set

    /**
     * 
     */
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
        ArrayList<Coordenada> movimentos = new ArrayList<Coordenada>();
        ArrayList<Coordenada> movimentos_P = new ArrayList<Coordenada>();
    
        if (getJogador() instanceof JogadorOushou) {
            movimentos = Movimento.PEAO_N.getMovimentos();
            movimentos_P = Movimento.PEAO_P.getMovimentos();
        } else if (getJogador() instanceof JogadorGyokushou) {
            movimentos = Movimento.GyokuPEAO_N.getMovimentos();
            movimentos_P = Movimento.GyokuPEAO_P.getMovimentos();
        }

        int estaPromovida;
        if (getPromovida() == true)
            estaPromovida = 1;
        else
            estaPromovida = 0;

        switch(estaPromovida){
            case 0: 
                for (Coordenada coordenada : movimentos) {
                Coordenada posiçãoFinal = Coordenada.transladarCoordenada(getCoordenada(), coordenada);
                    if (getTabuleiro().estaNoTabuleiro(posiçãoFinal))
                        if (!(getTabuleiro().getGrid()[posiçãoFinal.getC_x()][posiçãoFinal.getC_y()] != null && getTabuleiro().getGrid()[posiçãoFinal.getC_x()][posiçãoFinal.getC_y()].getJogador().equals(getJogador())))
                            jogadasPossíveis.add(Coordenada.transladarCoordenada(getCoordenada(), coordenada));
                }

                return jogadasPossíveis;
            case 1: 
                for (Coordenada coordenada : movimentos_P) {
                Coordenada posiçãoFinal = Coordenada.transladarCoordenada(getCoordenada(), coordenada);
                    if (getTabuleiro().estaNoTabuleiro(posiçãoFinal))
                        if (!(getTabuleiro().getGrid()[posiçãoFinal.getC_x()][posiçãoFinal.getC_y()] != null && getTabuleiro().getGrid()[posiçãoFinal.getC_x()][posiçãoFinal.getC_y()].getJogador().equals(getJogador())))
                            jogadasPossíveis.add(Coordenada.transladarCoordenada(getCoordenada(), coordenada));
                }

                return jogadasPossíveis;
        }
        return null;
    }

    public void atualizarImagem() {
        getListImageIcon().clear();
        if (getJogador() instanceof JogadorGyokushou) {
            getListImageIcon().add(new ImageIcon("src/ImagensInvertidas/Peão.png"));
            getListImageIcon().add(new ImageIcon("src/ImagensInvertidas/Peão_P.png"));
        } else if (getJogador() instanceof JogadorGyokushou) {
            getListImageIcon().add(new ImageIcon("src/Images/Peão.png"));
            getListImageIcon().add(new ImageIcon("src/Images/Peão_P.png"));
        }
    }   

}
