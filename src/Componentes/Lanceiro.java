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
    public Lanceiro(int x, int y, Jogador jogador, Simbolo[] simbolos, char simbolo,Valor[] valores, int valor, boolean capturada, Tabuleiro tabuleiro) {
        super(x, y, jogador, SimboloConj.LANCEIRO.getSimboloConj(), Simbolo.LANCEIRO_N.getSimbolo(), ValorConj.LANCEIRO.getValorConj(), Valor.LANCEIRO_N.getValor(), capturada, false, "src/Images/Lanceiro.png", "src/Images/Lanceiro_P.png", tabuleiro);
        if (jogador instanceof JogadorGyokushou) {
            getListImageIcon().remove(0);
            getListImageIcon().remove(1);
            ImageIcon image1 = new ImageIcon("src/ImagensInvertidas/Lanceiro.png");
            ImageIcon image2 = new ImageIcon("src/ImagensInvertidas/Lanceiro_P.png");
            getListImageIcon().add(image1);
            getListImageIcon().add(image2);
        }
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
