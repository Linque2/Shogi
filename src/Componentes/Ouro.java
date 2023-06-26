/**
 * Criado por Rafael Masato Haga Costa em 22/06/2023
 */
package Componentes;

import java.util.*;

import javax.swing.ImageIcon;
public class Ouro extends Peça {

     /**
     * Construtor da classe Ouro que herda de "Peça"
     * @param coordenada Coordenadas da casa onde a peça está no momento
     * @param jogador Parâmetro que o construtor recebe como o jogador com que a peça está no momento
     * @param simbolo Kanji representativo do ouro
     * @param valor Valor do ouro segundo as regras do jogo
     * @param capturada "true" se a peça foi capturada e está no banco de peças,
     * "false" se a peça não foi capturada e está em jogo
     */
    public Ouro(int x, int y, Jogador jogador, Simbolo[] simbolos, char simbolo, Valor[] valores, int valor, boolean capturada, Tabuleiro tabuleiro) {
        super(x, y, jogador, SimboloConj.OURO.getSimboloConj(), Simbolo.OURO.getSimbolo(), ValorConj.OURO.getValorConj(),Valor.OURO.getValor(), capturada, false, "src/Images/Ouro.png", "src/Images/Ouro.png", tabuleiro);
        if (jogador instanceof JogadorGyokushou) {
            getListImageIcon().remove(0);
            getListImageIcon().remove(1);
            ImageIcon image1 = new ImageIcon("src/ImagensInvertidas/Ouro.png");
            ImageIcon image2 = new ImageIcon("src/ImagensInvertidas/Ouro_P.png");
            getListImageIcon().add(image1);
            getListImageIcon().add(image2);
        }
    }

    // métodos de get e set

    /**
     * Calcula um vetor subtraindo Pi de Pf
     * Em seguida verifica se ele está na lista de movimentos possíveis da peça, registradas no enum MovimentoConj(index)
     * @return "true" caso a jogada seja possível, e translada a posição da peça para a nova posição
     * @return "false" caso a jogada seja impossível
     */
   /*  public boolean andarPara(Coordenada Pi, Coordenada Pf, Tabuleiro tabuleiro) {
        Coordenada vetor = Coordenada.calculaVetor(Pi, Pf);
        if (vetor.estaNaLista(Movimento.OURO.getMovimentos())) {
            setCoordenada(Coordenada.transladarCoordenada(getCoordenada(), vetor));
            return true;
        } else
            return false;
    } */

    @Override
    /**
     * @return O método retorna sempre "false", pois o ouro não possui promoção
     */
    public boolean promoverPeça() {
        return false;
    }

    @Override
    /**
     * @return O método retorna sempre "false", pois como o ouro não pode ser promovido, ele também não pode ser despromovido
     */
    public boolean despromoverPeça() {
        return false;
    }

    public ArrayList<Coordenada> podeAndar() {
        ArrayList<Coordenada> jogadasPossíveis = new ArrayList<Coordenada>();
        for (Coordenada coordenada : Movimento.OURO.getMovimentos()) {
            Coordenada posiçãoFinal = Coordenada.transladarCoordenada(getCoordenada(), coordenada);
            if (getTabuleiro().estaNoTabuleiro(posiçãoFinal))
                if (!(getTabuleiro().getGrid()[posiçãoFinal.getC_x()][posiçãoFinal.getC_y()] != null && getTabuleiro().getGrid()[posiçãoFinal.getC_x()][posiçãoFinal.getC_y()].getJogador().equals(getJogador())))
                    jogadasPossíveis.add(Coordenada.transladarCoordenada(getCoordenada(), coordenada));
        }

        return jogadasPossíveis;
    }

    /**
     * Função para testes
     * @param args
     */
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro(null, null);
        Ouro ouro = new Ouro(5, 5, null, SimboloConj.OURO.getSimboloConj(), Simbolo.OURO.getSimbolo(), ValorConj.OURO.getValorConj(), Valor.OURO.getValor(), false, tabuleiro);
        System.out.print(ouro.podeAndar());
    }
}
