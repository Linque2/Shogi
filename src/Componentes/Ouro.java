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
    public Ouro(int x, int y, JogadorOushou jogador, Simbolo[] simbolos, char simbolo, Valor[] valores, int valor, boolean capturada, Tabuleiro tabuleiro) {
        super(x, y, jogador, SimboloConj.OURO.getSimboloConj(), Simbolo.OURO.getSimbolo(), ValorConj.OURO.getValorConj(),Valor.OURO.getValor(), capturada, false, "Images/Ouro.png", "Images/Ouro.png", tabuleiro);
    }

    public Ouro(int x, int y, JogadorGyokushou jogador, Simbolo[] simbolos, char simbolo, Valor[] valores, int valor, boolean capturada, Tabuleiro tabuleiro) {
        super(x, y, jogador, SimboloConj.OURO.getSimboloConj(), Simbolo.OURO.getSimbolo(), ValorConj.OURO.getValorConj(),Valor.OURO.getValor(), capturada, false, "ImagensInvertidas/Ouro.png", "ImagensInvertidas/Ouro_P.png", tabuleiro);
    }

    // métodos de get e set

    //demais métodos

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

        ArrayList<Coordenada> movimentos = new ArrayList<Coordenada>();
        
        if (getJogador() instanceof JogadorOushou) {
            movimentos = Movimento.OURO.getMovimentos();
        } else if (getJogador() instanceof JogadorGyokushou) {
            movimentos = Movimento.GyokuOURO.getMovimentos();
        }
        
        for (Coordenada coordenada : movimentos) {
            Coordenada posiçãoFinal = Coordenada.transladarCoordenada(getCoordenada(), coordenada);
            if (getTabuleiro().estaNoTabuleiro(posiçãoFinal))
                if (!(getTabuleiro().getGrid()[posiçãoFinal.getC_x()][posiçãoFinal.getC_y()] != null && getTabuleiro().getGrid()[posiçãoFinal.getC_x()][posiçãoFinal.getC_y()].getJogador().equals(getJogador())))
                    jogadasPossíveis.add(Coordenada.transladarCoordenada(getCoordenada(), coordenada));
        }

        return jogadasPossíveis;
    }

    public void atualizarImagem() {
        getListImageIcon().clear();
        if (getJogador() instanceof JogadorGyokushou) {
            getListImageIcon().add(new ImageIcon("src/ImagensInvertidas/Ouro.png"));
        } else if (getJogador() instanceof JogadorGyokushou) {
            getListImageIcon().add(new ImageIcon("src/Images/Ouro.png"));
        }
    } 
}
