/**
 * Criado por Rafael Masato Haga Costa em 22/06/2023
 */

package Componentes;

import java.util.ArrayList;

import javax.swing.ImageIcon;

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
    public Lanceiro(int x, int y, JogadorOushou jogador, Simbolo[] simbolos, char simbolo,Valor[] valores, int valor, boolean capturada, Tabuleiro tabuleiro) {
        super(x, y, jogador, SimboloConj.LANCEIRO.getSimboloConj(), Simbolo.LANCEIRO_N.getSimbolo(), ValorConj.LANCEIRO.getValorConj(), Valor.LANCEIRO_N.getValor(), capturada, false, "Images/Lanceiro.png", "Images/Lanceiro_P.png", tabuleiro);
    }

    public Lanceiro(int x, int y, JogadorGyokushou jogador, Simbolo[] simbolos, char simbolo,Valor[] valores, int valor, boolean capturada, Tabuleiro tabuleiro) {
        super(x, y, jogador, SimboloConj.LANCEIRO.getSimboloConj(), Simbolo.LANCEIRO_N.getSimbolo(), ValorConj.LANCEIRO.getValorConj(), Valor.LANCEIRO_N.getValor(), capturada, false, "ImagensInvertidas/Lanceiro.png", "ImagensInvertidas/Lanceiro_P.png", tabuleiro);
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
        ArrayList<Coordenada> movimentos = new ArrayList<Coordenada>();
        ArrayList<Coordenada> movimentos_P = new ArrayList<Coordenada>();
        
        if (getJogador() instanceof JogadorOushou) {
            movimentos = Movimento.LANCEIRO_N.getMovimentos();
            movimentos_P = Movimento.LANCEIRO_P.getMovimentos();
        } else if (getJogador() instanceof JogadorGyokushou) {
            movimentos = Movimento.GyokuLANCEIRO_N.getMovimentos();
            movimentos_P = Movimento.GyokuLANCEIRO_P.getMovimentos();
        }

        Peça peçaBloq;
        Coordenada Pf = getCoordenada();
        int estaPromovida;
        if (getPromovida() == true)
            estaPromovida = 1;
        else
            estaPromovida = 0;

        switch(estaPromovida){
            case 0: 
                for (Coordenada coordenada : movimentos) {
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

    public void atualizarImagem() {
        getListImageIcon().clear();
        if (getJogador() instanceof JogadorGyokushou) {
            getListImageIcon().add(new ImageIcon("src/ImagensInvertidas/Lanceiro.png"));
            getListImageIcon().add(new ImageIcon("src/ImagensInvertidas/Lanceiro_P.png"));
        } else if (getJogador() instanceof JogadorOushou) {
            getListImageIcon().add(new ImageIcon("src/Images/Lanceiro.png"));
            getListImageIcon().add(new ImageIcon("src/Images/Lanceiro_P.png"));
        }
    } 
}
