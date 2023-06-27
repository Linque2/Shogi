/**
 * Criado por Rafael Masato Haga Costa em 22/06/2023
 */

package Componentes;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Cavalo extends Peça{

    public Cavalo(int x, int y, JogadorOushou jogador, Simbolo[] simbolos, char simbolo, Valor[] valores, int valor, boolean capturada, Tabuleiro tabuleiro) {
            super(x, y, jogador, SimboloConj.CAVALO.getSimboloConj(), Simbolo.CAVALO_N.getSimbolo(), ValorConj.CAVALO.getValorConj() ,Valor.CAVALO_N.getValor(), capturada, false, "Images/Cavalo.png", "Images/Cavalo_P.png", tabuleiro);
    }

    public Cavalo(int x, int y, JogadorGyokushou jogador, Simbolo[] simbolos, char simbolo, Valor[] valores, int valor, boolean capturada, Tabuleiro tabuleiro) {
            super(x, y, jogador, SimboloConj.CAVALO.getSimboloConj(), Simbolo.CAVALO_N.getSimbolo(), ValorConj.CAVALO.getValorConj() ,Valor.CAVALO_N.getValor(), capturada, false, "ImagensInvertidas/Cavalo.png", "ImagensInvertidas/Cavalo_P.png", tabuleiro);
    }

    //métodos de get e set

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
            movimentos = Movimento.CAVALO_N.getMovimentos();
            movimentos_P = Movimento.CAVALO_P.getMovimentos();
        } else if (getJogador() instanceof JogadorGyokushou) {
            movimentos = Movimento.GyokuCAVALO_N.getMovimentos();
            movimentos_P = Movimento.GyokuCAVALO_P.getMovimentos();
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
                System.out.println(jogadasPossíveis);
                return jogadasPossíveis;
        }
        return null;
    }

    public void atualizarImagem() {
        getListImageIcon().clear();
        if (getJogador() instanceof JogadorGyokushou) {
            getListImageIcon().add(new ImageIcon("src/ImagensInvertidas/Cavalo.png"));
            getListImageIcon().add(new ImageIcon("src/ImagensInvertidas/Cavalo_P.png"));
        } else if (getJogador() instanceof JogadorGyokushou) {
            getListImageIcon().add(new ImageIcon("src/Images/Cavalo.png"));
            getListImageIcon().add(new ImageIcon("src/Images/Cavalo_P.png"));
        }
    } 

    public String toString(){
        return "Coordenadas: " + getCoordenada().toString() + "Jogador: " + getJogador() + "Símbolo: " + getSimbolo() + "Tabuleiro: " + getTabuleiro() + "Classe: " + getClass();
    }
}
